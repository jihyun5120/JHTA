package semishit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class StudentDelete extends JPanel {

	private JTextField sno;
	private JTextField sname;
	private JTextField sbirth;
	private JTextField saddress;
	private JSeparator separator;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField sphone;
	private JTextField semail;
	private JLabel photo;
	private JButton delBtn;
	private JLabel label_7;
	private JLabel label_9;
	private JLabel asdf;
	private JTextField smale;
	private JTextField eno;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public StudentDelete() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		add(getSno());
		add(getSname());
		add(getSbirth());
		add(getSaddress());
		add(getSeparator());
		add(getLabel());
		add(getLabel_1());
		add(getLabel_2());
		add(getLabel_3());
		add(getLabel_4());
		add(getLabel_5());
		add(getSphone());
		add(getSemail());
		add(getPhoto());
		add(getDelBtn());
		add(getLabel_7());
		add(getLabel_9());
		add(getAsdf());
		add(getTextField_6());
		add(getEno());
		add(getLblNewLabel());

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
			sname.setEditable(false);
			sname.setColumns(10);
			sname.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sname.setBounds(79, 116, 197, 21);
		}
		return sname;
	}
	private JTextField getSbirth() {
		if (sbirth == null) {
			sbirth = new JTextField();
			sbirth.setEditable(false);
			sbirth.setColumns(10);
			sbirth.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sbirth.setBounds(79, 147, 197, 21);
		}
		return sbirth;
	}
	private JTextField getSaddress() {
		if (saddress == null) {
			saddress = new JTextField();
			saddress.setEditable(false);
			saddress.setColumns(10);
			saddress.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			saddress.setBounds(79, 177, 197, 21);
		}
		return saddress;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 67, 455, 2);
		}
		return separator;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uD559\uBC88");
			label.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(14, 89, 57, 15);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC774\uB984");
			label_1.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(12, 119, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
			label_2.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setBounds(12, 150, 57, 15);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC8FC\uC18C");
			label_3.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setBounds(12, 180, 57, 15);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC5F0\uB77D\uCC98");
			label_4.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setBounds(13, 211, 57, 15);
		}
		return label_4;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uC774\uBA54\uC77C");
			label_5.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_5.setHorizontalAlignment(SwingConstants.RIGHT);
			label_5.setBounds(12, 244, 57, 15);
		}
		return label_5;
	}
	private JTextField getSphone() {
		if (sphone == null) {
			sphone = new JTextField();
			sphone.setEditable(false);
			sphone.setColumns(10);
			sphone.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sphone.setBounds(79, 208, 197, 21);
		}
		return sphone;
	}
	private JTextField getSemail() {
		if (semail == null) {
			semail = new JTextField();
			semail.setEditable(false);
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
			photo.setBounds(333, 96, 139, 163);
		}
		return photo;
	}
	private JButton getDelBtn() {
		if (delBtn == null) {
			delBtn = new JButton("\uC0AD\uC81C");
			delBtn.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			delBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						StuDao dao = new StuDao();
						String no = sno.getText();
						int nono = Integer.parseInt(no);
						int r = dao.delete(nono);
						
						if(r > 0) {
							JOptionPane.showMessageDialog(delBtn, "학생이 삭제되었습니다.");
						}else {
							JOptionPane.showMessageDialog(delBtn, "삭제 실패했습니다.");
						}
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(delBtn, "삭제할 학생의 학번을 확인해주세요.");
					}
					
				}
			});
			delBtn.setBounds(163, 324, 97, 23);
		}
		return delBtn;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("\uD559\uC0DD \uC815\uBCF4 \uC0AD\uC81C");
			label_7.setFont(new Font("12롯데마트행복Light", Font.PLAIN, 25));
			label_7.setBounds(151, 0, 220, 68);
		}
		return label_7;
	}
	private JLabel getLabel_9() {
		if (label_9 == null) {
			label_9 = new JLabel("");
			label_9.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
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
							
							Thread t = new Receive1(vo.getImname(), vo.getImpath());
							t.start();
							photo.setIcon(new ImageIcon(vo.getImpath()));
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(label_9, "번호를 입력해주세요.");
					}
					
					
				}
			});
			label_9.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\\uC0AC\uC9C4\\\uAC80\uC0C9.png"));
			label_9.setBounds(281, 80, 30, 38);
		}
		return label_9;
	}
	private JLabel getAsdf() {
		if (asdf == null) {
			asdf = new JLabel("\uC131\uBCC4");
			asdf.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			asdf.setHorizontalAlignment(SwingConstants.RIGHT);
			asdf.setBounds(13, 273, 57, 15);
		}
		return asdf;
	}
	private JTextField getTextField_6() {
		if (smale == null) {
			smale = new JTextField();
			smale.setFont(new Font("돋움", Font.PLAIN, 12));
			smale.setEditable(false);
			smale.setColumns(10);
			smale.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			smale.setBounds(79, 269, 197, 21);
		}
		return smale;
	}
	private JTextField getEno() {
		if (eno == null) {
			eno = new JTextField();
			eno.setFont(new Font("돋움", Font.PLAIN, 12));
			eno.setEditable(false);
			eno.setColumns(10);
			eno.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			eno.setBounds(79, 300, 197, 21);
		}
		return eno;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uAC15\uC0AC\uBC88\uD638");
			lblNewLabel.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(16, 304, 57, 15);
		}
		return lblNewLabel;
	}
}
