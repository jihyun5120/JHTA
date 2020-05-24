package semishit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

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
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class EmployeesInsert extends JDialog {
   Emplyoees emp;
   String fileName = "";
   String filePath = "";
   private final JPanel contentPanel = new JPanel();
   private JButton btnNewButton;
   private JScrollPane scrollPane;
   private JTextArea tremark;
   private JButton btnNewButton_1;
   private JTextField teNum;
   private JTextField teName;
   private JTextField tbDate;
   private JTextField tphone;
   private JTextField temail;
   private JTextField taddress;
   private JTextField tjName;
   private JTextField thDate;

   private JLabel tePhoto;
   private JLabel lblNewLabel;
   private JTextField tsalary;

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
   public EmployeesInsert() {
      setTitle("Á÷¿øµî·Ï");
      setVisible(true);
      setBounds(100, 100, 370, 510);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);
      {
         JLabel lblNewLabel_1 = new JLabel("\uC0AC\uC6D0\uBC88\uD638");
         lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         lblNewLabel_1.setBounds(12, 10, 57, 15);
         contentPanel.add(lblNewLabel_1);
      }
      {
         JLabel lblNewLabel_2 = new JLabel("ÁÖ¼Ò");
         lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         lblNewLabel_2.setBounds(12, 233, 57, 15);
         contentPanel.add(lblNewLabel_2);
      }
      {
         JLabel lblNewLabel_3 = new JLabel("\uC131\uBA85");
         lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_3.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         lblNewLabel_3.setBounds(12, 60, 57, 15);
         contentPanel.add(lblNewLabel_3);
      }
      {
         JLabel lblNewLabel_4 = new JLabel("ÀÌ¸ÞÀÏ");
         lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_4.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         lblNewLabel_4.setBounds(12, 208, 57, 15);
         contentPanel.add(lblNewLabel_4);
      }
      {
         JLabel lblNewLabel_5 = new JLabel("»ý³â¿ùÀÏ");
         lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_5.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         lblNewLabel_5.setBounds(12, 108, 57, 15);
         contentPanel.add(lblNewLabel_5);
      }
      {
         JLabel lblNewLabel_6 = new JLabel("Á÷Ã¥");
         lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_6.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         lblNewLabel_6.setBounds(12, 258, 57, 15);
         contentPanel.add(lblNewLabel_6);
      }
      {
         JLabel lblNewLabel_7 = new JLabel("\uC5F0\uB77D\uCC98");
         lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_7.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         lblNewLabel_7.setBounds(12, 158, 57, 15);
         contentPanel.add(lblNewLabel_7);
      }
      {
         JLabel lblNewLabel_8 = new JLabel("ÀÔ»çÀÏ");
         lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_8.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         lblNewLabel_8.setBounds(12, 283, 57, 15);
         contentPanel.add(lblNewLabel_8);
      }
      {
         JLabel lblNewLabel_9 = new JLabel("Æ¯ÀÌ»çÇ×");
         lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_9.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         lblNewLabel_9.setBounds(12, 308, 57, 15);
         contentPanel.add(lblNewLabel_9);
      }
      contentPanel.add(getBtnNewButton());
      contentPanel.add(getScrollPane());
      contentPanel.add(getBtnNewButton_1());
      contentPanel.add(getTeNum());
      contentPanel.add(getTeName());
      contentPanel.add(getTbDate());
      contentPanel.add(getTphone());
      contentPanel.add(getTemail());
      {
         taddress = new JTextField();
         taddress.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         taddress.setBounds(81, 230, 261, 21);
         contentPanel.add(taddress);
         taddress.setColumns(10);
      }
      {
         tjName = new JTextField();
         tjName.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         tjName.setBounds(81, 255, 116, 21);
         contentPanel.add(tjName);
         tjName.setColumns(10);
      }
      {
         thDate = new JTextField();
         thDate.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
               if (thDate.getText().equals("yyyy-mm-dd")) {
                  thDate.setText("");
               }
            }
         });
         thDate.setText("yyyy-mm-dd");
         thDate.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         thDate.setBounds(81, 280, 116, 21);
         contentPanel.add(thDate);
         thDate.setColumns(10);
      }
      contentPanel.add(getTePhoto());
      contentPanel.add(getLblNewLabel());
      contentPanel.add(getTsalary());
   }

   public EmployeesInsert(Emplyoees emp) {
      this();
      this.emp = emp;
   }

   private JButton getBtnNewButton() {
      if (btnNewButton == null) {
         btnNewButton = new JButton("ÀÔ·Â");
         btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               EmployeesDao dao = new EmployeesDao();
               EmployeesVo vo = new EmployeesVo();
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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

                  int cnt = dao.empInsert(vo);

                  if (cnt > 0) {
                     JOptionPane.showMessageDialog(btnNewButton, "µî·ÏµÇ¾ú½À´Ï´Ù");
                     dispose();
                     EmployeesDao dao1 = new EmployeesDao();

                     emp.model = null;
                     emp.model = dao1.newTableGetSelect();
                     emp.table.setModel(emp.model);

                  } else {
                     JOptionPane.showMessageDialog(btnNewButton, "½ÇÆÐÇÏ¿´½À´Ï´Ù");
                  }

               } catch (Exception e2) {
                  e2.printStackTrace();
                  JOptionPane.showMessageDialog(btnNewButton, "¾ç½ÄÀ» ´Ù½Ã È®ÀÎÇØÁÖ¼¼¿ä");
               }

            }
         });
         btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         btnNewButton.setBounds(133, 439, 97, 23);
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
         tremark.setFont(new Font("±¼¸²", Font.PLAIN, 11));
      }
      return tremark;
   }

   private JButton getBtnNewButton_1() {
      if (btnNewButton_1 == null) {
         btnNewButton_1 = new JButton("»çÁøµî·Ï");
         btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               JFileChooser fc = new JFileChooser();

               fc.setMultiSelectionEnabled(true);
               int flag = fc.showOpenDialog(EmployeesInsert.this);
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
         btnNewButton_1.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         btnNewButton_1.setBounds(247, 172, 81, 23);
      }
      return btnNewButton_1;
   }

   public JTextField getTeNum() {
      if (teNum == null) {
         teNum = new JTextField();
         teNum.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
               EmployeesDao dao = new EmployeesDao();
               boolean result = dao.eNumCheck(Integer.parseInt(teNum.getText()));
               if (result == true) {
                  JOptionPane.showMessageDialog(teNum, "»ç¿ø¹øÈ£°¡ ÀÌ¹Ì ÀÖ½À´Ï´Ù");
                  teNum.requestFocus();
                  teNum.selectAll();
               } else {
                  JOptionPane.showMessageDialog(teNum, "»ç¿ë°¡´ÉÇÕ´Ï´Ù");
               }
            }
         });
         teNum.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         teNum.setBounds(81, 7, 116, 21);
         teNum.setColumns(10);
      }
      return teNum;
   }

   public JTextField getTeName() {
      if (teName == null) {
         teName = new JTextField();
         teName.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         teName.setBounds(81, 57, 116, 21);
         teName.setColumns(10);
      }
      return teName;
   }

   public JTextField getTbDate() {
      if (tbDate == null) {
         tbDate = new JTextField();
         tbDate.setText("yyyy-mm-dd");
         tbDate.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
               if (tbDate.getText().equals("yyyy-mm-dd")) {
                  tbDate.setText("");
               }
            }
         });

         tbDate.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         tbDate.setBounds(81, 105, 116, 21);
         tbDate.setColumns(10);
      }
      return tbDate;
   }

   public JTextField getTphone() {
      if (tphone == null) {
         tphone = new JTextField();
         tphone.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
               if (tphone.getText().equals("000-0000-0000")) {
                  tphone.setText("");
               }
            }
         });
         tphone.setText("000-0000-0000");
         tphone.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         tphone.setBounds(81, 155, 116, 21);
         tphone.setColumns(10);
      }
      return tphone;
   }

   public JTextField getTemail() {
      if (temail == null) {
         temail = new JTextField();
         temail.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         temail.setBounds(81, 205, 261, 21);
         temail.setColumns(10);
      }
      return temail;
   }

   private JLabel getTePhoto() {
      if (tePhoto == null) {
         tePhoto = new JLabel();
         tePhoto.setIcon(new ImageIcon("C:\\Users\\JHTA\\Documents\\ePhoto\\basic.jpg"));
         tePhoto.setBounds(232, 10, 110, 160);
      }
      return tePhoto;
   }

   private JLabel getLblNewLabel() {
      if (lblNewLabel == null) {
         lblNewLabel = new JLabel("\uC6D4\uAE09");
         lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         lblNewLabel.setBounds(209, 257, 57, 15);
      }
      return lblNewLabel;
   }

   private JTextField getTsalary() {
      if (tsalary == null) {
         tsalary = new JTextField();
         tsalary.setFont(new Font("±¼¸²", Font.PLAIN, 11));
         tsalary.setBounds(278, 254, 64, 21);
         tsalary.setColumns(10);
      }
      return tsalary;
   }
}