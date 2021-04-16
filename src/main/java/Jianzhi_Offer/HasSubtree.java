package Jianzhi_Offer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 */
public class HasSubtree
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
     * 自己没思考出来，原因：（1）不理解母树 和 子树 应该以怎样的结果生成，最后看了解析是层序遍历。
     * （2）母树 和 子树之间的关系是怎样的，怎样才算母树包含了子树。
     * <p>
     * 看了解析后有了思路：这个题要分为2步骤：
     * 1、在母树中按照先序遍历的顺序寻找，是否存在子树的根节点
     * 2、若存在，则母树和子树同步继续按照前序遍历的顺序遍历其节点，只要相等就继续遍历。
     * 3、当子树遍历节点遍历完了，就返回TURE，否则就是FALSE
     * <p>
     * 这个程序的思路是我想要达到的境界
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean isHasSubtree_1(TreeNode root1, TreeNode root2)
    {
        return (root1 != null && root2 != null) && (recur(root1, root2)
                || isHasSubtree_1(root1.left, root2) || isHasSubtree_1(root1.right, root2));
    }
    
    /**
     * 在判断出母树某个节点 和 子树根节点相同的情况下
     * 递归：前序遍历子树，母树的节点是否相等
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean recur(TreeNode root1, TreeNode root2)
    {
        if (root2 == null) return true;
        if (root1 == null || root1.val != root2.val) return false;
        return recur(root1.left, root2.left) && recur(root1.right, root2.right);
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
