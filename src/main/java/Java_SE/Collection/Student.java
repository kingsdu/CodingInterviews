package Java_SE.Collection;

/**
 * 测试TreeSet
 */
public class Student implements Comparable{

    private String name;
    private Integer age;

    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int compareTo(Object obj) {
        if(!(obj instanceof Student)){
            throw new RuntimeException("not student object");
        }

        Student stu = (Student) obj;

        if(this.age > stu.age){
            return 1;
        }
        if(this.age == stu.age){
            return 0;
        }
        return -1;
    }
}
