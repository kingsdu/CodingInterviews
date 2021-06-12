package DoExercise.JianzhiOffer;

import java.util.Stack;

public class TestDay
{
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
    
    }
    
    public static TreeNode mirrorTree(TreeNode root)
    {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        
        while (!stack.isEmpty())
        {
            TreeNode pop = stack.pop();
            if (pop.left != null)
            {
                stack.push(pop.left);
            }
            
            if (pop.right != null)
            {
                stack.push(pop.right);
            }
            
            TreeNode tmp = pop.left;
            pop.left = pop.right;
            pop.right = tmp;
        }
        return root;
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
