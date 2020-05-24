package company;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.text.ParseException;
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
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.LineBorder;

public class ProductUpdate extends JPanel {
	ProductSelect ps;
	Socket socket;
	JFileChooser fc;
	String fileName;
	String path;
   
   
   private JLabel label_1;
   private JLabel label_2;
   public JTextField tpId;
   public JTextField tpName;
   private JLabel label_3;
   private JLabel label_4;
   public JSpinner tea;
   private JLabel label_5;
   public JTextField tprice;
   private JLabel 단가;
   public JTextField tnote;
   private JLabel label_7;
   private JButton button;
   private JButton button_1;
   public JButton image;
   public JDateChooser tiDate;
   private JLabel lblNewLabel;
   public JTextField ttotPrice;
   private JLabel lblNewLabel_1;

   /**
    * Create the panel.
    */
   public ProductUpdate() {
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
      add(get단가());
      add(getTnote());
      add(getLabel_7());
      add(getButton());
      add(getButton_1());
      add(getImage());
      add(getTiDate());
      add(getLblNewLabel());
      add(getTtotPrice());
      add(getLblNewLabel_1());
   }
 
   public ProductUpdate(ProductSelect ps, String fileName) {
	   this(); 
	   this.ps = ps;
	   this.fileName = fileName;
   }

   private JButton getImage() { //사진추가
         if (image == null) {
            image = new JButton("");
            image.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
            image.setBackground(new Color(255, 228, 225));
            image.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  JFileChooser fc = new JFileChooser();
                  int state = fc.showSaveDialog(ProductUpdate.this);
                  if(state == JFileChooser.APPROVE_OPTION) {
                	  fileName = fc.getSelectedFile().getName();
                	  path = fc.getSelectedFile().getPath();
                     
                     Thread thread = new Send1(fileName, path);
                     thread.start();

                     //선택한 사진 버튼에 뜨기.
                     ImageIcon old = new ImageIcon(fc.getSelectedFile().getPath());
                     Image oldImage = old.getImage();
                     Image newImage = oldImage.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_DEFAULT);
                     image.setIcon(new ImageIcon(newImage));
                  }
               }
            });
            image.setBounds(141, 66, 145, 111);
         }
         return image; 
      }
  
   private JButton getButton() { //수정버튼
         if (button == null) {
            button = new JButton("\uC218\uC815");
            button.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
            button.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
            button.setBackground(new Color(255, 182, 193));
            button.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
            	   if(tpName.getText().equals("")){
                   	JOptionPane.showMessageDialog(ProductUpdate.this, "비품명을 입력해주세요.");
                   }else if(tiDate.getDate() == null){
                   	JOptionPane.showMessageDialog(ProductUpdate.this, "날짜를 입력해주세요.");
                   }else if(tprice.getText().equals("")){
                   	JOptionPane.showMessageDialog(ProductUpdate.this, "단가를 입력해주세요.");
                   }else {
                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                  ProductDao dao = new ProductDao();
                  ProductVo vo = new ProductVo();
                  
                     try {
                       vo.setImPath(path);
                       vo.setImName(fileName);
                        vo.setpName(tpName.getText());
                        vo.setEa(Integer.parseInt(tea.getValue().toString()));
                        vo.setiDate(tiDate.getDate());
                        vo.setPrice(Integer.parseInt(tprice.getText().trim()));
                        vo.setNote(tnote.getText());
                        vo.setpId(tpId.getText());
                        vo.setTotPrice(Integer.parseInt(ttotPrice.getText()));
                     } catch (Exception e1) {
                    	 e1.printStackTrace();
                     }
                        
                     int r = dao.update(vo);
                     if(r>0) {
                       JOptionPane.showMessageDialog(ProductUpdate.this, vo.getpId()+ "비품정보가 수정되었습니다.");
                       ps.refresh();
                       tpName.setText("");
                       tea.setValue(1);
                       tiDate.setDate(null);
                       tprice.setText("");
                       tnote.setText(""); 
                       tpId.requestFocus();
                       tpId.selectAll();
                      }else {
                        JOptionPane.showMessageDialog(ProductUpdate.this, "비품정보 수정 중 오류가 발생했습니다.");
                      }
               }
               }
            });
            button.setBounds(72, 520, 73, 23);
         }
         return button;
      }
   
