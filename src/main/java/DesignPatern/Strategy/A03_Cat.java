package DesignPatern.Strategy;

public class A03_Cat implements Comparable<A03_Cat> {
    int weight, height;

    public A03_Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int compareTo(A03_Cat c) {
        if(this.weight < c.weight) return -1;
        else if(this.weight > c.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
