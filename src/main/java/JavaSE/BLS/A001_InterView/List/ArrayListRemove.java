package JavaSE.BLS.A001_InterView.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListRemove
{
    private static List<Integer> nums = new ArrayList<>();
    
    static
    {
        nums.add(0);
        nums.add(0);
        nums.add(0);
        nums.add(4);
        nums.add(2);
        nums.add(5);
        nums.add(0);
        nums.add(3);
        nums.add(0);
    }
    
    public static void numQuest1()
    {
        int k = 0;
        Integer zero = new Integer(0);
        while (k < nums.size())
        {
            System.out.println(nums.get(k));
            if (nums.get(k).equals(zero))
                nums.remove(k);//remove方法执行后，数组的长度会-1，但是k会+1。所以同时出现2个0，第2个0删不掉
            k++;
        }
    }
    
    public static void numQuest2()
    {
        int k = 0;
        Integer zero = new Integer(0);
        Iterator<Integer> iterator = nums.iterator();
        while (k < nums.size())
        {
            if (iterator.hasNext()){
                if (iterator.next().equals(zero))
                {
                    iterator.remove();
                }
                k++;
            }

        }
    }
    
    public static void main(String[] args)
    {
        numQuest1();
        nums.stream().forEach(e -> System.out.print(e + " "));
    }
}
