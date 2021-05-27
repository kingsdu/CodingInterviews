package DoExercise.HSP.A010_HuffmanTree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * HuffmanTree：{13, 7, 8, 3, 29, 6, 1}
 * 1、先排序：{1,3,6,7,8,13,29}
 * 2、取出根节点权值最小的两个二叉树节点
 * 3、将前面两颗二叉树根节点权值的和组成一颗新的二叉树
 * 4、再将这颗新的二叉树，以根节点的权值大小再次排序
 */
public class HuffmanTree
{
    
    public static void main(String[] args)
    {
        int tree[] = {13, 7, 8, 3, 29, 6, 1};
        TreeNode huffmanTree1 = createHuffmanTree1(tree);
        preOrder(huffmanTree1);
    }
    
    
    /**
     * 构建哈夫曼树
     *
     * @param arr
     * @return
     */
    public static TreeNode createHuffmanTree1(int[] arr)
    {
        Stack<TreeNode> nodes = new Stack<>();
        for (int val : arr)
        {
            nodes.push(new TreeNode(val));
        }
        
        while (nodes.size() > 1)
        {
            Collections.sort(nodes);
            
            TreeNode leftNode = nodes.pop();
            TreeNode rightNode = nodes.pop();
            
            TreeNode parentNode = new TreeNode(leftNode.val + rightNode.val);
            
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            
            nodes.push(parentNode);
        }
        return nodes.get(0);
    }
    
    
    /**
     * ArrayList实现，需要将Comparable<TreeNode>方法改成从小到大排序
     *
     * @param arr
     * @return
     */
    public static TreeNode createHuffmanTree2(int[] arr)
    {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        for (int val : arr)
        {
            nodes.add(new TreeNode(val));
        }
        
        while (nodes.size() > 1)
        {
            Collections.sort(nodes);
            
            TreeNode leftNode = nodes.get(0);
            TreeNode rightNode = nodes.get(1);
            
            TreeNode parentNode = new TreeNode(leftNode.val + rightNode.val);
            
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            
            nodes.add(parentNode);
        }
        return nodes.get(0);
    }
    
    //编写一个前序遍历的方法
    public static void preOrder(TreeNode root)
    {
        if (root != null)
        {
            root.preOrder();
        } else
        {
            System.out.println("是空树，不能遍历~~");
        }
    }
    
    static class TreeNode implements Comparable<TreeNode>
    {
        public TreeNode left;
        public TreeNode right;
        int val;
        
        public TreeNode(int val)
        {
            this.val = val;
        }
        
        public void preOrder()
        {
            System.out.print(this);
            if (this.left != null)
            {
                this.left.preOrder();
            }
            if (this.right != null)
            {
                this.right.preOrder();
            }
        }
        
        @Override
        public int compareTo(TreeNode o)
        {
            return o.val - this.val;//上下等价
        }
        
        @Override
        public String toString()
        {
            return val + " ";
        }
    }
    
    
}
