package DoExercise.MianShiJinDian;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 */
public class Stack_MinElement {

    private Stack<Integer> stack_Ele;
    private Stack<Integer> stack_min;

    public Stack_MinElement(){
        stack_Ele = new Stack<Integer>();
        stack_min = new Stack<Integer>();
    }

    public void push(int value){
        if(stack_min.isEmpty()){
            stack_min.push(value);
        }else {
            if(getMin() >= value){
                stack_min.push(value);
            }
        }
        stack_Ele.push(value);
    }



    public int getMin(){
        if(stack_min.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        return this.stack_min.peek();
    }
}
