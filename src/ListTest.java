import entity.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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



        List l2 = new ArrayList();
        l2.add("222");
        l2.add("444");
        l2.add("555");
        l2.add("666");

        l2.retainAll(l1);

        System.out.println(l2);*/


        Person p1;
        List<Person> people = new LinkedList();
        for(int i=0;i<3;i++) {
            p1 = new Person();
            p1.setId(i + "");
            p1.setName(i + "x");
            /*if(i == 2){
                p1.setName("lisi");
            }else{
                p1.setName("zs");
            }*/
            p1.setAge(i + 20);
            people.add(p1);
        }

        Map<String, Person> collect = people.stream().collect(Collectors.toMap(Person::getName, p -> p));
        System.out.println(collect);


        String id = "123123xx";
        id = id.toUpperCase();
        System.out.println(id);

        /*Person p2 = new Person();
        List<Person> people2 = new LinkedList();
        people.forEach(person -> {
            p2.setId(person.getId());
            p2.setAge(person.getAge());
            p2.setName(person.getName());
            people2.add(p2);
        });*/

        /*List<Person> personList = people.stream().filter(person -> "zs".equals(person.getName())).collect(Collectors.toList());

        System.out.println(personList);*/

        /*people.add(p1);
        people.add(p2);
        people.add(p3);*/


        /*List<String> ids = people.stream().filter(p -> p.getAge() == 30).collect(Collectors.toList()).stream().map(Person::getId).collect(Collectors.toList());

        System.out.println(ids);*/

        /*for(Person person:people){
            System.out.println("123123123123123");
        }*/

    }
}
