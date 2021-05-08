package JavaSE.BLS.Proxy.DynamicProxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * 动态代理的基础是Java反射：
 * 使用jdk的反射机制,创建对象的能力,创建代理类对象.不用我们创建类文件
 *
 * 例如，下面需要帮助谁代理，就将对象传入，在invoke处理对应的逻辑
 */
public class ShopMain
{
    public static void main(String[] args)
    {
        UsbSell usbFactory = new UsbKingFactory();
        //创建invocationHandler对象,传入usbFactory，就是帮usbFactory代理
        InvocationHandler taobaoProxy = new MySellHandler(usbFactory);//传入谁，帮谁代理（动态的体现）
        //创建代理对象
        UsbSell proxy = (UsbSell) Proxy.newProxyInstance(
                usbFactory.getClass().getClassLoader(),
                usbFactory.getClass().getInterfaces(),
                taobaoProxy
        );
        System.out.println(proxy.sell(75));
    }
}
