package JavaSE.BLS.Reflect.Invoke;

import java.lang.reflect.Method;

/**
 *
 * invoke是，类 invoke 方法
 *
 */
public class TestClassLoad
{
    
    public static void main(String[] args) throws Exception
    {
        Class<?> clz = Class.forName("JavaSE.BLS.Reflect.Invoke.Hello");
        Object o = clz.getDeclaredConstructor().newInstance();
        Method m = clz.getDeclaredMethod("helloWorld", String.class);
        m.setAccessible(true);
        m.invoke(o,"aaa");
    }
    
}
