package lock;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {

    public static void main(String[] args) throws Exception {
        long requestStartTime = System.currentTimeMillis();
        test2();
        System.out.println(String.format("本次请求共用%s秒", (System.currentTimeMillis() - requestStartTime) / 1000 % 60));
    }

    public static void test2() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.err.println("生成的订单号是：" + DateUtil.formatDate(new Date()));
            }).start();
        }
    }

    public static void test1() {
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.err.println("生成的订单号是：" + sdf.format(new Date()));
            }).start();
        }
    }
}
