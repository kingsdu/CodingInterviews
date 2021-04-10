package DataStruct.Tree;

import java.util.LinkedList;

public class TestMain
{
    
    public static void main(String[] args)
    {
        BinaryTree bit = new BinaryTree();
        BinaryTreeNode[] root = bit.getBinaryNode(10);
        BinaryTreeNode rootNode = root[1];
//        bit.printResList(bit.getResultList());
//        System.out.println();
//        bit.printResList(bit.postOrderTreeNonRec(rootNode));
//        System.out.println();
//        bit.printResList(bit.levelOrderTree(rootNode));
//        System.out.println();
//        bit.printResList(bit.postOrderTreeNonRec(rootNode));
        BinaryTreeNode node = bit.addTreeNode(rootNode, new BinaryTreeNode(10));
        LinkedList<Integer> integers = bit.levelOrderTree(node);
        bit.printResList(integers);
        
    }
    
}
