package DoExercise.JianzhiOffer;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(hasPathSum1(Offer000_Common.deserializeTreeNode(array), 22));
    }
    
    //===================================================================================
    
    public static List<List<Integer>> pathSum(Offer000_Common.TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayList<Integer> path = new ArrayList<>();
        process(root, path, 0, sum, ans);
        return ans;
    }
    
    public static void process(Offer000_Common.TreeNode x, List<Integer> path, int preSum, int sum, List<List<Integer>> ans) {
        if (x.left == null && x.right == null) {
            if (preSum + x.val == sum) {
                path.add(x.val);
                ans.add(Offer000_Common.Copy(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        // x 非叶节点
        path.add(x.val);
        preSum += x.val;
        if (x.left != null) {
            process(x.left, path, preSum, sum, ans);
        }
        if (x.right != null) {
            process(x.right, path, preSum, sum, ans);
        }
        path.remove(path.size() - 1);
    }
    
    /*
    方法1
     */
    public static boolean isSum = false;
    
    public static boolean hasPathSum(Offer000_Common.TreeNode root, int sum)
    {
        if (root == null) return false;
        isSum = false;//如果运行多次，保证全局变量每次开始调用初始值都是false
        process(root, 0, sum);
        return isSum;
    }
    
    //检测isSum会不会有true
    public static void process(Offer000_Common.TreeNode x, int preSum, int sum)
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
    public static boolean hasPathSum1(Offer000_Common.TreeNode root, int sum)
    {
        if (root == null) return false;
        return process1(root, sum);
    }
    
    public static boolean process1(Offer000_Common.TreeNode root, int rest)
    {
        if (root.left == null && root.right == null) return root.val == rest;//到叶子节点，如果叶子节点的值和剩余的值相等，则说明匹配
        boolean ans = (root.left != null ? process1(root.left, rest - root.val) : false)
                | (root.right != null ? process1(root.right, rest - root.val) : false);
        return ans;
    }
    
    
}
