package syn;

/**
 * @ClassName Service
 * @Description TODO
 * @Author leibailong
 * @Date 2018/10/30 0030 20:07
 * @Version 1.0
 **/
public class Service {
    private boolean isContinueRun = true;
    public void runMethod(){
        while(isContinueRun == true){
        }
        System.out.println("停下来了！");
    }
    public void stopMethod(){
        isContinueRun = false;
        System.out.println(isContinueRun);
    }
}
