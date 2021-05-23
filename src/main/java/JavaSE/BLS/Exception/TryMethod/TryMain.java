package JavaSE.BLS.Exception.TryMethod;

import java.rmi.AccessException;

/**
 *
 * 1、若catch(){}块中，如果有throw语句，则try{}catch(){}finally{}块之外的代码不执行；否则，执行。
 * 2、try{}中有异常，则异常下面代码不执行。
 * 3、finally{}中代码必执行。
 *
 */
public class TryMain
{
    
    public static void main(String[] args)
    {
        try
        {
            throw new AccessException("aa");
//            System.out.println("error1");编译报错
        } catch (Exception e)
        {
            System.out.println("error1");
        }
        System.out.println("error2");
    }
    
}
