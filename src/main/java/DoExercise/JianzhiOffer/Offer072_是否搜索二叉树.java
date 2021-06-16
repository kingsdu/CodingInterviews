package DoExercise.JianzhiOffer;

/**
 * @Author: Du
 * @Date: 2021/6/16 13:54
 * <p>
 * 搜索二叉树
 * 中序遍历(左 根 右)一定是递增
 */
public class Offer072_是否搜索二叉树
{
    
    public static void main(String[] args)
    {
    
    }
    
    
    public static Info process_isFalse(TreeNode x)
    {
        if (x == null)
        {
            return null;
        }
        Info leftInfo = process_isFalse(x.left);
        Info rightInfo = process_isFalse(x.right);
        int max = x.val;
        int min = x.val;
        if (leftInfo != null)
        {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }
        if (rightInfo != null)
        {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }
        boolean isBST = true;//先默认为true，后面判断条件，只要有一次不满足，结果就是false
        
        if (leftInfo != null && !leftInfo.isBST)
        {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST)
        {
            isBST = false;
        }
        
        boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
        boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);
        if (!(leftMaxLessX && rightMinMoreX))
        {
            isBST = false;
        }
        return new Info(isBST, max, min);
    }
    
    public static Info process_isTrue(TreeNode x)
    {
        if (x == null)
        {
            return null;
        }
        Info leftInfo = process_isTrue(x.left);
        Info rightInfo = process_isTrue(x.right);
        int max = x.val;
        int min = x.val;
        //确定左树和右树的min 和 max
        if (leftInfo != null)
        {
            max = Math.max(leftInfo.max, max);//和左树比谁更大
            min = Math.min(leftInfo.min, min);//和右树比谁更小
        }
        if (rightInfo != null)
        {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }
        
        boolean isBST = false;//先为false，条件全达标才是true
        boolean leftIsBst = leftInfo == null ? true : leftInfo.isBST;
        boolean rightIsBst = rightInfo == null ? true : rightInfo.isBST;
        boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
        boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);
        if (leftIsBst && rightIsBst && leftMaxLessX && rightMinMoreX)
        {
            isBST = true;
        }
        return new Info(isBST, max, min);
    }
    
    //对于所有节点递归，每个节点需要确定的信息
    public static class Info
    {
        public boolean isBST;
        public int max;
        public int min;
        
        public Info(boolean is, int ma, int mi)
        {
            isBST = is;
            max = ma;
            min = mi;
        }
    }
    
    public static class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        
        TreeNode(int val)
        {
            this.val = val;
        }
    }
    
}
