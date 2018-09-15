package DataStructBook;

public class FirstLastList {

    private Link first;
    private Link last;

    public FirstLastList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int id,long dd){
        Link newLink = new Link(id,dd);

        if(isEmpty()){
            last = newLink;
        }

        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int id,long dd){
        Link newLink = new Link(id,dd);
        if(isEmpty()){
            first = newLink;
        }else{
            last.next = newLink;
        }
        last = newLink;
    }

    public Link deleteFirst(){
        Link temp = first;
        if(first.next == null){
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayList(){
        Link current = first;
        while (current != null){
            current.displayList();
            current = current.next;
        }
    }


}
