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
        head = end;
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
            lastEnd.next = end;
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
        ListNode next = null;
        while (cur != end)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }
    
}
