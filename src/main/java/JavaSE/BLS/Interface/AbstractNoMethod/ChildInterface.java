package JavaSE.BLS.Interface.AbstractNoMethod;


/**
 *
 *
 * 子类可以只实现父类中的某个方法
 *
 */
public class ChildInterface extends ParentInterface
{
    
    public static void main(String[] args)
    {
        ChildInterface c = new ChildInterface();
        c.add();
    }
    
    public void add(){
        System.out.println("ChildInterface -- add");
    }
}
