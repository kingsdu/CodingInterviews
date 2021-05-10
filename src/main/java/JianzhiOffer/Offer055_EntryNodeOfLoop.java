package JianzhiOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 环形节点，即某节点出现2次即为节点头。
 *
 */
public class Offer055_EntryNodeOfLoop
{
    
    public ListNode EntryNodeOfLoop_1(ListNode pHead)
    {
        Set<ListNode> s = new HashSet<>();
        while (pHead!=null){
            if(s.contains(pHead)){
                return pHead;
            }else {
                s.add(pHead);
                pHead = pHead.next;
            }
        }
        return null;
    }
    
    
    static class ListNode
    {
        int val;
        ListNode next = null;
        
        ListNode(int val)
        {
            this.val = val;
        }
    }
}
