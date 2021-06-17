package DoExercise.JianzhiOffer;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Offer039_平衡二叉树
{
    
    public static void main(String[] args)
    {
        Integer[] nodes = {1, 2, 2, 3, 3, null, null, 4, 4};
        Offer000_Common.TreeNode roots = Offer000_Common.deserializeTreeNode(nodes);
        boolean balanced = isBalanced(roots);
        System.out.println(balanced);
    }
    
    //==============================左程云讲的方法=========================================
    public static boolean isBalanced_ZCY(Offer000_Common.TreeNode root)
    {
        return process(root).isBalanced;
    }
    
    public static Info process(Offer000_Common.TreeNode root)
    {
        if (root == null) return new Info(true, 0);//初始isBalanced是true
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new Info(isBalanced, height);
    }
    
    //将需要计算的信息存放在一个Info中
    public static class Info
    {
        public boolean isBalanced;
        public int height;
        
        public Info(boolean i, int h)
        {
            isBalanced = i;
            height = h;
        }
    }
    
    //==================================K神的方法=====================================
    static boolean flag = true;
    
    public static boolean isBalanced(Offer000_Common.TreeNode root)
    {
        maxDepth(root);
        return flag;
    }
    
    public static int maxDepth(Offer000_Common.TreeNode root)
    {
        int leftTree, rightTree;
        if (root == null)
        {
            return 0;
        } else
        {
            leftTree = maxDepth(root.left);
            rightTree = maxDepth(root.right);
            if (Math.abs(leftTree - rightTree) > 1)
            {
                flag = false;
            }
            if (leftTree < rightTree)
            {
                return rightTree + 1;
            } else
            {
                return leftTree + 1;
            }
        }
    }
    
    //=======================================================================================================
    public static boolean isBalanced_2(Offer000_Common.TreeNode root)
    {
        return recur(root) != -1;
    }
    
    private static int recur(Offer000_Common.TreeNode root)
    {
        if (root == null) return 0;
        
        int left = recur(root.left);
        if (left == -1) return -1;
        
        int right = recur(root.right);
        if (right == -1) return -1;
        
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
    
    //===============================================================================================
    public static boolean isBalanced_3(Offer000_Common.TreeNode root)
    {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced_3(root.left) && isBalanced_3(root.right);
    }
    
    private static int depth(Offer000_Common.TreeNode root)
    {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    
    
    
}
