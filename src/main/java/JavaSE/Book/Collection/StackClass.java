package JavaSE.Book.Collection;

import java.util.Stack;

public class StackClass {


    /**
     *
     * Stack类的学习
     *
     * push方法从顶部插入元素，后面的顶部元素会代替前面的顶部元素成为新的顶部元素，以前的顶部元素变为底部元素。
     * Pop方法，从顶部获取元素。
     */
    public void showStack(){

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (Integer i :
                stack) {
            System.out.print(" "+i);
        }

        System.out.println();

        while (!stack.isEmpty()){
            System.out.print(" "+stack.pop());
        }


    }


    public static void main(String[] args) {
        StackClass stackClass = new StackClass();
        stackClass.showStack();
    }
}
