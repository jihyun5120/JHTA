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

public class Send {
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

            try {// ----------------���� �ִ� �ڵ�--------------
               ss = new ServerSocket(5033);
               while (true) {
                  System.out.println("���� ��ٸ�");
                  s = ss.accept();
                  System.out.println("���� ������");
                  // Ŭ���̾�Ʈ�κ��� ������ ���ϸ� �ޱ�
                  is = s.getInputStream();
                  count = is.read(bytes);
                  fileName = new String(bytes, 0, count);
                  path = "C:/aka";
                  file = new File(path + "/" + fileName);
                  System.out.println("���ϸ� ����");
                  os = s.getOutputStream();
                  FileInputStream fis = new FileInputStream(file);
                  while ((count = fis.read(bytes)) != -1) {
                     os.write(bytes, 0, count);
                  }
                  os.flush();
                  fis.close();
                  os.close();
                  is.close();
                  s.close();
                  System.out.println("���� ���� �Ϸ�");
               }
            } catch (Exception ex) {
               ex.printStackTrace();
            }
         }
      };
      es.execute(task);
   }

}