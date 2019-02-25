package train;

import java.sql.SQLOutput;

/**
 * @Description 一般而言，兔子在出生两个月后，就有繁殖能力，
 * 一对兔子每个月能生出一对小兔子来。
 * 如果所有的兔子都不死，
 * 那么一年以后可以繁殖多少对兔子？
 * 我们不妨拿新出生的一对小兔子分析一下：
 * 第一个月小兔子没有繁殖能力，所以还是一对；
 * 两个月后，生下一对小兔总数共有两对；
 * 三个月以后，老兔子又生下一对，因为小兔子还没有繁殖能力，所以一共是三对；
 * 经过月数 0 1 2 3 4 5 6 7  8  9  10 11 12
 * 总体对数 0 1 1 2 3 5 8 13 21 34 55 89 144
 **/
public class FibonacciSequence {

    public static void main(String[] args) {
        /*for(int i=0;i<=12;i++){
            System.out.println("月份"+i+"\t"+"对数"+testFib1(i));
        }*/
        testFib3();
    }

    public static int testFib1(int n) {
        //从第3个月开始,f(n) = f(n-1)+f(n-2)
        if (n == 1 || n == 2) {
            return 1;
        } else if(n==0) {
            return 0;
        }else{
            return testFib1(n - 1) + testFib1(n - 2);
        }
    }

    public static void testFib2() {
        //从第3个月开始,f(n) = f(n-1)+f(n-2)
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=0;i<10;i++){
            if(i>1){
                arr[i] = arr[i-2]+arr[i-1];
            }
            System.out.print(arr[i]+"\t");
        }
    }

    public static void testFib3() {
        //从第3个月开始,f(n) = f(n-1)+f(n-2)
        int a = 1;
        int b = 1;
        for(int i = 1;i <= 5;i++) {
            //循环打印a,b两个数，即两个两个打印
            System.out.print(a + "\t" + b + "\t");
            //打印第三、四个数
            a = a + b;
            b = a + b;
        }
    }
}
