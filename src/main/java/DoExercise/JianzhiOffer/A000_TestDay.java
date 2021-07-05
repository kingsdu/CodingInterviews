package DoExercise.JianzhiOffer;

import java.util.Stack;

//0620:要刷的三道题:12;20;9
//0621:要刷的三道题:13;11;22
//0622:要刷的三道题:7;13;6
//0624:要刷的三道题:6;57;1
//0628:要刷的三道题:7;8;3
//0703:要刷的三道题:17;10;29
//0703:要刷的三道题:18;1;11
//0704:要刷的三道题:38;31;7
public class A000_TestDay
{
    
    public static void main(String[] args)
    {
        A000_TestDay a = new A000_TestDay();
        Offer000_Common.randomTM(40);
    }
    
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> min = new Stack<>();
    
    
    public void push(int x)
    {
        s1.push(x);
        if (min.empty() || min.peek() >= x)
        {
            min.push(x);
        }
    }
    
    public void pop()
    {
        if (s1.pop().equals(min.peek()))
        {
            min.pop();
        }
    }
    
    public int top()
    {
        return s1.peek();
    }
    
    public int min()
    {
        return min.peek();
    }
    
}
