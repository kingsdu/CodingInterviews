package help_methods;

import org.junit.Test;

import static org.junit.Assert.*;

public class E06ConstructBinaryTreeTest {



    @Test
    public void construct() {
    }

    @Test
    public void constructCore() {
    }

    @Test
    public void printPreOrder() {
    }


    @Test
    public void constructTree(){
        int[] preOrder={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        E06ConstructBinaryTree.printPreOrder(E06ConstructBinaryTree.Construct(preOrder, inOrder, preOrder.length));
    }
}