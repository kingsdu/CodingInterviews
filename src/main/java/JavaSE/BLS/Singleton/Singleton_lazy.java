package JavaSE.BLS.Singleton;

/**
 *
 * 懒汉式
 * 用的时候才创建
 *
 */
public class Singleton_lazy
{
    //静态保证了其唯一性.
    //使用方法调用是为了保证对象可控
    private static Singleton_lazy singleton = null;
    //私有化构造函数，保证外部无法调用
    private Singleton_lazy(){
    
    }
    //留给外部访问类实例的方法
    public static Singleton_lazy getInstacnce(){
        if(singleton == null){
            singleton = new Singleton_lazy();
        }
        return singleton;
    }
    
    
}
