package semishit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import l_ftp.FileTransfer;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.toedter.components.JLocaleChooser;

public class StudentInput extends JPanel {

	private JPanel panel;
	private JTextField sno;
	private JTextField sname;
	private JTextField sbirth;
	private JTextField saddress;
	private JSeparator separator;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField sphone;
	private JTextField semail;
	private JLabel label_6;
	private JButton btnNewButton;
	private JButton insertBtn;
	private JRadioButton male;
	private JRadioButton female;
	ButtonGroup bg = new ButtonGroup();
	private JLabel lblNewLabel_2;
	private JTextField eno;
	private JLabel dateerr;
	private JLabel status;
	private JLabel lblNewLabel_3;
	private JComboBox comboBox;
	private JLabel label;
	String fn = "";
	String fp = "";
	/**
	 * Create the panel.
	 */
	public StudentInput() {
		setLayout(new BorderLayout(0, 0));
		add(getPanel(), BorderLayout.CENTER);

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(420, 300));
			panel.setBackground(new Color(255, 255, 255));
			panel.setLayout(null);
			panel.add(getSno());
			panel.add(getSname());
			panel.add(getSbirth());
			panel.add(getSaddress());
			panel.add(getSeparator());
			panel.add(getLblNewLabel());
			panel.add(getLblNewLabel_1());
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLabel_3());
			panel.add(getLabel_4());
			panel.add(getLabel_5());
			panel.add(getSphone());
			panel.add(getSemail());
			panel.add(getLabel_6());
			panel.add(getBtnNewButton());
			panel.add(getInsertBtn());
			panel.add(getMale());
			panel.add(getFemale());
			panel.add(getLblNewLabel_2());
			panel.add(getEno());
			panel.add(getDateerr());
			panel.add(getStatus());
			panel.add(getLblNewLabel_3());
			panel.add(getComboBox());
			panel.add(getLabel());
		}
		return panel;
	}

	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setFont(new Font("굴림", Font.PLAIN, 12));
			sno.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sno.setBounds(79, 87, 197, 21);
			sno.setColumns(10);
		}
		return sno;
	}

	private JTextField getSname() {
		if (sname == null) {
			sname = new JTextField();
			sname.setFont(new Font("굴림", Font.PLAIN, 12));
			sname.setColumns(10);
			sname.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sname.setBounds(79, 118, 197, 21);
		}
		return sname;
	}

	private JTextField getSbirth() {
		if (sbirth == null) {
			sbirth = new JTextField();
			sbirth.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					sbirth.setText("");
				}
			});
			sbirth.setFont(new Font("굴림", Font.PLAIN, 12));
			sbirth.setText("yyyy-mm-dd");
			sbirth.setColumns(10);
			sbirth.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sbirth.setBounds(79, 149, 197, 21);
		}
		return sbirth;
	}

	private JTextField getSaddress() {
		if (saddress == null) {
			saddress = new JTextField();
			saddress.setFont(new Font("굴림", Font.PLAIN, 12));
			saddress.setColumns(10);
			saddress.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			saddress.setBounds(79, 179, 197, 21);
		}
		return saddress;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 69, 499, 2);
		}
		return separator;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uC0DD \uC815\uBCF4 \uC785\uB825");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("12롯데마트행복Light", Font.PLAIN, 25));
			lblNewLabel.setBounds(174, 10, 220, 60);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD559\uBC88");
			lblNewLabel_1.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setBounds(10, 90, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC774\uB984");
			label_1.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(10, 121, 57, 15);
		}
		return label_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
			label_2.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setBounds(10, 152, 57, 15);
		}
		return label_2;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC8FC\uC18C");
			label_3.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setBounds(10, 182, 57, 15);
		}
		return label_3;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC5F0\uB77D\uCC98");
			label_4.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setBounds(11, 213, 57, 15);
		}
		return label_4;
	}

	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uC774\uBA54\uC77C");
			label_5.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label_5.setHorizontalAlignment(SwingConstants.RIGHT);
			label_5.setBounds(10, 244, 57, 15);
		}
		return label_5;
	}

	private JTextField getSphone() {
		if (sphone == null) {
			sphone = new JTextField();
			sphone.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					sphone.setText("");
				}
			});
			sphone.setText("xxx-xxxx-xxxx");
			sphone.setFont(new Font("굴림", Font.PLAIN, 12));
			sphone.setColumns(10);
			sphone.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sphone.setBounds(79, 210, 197, 21);
		}
		return sphone;
	}

	private JTextField getSemail() {
		if (semail == null) {
			semail = new JTextField();
			semail.setFont(new Font("굴림", Font.PLAIN, 12));
			semail.setColumns(10);
			semail.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			semail.setBounds(79, 241, 197, 21);
		}
		return semail;
	}

	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("");
			label_6.setHorizontalAlignment(SwingConstants.CENTER);
			label_6.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\\uC0AC\uB78C.png"));
			label_6.setBounds(391, 69, 130, 170);
		}
		return label_6;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC0AC\uC9C4 \uB4F1\uB85D");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JFileChooser fc = new JFileChooser();
					fc.setMultiSelectionEnabled(true);
					int flag = fc.showOpenDialog(StudentInput.this);
					if (flag == JFileChooser.APPROVE_OPTION) {
						File[] tempFiles = fc.getSelectedFiles();
						for (File f : tempFiles) {
							label_6.setIcon(new ImageIcon(f.getPath()));
							////////////////////////////////////////파일 db
							fn = f.getName();
							fp = f.getPath();
							
						}

					}
					///////////////////////////////////////////////////////////
					

				}
			});
			btnNewButton.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			btnNewButton.setBounds(408, 240, 97, 23);
		}
		return btnNewButton;
	}

	private JButton getInsertBtn() {
		if (insertBtn == null) {
			insertBtn = new JButton("\uC785\uB825");
			insertBtn.setForeground(Color.WHITE);
			insertBtn.setBackground(new Color(123, 104, 238));
			insertBtn.setBorder(null);
			insertBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date birth = null;
						String no = sno.getText();
						String name = sname.getText();
						String birthT = sbirth.getText();
						String address = saddress.getText();
						String phone = sphone.getText();
						String email = semail.getText() + "@" + comboBox.getSelectedItem();
						String man = null;
						int en = Integer.parseInt(eno.getText());

						if (male.isSelected()) {
							man = "남자";
						} else {
							man = "여자";
						}

						try {
							birth = sdf.parse(birthT);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						int nono = Integer.parseInt(no);
						StuVo vo = new StuVo(nono, name, birth, address, phone, email, man, en, fn ,fp);
						StuDao dao = new StuDao();
						int i = dao.Sinput(vo);

						if (i > 0) {
							JOptionPane.showMessageDialog(insertBtn, "학생이 입력되었습니다.");
						} else {
							JOptionPane.showMessageDialog(insertBtn, "이미 있는 학번이거나 강사번호가 틀렸을 수 있습니다.");
						}
						if (birth instanceof Date) {
							dateerr.setText("");
						} else {
							dateerr.setText("* yyyy-MM-dd");
						}
						
						
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(insertBtn, "제대로 입력해주세요.");

					}

				}
			});
			insertBtn.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			insertBtn.setBounds(229, 323, 74, 23);
		}
		return insertBtn;
	}

	private JRadioButton getMale() {
		if (male == null) {
			male = new JRadioButton("\uB0A8\uC790");
			male.setSelected(true);
			male.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			male.setBackground(Color.WHITE);
			male.setBounds(114, 268, 57, 23);
			bg.add(male);
		}
		return male;
	}

	private JRadioButton getFemale() {
		if (female == null) {
			female = new JRadioButton("\uC5EC\uC790");
			female.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			female.setBackground(Color.WHITE);
			female.setBounds(189, 268, 57, 23);
			bg.add(female);
		}
		return female;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uAC15\uC0AC\uBC88\uD638");
			lblNewLabel_2.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setBounds(10, 295, 57, 15);
		}
		return lblNewLabel_2;
	}

	private JTextField getEno() {
		if (eno == null) {
			eno = new JTextField();
			eno.setFont(new Font("굴림", Font.PLAIN, 12));
			eno.setColumns(10);
			eno.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			eno.setBounds(79, 292, 197, 21);
		}
		return eno;
	}

	private JLabel getDateerr() {
		if (dateerr == null) {
			dateerr = new JLabel("");
			dateerr.setForeground(Color.RED);
			dateerr.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			dateerr.setHorizontalAlignment(SwingConstants.CENTER);
			dateerr.setBounds(278, 151, 125, 15);
		}
		return dateerr;
	}

	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setForeground(Color.BLUE);
			status.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			status.setBounds(74, 349, 403, 15);
		}
		return status;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC131\uBCC4");
			lblNewLabel_3.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_3.setBounds(10, 270, 57, 15);
		}
		return lblNewLabel_3;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			comboBox.setModel(
					new DefaultComboBoxModel(new String[] { "naver.com", "daum.net", "hanmail.net", "gmail.com" }));
			comboBox.setBounds(293, 242, 103, 21);
		}
		return comboBox;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("@");
			label.setBounds(278, 245, 22, 15);
		}
		return label;
	}
}
