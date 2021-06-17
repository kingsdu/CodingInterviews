package DoExercise.JianzhiOffer;

/**
 * @Author: Du
 * @Date: 2021/6/17 9:54
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
public class Offer073_二叉搜索树与双向链表
{
    //====================================K=============================================
    //二叉搜索树的中序遍历是顺序递增的
    
    static Node pre, head;
    
    public static Node treeToDoublyList(Node root)
    {
        if (root == null) return null;
        dfs(root);
        head.left = pre;//变成循环链表
        pre.right = head;//变成循环链表
        return head;
    }
    
    //变成双向链表
    public static void dfs(Node cur)
    {
        if (cur == null) return;
        dfs(cur.left);
        //左
        if (pre != null)
        {
            pre.right = cur;
        } else
        {
            head = cur;//为空直接为head
        }
        //根
        cur.left = pre;
        pre = cur;//注意此处双向链表的操作
        dfs(cur.right);//右
    }
    
    
    class Node
    {
        public int val;
        public Node left;
        public Node right;
        
        public Node()
        {
        }
        
        public Node(int _val)
        {
            val = _val;
        }
        
        public Node(int _val, Node _left, Node _right)
        {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
