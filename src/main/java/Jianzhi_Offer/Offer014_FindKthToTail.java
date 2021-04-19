package Jianzhi_Offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 如果该链表长度小于k，请返回空。
 * <p>
 * {1,2,3,4,5},1
 * <p>
 * {5}
 */
public class Offer014_FindKthToTail
{
    
    public static ListNode head;
    
    public static void main(String[] args)
    {
        addNodeOrder(1);
        addNodeOrder(2);
        addNodeOrder(3);
        addNodeOrder(4);
        addNodeOrder(5);
        addNodeOrder(6);
        printListNode(head);
        ListNode listNode1 = FindKthToTail_1(head, 2);
        printListNode(listNode1);
        System.out.println();
        ListNode listNode2 = FindKthToTail_2(head, 2);
        printListNode(listNode2);
    }
    
    
    /**
     * 思路：
     * 1、确定链表总节点个数；
     * 2、用 总个数 - 倒数个数 + 1 = 顺着数的位数：
     * eg 链表10个数字，找倒数第3个，就是顺数（10-3+1）第8个
     * <p>
     * 函数复杂度：O(n2)
     *
     * @param pHead
     * @param k
     * @return
     */
    public static ListNode FindKthToTail_1(ListNode pHead, int k)
    {
        //判空操作要注意
        if (pHead == null)
        {
            return null;
        }
        
        ListNode node1 = pHead;
        ListNode node2 = pHead;
        int index1 = 1, index2;
        //循环n次
        while (node1.next != null)
        {
            node1 = node1.next;
            index1++;
        }
        //下标判断要注意
        if (k > index1 || k < 1)
        {
            return null;
        }
        
        index2 = index1 - k;
        //循环n-k次
        while (index2 > 0)
        {
            node2 = node2.next;
            index2--;
        }
        return node2;
    }
    
    
    /**
     *
     *
     * 大小指针/双指针，可实现功能
     *
     * 一个指针先走K步，另一个从头开始，当第一个指针走到头时，第二个指针所指的位置就是所求的位置。
     *
     * @param pHead
     * @param k
     * @return
     */
    public static ListNode FindKthToTail_2(ListNode pHead, int k)
    {
        if(pHead == null){
            return null;
        }
        int index = 0;
        ListNode first = pHead;//先走
        ListNode last = pHead;//后走
        
        while (index < k && first!=null){
            first = first.next;
            index++;
        }
    
        if (index < k) {
            return null;
        }
        
        while (first != null){
            first = first.next;
            last = last.next;
        }

        return last;
    }
    
    
    public static void addNodeOrder(int value)
    {
        ListNode newNode = new ListNode(value);
        ListNode curNode;
        
        if (head == null)
        {
            head = newNode;
            return;
        }
        
        curNode = head;
        
        while (curNode.next != null)
        {
            curNode = curNode.next;
        }
        
        curNode.next = newNode;
    }
    
    
    public static void printListNode(ListNode node)
    {
        ListNode curNode = node;
        while (curNode != null)
        {
            System.out.print(curNode.val + " ");
            curNode = curNode.next;
        }
    }
    
    
    public static class ListNode
    {
        int val;
        ListNode next = null;
        
        public ListNode(int val)
        {
            this.val = val;
        }
    }
}
