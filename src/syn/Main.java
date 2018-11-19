package syn;

/**
 * @ClassName Main
 * @Description TODO
 * @Author leibailong
 * @Date 2018/10/30 0030 20:06
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.start();
        Thread.sleep(1000);
        ThreadB b = new ThreadB(service);
        b.start();
        System.out.println("已经发起停止的命令了！");
    }
}
