package syn;

/**
 * @ClassName ThreadA
 * @Description TODO
 * @Author leibailong
 * @Date 2018/10/30 0030 20:10
 * @Version 1.0
 **/
public class ThreadA extends Thread {
    private Service service;
    public ThreadA(Service service){
        super();
        this.service = service;
    }
    @Override
    public void run(){
        service.runMethod();
    }
}
