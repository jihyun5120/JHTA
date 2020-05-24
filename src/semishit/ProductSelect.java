package semishit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class ProductSelect extends JInternalFrame {
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
   Vector <ProductVo> list;
   Connection conn;
   PreparedStatement ps;
   DefaultTableModel model;
   Socket socket;

   
   private JPanel panel;
   public  JTextField textField;
   private JButton btnNewButton;
   private JPanel panel_2;
   private JLabel lblNewLabel;
   private JScrollPane scrollPane;
   public  JTable table;
   private JComboBox comboBox;
   private JPanel panel_3;
   private JButton btnNewButton_1;
 
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               ProductSelect frame = new ProductSelect();
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
   public ProductSelect() {
      super("비품관리", true, true, true, true);
      getContentPane().setBackground(Color.WHITE);
      setBackground(Color.WHITE);
      setBounds(100, 100, 1070, 622);
      getContentPane().add(getPanel_1(), BorderLayout.SOUTH);
      getContentPane().add(getPanel_2(), BorderLayout.WEST);
      getContentPane().add(getPanel_3_1(), BorderLayout.EAST);
      refresh(); 
      setVisible(true);
   }
   
   public void refresh() { //조회목록테이블에 띄우기
      ProductDao dao = new ProductDao();
      model = dao.list();
      table.setModel(model);
      table.setAutoCreateRowSorter(true);
   }
   
   private JButton getBtnNewButton() { //조회버튼
         if (btnNewButton == null) {
            btnNewButton = new JButton("조회");
            btnNewButton.setBackground(new Color(255, 182, 193));
            btnNewButton.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
            btnNewButton.setBounds(548, 4, 80, 25);
            btnNewButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent arg0) {
                  ProductDao dao = new ProductDao();
                  int index = comboBox.getSelectedIndex();
                  String find = textField.getText();
                  model = dao.select(index, find);
                  table.setModel(model);
                  textField.requestFocus();
                  textField.selectAll();
               }
            });
            btnNewButton.setPreferredSize(new Dimension(60, 25));
         }
         return btnNewButton;
      }
   
   private JTable getTable() { //조회목록
         if (table == null) {
            table = new JTable();
            table.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 12));
            table.setBackground(Color.WHITE);
            table.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  //조회목록에서 수정할 데이터 누르면.
                  ProductDao dao = new ProductDao();
                  ProductVo vo = new ProductVo();
                  int row = table.getSelectedRow();
                  String pId = (table.getValueAt(row, 0)+"");
                  vo = dao.im(pId);
                  
                  String fileName = vo.imName;
                  String path = vo.imPath;
                  
                  Thread thread = new Receive1(fileName, path);
                  thread.start();
                  
                  panel_3.removeAll();
                  ProductUpdate update = new ProductUpdate(ProductSelect.this, fileName);
                  panel_3.add(update); 
                  panel_3.updateUI();
                  
                  ImageIcon old = new ImageIcon(path);
                  Image oldImage = old.getImage();
                  Image newImage = oldImage.getScaledInstance(update.image.getWidth(), update.image.getHeight(), Image.SCALE_DEFAULT);
                  update.image.setIcon(new ImageIcon(newImage));
                  
                  String pri = (String)table.getValueAt(row, 3);
                  String price = pri.replaceAll("[^0-9]", "");
                  String tot = (String)table.getValueAt(row, 4);
                  String totPrice = tot.replaceAll("[^0-9]", "");
                  
                  
                  try {
                  update.tprice.setText(price);
                  update.tpId.setText((String)table.getValueAt(row, 0));
                  update.tpName.setText((String)table.getValueAt(row, 1));
                  update.tea.setValue(Integer.parseInt((String)table.getValueAt(row, 2)));
                  update.ttotPrice.setText(totPrice);
                  update.tiDate.setDate(sdf.parse(table.getValueAt(row, 5).toString()));
                  update.tnote.setText((String)table.getValueAt(row, 6));
                  } catch (ParseException e1) {
					e1.printStackTrace();
				}
               }
            });
         }
         return table;
      }
   
   private JPanel getPanel_1() {
      if (panel == null) {
         panel = new JPanel();
         panel.setBackground(Color.WHITE);
         panel.setPreferredSize(new Dimension(10, 30));
         panel.setLayout(null);
         panel.add(getTextField());
         panel.add(getComboBox());
         panel.add(getBtnNewButton());
         panel.add(getBtnNewButton_1());
      }
      return panel;
   }
   public JTextField getTextField() {
      if (textField == null) {
         textField = new JTextField();
         textField.setBackground(new Color(245, 245, 245));
         textField.setBounds(252, 6, 284, 20);
         textField.setColumns(10);
      }
      return textField;
   }
   private JPanel getPanel_2() {
      if (panel_2 == null) {
         panel_2 = new JPanel();
         panel_2.setBackground(Color.WHITE);
         panel_2.setPreferredSize(new Dimension(750, 10));
         panel_2.setLayout(new BorderLayout(0, 0));
         panel_2.add(getLblNewLabel());
         panel_2.add(getScrollPane());
      }
      return panel_2;
   }
   private JLabel getLblNewLabel() {
      if (lblNewLabel == null) {
         lblNewLabel = new JLabel("\uBE44\uD488\uC870\uD68C\uBAA9\uB85D");
         lblNewLabel.setPreferredSize(new Dimension(72, 30));
         lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      }
      return lblNewLabel;
   }
   private JScrollPane getScrollPane() {
      if (scrollPane == null) {
         scrollPane = new JScrollPane();
         scrollPane.setBackground(Color.WHITE);
         scrollPane.setViewportView(getTable());
      }
      return scrollPane;
   }
   private JComboBox getComboBox() {
      if (comboBox == null) {
         comboBox = new JComboBox();
         comboBox.setBackground(new Color(211, 211, 211));
         comboBox.setBounds(162, 6, 80, 21);
         comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC804\uCCB4", "\uBE44\uD488\uCF54\uB4DC", "\uBE44\uD488\uBA85", "\uAD6C\uC785\uB0A0\uC9DC"}));
         comboBox.setPreferredSize(new Dimension(80, 21));
      }
      return comboBox;
   }
   private JPanel getPanel_3_1() {
      if (panel_3 == null) {
         panel_3 = new ProductInsert(ProductSelect.this);
         panel_3.setBackground(Color.WHITE);
         panel_3.setPreferredSize(new Dimension(300, 10));
         panel_3.setLayout(new BorderLayout(0, 0));
      }
      return panel_3;
   }
   private JButton getBtnNewButton_1() {
      if (btnNewButton_1 == null) {
         btnNewButton_1 = new JButton("\uBE44\uD488\uC785\uB825\uCC3D");
         btnNewButton_1.setBackground(new Color(255, 182, 193));
         btnNewButton_1.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
         btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               panel_3.removeAll(); 
               ProductInsert panel = new ProductInsert(ProductSelect.this);
               panel_3.add(panel);
               panel_3.updateUI();
            }
         });
         btnNewButton_1.setBounds(639, 5, 108, 23);
      }
      return btnNewButton_1;
   }
}