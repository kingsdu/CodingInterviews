package DesignPatern.Strategy;

public class A04_DogComparator implements Comparator<A04_Dog> {
    @Override
    public int compare(A04_Dog o1, A04_Dog o2) {
        if(o1.food < o2.food) return -1;
        else if (o1.food > o2.food) return 1;
        else return 0;
    }
}
