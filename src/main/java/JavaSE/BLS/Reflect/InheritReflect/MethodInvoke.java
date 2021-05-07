package JavaSE.BLS.Reflect.InheritReflect;

import java.lang.reflect.Method;

public class MethodInvoke
{
    public static void main(String[] args) throws Exception
    {
        Method animalMethod = Animal.class.getDeclaredMethod("print");
        Method catMethod = Cat.class.getDeclaredMethod("print");
        
        Animal animal = new Animal();
        Cat cat = new Cat();
        animalMethod.invoke(cat);
        animalMethod.invoke(animal);
        
        catMethod.invoke(cat);
        catMethod.invoke(animal);//传入的参数类型Animal是父类，却期望调用子类Cat的方法，异常
    }
    
}
