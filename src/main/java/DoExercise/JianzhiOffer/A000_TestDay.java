package DoExercise.JianzhiOffer;

import java.util.Stack;

public class A000_TestDay
{
    
    public static void main(String[] args)
    {
        A000_TestDay a = new A000_TestDay();
        
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(a.validateStackSequences(pushed, popped));
    }
    
    
    public boolean validateStackSequences(int[] pushed, int[] popped)
    {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed)
        {
            stack.push(num);
            while (!stack.empty() && stack.peek() == popped[i])
            {
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }
}
