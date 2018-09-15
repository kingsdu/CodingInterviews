package DataStructBook;

import org.junit.Test;

import static org.junit.Assert.*;

public class UseStackTest {

    @Test
    public void reverseCharacter() {
        UseStack useStack = new UseStack();
        useStack.reverseCharacter(new String[]{"1","2","3","4","5","6"});
    }

    @Test
    public void bracketTest(){
        UseStack useStack = new UseStack();
        useStack.bracket("a{b(c)d}e");
    }


    @Test
    public void stack(){
        StackX_Char stackX = new StackX_Char(3);
        stackX.push('a');
        stackX.push('b');
        stackX.push('c');

        StackX stack = new StackX(3);
        stack.push("a");
        stack.push("b");
        stack.push("c");

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        while (!stackX.isEmpty()){
            System.out.println(stackX.pop());
        }

    }

}