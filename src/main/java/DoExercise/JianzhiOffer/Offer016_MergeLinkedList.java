package DoExercise.JianzhiOffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * <p>
 * {1,3,5},{2,4,6}
 * {1,2,3,4,5,6}
 */
public class Offer016_MergeLinkedList
{
    public static ListNode head;
    
    public static void main(String[] args)
    {
        ListNode list1 = addNodeOrder(null, 1);
        list1 = addNodeOrder(list1, 3);
        list1 = addNodeOrder(list1, 5);
        printListNode(list1);
        System.out.println();
        ListNode list2 = addNodeOrder(null, 2);
        list2 = addNodeOrder(list2, 4);
        list2 = addNodeOrder(list2, 6);
        printListNode(list2);
        System.out.println();
//        ListNode listNode = Merge_2(list1, list2);
//        printListNode(listNode);
//        System.out.println();
        ListNode listNode1 = Merge_3(list1, list2);
        printListNode(listNode1);
    }
    
    
    /**
     *
     * 两个链表迭代求解
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge_2(ListNode list1, ListNode list2)
    {  //没考虑到点1：用一个节点表示头
        ListNode newHead = new ListNode(0);
        ListNode tmpNode = newHead;
        //没考虑到点2：判断应该是&&
        while (list1 != null && list2 != null)
        {   //没考虑到点3：=不用特殊考虑
            if (list1.val >= list2.val)
            {
                tmpNode.next = list2;
                tmpNode = tmpNode.next;
                list2 = list2.next;
            } else
            {
                tmpNode.next = list1;
                tmpNode = tmpNode.next;
                list1 = list1.next;
            }
        }
        
        if(null == list1){
            //没考虑到点4：直接将List赋值给tmpNode即可，不用在逐个遍历，因为list本身有联系
            tmpNode.next = list2;
        }else if(null == list2){
            tmpNode.next = list1;
        }
        return newHead.next;
    }
    
    
    /**
     *
     * 递归算法
     *
     * 该方法才是最舒服的方法
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge_3(ListNode list1, ListNode list2){
        if(list1==null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else{
            if(list1.val < list2.val){
                list1.next = Merge_3(list1.next,list2);
                return list1;
            }else{
                list2.next = Merge_3(list1,list2.next);
                return list2;
            }
        }
    }
    
    
    /**
     * 自己写的第一份程序，错误。
     * <p>
     * 原因：1\在新建链表时首先需要考虑的时链表的头部不变，因为只有稳定的头部才能访问到链表中所有的元素；
     * 2\这个程序在考虑头部时花费了大量的时间做无用功；
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge_1(ListNode list1, ListNode list2)
    {
        ListNode listRes = null;
        while (list1 != null || list2 != null)//条件写的有问题
        {
            if (list1.val < list2.val)
            {
                if (listRes == null)
                {
                    listRes = list1;
                } else
                {
                    listRes.next = list1;
                }
                list1 = list1.next;
                listRes = listRes.next;
            } else if (list1.val > list2.val)
            {
                if (listRes == null)
                {
                    listRes = list2;
                } else
                {
                    listRes.next = list2;
                }
                list2 = list2.next;
                listRes = listRes.next;
            } else
            {
                if (listRes == null)
                {
                    listRes = list1;
                    listRes.next = list2;
                    listRes = listRes.next;
                } else
                {
                    listRes.next = list1;
                    listRes.next.next = list2;
                    listRes = listRes.next.next;
                }
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        
        if (list1 == null)
        {
            if (listRes == null)
            {
                if (list2 != null)
                {
                    listRes = list2;
                    list2 = list2.next;
                }
                while (list2 != null)
                {
                    listRes.next = list2;
                    listRes = listRes.next;
                    list2 = list2.next;
                }
            } else
            {
                while (list2 != null)
                {
                    listRes.next = list2;
                    listRes = listRes.next;
                    list2 = list2.next;
                }
            }
        } else if (list2 == null)
        {
            if (listRes == null)
            {
                if (list1 != null)
                {
                    listRes = list1;
                    list1 = list1.next;
                }
                while (list1 != null)
                {
                    listRes.next = list1;
                    listRes = listRes.next;
                    list1 = list1.next;
                }
            } else
            {
                while (list1 != null)
                {
                    listRes.next = list1;
                    listRes = listRes.next;
                    list1 = list1.next;
                }
            }
        }
        return listRes;
    }
    
    
    public static ListNode addNodeOrder(ListNode node, int value)
    {
        ListNode newNode = new ListNode(value);
        ListNode curNode;
        
        if (node == null)
        {
            node = newNode;
            return node;
        }
        
        curNode = node;
        while (curNode.next != null)
        {
            curNode = curNode.next;
        }
        curNode.next = newNode;
        return node;
    }
    
    public static void printListNode(ListNode node)
    {
        ListNode curNode = node;
        while (curNode != null)
        {
            System.out.print(curNode.val + " ");
            curNode = curNode.next;
        }
    }
    
    public static class ListNode
    {
        int val;
        ListNode next = null;
        
        public ListNode(int val)
        {
            this.val = val;
        }
    }
}
