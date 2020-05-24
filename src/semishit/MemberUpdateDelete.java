package semishit;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import m_jdbc.DBConn;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class MemberUpdateDelete extends JInternalFrame {

	ButtonGroup group = new ButtonGroup();

	private JLabel label;
	private JLabel label_3;
	private JTextField tmName;
	private JButton button;
	private JTextField findData;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JRadioButton btnEno;
	private JRadioButton btnmId;
	private JSeparator separator;
	private JPanel panel;
	private JLabel 사원번호;
	private JLabel lblNewLabel_1;
	private JTextField tserial;
	private JTextField tmId;
	private JLabel label_1;
	private JPasswordField tpwd;
	private JLabel label_2;
	private JPasswordField tpwdck;
	private JLabel label_4;
	private JComboBox comboBox;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField tpwdan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberUpdateDelete frame = new MemberUpdateDelete();
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
	public MemberUpdateDelete() {
		super("수정삭제", false, true, true, true);
		getContentPane().setBackground(Color.WHITE);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent arg0) {
				Connection conn = DBConn.getConn(); // 이부분 맞는지 다시 확인 필요함.
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		setVisible(true);
		setBounds(100, 100, 410, 514);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_3());
		getContentPane().add(getTmName());
		getContentPane().add(getButton());
		getContentPane().add(getFindData());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getSeparator());
		getContentPane().add(getPanel());
		getContentPane().add(get사원번호());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTserial());
		getContentPane().add(getTmId());
		getContentPane().add(getLabel_1());
		getContentPane().add(getTpwd());
		getContentPane().add(getLabel_2_1());
		getContentPane().add(getTpwdck());
		getContentPane().add(getLabel_4_1());
		getContentPane().add(getComboBox_1());
		getContentPane().add(getLabel_5_1());
		getContentPane().add(getLabel_6());
		getContentPane().add(getTpwdan());

	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uD68C\uC6D0 \uC218\uC815 \uC0AD\uC81C");
			label.setFont(new Font("나눔고딕", Font.BOLD, 25));
			label.setBounds(24, 10, 192, 53);
		}
		return label;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC774\uB984");
			label_3.setBounds(45, 179, 57, 15);
		}
		return label_3;
	}

	private JTextField getTmName() {
		if (tmName == null) {
			tmName = new JTextField();
			tmName.setColumns(10);
			tmName.setBounds(114, 176, 116, 21);
		}
		return tmName;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uC0AD\uC81C");
			button.setBackground(Color.PINK);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// 삭제

					String mId = tmId.getText();
					joinDao dao = new joinDao();
					int cnt = dao.delete(mId);

					if (cnt > 0) {
						JOptionPane.showMessageDialog(MemberUpdateDelete.this, "삭제가 성공적으로 이뤄졌습니다.");
					} else {
						JOptionPane.showMessageDialog(MemberUpdateDelete.this, "삭제 중 오류가 발생했습니다.");
					}

					tserial.setText("");
					findData.setText("");
					tmId.setText("");
					tpwd.setText("");
					tmName.setText("");
					tpwdck.setText("");
					tpwdan.setText("");
					comboBox.setSelectedIndex(0);

					findData.requestFocus();
					findData.selectAll();

				}
			});
			button.setBounds(198, 396, 97, 23);
		}
		return button;
	}

	private JTextField getFindData() {
		if (findData == null) {
			findData = new JTextField();
			findData.setBounds(170, 73, 125, 21);
			findData.setColumns(10);
		}
		return findData;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setBackground(Color.PINK);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {// 검색
					JoinVo vo = new JoinVo();
					joinDao dao = new joinDao();
					SimpleDateFormat sdf = new SimpleDateFormat();
					try {
						if (btnEno.isSelected()) {
							int find = 0;

							find = Integer.parseInt(findData.getText());
							vo = dao.search(find); // search(int ) 메소드로 간다

							if (vo == null) {
								JOptionPane.showMessageDialog(MemberUpdateDelete.this, "오류가 발생했습니다!");

							} else {
								String f = findData.getText();
								tserial.setText(f);
								tserial.setEnabled(false);

								tmId.setText(vo.getmId());
								tmId.setEnabled(false);

								tmName.setText(vo.getmName());
								tmName.setEnabled(false);

								tpwd.setText(vo.getPwd());
								tpwdck.setText(vo.getPwd());

								comboBox.setSelectedIndex(Integer.parseInt(vo.getPwdQu()));
								tpwdan.setText(vo.getPwdAn());
								

							}

						} else { // mId 버튼 클릭했을때
							String find = "";
							find = findData.getText();
							vo = dao.search(find); // search(String ) 메소드로 간다.

							if (vo == null) {

								JOptionPane.showMessageDialog(MemberUpdateDelete.this, "오류가 발생했습니다!");

							} else {
								String f = findData.getText();

								tserial.setText(vo.getEno() + "");
								tmId.setText(f);
								tpwd.setText(vo.getPwd());
								tpwdck.setText(vo.getPwd());
								tmName.setText(vo.getmName());
								comboBox.setSelectedIndex(Integer.parseInt(vo.getPwdQu()));
								tpwdan.setText(vo.getPwdAn());
								
							}

						}
					} catch (Exception ex) {

						JOptionPane.showMessageDialog(MemberUpdateDelete.this, "검색어가 공백입니다!");
					}

				}
			});
			btnNewButton.setBounds(297, 69, 97, 23);
		}
		return btnNewButton;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.setBackground(Color.PINK);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// 수정

					// 암호 영문, 숫자, 특수문자 조합, 9~12자리
					String patt = "^[a-z0-9!@#$%^&*]{9,12}$";
					String val = tpwd.getText();
					boolean pwdcheck = Pattern.matches(patt, val);

					int eN = Integer.parseInt(tserial.getText());
					String mI = tmId.getText();
					String pw = tpwd.getText();
					String mN = tmName.getText();
					String pQ = String.valueOf(comboBox.getSelectedIndex());
					String pA = tpwdan.getText();

					JoinVo vo = new JoinVo(eN, mN, mI, pw, pQ, pA);

					joinDao dao = new joinDao();
					if (mI != "" || pw != "" || mN != "" || pQ != "" || pA != "") {

						if (pwdcheck == true) {
							int cnt = dao.update(vo);

							if (cnt > 0) {

								JOptionPane.showMessageDialog(MemberUpdateDelete.this, "수정이 성공적으로 이뤄졌습니다.");
								tpwd.setText("");
								tmName.setText("");
								tpwd.setText("");
								tpwdck.setText("");
								tpwdan.setText("");
								comboBox.setSelectedIndex(0);

								findData.requestFocus();
								findData.selectAll();
							} else {
								JOptionPane.showMessageDialog(MemberUpdateDelete.this, "수정 중 오류가 발생했습니다.");
							}
						} else {
							JOptionPane.showMessageDialog(MemberUpdateDelete.this, "비밀번호가 형식에 맞지않습니다!");
						}
					} else {

					}
				}

			});
			btnNewButton_1.setBounds(76, 396, 97, 23);
		}
		return btnNewButton_1;
	}

	private JRadioButton getBtnEno() {
		if (btnEno == null) {
			btnEno = new JRadioButton("\uC0AC\uC6D0\uBC88\uD638");
			btnEno.setBackground(Color.WHITE);

			group.add(btnEno);

			btnEno.setSelected(true);
		}
		return btnEno;
	}

	private JRadioButton getBtnmId() {
		if (btnmId == null) {
			btnmId = new JRadioButton("\uC544\uC774\uB514");
			btnmId.setBackground(Color.WHITE);

			group.add(btnmId);
		}
		return btnmId;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 221, 429, 15);
		}
		return separator;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(12, 70, 152, 33);
			panel.add(getBtnEno());
			panel.add(getBtnmId());
		}
		return panel;
	}

	private JLabel get사원번호() {
		if (사원번호 == null) {
			사원번호 = new JLabel("\uC0AC\uC6D0\uBC88\uD638");
			사원번호.setBounds(45, 123, 57, 15);
		}
		return 사원번호;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setBounds(45, 148, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JTextField getTserial() {
		if (tserial == null) {
			tserial = new JTextField();
			tserial.setBounds(114, 120, 152, 21);
			tserial.setColumns(10);
		}
		return tserial;
	}

	private JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setBounds(114, 145, 152, 21);
			tmId.setColumns(10);
		}
		return tmId;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
			label_1.setBounds(35, 236, 57, 15);
		}
		return label_1;
	}

	private JPasswordField getTpwd() {
		if (tpwd == null) {
			tpwd = new JPasswordField();
			tpwd.setToolTipText("\uC601\uBB38,\uC22B\uC790,\uD2B9\uC218\uAE30\uD638\uB97C \uC870\uD569\uD558\uC5EC 9~12\uC790\uB9AC\uB85C \uC124\uC815\uD574\uC8FC\uC138\uC694.");
			tpwd.setBounds(130, 233, 157, 21);
		}
		return tpwd;
	}

	private JLabel getLabel_2_1() {
		if (label_2 == null) {
			label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638\uD655\uC778");
			label_2.setBounds(35, 261, 80, 15);
		}
		return label_2;
	}

	private JPasswordField getTpwdck() {
		if (tpwdck == null) {
			tpwdck = new JPasswordField();
			tpwdck.setBounds(130, 258, 157, 23);
		}
		return tpwdck;
	}

	private JLabel getLabel_4_1() {
		if (label_4 == null) {
			label_4 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBD84\uC2E4\uC2DC ");
			label_4.setBounds(35, 300, 117, 21);
		}
		return label_4;
	}

	private JComboBox getComboBox_1() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBackground(Color.WHITE);
			comboBox.setModel(
					new DefaultComboBoxModel(new String[] { "\uC81C\uC77C \uC88B\uC544\uD558\uB294 \uC0C9\uAE54\uC740?",
							"\uC5B4\uB9B0 \uC2DC\uC808 \uBCC4\uBA85\uC740?",
							"\uAC00\uC7A5 \uC88B\uC544\uD558\uB294 \uACFC\uC77C\uC740?",
							"\uAC00\uC7A5 \uC874\uACBD\uD558\uB294 \uC778\uBB3C\uC740?" }));
			comboBox.setBounds(130, 300, 157, 21);
		}
		return comboBox;
	}

	private JLabel getLabel_5_1() {
		if (label_5 == null) {
			label_5 = new JLabel("\uD655\uC778\uC9C8\uBB38");
			label_5.setBounds(35, 319, 80, 21);
		}
		return label_5;
	}

	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("\uD655\uC778\uC9C8\uBB38 \uC815\uB2F5");
			label_6.setBounds(35, 350, 83, 17);
		}
		return label_6;
	}

	private JTextField getTpwdan() {
		if (tpwdan == null) {
			tpwdan = new JTextField();
			tpwdan.setColumns(10);
			tpwdan.setBounds(130, 346, 157, 21);
		}
		return tpwdan;
	}
}
