package DoExercise.JianzhiOffer;

import java.util.Stack;

/**
 * @Author: Du
 * @Date: 2021/6/13 10:35
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * push存值
 * pop不用返回值
 * top表示当前的栈顶元素
 * min要求能多次取
 *
 * 重点：注意2个细节
 */
public class Offer072_包含min函数的栈
{
    Stack<Integer> stack, sMin;
    
    public Offer072_包含min函数的栈()
    {
        stack = new Stack<>();
        sMin = new Stack<>();
    }
    
    public void push(int x)
    {
        stack.push(x);
        if (sMin.empty() || sMin.peek() >= x)
        {//这里必须要等于的情况，例如 0，1，0 没等于就有问题
            sMin.push(x);
        }
    }
    
    public void pop()
    {   //如果用==将会无法通过 Integer的equals重写过，比较的是内部value的值，
        // ==如果在[-128,127]会被cache缓存,超过这个范围则比较的是对象是否相同
        if (stack.pop().equals(sMin.peek()))
        {
            sMin.pop();
        }
    }
    
    public int top()
    {
        return stack.peek();
    }
    
    public int min()
    {
        return sMin.peek();
    }
}
