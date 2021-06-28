package JavaSE.BLS.Proxy.DynamicProxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理的基础是Java反射：
 * 使用jdk的反射机制,创建对象的能力,创建代理类对象.不用我们创建类文件
 * <p>
 * 例如，下面需要帮助谁代理，就将对象传入，在invoke处理对应的逻辑
 */
public class ShopMain
{
    public static void main(String[] args)
    {
        UsbSell usbFactory = new UsbKingFactory();
        //创建invocationHandler对象,传入usbFactory，就是帮usbFactory代理
        InvocationHandler taobaoProxy1 = new MySellHandler(usbFactory);//传入谁，帮谁代理（动态的体现）
        InvocationHandler taobaoProxy2 = new MySellHandler2(usbFactory);//传入谁，帮谁代理（动态的体现）
        //创建代理对象
        UsbSell proxy1 = (UsbSell) Proxy.newProxyInstance(
                usbFactory.getClass().getClassLoader(),//将proxy和需要代理的类建立联系
                usbFactory.getClass().getInterfaces(),
                taobaoProxy1
        );
        System.out.println("动态代理1   " + proxy1.sell(75));//此时调用sell就是proxy帮助usbFactory代理执行了
        UsbSell proxy2 = (UsbSell) Proxy.newProxyInstance(
                usbFactory.getClass().getClassLoader(),//将proxy和需要代理的类建立联系
                usbFactory.getClass().getInterfaces(),
                taobaoProxy2
        );
        System.out.println("动态代理2   " + proxy2.sell(75));//此时调用sell就是proxy帮助usbFactory代理执行了
    }
}
