package train;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 **/
public class LotteryTest {

    public static void main(String[] args) {
        randomName();
    }

    public static void randomName() {

        int m = 1;
        int n = 4;
        List<String> nameList = new LinkedList<>();
        nameList.add("张三");
        nameList.add("李四");
        nameList.add("王五");
        nameList.add("赵六");

        //生成从m到n的随机整数[m,n]
        if (nameList.size() > 0) {
            int temp = m + (int) (Math.random() * (n + 1 - m));
            int index = temp - 1;
            System.out.println("中奖号:" + temp + "\t姓名:" + nameList.get(index));
            nameList.remove(index);
        } else {
            System.out.println("抽奖结束");
        }
    }
}
