package JavaSE.BLS.Net.UserLogin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserThread implements Runnable
{
    private Socket s;
    
    UserThread(Socket s)
    {
        this.s = s;
    }
    
    public void run()
    {
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + "....connected");
        try
        {
            for (int x = 0; x < 3; x++)
            {
                BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
                
                String name = bufIn.readLine();
                if (name == null)
                    break;
                
                BufferedReader bufr = new BufferedReader(new FileReader("D:\\Files\\Txt\\user.txt"));
                
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                
                String line = null;
                
                boolean flag = false;
                while ((line = bufr.readLine()) != null)
                {
                    if (line.equals(name))
                    {
                        flag = true;
                        break;
                    }
                }
                
                if (flag)
                {
                    System.out.println(name + ",已登录");
                    out.println(name + ",欢迎光临");
                    break;
                } else
                {
                    System.out.println(name + ",尝试登录");
                    out.println(name + ",用户名不存在");
                }
                
                
            }
            s.close();
        } catch (Exception e)
        {
            throw new RuntimeException(ip + "校验失败");
        }
    }
}
