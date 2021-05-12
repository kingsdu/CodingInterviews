package JianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * {8,6,10,5,7,9,11}
 * [[8],[10,6],[5,7,9,11]]
 *
 */
public class Offer059_PrintZHI
{
    public static void main(String[] args)
    {
        Integer arr[] = new Integer[]{8, 6, 10, 5, 7, 9, 11};
        TreeNode[] root = CreateBinaryTree(arr);
        Print_1(root[0]);
    }
    
    public static ArrayList<ArrayList<Integer>> Print_1(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
        {
            return res;
        }
        ArrayList<Integer> tmp = null;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> tmpStack = new Stack<>();
        stack.push(pRoot);
        boolean flag = true;
        while (!stack.isEmpty())
        {
            int size = stack.size();
            tmp = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = stack.pop();
                tmp.add(node.val);
                if (flag)
                {
                    if (node.left != null)
                    {
                        tmpStack.push(node.left);
                    }
                    if (node.right != null)
                    {
                        tmpStack.push(node.right);
                    }
                } else
                {
                    if (node.right != null)
                    {
                        tmpStack.push(node.right);
                    }
                    if (node.left != null)
                    {
                        tmpStack.push(node.left);
                    }
                }
            }
            res.add(tmp);
            flag = !flag;
            if (!tmpStack.isEmpty())
            {
                stack = (Stack) tmpStack.clone();
                tmpStack.clear();
            }
        }
        return res;
    }
    
    
    /**
     *
     * 这个思路比我的思路清晰很多
     *
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> Print_2(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(pRoot);
        Stack<TreeNode> stack2 = new Stack<>();
        while (!stack1.isEmpty() || !stack2.isEmpty())
        {
            ArrayList<Integer> tmp = new ArrayList<>();
            if (!stack1.isEmpty())
            {
                while (!stack1.isEmpty())
                {
                    TreeNode p = stack1.pop();
                    tmp.add(p.val);
                    if (p.left != null)
                    {
                        stack2.add(p.left);
                    }
                    if (p.right != null)
                    {
                        stack2.add(p.right);
                    }
                }
            } else
            {
                while (!stack2.isEmpty())
                {
                    TreeNode p = stack2.pop();
                    tmp.add(p.val);
                    if (p.right != null)
                    {
                        stack1.add(p.right);
                    }
                    if (p.left != null)
                    {
                        stack1.add(p.left);
                    }
                }
            }
            res.add(tmp);
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
