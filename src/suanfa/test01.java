package suanfa;

/**
 * 求s=a+aa+aaa+aaaa+aa...a的值，
 * 其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
 **/
public class test01 {
    public static void main(String[] args) {
        int x = 8;
        int num = 9;
        int t = 0;
        int y=0;
        for (int i = 0; i < num; i++) {
            y=y*10+x;
            t+=y;
        }
        System.out.println(t);
        f2();
    }
    public static void f2(){
        int a=8;
        int n=9;
        int sum=0,b=0;
        for(int i=0;i<n;i++) {
            b+=a;
            sum+=b;
            a=a*10;
        }
        System.out.println(sum);
    }
}


