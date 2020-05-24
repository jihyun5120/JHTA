package semishit;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class ProductInsert extends JPanel {
   JFileChooser fc;
   Socket socket;
   FileInputStream fis;
   OutputStream os;
   String fileName;
   String path;
   ProductSelect ps;
   
   private JLabel label_1;
   private JLabel label_2;
   private JTextField tpId;
   private JTextField tpName;
   private JLabel label_3;
   private JLabel label_4;
   private JSpinner tea;
   private JLabel label_5;
   private JTextField tprice;
   private JLabel label_6;
   private JTextField tnote;
   private JLabel label_7;
   private JButton insert;
   private JButton image;
   private JDateChooser tiDate;
   private JLabel status;
   private JLabel lblNewLabel;
   private JTextField ttotPrice;
   private JLabel label;

   /**
    * Create the panel.
    */
   public ProductInsert() {
   	setBackground(Color.WHITE);
      setLayout(null);
      add(getLabel_1());
      add(getLabel_2());
      add(getTpId());
      add(getTpName());
      add(getLabel_3());
      add(getLabel_4());
      add(getTea());
      add(getLabel_5());
      add(getTprice());
      add(getLabel_6());
      add(getTnote());
      add(getLabel_7());
      add(getInsert());
      add(getImage());
      add(getDateChooser_1());
      add(getStatus());
      add(getLblNewLabel());
      add(getTtotPrice());
      add(getLabel());
      
      
   }
   
   public ProductInsert(ProductSelect ps) {
	   this();
	   this.ps = ps;
   }
   
   private JButton getImage() { //사진추가버튼
         if (image == null) {
            image = new JButton("\uC0AC\uC9C4\uCD94\uAC00");
            image.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
            image.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
            image.setBackground(new Color(255, 240, 245));
            image.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  fc = new JFileChooser(); 
                  int state = fc.showSaveDialog(ProductInsert.this);
                  if(state == JFileChooser.APPROVE_OPTION) {
                	 fileName = fc.getSelectedFile().getName();
                     path = fc.getSelectedFile().getPath();
                     
                     Thread thread = new Send1(fileName, path);
                     thread.start();
                     
                     //선택한 사진 버튼에 뜨기.
                     image.setText("");
                     ImageIcon old = new ImageIcon(fc.getSelectedFile().getPath());
                     Image oldImage = old.getImage();
                     Image newImage = oldImage.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_DEFAULT);
                     image.setIcon(new ImageIcon(newImage));
                  }
               }
            });
            image.setBounds(140, 66, 145, 110);
         }
         return image;
      }

   
   private JButton getInsert() { //입력버튼
      if (insert == null) {
         insert = new JButton("\uC785\uB825");
         insert.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
         insert.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
         insert.setBackground(new Color(255, 182, 193));
         insert.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
               
            	if(tpId.getText().equals("")) {
            		JOptionPane.showMessageDialog(ProductInsert.this, "비품코드를 입력해주세요.");
                }else if(tpName.getText().equals("")){
                	JOptionPane.showMessageDialog(ProductInsert.this, "비품명을 입력해주세요.");
                }else if(tiDate.getDate() == null){
                	JOptionPane.showMessageDialog(ProductInsert.this, "날짜를 입력해주세요.");
                }else if(tprice.getText().equals("")){
                	JOptionPane.showMessageDialog(ProductInsert.this, "단가를 입력해주세요.");
                }else if(image.getIcon() == null){
                	JOptionPane.showMessageDialog(ProductInsert.this, "비품사진을 넣어주세요.");
                }else {
                
	               SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	               ProductDao dao = new ProductDao();
	               ProductVo vo = new ProductVo();
	               
	               try {
	            	   vo.setImPath(fc.getSelectedFile().getPath());
	            	   vo.setImName(fc.getSelectedFile().getName());
	            	   vo.setpId(tpId.getText());
	            	   vo.setpName(tpName.getText());
	            	   vo.setEa(Integer.parseInt(tea.getValue().toString()));
	            	   vo.setiDate(tiDate.getDate());
	            	   vo.setPrice(Integer.parseInt(tprice.getText()));
	            	   vo.setNote(tnote.getText());
	            	   vo.setTotPrice(Integer.parseInt(ttotPrice.getText()));
	               } catch(Exception ex) {
	            	   ex.printStackTrace();
	               }
	               
	               int r = dao.insert(vo);
	               if(r>0) {
	                  JOptionPane.showMessageDialog(ProductInsert.this, "비품정보가 입력되었습니다.");
	                  ps.refresh();
	                  tpName.setText("");
	                  tea.setValue(1);
	                  tiDate.setDate(null);
	                  tprice.setText("");
	                  tnote.setText("");
	                  tpId.requestFocus();
	                  tpId.selectAll();
	               } else {
	                  JOptionPane.showMessageDialog(ProductInsert.this, "비품정보 입력 중 오류가 발생했습니다.");
	               }
                }
            }
         });
         insert.setBounds(111, 510, 73, 23);
      }
      return insert;
   }
   
   private JLabel getLabel_1() {
      if (label_1 == null) {
         label_1 = new JLabel("\uBE44\uD488\uC785\uB825");
         label_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20));
         label_1.setHorizontalAlignment(SwingConstants.CENTER);
         label_1.setBounds(0, 10, 285, 46);
      }
      return label_1;
   }
   private JLabel getLabel_2() {
      if (label_2 == null) {
         label_2 = new JLabel("\uBE44\uD488\uCF54\uB4DC");
         label_2.setBounds(12, 128, 57, 15);
      }
      return label_2;
   }
   private JTextField getTpId() {
      if (tpId == null) {
         tpId = new JTextField();
         tpId.setHorizontalAlignment(SwingConstants.CENTER);
         tpId.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
         tpId.setBackground(new Color(245, 245, 245));
         tpId.addFocusListener(new FocusAdapter() {
         	@Override
         	public void focusLost(FocusEvent e) {
         		for(int i=0; i<ps.table.getRowCount(); i++) {
        			if(ps.table.getValueAt(i, 0).equals(tpId.getText())) {
        				status.setText("비품코드"+tpId.getText()+"(을)를 사용할 수 없습니다.");
        			}
        		}
         	}
         	@Override
         	public void focusGained(FocusEvent e) {
         		status.setText("");
         	}
         });
         tpId.setColumns(10);
         tpId.setBounds(12, 154, 116, 21);
      }
      return tpId;
   }
   private JTextField getTpName() {
      if (tpName == null) {
         tpName = new JTextField();
         tpName.setHorizontalAlignment(SwingConstants.CENTER);
         tpName.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
         tpName.setBackground(new Color(245, 245, 245));
         tpName.setColumns(10);
         tpName.setBounds(111, 209, 116, 21);
      }
      return tpName;
   }
   private JLabel getLabel_3() {
      if (label_3 == null) {
         label_3 = new JLabel("\uBE44\uD488\uBA85");
         label_3.setBounds(31, 212, 57, 15);
      }
      return label_3;
   }
   private JLabel getLabel_4() {
      if (label_4 == null) {
         label_4 = new JLabel("\uC218\uB7C9");
         label_4.setBounds(31, 255, 57, 15);
      }
      return label_4;
   }
   private JSpinner getTea() {
      if (tea == null) {
         tea = new JSpinner();
         tea.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
         tea.setBackground(new Color(245, 245, 245));
         tea.addChangeListener(new ChangeListener() {
         	public void stateChanged(ChangeEvent arg0) {
         		 int ea = Integer.parseInt(tea.getValue().toString());
                 int price = Integer.parseInt(tprice.getText());
           		ttotPrice.setText((ea*price)+"");
         	}
         });
         
         tea.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
         tea.setBounds(111, 252, 57, 22);
      }
      return tea;
   }
   private JLabel getLabel_5() {
      if (label_5 == null) {
         label_5 = new JLabel("\uAD6C\uC785\uB0A0\uC9DC");
         label_5.setBounds(31, 385, 57, 15);
      }
      return label_5;
   }
   private JTextField getTprice() {
      if (tprice == null) {
         tprice = new JTextField();
         tprice.setHorizontalAlignment(SwingConstants.CENTER);
         tprice.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
         tprice.setBackground(new Color(245, 245, 245));
         tprice.addFocusListener(new FocusAdapter() {
         	@Override
         	public void focusLost(FocusEvent e) {
               int ea = Integer.parseInt(tea.getValue().toString());
               int price = Integer.parseInt(tprice.getText());
         		ttotPrice.setText((ea*price)+"");
         	}
         });
         tprice.setColumns(10);
         tprice.setBounds(111, 295, 116, 21);
      }
      return tprice;
   }
   private JLabel getLabel_6() {
      if (label_6 == null) {
         label_6 = new JLabel("\uB2E8\uAC00");
         label_6.setBounds(31, 298, 57, 15);
      }
      return label_6;
   }
   private JTextField getTnote() {
      if (tnote == null) {
         tnote = new JTextField();
         tnote.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
         tnote.setBackground(new Color(245, 245, 245));
         tnote.setColumns(10);
         tnote.setBounds(110, 434, 175, 58);
      }
      return tnote;
   }
   private JLabel getLabel_7() {
      if (label_7 == null) {
         label_7 = new JLabel("\uD2B9\uC774\uC0AC\uD56D");
         label_7.setBounds(31, 434, 57, 15);
      }
      return label_7;
   }
	private JDateChooser getDateChooser_1() {
		if (tiDate == null) {
			tiDate = new JDateChooser();
			tiDate.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
			tiDate.setBackground(new Color(245, 245, 245));
			tiDate.setBounds(111, 379, 116, 21);
		}
		return tiDate;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setForeground(Color.RED);
			status.setBounds(12, 184, 275, 15);
		}
		return status;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uCD1D\uAE08\uC561");
			lblNewLabel.setBounds(31, 339, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTtotPrice() {
		if (ttotPrice == null) {
			ttotPrice = new JTextField();
			ttotPrice.setHorizontalAlignment(SwingConstants.CENTER);
			ttotPrice.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
			ttotPrice.setBackground(new Color(245, 245, 245));
			ttotPrice.setEditable(false);
			ttotPrice.setBounds(111, 336, 116, 21);
			ttotPrice.setColumns(10);
		}
		return ttotPrice;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setOpaque(true);
			label.setBackground(new Color(255, 240, 245));
			label.setBounds(0, 10, 287, 46);
		}
		return label;
	}
}