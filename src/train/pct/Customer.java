package train.pct;

/**
 * @ClassName Customer
 * @Description TODO
 * @Author leibailong
 * @Date 2018/11/1 0001 15:15
 * @Version 1.0
 **/
public class Customer {
    private Cake cake;
    private String lock;

    public Customer(Cake cake,String lock) {
        this.cake = cake;
        this.lock = lock;
    }

    public void customer(){
        try {
            synchronized(lock) {
                while (cake.getCakeNum()<1) {
                    lock.wait();
                }
                cake.customerCake();
                System.out.println(Thread.currentThread().getName() + " 消费了1个蛋糕");
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
