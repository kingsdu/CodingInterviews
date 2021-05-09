package JavaSE.BLS.Net.FileUpload3;

import java.net.ServerSocket;
import java.net.Socket;

public class PicServerMain
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(10007);
        
        while(true)
        {
            Socket s = ss.accept();
            
            new Thread(new PicThread(s)).start();
        }
 
    }
}
