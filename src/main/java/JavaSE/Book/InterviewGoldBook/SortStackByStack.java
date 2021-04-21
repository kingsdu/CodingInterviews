package JavaSE.Book.InterviewGoldBook;

import java.util.Stack;

/**
 *
 */
public class SortStackByStack {


    public static void main(String[] args) {
        Stack <Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        sortStackByStack(stack);
    }


    /**
     * 使用一个栈对另一个更栈进行排序（排序数字不能重复）
     *
     */
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() > cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }




}
