package DesignPatern.Strategy;

public class A03_CatWeightComparator implements Comparator<A03_Cat> {
    @Override
    public int compare(A03_Cat o1, A03_Cat o2) {
        if(o1.weight < o2.weight) return -1;
        else if (o1.weight > o2.weight) return 1;
        else return 0;
    }
}
