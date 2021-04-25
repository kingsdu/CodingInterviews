package JavaSE.BLS.InnerClass.PartInnerClass;

public class A03_Anonymous
{
    //面试题
    public void method(){
        new Object(){
            public void show(){
            
            }
        }.show();
    
        //编译失败，因为匿名内部类就是子类对象，返回为Object类型后，向上转型，但是Objetc中是没有show() 方法的，所以会编译失败
        Object obj = new Object(){
            public void show(){
            
            }
        };
        //编译失败
        //obj.show();
    }
}
