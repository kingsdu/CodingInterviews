package DoExercise.JianzhiOffer;

import java.util.Stack;

public class Offer021_栈的压入弹出序列
{
    
    public static void main(String[] args)
    {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {3, 5, 4, 2, 1};
        
        System.out.println(validateStackSequences(pushed, popped) == true ? "true" : "false");
    }
    
    /**
     * 这个代码不用看，肯定不达标
     * <p>
     * 你的思考切入点错了：
     * 这个题的关键是要拿 popped 和 stack比较，而不是popped 和 pushed比较（你的思考点一直这里纠结），
     * pushed只是 stack的数据源
     * 因为题目是要求校验popped是否等于出栈的顺序，而出栈的顺序一定要和stack比较
     *
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean validateStackSequences_error(int[] pushed, int[] popped)
    {
        Stack<Integer> stack = new Stack<>();
        boolean success = false;
        int i = 0;
        while (i < pushed.length)
        {
            if (stack.isEmpty())
            {
                stack.push(pushed[i]);
            } else if (stack.peek().equals(popped[0]))
            {
                success = true;
                break;
            } else
            {
                stack.push(pushed[i]);
            }
            i++;
        }
        
        if (i == pushed.length)
        {
            if (stack.peek().equals(popped[0]))
            {
                success = true;
            }
        }
        
        if (!success)
        {
            return false;
        } else
        {
            //找到对应元素
            int j = 0;
            while (i <= pushed.length && !stack.isEmpty())
            {
                boolean flag = false;
                if (stack.peek().equals(popped[j]) && j < popped.length)
                {
                    while (!stack.isEmpty() && stack.peek().equals(popped[j]) && j < popped.length)
                    {
                        stack.pop();
                        j++;
                        flag = true;
                    }
                    
                    if (stack.isEmpty())
                    {
                        return true;
                    }
                    
                    if (!flag)
                    {
                        j++;
                    }
                    
                } else
                {
                    if (i < pushed.length)
                    {
                        stack.push(pushed[i]);
                        i++;
                    }
                }
            }
            
            if (stack.isEmpty())
            {
                return true;
            }
        }
        return false;
    }
    
    
    public static boolean validateStackSequences(int[] pushed, int[] popped)
    {
        Stack<Integer> s1 = new Stack<>();
        int i = 0;
        for (int x : pushed)
        {
            s1.push(x);
            while (!s1.empty() && s1.peek().equals(popped[i]))
            {
                s1.pop();
                i++;
            }
        }
        return s1.empty();
    }
    
    //用数组来模拟栈
    public static boolean validateStackSequences_optimism(int[] pushed, int[] popped)
    {
        int i = 0, j = 0;
        for (int x : pushed)
        {
            pushed[i] = x;
            while (i >= 0 && pushed[i] == popped[j])
            {
                i--;
                j++;
            }
            i++;//注意细节，最后会为-1，所以要加一次
        }
        return i == 0;
    }
}
