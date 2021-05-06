package JavaSE.BLS.Generic.BrigeMethod;

/**
 *
 * 1、桥方法的合成是为了避免类型变量擦除所带来的多态灾难。
 * 问题：没搞懂，虽然有桥方法，但是似乎没用，数据set不进去，取不出来？？？
 *
 */
public class BridgeMethodMain
{
    public static void main(String[] args)
    {
        //子类独立方法，可以获取到数据
        BridgeMethodChildPair childPair = new BridgeMethodChildPair();
        childPair.setThird(1);
        System.out.println(childPair.getThird());
        /**
         * 运行结果
         * 1
         *
         */
        
        //子类重写父类方法
        BridgeMethodPair<Integer> pair = childPair;
        pair.setSecond(1);
        System.out.println(pair.getSecond());
        /**
         * 运行结果
         *
         * Integer setSecond
         * Integer getSecond
         * T getSecond
         * null
         *
         */
    }

}
