package z_exam;


import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Send implements Runnable{

   @Override
   public void run() {
      
      try {
         Socket s = new Socket("192.168.0.22", 5002);
         OutputStream os = s.getOutputStream();
         byte[] bytes = new byte[90000];
         int count = 0;
         
         String fileName = "or.png";
         File file = new File("C:\\Users\\uk\\Desktop\\note\\"+fileName);

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
         s.close();
      }catch(Exception ex) {
         ex.printStackTrace();
      }
   }
}
