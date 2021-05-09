package JavaSE.BLS.Net.FileUpload2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerThread2Main
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket ss = new ServerSocket(9912);
        while (true)
        {
            Socket s = ss.accept();
            new Thread(new TCPServerThread2(s)).start();
        }
    }
}
