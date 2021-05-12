package JianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 重点：
 * LinkedList
 * 1、LinkedList具有List和stack的双重属性，可以通过add将元素变为先进后出操作；也可以通过push，将元素变为后进先出操作。
 */
public class Offer060_PrintBinTree
{
    public static void main(String[] args)
    {
        Integer arr[] = new Integer[]{8, 6, 10, 5, 7, 9, 11};
        TreeNode[] root = CreateBinaryTree(arr);
        Print_1(root[0]);
    }
    
    /**
     *
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> Print_1(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
        {
            return res;
        }
        LinkedList<TreeNode> list = new LinkedList();
        LinkedList<TreeNode> tmpList = new LinkedList();
        list.push(pRoot);
        while (!list.isEmpty())
        {
            int size = list.size();
            ArrayList<Integer> li = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = list.poll();
                li.add(node.val);
                if (node.left != null)
                {
                    tmpList.add(node.left);
                }
                if (node.right != null)
                {
                    tmpList.add(node.right);
                }
            }
            if (!tmpList.isEmpty())
            {
                list = (LinkedList) tmpList.clone();
                tmpList.clear();
            }
            res.add(li);
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
    
    public static TreeNode[] CreateBinaryTree(Integer[] array)
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
}
