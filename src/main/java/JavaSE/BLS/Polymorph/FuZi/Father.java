package JavaSE.BLS.Polymorph.FuZi;

public class Father
{
    int num = 3;
    static int age = 40;
    
    FaBorther fa;
    
    public Father(){
        fa = new FaBorther();
    }
    
    public void faLook(){
        fa.look();
    }
    
    public void show(){
        System.out.println("Father show");
    }
    
    public static void method(){
        System.out.println("Father method");
    }
    
    public void see(){
        System.out.println("Father see");
    }
}
