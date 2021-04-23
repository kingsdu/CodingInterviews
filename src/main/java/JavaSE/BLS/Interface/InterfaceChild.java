package JavaSE.BLS.Interface;

import JavaSE.BLS.Interface.InterfaceClass1;
import JavaSE.BLS.Interface.InterfaceClass2;

public class InterfaceChild implements InterfaceClass2, InterfaceClass1
{
    @Override
    public void open() {

    }

    @Override
    public void close() {

    }
    
    @Override
    public int down()
    {
        return 0;
    }
    
    @Override
    public void up()
    {
    
    }
    
    
}
