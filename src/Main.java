import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception{
        /*String str1 = "abc";
        String str2 = "abc";
        String str3 = "a";
        String str4 = "bc";
        String str5 = str3 + str4;
        String str6 = new String(str1);

        print("------no intern------");
        printnb("str1 == str2 ? ");
        print( str1 == str2);//true
        printnb("str1 == str5 ? ");
        print(str1 == str5);//true
        printnb("str1 == str6 ? ");
        print(str1 == str6);//false

        print("------intern------");
        printnb("str1.intern() == str2.intern() ? ");
        print(str1.intern() == str2.intern());
        printnb("str1.intern() == str5.intern() ? ");
        print(str1.intern() == str5.intern());
        printnb("str1.intern() == str6.intern() ? ");
        print(str1.intern() == str6.intern());
        printnb("str1 == str6.intern() ? ");
        print(str1 == str6.intern());*/

        //System.out.println("<?xml version=\"1.0\" encoding=\"GB2312\"?><data><TransCode>ZJW001</TransCode><fSeqno>0022019100817505383850699</fSeqno><ChnnelPswd>684ec6598a025b471c29958e5a28c3ba334172166ee85d95b45b7fa13b66bea2</ChnnelPswd><RetCode>00000</RetCode><RetMsg>成功</RetMsg><AcctNo>817702601421000085</AcctNo><AcctName>威海银行农民工代发工资</AcctName><AccStat>0</AccStat><Balance>2000000</Balance><UseBalance>1000000</UseBalance><AccType>工程款账户</AccType></data>".getBytes("GBK").length);


        /*System.out.println(new SimpleDateFormat("yyyy-MM").format(new Date())+"%");*/
        //setScale(2, BigDecimal.ROUND_HALF_UP)

        /*BigDecimal b = new BigDecimal("123131");
        BigDecimal number1 = b.multiply(new BigDecimal("0.3"));

        BigDecimal warningValue = number1.divide(new BigDecimal(13),4);
        System.out.println(warningValue);
*/
        /*String errorinfo = String.format("账户自动设置预警余额失败,项目%s",111111);
        System.out.println(errorinfo);*/

        /*int a = 5,b=100;
        System.out.println(new BigDecimal((float) a / b).setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));*/

        /*String nowMonth = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println(nowMonth);*/

        /*String a = "E:/vue/asdddf/02-Vue高级实战-移动端音乐WebApp";
        String b = "E:/vue";
        String c = a.substring(a.indexOf(b)+b.length(),a.length());
        System.out.println(c);*/

        int a = 5;
        int b =10;

        BigDecimal up = new BigDecimal(Integer.toString(5));
        BigDecimal down = new BigDecimal(Integer.toString(10));
        System.out.println(up.divide(down,2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue());

    }

    public static void print(Object obj){
        System.out.println(obj);
    }
    public static void printnb(String str){
        System.out.print(str);
    }
    public static int add(int x, int y) {
        return x + y;
    }
    //此时方法名称相同，参数的个数不同
    public static int add(int x, int y, int z) {
        return x + y + z;
    }
    public static double add(double x, double y) {
        return x + y;
    }
}
