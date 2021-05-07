package JavaSE.BLS.Reflect.SimpleReflect;

public class Person
{
    
    private String name;
    private int age;
    
    public Person(){}
    
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public String toString(){
        return this.name + ":" + this.age;
    }
    
    public static void show(){
        System.out.println("我是静态方法，跟随类一起创建，反射调用时不用传类");
    }
}
