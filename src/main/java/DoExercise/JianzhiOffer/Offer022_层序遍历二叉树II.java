package DoExercise.JianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Du
 * @Date: 2021/6/15 10:02
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 要求一层节点放在一个ArrayList中
 *
 * <p>
 * 有2个细节要注意
 * 1 因为题目要求对树的节点进行分层存储，所以int i = queue.size()，固定了每一层的节点个数，详细见for循环的执行顺序
 * 2 new了一个List<Integer> list，所以对应的List<List<Integer>> res，不能写成List<ArrayList<Integer>> res
 *
 *
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
public class Offer022_层序遍历二叉树II
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);//大树根节点
        TreeNode r1 = new TreeNode(9);
        TreeNode r2 = new TreeNode(20);
        root.right = r2;
        root.left = r1;
        TreeNode r3 = new TreeNode(15);
        TreeNode r4 = new TreeNode(7);
        r2.right = r4;
        r2.left = r3;
    
        List<List<Integer>> lists = levelOrder(root);
    
        for (List<Integer> x :
                lists)
        {
           for(int n : x){
               System.out.print(n+" ");
           }
            System.out.println();
        }
    }
    
    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--)
            {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
    
    public static List<List<Integer>> levelOrder_reverse(TreeNode root)
    {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--)
            {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.addFirst(list);//注意这个方法可以这样用，不是此题的解答
        }
        return res;
    }
    
    public static class TreeNode
    {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        
        public TreeNode(int val)
        {
            this.val = val;
        }
    }
}
