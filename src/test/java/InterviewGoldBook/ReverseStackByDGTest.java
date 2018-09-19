package InterviewGoldBook;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class ReverseStackByDGTest {

    @Test
    public void getAndRemoveLastElement() {
        Stack stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        ReverseStackByDG reverseStackByDG = new ReverseStackByDG();
        reverseStackByDG.reverse(stack);
    }
}