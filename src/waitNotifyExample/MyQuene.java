package waitNotifyExample;

import sun.util.locale.provider.TimeZoneNameUtility;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQuene {

    private LinkedList quene = new LinkedList<>();

    private AtomicInteger count = new AtomicInteger(0);

    private final int min = 0;

    private final int max;

    public MyQuene(int max) {
        this.max = max;
    }

    private final Object lock = new Object();


    public void put(Object o) {
        synchronized (lock) {
            while (count.get() == this.max) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            quene.add(o);
            System.out.println("新加入了元素======" + o);
            count.incrementAndGet();
            lock.notify();
        }
    }


    public Object take() {
        Object o = null;
        synchronized (lock) {
            while (count.get() == this.min) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            o = quene.removeFirst();
            count.decrementAndGet();
            lock.notify();
        }
        return o;
    }

    public int getSize() {
        return this.count.get();
    }

    public static void main(String[] args) {
        MyQuene myQuene = new MyQuene(5);
        myQuene.put("aaa");
        myQuene.put("bbb");
        myQuene.put("ccc");
        myQuene.put("ddd");
        myQuene.put("eee");
        System.out.println("当前容器的长度为:" + myQuene.getSize());

        Thread t1 = new Thread(() -> {
            myQuene.put("fff");
            myQuene.put("ggg");
        }, "t1");
        t1.start();

        Thread t2 = new Thread(()->{
            Object o1= myQuene.take();
            System.out.println("当前容器取出的元素为:" + o1);
            Object o2 = myQuene.take();
            System.out.println("当前容器取出的元素为:" + o2);
        },"t2");

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

    }
}
