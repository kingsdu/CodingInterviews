package Jianzhi_Offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 */
public class FindKthToTail {

    private ListNode head;

    /**
     * 两个指针，先让第一个指针和第二个指针都指向头节点
     * 让第一个指针向前进n步
     * 两个指针一起向前移动
     * 当第一个指针指向尾部时，第二个指针指向的位置就是倒数第k个节点
     * @param n
     */
    public ListNode getNodeInList(int n){
        if(head==null||n<=0){
            return null;
        }
        ListNode pre = head;
        ListNode last = head;

        for (int i = 1; i < n; i++) {
            if(pre!=null){
                pre = pre.next;
            }else{
                return null;
            }
        }

        while (pre.next != null){
            pre = pre.next;
            last = last.next;
        }

        return last;
    }
}
