package lock;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static ThreadLocal<SimpleDateFormat> format1 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss|SSS");
        }
    };

    public static String formatDate(Date date) {
        return format1.get().format(date);
    }
}
