package JavaSE.BLS.Generic.Method;

/**
 *
 * 泛型方法：
 * 1、我只需要告诉调用者，传入的方法必须继承于Comparable接口
 * 2、不用分别定义ArrayAlgInteger 和 ArrayAlgString
 * 3、泛型类 + 泛型方法
 * 4、<T extends Comparable> 告诉了虚拟机，T所属的范围
 */
public class PairMethodMain
{
    
    public static void main(String[] args)
    {
        String[] words = {"1", "2", "3", "4", "5"};
        Integer[] ints = {1, 2, 3, 4, 5};

        MethodPair<String> mm = ArrayAlgT.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    
        MethodPair<Integer> mm1 = ArrayAlgT.minmax(ints);
        System.out.println("min = " + mm1.getFirst());
        System.out.println("max = " + mm1.getSecond());
    }
}
