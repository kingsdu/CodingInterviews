package DoExercise.HSP.A009_BinTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 实现二叉树
 * <p>
 * 前序：0137849256：左右根
 * 中序：7381904526：左根右
 * 后序：7839415620：左右根
 * <p>
 * 前序遍历：递归、非递归实现
 * 中序遍历：递归、非递归实现
 * 后序遍历：递归、非递归实现
 * 层序遍历
 */
public class BinTreeThrough
{
    
    public static void main(String[] args)
    {
        BinTreeNode[] nodes = new BinTreeNode[10];
        
        for (int i = 0; i < 10; i++)
        {
            nodes[i] = new BinTreeNode(i);
        }
        
        for (int i = 0; i < 10; i++)
        {
            if (i * 2 + 1 < 10)
            {
                nodes[i].left = nodes[i * 2 + 1];
            }
            if (i * 2 + 2 < 10)
            {
                nodes[i].right = nodes[i * 2 + 2];
            }
        }
        preOrder(nodes[0]);
        System.out.println();
//        preorderRe(nodes[0]);
//        System.out.println();
        inorderTraversal(nodes[0]);
//        midorderRe(nodes[0]);
//        System.out.println();
//        midOrder(nodes[0]);
//        bacorderRe(nodes[0]);
//        System.out.println();
        //  bacOrder(nodes[0]);
//        postorderTraversal(nodes[0]);
    }
    
    /**
     * 递归法，前序遍历，根左右
     *
     * @param node
     */
    public static void preorderRe(BinTreeNode node)
    {
        if (node != null)
        {
            System.out.print(node.val + " ");
            preorderRe(node.left);
            preorderRe(node.right);
        }
    }
    
    
    /**
     * 非递归法实现前序遍历
     *
     * @param node
     */
    public static void preOrder(BinTreeNode node)
    {
        Stack<BinTreeNode> stack = new Stack<>();
        
        while (node != null || !stack.isEmpty())
        {
            while (node != null)
            {
                System.out.print(node.val + " ");
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty())
            {
                node = stack.pop();
                node = node.right;
            }
        }
    }
    
    /**
     * 前序遍历
     * 算法逻辑：对于每一个节点，都做左右根的遍历考虑
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(BinTreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<BinTreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                //区别，先存根节点，在遍历左边是否有节点
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return list;
    }
    
    /**
     * 递归法，中序遍历，左根右
     *
     * @param node
     */
    public static void midorderRe(BinTreeNode node)
    {
        if (node != null)
        {
            midorderRe(node.left);
            System.out.print(node.val + " ");
            midorderRe(node.right);
        }
    }
    
    
    /**
     * 中序遍历，非递归算法。
     *
     * @param node
     */
    public static void midOrder(BinTreeNode node)
    {
        Stack<BinTreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty())
        {
            while (node != null)
            {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty())
            {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
        
    }
    
    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(BinTreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<BinTreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty())
        {
            if (root != null)
            {
                //区别，先看左边是否有节点
                stack.push(root);
                root = root.left;
            } else
            {
                BinTreeNode temp = stack.pop();
                list.add(temp.val);
                root = temp.right;
            }
        }
        for (Integer index :
                list)
        {
            System.out.print(index + " ");
        }
        return list;
    }
    
    
    /**
     * 递归法，后序遍历，左右根
     *
     * @param node
     */
    public static void bacorderRe(BinTreeNode node)
    {
        if (node != null)
        {
            bacorderRe(node.left);
            bacorderRe(node.right);
            System.out.print(node.val + " ");
        }
    }
    
    
    /**
     * 后续遍历的实现，难点
     *
     * @param node
     */
    public static void bacOrder(BinTreeNode node)
    {   //后序遍历非递归实现
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<BinTreeNode> stack = new Stack<BinTreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。
        
        while (node != null || !stack.empty())
        {
            while (node != null)
            {//将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(node);
                stack2.push(left);
                node = node.left;
            }
            
            while (!stack.empty() && stack2.peek() == right)
            {//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.print(stack.pop().val + " ");
            }
            
            if (!stack.empty() && stack2.peek() == left)
            {//如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                node = stack.peek().right;
            }
            
        }
    }
    
    
    /**
     * 反向推二叉树的后序遍历
     * <p>
     * 正常的后序遍历的顺序是：左右根。
     * 可以从后往前反向推，后续遍历变为：根右左。
     * 然后在利用栈和链表的属性完成代码
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(BinTreeNode root)
    {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null)
            return list;
        Stack<BinTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            BinTreeNode temp = stack.pop();
            list.addFirst(temp.val);
            if (temp.left != null)
            {
                stack.push(temp.left);
            }
            if (temp.right != null)
            {
                stack.push(temp.right);
            }
        }
        return list;
    }
    
    /**
     * 层序遍历：逐层遍历
     * BFS
     *
     * @param root
     * @return
     */
    public LinkedList<Integer> levelOrderTree(BinTreeNode root)
    {
        if (root == null) return null;
        LinkedList<Integer> linkedList = new LinkedList<>();
        LinkedList<BinTreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty())
        {
            BinTreeNode tempNode = queue.poll();
            linkedList.add(tempNode.val);
            
            if (tempNode.left != null)
            {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null)
            {
                queue.add(tempNode.right);
            }
            
        }
        return linkedList;
    }
    
    
    
    public static class BinTreeNode
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
