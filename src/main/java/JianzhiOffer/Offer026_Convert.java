package JianzhiOffer;

/**
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 性质：二叉搜索树的中序遍历为递增序列 。
 *
 * 1、二叉搜索树的中序遍历为递增序列 。
 * 2、构建相邻节点的引用关系时，设前驱节点为pre 和 当前节点为 cur，应该构建 pre.right = cur 和 cur.left = pre
 * 3、设头节点为 head、尾节点为 pre，应该构建 head.left = pre 和 pre.left = head;
 *
 */

public class Offer026_Convert
{
    
    TreeNode pre,head;
    
    public static void main(String[] args)
    {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        
        Offer026_Convert oc = new Offer026_Convert();
        TreeNode treeNode = oc.Convert_1(node1);
        while (treeNode!=null){
            System.out.println(treeNode.val);
            treeNode = treeNode.left;
        }
    }
    
    
    public TreeNode Convert_1(TreeNode pRootOfTree)
    {
        if(pRootOfTree == null){
            return null;
        }
        
        dfsRecur(pRootOfTree);
        //所有顺序排好后，首位节点呼唤指向
        head.left = pre;
        pre.right = head;
        return head;
    }
    
    
    /**
     * DFS----Depth First Search
     *
     * @param cur
     */
    private void dfsRecur(TreeNode cur){
        if(cur == null) return;
        dfsRecur(cur.left);
        if(pre != null){
            pre.right = cur;
        }
        else{
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfsRecur(cur.right);
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
