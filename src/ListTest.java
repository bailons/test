import entity.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ListTest
 * @Description TODO
 * @Author leibailong
 * @Date 2019/4/29 0029 17:14
 * @Version 1.0
 **/
public class ListTest {

    public static void main(String[] args) {

        /*List l1 = new ArrayList();

        l1.add("111");
        l1.add("222");
        l1.add("333");
        l1.add("444");


        List l2 = new ArrayList();
        l2.add("222");
        l2.add("444");
        l2.add("555");

        l1.retainAll(l2);

        System.out.println(l1);*/
        Person person = new Person();
        Map<String,String> map = new HashMap();
        person.setId(map.get("555"));
        person.setName("hahahahahaha");
        person.setAge(32);
        System.out.println(person.toString());



    }
}
