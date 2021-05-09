package JavaSE.BLS.Net.UserLogin;

import java.net.ServerSocket;
import java.net.Socket;

public class LoginServerMain
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(10008);
        
        while(true)
        {
            Socket s = ss.accept();
            new Thread(new UserThread(s)).start();
        }
    }
}
