package Design_patern;

public class Observer_Xiaowang implements Observer_Person{

    public String name = null;

    public Observer_Xiaowang(String name){
        this.name = name;
    }

    @Override
    public void getMsessage(String s) {
        System.out.println("xiaomei xiaowang");
    }
}
