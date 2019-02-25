package train;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Red {
    public static void main(String[] args) {
    }

    //随机生成不重复数字
    public static void buchongfu(){
        int [] arr = new int[100];
        for(int i=0 ;i<100 ;i++) {
            arr[i] = i+1;
        }

        for(int i = 0 ;i<100 ;i++) {
            int num = new Random().nextInt(100);
            int temp = arr[num];
            arr[num] = arr[i];
            arr[i] = temp;
            System.out.println(arr[i]);
        }
    }

    public static void suanfa02(double moneySum, int redNum) {
        // 设置最小的金额
        double moneyMin = 0.01;
        Random random = new Random();
        //精确小数点2位
        NumberFormat formatter = new DecimalFormat("#.##");
        for (int i = 1; i < redNum; i++) {
            //随机一个数，数值范围在最小值与余额之间
            String money = formatter.format(random.nextDouble() * (moneySum - moneyMin) + moneyMin);
            //数值转换
            moneySum = Double.valueOf(formatter.format(moneySum - Double.valueOf(money)));

            System.out.println("第" + i + "个红包：" + money + "元 ,余额：" + moneySum);
        }
        System.out.println("最后个红包：" + moneySum + "元 ,余额：" + (moneySum - moneySum));
    }

    public static double [] getMoney(double money, int num){
        Random r = new Random();
        DecimalFormat format = new DecimalFormat(".##");

        double middle = Double.parseDouble(format.format(money/num));
        double [] dou = new double[num];
        double redMoney = 0;
        double nextMoney = money;
        double sum = 0;
        int index = 0;
        for(int i=num;i>0;i--){
            if(i == 1){
                dou[index] = nextMoney;
                System.out.println("第"+i+"个人抢到红包"+nextMoney+"元");
            }else{
                while(true){
                    String str = format.format(r.nextDouble()*nextMoney);
                    redMoney = Double.parseDouble(str);
                    if(redMoney>0 && redMoney < middle){
                        break;
                    }
                }
                nextMoney = Double.parseDouble(format.format(nextMoney - redMoney));
                sum = sum + redMoney;
                dou[index] = redMoney;
                middle = Double.parseDouble(format.format(nextMoney/(i-1)));
                index++;
                System.out.println("第"+i+"个人抢到红包"+redMoney+"元");
            }
        }
        System.out.println("累计金额："+sum+"元");
        return dou;
    }

    public static void suanfa01() {
        //红包数
        int number = 10;
        //红包总额
        float total = 10;
        float money;
        //最小红包
        double min = 1;
        double max;
        int i = 1;
        List math = new ArrayList();
        DecimalFormat df = new DecimalFormat("###.##");
        while (i < number) {
            //保证即使一个红包是最大的了,后面剩下的红包,每个红包也不会小于最小值
            max = total - min * (number - i);
            int k = (number - i) / 2;
            //保证最后两个人拿的红包不超出剩余红包
            if (number - i <= 2) {
                k = number - i;
            }
            //最大的红包限定的平均线上下
            max = max / k;
            //保证每个红包大于最小值,又不会大于最大值
            money = (int) (min * 100 + Math.random() * (max * 100 - min * 100 + 1));
            money = money / 100;
            //保留两位小数
            money = Float.parseFloat(df.format(money));
            total = (int) (total * 100 - money * 100);
            total = total / 100;
            math.add(money);
            System.out.println("第" + i + "个人拿到" + money + ";剩下" + total);
            i++;
            //最后一个人拿走剩下的红包
            if (i == number) {
                math.add(total);
                System.out.println("第" + i + "个人拿到" + total + "剩下0");
            }
        }
        //取数组中最大的一个值的索引
        System.out.println("本轮发红包中第" + (math.indexOf(Collections.max(math)) + 1) + "个人手气最佳");
    }

}
