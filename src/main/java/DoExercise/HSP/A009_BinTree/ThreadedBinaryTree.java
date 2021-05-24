package DoExercise.HSP.A009_BinTree;

/**
 * 线索二叉树
 * 1、优势：
 * (1)利用线索二叉树进行中序遍历时，不必采用堆栈处理，速度较一般二叉树的遍历速度快，且节约存储空间。
 * (2)任意一个结点都能直接找到它的前驱和后继结点。
 * 2、不足
 * (1)结点的插入和删除麻烦，且速度也较慢。
 * (2)线索子树不能共用。
 */
public class ThreadedBinaryTree
{
    
    static ThreadedNode root;
    static ThreadedNode pre = null;
    
    
    public static void main(String[] args)
    {
        root = new ThreadedNode(1);
        ThreadedNode t1 = new ThreadedNode(3);
        ThreadedNode t2 = new ThreadedNode(6);
        ThreadedNode t3 = new ThreadedNode(8);
        ThreadedNode t4 = new ThreadedNode(10);
        ThreadedNode t5 = new ThreadedNode(14);
        
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
    
        threadedNodesInOrder(root);
//        threadedNodesPostOrder(root);
        threadedListInOrder();
    }
    
    
    /**
     *
     * 中序遍历线索
     *
     * @param node
     */
    public static void threadedNodesInOrder(ThreadedNode node)
    {
        if (node == null)
        {
            return;
        }
        
        threadedNodesInOrder(node.left);
        if (node.left == null)
        {
            node.left = pre;
            node.leftType = 1;
        }
        
        if (pre != null && pre.right == null)
        {
            pre.right = node;
            pre.rightType = 1;
        }
        pre = node;
        threadedNodesInOrder(node.right);
    }
    
    
    /**
     * 中序遍历线索化二叉树
     * 8 4 9 2 10 5 11 1 6 3 7
     */
    public static void threadedListInOrder()
    {
        ThreadedNode node = root;
        while (node != null)
        {
            while (node.leftType == 0)
            {
                node = node.left;
            }
            System.out.print(node.val + " ");
            
            while (node.rightType == 1)//必须是1的才可以输出
            {
                node = node.right;
                System.out.print(node.val + " ");
            }
            node = node.right;//否则就继续向下遍历
        }
    }
    
    
    /**
     *
     * 后序遍历线索二叉树
     *
     * @param node
     */
    public static void threadedNodesPostOrder(ThreadedNode node)
    {
        if (node == null)
        {
            return;
        }
        // 造成中序和后序的区别的原因：
        // 假设当前是3，中序是在3时开始处理，后序是里面处理3的右节点
        threadedNodesPostOrder(node.left);
        threadedNodesPostOrder(node.right);
        if (node.left == null)
        {
            node.left = pre;
            node.leftType = 1;
        }
        
        if (pre != null && pre.right == null)
        {
            pre.right = node;
            pre.rightType = 1;
        }
        pre = node;
    }
    
    
    /**
     *
     * 线索二叉树后序遍历
     *
     */
    public static void threadedListPostOrder()
    {
    
    }
    
   
    
    static class ThreadedNode
    {
        public int val;
        public ThreadedNode left; //默认null
        public ThreadedNode right; //默认null
        public int leftType;//leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
        public int rightType;//rightType == 0 表示指向是右子树, 如果 1 表示指向后继结点
        
        ThreadedNode(int val)
        {
            this.val = val;
        }
    }
}
