package Integer;

public class Test1
{
    private int a = 10;
    int b = 20;
    static int c = 1;
    
    public static void main(String[] args)
    {
        Test1 t = new Test1();
        t.c = 1;
        System.out.println(t.c);
        t.setA();

    }
    
    public void setA(){
        Test1 t = new Test1();
        c = 2;
        System.out.println(t.c);
    }
}
