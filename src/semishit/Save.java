package semishit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Save {
   ExecutorService es;
   ServerSocket ss;
   Socket s = null;
   byte[] bytes = new byte[89000];
   int count = 0;
   InputStream is = null;
   OutputStream os = null;
   File file = null;
   String path = null;
   String fileName = null;

   public void start() {

      es = Executors.newCachedThreadPool();
      Runnable task = new Runnable() {
         @Override
         public void run() {

            try { // -----------파일 받는 코드----------------
               ss = new ServerSocket(5032);
               while (true) {
                  System.out.println("연결 기다림");
                  s = ss.accept();
                  System.out.println("연결 수락함");

                  // 클라이언트로부터 서버에 파일명 받기
                  is = s.getInputStream();
                  count = is.read(bytes);
                  fileName = new String(bytes, 0, count);
                  path = "C:/aka";
                  file = new File(path + "/" + fileName);
                  System.out.println("파일명 받음");

                  // 클라이언트로부터 서버에 파일받기
                  FileOutputStream fos = new FileOutputStream(file);
                  while ((count = is.read(bytes)) != -1) {
                     fos.write(bytes, 0, count);
                  }
                  fos.flush();
                  fos.close();
                  is.close();
                  System.out.println("파일 다운 완료");
               }
            } catch (Exception ex) {
               ex.printStackTrace();
            }

         }
      };
      es.execute(task);
   }
}