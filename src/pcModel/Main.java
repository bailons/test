package pcModel;

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
        ThreadProducer tp = new ThreadProducer(producer);
        ThreadCustomer tc = new ThreadCustomer(consumer);
        tp.start();
        tc.start();
    }
}
