package JavaSE.BLS.Proxy.StaticProxy;

/**
 *
 *
 *
 * 淘宝是一个商家,代理金士顿U盘的销售
 *
 *
 *
 *
 */
public class TaoBao implements UsbSell
{
    
    private UsbKingFactory factory =new UsbKingFactory();
    
    @Override
    public float sell(int amount)
    {
        float price = factory.sell(amount);
        price = price + 20;
        return price;
    }
}
