package DoExercise.JianzhiOffer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 */
public class Offer017_树的子结构
{
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(8);//大树根节点
        TreeNode r1 = new TreeNode(8);
        TreeNode r2 = new TreeNode(2);
        root.right = r2;
        root.left = r1;
        TreeNode r3 = new TreeNode(9);
        TreeNode r4 = new TreeNode(7);
        r1.right = r4;
        r1.left = r3;
        
        TreeNode target = new TreeNode(8);//小树根节点
        target.left = new TreeNode(9);
        target.right = new TreeNode(7);
        
        System.out.println(isHasSubtree_1(root, target));
    }
    
    
    /**
     *
     * A是B的子树需要满足3个条件：
     * 1、AB不能同时为空
     * 2、以节点A为根节点的子树包含树B
     * 3、B是A的左子树结构 或者 B是A的右子树结构
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean isHasSubtree_1(TreeNode A, TreeNode B)
    {
        return (A != null && B != null) && (recur(A, B)
                || isHasSubtree_1(A.left, B) || isHasSubtree_1(A.right, B));
    }
    
    /**
     * 以节点A为根节点的子树包含树B
     *
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean recur(TreeNode A, TreeNode B)
    {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
    
    /**
     * 对 isHasSubtree_1 的解释
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean isHasSubtree_2(TreeNode root1, TreeNode root2)
    {
        if (root1 == null || root2 == null) return false;
        boolean result = false;
        if (root1.val == root2.val)
        {
            result = isHasSubtree_2(root1, root2);
        }
        if (!result) result = isHasSubtree_2(root1.left, root2);
        if (!result) result = isHasSubtree_2(root1.right, root2);
        return result;
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
