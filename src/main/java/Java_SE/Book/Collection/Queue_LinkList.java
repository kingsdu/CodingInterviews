package Java_SE.Book.Collection;

import java.util.LinkedList;

public class Queue_LinkList {

    private LinkedList link;

    public Queue_LinkList(){
        link = new LinkedList();
    }

    public void addElement(Object obj){
        link.addFirst(obj);
    }

    public Object getElement(Object obj){
        return link.removeFirst();
    }

}
