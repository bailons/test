package testZkLock;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {

    public static void main(String[] args) throws Exception{
        /*for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");

                String orderNo = sdf.format(new Date());

                System.err.println("生成的订单号是：" + orderNo);
            }).start();
        }*/
        long requestStartTime = System.currentTimeMillis();
        Thread.sleep(1000);
        System.out.println("本次请求共用=====>" + ((System.currentTimeMillis() - requestStartTime)/ 1000 % 60) + " 秒");
    }
}
