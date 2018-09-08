package Design_patern;

import java.util.ArrayList;
import java.util.List;

public class Observer_Xiaomei {

    List<Observer_Person> observer_people = new ArrayList<Observer_Person>();

    public void addPerson(Observer_Person person){
        observer_people.add(person);
    }

    public void notifyPerson(){
        for(Observer_Person person : observer_people){
            person.getMsessage("xiaomei message");
        }
    }
}
