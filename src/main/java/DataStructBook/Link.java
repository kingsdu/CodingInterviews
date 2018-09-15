package DataStructBook;

public class Link {

    public int iData;
    public double dData;
    public Link next;

    public Link(int id,double dd){
        this.iData = id;
        this.dData = dd;
    }


    public void displayList(){
        System.out.println("{"+iData+","+dData+"}");
    }
}
