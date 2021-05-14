package DoExercise.JianzhiOffer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1}
 * 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 * 输入：pushed = [1,2,3,4,5], popped = [3,5,4,2,1]
 * 输出：true
 *
 */
public class Offer021_ValidateStackSequences
{
    
    public static void main(String[] args)
    {
        Offer021_ValidateStackSequences of = new Offer021_ValidateStackSequences();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {3, 5, 4, 2, 1};
        
        System.out.println(of.validateStackSequences_1(pushed, popped) == true ? "true" : "false");
        System.out.println(of.validateStackSequences_2(pushed, popped) == true ? "true" : "false");
    }
    
    /**
     * 思路：模拟其入栈和出栈的过程
     * 1、pushed先入栈，入栈的同时校验popped中的元素是否和pushed中的入栈元素一致，
     * 如果一致，则pushed先出栈。
     * 2、poped+1，继续通过步骤1的移动判断下标的元素。
     *
     *
     * 代码写的太过繁琐，牛客网报错程序太复杂.
     * 这就是我编程时特别容易陷入的误区：没理解算法的实质，就在那里推演，越推演，越复杂。
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences_1(int[] pushed, int[] popped)
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
            
            if(stack.isEmpty()){
                return true;
            }
        }
        return false;
    }
    
    
    /**
     *
     * 大神方法：其实问题很简单，我就是对程序的归纳能力很弱，什么时候结束循环，什么东西作为循环，这些东西我思路不清晰
     *          搞得我写程序会花很多时间，写出来的东西也是很复杂的。没有抓住问题的核心。
     *
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences_2(int[] pushed, int[] popped){
        if (pushed.length == 0 || popped.length == 0 || pushed.length != popped.length) {
            return false;
        }
        
        Stack<Integer> stack = new Stack<>();
        int index = 0;
    
        for (int item :
                pushed)
        {
            stack.push(item);
            while (!stack.isEmpty() && popped[index] == stack.peek()){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
