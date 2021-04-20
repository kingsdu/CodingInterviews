package DataStruct.Tree;

/**
 *
 * 二叉树的基本结构
 * 当前节点的值 + 左节点 + 右节点
 *
 */
public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int val){
        this.val = val;
    }
    
}
