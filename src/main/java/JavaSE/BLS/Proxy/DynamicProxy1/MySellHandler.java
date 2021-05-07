package JavaSE.BLS.Proxy.DynamicProxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MySellHandler implements InvocationHandler//InvocationHandler接口：表示代理要干什么（定义目标类要完成的功能）
{
    private Object target = null;
    
    //动态代理的目标对象是活动的，需要传入进来，传进来的是谁就给谁创建代理
    public MySellHandler(Object target)
    {
        this.target = target;
    }
    
    /**
     *
     * 表示代理对象要执行的功能代码
     *
     * 可以根据传入 target 的不同，对各种对象实现代理
     *
     * @param proxy jdk创建的代理对象，无需赋值
     * @param method 目标类中的方法，jdk负责提供method对象
     * @param args 目标类中的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Object res = null;
        res = method.invoke(target, args);
        if (res != null)
        {
            Float price = (Float) res;
            price = price + 25;
            res = price;
        }
        System.out.println("淘宝售价");
        return res;
    }
}
