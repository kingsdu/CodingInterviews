package JavaSE.BLS.Generic.BrigeMethod;

public class BridgeMethodChildPair extends BridgeMethodPair<Integer>
{
    private Integer first;
    private Integer second;
    private Integer third;
    
    public BridgeMethodChildPair()
    {
        first = null;
        second = null;
    }
    
    public BridgeMethodChildPair(Integer first, Integer second)
    {
        this.first = first;
        this.second = second;
    }
    
    public void setSecond(Integer newValue)
    {
        System.out.println("Integer setSecond");
        second = newValue;
    }
    
    public Integer getSecond()
    {
        System.out.println("Integer getSecond");
        return super.getSecond();
    }
    
    public Integer getThird()
    {
        return third;
    }
    
    public void setThird(Integer third)
    {
        this.third = third;
    }
}
