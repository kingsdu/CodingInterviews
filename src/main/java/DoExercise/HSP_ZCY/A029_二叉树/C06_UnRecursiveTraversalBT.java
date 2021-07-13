package DoExercise.HSP_ZCY.A029_二叉树;

import java.util.Stack;

/**
 * @Author: Du
 * @Date: 2021/7/13 12:18
 */
public class C06_UnRecursiveTraversalBT
{
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
    
    
    /**
     *
     * 辅助栈
     *
     * 1、弹出打印
     * 2、如有右，压入右
     * 3、如有左，压入左
     *
     * @param head
     */
    public static void pre(Node head)
    {
        System.out.print("pre-order: ");
        if (head != null)
        {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty())
            {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null)
                {
                    stack.push(head.right);
                }
                if (head.left != null)
                {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }
    
    
    /**
     *
     * 1 整棵树的左边界，依次入栈
     * 2 步骤1无法继续，则继续弹出右树1
     *
     * 左 头 分解
     *
     * @param head
     */
    public static void in(Node head)
    {
        System.out.print("in-order: ");
        if (head != null)
        {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null)
            {
                if (head != null)
                {
                    stack.push(head);
                    head = head.left;
                } else
                {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }
    
    
    /**
     * 辅助栈
     *
     * 1、弹出打印
     * 2、如有左，压入左
     * 3、如有右，压入右
     *
     * 头右左的逆序就是
     * 左右头
     * 就是后序
     *
     * 两个栈实现
     *
     * @param head
     */
    public static void pos1(Node head)
    {
        System.out.print("pos-order: ");
        if (head != null)
        {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty())
            {
                head = s1.pop();
                s2.push(head);
                if (head.left != null)
                {
                    s1.push(head.left);
                }
                if (head.right != null)
                {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty())
            {
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }
    
    
    /**
     *
     *
     * 一个栈实现
     *
     * @param h 没打印前，不影响处理左树，当打印后h被标记，标记左树则处理右树，如果右树也标记了，就处理自己
     */
    public static void pos2(Node h)
    {
        System.out.print("pos-order: ");
        if (h != null)
        {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty())
            {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right)//左树没处理完，处理左树
                {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right)//右树没处理完，处理右树
                {
                    stack.push(c.right);
                } else//处理自己
                {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }
    
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
        pos1(head);
        System.out.println("========");
        pos2(head);
        System.out.println("========");
    }
}
