package DoExercise.HSP_ZCY.A026_链表;

import DoExercise.JianzhiOffer.Offer000_Common;

/**
 * @Author: Du
 * @Date: 2021/7/5 11:18
 * <p>
 * 删除链表中的某个结点，包含重复结点。
 * 例子：
 * 1,2,3,4,5,3,3,4,5,3
 * 删除3
 * 结果：1,2,4,5,4,5
 */
public class Code07_DeleteGivenValue
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,3,3,4,5,3};
        int num = 3;
        Offer000_Common.ListNode head = Offer000_Common.deserialize_ListNode(arr);
        Offer000_Common.ListNode res = removeValue(head, num);
        Offer000_Common.printListNode(res);
    }
    
    /**
     *
     * 删除指定结点
     *
     * @param head
     * @param num
     * @return
     */
    public static Offer000_Common.ListNode removeValue(Offer000_Common.ListNode head, int num)
    {
        while (head != null)
        {
            if (head.val != num)
            {
                break;
            }
            head = head.next;
        }
        
        Offer000_Common.ListNode pre = head;
        Offer000_Common.ListNode cur = head;
        while (cur != null)
        {
            if (cur.val == num)
            {
                pre.next = cur.next;
            } else
            {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
    
}
