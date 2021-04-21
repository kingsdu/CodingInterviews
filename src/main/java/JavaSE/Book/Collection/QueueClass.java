package JavaSE.Book.Collection;

import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueClass
{
    
    
    public static void main(String[] args)
    {
        //报错，不允许加null
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue();
        queue.add(null);
    
        Stack<String> stack = new Stack<>();
        stack.push(null);
    }
    
    
    
}
