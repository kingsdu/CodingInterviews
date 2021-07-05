package DesignPatern.State.v1;

/**
 * 根据状态不同，对应的动作都不同
 */
public class MM
{
    String name;
    
    private enum MMState
    {HAPPY, SAD}
    
    MMState state;
    
    public void smile()
    {
        //switch case
        
    }
    
    public void cry()
    {
        //switch case
    }
    
    public void say()
    {
        //switch case
    }
}
