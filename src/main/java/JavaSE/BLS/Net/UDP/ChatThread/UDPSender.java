package JavaSE.BLS.Net.UDP.ChatThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSender implements Runnable
{
    private DatagramSocket ds;
    
    
    public UDPSender(DatagramSocket ds)
    {
        this.ds = ds;
    }
    
    @Override
    public void run()
    {
        try
        {
            //2 确定数据，并将其封装为数据包
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            
            String line = null;
            
            while ((line = bf.readLine()) != null)
            {
                if ("886".equals(line))
                {
                    break;
                }
                byte[] buf = line.getBytes();
                
                DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(InetAddress.getLocalHost().getHostAddress()), 12002);
                
                ds.send(dp);
                //注意最后不能关闭。如果一端的Socket被关闭（或主动关闭或者因为异常退出而引起的关闭），另一端仍发送数据，会导致异常
            }
        } catch (SocketException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
