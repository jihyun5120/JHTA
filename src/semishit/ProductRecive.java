package semishit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ProductRecive implements Runnable{
   ProductVo vo;
   String fileName;
   String path;
   Socket s;
   int count;
   byte[] bytes;
   public ProductRecive() {}
   public ProductRecive(ProductVo vo) {
      this.vo = vo;
   }
   
   @Override
   public void run() {
      try {
    	 s = new Socket("192.168.0.19", 5033);
         OutputStream os = s.getOutputStream();
         bytes = new byte[90000];
         count = 0;
         
         //파일명보내기
         fileName = vo.getImName();
         path = vo.getImPath();
         bytes = fileName.getBytes();
         os.write(bytes);
         os.flush();
      
         File file = new File(path+"/"+fileName);
         FileOutputStream fos = new FileOutputStream(file);
         bytes = new byte[90000];
//         boolean isExist = file.exists();
//         if(!isExist) {
//            file.mkdirs();
            InputStream is = s.getInputStream();
            while( (count = is.read(bytes)) != -1 ) {
              fos.write(bytes, 0, count);
            }
         fos.flush();
         is.close();
         fos.close();
         os.close();
         s.close();
//         }
         
      }catch(Exception e1) {
         e1.printStackTrace();
      }
   }
}