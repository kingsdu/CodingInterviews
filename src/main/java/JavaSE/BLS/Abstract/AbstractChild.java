package JavaSE.BLS.Abstract;

import java.io.FilterReader;
import java.io.Reader;

public class AbstractChild extends AbstractClass{
    
    
    public AbstractChild(int i)
    {
        super(i);
    }
    
    @Override
    public void open() {

    }

    @Override
    public void close() {

    }
    
    public void method(){
        System.out.println("456");
    }
    
    
    public static void main(String[] args)
    {
    
    }
    
}
