package DoExercise.HSP_ZCY.A026_链表;

/**
 * @Author: Du
 * @Date: 2021/6/13 14:44
 * <p>
 * 按照大小顺序 合并两个链表
 * <p>
 * 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
 */
public class Code06_MergeTwoSortedLinkedList
{
    public static class ListNode
    {
        public int val;
        public ListNode next;
    }
    
    public static ListNode mergeTwoLists(ListNode head1, ListNode head2)
    {
        if (head1 == null || head2 == null)
        {
            return head1 == null ? head2 : head1;
        }
        
        ListNode head = head1.val <= head2.val ? head1 : head2;//确定头，最后返回的头
        ListNode cur1 = head.next;//cur1标识头的下个节点
        ListNode cur2 = head == head1 ? head2 : head1;//cur2标识不是头的当前节点
        ListNode pre = head;//返回的头，不能在动
        while (cur1 != null && cur2 != null)
        {
            //比较节点，谁小pre.next 指向谁，谁向后移动
            if (cur1.val <= cur2.val)
            {
                pre.next = cur1;
                cur1 = cur1.next;
            } else
            {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        //补全剩余节点
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }
}
