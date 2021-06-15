package DoExercise.HSP_ZCY.A029_二叉树;

/**
 * @Author: Du
 * @Date: 2021/6/15 14:24
 * <p>
 * https://leetcode.com/problems/symmetric-tree
 */
public class C03_SymmetricTree
{
    public static class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    
    public static boolean isSymmetric(TreeNode root)
    {
        return isMirror(root, root);//开始时1和1互为镜面
    }
    
    public static boolean isMirror(TreeNode h1, TreeNode h2)
    {
        if (h1 == null ^ h2 == null)
        {
            return false;
        }
        if (h1 == null && h2 == null)
        {
            return true;
        }
        //对于某一个树来说：我的左要 = 你的右  我的右 要= 你的左
        return h1.val == h2.val && isMirror(h1.left, h2.right) && isMirror(h1.right, h2.left);
    }
}
