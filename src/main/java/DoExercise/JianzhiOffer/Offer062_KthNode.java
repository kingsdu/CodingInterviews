package DoExercise.JianzhiOffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 * {5,3,7,2,4,6,8},3
 * {4}
 * 按结点数值大小顺序第三小结点的值为4
 */
public class Offer062_KthNode
{
    
    public static void main(String[] args)
    {
        Integer arr[] = new Integer[]{8,6,10,5,7,9,11};
        TreeNode tree = createTree(arr);
        System.out.println(KthNode(tree, 8).val);
    }
    
    
    /**
     *
     *
     * 二叉查找树的最左节点是其最小节点
     * 1、遍历至其最小节点
     * 2、按照左 根 右的顺序，遍历，遍历次数为 k 次
     *
     * @param pRoot
     * @param k
     * @return
     */
    public static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k < 0)
        {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack();
        while (pRoot != null)
        {
            stack.push(pRoot);
            pRoot = pRoot.left;
        }
        
        TreeNode resNode = null;
        for (int i = 0; i < k; i++)
        {
            if (stack.isEmpty())
            {
                return null;
            }
            resNode = stack.peek();
            if (stack.peek().right == null)
            {
                stack.pop();
            } else if (stack.peek().right != null)
            {
                TreeNode pop = stack.pop().right;
                while (pop != null)
                {
                    stack.push(pop);
                    pop = pop.left;
                }
            }
        }
        return resNode;
    }
    
    public static TreeNode createTree(Integer data[])
    {
        TreeNode root = new TreeNode(data[0]);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>()
        {{
            add(root);
        }};
        int i = 1;
        while (!queue.isEmpty() && i < data.length)
        {
            TreeNode node = queue.poll();
            if (!data[i].equals("null"))
            {
                node.left = new TreeNode(data[i]);
                queue.add(node.left);
                i++;
            }
            if (!data[i].equals("null"))
            {
                node.right = new TreeNode(data[i]);
                queue.add(node.right);
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
