package DesignPatern.Factorymethod;

import DesignPatern.Factorymethod.model.Plane;

public class CarFactory
{
    public Moveable create()
    {
        //return new Car();
        //return new Broom();
        return new Plane();
    }
}
