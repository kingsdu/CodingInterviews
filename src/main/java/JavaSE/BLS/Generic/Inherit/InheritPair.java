package JavaSE.BLS.Generic.Inherit;

public class InheritPair<T>
{
    private T first;
    private T second;
    
    public InheritPair() { first = null; second = null; }
    
    public InheritPair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    
    public T getFirst() { return first; }
    public T getSecond() { return second; }
    
    public void setFirst(T newValue) { first = newValue; }
    public void setSecond(T newValue) { second = newValue; }
}
