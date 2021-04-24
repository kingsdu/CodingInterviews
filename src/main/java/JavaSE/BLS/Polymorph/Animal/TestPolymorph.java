package JavaSE.BLS.Polymorph.Animal;


/**
 * 多态
 * <p>
 * 好处：1、提高了程序的拓展性
 * 弊端：1、通过父类对象调用子类对象时，只能使用父类中已有的方法，不能操作子类持有的对象。
 * 前提：1、必须有关系：继承、实现（list 和 ArrayList）；2、通常都有重写操作。
 * <p>
 * 多态情况下如何调用子类方法：转型
 * Animal a = new Dog();
 * a.eat();
 * //向下转型实现多态调用子类型，即将父类型转化为子类型
 * Dog d = (Dog)a;
 * d.lookHome();
 * <p>
 * 转型总结：
 * 1、只使用父类的公共方法，不需要使用子类的方法，使用向上转型。即多态 Animal a = new Dog();
 * 2、需要使用父类方法，也需要使用子类的方法，使用向下转型。即 Dog dog = (Dog) animal;这时需要用instanceof判断类是否属于该类。
 *
 *
 */
public class TestPolymorph
{
    
    public static void main(String[] args)
    {
        Dog d = new Dog();
        method(d);
        Cat c = new Cat();
        method(c);
    }
    
    
    public static void method(Animal animal)
    {
        //向上向下转型
        if (animal instanceof Dog)
        {
            //当用到某个类型时，需要做类型的判断
            Dog dog = (Dog) animal;
            dog.lookHome();
        } else if (animal instanceof Cat)
        {
            Cat cat = (Cat) animal;
            cat.eatMouse();
        }
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
