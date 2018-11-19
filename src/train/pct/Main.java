package train.pct;

/**
 * @ClassName Main
 * @Description TODO
 * @Author leibailong
 * @Date 2018/11/1 0001 15:14
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException{
        String lock = new String();
        Cake cake = new Cake();
        Producer p = new Producer(cake,lock);
        Customer c = new Customer(cake,lock);
        Runnable pr = new Runnable() {
            @Override
            public void run() {
                p.producer();
            }
        };

        Runnable cr = new Runnable() {
            @Override
            public void run() {
                c.customer();
            }
        };

        Thread[] pt = new Thread[3];
        Thread[] ct = new Thread[3];
        for (int i = 0; i < 3; i++) {
            pt[i] = new Thread(pr);
            pt[i].setName("生产者" + i);
            ct[i] = new Thread(cr);
            ct[i].setName("消费者" + i);
        }

        for (int i = 0; i < 3; i++) {
            pt[i].start();
            ct[i].start();
        }
        Thread.sleep(1000);
        System.out.println("最后还剩"+cake.getCakeNum()+"个蛋糕");
    }
}
