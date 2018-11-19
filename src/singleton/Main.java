package singleton;

/**
 * @ClassName Main
 * @Description TODO
 * @Author leibailong
 * @Date 2018/11/1 0001 14:26
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Threads s = new Threads();
        Thread a = new Thread(s);
        Thread b = new Thread(s);
        Thread c = new Thread(s);
        a.start();
        b.start();
        c.start();
    }
}
