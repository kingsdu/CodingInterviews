package DoExercise.JianzhiOffer;

import java.util.*;

/**
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * <p>
 * 输入  {10,5,12,4,7},22  输出 [[10,5,7],[10,12]]
 * <p>
 * 输入 {10,5,12,4,7},15  输出 []
 * <p>
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/submissions/
 */
public class Offer024_二叉树中和为某一值的路径I
{
    
    public static void main(String[] args)
    {
        Integer[] array = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        List<List<Integer>> lists = pathSum(Offer000_Common.deserializeTreeNode(array), 22);
        for (List<Integer> l : lists)
        {
            for (int x : l)
            {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    
    //==================方法1：使用全局变量==================
    static LinkedList<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> list = new LinkedList();
    
    public static List<List<Integer>> pathSum(Offer000_Common.TreeNode root, int target)
    {
        recur(root, target);
        return res;
    }
    
    public static void recur(Offer000_Common.TreeNode root, int target)
    {
        if (root == null) return;//target < 0这个条件不能加，因为要保证二叉树的完全遍历，要保证同等全
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
        {
            res.add(new LinkedList<>(list));//此处必须新建，否则因为作用域，所以加入的都是N个最后一个path
        }
        recur(root.left, target);
        recur(root.right, target);
        list.removeLast();
    }
    
    //==================方法2：不使用全局变量==================
    public static List<List<Integer>> pathSum1(Offer000_Common.TreeNode root, int sum)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
        {
            return ans;
        }
        ArrayList<Integer> path = new ArrayList<>();
        process(root, path, 0, sum, ans);
        return ans;
    }
    
    public static void process(Offer000_Common.TreeNode x, List<Integer> path, int preSum, int sum, List<List<Integer>> ans)
    {
        if (x.left == null && x.right == null)
        {
            if (preSum + x.val == sum)
            {
                path.add(x.val);
                ans.add(copy(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        // x 非叶节点
        path.add(x.val);
        preSum += x.val;
        if (x.left != null)
        {
            process(x.left, path, preSum, sum, ans);
        }
        if (x.right != null)
        {
            process(x.right, path, preSum, sum, ans);
        }
        path.remove(path.size() - 1);//还原现场
    }
    
    public static List<Integer> copy(List<Integer> path)
    {
        List<Integer> ans = new ArrayList<>();
        for (Integer num : path)
        {
            ans.add(num);
        }
        return ans;
    }
    
}
