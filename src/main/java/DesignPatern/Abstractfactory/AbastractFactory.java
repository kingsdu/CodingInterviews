package DesignPatern.Abstractfactory;

import DesignPatern.Abstractfactory.foods.Food;
import DesignPatern.Abstractfactory.vehicles.Vehicle;
import DesignPatern.Abstractfactory.weapons.Weapon;
//抽象工厂
public abstract class AbastractFactory
{
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();
}
