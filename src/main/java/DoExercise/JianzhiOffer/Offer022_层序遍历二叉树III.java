package DoExercise.JianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Du
 * @Date: 2021/6/15 10:20
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，
 * 其他行以此类推。
 *
 * 注意这题判断奇偶，以及如何使用LinkedList特性的方式！！！
 * 注意这题判断奇偶，以及如何使用LinkedList特性的方式！！！
 * 注意这题判断奇偶，以及如何使用LinkedList特性的方式！！！
 */
public class Offer022_层序遍历二叉树III
{
    
    
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty())
        {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--)
            {
                TreeNode node = queue.poll();
                if ((res.size() & 1) == 0)//细节，注意这里判断奇偶，以及如何使用LinkedList特性的方式！！！
                    list.addLast(node.val);
                else
                    list.addFirst(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
    
    public class TreeNode
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
