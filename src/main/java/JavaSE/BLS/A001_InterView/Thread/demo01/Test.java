package JavaSE.BLS.A001_InterView.Thread.demo01;

public class Test
{
    private int data;
    int result = 0;
    
    public void m()
    {
        result += 2;
        data += 2;
        System.out.print(result + "  " + data);
    }
}
