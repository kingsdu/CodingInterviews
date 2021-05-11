package JianzhiOffer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Offer058_IsSymmetrical
{
    
    
    /**
     *
     *
     * 自己写的程序，没想清楚。。。。
     * @param pRoot
     * @return
     */
    public static boolean isSymmetrical1(TreeNode pRoot)
    {
        if (pRoot != null)
        {
            if (pRoot.left != pRoot.right) return false;
            isSymmetrical1(pRoot.left);
            isSymmetrical1(pRoot.right);
        }
        return true;
    }
    
    public boolean isSame(TreeNode r1, TreeNode r2)
    {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        return r1.val == r2.val && isSame(r1.left, r2.right);
        
    }
    
    public boolean isSymmetrical2(TreeNode pRoot)
    {
        return isSame(pRoot, pRoot);
    }
    
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
