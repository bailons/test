package exception;

import list2map.Person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {


    public static void main(String[] args) {

        /*try {
            js();
        } catch (Exception e) {
            System.out.println("0000000===e.getMessage()>"+e.getMessage());
            System.out.println("0000000===e.printStackTrace()>");
            e.printStackTrace();
        }*/

        //System.out.println(dealData("1111dd2222"));
        /*BigDecimal decimal = new BigDecimal("1.12345");
        System.out.println(decimal);
        BigDecimal setScale = decimal.setScale(2);*/
        /*String str = "<p><p>sdafasd</p>fasdf</p>";
        String clearPrefixStr = str.trim().substring(3);
        System.out.println(clearPrefixStr.substring(0,clearPrefixStr.lastIndexOf("</p>")));*/

        /*String aa = "http://dfajlsfjlasd:8080/ann/add/dfew";
        String bb = "/ann/add";
        System.out.println(aa.contains(bb));*/

        /*String text = "d:/test/dubbo.properties";
        String c = "abbbbbcc";
        System.out.println(text.substring(text.lastIndexOf("/")+1,text.length()));*/

        /*Byte del_flag = 1;
        System.out.println(del_flag);*/

        //printStr(SysRelationsTypeEnum.tailbox);

        //System.out.println(EqpDeviceTypeEnum.TAILBOX.getCode());
        /*Integer a = new Integer(1231);
        System.out.println(a.toString());*/
        List<String> old = new LinkedList<>();
        old.add("aaaa");
        old.add("bbbb");
        old.add("cccc");

        List<String> news = new LinkedList<>();
        news.add("aaaa");
        news.add("dddd");
        news.add("eeee");
        news.add("ffff");

        old.removeAll(news);
        old.forEach(o-> System.out.println(o));

       /* String aaa= "asdfasdf21231,1231dsadwasdf";
        String[] aad = aaa.split(",");*/

        /*Person person1 = new Person();
        person1.setId("111");
        person1.setName(null);
        person1.setAge(0);

        Person person2 = new Person();
        person2.setId("222");
        person2.setName(person1.getName());
        person2.setAge(0);

        System.out.println(person2.toString());
*/

        /*Byte a = 123;
        String b = "123";
        System.out.println(a.toString().equals(b));*/


    }
    public static void printStr(SysRelationsTypeEnum sysRelationsTypeEnum){
        System.out.println(sysRelationsTypeEnum.toString());

    }

    public static String dealData(String cardNo){
        String regex = "(\\w{4})(.*)(\\w{4})";
        Matcher m = Pattern.compile(regex).matcher(cardNo);
        if (m.find()) {
            String rep = m.group(2);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rep.length(); i++) {
                sb.append("*");
            }
            return cardNo.replaceAll(rep, sb.toString());
        }
        return null;
    }

    private static void js() throws Exception{


        try {
            jsDetail();
        } catch (Exception e) {
            System.out.println("1111111===e.getMessage()>"+e.getMessage());
            System.out.println("1111111===e.printStackTrace()>");
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }


    }



    private static void  jsDetail() throws Exception{
        try {
            int i = 1 / 0;
        }catch (RuntimeException e){
            System.out.println("2222222===e.getMessage()>"+e.getMessage());
            System.out.println("2222222===e.printStackTrace()>");
            e.printStackTrace();
            throw new RuntimeException("底层计算出错,请检查!");
        }

    }



}
