package JavaSE.Book.Collection.Compare;


public class Student implements Comparable
{
    
    private String name;
    private Integer age;
    
    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
        System.out.println("this.age----"+this.age);
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Integer getAge()
    {
        return age;
    }
    
    public void setAge(Integer age)
    {
        this.age = age;
    }
    
    
    /**
     * 如果返回 1  说明o1 > o2  如 2  1
     * 如果返回 0  说明o1 = o2   如 cc  cc
     * 如果返回 -1 说明o1 < o2   如 6  7
     *
     * @param obj
     * @return
     */
    public int compareTo(Object obj)
    {
        if (!(obj instanceof Student))
        {
            throw new RuntimeException("not student object");
        }
        
        Student stu = (Student) obj;
        
        System.out.println("this.age" + this.age);
        System.out.println("stu.age" + stu.age);
//        return this.age - stu.age;
        return this.age - stu.age;
    }
}
