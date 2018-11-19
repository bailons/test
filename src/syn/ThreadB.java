package syn;

/**
 * @ClassName ThreadB
 * @Description TODO
 * @Author leibailong
 * @Date 2018/10/30 0030 20:12
 * @Version 1.0
 **/
public class ThreadB extends Thread {
    private Service service;
    public ThreadB(Service service){
        super();
        this.service = service;
    }
    @Override
    public void run(){
        service.stopMethod();
    }
}
