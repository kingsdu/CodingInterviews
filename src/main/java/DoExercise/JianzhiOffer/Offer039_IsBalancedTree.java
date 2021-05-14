package DoExercise.JianzhiOffer;

import DataStruct.MyOverride.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Offer039_IsBalancedTree
{
    
    public static void main(String[] args)
    {
        Offer039_IsBalancedTree of = new Offer039_IsBalancedTree();
        BinaryTree bi = new BinaryTree();
//        Integer[] nodes = {3,9,20,null,null,15,7};
        Integer[] nodes = {1, 2, 2, 3, 3, null, null, 4, 4};
        TreeNode[] roots = of.CreateBinaryTree(nodes);
        boolean balanced = of.isBalanced(roots[0]);
        System.out.println(balanced);
    }
    
    boolean flag = true;
    
    public boolean isBalanced(TreeNode root)
    {
        maxDepth(root);
        return flag;
    }
    
    
    public int maxDepth(TreeNode root)
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
    
    
    /**
     * 和上面的程序是一个意思，但是别人写的可读性就比我的好很多
     *
     * @param root
     * @return
     */
    public boolean isBalanced_2(TreeNode root)
    {
        return recur(root) != -1;
    }
    
    private int recur(TreeNode root)
    {
        if (root == null) return 0;
        
        int left = recur(root.left);
        if (left == -1) return -1;
        
        int right = recur(root.right);
        if (right == -1) return -1;
        
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
    
    
    /**
     * 另一种写法，表示树上所有的节点高度都<=1
     * <p>
     * 逆向思维：树中所有的节点的高度差都<=1，即可
     *
     * @param root
     * @return
     */
    public boolean isBalanced_3(TreeNode root)
    {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced_3(root.left) && isBalanced_3(root.right);
    }
    
    private int depth(TreeNode root)
    {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    
    
    public TreeNode[] CreateBinaryTree(Integer[] array)
    {
        int size = array.length;
        TreeNode[] root = new TreeNode[size];
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == null)
            {
                root[i] = null;
            } else
            {
                root[i] = new TreeNode(array[i]);
            }
        }
        Queue<TreeNode> queue = new LinkedList<>();
        if (root.length == 0)
        {
            return null;
        }
        queue.add(root[0]);
        int i = 1;
        while (i < size || !queue.isEmpty())
        {
            TreeNode curNode = queue.poll();
            //判断当前节点为空则继续出栈
            while (curNode == null)
            {
                curNode = queue.poll();
                if (queue.isEmpty() && curNode == null)//最后一个元素出栈，栈是空，但是还有元素
                {
                    return root;
                }
            }
            
            if (i < size)
            {
                curNode.left = array[i] == null ? null : root[i];
                queue.offer(curNode.left);
                i++;
            }
            
            if (i < size)
            {
                curNode.right = array[i] == null ? null : root[i];
                queue.offer(curNode.right);
                i++;
            }
        }
        return root;
    }
    
    public static class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(int val)
        {
            this.val = val;
        }
    }
    
}
