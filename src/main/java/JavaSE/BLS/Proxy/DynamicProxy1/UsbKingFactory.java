package JavaSE.BLS.Proxy.DynamicProxy1;

public class UsbKingFactory implements UsbSell
{
    @Override
    public float sell(int amount)
    {
        System.out.println("出场价："+amount);
        return amount;//厂家的U盘价格
    }
}
