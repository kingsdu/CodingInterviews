package DataStruct;

import org.junit.Test;

import static org.junit.Assert.*;

public class Tree2SortsTest {

    @Test
    public void insert() {
        Tree2Sorts tree = new Tree2Sorts();
        tree.insert(8);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(5);
        tree.insert(3);
        tree.outPutTree(tree.root);
        tree.getMinValue(tree.root);
        tree.getMaxValue(tree.root);
    }
}