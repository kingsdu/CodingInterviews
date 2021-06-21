package DesignPatern.Abstractfactory;


import DesignPatern.Abstractfactory.foods.Bread;
import DesignPatern.Abstractfactory.foods.Food;
import DesignPatern.Abstractfactory.vehicles.Car;
import DesignPatern.Abstractfactory.vehicles.Vehicle;
import DesignPatern.Abstractfactory.weapons.AK47;
import DesignPatern.Abstractfactory.weapons.Weapon;
//现代人
public class ModernFactory extends AbastractFactory
{
    @Override
    Food createFood()
    {
        return new Bread();
    }
    
    @Override
    Vehicle createVehicle()
    {
        return new Car();
    }
    
    @Override
    Weapon createWeapon()
    {
        return new AK47();
    }
}
