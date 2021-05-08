package JavaSE.BLS.Reflect.SimpleReflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * B站视频学习
 * 疑问：
 * 1、反射机制和面向对象的封装性是否矛盾？如何看待这两个技术？
 * 不矛盾。
 * 封装性本身有其逻辑，它会提供对应的方法，不建议调用私有的方法。封装是建议调用者调用什么
 * 反射解决的能不能调的问题。
 * <p>
 * 2、通过直接new的方式或反射的方式都可以调用，开发中究竟用哪个？
 * 从代码量上、可读性，正常情况下都是用new。
 * 反射的特点是动态性，当我们在编译时不确定需要new的类对象时，需要用反射。比如在tmall中的，通过前台页面传入的url，动态调用其中的方法。
 * Method m = this.getClass().getMethod(method, HttpServletRequest.class,
 * HttpServletResponse.class,Page.class);
 */
public class ReflectPersonTest
{
    
    /**
     * 正常方法新建类
     */
    @Test
    public void normalNewClass()
    {
        Person p = new Person("Tom", 11);
        p.setAge(12);
        System.out.println(p.toString());
    }
    
    /**
     *
     * 反射的方式新建类
     *
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws NoSuchFieldException
     */
    @Test
    public void newByReflect() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException
    {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person p = constructor.newInstance("aaa", 111);
        System.out.println(p.toString());
        
        Field age = personClass.getDeclaredField("age");
        age.setAccessible(true);//调用私有方法需要加上该属性
        age.set(p, 112);
        System.out.println(p.toString());
    }
    
    /**
     * 关于Java.lang.Class类的理解
     * 1、类加载过程
     * 程序经过Javac.exe命令后，会生成一个或多个字节码文件（.class结尾），接着
     * 用Java.exe命令对某个字节码文件进行解释运行，相当于某个字节码文件加载到内存中。此过程就称为类的加载。
     * 加载到内存中的类，我们就称为运行时类，此运行时类，就是一个Class的实例。Class就是运行时的类。
     * <p>
     * 2、加载到内存中的运行时类会缓存一段时间，所以我们可以通过4种方法获取同一个类变量
     */
    @Test
    public void getClassMethod() throws ClassNotFoundException
    {
        //1、调用运行时属性：.Class
        Class c1 = Person.class;
        System.out.println(c1);
        
        //2、运用运行时类，调用getClass()
        Person p = new Person();
        Class c2 = p.getClass();
        System.out.println(c2);
        
        
        //3、调用Class的静态方法：forName
        Class c3 = Class.forName("JavaSE.BLS.Reflect.SimpleReflect.Person");
        System.out.println(c3);
        
        //4、ClassLoader 类加载器
        ClassLoader loader = ReflectPersonTest.class.getClassLoader();
        Class c4 = loader.loadClass("JavaSE.BLS.Reflect.SimpleReflect.Person");
        System.out.println(c4);
        
        System.out.println(c1 == c2);
        System.out.println(c2 == c3);
        System.out.println(c3 == c4);
    }
    
    /**
     *
     * 哪些类型可以有Class对象？
     * 基本都算
     *
     */
    
    
    /**
     * Java的类加载器
     * <p>
     * jdk.internal.loader.ClassLoaders$AppClassLoader@66d3c617
     * jdk.internal.loader.ClassLoaders$PlatformClassLoader@7907ec20
     * null
     */
    @Test
    public void getClassLoader()
    {
        //自定义类，使用系统的类加载器加载
        ClassLoader loader = ReflectPersonTest.class.getClassLoader();
        System.out.println(loader);
        //获取扩展类加载器
        ClassLoader parent = loader.getParent();
        System.out.println(parent);
        //无法获取引导类加载器
        //引导类加载器主要负责加载核心库，无法加载自定义类
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }
    
    
    /**
     * JavaBean中要求提供一个public的空参构造器的原因：
     * 1、便于通过反射，创建运行时类的对象
     * 2、便于子类继承此运行时类时，默认调用super()，保证父类有次构造方法
     * <p>
     * 比如 "java.sql.Date"; 没有空参构造器，运行时就会报错
     * java.lang.NoSuchMethodException: java.sql.Date.<init>()
     */
    public Object getInstance(String classPath) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        Class<?> aClass = Class.forName(classPath);
        return aClass.getDeclaredConstructor().newInstance();
    }
    
    /**
     * 反射的动态性
     * 动态性：在运行时代码可以根据某些条件改变自身结构。
     */
    @Test
    public void reflectTest()
    {
        for (int i = 0; i < 10; i++)
        {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num)
            {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                case 2:
                    classPath = "JavaSE.BLS.Reflect.SimpleReflect.Person";
            }
            
            try
            {
                Object instance = getInstance(classPath);
                System.out.println(instance);
            } catch (NoSuchMethodException e)
            {
                e.printStackTrace();
            } catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            } catch (IllegalAccessException e)
            {
                e.printStackTrace();
            } catch (InvocationTargetException e)
            {
                e.printStackTrace();
            } catch (InstantiationException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    
    /**
     *
     *
     * 静态方法的反射
     *
     */
    @Test
    public void StaticTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        Class<Person> p = Person.class;//此处已经有类了，所以不需要传参也可调用invoke
        Method show = p.getDeclaredMethod("show");
        show.invoke(null);
    }
    
}
