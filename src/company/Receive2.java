package company;

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
         Socket s = new Socket("192.168.0.22",port); //System.out.println("파일 서버 연결");
         InputStream is = s.getInputStream();
         OutputStream os = s.getOutputStream();
         
         byte[] bytes = new byte[90000];
         bytes = fileName.getBytes();
         os.write(bytes); //System.out.println("파일명 전송");
         
         // 해당 디렉토리가 없을경우 디렉토리를 생성
         File Folder = new File("C:/Photo");
         if (!Folder.exists()) {
            try{
                Folder.mkdir(); //폴더 생성
                System.out.println("폴더가 생성되었습니다.");
                 } 
                 catch(Exception e){
                e.getStackTrace();
            }        
               }else {
            System.out.println("이미 폴더가 생성되어 있습니다.");
         }
         byte[] bytes2 = new byte[4000];
         
         FileOutputStream fos = new FileOutputStream(path);
         while((count = is.read(bytes2)) != -1) {
         fos.write(bytes2, 0, count);
         }
         fos.flush(); 
         os.flush();
         os.close();
         fos.close();
         is.close();
         s.close();
         //System.out.println("파일 전송 받음");
      }catch(Exception ex) {
         ex.printStackTrace();
      }
      
   }
}