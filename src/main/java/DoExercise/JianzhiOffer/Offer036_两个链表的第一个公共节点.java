package DoExercise.JianzhiOffer;


/**
 *
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 */
public class Offer036_两个链表的第一个公共节点
{
    
    public static void main(String[] args)
    {
        Offer000_Common.ListNode node1 = new Offer000_Common.ListNode(1);
        Offer000_Common.ListNode node2 = new Offer000_Common.ListNode(2);
        Offer000_Common.ListNode node3 = new Offer000_Common.ListNode(3);
        Offer000_Common.ListNode node4 = new Offer000_Common.ListNode(4);
        Offer000_Common.ListNode node5 = new Offer000_Common.ListNode(5);
        Offer000_Common.ListNode node6 = new Offer000_Common.ListNode(6);
        Offer000_Common.ListNode node7 = new Offer000_Common.ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node6.next = node7;
        
        node4.next = node5;
        node5.next = node6;
        
        Offer000_Common.ListNode intersectionNode = getIntersectionNode_1(node1, node4);
        System.out.println(intersectionNode.val);
    }
    
    
    public static Offer000_Common.ListNode getIntersectionNode_1(Offer000_Common.ListNode headA, Offer000_Common.ListNode headB)
    {
        Offer000_Common.ListNode A = headA, B = headB;
        while (A != B)
        {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
    
    
   
    
    
}
