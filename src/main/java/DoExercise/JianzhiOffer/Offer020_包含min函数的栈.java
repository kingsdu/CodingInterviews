package DoExercise.JianzhiOffer;

import java.util.Stack;

/**
 * @Author: Du
 * @Date: 2021/6/13 10:35
 *
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 *
 * 重点：注意2个细节
 */
public class Offer020_包含min函数的栈
{
    Stack<Integer> stack, sMin;
    public Offer020_包含min函数的栈()
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
        //==如果在[-128,127]会被cache缓存,超过这个范围则比较的是对象是否相同
        //例如 Integer 1 == Integer 1 但是 Integer 128 != Integer 128的
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
