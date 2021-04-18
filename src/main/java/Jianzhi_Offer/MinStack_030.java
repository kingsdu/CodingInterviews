package Jianzhi_Offer;

import java.util.Stack;

/**
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();      --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();      --> 返回 -2.
 *
 *
 * 各函数的调用总次数不超过 20000 次
 *
 */
public class MinStack_030
{
    Stack<Integer> normal, minval;
    
    public MinStack_030() {
        normal = new Stack<>();
        minval = new Stack<>();
    }
    
    /**
     *
     * >= 很细节，防止了重复最小元素出栈为空
     * @param x
     */
    public void push(int x) {
        normal.push(x);
        if(minval.isEmpty() || minval.peek() >= x){
            minval.push(x);
        }
    }
    
    
    /**
     *
     * 有最小push最小
     * 没最小push的minval.peek()
     *
     * @param x
     */
    public void push_1(int x) {
        normal.push(x);
        if(minval.isEmpty()){
            minval.push(x);
        }
        else{
            if(x <= minval.peek()){
                minval.push(x);
            }
            else{
                minval.push(minval.peek());
            }
        }
    }
    
    /**
     * 因为在push的时候push了2次
     * 所以在pop的时候，为了保证2个栈的一致性，需要比较后再次pop
     * 这个很细节
     *
     */
    public void pop() {
        if(normal.pop().equals(minval.peek())){
            minval.pop();
        }
    }
    
    public void pop_1() {
        normal.pop();
        minval.pop();
    }
    
    public int top() {
       return normal.peek();
    }
    
    public int min() {
        return minval.peek();
    }
}
