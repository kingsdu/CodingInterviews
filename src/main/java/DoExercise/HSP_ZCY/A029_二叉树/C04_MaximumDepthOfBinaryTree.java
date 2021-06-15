package DoExercise.HSP_ZCY.A029_二叉树;

/**
 * @Author: Du
 * @Date: 2021/6/15 14:28
 * <p>
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 */
public class C04_MaximumDepthOfBinaryTree
{
    
    public static class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    
    // 以root为头的树，最大高度是多少返回！
    public static int maxDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
}
