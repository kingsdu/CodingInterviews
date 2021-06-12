package DoExercise.JianzhiOffer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Offer058_对称的二叉树
{
    
    public static void main(String[] args)
    {
    
    }
    
    
    /**
     *
     * 学习别人的思路1
     *
     * @param pRoot
     * @return
     */
    public boolean isSymmetrical(TreeNode pRoot)
    {
        return pRoot == null ? true : isSame(pRoot.left, pRoot.right);
    }
    
    public boolean isSame(TreeNode r1, TreeNode r2)
    {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null || r1.val != r2.val) return false;
        return isSame(r1.left, r2.right) && isSame(r1.right, r2.left);
    }
    
    /**
     *
     * 学习别人的思路2
     *
     * @param pRoot
     * @return
     */
    public boolean isSymmetrical3(TreeNode pRoot)
    {
        return pRoot == null || jude(pRoot.left, pRoot.right);
    }
    
    public boolean jude(TreeNode node1, TreeNode node2)
    {
        if (node1 == null && node2 == null)
        {
            return true;
        } else if (node1 == null || node2 == null)
        {
            return false;
        }
        
        if (node1.val != node2.val)
        {
            return false;
        } else
        {
            return jude(node1.left, node2.right) && jude(node1.right, node2.left);
        }
    }
    

    
    public static class TreeNode
    {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        
        public TreeNode(int val)
        {
            this.val = val;
        }
    }
}
