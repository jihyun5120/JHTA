package semishit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class EmployeesModify extends JDialog {
   Emplyoees emp;
   String fileName = "";
   String filePath = "";
   private final JPanel contentPanel = new JPanel();
   private JButton btnNewButton;
   private JScrollPane scrollPane;
   public JTextArea tremark;
   private JButton btnNewButton_1;
   public JTextField teNum;
   public JTextField teName;
   public JTextField tbDate;
   public JTextField tphone;
   public JTextField temail;
   public JTextField taddress;
   public JTextField tjName;
   public JTextField thDate;
   private JButton btnNewButton_2;
   public JLabel tePhoto;
   private JLabel lblNewLabel;
   public JTextField tsalary;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      try {
         EmployeesInsert dialog = new EmployeesInsert();
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Create the dialog.
    */
   public EmployeesModify() {
      setTitle("직원등록");
      setVisible(true);
      setBounds(100, 100, 370, 510);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);

      {
         JLabel lblNewLabel_1 = new JLabel("사원번호");
         lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_1.setBounds(12, 10, 57, 15);
         contentPanel.add(lblNewLabel_1);
      }
      {
         JLabel lblNewLabel_2 = new JLabel("주소");
         lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_2.setBounds(12, 233, 57, 15);
         contentPanel.add(lblNewLabel_2);
      }
      {
         JLabel lblNewLabel_3 = new JLabel("성명");
         lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_3.setBounds(12, 60, 57, 15);
         contentPanel.add(lblNewLabel_3);
      }
      {
         JLabel lblNewLabel_4 = new JLabel("이메일");
         lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_4.setBounds(12, 208, 57, 15);
         contentPanel.add(lblNewLabel_4);
      }
      {
         JLabel lblNewLabel_5 = new JLabel("생년월일");
         lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_5.setBounds(12, 108, 57, 15);
         contentPanel.add(lblNewLabel_5);
      }
      {
         JLabel lblNewLabel_6 = new JLabel("직책");
         lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_6.setBounds(12, 258, 57, 15);
         contentPanel.add(lblNewLabel_6);
      }
      {
         JLabel lblNewLabel_7 = new JLabel("연락처");
         lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_7.setBounds(12, 158, 57, 15);
         contentPanel.add(lblNewLabel_7);
      }
      {
         JLabel lblNewLabel_8 = new JLabel("입사일");
         lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_8.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_8.setBounds(12, 283, 57, 15);
         contentPanel.add(lblNewLabel_8);
      }
      {
         JLabel lblNewLabel_9 = new JLabel("특이사항");
         lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_9.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_9.setBounds(12, 308, 57, 15);
         contentPanel.add(lblNewLabel_9);
      }
      contentPanel.add(getBtnNewButton());
      contentPanel.add(getBtnNewButton_2());
      contentPanel.add(getScrollPane());
      contentPanel.add(getBtnNewButton_1());
      contentPanel.add(getTeNum());
      contentPanel.add(getTeName());
      contentPanel.add(getTbDate());
      contentPanel.add(getTphone());
      contentPanel.add(getTemail());
      {
         taddress = new JTextField();
         taddress.setFont(new Font("굴림", Font.PLAIN, 11));
         taddress.setBounds(81, 230, 261, 21);
         contentPanel.add(taddress);
         taddress.setColumns(10);
      }
      {
         tjName = new JTextField();
         tjName.setFont(new Font("굴림", Font.PLAIN, 11));
         tjName.setBounds(81, 255, 116, 21);
         contentPanel.add(tjName);
         tjName.setColumns(10);
      }
      {
         thDate = new JTextField();
         thDate.setFont(new Font("굴림", Font.PLAIN, 11));
         thDate.setBounds(81, 280, 116, 21);
         contentPanel.add(thDate);
         thDate.setColumns(10);
      }
      {
         JPanel buttonPane = new JPanel();
         buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
         getContentPane().add(buttonPane, BorderLayout.SOUTH);
      }

      contentPanel.add(getTePhoto());
      contentPanel.add(getLblNewLabel());
      contentPanel.add(getTsalary());
   }

   public EmployeesModify(Emplyoees emp) {
      this();
      this.emp = emp;
   }

   private JButton getBtnNewButton() {
      if (btnNewButton == null) {
         btnNewButton = new JButton("수정");
         btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               EmployeesDao dao = new EmployeesDao();
               EmployeesVo vo = new EmployeesVo();
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

               try {
                  vo.seteNum(Integer.parseInt(teNum.getText()));
                  vo.seteName(teName.getText());
                  vo.setbDate(sdf.parse(tbDate.getText()));
                  vo.setPhone(tphone.getText());
                  vo.setEmail(temail.getText());
                  vo.setAddress(taddress.getText());
                  vo.setjName(tjName.getText());
                  vo.sethDate(sdf.parse(thDate.getText()));
                  vo.setRemark(tremark.getText());
                  vo.setePhoto(tePhoto.getIcon().toString());
                  vo.setSalary(Integer.parseInt(tsalary.getText()));
                  vo.setePName(fileName);
                  
                  System.out.println(fileName);
                  int cnt = dao.empUpdate(vo);
                  if (cnt > 0) {
                     JOptionPane.showMessageDialog(btnNewButton, "수정되었습니다");
                     dispose();
                     EmployeesDao dao1 = new EmployeesDao();
                     emp.model = null;
                     emp.model = dao1.newTableGetSelect();
                     emp.table.setModel(emp.model);

                  } else {
                     JOptionPane.showMessageDialog(btnNewButton, "실패하였습니다");
                  }

               } catch (Exception e1) {
                  JOptionPane.showMessageDialog(btnNewButton, "양식을 다시 확인해주세요");
               }
            }
         });
         btnNewButton.setFont(new Font("굴림", Font.PLAIN, 11));
         btnNewButton.setBounds(81, 439, 97, 23);
      }
      return btnNewButton;
   }

   private JScrollPane getScrollPane() {
      if (scrollPane == null) {
         scrollPane = new JScrollPane();
         scrollPane.setBounds(12, 338, 330, 91);
         scrollPane.setViewportView(getTremark());
      }
      return scrollPane;
   }

   public JTextArea getTremark() {
      if (tremark == null) {
         tremark = new JTextArea();
         tremark.setFont(new Font("굴림", Font.PLAIN, 11));
      }
      return tremark;
   }

   private JButton getBtnNewButton_1() {
      if (btnNewButton_1 == null) {
         btnNewButton_1 = new JButton("사진변경");
         btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               JFileChooser fc = new JFileChooser();

               fc.setMultiSelectionEnabled(true);
               int flag = fc.showOpenDialog(EmployeesModify.this);
               if (flag == JFileChooser.APPROVE_OPTION) {
                  File[] tempFiles = fc.getSelectedFiles();
                  for (File f : tempFiles) {
                     tePhoto.setIcon(new ImageIcon(f.getPath()));
                     fileName = f.getName();
                     filePath = f.getPath();
                     Thread t = new Send1(fileName, filePath);
                     t.start();
                  }
               }

            }
         });
         btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 11));
         btnNewButton_1.setBounds(247, 172, 81, 23);
      }
      return btnNewButton_1;
   }

   public JTextField getTeNum() {
      if (teNum == null) {
         teNum = new JTextField();
         teNum.setEditable(false);
         teNum.setFont(new Font("굴림", Font.PLAIN, 11));
         teNum.setBounds(81, 7, 116, 21);
         teNum.setColumns(10);
      }
      return teNum;
   }

   public JTextField getTeName() {
      if (teName == null) {
         teName = new JTextField();
         teName.setFont(new Font("굴림", Font.PLAIN, 11));
         teName.setBounds(81, 57, 116, 21);
         teName.setColumns(10);
      }
      return teName;
   }

   public JTextField getTbDate() {
      if (tbDate == null) {
         tbDate = new JTextField();
         tbDate.setFont(new Font("굴림", Font.PLAIN, 11));
         tbDate.setBounds(81, 105, 116, 21);
         tbDate.setColumns(10);
      }
      return tbDate;
   }

   public JTextField getTphone() {
      if (tphone == null) {
         tphone = new JTextField();
         tphone.setFont(new Font("굴림", Font.PLAIN, 11));
         tphone.setBounds(81, 155, 116, 21);
         tphone.setColumns(10);
      }
      return tphone;
   }

   public JTextField getTemail() {
      if (temail == null) {
         temail = new JTextField();
         temail.setFont(new Font("굴림", Font.PLAIN, 11));
         temail.setBounds(81, 205, 261, 21);
         temail.setColumns(10);
      }
      return temail;
   }

   private JButton getBtnNewButton_2() {
      if (btnNewButton_2 == null) {
         btnNewButton_2 = new JButton("삭제");
         btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 11));
         btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               EmployeesDao dao = new EmployeesDao();
               int serial = Integer.parseInt(teNum.getText());
               int cnt = dao.empDelete(serial);
               if (cnt > 0) {
                  JOptionPane.showMessageDialog(btnNewButton, "삭제되었습니다");
                  dispose();
                  EmployeesDao dao1 = new EmployeesDao();
                  emp.model = null;
                  emp.model = dao1.newTableGetSelect();
                  emp.table.setModel(emp.model);

               } else {
                  JOptionPane.showMessageDialog(btnNewButton, "실패하였습니다");
               }
            }
         });
         btnNewButton_2.setBounds(190, 438, 97, 23);
      }
      return btnNewButton_2;
   }

   public JLabel getTePhoto() {
      if (tePhoto == null) {
         tePhoto = new JLabel();
         tePhoto.setBounds(232, 10, 110, 160);
      }
      return tePhoto;
   }

   private JLabel getLblNewLabel() {
      if (lblNewLabel == null) {
         lblNewLabel = new JLabel("\uC6D4\uAE09");
         lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel.setBounds(209, 257, 57, 15);
      }
      return lblNewLabel;
   }

   public JTextField getTsalary() {
      if (tsalary == null) {
         tsalary = new JTextField();
         tsalary.setFont(new Font("굴림", Font.PLAIN, 11));
         tsalary.setBounds(278, 254, 64, 21);
         tsalary.setColumns(10);
      }
      return tsalary;
   }
}