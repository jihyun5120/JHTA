package company;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Receive1 extends Thread{

   String fileName;
   String path;
   Socket s;
   int port;
   int count;
   byte[] bytes;
   public Receive1() {}
   public Receive1(String fileName, String path) {

      this.fileName =  fileName;
      this.path = path;
   }
   
   @Override
   public void run() {
      Socket s;
      OutputStream os;
      InputStream is;
      DataInputStream dis;
      byte[] bytes = new byte[90000] ;
      String message = "receive";
      int count;
      FileOutputStream fos;
      
      try {
         
         s = new Socket("192.168.0.22",5001); //System.out.println("서버에 연결함");
         os = s.getOutputStream();
         is = s.getInputStream();

         bytes = message.getBytes();
         os.write(bytes); //System.out.println("메세지 보냄");
          
         dis = new DataInputStream(is);
         port = dis.readInt(); //System.out.println("포트번호 받음");
         Thread receive2 = new Receive2(port, fileName, path);
         receive2.start();
         os.flush();
         dis.close();
         is.close();
         os.close();
         s.close();
         
      } catch (Exception ex) {
         ex.printStackTrace();
      } 
   }

}