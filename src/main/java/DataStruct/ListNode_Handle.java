package DataStruct;

/**
 * 单链表的增删改查
 */
public class ListNode_Handle {

    public ListNode head;

    public ListNode_Handle(){
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }


    /**
     * 头结点插入
     */
    public void insertHead(int val){
        ListNode listNode = new ListNode(val);
        if(isEmpty()){
            listNode = head;
        }else{
            listNode.next = head;
            head = listNode;
        }
    }


    /**
     * 某个元素后插入
     * @param index
     * @param val
     * @return
     */
    public void insertInposition(int index,int val){
        ListNode listNode = new ListNode(val);
        while (head!=null){
            if(head.data == index){
                listNode.next = head.next;
                head.next = listNode;
            }else {
                head = head.next;
            }
        }
    }


    /**
     * 删除头元素
     * @return
     */
    public boolean deleteHead(){
        if(head == null){
            return false;
        }
        head = head.next;
        return true;
    }


    /**
     * 删除某个元素
     * @param val
     */
    public void deleteIndex(int val){
        if(head == null){
            return;
        }

        ListNode current = head;
        ListNode previous = head;

        while (current.data != val){
            if(current.next == null){
                return;
            }else {
                previous = current;
                current = current.next;
            }
        }

        if(current == head){
            head = head.next;
        }else{
            previous.next = current.next;
        }
    }


    /**
     * 查找元素
     * @param key
     */
    public ListNode findVal(int key){
        ListNode current = new ListNode(key);

        while (head.data != key){
            if(head == null){
                return null;
            }else {
                head = head.next;
            }
        }
        return head;
    }

}
