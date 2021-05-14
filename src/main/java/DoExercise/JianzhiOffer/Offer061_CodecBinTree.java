package DoExercise.JianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class Offer061_CodecBinTree
{
    static StringBuilder preOrderStr = new StringBuilder(), inOrderStr = new StringBuilder();
    
    
    public static void main(String[] args)
    {
        Integer arr[] = new Integer[]{5, 4, null, 3, null, 2};
        TreeNode root = CreateBinaryTree(arr);
        /**
         *
         * 逻辑1 获取前序和中序遍历，再重建二叉树
         * serialize_1(treeNodes[0]);
         * TreeNode treeNode = deserialize_1(preOrderStr.toString() + "_" + inOrderStr.toString());
         *
         * preOrder(treeNode);
         */
        String s = serialize_2(root);
        TreeNode node = deserialize_2(s);
        System.out.println(node);
    }
    
    
    public static String serialize_2(TreeNode root)
    {
        if (root == null)
        {
            return null;
        }
        
        LinkedList<TreeNode> list = new LinkedList<>();
        StringBuilder sbr = new StringBuilder();
        list.add(root);
        
        while (!list.isEmpty())
        {
            TreeNode node = list.poll();
            if (node != null)
            {
                sbr.append(node.val + ",");
                list.add(node.left);
                list.add(node.right);
            } else sbr.append("null,");
        }
        sbr.deleteCharAt(sbr.length() - 1);
        return sbr.toString();
    }
    
    
    public static TreeNode deserialize_2(String data)
    {
        if (data == null || data.length() == 0)
        {
            return null;
        }
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>()
        {{
            add(root);
        }};
        int i = 1;
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null"))
            {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null"))
            {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
    
    
    /**
     * 序列化：把二叉树转化为数组
     *
     * @param root
     * @return
     */
    public static String serialize_1(TreeNode root)
    {
        if (root == null || (root.left == null && root.right == null))
        {
            return String.valueOf(root.val) == null ? null : String.valueOf(root.val);
        }
        preOrder(root);
        inOrder(root);
        
        return preOrderStr.toString();
    }
    
    
    public static void preOrder(TreeNode root)
    {
        if (root != null)
        {
            preOrderStr.append(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    public static void inOrder(TreeNode root)
    {
        if (root != null)
        {
            inOrder(root.left);
            inOrderStr.append(root.val);
            inOrder(root.right);
        }
    }
    
    /**
     * 反序列化：数组转化成二叉树
     *
     * @param data
     * @return
     */
    public static TreeNode deserialize_1(String data)
    {
        String[] s = data.split("_");
        return reConstructTree(s[0], s[1]);
    }
    
    public static TreeNode reConstructTree(String preOrder, String inOrder)
    {
        if (preOrder.length() == 0 || inOrder.length() == 0)
        {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(String.valueOf(preOrder.charAt(0))));
        for (int i = 0; i < inOrder.length(); i++)
        {
            if (preOrder.charAt(0) == inOrder.charAt(i))
            {
                node.left = reConstructTree(preOrder.substring(1, i + 1), inOrder.substring(0, i));
                node.right = reConstructTree(preOrder.substring(i + 1), inOrder.substring(i + 1));
            }
        }
        return node;
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
