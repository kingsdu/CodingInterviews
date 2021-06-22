package DesignPatern.Factorymethod.model;

import DesignPatern.Factorymethod.Moveable;

public class Broom implements Moveable
{
    @Override
    public void go()
    {
        System.out.println("broom flying chuachuachua .....");
    }
}
