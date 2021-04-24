package JavaSE.BLS.Polymorph.NoteBook;

public class Test
{
    /**
     * 1.0 版本
     * 程序问题：当需要用的功能越多，就总是需要修改NoteBook类，在其中加上对应的方法
     * 故进行改进
     *
    public static void main(String[] args)
    {
        NoteBook n = new NoteBook();
        n.run();
        n.useMouse(new Mouse());
        n.useKeyBoard(new KeyBoard());
    }
     */
    
    //2.0版本
    public static void main(String[] args)
    {
        NoteBook n = new NoteBook();
        n.run();
        n.useUsb(new Mouse());
        n.useUsb(new KeyBoard());
    }
}
