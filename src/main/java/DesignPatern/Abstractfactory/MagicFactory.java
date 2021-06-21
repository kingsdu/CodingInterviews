package DesignPatern.Abstractfactory;

import DesignPatern.Abstractfactory.foods.Food;
import DesignPatern.Abstractfactory.foods.MushRoom;
import DesignPatern.Abstractfactory.vehicles.Vehicle;
import DesignPatern.Abstractfactory.vehicles.Broom;
import DesignPatern.Abstractfactory.weapons.MagicStick;
import DesignPatern.Abstractfactory.weapons.Weapon;
//魔法世界的人
public class MagicFactory extends AbastractFactory
{
    @Override
    Food createFood()
    {
        return new MushRoom();
    }
    
    @Override
    Vehicle createVehicle()
    {
        return new Broom();
    }
    
    @Override
    Weapon createWeapon()
    {
        return new MagicStick();
    }
}
