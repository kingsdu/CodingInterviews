package JavaSE.BLS.Polymorph.NoteBook;


/**
 * 笔记本类
 */
public class NoteBook
{
    
    public void run()
    {
        System.out.println("NoteBook run");
    }
    
    /***
     *
     * 2.0 版本通过接口
     *
     * 增加多态，参数UseUSB usb，
     * 当传入的是 Mouse 时，UseUSB usb = new Mouse();
     * 当传入的是 KeyBoard 时，UseUSB usb = new KeyBoard();
     */
    public void useUsb(UseUSB usb){
        usb.open();
        usb.close();
    }
    
    
    /**
     * 1.0版本
     *
     *
    public void useMouse(Mouse m){
        if(m != null){
            m.open();
            m.close();
        }
    }
    
    public void useKeyBoard(KeyBoard k){
        if(k != null){
            k.open();
            k.close();
        }
    }
 
     */
}
