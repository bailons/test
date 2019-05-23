import entity.Person;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestListContain {
    public static void main(String[] args) {

        List<String> all = new ArrayList<>();
        all.add("111");
        all.add("222");
        all.add("333");
        System.out.println(all.toString());
        List<Person> persons = new ArrayList<>();
        Person p1 = new Person();
        p1.setId("111");
        p1.setName("qweqwe");
        p1.setAge(0);
        Person p2 = new Person();
        p2.setId("222");
        p2.setName("qwewqe");
        p2.setAge(0);
        Person p3 = new Person();
        p3.setId("333");
        p3.setName("qweqweq");
        p3.setAge(0);
        Person p4 = new Person();
        p4.setId("444");
        p4.setName("qwewqeqwe");
        p4.setAge(0);
        Person p5 = new Person();
        p5.setId("555");
        p5.setName("qweqwewqeqw");
        p5.setAge(0);
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        /*List<Person> person2 = new ArrayList<>();
        persons.forEach(
                p->{
                    if(all.contains(p.getId())){
                        person2.add(p);
                    }
                }
        );
        person2.forEach(p-> System.out.println(p.toString()));*/
        Map<String, Person> personMap = persons.stream().collect(Collectors.toMap(Person::getId, Person -> Person));
        persons = null;
        /*for (Map.Entry<String, Person> entry : personMap.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= "
                    + entry.getValue().getName());
        }*/

        /*BigDecimal b1 = new BigDecimal("0");
        BigDecimal b2 = new BigDecimal("2004");
        System.out.println(b1.add(b2));
        System.out.println(b1.add(b2));*/


        /*LocalDate now = LocalDate.now();
        System.out.println(LocalDate.now().toString().replaceAll("-","").substring(2));*/

        String str = "Z19040410001";
        String a;
        /*a=new Integer(str.substring(1))+1+"";
        System.out.println(a);*/
        /*String substring = str.substring(0, 7);
        System.out.println((new Integer(str.substring(7))+1));*/


        /*List<Integer> i = new ArrayList<>();

        i.add(2);
        i.add(9);
        i.add(18);
        System.out.println(Collections.max(i));*/



        /*String str2 = "0                              <?xml version=\"1.0\" encoding=\"GB2312\"?><data><TransCode>ZJW004</TransCode><TranDate>20190425</TranDate><TranTime>140409</TranTime><fSeqno>0022019042514040915830326</fSeqno><Channel>002</Channel><ChnnelPswd>HgOTGbP+hdqvUUBNfftlwdyBxDoHvbEhMYXCMXjhkmU=</<ChnnelPswd>><TellNo>TellNo</TellNo><Flag>cx</Flag><AcctNo>123456123123</AcctNo><BatNo>Z19042310001</AcctNo><BeginNo>0</BeginNo><AskNum>10</AskNum></data>\n";
        String str3 = str2.substring(str2.indexOf("<data>"));
        System.out.println(str3);*/

    }
}
