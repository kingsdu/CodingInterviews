package JavaSE.BLS.Generic.Inherit;

public class PairAlg
{
    public static boolean hasNulls(InheritPair<?> pair)
    {
        return pair.getFirst() == null || pair.getSecond() == null;
    }
    
    public static void swap(InheritPair<?> pair)
    {
        swapHelper(pair);
    }
    
    public static <T> void swapHelper(InheritPair<T> pair)
    {
        T first = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(first);
    }
}
