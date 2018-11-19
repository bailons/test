package singleton;

/**
 * @ClassName Threads
 * @Description TODO
 * @Author leibailong
 * @Date 2018/11/1 0001 14:23
 * @Version 1.0
 **/
public class Threads implements Runnable{
    @Override
    public void run() {
        System.out.println(MyObject.getMyObjectInstance().hashCode());
    }
}
