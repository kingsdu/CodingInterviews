package JavaSE.BLS.Equals;

import org.apache.commons.lang3.StringUtils;

public class User
{
    private String id;
    private String name;
    private int age;
    
    public User()
    {
    
    }
    
    public User(String id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    @Override
    public int hashCode()
    {
        /**
         *
         * 为什么要使用 31
         * 1、更少的乘积结果冲突：进行 hash code 运算，并使用常数 31, 33, 37, 39 和 41 作为乘子，每个常数算出的哈希值冲突数都小于7个
         * 2、31 可以被 JVM 优化，可以进位运算。31 * i = (i << 5) - i（左边  31*2=62,右边   2*2^5-2=62） - 两边相等，JVM就可以高效的进行计算
         *
         */
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        //原逻辑，地址相等
        if (this == obj)
        {
            return true;
        }
        //新增非空性：对于任意非空引用x，x.equals(null)应该返回false。
        if (obj == null)
        {
            return false;
        }
        //新增
        if (obj instanceof User)
        {
            User user = (User) obj;
            if (equalsStr(this.name, user.name) && equalsInt(this.age, user.age))
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean equalsInt(int int1, int int2)
    {
        return int1 == int2;
    }
    
    private boolean equalsStr(String str1, String str2)
    {
        if (StringUtils.isEmpty(str1) && StringUtils.isEmpty(str2))
        {
            return true;
        }
        if (!StringUtils.isEmpty(str1) && str1.equals(str2))
        {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.age;
    }
}
