package DataStructBook;

import java.util.Stack;

/**
 * size head
 * 常见单链表操作：增加、删除、排序、查找，打印所有节点、
 */
public class HandleListNode {

    public Node head;
    public int size;

    public HandleListNode(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size==0?true:false;
    }

    public int size(){
        return size;
    }


    /**
     * 添加节点到头部
     * @param node
     */
    public void addNode(Node node){
        if(size == 0){
            head = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }


    /**
     * 删除头节点
     */
    public Node deleteHeadNode(){
        if(size == 0) return null;
        Node node = head;
        if(head.next == null){
            head = null;
        }else{
            head = head.next;
        }
        size --;
        return node;
    }

    /**
     * 删除指定节点
     * @return
     */
    public boolean deleteNode(Node node){
        if(size == 0){
            return false;
        }

        Node previous = null;
        Node current = head;

        while (current.data != node.data){
            if(current.next == null){
                return false;
            }
            previous = current;
            current = current.next;
        }
        //current代表需要删除的节点
        if(current == head){
            this.deleteHeadNode();
        }else{
            previous.next = current.next;
            size--;
        }
        return true;
    }


    /**
     * 按照指定下标插入节点
     * @param index
     * @param node
     */
    public void insertNodeByIndex(int index,Node node){
        //判断
        if(index < 1 || index>size+1){
            return;
        }
        //根据index确定插入位置
        int length = 1;
        Node temp = head;
        while (temp.next!=null){
            if(index == length++){
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }


    /**
     * 查找节点
     * @param node
     * @return
     */
    public boolean findNode(Node node){
        if(size == 0){
            return false;
        }

        Node temp = head;
        while (temp!=null){
            if(temp.data == node.data){
                return true;
            }else{
                temp = temp.next;
            }
        }
        return false;
    }


    /**
     * 使用Stack，从后向前遍历链表
     * @param node
     */
    public void printListFromTailToHead(Node node){
        if(node == null){
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        while(node != null){
            stack.push((Integer)node.data);
            node = node.next;
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }


    /**
     * 使用递归的方式，从后向前遍历链表
     * @param node
     */
    public void printListNodeTailToHeadBy_2(Node node){
        if(node == null){
            return;
        }else{
            if (node.next != null){
                printListNodeTailToHeadBy_2(node.next);
            }
            System.out.println(node.data);
        }
    }

}
