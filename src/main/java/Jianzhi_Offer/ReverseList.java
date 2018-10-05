package Jianzhi_Offer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    ListNode head;
    ListNode cur;

    public void reverseList(){
        if(head==null)
            return;

        ListNode pre = null;
        ListNode next = null;

        while(head!=null){
            next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }

        while (pre!=null){
            System.out.println(pre.val);
            pre = pre.next;
        }
    }


    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        for (int i = 1; i < 6; i++) {
            reverseList.addNode(i);
        }

        reverseList.reverseList();
    }


    public void addNode(int data){
        if(head == null) {
            head = new ListNode(data);
            cur = head;
        }else {
            cur.next = new ListNode(data);
            cur = cur.next;
        }
    }
}
