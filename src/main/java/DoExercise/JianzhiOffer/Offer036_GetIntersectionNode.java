package DoExercise.JianzhiOffer;


/**
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * listA = [4,1,8,4,5], listB = [5,0,1,8,4,5]
 * intersectVal = 1
 * <p>
 * listA = [0,9,1,2,4], listB = [3,2,4]
 * intersectVal = 2
 * <p>
 * 问题：
 * 1、如何定义第一个公共节点？
 * 2、这个题目难点在于，比较的是ListNode的地址值。
 *
 */
public class Offer036_GetIntersectionNode
{
    
    public static void main(String[] args)
    {
        Offer036_GetIntersectionNode of = new Offer036_GetIntersectionNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
    
        // first
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node6.next = node7;
        // second
        node4.next = node5;
        node5.next = node6;
        
    
        ListNode intersectionNode = of.getIntersectionNode_1(node1, node4);
        System.out.println(intersectionNode.val);
    }
    
    
    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB)
    {
        ListNode A = headA, B = headB;
        while (A != B)
        {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
    
    
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB){
        int a = getListLength(headA);
        int b = getListLength(headB);
        int diff = a - b;
        
        ListNode Long = headA;
        ListNode Short = headB;
        
        if(diff < 0){
            Long = headB;
            Short = headA;
            diff = b - a;
        }
    
        for (int i = 0; i < diff; i++)
        {
            Long = Long.next;
        }
        
        while (Long != null && Short != null && Long != Short){
            Long = Long.next;
            Short = Short.next;
        }
    
        ListNode aLong = Long;
        return aLong;
    }
    
    private int getListLength(ListNode head)
    {
        int length = 0;
        ListNode tempNode = head;
        while (tempNode != null)
        {
            tempNode = tempNode.next;
            length++;
        }
        
        return length;
    }
    
    
    public static class ListNode
    {
        int val;
        ListNode next;
        
        ListNode(int x)
        {
            val = x;
            next = null;
        }
    }
}
