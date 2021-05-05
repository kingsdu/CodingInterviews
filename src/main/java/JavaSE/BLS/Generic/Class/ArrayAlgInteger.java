package JavaSE.BLS.Generic.Class;

public class ArrayAlgInteger
{
    public static ClassPair<Integer> minmax(Integer[] arr)
    {
        if (arr == null || arr.length == 0) return null;
        Integer min = arr[0];
        Integer max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (min.compareTo(arr[i]) > 0) min = arr[i];
            if (max.compareTo(arr[i]) < 0) max = arr[i];
        }
        return new ClassPair<>(min, max);
    }
    
}
