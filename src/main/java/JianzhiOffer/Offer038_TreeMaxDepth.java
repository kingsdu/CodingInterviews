package JianzhiOffer;


import DataStruct.MyOverride.Tree.BinaryTree;
import DataStruct.MyOverride.Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Offer038_TreeMaxDepth
{
    
    
    public static void main(String[] args)
    {
        Offer038_TreeMaxDepth of = new Offer038_TreeMaxDepth();
        BinaryTree bi = new BinaryTree();
        Integer[] nodes = {3,9,20,null,null,15,7};
        TreeNode[] roots = bi.CreateBinaryTree(nodes);
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
    
}
