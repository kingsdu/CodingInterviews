package JianzhiOffer;

import java.util.*;

/**
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * <p>
 * 输入  {10,5,12,4,7},22  输出 [[10,5,7],[10,12]]
 * <p>
 * 输入 {10,5,12,4,7},15  输出 []
 */
public class Offer024_FindPath
{
    
    
    public static void main(String[] args)
    {
        Integer[] array = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        Offer024_FindPath of = new Offer024_FindPath();
        TreeNode[] root = of.CreateBinaryTree(array);
        of.FindPath_3(root[0], 22);
    }
    
    
    ArrayList<ArrayList<Integer>> reslist = new ArrayList<>();
    ArrayList<Integer> tmpList = new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> FindPath_4(TreeNode root, int target)
    {
        if (root == null || root.val > target)
        {
            return null;
        }
        
        tmpList.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
        {
            reslist.add(new ArrayList<Integer>(tmpList));
        }
        FindPath_4(root.left, target);
        FindPath_4(root.right, target);
        tmpList.remove(tmpList.size() - 1);
        return reslist;
    }
    
    
    /**
     * 我的思路
     * 开始想的非递归，结果做不出来
     *
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath_1(TreeNode root, int target)
    {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        ArrayList<Integer> tmpList = new ArrayList<>();
        int sum = 0;
        if (null == root)
        {
            return resList;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (!stack.isEmpty() || curNode != null)
        {
            while (curNode != null)
            {
                int val = curNode.val;
                sum += val;
                tmpList.add(val);
                stack.push(curNode);
                curNode = curNode.left;
                if (sum == target)
                {
                    resList.add(tmpList);
                    sum = 0;
                    stack.pop();
                    tmpList.remove(tmpList.size() - 1);
                    curNode = stack.pop().right;
                } else if (sum > target)
                {
                    stack.pop();
                    tmpList.remove(tmpList.size() - 1);
                    sum -= val;
                    curNode = stack.pop().right;
                }
            }
            if (!tmpList.isEmpty())
            {
                tmpList.remove(tmpList.size() - 1);
                sum -= curNode.val;
            }
            curNode = stack.pop().right;
        }
        return resList;
    }
    
    
    /**
     * 非递归方式比递归的方式，提前出栈了一次，导致效果不对。
     * 4
     * 5  6
     * 递归可以 564
     * 非递归   546
     * <p>
     * 所以这个方法暂时没想到好的解决方法
     *
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath_2(TreeNode root, int target)
    {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        ArrayList<Integer> tmpList = new ArrayList<>();
        if (null == root)
        {
            return resList;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (!stack.isEmpty() || curNode != null)
        {
            int num = target;
            while (curNode != null)
            {
                num -= curNode.val;
                tmpList.add(curNode.val);
                stack.push(curNode);
                if (num == 0 && curNode.left == null && curNode.right == null)
                {
                    resList.add(new ArrayList<>(tmpList));
                }
                curNode = curNode.left;
            }
            curNode = stack.pop().right;
            tmpList.remove(tmpList.size() - 1);
        }
        return resList;
    }
    
    
    /**
     * 大神的方法
     */
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> FindPath_3(TreeNode root, int target)
    {
        if (root == null || root.val > target)
        {
            return list;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
        {
            list.add(new ArrayList<>(path));//此处必须新建，否则因为作用域，所以加入的都是N个最后一个path
        }
        FindPath_3(root.left, target);
        FindPath_3(root.right, target);
        path.remove(path.size() - 1);
        return list;
    }
    
    
    /**
     * 根据目标数组中的数字，生成对应的二叉树
     * <p>
     * 012null3null567
     * <p>
     * 0
     * 1  2
     * n 3 n 5
     * 6 7
     *
     * @param array
     * @return
     */
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
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        
        public TreeNode(int val)
        {
            this.val = val;
        }
    }
    
}
