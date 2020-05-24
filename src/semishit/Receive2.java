package semishit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Receive2 extends Thread{
   
   int port;
   String fileName;
   String path;
   
   public Receive2() {
      
   } 
   
   public Receive2(int port, String fileName, String path) {
      this.port = port;
      this.fileName =  fileName;
      this.path = path;
   }
   
   @Override
   public void run() {
      
      try {
         int count = 0;
         Socket s = new Socket("192.168.0.22",port); System.out.println("파일 서버 연결");
         InputStream is = s.getInputStream();
         OutputStream os = s.getOutputStream();
         
         
         byte[] bytes = new byte[90000];
         bytes = fileName.getBytes();
         os.write(bytes); System.out.println("파일명 전송");
         
         byte[] bytes2 = new byte[4000];
         FileOutputStream fos = new FileOutputStream(path);
         System.out.println(path);
         while((count = is.read(bytes2)) != -1) {
         fos.write(bytes2, 0, count);
         }
         fos.flush(); 
         os.flush();
         os.close();
         fos.close();
         is.close();
         s.close();
         System.out.println("파일 전송 받음");
      }catch(Exception ex) {
         ex.printStackTrace();
      }
      
   }
}