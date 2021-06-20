package DesignPatern.Strategy;

public class A04_Dog implements java.lang.Comparable<A04_Dog>
{

    int food;

    public A04_Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(A04_Dog d) {
        if(this.food < d.food) return -1;
        else if(this.food > d.food) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
