package JavaSE.BLS.Net.UserLogin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LoginClient
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("127.0.0.1", 10008);
        
        BufferedReader bufr =
                new BufferedReader(new InputStreamReader(System.in));
        
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        
        BufferedReader bufIn =
                new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        
        for (int x = 0; x < 3; x++)
        {
            String line = bufr.readLine();
            if (line == null)
                break;
            out.println(line);
            
            String info = bufIn.readLine();
            System.out.println("info:" + info);
            if (info.contains("欢迎"))
                break;
            
        }
        
        bufr.close();
        s.close();
    }
}
