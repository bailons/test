package train.lock;

/**
 * @ClassName BuyThread
 * @Description TODO
 * @Author leibailong
 * @Date 2018/11/1 0001 17:10
 * @Version 1.0
 **/
public class BuyThread extends Thread {
    private Buy buy;
    public BuyThread(Buy buy){
        this.buy = buy;
    }
    @Override
    public void run(){
        buy.buy();
    }
}
