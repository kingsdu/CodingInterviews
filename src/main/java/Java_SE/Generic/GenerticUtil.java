package Java_SE.Generic;

public class GenerticUtil<E>{

    private E q;

    public void setObject(E q){
        this.q = q;
    }

    public E getObject(){
        return q;
    }
}