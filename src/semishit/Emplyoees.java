package semishit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Emplyoees extends JInternalFrame {
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   DefaultTableModel model = new DefaultTableModel();
   EmployeesVo vo = new EmployeesVo();

   private JPanel panel;
   private JPanel panel_1;
   private JLabel lblNewLabel_1;
   private JPanel panel_2;
   private JLabel lblNewLabel;
   private JScrollPane scrollPane;
   public JTable table;
   private JButton btnNewButton;
   private JButton btnNewButton_1;
   private JButton btnNewButton_2;
   private JTextField find;
   private JComboBox comboBox;
   private JPanel panel_3;
   private JLabel tePhoto;
   private JLabel lblNewLabel_2;
   private JLabel lblNewLabel_4;
   private JLabel lblNewLabel_5;
   private JLabel lblNewLabel_6;
   private JLabel lblNewLabel_7;
   public JTextField teNum;
   public JTextField teName;
   public JTextField tbDate;
   public JTextField tphoen;
   public JTextField temail;
   private JLabel lblNewLabel_9;
   public JTextField taddress;
   private JLabel lblNewLabel_10;
   public JTextField tjName;
   private JLabel lblNewLabel_11;
   public JTextField thDate;
   private JLabel lblNewLabel_8;
   private JScrollPane scrollPane_1;
   public JTextArea tremark;
   private JLabel lblNewLabel_3;
   private JTextField tsalary;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Emplyoees frame = new Emplyoees();
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
   public Emplyoees() {
      super("직원관리", false, true, true, true);
      setVisible(true);
      setBounds(100, 100, 883, 577);
      getContentPane().setLayout(new BorderLayout(0, 0));
      getContentPane().add(getPanel(), BorderLayout.EAST);
      getContentPane().add(getPanel_1(), BorderLayout.SOUTH);
      getContentPane().add(getLblNewLabel(), BorderLayout.NORTH);
      getContentPane().add(getScrollPane(), BorderLayout.CENTER);

      model();

   }

   public void model() {
      EmployeesDao dao = new EmployeesDao();
      model = dao.tableGetSelect(model);
      table.setModel(model);

   }

   private JPanel getPanel() {
      if (panel == null) {
         panel = new JPanel();
         panel.setPreferredSize(new Dimension(300, 10));
         panel.setLayout(new BorderLayout(0, 0));
         panel.add(getLblNewLabel_1(), BorderLayout.NORTH);
         panel.add(getPanel_2(), BorderLayout.SOUTH);
         panel.add(getPanel_3_1(), BorderLayout.CENTER);
      }
      return panel;
   }

   private JPanel getPanel_1() {
      if (panel_1 == null) {
         panel_1 = new JPanel();
         panel_1.setPreferredSize(new Dimension(10, 30));
         panel_1.setLayout(null);
         panel_1.add(getComboBox());
         panel_1.add(getFind());
         panel_1.add(getBtnNewButton_2());
      }
      return panel_1;
   }

   private JLabel getLblNewLabel_1() {
      if (lblNewLabel_1 == null) {
         lblNewLabel_1 = new JLabel("직원정보");
         lblNewLabel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
         lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
      }
      return lblNewLabel_1;
   }

   private JPanel getPanel_2() {
      if (panel_2 == null) {
         panel_2 = new JPanel();
         panel_2.setPreferredSize(new Dimension(10, 30));
         panel_2.setLayout(null);
         panel_2.add(getBtnNewButton_1());
         panel_2.add(getBtnNewButton());
      }
      return panel_2;
   }

   private JLabel getLblNewLabel() {
      if (lblNewLabel == null) {
         lblNewLabel = new JLabel("직원목록");
         lblNewLabel.setOpaque(true);
         lblNewLabel.setBackground(new Color(102, 153, 204));
         lblNewLabel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
         lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
      }
      return lblNewLabel;
   }

   private JScrollPane getScrollPane() {
      if (scrollPane == null) {
         scrollPane = new JScrollPane();
         scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
         scrollPane.setViewportView(getTable());
      }
      return scrollPane;
   }

   public JTable getTable() {
      if (table == null) {
         table = new JTable() {
            public boolean isCellEditable(int row, int coulmn) {
               return false;

            }
         };
         table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
         table.setFont(new Font("굴림", Font.PLAIN, 11));
         table.setFillsViewportHeight(true);
         table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               EmployeesDao dao1 = new EmployeesDao();
               JTable jtable = (JTable) e.getSource();
               int row = jtable.getSelectedRow();
               model.getRowCount();

               vo = dao1.panelGetSelect(Integer.parseInt(model.getValueAt(row, 0).toString()));

               Thread t = new Receive1(vo.getePName(), vo.getePhoto());
               t.start();

               teNum.setText(vo.geteNum() + "");
               teName.setText(vo.geteName());
               tbDate.setText(sdf.format(vo.getbDate()));
               tphoen.setText(vo.getPhone());
               temail.setText(vo.getEmail());
               taddress.setText(vo.getAddress());
               tjName.setText(vo.getjName());
               thDate.setText(sdf.format(vo.gethDate()));
               tremark.setText(vo.getRemark());
               tePhoto.setIcon(new ImageIcon(vo.getePhoto()));
               tsalary.setText(vo.getSalary() + "");

               if (e.getClickCount() == 2) {
                  EmployeesModify em = new EmployeesModify();

                  em.teNum.setText(vo.geteNum() + "");
                  em.teName.setText(vo.geteName());
                  em.tbDate.setText(sdf.format(vo.getbDate()));
                  em.tphone.setText(vo.getPhone());
                  em.temail.setText(vo.getEmail());
                  em.taddress.setText(vo.getAddress());
                  em.tjName.setText(vo.getjName());
                  em.thDate.setText(sdf.format(vo.gethDate()));
                  em.tremark.setText(vo.getRemark());
                  em.tePhoto.setIcon(new ImageIcon(vo.getePhoto()));
                  em.tsalary.setText(vo.getSalary() + "");
               }
            }
         });
      }
      return table;
   }

   private JButton getBtnNewButton() {
      if (btnNewButton == null) {
         btnNewButton = new JButton("정보수정");
         btnNewButton.setFont(new Font("굴림", Font.PLAIN, 11));
         btnNewButton.setBounds(158, 0, 96, 28);
         btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if (teNum.getText().equals("")) {

                  JOptionPane.showMessageDialog(btnNewButton, "사원을 확인해주세요");
               } else {
                  EmployeesModify em = new EmployeesModify(Emplyoees.this);
                  em.teNum.setText(vo.geteNum() + "");
                  em.teName.setText(vo.geteName());
                  em.tbDate.setText(sdf.format(vo.getbDate()));
                  em.tphone.setText(vo.getPhone());
                  em.temail.setText(vo.getEmail());
                  em.taddress.setText(vo.getAddress());
                  em.tjName.setText(vo.getjName());
                  em.thDate.setText(sdf.format(vo.gethDate()));
                  em.tremark.setText(vo.getRemark());
                  em.tePhoto.setIcon(new ImageIcon(vo.getePhoto()));
                  em.tsalary.setText(vo.getSalary() + "");
               }
            }
         });
      }
      return btnNewButton;
   }

   private JButton getBtnNewButton_1() {
      if (btnNewButton_1 == null) {
         btnNewButton_1 = new JButton("직원등록");
         btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 11));
         btnNewButton_1.setBounds(50, 0, 96, 28);
         btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               EmployeesInsert ei = new EmployeesInsert(Emplyoees.this);

            }
         });
      }
      return btnNewButton_1;
   }

   private JButton getBtnNewButton_2() {
      if (btnNewButton_2 == null) {
         btnNewButton_2 = new JButton("조회");
         btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               EmployeesDao dao = new EmployeesDao();

               if (comboBox.getSelectedItem().toString() == "전체") {
                  model = null;
                  model = dao.allGetSelect(find.getText());
                  table.setModel(model);
               } else if (comboBox.getSelectedItem().toString() == "사원번호") {
                  model = null;
                  model = dao.eNumGetSelect(find.getText());
                  table.setModel(model);
               } else if (comboBox.getSelectedItem().toString() == "성명") {
                  model = null;
                  model = dao.eNameGetSelect(find.getText());
                  table.setModel(model);
               } else if (comboBox.getSelectedItem().toString() == "직책") {
                  model = null;
                  model = dao.jNameGetSelect(find.getText());
                  table.setModel(model);
               }

            }
         });
         btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 11));
         btnNewButton_2.setBounds(486, 0, 82, 30);
      }
      return btnNewButton_2;
   }

   private JTextField getFind() {
      if (find == null) {
         find = new JTextField();
         find.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
               if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                  EmployeesDao dao = new EmployeesDao();

                  if (comboBox.getSelectedItem().toString() == "전체") {
                     model = null;
                     model = dao.allGetSelect(find.getText());
                     table.setModel(model);
                  } else if (comboBox.getSelectedItem().toString() == "사원번호") {
                     model = null;
                     model = dao.eNumGetSelect(find.getText());
                     table.setModel(model);
                  } else if (comboBox.getSelectedItem().toString() == "성명") {
                     model = null;
                     model = dao.eNameGetSelect(find.getText());
                     table.setModel(model);
                  } else if (comboBox.getSelectedItem().toString() == "직책") {
                     model = null;
                     model = dao.jNameGetSelect(find.getText());
                     table.setModel(model);
                  }
               }
            }
         });
         find.setBounds(314, 1, 172, 30);
         find.setColumns(10);
      }
      return find;
   }

   private JComboBox getComboBox() {
      if (comboBox == null) {
         comboBox = new JComboBox();
         comboBox.setFont(new Font("굴림", Font.PLAIN, 11));
         comboBox.setModel(new DefaultComboBoxModel(new String[] { "전체", "사원번호", "성명", "직책" }));
         comboBox.setBounds(238, 0, 74, 30);
      }
      return comboBox;
   }

   private JPanel getPanel_3_1() {
      if (panel_3 == null) {
         panel_3 = new JPanel();
         panel_3.setLayout(null);
         panel_3.add(getTePhoto());
         panel_3.add(getLblNewLabel_2());
         panel_3.add(getLblNewLabel_4());
         panel_3.add(getLblNewLabel_5());
         panel_3.add(getLblNewLabel_6());
         panel_3.add(getLblNewLabel_7());
         panel_3.add(getTeNum());
         panel_3.add(getTeName());
         panel_3.add(getTbDate());
         panel_3.add(getTphoen());
         panel_3.add(getTemail());
         panel_3.add(getLblNewLabel_9());
         panel_3.add(getTaddress());
         panel_3.add(getLblNewLabel_10());
         panel_3.add(getTjName());
         panel_3.add(getLblNewLabel_11());
         panel_3.add(getThDate());
         panel_3.add(getLblNewLabel_8());
         panel_3.add(getScrollPane_1());
         panel_3.add(getLblNewLabel_3());
         panel_3.add(getTsalary());
      }
      return panel_3;
   }

   private JLabel getTePhoto() {
      if (tePhoto == null) {
         tePhoto = new JLabel();
         tePhoto.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
         tePhoto.setHorizontalAlignment(SwingConstants.CENTER);
         tePhoto.setBounds(179, 10, 110, 160);
      }
      return tePhoto;
   }

   private JLabel getLblNewLabel_2() {
      if (lblNewLabel_2 == null) {
         lblNewLabel_2 = new JLabel("사원번호");
         lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_2.setBounds(12, 10, 57, 15);
      }
      return lblNewLabel_2;
   }

   private JLabel getLblNewLabel_4() {
      if (lblNewLabel_4 == null) {
         lblNewLabel_4 = new JLabel("성명");
         lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_4.setBounds(12, 60, 57, 15);
      }
      return lblNewLabel_4;
   }

   private JLabel getLblNewLabel_5() {
      if (lblNewLabel_5 == null) {
         lblNewLabel_5 = new JLabel("생년월일");
         lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_5.setBounds(12, 108, 57, 15);
      }
      return lblNewLabel_5;
   }

   private JLabel getLblNewLabel_6() {
      if (lblNewLabel_6 == null) {
         lblNewLabel_6 = new JLabel("연락처");
         lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_6.setBounds(12, 158, 57, 15);
      }
      return lblNewLabel_6;
   }

   private JLabel getLblNewLabel_7() {
      if (lblNewLabel_7 == null) {
         lblNewLabel_7 = new JLabel("이메일");
         lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_7.setBounds(12, 208, 57, 15);
      }
      return lblNewLabel_7;
   }

   private JTextField getTeNum() {
      if (teNum == null) {
         teNum = new JTextField();
         teNum.setFont(new Font("굴림", Font.PLAIN, 11));
         teNum.setEditable(false);
         teNum.setBounds(81, 7, 86, 21);
         teNum.setColumns(10);
      }
      return teNum;
   }

   private JTextField getTeName() {
      if (teName == null) {
         teName = new JTextField();
         teName.setFont(new Font("굴림", Font.PLAIN, 11));
         teName.setEditable(false);
         teName.setBounds(81, 57, 86, 21);
         teName.setColumns(10);
      }
      return teName;
   }

   private JTextField getTbDate() {
      if (tbDate == null) {
         tbDate = new JTextField();
         tbDate.setFont(new Font("굴림", Font.PLAIN, 11));
         tbDate.setEditable(false);
         tbDate.setBounds(81, 105, 86, 21);
         tbDate.setColumns(10);
      }
      return tbDate;
   }

   private JTextField getTphoen() {
      if (tphoen == null) {
         tphoen = new JTextField();
         tphoen.setFont(new Font("굴림", Font.PLAIN, 11));
         tphoen.setEditable(false);
         tphoen.setBounds(81, 155, 86, 21);
         tphoen.setColumns(10);
      }
      return tphoen;
   }

   private JTextField getTemail() {
      if (temail == null) {
         temail = new JTextField();
         temail.setFont(new Font("굴림", Font.PLAIN, 11));
         temail.setEditable(false);
         temail.setBounds(81, 205, 208, 21);
         temail.setColumns(10);
      }
      return temail;
   }

   private JLabel getLblNewLabel_9() {
      if (lblNewLabel_9 == null) {
         lblNewLabel_9 = new JLabel("주소");
         lblNewLabel_9.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_9.setBounds(12, 233, 57, 15);
      }
      return lblNewLabel_9;
   }

   private JTextField getTaddress() {
      if (taddress == null) {
         taddress = new JTextField();
         taddress.setFont(new Font("굴림", Font.PLAIN, 11));
         taddress.setEditable(false);
         taddress.setBounds(81, 230, 208, 21);
         taddress.setColumns(10);
      }
      return taddress;
   }

   private JLabel getLblNewLabel_10() {
      if (lblNewLabel_10 == null) {
         lblNewLabel_10 = new JLabel("직책");
         lblNewLabel_10.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_10.setBounds(12, 258, 57, 15);
      }
      return lblNewLabel_10;
   }

   private JTextField getTjName() {
      if (tjName == null) {
         tjName = new JTextField();
         tjName.setFont(new Font("굴림", Font.PLAIN, 11));
         tjName.setEditable(false);
         tjName.setBounds(81, 255, 86, 21);
         tjName.setColumns(10);
      }
      return tjName;
   }

   private JLabel getLblNewLabel_11() {
      if (lblNewLabel_11 == null) {
         lblNewLabel_11 = new JLabel("입사일");
         lblNewLabel_11.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_11.setBounds(12, 283, 57, 15);
      }
      return lblNewLabel_11;
   }

   private JTextField getThDate() {
      if (thDate == null) {
         thDate = new JTextField();
         thDate.setFont(new Font("굴림", Font.PLAIN, 11));
         thDate.setEditable(false);
         thDate.setBounds(81, 280, 86, 21);
         thDate.setColumns(10);
      }
      return thDate;
   }

   private JLabel getLblNewLabel_8() {
      if (lblNewLabel_8 == null) {
         lblNewLabel_8 = new JLabel("특이사항");
         lblNewLabel_8.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_8.setBounds(12, 308, 57, 15);
      }
      return lblNewLabel_8;
   }

   private JScrollPane getScrollPane_1() {
      if (scrollPane_1 == null) {
         scrollPane_1 = new JScrollPane();
         scrollPane_1.setBounds(12, 333, 276, 90);
         scrollPane_1.setViewportView(getTremark());
      }
      return scrollPane_1;
   }

   private JTextArea getTremark() {
      if (tremark == null) {
         tremark = new JTextArea();
         tremark.setEditable(false);
      }
      return tremark;
   }

   private JLabel getLblNewLabel_3() {
      if (lblNewLabel_3 == null) {
         lblNewLabel_3 = new JLabel("월급");
         lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 11));
         lblNewLabel_3.setBounds(179, 257, 45, 15);
      }
      return lblNewLabel_3;
   }

   private JTextField getTsalary() {
      if (tsalary == null) {
         tsalary = new JTextField();
         tsalary.setEditable(false);
         tsalary.setFont(new Font("굴림", Font.PLAIN, 11));
         tsalary.setBounds(236, 254, 52, 21);
         tsalary.setColumns(10);
      }
      return tsalary;
   }
}