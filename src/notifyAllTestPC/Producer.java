package notifyAllTestPC;

/**
 * @ClassName Producer
 * @Description TODO
 * @Author leibailong
 * @Date 2018/10/31 0031 14:57
 * @Version 1.0
 **/
public class Producer {
    private String lock;
    private PCData pcdata;

    public Producer(String lock, PCData pcdata) {
        super();
        this.lock = lock;
        this.pcdata = pcdata;
    }
    public void setValue() {
        try {
            synchronized (lock) {
                while(null != pcdata.getData()) {
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println(Thread.currentThread().getName()+" 生产了Data的值=" + value);
                pcdata.setPCData(value);
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
