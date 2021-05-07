package JavaSE.BLS.Proxy.DynamicProxy2;

public class LisonMain
{
    
    public static void main(String[] args)
    {
        Girl girl = new WangMeiLi();
    
        WangMeiLiProxy family = new WangMeiLiProxy(girl);
    
        Girl GirlProxy = (Girl) family.getProxyInstance();
    
        GirlProxy.date();
        GirlProxy.eat();
    }
    
}
