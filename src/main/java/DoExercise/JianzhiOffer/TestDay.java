package DoExercise.JianzhiOffer;

public class TestDay
{
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
    
    }
    
    public static boolean isSubStructure(TreeNode A, TreeNode B)
    {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    
    public static boolean recur(TreeNode A, TreeNode B)
    {
        if (B == null)
        {
            return true;
        }
        
        if (A == null || A.val != B.val)
        {
            return false;
        }
        
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
    
    
    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x)
        {
            val = x;
        }
    }
}
