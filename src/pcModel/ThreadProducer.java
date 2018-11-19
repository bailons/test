package pcModel;

/**
 * @ClassName ThreadProducer
 * @Description TODO
 * @Author leibailong
 * @Date 2018/10/31 15:14
 * @Version 1.0
 **/
public class ThreadProducer extends Thread {
    private Producer producer;

    public ThreadProducer(Producer producer){
        super();
        this.producer = producer;
    }
    @Override
    public void run(){
        while (true){
            producer.setValue();
        }
    }
}
