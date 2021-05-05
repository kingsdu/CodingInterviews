package JavaSE.BLS.Generic.Class;

/**
 *
 * 泛型：
 * 1、代码可以被很多不同类型的对象所重用。
 *
 *
 */
public class PairClassMain
{
    public static void main(String[] args)
    {
        String[] words = {"1", "2", "3", "4", "5"};
        ClassPair<String> mm = ArrayAlgString.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
        
        Integer[] ints = {1, 2, 3, 4, 5};
        ClassPair<Integer> mm1 = ArrayAlgInteger.minmax(ints);
        System.out.println("min = " + mm1.getFirst());
        System.out.println("max = " + mm1.getSecond());
    
        //类型擦除后返回true
        System.out.println(mm.getClass() == mm1.getClass() ? true : false);
    
        //下面几点总的来说就是，不能将泛型实例化为某个类型，这个就违反了泛型的思想
        /**
         *
         * 运行时类型查询只适用于原始类型
         * 下面语句报错
        if(mm instanceof ClassPair<String>){
        
        }
         */
        
        /**
         *
         * 不能创建参数化类型数组
         * 下面语句报错
         *
         ClassPair<String>[] table = new ClassPair<String>[10];
         */
    }
}
