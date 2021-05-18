package DoExercise.HSP.A004_Stack;

import java.util.EmptyStackException;

/**
 * 用数组实现一个基础的栈结构
 */
public class SimpleStackHSP
{
    public int[] stackObj;
    public int maxSize;
    public int count;
    
    public SimpleStackHSP(int size)
    {
        this.maxSize = size;
        stackObj = new int[size];
        count = -1;
    }
    
    
    public static void main(String[] args)
    {
        SimpleStackHSP myStack = new SimpleStackHSP(10);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
    
    
    public boolean isEmpty()
    {
        return count == -1;
    }
    
    public boolean isFull()
    {
        return maxSize - 1 == count;
    }
    
    public int peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return stackObj[count];
    }
    
    public int pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        int peek = peek();
        stackObj[count] = 0;
        count--;
        return peek;
    }
    
    
    public void push(int val)
    {
        if (isFull())
        {
            return;
        }
        stackObj[++count] = val;
    }
    
    public int priority(int oper)
    {
        if (oper == '*' || oper == '/')
        {
            return 1;
        } else if (oper == '+' || oper == '-')
        {
            return 0;
        } else
        {
            return -1;
        }
    }
    
    public boolean isOper(char val)
    {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    
    public int cal(int num1, int num2, int oper)
    {
        int res = 0;
        switch (oper)
        {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
