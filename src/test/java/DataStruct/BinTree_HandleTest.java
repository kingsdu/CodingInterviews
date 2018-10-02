package DataStruct;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinTree_HandleTest {

    @Test
    public void insertNode() {

    }

    @Test
    public void deleteNode() {
        BinTree_Handle binTree_handle = new BinTree_Handle(50);

        binTree_handle.insertNode(25);
        binTree_handle.insertNode(75);
        binTree_handle.insertNode(12);
        binTree_handle.insertNode(37);
        binTree_handle.insertNode(43);
        binTree_handle.insertNode(30);
        binTree_handle.insertNode(33);
        binTree_handle.insertNode(41);
        binTree_handle.insertNode(40);
        binTree_handle.insertNode(39);
        binTree_handle.insertNode(87);
        binTree_handle.insertNode(93);
        binTree_handle.insertNode(97);

        binTree_handle.deleteNode(37);
    }
}