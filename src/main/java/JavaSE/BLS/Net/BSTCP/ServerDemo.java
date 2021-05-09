package JavaSE.BLS.Net.BSTCP;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(11000);
        
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress());
        
        InputStream in = s.getInputStream();
        
        byte[] buf = new byte[1024];
        
        int len = in.read(buf);
        
        System.out.println(new String(buf,0,len));
        
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        
        out.println("<font color='red' size='7'>客户端你好</font>");
        
        s.close();
        
        ss.close();
    }
}
