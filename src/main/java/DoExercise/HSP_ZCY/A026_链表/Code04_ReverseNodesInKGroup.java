package DoExercise.HSP_ZCY.A026_链表;

/**
 * @Author: Du
 * @Date: 2021/6/13 13:51
 *
 * K个一组翻转链表
 * 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class Code04_ReverseNodesInKGroup
{
    
    public static class ListNode
    {
        public int val;
        public ListNode next;
        
        public ListNode(int val){
            this.val = val;
        }
    }
    
    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
    
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
    
        ListNode listNode = reverseKGroup(l1, 3);
        while (listNode != null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
    
    }
    
    public static ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null)//第一组没凑齐
        {
            return head;
        }
        // 第一组凑齐了！
        head = end;//此处head就是最终的返回头，不能在动
        reverse(start, end);
        // 上一组的结尾节点
        ListNode lastEnd = start;
        while (lastEnd.next != null)
        {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null)
            {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;//细节操作，让1指向6
            lastEnd = start;
        }
        return head;
    }
    
    //从start开始，返回第K个节点
    public static ListNode getKGroupEnd(ListNode start, int k)
    {
        while (--k != 0 && start != null)
        {
            start = start.next;
        }
        return start;
    }
    
    //反转从start到end的链表，并让start指向下一K序列的头
    public static void reverse(ListNode start, ListNode end)
    {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        while (cur != end)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }
    
}
