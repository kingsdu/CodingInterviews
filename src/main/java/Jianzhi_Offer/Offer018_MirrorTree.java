package Jianzhi_Offer;

import java.util.Stack;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class Offer018_MirrorTree
{
    //记录调用次数:结果outMirrorTree_1 和 outMirrorTree_3 都递归调用了15次
    private static int index = 0;
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);//大树根节点
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        root.right = r2;
        root.left = r1;
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(5);
        r1.right = r4;
        r1.left = r3;
        TreeNode r5 = new TreeNode(6);
        TreeNode r6 = new TreeNode(7);
        r2.right = r6;
        r2.left = r5;
        
        TreeNode treeNode = outMirrorTree_4(root);
        while (treeNode != null)
        {
            System.out.println(treeNode.left);
        }
    }
    
    
    /**
     * 思路:先序遍历树,交换树的左右节点
     *
     * @param root
     * @return
     */
    public static TreeNode outMirrorTree_1(TreeNode root)
    {
        if (root == null)
        {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        outMirrorTree_1(root.left);
        outMirrorTree_1(root.right);
        return root;
    }
    
    
    /**
     * outMirrorTree_2 == outMirrorTree_1
     * 方法OK,自己写的
     *
     * @param root
     * @return
     */
    public static TreeNode outMirrorTree_2(TreeNode root)
    {
        if (root != null)
        {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            outMirrorTree_2(root.left);
            outMirrorTree_2(root.right);
        }
        return root;
    }
    
    
    /**
     * 大神思路方法
     * 比我的想的要更透彻,对递归的理解更深入
     *
     * @param root
     * @return
     */
    public static TreeNode outMirrorTree_3(TreeNode root)
    {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = outMirrorTree_3(root.right);
        root.right = outMirrorTree_3(tmp);
        return root;
    }
    
    
    /**
     * 不用递归,用栈来辅助
     * <p>
     * 思路: 用栈辅助存储每一轮需要交换左右节点的根节点,如果栈为空,则代表没有需要交换的节点了,返回root节点.
     * 细节: 先将root入栈,在操作出栈给node,操作node交换左右,不影响root的根节点指向.
     *
     * @param root
     * @return
     */
    public static TreeNode outMirrorTree_4(TreeNode root)
    {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);//先入根节点
        while (!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
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
    
}
