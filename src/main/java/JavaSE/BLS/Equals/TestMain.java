package JavaSE.BLS.Equals;

import java.util.HashSet;
import java.util.Set;

public class TestMain
{
    
    public static void main(String[] args)
    {
        TestMain t = new TestMain();
        t.testEqualsHashCode();
    }
    
    
    public void testEqualsHashCode()
    {
        /**
         *
         * 每重写equals之前，运行结果是false，因为equals里面比较的是两对象的地址是否相等
         *
         */
        User user1 = new User("1", "xiaohua", 14);
        User user2 = new User("1", "xiaohua", 14);
        System.out.println(user1.equals(user2));
        Set<User> userSet = new HashSet<>();
        userSet.add(user1);
        userSet.add(user2);
        System.out.println(user1.hashCode() == user2.hashCode());
        System.out.println(userSet);//不重写hashcode方法，会输出[1 xiaohua 14, 1 xiaohua 14]
    }
    

}
