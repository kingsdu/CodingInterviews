package JavaSE.BLS.IO;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class PicClient {

    public static void main(String[] args) {
        try {
            File file = new File("G:\\mine\\pic\\No.jpg");
            if (!(file.exists() && file.isFile())) {
                return;
            }
            if (!file.getName().endsWith(".jpg")) {
                return;
            }

            if (file.length() > 1024 * 1024 * 5) {
                return;
            }
            Socket s = new Socket("192.168.0.116", 10002);
            FileInputStream fis = new FileInputStream(file);
            OutputStream out = s.getOutputStream();
            byte[] buf = new byte[1024];
            int len = 0;

            while ((len = fis.read(buf)) != -1) {
                out.write(buf, 0, len);//写入socket流中
            }
            s.shutdownOutput();//结束标记
            InputStream in = s.getInputStream();
            byte[] bufIn = new byte[1024];
            int num = in.read(bufIn);
            System.out.println(new String(bufIn, 0, num));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
