package DesignPatern.Factorymethod;

public class CarFactory
{
    public Moveable create()
    {
        //return new Car();
        //return new Broom();
        return new Plane();
    }
}
