package JianzhiOffer;


import java.util.Arrays;

/***
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 1、根据当前前序序列的第一个结点确定根结点，为 1
 * 2、找到 1 在中序遍历序列中的位置，为 in[3]
 * 3、切割左右子树，则 in[3] 前面的为左子树， in[3] 后面的为右子树
 * 4、则切割后的左子树前序序列为：{2,4,7}，切割后的左子树中序序列为：{4,7,2}；切割后的右子树前序序列为：{3,5,6,8}，切割后的右子树中序序列为：{5,3,8,6}
 * 5、对子树分别使用同样的方法分解
 *
 */
public class Offer004_ReConstructBinaryTree
{
    
    public static void main(String[] args)
    {
        Offer004_ReConstructBinaryTree binaryTreeTra = new Offer004_ReConstructBinaryTree();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8}, in = {4, 7, 2, 1, 5, 3, 8, 6};
        BinTreeNode binTreeNode = binaryTreeTra.reConstructBinaryTree(pre, in);
        binaryTreeTra.preOrder(binTreeNode);
        System.out.println();
        binaryTreeTra.midOrder(binTreeNode);
        System.out.println();
        binaryTreeTra.tailOrder(binTreeNode);
    }
    
    
    public BinTreeNode reConstructBinaryTree(int[] pre, int[] in)
    {
        if (pre.length == 0 || in.length == 0)
        {
            return null;
        }
        BinTreeNode root = new BinTreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < in.length; i++)
        {
            if (in[i] == pre[0])
            {
                // 左子树，注意 copyOfRange 函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }
    
    
    public void preOrder(BinTreeNode node)
    {
        if (node != null)
        {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    public void midOrder(BinTreeNode node)
    {
        if (node != null)
        {
            midOrder(node.left);
            System.out.print(node.val + " ");
            midOrder(node.right);
        }
    }
    
    public void tailOrder(BinTreeNode node)
    {
        if (node != null)
        {
            tailOrder(node.left);
            tailOrder(node.right);
            System.out.print(node.val + " ");
        }
    }
    
    
    public class BinTreeNode
    {
        
        BinTreeNode left;
        BinTreeNode right;
        int val;
        
        BinTreeNode(int val)
        {
            this.val = val;
        }
    }
    
}


/***
 *
 * 1、copyOfRange(X,from,to)，from下标是包含,to的下标是排他。(from,to];
 * 2、写程序重点是搞清楚算法逻辑；
 *
 */
