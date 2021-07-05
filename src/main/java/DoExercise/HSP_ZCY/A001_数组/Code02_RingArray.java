package DoExercise.HSP_ZCY.A001_数组;

/**
 * @Author: Du
 * @Date: 2021/7/5 11:55
 * <p>
 * 数组实现环形队列
 */
public class Code02_RingArray
{
    
    public static void main(String[] args)
    {
        Code02_RingArray c = new Code02_RingArray(3);
        c.push(1);
        c.push(2);
        c.push(3);
        System.out.println(c.pop());
        System.out.println(c.pop());
        System.out.println(c.pop());
        c.push(4);
        c.push(5);
        c.push(6);
        System.out.println(c.pop());
        System.out.println(c.pop());
        System.out.println(c.pop());
        c.push(7);
        c.push(8);
        c.push(9);
        System.out.println(c.pop());
        System.out.println(c.pop());
        System.out.println(c.pop());
    }
    
    
    private int[] arr;
    private int pushIdx;
    private int popIdx;
    private int size;
    private int limit;
    
    public Code02_RingArray(int maxSize)
    {
        arr = new int[maxSize];
        popIdx = 0;
        pushIdx = 0;
        size = 0;
        limit = maxSize;
    }
    
    //返回下一个位置下标
    public int nextIndex(int index)
    {
        return index < limit - 1 ? index + 1 : 0;
    }
    
    public void push(int val)
    {
        if (size == limit) throw new RuntimeException("栈满了，不能再加了");
        size++;
        arr[pushIdx] = val;
        pushIdx = nextIndex(pushIdx);
    }
    
    public int pop()
    {
        if (size == 0) throw new RuntimeException("栈空了，不能再拿了");
        size--;
        int ans = arr[popIdx];
        popIdx = nextIndex(popIdx);
        return ans;
    }
    
    
}
