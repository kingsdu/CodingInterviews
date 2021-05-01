package JavaSE.BLS.String;

import java.lang.reflect.Field;

/**
 *
 * 通过反射修改String的值
 *
 * String默认是不可变类，但是可以通过反射修改其内的值
 *
 */
public class ReflectionString
{
    /**
     *
     *
     *
     * @param args
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException
    {
        String s = "Hello world";
        System.out.println(s);
    
        /**
         *
         * 使用反射也修改不了String的值：下面代码会报错cannot access a member of class java.lang.String
         *
         */
        Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
    
        char[] chars = (char[]) value.get(s);
        
        chars[5] = '_';
    
        System.out.println(s);
    }
    
}
