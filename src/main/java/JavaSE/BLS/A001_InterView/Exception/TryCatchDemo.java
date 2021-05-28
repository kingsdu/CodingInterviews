package JavaSE.BLS.A001_InterView.Exception;

public class TryCatchDemo
{
    public static String sRet = "";
    
    public static void func(int i)
    {
        try
        {
            if (i % 2 == 0)
            {
                throw new Exception();
            }
        } catch (Exception e)
        {
            sRet += "0";
            return;
        } finally
        {
            sRet += "1";
        }
        sRet += "2";
    }
    
    public static void main(String[] args)
    {
        func(1);//12
        func(2);//1201
        System.out.println(sRet);
    }
}
