package JianzhiOffer;

import java.util.ArrayList;

/**
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
 *
 * 问题：第一遍没读懂：同时包含指向父结点的next指针。
 *
 * 思路:
 * 1、找到根节点，中序遍历并按顺序存入到数组中，遍历数组，找到节点的下一个节点
 * 2、https://blog.nowcoder.net/n/37b2e6170ffb4acaa27f67f88b1b1922?f=comment
 */
public class Offer057_GetNext
{
    static ArrayList<TreeLinkNode> ss = new ArrayList<>();
    
    
    public static void main(String[] args)
    {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n8 = new TreeLinkNode(8);
        TreeLinkNode n9 = new TreeLinkNode(9);
        TreeLinkNode n10 = new TreeLinkNode(10);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        n5.left = n10;
        n1.next = null;
        n2.next = n1;
        n3.next = n1;
        n4.next = n2;
        n5.next = n2;
        n6.next = n3;
        n7.next = n3;
        n8.next = n4;
        n9.next = n4;
        n10.next = n5;
        System.out.println(GetNext_1(n4).val);
    }
    
    public static TreeLinkNode GetNext_1(TreeLinkNode pNode)
    {
        TreeLinkNode findNode = pNode;
        while (pNode.next != null)
        {
            pNode = pNode.next;
        }
        minOrder(pNode);
        for (int i = 0; i < ss.size(); i++)
        {
            if (ss.get(i) == findNode)
            {
                return i == ss.size() - 1 ? null : ss.get(i + 1);//最后一个节点，没有下一个节点
            }
        }
        return null;
    }
    
    
    public static void minOrder(TreeLinkNode pNode)
    {
        if (pNode != null)
        {
            minOrder(pNode.left);
            ss.add(pNode);
            minOrder(pNode.right);
        }
    }
    
    public static class TreeLinkNode
    {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
        
        TreeLinkNode(int val)
        {
            this.val = val;
        }
    }
    
}
