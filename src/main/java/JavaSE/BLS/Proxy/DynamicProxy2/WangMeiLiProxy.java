package JavaSE.BLS.Proxy.DynamicProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class WangMeiLiProxy implements InvocationHandler
{
    //不能访问真实对象
    private Girl girl;
    
    public WangMeiLiProxy(Girl g)
    {
        this.girl = g;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        doSomethingBefore();
        Object invoke = method.invoke(girl, args);
        doSomethingAfter();
        return invoke;
    }
    
    
    private void doSomethingBefore()
    {
        System.out.println("父母的调查1");
    }
    
    private void doSomethingAfter()
    {
        System.out.println("父母的调查2");
    }
    
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(girl.getClass().getClassLoader(), girl.getClass().getInterfaces(),this);
    }
    
}
