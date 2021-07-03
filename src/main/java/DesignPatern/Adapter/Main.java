package DesignPatern.Adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *
 *
 * WindowAdapter 实现了 WindowListener ，这样继承抽象类WindowAdapter可以只是调用其中的一个方法，不用实现其中所有的方法
 *
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream fis = new FileInputStream("c:/test.text");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null && !line.equals(""))
        {
            System.out.println(line);
        }
        br.close();
    }
}
