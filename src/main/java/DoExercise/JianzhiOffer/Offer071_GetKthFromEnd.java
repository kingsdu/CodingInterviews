package DoExercise.JianzhiOffer;

/**
 * @Author: Du
 * @Date: 2021/6/10 11:16
 */
public class Offer071_GetKthFromEnd
{
    
    
    public static void main(String[] args)
    {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
    
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
    
        ListNode kthFromEnd = getKthFromEnd1(node1, 2);
        while (kthFromEnd != null)
        {
            System.out.println(kthFromEnd.val);
            kthFromEnd = kthFromEnd.next;
        }
    }
    
    /**
     *
     * 大小指针
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd1(ListNode head, int k)
    {
        ListNode former = head;
        ListNode latter = head;
        for (int i = 0; i < k; i++) former  = former .next;
        while (former  != null)
        {
            former  = former .next;
            latter = latter.next;
        }
        return latter;
    }
    
    
    public static ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode pre = head;
        int count = 0;
        while (pre != null)
        {
            pre = pre.next;
            count++;
        }
        
        while (head != null && count > k)
        {
            count--;
            head = head.next;
        }
        return head;
    }
    
    
    public static class ListNode
    {
        int val;
        ListNode next;
        
        ListNode(int x)
        {
            val = x;
        }
    }
}
