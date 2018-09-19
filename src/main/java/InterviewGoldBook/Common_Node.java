package InterviewGoldBook;

/**
 * 两个链表 head1 head2 打印两个链表公共部分
 */
public class Common_Node {

    public int val;
    public Common_Node next;
    public Common_Node(int value){
        val = value;
    }

    public void printCommonNode(Common_Node head1,Common_Node head2){
        while (head1 != null && head2 != null){
            if(head1.val < head2.val){
                head1 = head1.next;
            }else if(head2.val < head1.val){
                head2 = head2.next;
            }else{
                System.out.println(head2.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
