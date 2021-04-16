package DataStruct.Stack;

import java.util.EmptyStackException;

public class StackArray
{
    public int[] stackObj;
    public int maxSize;
    public int index;
    
    public StackArray(int size)
    {
        this.maxSize = size;
        stackObj = new int[size];
        index = -1;
    }
    
    
    public static void main(String[] args)
    {
        StackArray st = new StackArray(10);
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.peek());
        
        while (!st.isEmpty())
        {
            System.out.println(st.pop());
        }
    }
    
    
    public boolean isEmpty()
    {
        return index == -1;
    }
    
    public boolean isFull()
    {
        return maxSize - 1 == index;
    }
    
    public int peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return stackObj[index];
    }
    
    public int pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        int peek = peek();
        index--;
        return peek;
    }
    
    
    public void push(int val)
    {
        if (isFull())
        {
            return;
        }
        stackObj[++index] = val;
    }
    
}
