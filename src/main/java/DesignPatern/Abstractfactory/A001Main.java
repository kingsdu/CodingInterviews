package DesignPatern.Abstractfactory;

import DesignPatern.Abstractfactory.foods.Food;
import DesignPatern.Abstractfactory.vehicles.Vehicle;
import DesignPatern.Abstractfactory.weapons.Weapon;


//抽象工厂
//每个产品可以不断扩展
//每个类也可以不断扩展
public class A001Main
{
    public static void main(String[] args)
    {
        AbastractFactory f = new ModernFactory();//现代人
        Vehicle c = f.createVehicle();
        c.go();
        Weapon w = f.createWeapon();
        w.shoot();
        Food b = f.createFood();
        b.printName();
        
        System.out.println("==========================================");
        
        AbastractFactory f1 = new MagicFactory();//魔法人
        Vehicle c1 = f1.createVehicle();
        c1.go();
        Weapon w1 = f1.createWeapon();
        w1.shoot();
        Food b1 = f1.createFood();
        b1.printName();
    }
}
