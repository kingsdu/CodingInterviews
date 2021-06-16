package DoExercise.JianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Du
 * @Date: 2021/6/16 14:20
 * <p>
 * 测试链接：https://leetcode.com/problems/path-sum
 */
public class Offer024_二叉树是否存在某一值的路径II
{
    public static void main(String[] args)
    {
        Integer[] array = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        System.out.println(hasPathSum1(CreateBinaryTree(array), 22));
    }
    
    /*
    方法1
     */
    public static boolean isSum = false;
    
    public static boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null) return false;
        isSum = false;//如果运行多次，保证全局变量每次开始调用初始值都是false
        process(root, 0, sum);
        return isSum;
    }
    
    //检测isSum会不会有true
    public static void process(TreeNode x, int preSum, int sum)
    {
        //当x的左右节点时叶子节点，判断路径和是否有凑出sum
        if (x.left == null && x.right == null)
        {
            if (x.val + preSum == sum) isSum = true;
            return;
        }
        // x是非叶节点
        preSum += x.val;//之前的和累加
        if (x.left != null) process(x.left, preSum, sum);
        if (x.right != null) process(x.right, preSum, sum);
    }
    
    /*
    方法2
     */
    public static boolean hasPathSum1(TreeNode root, int sum)
    {
        if (root == null) return false;
        return process1(root, sum);
    }
    
    public static boolean process1(TreeNode root, int rest)
    {
        if (root.left == null && root.right == null) return root.val == rest;//到叶子节点，如果叶子节点的值和剩余的值相等，则说明匹配
        boolean ans = (root.left != null ? process1(root.left, rest - root.val) : false)
                        | (root.right != null ? process1(root.right, rest - root.val) : false);
        return ans;
    }
    
    
    public static class TreeNode
    {
        public Integer val;
        public TreeNode left;
        public TreeNode right;
        
        TreeNode(Integer val)
        {
            this.val = val;
        }
    }
    
    //=============================================帮助方法=====================================================
    public static TreeNode CreateBinaryTree(Integer[] array)
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
                    return root[0];
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
        return root[0];
    }
}
