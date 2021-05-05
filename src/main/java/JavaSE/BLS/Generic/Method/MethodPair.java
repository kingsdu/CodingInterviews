package JavaSE.BLS.Generic.Method;

public class MethodPair<T>
{
    private T first;
    private T second;
    
    public MethodPair() { first = null; second = null; }
    
    public MethodPair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    
    public T getFirst() { return first; }
    public T getSecond() { return second; }
    
    public void setFirst(T newValue) { first = newValue; }
    public void setSecond(T newValue) { second = newValue; }
}
