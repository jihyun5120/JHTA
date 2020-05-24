package semishit;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ProductSend implements Runnable{
	String fileName;
	String path;
   
   public ProductSend(String fileName, String path) {
      this.fileName = fileName;
      this.path = path;
   }
   @Override
   public void run() {
      
      try {
         Socket s = new Socket("192.168.0.19", 5032);
         OutputStream os = s.getOutputStream();
         byte[] bytes = new byte[90000];
         int count = 0;
         
         File file = new File(path);

         bytes = fileName.getBytes();
         os.write(bytes);
         os.flush();
         
         FileInputStream fis = new FileInputStream(file);
         
         while( (count = fis.read(bytes)) != -1 ) {
            os.write(bytes,0,count);
         }
         os.flush();
         os.close();
         fis.close();
         
      }catch(Exception ex) {
         ex.printStackTrace();
      }
   }
}