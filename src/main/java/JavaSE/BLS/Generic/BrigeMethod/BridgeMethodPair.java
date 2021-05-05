package JavaSE.BLS.Generic.BrigeMethod;

public class BridgeMethodPair<T>
{
    private T first;
    private T second;
    
    public BridgeMethodPair()
    {
        first = null;
        second = null;
    }
    
    public BridgeMethodPair(T first, T second)
    {
        this.first = first;
        this.second = second;
    }
    
    public T getFirst()
    {
        return first;
    }
    
    public T getSecond()
    {
        System.out.println("T getSecond");
        return second;
    }
    
    public void setFirst(T newValue)
    {
        first = newValue;
    }
    
    public void setSecond(T newValue)
    {
        System.out.println("T setSecond");
        second = newValue;
    }
}
