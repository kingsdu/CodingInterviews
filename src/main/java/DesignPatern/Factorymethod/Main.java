package DesignPatern.Factorymethod;

//Broom Car Plane 都实现了Moveable接口，CarFactory是对应的工厂
public class Main
{
    public static void main(String[] args)
    {
        Moveable m = new CarFactory().create();
        m.go();
    }
}
