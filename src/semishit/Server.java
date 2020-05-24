package semishit;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Server extends JFrame {
   
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
      String sign = null;
  

   private JPanel contentPane;
   private JTextField textField;
   private JButton btnNewButton;
   private JScrollPane scrollPane;
   private JTextArea textArea;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Server frame = new Server();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public Server() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      contentPane.add(getTextField(), BorderLayout.NORTH);
      contentPane.add(getBtnNewButton(), BorderLayout.SOUTH);
      contentPane.add(getScrollPane(), BorderLayout.CENTER);
   }
   
   public void start() {

      es = Executors.newCachedThreadPool();
      Runnable task = new Runnable() {
         @Override
         public void run() {
            
            
            
            
               try { //-----------파일 받는 코드----------------
                  ss = new ServerSocket(5031);
                  while(true) {
                     System.out.println("연결 기다림");
                     s = ss.accept();
                     System.out.println("연결 수락함");
                     
                    
                     //클라이언트로부터 서버에 신호 받기
                     is = s.getInputStream();
                     while((count = is.read(bytes)) !=-1 ) {
                     sign = new String(bytes, 0, count);
                     }
                     
                     //send 서버에서 클라이언트로 파일 전송
                     if(sign.equals("save")) {
                        System.out.println("save 신호받음");
                        Send send = new Send();
                        send.start();
                        System.out.println("파일 전송(내 send) 서버 연결");
                     //save 클라이언트에서 서버로 파일 다운
                     }else if(sign.equals("send")){
                        System.out.println("send 신호받음");
                        Save save = new Save();
                        save.start();
                        System.out.println("파일 다운(내 save) 서버 연결");
                     }
                     
                     is.close();
                  }
               }catch(Exception ex) { ex.printStackTrace(); }
               
            }
         };
         es.execute(task);
      }
   

   private JTextField getTextField() {
      if (textField == null) {
         textField = new JTextField();
         textField.setColumns(10);
      }
      return textField;
   }
   private JButton getBtnNewButton() {
      if (btnNewButton == null) {
         btnNewButton = new JButton("New button");
         btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               start();
            }
         });
      }
      return btnNewButton;
   }
   private JScrollPane getScrollPane() {
      if (scrollPane == null) {
         scrollPane = new JScrollPane();
         scrollPane.setViewportView(getTextArea());
      }
      return scrollPane;
   }
   private JTextArea getTextArea() {
      if (textArea == null) {
         textArea = new JTextArea();
      }
      return textArea;
   }
}