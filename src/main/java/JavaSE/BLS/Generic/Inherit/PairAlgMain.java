package JavaSE.BLS.Generic.Inherit;


/**
 *
 *
 * ? 是类型通配符,?内部是传入的类型，?只能对变量进行限定
 * T 是一种类型，泛指所有类型的类型，T的内部是Object，T可以对方法返回值、变量类型、类类型进行修饰
 * 例如
 * public static void printBuddies(InheritPair<? extends Employee> p) 中
 * InheritPair是泛型T，类似于int，?是限定了T中的类型必须继承于Employee。
 *
 * 而 public static <T extends Comparable> MethodPair<T> minmax(T[] a) 中
 *  1、返回值类型需要继承于Comparable
 *  2、传入参数需要继承于Comparable
 *
 *
 *  总之，T是大佬，?是辅助大佬的小兵
 *
 */
public class PairAlgMain
{
    public static void main(String[] args)
    {
        Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
        Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);
        InheritPair<Manager> buddies = new InheritPair<>(ceo, cfo);

        printBuddies(buddies);
        
        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        Manager[] managers = {ceo, cfo};
        
        InheritPair<Employee> result = new InheritPair<>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName()
                + ", second: " + result.getSecond().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName()
                + ", second: " + result.getSecond().getName());
    }
    
    public static void printBuddies(InheritPair<? extends Employee> p)
    {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }
    
    public static void minmaxBonus(Manager[] a, InheritPair<? super Manager> result)
    {
        if (a == null || a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++)
        {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }
    
    public static void maxminBonus(Manager[] a, InheritPair<? super Manager> result)
    {
        minmaxBonus(a, result);
        PairAlg.swapHelper(result); // OK--swapHelper captures wildcard type
    }
    
}
