package DoExercise.HSP_ZCY.A029_二叉树;

/**
 * @Author: Du
 * @Date: 2021/6/15 14:16
 *
 * 两颗 二叉树是否相等（对称）
 *
 * https://leetcode.com/problems/same-tree
 */
public class C02_SameTree
{
    
    public static class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    
    public static boolean isSameTree(TreeNode p, TreeNode q)
    {
        //p == null || q == null 不是同时为空就不行。这个地方的判断和位图除法中最后取符号的逻辑是一样的
        if (p == null ^ q == null)
        {
            return false;
        }
        if (p == null && q == null)
        {
            return true;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
}
