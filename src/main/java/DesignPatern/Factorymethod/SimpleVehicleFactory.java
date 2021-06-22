package DesignPatern.Factorymethod;

import DesignPatern.Factorymethod.model.Broom;
import DesignPatern.Factorymethod.model.Car;

/**
 * 简单工厂的可扩展性不好
 */
public class SimpleVehicleFactory
{
    public Car createCar()
    {
        //before processing
        return new Car();
    }
    
    public Broom createBroom()
    {
        return new Broom();
    }
}
