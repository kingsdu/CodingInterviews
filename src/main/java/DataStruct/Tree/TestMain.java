package DataStruct.Tree;

import java.util.LinkedList;

public class TestMain
{
    
    public static void main(String[] args)
    {
        BinaryTree bit = new BinaryTree();
//        BinaryTreeNode[] root = bit.CreateBinaryTree(2);
//        BinaryTreeNode rootNode = root[0];
//        bit.printResList(bit.getResultList());
//        System.out.println();
//        bit.printResList(bit.postOrderTreeNonRec(rootNode));
//        System.out.println();
//        bit.printResList(bit.levelOrderTree(rootNode));
//        System.out.println();
//        bit.printResList(bit.postOrderTreeNonRec(rootNode));
//        BinaryTreeNode node = bit.addTreeNode(rootNode, new BinaryTreeNode(10));
//        LinkedList<Integer> integers = bit.levelOrderTree(node);
//        bit.printResList(integers);
//        bit.HighOfTree(rootNode);
        Integer[] nodes = {0,1,2,null,null,null,3,4};
        BinaryTreeNode[] root = bit.CreateBinaryTree(nodes);
        bit.deleteTreeNode(root[0],new BinaryTreeNode(2));
    }
    
}
