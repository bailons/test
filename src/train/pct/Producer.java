package train.pct;

/**
 * @ClassName Producer
 * @Description TODO
 * @Author leibailong
 * @Date 2018/11/1 0001 15:15
 * @Version 1.0
 **/
public class Producer{
    private Cake cake;
    private String lock;
    public Producer(Cake cake,String lock){
        this.cake = cake;
        this.lock = lock;
    }
    public void producer(){
        try {
            synchronized(lock) {
                while (cake.getCakeNum()>0) {
                    lock.wait();
                }
                cake.setCakeNum(1);
                System.out.println(Thread.currentThread().getName() + " 生产了1个蛋糕");
                lock.notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
