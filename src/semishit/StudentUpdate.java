package semishit;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentUpdate extends JPanel {
	private JTextField sno;
	private JTextField sname;
	private JTextField sbirth;
	private JTextField saddress;
	private JSeparator separator;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField sphone;
	private JTextField semail;
	private JLabel photo;
	private JButton button;
	private JButton insertBtn;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JTextField smale;
	private JLabel lblNewLabel;
	private JTextField eno;
	String fn;
	String fp;
	/**
	 * Create the panel.
	 */
	public StudentUpdate() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		add(getSno());
		add(getSname());
		add(getSbirth());
		add(getSaddress());
		add(getSeparator());
		add(getLabel_1());
		add(getLabel_2());
		add(getLabel_3());
		add(getLabel_4());
		add(getLabel_5());
		add(getLabel_6());
		add(getSphone());
		add(getSemail());
		add(getPhoto());
		add(getButton());
		add(getInsertBtn());
		add(getLabel_8());
		add(getLabel_9());
		add(getLabel_10());
		add(getSmale());
		add(getLblNewLabel());
		add(getEno());

	}
	

	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setColumns(10);
			sno.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sno.setBounds(79, 87, 197, 21);
		}
		return sno;
	}
	private JTextField getSname() {
		if (sname == null) {
			sname = new JTextField();
			sname.setColumns(10);
			sname.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sname.setBounds(79, 116, 197, 21);
		}
		return sname;
	}
	private JTextField getSbirth() {
		if (sbirth == null) {
			sbirth = new JTextField();
			sbirth.setColumns(10);
			sbirth.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sbirth.setBounds(79, 147, 197, 21);
		}
		return sbirth;
	}
	private JTextField getSaddress() {
		if (saddress == null) {
			saddress = new JTextField();
			saddress.setColumns(10);
			saddress.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			saddress.setBounds(79, 177, 197, 21);
		}
		return saddress;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 67, 393, 2);
		}
		return separator;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uD559\uBC88");
			label_1.setFont(new Font("12롯데마트드림Bold", Font.PLAIN, 12));
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(12, 88, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC774\uB984");
			label_2.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setBounds(12, 119, 57, 15);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
			label_3.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setBounds(12, 150, 57, 15);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC8FC\uC18C");
			label_4.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setBounds(12, 180, 57, 15);
		}
		return label_4;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uC5F0\uB77D\uCC98");
			label_5.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_5.setHorizontalAlignment(SwingConstants.RIGHT);
			label_5.setBounds(13, 211, 57, 15);
		}
		return label_5;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("\uC774\uBA54\uC77C");
			label_6.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_6.setHorizontalAlignment(SwingConstants.RIGHT);
			label_6.setBounds(12, 242, 57, 15);
		}
		return label_6;
	}
	private JTextField getSphone() {
		if (sphone == null) {
			sphone = new JTextField();
			sphone.setColumns(10);
			sphone.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sphone.setBounds(79, 208, 197, 21);
		}
		return sphone;
	}
	private JTextField getSemail() {
		if (semail == null) {
			semail = new JTextField();
			semail.setColumns(10);
			semail.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			semail.setBounds(79, 239, 197, 21);
		}
		return semail;
	}
	private JLabel getPhoto() {
		if (photo == null) {
			photo = new JLabel("");
			photo.setHorizontalAlignment(SwingConstants.CENTER);
			photo.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\\uC0AC\uB78C.png"));
			photo.setBounds(351, 79, 140, 161);
		}
		return photo;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uC0AC\uC9C4 \uB4F1\uB85D");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					JFileChooser fc = new JFileChooser();
					fc.setMultiSelectionEnabled(true);
					int flag = fc.showOpenDialog(StudentUpdate.this);
					if (flag == JFileChooser.APPROVE_OPTION) {
						File[] tempFiles = fc.getSelectedFiles();
						for (File f : tempFiles) {
							photo.setIcon(new ImageIcon(f.getPath()));
							////////////////////////////////////////파일 db
							fn = f.getName();
							fp = f.getPath();
							
						}

					}
				}
			});
			button.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			button.setBounds(372, 238, 97, 23);
		}
		return button;
	}
	private JButton getInsertBtn() {
		if (insertBtn == null) {
			insertBtn = new JButton("\uC800\uC7A5");
			insertBtn.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			insertBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						StuDao dao = new StuDao();
						StuVo vo = new StuVo();
						Date day = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						try {
							day = sdf.parse(sbirth.getText());
						}catch(Exception ex) {
							System.out.println("제대로 안적고있음");
						}
						vo.setSno(Integer.parseInt(sno.getText()));
						vo.setSname(sname.getText());
						vo.setSbirth(day);
						vo.setSaddress(saddress.getText());
						vo.setSphone(sphone.getText());
						vo.setSemail(semail.getText());
						vo.setSmale(smale.getText());
						vo.setEno(Integer.parseInt(eno.getText()));
						
						vo.setImname(fn);
						vo.setImpath(fp);
						
						System.out.println(fn + fp);
						 
						Thread t = new Send1(vo.getImname(), vo.getImpath());
						t.start();
						
						
						
						int r = dao.update(vo);
						if(r > 0) {
							JOptionPane.showMessageDialog(insertBtn, "학생이 수정되었습니다.");
						}else {
							JOptionPane.showMessageDialog(insertBtn, "이미 있는 학번이거나 강사번호가 틀렸습니다.");
						}
					
					}catch(Exception ex1) {
						JOptionPane.showMessageDialog(insertBtn, "제대로 입력해주세요");
					}
				
				}
			});
			insertBtn.setBounds(245, 340, 97, 23);
		}
		return insertBtn;
	}
	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("\uD559\uC0DD \uC815\uBCF4 \uC218\uC815");
			label_8.setFont(new Font("12롯데마트행복Bold", Font.PLAIN, 25));
			label_8.setBounds(157, 0, 220, 68);
		}
		return label_8;
	}
	private JLabel getLabel_9() {
		if (label_9 == null) {
			label_9 = new JLabel("");
			label_9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						StuDao dao = new StuDao();
						int no = Integer.parseInt(sno.getText());
						StuVo vo = dao.search(no);
						Date day = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						
						if(vo == null) {
							System.out.println("sno 자료 없음"); // 테스트문
							JOptionPane.showMessageDialog(label_9, "해당 번호 학생이 존재하지 않습니다.");
							sno.setText("");
							sname.setText("");
							sbirth.setText("");
							saddress.setText("");
							sphone.setText("");
							semail.setText("");
							smale.setText("");
							eno.setText("");
						}else {
							sno.setText(vo.getSno()+"");
							sname.setText(vo.getSname());
							sbirth.setText(sdf.format(vo.getSbirth()));
							saddress.setText(vo.getSaddress());
							sphone.setText(vo.getSphone());
							semail.setText(vo.getSemail());
							smale.setText(vo.getSmale());
							eno.setText(vo.getEno()+"");
							
							System.out.println(vo.getImpath());
							photo.setIcon(new ImageIcon(vo.getImpath()));
							
							
							
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(label_9, "번호를 입력해주세요.");
					}
					
					
					
				}
			});
			label_9.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\\uC0AC\uC9C4\\\uAC80\uC0C9.png"));
			label_9.setBounds(280, 82, 30, 38);
		}
		return label_9;
	}
	private JLabel getLabel_10() {
		if (label_10 == null) {
			label_10 = new JLabel("\uC131\uBCC4");
			label_10.setHorizontalAlignment(SwingConstants.RIGHT);
			label_10.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_10.setBounds(11, 271, 57, 15);
		}
		return label_10;
	}
	private JTextField getSmale() {
		if (smale == null) {
			smale = new JTextField();
			smale.setFont(new Font("돋움", Font.PLAIN, 12));
			smale.setColumns(10);
			smale.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			smale.setBounds(79, 269, 197, 21);
		}
		return smale;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uAC15\uC0AC\uBC88\uD638");
			lblNewLabel.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(14, 299, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getEno() {
		if (eno == null) {
			eno = new JTextField();
			eno.setFont(new Font("돋움", Font.PLAIN, 12));
			eno.setColumns(10);
			eno.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			eno.setBounds(79, 297, 197, 21);
		}
		return eno;
	}
}