private JButton getButton_1() { //삭제버튼
   if (button_1 == null) {
      button_1 = new JButton("\uC0AD\uC81C");
      button_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
      button_1.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
      button_1.setBackground(new Color(255, 182, 193));
      button_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            ProductDao dao = new ProductDao();
            int r = dao.delete(tpId.getText());
            if(r>0) {
               JOptionPane.showMessageDialog(ProductUpdate.this, tpId.getText()+ "비품정보가 삭제되었습니다.");
               ps.refresh();
               }else {
                  JOptionPane.showMessageDialog(ProductUpdate.this, "비품정보 삭제 중 오류가 발생했습니다.");
               }
         }
      });
      button_1.setBounds(157, 520, 73, 23);
   }
   return button_1;
}
   
   private JLabel getLabel_1() {
      if (label_1 == null) {
         label_1 = new JLabel("\uBE44\uD488 \uC218\uC815 \uBC0F \uC0AD\uC81C");
         label_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20));
         label_1.setHorizontalAlignment(SwingConstants.CENTER);
         label_1.setBounds(0, 10, 287, 46);
      }
      return label_1;
   }
   private JLabel getLabel_2() {
      if (label_2 == null) { 
         label_2 = new JLabel("\uBE44\uD488\uCF54\uB4DC");
         label_2.setBounds(13, 113, 57, 15);
      }
      return label_2;
   }
   private JTextField getTpId() {
      if (tpId == null) {
         tpId = new JTextField();
         tpId.setHorizontalAlignment(SwingConstants.CENTER);
         tpId.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
         tpId.setBackground(new Color(245, 245, 245));
         tpId.setEnabled(true);
         tpId.setEditable(false);
         tpId.setColumns(10);
         tpId.setBounds(13, 139, 116, 21);
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
         tpName.setBounds(100, 213, 116, 21);
      }
      return tpName;
   }
   private JLabel getLabel_3() {
      if (label_3 == null) {
         label_3 = new JLabel("\uBE44\uD488\uBA85");
         label_3.setBounds(31, 216, 57, 15);
      }
      return label_3;
   }
   private JLabel getLabel_4() {
      if (label_4 == null) {
         label_4 = new JLabel("\uC218\uB7C9");
         label_4.setBounds(31, 247, 57, 15);
      }
      return label_4;
   }
   private JSpinner getTea() {
      if (tea == null) {
         tea = new JSpinner();
         tea.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
         tea.setBackground(new Color(245, 245, 245));
         tea.addChangeListener(new ChangeListener() {
         	public void stateChanged(ChangeEvent e) {
         		 int ea = Integer.parseInt(tea.getValue().toString());
                 int price = Integer.parseInt(tprice.getText());
           		ttotPrice.setText(String.valueOf(ea*price));
         	}
         });
         tea.setModel(new SpinnerNumberModel(1, 1, 10000, 1));
         tea.setBounds(100, 244, 57, 22);
      }
      return tea;
   }
   private JLabel getLabel_5() {
      if (label_5 == null) {
         label_5 = new JLabel("\uAD6C\uC785\uB0A0\uC9DC");
         label_5.setBounds(31, 409, 57, 15);
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
         tprice.setBounds(100, 276, 116, 21);
      }
      return tprice;
   }
   private JLabel get단가() {
      if (단가 == null) {
         단가 = new JLabel("\uB2E8\uAC00");
         단가.setBounds(31, 279, 57, 15);
      }
      return 단가;
   }
   private JTextField getTnote() {
      if (tnote == null) {
         tnote = new JTextField();
         tnote.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
         tnote.setBackground(new Color(245, 245, 245));
         tnote.setColumns(10);
         tnote.setBounds(112, 440, 175, 58);
      }
      return tnote;
   }
   private JLabel getLabel_7() {
      if (label_7 == null) {
         label_7 = new JLabel("\uD2B9\uC774\uC0AC\uD56D");
         label_7.setBounds(31, 441, 57, 15);
      }
      return label_7;
   }
	private JDateChooser getTiDate() {
		if (tiDate == null) {
			tiDate = new JDateChooser();
			tiDate.setBorder(new LineBorder(new Color(255, 192, 203), 2, true));
			tiDate.setBackground(new Color(245, 245, 245));
			tiDate.setBounds(112, 409, 116, 21);
		}
		return tiDate;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uCD1D\uAE08\uC561");
			lblNewLabel.setBounds(31, 323, 57, 15);
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
			ttotPrice.setBounds(100, 320, 116, 21);
			ttotPrice.setColumns(10);
		}
		return ttotPrice;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setBackground(new Color(255, 240, 245));
			lblNewLabel_1.setBounds(0, 8, 287, 46);
		}
		return lblNewLabel_1;
	}
}
