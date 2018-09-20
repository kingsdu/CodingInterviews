package DataStructBook;

import java.util.*;

/**
 * 练习回忆之前学过的代码
 */
public class Practice {

    /**
     * 递归调用
     */
    public int getLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else{
            int last = getLastElement(stack);
            stack.push(result);
            return last;
        }
    }


    public void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }else{
           int value = getLastElement(stack);
           reverse(stack);
           stack.push(value);
        }
    }












}
