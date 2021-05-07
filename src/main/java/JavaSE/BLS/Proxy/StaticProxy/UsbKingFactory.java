package JavaSE.BLS.Proxy.StaticProxy;

public class UsbKingFactory implements UsbSell
{
    @Override
    public float sell(int amount)
    {
        System.out.println("出厂价是:" + amount);
        return amount;
    }
}
