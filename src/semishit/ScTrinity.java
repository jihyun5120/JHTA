package semishit;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ScTrinity extends JDialog {
	SC_search sc;
	ButtonGroup group = new ButtonGroup();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private JLabel lblNewLabel;
	private JTextField tsno;
	private JTextField tname;
	private JTextField tsub;
	private JSeparator separator;
	private JTextField tsco;
	private JTextField tdate;
	private JComboBox combo;
	private JRadioButton rbp;
	private JRadioButton rbu;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel status;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ScTrinity dialog = new ScTrinity();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ScTrinity() {
		setVisible(true);
		setTitle("\uD559\uC0DD \uC131\uC801 \uC815\uBCF4 ");
		setBounds(100, 100, 237, 439);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTsno());
		getContentPane().add(getTname());
		getContentPane().add(getTsub());
		getContentPane().add(getSeparator());
		getContentPane().add(getTsco());
		getContentPane().add(getTdate());
		getContentPane().add(getCombo());
		getContentPane().add(getRbp());
		getContentPane().add(getRbu());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getLblNewLabel_5());
		getContentPane().add(getLblNewLabel_6());
		getContentPane().add(getLblNewLabel_7());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getStatus());
		getContentPane().add(getBtnNewButton());
	}
	
	public ScTrinity(ScVo vo, SC_search sc) {
		this();
		this.sc=sc;
		tsno.setText(String.valueOf(vo.getSno()));
		tname.setText(vo.getName());
		
		if(vo.getSub()!=null) {
		tsub.setText(vo.getSub());
		}else {
			tsub.setText("과목을 입력해주세요.");
		}
		
		if(vo.getSco()>=0 || vo.getSco()<=100) {
		tsco.setText(String.valueOf(vo.getSco()));
		}else {
			tsco.setText("성적을 입력해주세요.");
		}
		
		if(vo.getrDate()!=null) {
		tdate.setText(sdf.format(vo.getrDate()));
		}else {
			tdate.setText("날짜를 입력해주세요.");
		}
		if(vo.getnTry()!=null) {
			if(vo.getnTry().equals("1차 시험")) {
				combo.setSelectedIndex(0);
			}else if(vo.getnTry().equals("2회차")) {
				combo.setSelectedIndex(1);
			}else if(vo.getnTry().equals("3회차")) {
				combo.setSelectedIndex(2);
			}
		}else {
			combo.setSelectedIndex(0);
		}
		if(vo.getPass()!=null) {
			if(vo.getPass().equals("pass")) {
				rbp.setSelected(true);
			}else if(vo.getPass().equals("unpass")) {
				rbu.setSelected(true);
			}
		}else {
			rbp.setSelected(true);
		}
		
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uC0DD\uC131\uC801 \uC785\uB825 \uC218\uC815 \uC0AD\uC81C");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
			lblNewLabel.setBounds(12, 10, 181, 67);
		}
		return lblNewLabel;
	}
	private JTextField getTsno() {
		if (tsno == null) {
			tsno = new JTextField();
			tsno.setEditable(false);
			tsno.setBounds(77, 87, 116, 21);
			tsno.setColumns(10);
		}
		return tsno;
	}
	private JTextField getTname() {
		if (tname == null) {
			tname = new JTextField();
			tname.setEditable(false);
			tname.setBounds(77, 118, 116, 21);
			tname.setColumns(10);
		}
		return tname;
	}
	private JTextField getTsub() {
		if (tsub == null) {
			tsub = new JTextField();
			tsub.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(tsub.getText().equals("과목을 입력해주세요.")) {
						tsub.setText("");
					}
				}
			});
			tsub.setBounds(77, 175, 116, 21);
			tsub.setColumns(10);
		}
		return tsub;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(8, 154, 206, 17);
		}
		return separator;
	}
	private JTextField getTsco() {
		if (tsco == null) {
			tsco = new JTextField();
			tsco.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(tsco.getText().equals("성적을 입력해주세요.")) {
						tsco.setText("");
					}
				}
			});
			tsco.setBounds(77, 206, 116, 21);
			tsco.setColumns(10);
		}
		return tsco;
	}
	private JTextField getTdate() {
		if (tdate == null) {
			tdate = new JTextField();
			tdate.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(tdate.getText().equals("날짜를 입력해주세요.")) {
						tdate.setText("");
					}
				}
			});
			tdate.setBounds(77, 237, 116, 21);
			tdate.setColumns(10);
		}
		return tdate;
	}
	private JComboBox getCombo() {
		if (combo == null) {
			combo = new JComboBox();
			combo.setModel(new DefaultComboBoxModel(new String[] {"1\uD68C\uCC28", "2\uD68C\uCC28", "3\uD68C\uCC28"}));
			combo.setBounds(77, 271, 116, 21);
		}
		return combo;
	}
	private JRadioButton getRbp() {
		if (rbp == null) {
			rbp = new JRadioButton("pass");
			group.add(rbp);
			rbp.setBounds(74, 298, 60, 23);
		}
		return rbp;
	}
	private JRadioButton getRbu() {
		if (rbu == null) {
			rbu = new JRadioButton("unpass");
			group.add(rbu);
			rbu.setBounds(138, 298, 67, 23);
		}
		return rbu;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setBounds(8, 90, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC774\uB984");
			lblNewLabel_2.setBounds(12, 121, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uACFC\uBAA9");
			lblNewLabel_3.setBounds(12, 178, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC131\uC801");
			lblNewLabel_4.setBounds(12, 209, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uB0A0\uC9DC");
			lblNewLabel_5.setBounds(12, 240, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("\uC2DC\uD5D8 \uD69F\uC218");
			lblNewLabel_6.setBounds(12, 274, 57, 15);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("\uD1B5\uACFC \uC5EC\uBD80");
			lblNewLabel_7.setBounds(12, 302, 57, 15);
		}
		return lblNewLabel_7;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC785\uB825");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(tsub.getText().equals("") || tsub.getText().equals("과목을 입력해주세요.")) {
						status.setText("과목을 입력해주세요.");
					}else if(tsco.getText().equals("") || tsco.getText().equals("성적을 입력해주세요.")) {
							status.setText("성적을 입력해주세요.");
						}else if(tdate.getText().equals("")  || tdate.getText().equals("날짜를 입력해주세요.")) {
								status.setText("날짜를 입력해주세요.");
							}else {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								ScVo vo = new ScVo();
								ScDao dao = new ScDao();
								
								try {
								vo.setSno(Integer.parseInt(tsno.getText()));
								vo.setSub(tsub.getText());
								vo.setSco(Integer.parseInt(tsco.getText()));
								vo.setrDate(sdf.parse(tdate.getText()));
									
									if(combo.getSelectedIndex()==0) {
										vo.setnTry("1회차");
									}else if(combo.getSelectedIndex()==1) {
										vo.setnTry("2회차");
									}else if(combo.getSelectedIndex()==2) {
										vo.setnTry("3회차");
									}
									
									if(rbp.isSelected()) {
										vo.setPass("pass");
									}else if(rbu.isSelected()) {
										vo.setPass("unpass");
									}
									int r = dao.insert(vo);
									if(r>0) {
									
													status.setText("입력이 완료되었습니다.");
													tsub.setText("");
													tsco.setText("");
													tdate.setText("");
													combo.setSelectedIndex(0);
													rbp.setSelected(true);
													tsub.requestFocus();
													tsub.selectAll();	
													sc.restart();
									}else status.setText("입력중 오류가 발생하였습니다.");
								} catch (ParseException e1) {
									e1.printStackTrace();
								}
							}
					
						
				
				}
			});
			btnNewButton_1.setBounds(8, 341, 67, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC0AD\uC81C");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int sno = Integer.parseInt(tsno.getText());
					ScDao dao = new ScDao();
					int r = dao.delete(sno);
					if(r>0) {
						status.setText("삭제가 완료되었습니다.");
						tsno.setText("");
						tname.setText("");
						tsub.setText("");
						tsco.setText("");
						tdate.setText("");
						combo.setSelectedIndex(0);
						rbp.setSelected(true);
						tsub.requestFocus();
						tsub.selectAll();
						sc.restart();
					}else status.setText("삭제중 오류가 발생하였습니다.");
				}
			});
			btnNewButton_2.setBounds(147, 341, 67, 23);
		}
		return btnNewButton_2;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setOpaque(true);
			status.setBackground(Color.WHITE);
			status.setBounds(8, 374, 206, 15);
		}
		return status;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC218\uC815");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					{
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						ScVo vo = new ScVo();
						ScDao dao = new ScDao();
						
						try {
						vo.setSno(Integer.parseInt(tsno.getText()));
						vo.setSub(tsub.getText());
						vo.setSco(Integer.parseInt(tsco.getText()));
						vo.setrDate(sdf.parse(tdate.getText()));
							
							if(combo.getSelectedIndex()==0) {
								vo.setnTry("1회차");
							}else if(combo.getSelectedIndex()==1) {
								vo.setnTry("2회차");
							}else if(combo.getSelectedIndex()==2) {
								vo.setnTry("3회차");
							}
							
							if(rbp.isSelected()) {
								vo.setPass("pass");
							}else if(rbu.isSelected()) {
								vo.setPass("unpass");
							}
							int r = dao.update(vo);
							if(r>0) {
								status.setText("수정이 완료되었습니다.");
								tsub.setText("");
								tsco.setText("");
								tdate.setText("");
								combo.setSelectedIndex(0);
								rbp.setSelected(true);
								tsub.requestFocus();
								tsub.selectAll();
								sc.restart();
							}else status.setText("수정중 오류가 발생하였습니다.");
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btnNewButton.setBounds(77, 341, 67, 23);
		}
		return btnNewButton;
	}
}
