package DoExercise.JianzhiOffer;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
public class TestDay
{
    
    
    public static void main(String[] args)
    {
        int[] arr = {3, 9, 20, 15, 7};
        int i = 1;
        int[] ints = Arrays.copyOfRange(arr, 1, i + 1);
        Arrays.stream(ints).forEach(e -> System.out.print(e + " "));
        System.out.println();
        int[] ints1 = Arrays.copyOfRange(arr, i + 1, arr.length);
        Arrays.stream(ints1).forEach(e -> System.out.print(e + " "));
    }
    
 
    public TreeNode reConstructTree(int preorder[], int inorder[])
    {
        if (preorder.length == 0 || inorder.length == 0)
        {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++)
        {
            if (inorder[i] == preorder[0])
            {
                root.left = reConstructTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = reConstructTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
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
