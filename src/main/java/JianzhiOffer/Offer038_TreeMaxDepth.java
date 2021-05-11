package JianzhiOffer;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Offer038_TreeMaxDepth
{
    
    
    public static void main(String[] args)
    {
        Offer038_TreeMaxDepth of = new Offer038_TreeMaxDepth();
        Integer[] nodes = {3,9,20,null,null,15,7};
        TreeNode[] roots = of.CreateBinaryTree(nodes);
        int i = of.maxDepth_3(roots[0]);
        System.out.println(i);
    }
    
    
    public int maxDepth_1(TreeNode root)
    {
        int leftTree, rightTree;
        if (root == null)
        {
            return 0;
        } else
        {
            leftTree = maxDepth_1(root.left);
            rightTree = maxDepth_1(root.right);
            
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
     *
     * DFS 深度优先
     *
     * @param root
     * @return
     */
    public int maxDepth_2(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        return Math.max(maxDepth_2(root.left), maxDepth_2(root.right)) + 1;
    }
    
    /**
     *
     * 层序遍历计算深度
     *
     * @param root
     * @return
     */
    public int maxDepth_3(TreeNode root)
    {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<TreeNode> tmp;
        int res = 0;
        while (!queue.isEmpty())
        {
            tmp = new LinkedList<>();
            for (TreeNode node : queue)
            {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp;//queue指向下一层
            res++;
        }
        return res;
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
