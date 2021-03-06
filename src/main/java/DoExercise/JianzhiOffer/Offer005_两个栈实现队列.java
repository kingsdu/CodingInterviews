package DoExercise.JianzhiOffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * <p>
 * 栈：先进后出
 * 队列：先进先出
 * 堆：队列优先，先进先出
 * <p>
 * <p>
 * 思路：
 * 1、一个栈作为入栈stackIn，一个作为出栈stackOut
 * 2、push时，直接将元素入栈至stackIn，pop时，先将stackIn的元素出栈至stackOut，在出栈stackOut
 */
public class Offer005_两个栈实现队列
{
    static Stack<Integer> stackIn = new Stack<Integer>();
    static Stack<Integer> stackOut = new Stack<Integer>();
    
    public static void push_1(int node)
    {
        stackIn.push(node);
    }
    
    public static int pop_1()
    {
        if (stackIn.isEmpty() && stackOut.isEmpty())
        {
            throw new RuntimeException("Queue is empty");
        }
        
        if (stackOut.isEmpty())
        {
            if (stackIn.isEmpty())
            {
                return -1;
            }
            while (!stackIn.isEmpty())
            {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();//当s
        // 2中还有值，继续返回s2
    }
    
    
    public static void main(String[] args)
    {
        push_1(1);
        push_1(2);
        System.out.println(pop_1());
        
        push_1(3);
        
        System.out.println(pop_1());
        System.out.println(pop_1());
    }
}

