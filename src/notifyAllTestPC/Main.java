package notifyAllTestPC;

/**
 * @ClassName Main
 * @Description 生产者消费者模型
 * @Author leibailong
 * @Date 2018/10/30 0030 20:06
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        PCData pcData = new PCData(null);
        String lock = new String();
        Producer producer = new Producer(lock,pcData);
        Consumer consumer = new Consumer(lock,pcData);
        ThreadProducer[] tps = new ThreadProducer[2];
        ThreadCustomer[] tcs = new ThreadCustomer[2];
        for (int i=0;i<2;i++){
            tps[i] = new ThreadProducer(producer);
            tps[i].setName("生产者"+i);
            tcs[i] = new ThreadCustomer(consumer);
            tcs[i].setName("消费者"+i);
            tps[i].start();
            tcs[i].start();
        }
    }
}
