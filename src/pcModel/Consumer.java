package pcModel;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author leibailong
 * @Date 2018/10/31 0031 15:10
 * @Version 1.0
 **/
public class Consumer {
    private String lock;
    private PCData pcdata;
    public Consumer(String lock,PCData pcdata){
        super();
        this.lock = lock;
        this.pcdata = pcdata;
    }
    public void getValue(){
        try {
            synchronized (lock){
                if(null == pcdata.getData()){
                    lock.wait();
                }
                String value = pcdata.getData();
                System.out.println("消费了Data的值="+value);
                pcdata.setPCData(null);
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
