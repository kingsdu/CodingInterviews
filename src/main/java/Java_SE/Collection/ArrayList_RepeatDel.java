package Java_SE.Collection;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * 去除ArrayList中的重复元素
 */

public class ArrayList_RepeatDel {


    public ArrayList delRepeat(ArrayList arrayList){
        ArrayList result = new ArrayList();
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()){
            Object next = listIterator.next();
            if(!result.contains(next)){
                result.add(next);
            }
        }
        return result;
    }

    public void outArrayList(ArrayList res){
        Iterator iterator = res.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
