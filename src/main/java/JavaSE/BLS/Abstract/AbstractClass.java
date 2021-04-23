package JavaSE.BLS.Abstract;


/**
 *
 * 抽象类比普通类多了一个抽象函数
 *
 * 抽象类不能和
 * 1、final：无法初始化
 * 2、private：加上私有无法覆盖，不允许
 * 3、static：静态数据是直接被类调用的，调用无意义。
 *
 * 3个修饰符共存
 *
 */
public abstract class AbstractClass {

    private int i;

    public abstract void open();
    public abstract void close();

    public void method(){
        System.out.println("123");
    }
    
    /**
     *
     * 抽象类可以定义构造函数，但是构造函数的初始化只能在子类实现（子类必须实现构造函数）
     *
     * @param i
     */
    public AbstractClass(int i){
        this.i = i;
    }

}
