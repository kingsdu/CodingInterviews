package DataStruct.Tree;

/**
 *
 * 二叉树的基本结构
 * 当前节点的值 + 左节点 + 右节点
 *
 */
public class BinaryTreeNode
{
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    
    public BinaryTreeNode(int val){
        this.val = val;
    }
    
}
