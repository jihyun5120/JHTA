package h_api;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BoardInput extends JInternalFrame {
   private JLabel lblNewLabel_1;
   private JLabel lblNewLabel_2;
   private JLabel lblNewLabel_3;
   private JLabel lblNewLabel_5;
   private JTextField subject;
   private JTextField content;
   private JTextField mId;
   private JTextField read;
   private JButton btnNewButton;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               BoardInput frame = new BoardInput();
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
   public BoardInput() {
      super("값 입력", false, true, true, true);
      setBounds(100, 100, 438, 347);
      getContentPane().setLayout(null);
      getContentPane().add(getLblNewLabel_1());
      getContentPane().add(getLblNewLabel_2());
      getContentPane().add(getLblNewLabel_3());
      getContentPane().add(getLblNewLabel_5());
      getContentPane().add(getSubject());
      getContentPane().add(getContent());
      getContentPane().add(getMId());
      getContentPane().add(getRead());
      getContentPane().add(getBtnNewButton());
      setVisible(true);
   }
   private JLabel getLblNewLabel_1() {
      if (lblNewLabel_1 == null) {
         lblNewLabel_1 = new JLabel("\uC81C\uBAA9");
         lblNewLabel_1.setBounds(12, 32, 57, 15);
      }
      return lblNewLabel_1;
   }
   private JLabel getLblNewLabel_2() {
      if (lblNewLabel_2 == null) {
         lblNewLabel_2 = new JLabel("\uB0B4\uC6A9");
         lblNewLabel_2.setBounds(12, 104, 57, 15);
      }
      return lblNewLabel_2;
   }
   private JLabel getLblNewLabel_3() {
      if (lblNewLabel_3 == null) {
         lblNewLabel_3 = new JLabel("\uC791\uC131\uC790 \uC544\uC774\uB514");
         lblNewLabel_3.setBounds(12, 205, 90, 15);
      }
      return lblNewLabel_3;
   }
   private JLabel getLblNewLabel_5() {
      if (lblNewLabel_5 == null) {
         lblNewLabel_5 = new JLabel("\uC870\uD68C\uC218");
         lblNewLabel_5.setBounds(12, 236, 57, 15);
      }
      return lblNewLabel_5;
   }
   private JTextField getSubject() {
      if (subject == null) {
         subject = new JTextField();
         subject.setBounds(156, 21, 243, 37);
         subject.setColumns(10);
      }
      return subject;
   }
   private JTextField getContent() {
      if (content == null) {
         content = new JTextField();
         content.setBounds(156, 69, 243, 123);
         content.setColumns(10);
      }
      return content;
   }
   private JTextField getMId() {
      if (mId == null) {
         mId = new JTextField();
         mId.setBounds(156, 202, 116, 21);
         mId.setColumns(10);
      }
      return mId;
   }
   private JTextField getRead() {
      if (read == null) {
         read = new JTextField();
         read.setBounds(156, 233, 116, 21);
         read.setColumns(10);
      }
      return read;
   }
   private JButton getBtnNewButton() {
      if (btnNewButton == null) {
         btnNewButton = new JButton("\uAC8C\uC2DC\uBB3C \uC791\uC131");
         btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Date dt = new Date();
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
               
               BoardVo bv = new BoardVo(BoardMain.count, subject.getText(), content.getText(), mId.getText(), sdf.format(dt),read.getText());
               BoardMain.data[BoardMain.count] = bv;
               BoardMain.count++;
            }
         });
         btnNewButton.setBounds(283, 201, 116, 85);
      }
      return btnNewButton;
   }
}