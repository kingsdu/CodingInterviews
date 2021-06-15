package DoExercise.HSP_ZCY.A029_二叉树;

/**
 * @Author: Du
 * @Date: 2021/6/15 14:06
 *
 * 二叉树的遍历
 *
 * 递归法
 * 前序遍历：根左右
 *
 * 中序遍历：左根右
 *
 * 后序遍历：左右根
 *
 *
 * 二叉树的递归序：前序，中序，后序
 * 前序：递归顺序第一次出现
 * 中序：递归顺序第二次出现
 * 后序：递归顺序第三次出现
 *
 */
public class C01_TraversalBinaryTree
{
    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        
        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos(head);
        System.out.println("========");
    }
    
    
    // 先序打印所有节点
    public static void pre(Node head)
    {
        if (head == null)
        {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }
    
    public static void in(Node head)
    {
        if (head == null)
        {
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }
    
    public static void pos(Node head)
    {
        if (head == null)
        {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }
    
    
    public static void f(Node head)
    {
        if (head == null)
        {
            return;
        }
        // 1
        f(head.left);
        // 2
        f(head.right);
        // 3
    }
    
    public static class Node
    {
        public int value;
        public Node left;
        public Node right;
        
        public Node(int v)
        {
            value = v;
        }
    }
}
