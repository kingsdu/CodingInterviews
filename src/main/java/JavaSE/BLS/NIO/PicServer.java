package JavaSE.BLS.NIO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class PicServer {

    public static void main(String[] args) {
        System.out.println("服务端成功开启");
        try {
            ServerSocket ss = new ServerSocket(10002);
            while(true) {
                Socket s = ss.accept();
                new Thread(new PicThread(s)).start();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
