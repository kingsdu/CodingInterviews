package DoExercise.MianShiJinDian;

import java.util.Stack;

/**
 * 仅用递归函数和栈，逆序一个栈
 */
public class ReverseStackByDG {

    /**
     * 这里面涉及一些技巧
     * 1 递归，根据从里到外的顺序返回递归元素
     * 2 栈，从外到里的返回元素
     * 3 递归的return返回值last不会变化
     */
    public int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.empty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }


    public void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }


}
