import entity.Person;

import java.util.ArrayList;
import java.util.List;

public class TestListContain {
    public static void main(String[] args) {

        List<String> all = new ArrayList<>();
        all.add("111");
        all.add("222");
        all.add("333");
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
        List<Person> person2 = new ArrayList<>();
        persons.forEach(
                p->{
                    if(all.contains(p.getId())){
                        person2.add(p);
                    }
                }
        );
        person2.forEach(p-> System.out.println(p.toString()));
    }
}
