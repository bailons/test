package singleton;

/**
 * @ClassName MyObject
 * @Description TODO
 * @Author leibailong
 * @Date 2018/11/1 0001 14:16
 * @Version 1.0
 **/
public class MyObject {
    /**
     *INSTANCE  = new SingleTon();
     * 这个步骤，其实在jvm里面的执行分为三步：
     * 1.在堆内存开辟内存空间
     * 2.在堆内存中实例化SingleTon里面的各个参数
     * 3.把对象指向堆内存空间
     * 由于jvm存在乱序执行功能，所以可能在2还没执行时就先执行了3，如果此时再被切换到线程B上，由于执行了3，INSTANCE 已经非空了，会被直接拿出来用，这样的话，就会出现异常。这个就是著名的DCL失效问题。
     *不过在JDK1.5之后，官方也发现了这个问题，故而具体化了volatile，即在JDK1.6及以后，只要定义为private volatile static SingleTon  INSTANCE = null;就可解决DCL失效问题。volatile确保INSTANCE每次均在主内存中读取，这样虽然会牺牲一点效率，但也无伤大雅。
     **/
    private volatile static MyObject myObject=null;
    private MyObject(){}
    public static MyObject getMyObjectInstance(){
        if(myObject == null){
            synchronized (MyObject.class){
                if(myObject == null){
                    myObject = new MyObject();
                }
            }
        }
        return myObject;
    }
}
