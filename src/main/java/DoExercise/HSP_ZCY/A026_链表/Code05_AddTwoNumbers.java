package DoExercise.HSP_ZCY.A026_链表;

/**
 * @Author: Du
 * @Date: 2021/6/13 14:43
 *
 * 计算两个链表的和
 * 例如
 * 输出
 * 2 - 4 - 3
 * 5 - 6 - 4
 * 返回
 * 7 - 0 - 8
 *
 * 测试链接：https://leetcode.com/problems/add-two-numbers/
 */
public class Code05_AddTwoNumbers
{
    
    public static class ListNode
    {
        public int val;
        public ListNode next;
        
        public ListNode(int val)
        {
            this.val = val;
        }
        
        public ListNode(int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }
    }
    //细节注意：1、last当前有效节点；2、进位处理
    public static ListNode addTwoNumbers(ListNode head1, ListNode head2)
    {
        int len1 = listLength(head1);
        int len2 = listLength(head2);
        ListNode l = len1 >= len2 ? head1 : head2;//l设置指向长链表
        ListNode s = l == head1 ? head2 : head1;//s设置指向短链表
        ListNode curL = l;
        ListNode curS = s;
        ListNode last = curL;//始终跟着最后一个有效节点，帮助补进位的节点
        int carry = 0;//进位
        int curNum = 0;//两个节点和的值
        //第一段 l 有 s 有
        while (curS != null)
        {
            curNum = curL.val + curS.val + carry;//a + b + 进位
            curL.val = (curNum % 10);
            carry = curNum / 10;//进位
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        //第二段 l 有 s 没有
        while (curL != null)
        {
            curNum = curL.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        //第三段 l 没有 s 没有
        if (carry != 0)
        {
            last.next = new ListNode(1);//补充进位节点
        }
        return l;
    }
    
    // 求链表长度
    public static int listLength(ListNode head)
    {
        int len = 0;
        while (head != null)
        {
            len++;
            head = head.next;
        }
        return len;
    }
    
}
