package JavaSE.BLS.Interface;

import JavaSE.BLS.Interface.Abstract.Dog;

/**
 *
 * 要定义缉毒犬，
 * 所有的犬都有bellow()、eat()的功能
 * 而缉毒犬除了具备犬的基本特性外还有drug()缉毒功能
 *
 * 所以对于一般特性需要定义为类，is a
 * 对于其功能拓展可以定义为接口, like a
 *
 */
public class DrugDog extends Dog implements Drugable
{
    /**
     *
     * bellow()、eat()方法是所有的基本特性
     *
     *
     */
    
    @Override
    public void bellow()
    {
    
    }
    
    @Override
    public void eat()
    {
    
    }
    
    
    /**
     *
     *
     * drug()缉毒
     *
     */
    @Override
    public void drug()
    {
    
    }
}
