package singleton;

/**
 * @ClassName MyObject
 * @Description TODO
 * @Author leibailong
 * @Date 2018/11/1 0001 14:16
 * @Version 1.0
 **/
public class MyObject {
    private static MyObject myObject;
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
