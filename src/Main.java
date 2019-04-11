public class Main {
    public static void main(String[] args) {
        String str1 = "abc";
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
        print(str1 == str6.intern());
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
