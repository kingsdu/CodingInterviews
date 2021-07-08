package DoExercise.JianzhiOffer;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class Offer017_树的子结构
{
    
    public static void main(String[] args)
    {
        Offer000_Common.TreeNode root = new Offer000_Common.TreeNode(8);//大树根节点
        Offer000_Common.TreeNode r1 = new Offer000_Common.TreeNode(8);
        Offer000_Common.TreeNode r2 = new Offer000_Common.TreeNode(2);
        root.right = r2;
        root.left = r1;
        Offer000_Common.TreeNode r3 = new Offer000_Common.TreeNode(9);
        Offer000_Common.TreeNode r4 = new Offer000_Common.TreeNode(7);
        r1.right = r4;
        r1.left = r3;
        
        Offer000_Common.TreeNode target = new Offer000_Common.TreeNode(8);//小树根节点
        target.left = new Offer000_Common.TreeNode(9);
        target.right = new Offer000_Common.TreeNode(7);
        
        System.out.println(isHasSubtree_1(root, target));
    }
    
    
    /**
     * A是B的子树需要满足3个条件：
     * 1、AB不能同时为空
     * 2、以节点A为根节点的子树包含树B
     * 3、B是A的左子树结构 或者 B是A的右子树结构
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean isHasSubtree_1(Offer000_Common.TreeNode A, Offer000_Common.TreeNode B)
    {
        return (A != null && B != null) && (recur(A, B)
                || isHasSubtree_1(A.left, B) || isHasSubtree_1(A.right, B));
    }
    
    /**
     * 以节点A为根节点的子树包含树B
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean recur(Offer000_Common.TreeNode A, Offer000_Common.TreeNode B)
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
    public static boolean isHasSubtree_2(Offer000_Common.TreeNode root1, Offer000_Common.TreeNode root2)
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
    
    
}
