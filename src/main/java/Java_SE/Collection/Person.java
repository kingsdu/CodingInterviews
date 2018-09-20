package Java_SE.Collection;


/**
 *
 */
public class Person {
    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    /**
     * 重写equals方法
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Person)){
            return false;
        }

        Person p = (Person)obj;

//        System.out.println(p.name);

        return this.name.equals(p.name) &&
                this.age == p.age;
    }


    /**
     * 带有hash表的结构，首先计算hashcode,如果hashcode相同，才会判断equals
     * @return
     */
    @Override
    public int hashCode() {
        return name.hashCode()+age*39;//保证hashcode相同
    }
}
