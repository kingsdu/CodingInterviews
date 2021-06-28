package JavaSE.BLS.Proxy.DynamicProxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: Du
 * @Date: 2021/6/28 15:02
 *
 * 动态代理，可代理对象2
 */
public class MySellHandler2 implements InvocationHandler
{
    
    private Object target = null;
    
    //动态代理的目标对象是活动的，需要传入进来，传进来的是谁就给谁创建代理
    public MySellHandler2(Object target)
    {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Object res = null;
        res = method.invoke(target, args);
        if (res != null)
        {
            Float price = (Float) res;
            price = price + 35;
            res = price;
        }
        System.out.println("淘宝售价");
        return res;
    }
}
