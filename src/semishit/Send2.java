package semishit;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Send2 extends Thread{
   int port;
   String fileName;
   String path;
   public Send2() {}
   
   public Send2(int port,String fileName, String path) {
      this.port = port;
      this.fileName = fileName;
      this.path = path;
   }
   
   
   @Override
   public void run() {
      try {
         int count = 0;  
      System.out.println("���� ���� ���� �����");
      Socket s = new Socket("192.168.0.22",port); System.out.println("���� ���� ����");
      OutputStream os = s.getOutputStream();
      
      byte[] bytes = new byte[90000];
      bytes = fileName.getBytes();
      os.write(bytes); System.out.println("���ϸ� ����");
      
      System.out.println(path);
      System.out.println(fileName);
      
      FileInputStream fis = new FileInputStream(path);
      
      byte[] bytes2 = new byte[4000];
      
      while((count = fis.read(bytes2)) != -1){
         os.write(bytes2, 0, count);
      }
      os.flush();
      fis.close();
      os.close();
      s.close();
      System.out.println("���� ���� �Ϸ�");
      }catch(Exception ex) { 
         ex.printStackTrace();
      }
   }
 
}
