package JavaSE.BLS.Proxy.StaticProxy;


/**
 *
 * 静态代理
 * 优点: 1、实现简单；2、容易理解
 *
 * 缺点：
 * 1、当你的项目中,目标类的代理类很多的时候,当目标类增加了,代理类可能也需要成倍的增加
 * 2、当你的接口中功能在增加了,或者修改了,会影响众多的实现类,厂家类,代理都需要修改,影响比较多.
 * 例如下面例子，1、当需要在京东上卖时，需要增加新的接口；
 *
 */
public class ShopMain
{
    public static void main(String[] args)
    {
        TaoBao taoBao = new TaoBao();
        float price = taoBao.sell(80);
        System.out.println("淘宝售价:"+price);
    }
}
