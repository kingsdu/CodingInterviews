package java_se;

import java_se.Collection.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class ArrayList_RepeatDelTest {


    /**
     * 去除ArrayList中的重复元素
     */
    @Test
    public void delRepeatTest(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);

        ArrayList_RepeatDel arrayList_repeatDel = new ArrayList_RepeatDel();
        arrayList_repeatDel.outArrayList(arrayList_repeatDel.delRepeat(list));
    }


    /**
     * 去除ArrayList中的重复对象
     *
     * ArrayList判断或者删除对象只依赖于equals
     */
    @Test
    public void delRepeatPerson(){
        ArrayList personAly = new ArrayList();
        ArrayList_RepeatDel arrayList_repeatDel = new ArrayList_RepeatDel();

        personAly.add(new Person("zs",23));
        personAly.add(new Person("ls",24));
        personAly.add(new Person("ww",25));
        personAly.add(new Person("ww",25));

        ArrayList personList = arrayList_repeatDel.delRepeat(personAly);

        Iterator iterator = personList.iterator();
        while (iterator.hasNext()){
            Person person = (Person) iterator.next();
            System.out.println(person.getName()+"::"+person.getAge());
        }
    }


    /**
     * 去除HashSet中的重复对象
     *
     * HashSet判断或者删除对象依赖于 equals 和 hashcode
     *
     * 原因在于数据结构不同
     */
    @Test
    public void delRepeatSet(){
        HashSet set = new HashSet();

        set.add(new Person("zs",23));
        set.add(new Person("ls",24));
        set.add(new Person("ww",25));
        set.add(new Person("ww",25));

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            Person person = (Person) iterator.next();
            System.out.println(person.getName()+"::"+person.getAge());
        }
    }


    /**
     * 利用TreeSet进行比较的两种方法
     *  1 Student类实现Comparable接口，覆写方法compare方法；
     *  2 自定义规则，Student_Comparator实现Comparator方法；
     */
    @Test
    public void delRepeatTreeSet(){
        //方式1
/*        TreeSet set = new TreeSet();

        set.add(new Student("zs",23));
        set.add(new Student("ls",24));
        set.add(new Student("ww",25));
        set.add(new Student("ww",25));

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            Student student = (Student) iterator.next();
            System.out.println(student.getName() +"::"+ student.getAge());
        }*/

        //方式2
        TreeSet set_comparator = new TreeSet(new Student_Comparator());

        set_comparator.add(new Student("zs",23));
        set_comparator.add(new Student("ls",24));
        set_comparator.add(new Student("ww",25));
        set_comparator.add(new Student("ww",25));

        Iterator comparator_iterator = set_comparator.iterator();

        while (comparator_iterator.hasNext()){
            Student student = (Student) comparator_iterator.next();
            System.out.println(student.getName() +"::"+ student.getAge());
        }
    }


    /**
     * Treeset练习1：按照字符串长度排序
     */
    @Test
    public void tree_Execise_1(){
        TreeSet set = new TreeSet(new StringLength_Comparator());

        set.add("abcdefg");
        set.add("abd");
        set.add("aaa");
        set.add("abcds");
        set.add("ad");
        set.add("abcd");


        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}