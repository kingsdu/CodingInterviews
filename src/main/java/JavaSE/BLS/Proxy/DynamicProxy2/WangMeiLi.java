package JavaSE.BLS.Proxy.DynamicProxy2;

public class WangMeiLi implements Girl
{
    
    @Override
    public void date()
    {
        System.out.println("我是王美丽，我在约会");
    }
    
    @Override
    public void eat()
    {
        System.out.println("我是王美丽，我在吃饭");
    }
}
