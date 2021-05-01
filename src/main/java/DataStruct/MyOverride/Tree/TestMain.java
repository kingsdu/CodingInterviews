package DataStruct.MyOverride.Tree;

public class TestMain
{
    
    public static void main(String[] args)
    {
        BinaryTree bit = new BinaryTree();
        Integer[] nodes = {3,9,20,null,null,15,7};
        TreeNode[] root = bit.CreateBinaryTree(nodes);
        bit.HighOfTree(root[0]);

    }
    
}
