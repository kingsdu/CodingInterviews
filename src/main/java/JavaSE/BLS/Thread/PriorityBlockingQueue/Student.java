package JavaSE.BLS.Thread.PriorityBlockingQueue;

public class Student implements Comparable<Student>
{
    int age;
    String name;
    
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString()
    {
        return this.name + "---" + this.age;
    }
    
    @Override
    public int compareTo(Student o)
    {
        return this.age - o.age;
    }
}
