package JavaSE.BLS.Polymorph;


/**
 *
 * 多态
 *
 * 好处：1、提高了程序的拓展性
 * 弊端：1、通过父类对象调用子类对象时，只能使用父类中已有的方法，不能操作子类持有的对象。
 * 前提：1、必须有关系：继承、实现（list 和 ArrayList）；2、通常都有重写操作。
 *
 */
public class TestPolymorph
{
    
    
    public static void main(String[] args)
    {
        Dog d = new Dog();
        //Animal animal = new Dog();
        method(d);
        Cat c = new Cat();
        method(c);
    }
    
    
    public static void method(Animal animal){
        animal.eat();
    }
    
    
    /**
     
     原本的逻辑是，对每个新建的类（猪），在调用其方法时，都需要新建一个method，传入对应对象，
     而当将所有动物抽象为一个类，并将其共性方法定位为抽象方法，这时可以将menthod方法的参数修改
     为Animal，无论调用那个eat，继承类会自动被识别。
    
    public static void method(Dog d){
        d.eat();
    }
    
    public static void method(Cat c){
        c.eat();
    }
 
     */
}
