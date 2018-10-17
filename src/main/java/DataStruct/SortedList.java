package DataStruct;

import DataStructBook.Link;

/**
 * 有序链表
 * 插入的速度更快，不需要元素的移动
 *
 */
public class SortedList {

    private ListNode first;

    public SortedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }


    public void insert(int key) {
        ListNode listNode = new ListNode(key);
        ListNode previous = null;
        ListNode current = first;

        while (current != null && key > current.data){
            previous = current;
            current = current.next;
        }

        if(previous == null){
            first = listNode;
        }else {
            previous.next = listNode;
        }
        listNode.next = current;
    }


    public ListNode remove() {
        ListNode temp = first;
        first = first.next;
        return temp;
    }


    /**
     * 移除指定元素
     *
     * @return
     */
    public ListNode removeByNode(int val) {
        ListNode previous = first;
        ListNode current = first;

        while (current.data != val) {
            if (current.next == null) {
                return null;
            }
            previous = current;
            current = current.next;
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }


    public void displayList() {
        ListNode current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        SortedList sortedList = new
                SortedList();
        sortedList.insert(20);
        sortedList.insert(40);
        sortedList.displayList();

        sortedList.insert(10);
        sortedList.insert(50);
        sortedList.displayList();

        sortedList.remove();
        sortedList.displayList();

        sortedList.removeByNode(40);
        sortedList.displayList();
    }

}
