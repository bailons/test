import com.sun.deploy.util.StringUtils;
import enums.AuthStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {

    private static final BigDecimal BigDecimal100 = new BigDecimal(100);
    public static void main(String[] args) {
       /* int a = 1;
        int b = 318;
        System.out.println(getValue(a,b));*/
       /*String a = "1111";
       String b = null;
       test(a,b);
*/

        /*Byte b = (byte)(0XFF & AuthStatusEnum.ISSUED.getCode());
        System.out.println(b);*/

        String a = "0123123123";

        /*List<String> strings = Arrays.asList(a);*/

        /*System.out.println(changeNumber(a));*/

        /*String lineTxt = "1221|12312|123123";

         lineTxt = lineTxt.replace("|", " | ");
         String[] lineArr = lineTxt.split("\\|");

        System.out.println(lineArr);*/


//        LocalDateTime now = LocalDateTime.now();
//        System.out.println((short) now.getYear());
//        System.out.println((byte) (now.getMonth().getValue()));
//        System.out.println((byte) now.getDayOfMonth());
//        System.out.println((byte) now.getHour());
//        System.out.println((byte) now.getMinute());
//        System.out.println((byte) now.getSecond());
        Test3 iCard = null;
        Test3 face =  new Test3();
        System.out.println(true && (iCard == null || face == null));

    }


    private static String changeNumber(String number){
        StringBuilder sb = new StringBuilder();
        if(number.matches("^0\\d*$")){
            number.replace(number.substring(0, 1),"1");
            return sb.append("1").append(number).toString();
        }else{
            return number;
        }
    }

    public static void test(String ...args){
        System.out.println(args[0]+"---"+args[1]);
    }

    private static double getValue(int number, int total) {
        BigDecimal up = new BigDecimal(Integer.toString(number));
        BigDecimal down = new BigDecimal(Integer.toString(total));
        if (down.compareTo(BigDecimal.ZERO) == 0) {
            return 0.0d;
        }
        return up.divide(down, 4, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal100).doubleValue();
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^-?[0-9]+");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
