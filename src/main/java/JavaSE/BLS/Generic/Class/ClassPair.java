package JavaSE.BLS.Generic.Class;

/**
 *
 * @param <T>
 */
public class ClassPair<T>//传入的类型可以是任意类型，运行时才知道
{
    private T first;
    private T second;
    
    public ClassPair() { first = null; second = null; }
    
    public ClassPair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    
    public T getFirst() { return first; }
    public T getSecond() { return second; }
    
    public void setFirst(T newValue) { first = newValue; }
    public void setSecond(T newValue) { second = newValue; }
    
    /**
     *
     * 下面方法报错
     * 因为Object中已经存在这个方法，这样JVM就无法分辨了
         public boolean equals(T value){
           return first.equals(value);
         }
     */

}
