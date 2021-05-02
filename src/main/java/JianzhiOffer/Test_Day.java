package JianzhiOffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * <p>
 * 栈：先进后出
 * 队列：先进先出
 * 堆：队列优先，先进先出
 *
 *
 * 思路：
 * 1、一个栈作为入栈stackIn，一个作为出栈stackOut
 * 2、push时，直接将元素入栈至stackIn，pop时，先将stackIn的元素出栈至stackOut，在出栈stackOut
 */
public class Test_Day
{
    public static void main(String[] args)
    {
    
    }
    
    Stack<Integer> stackIn = new Stack<>();
    Stack<Integer> stackOut = new Stack<>();
    
    public Integer pop(){
        if(stackIn.isEmpty() && stackOut.isEmpty()){
            return null;
        }
        
        if(stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        
        return stackOut.pop();
    }
    
    public void push(int x){
        stackIn.push(x);
    }
    
   
}
