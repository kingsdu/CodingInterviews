package JavaSE.BLS.Collection.Compare;

import java.util.Arrays;

public class StudentMain
{
    
    public static void main(String[] args)
    {
        Student s2 = new Student("ls",1);
        Student s1 = new Student("zs",10);
//        Student s3 = new Student("ww",110);

        Student[] arr = new Student[2];
        arr[0] = s1;
        arr[1] = s2;
//        arr[2] = s3;

        Arrays.sort(arr);

        for (Student s:
             arr)
        {
            System.out.println(s.getAge());
        }
        
//        List<Student> list = new ArrayList<>();
//        list.add(s1);
//        list.add(s2);
//        list.add(s3);
//
//        Collections.sort(list);
//
//        for (Student s:
//                list)
//        {
//            System.out.println(s.getAge());
//        }
    }
}
