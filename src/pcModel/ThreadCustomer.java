package pcModel;

/**
 * @ClassName ThreadCustomer
 * @Description TODO
 * @Author leibailong
 * @Date 2018/10/31 0031 15:21
 * @Version 1.0
 **/
public class ThreadCustomer extends Thread {
    private Consumer consumer;
    public ThreadCustomer(Consumer consumer){
        super();
        this.consumer = consumer;
    }
    @Override
    public void run(){
        while (true){
            consumer.getValue();
        }
    }
}
