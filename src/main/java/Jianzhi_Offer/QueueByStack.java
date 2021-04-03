package Jianzhi_Offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * <p>
 * 栈：先进后出
 * 队列：先进先出
 * 堆：队列优先，先进先出
 */
public class QueueByStack
{

    Stack<Integer> stackIn = new Stack<Integer>();
    Stack<Integer> stackOut = new Stack<Integer>();


    public void push_1(int node)
    {
        stackIn.push(node);
    }

    public int pop_1()
    {
        if(stackIn.isEmpty() && stackOut.isEmpty())
        {
            throw new RuntimeException("Queue is empty");
        }

        if (stackOut.isEmpty())
        {
            while (!stackIn.isEmpty())
            {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }


    public static void main(String[] args)
    {
        QueueByStack queueByStack = new QueueByStack();
        queueByStack.push_1(1);
        queueByStack.push_1(2);
        System.out.println(queueByStack.pop_1());

        queueByStack.push_1(3);

        System.out.println(queueByStack.pop_1());
        System.out.println(queueByStack.pop_1());

    }
}
