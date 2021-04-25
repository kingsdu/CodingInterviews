package JavaSE.BLS.InnerClass;

public class A02Outer
{
    private String outStr = "Outer中的字符串";
    
    public String getOutStr()
    {
        return outStr;
    }
    
    public void fun()
    {   //2
        A02Inner in = new A02Inner(this); //3
        in.print();                 //5
    }
    
}
