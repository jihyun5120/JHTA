package semishit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UpdateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField sno;
	private JTextField sname;
	private JTextField sbirth;
	private JTextField saddress;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField sphone;
	private JTextField semail;
	private JLabel photo;
	private JButton button;
	private JButton insertBtn;
	private JLabel search;
	private JLabel label_8;
	private JTextField smale;
	private JLabel label_9;
	private JTextField eno;
	String fn;
	String fp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UpdateDialog dialog = new UpdateDialog();
			
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UpdateDialog() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
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
		setVisible(true);
		setTitle("\uD559\uC0DD\uC815\uBCF4 \uC218\uC815");
		setBounds(100, 100, 530, 387);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getSno());
		contentPanel.add(getSname());
		contentPanel.add(getSbirth());
		contentPanel.add(getSaddress());
		contentPanel.add(getLabel());
		contentPanel.add(getLabel_1());
		contentPanel.add(getLabel_2());
		contentPanel.add(getLabel_3());
		contentPanel.add(getLabel_4());
		contentPanel.add(getLabel_5());
		contentPanel.add(getSphone());
		contentPanel.add(getSemail());
		contentPanel.add(getPhoto());
		contentPanel.add(getButton());
		contentPanel.add(getSearch());
		contentPanel.add(getLabel_8());
		contentPanel.add(getSmale());
		contentPanel.add(getLabel_9());
		contentPanel.add(getEno());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 140, 0));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			buttonPane.add(getInsertBtn());
		}
		
		
		
	}
	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setColumns(10);
			sno.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sno.setBounds(80, 30, 197, 21);
		}
		return sno;
	}
	private JTextField getSname() {
		if (sname == null) {
			sname = new JTextField();
			sname.setColumns(10);
			sname.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sname.setBounds(80, 59, 197, 21);
		}
		return sname;
	}
	private JTextField getSbirth() {
		if (sbirth == null) {
			sbirth = new JTextField();
			sbirth.setColumns(10);
			sbirth.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sbirth.setBounds(80, 90, 197, 21);
		}
		return sbirth;
	}
	private JTextField getSaddress() {
		if (saddress == null) {
			saddress = new JTextField();
			saddress.setColumns(10);
			saddress.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			saddress.setBounds(80, 120, 197, 21);
		}
		return saddress;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uD559\uBC88");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			label.setBounds(13, 31, 57, 15);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC774\uB984");
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			label_1.setBounds(13, 62, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			label_2.setBounds(13, 93, 57, 15);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC8FC\uC18C");
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			label_3.setBounds(13, 123, 57, 15);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC5F0\uB77D\uCC98");
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			label_4.setBounds(14, 154, 57, 15);
		}
		return label_4;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uC774\uBA54\uC77C");
			label_5.setHorizontalAlignment(SwingConstants.RIGHT);
			label_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			label_5.setBounds(13, 185, 57, 15);
		}
		return label_5;
	}
	private JTextField getSphone() {
		if (sphone == null) {
			sphone = new JTextField();
			sphone.setColumns(10);
			sphone.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			sphone.setBounds(80, 151, 197, 21);
		}
		return sphone;
	}
	private JTextField getSemail() {
		if (semail == null) {
			semail = new JTextField();
			semail.setColumns(10);
			semail.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			semail.setBounds(80, 182, 197, 21);
		}
		return semail;
	}
	private JLabel getPhoto() {
		if (photo == null) {
			photo = new JLabel("");
			photo.setHorizontalAlignment(SwingConstants.CENTER);
			photo.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\\uC0AC\uB78C.png"));
			photo.setBounds(357, 30, 145, 157);
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
					int flag = fc.showOpenDialog(UpdateDialog.this);
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
			button.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			button.setBounds(380, 197, 97, 23);
		}
		return button;
	}
	private JButton getInsertBtn() {
		if (insertBtn == null) {
			insertBtn = new JButton("\uC800\uC7A5");
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
							ex.printStackTrace();
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
						
						Thread t = new Send1(vo.getImname(), vo.getImpath());
						t.start();
						
						
						
						int r = dao.update(vo);
						if(r>0) {
							JOptionPane.showMessageDialog(insertBtn, "학생 수정 완료");
						}else {
							JOptionPane.showMessageDialog(insertBtn, "학번/강사번호 오류");
						}
					
					}catch(Exception ex1) {
						JOptionPane.showMessageDialog(insertBtn, "제대로 입력하세요.");
						ex1.printStackTrace();
					}
				}
			});
			insertBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		}
		return insertBtn;
	}
	public JLabel getSearch() {
		if (search == null) {
			search = new JLabel("");
			search.addMouseListener(new MouseAdapter() {
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
			search.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\\uC0AC\uC9C4\\\uAC80\uC0C9.png"));
			search.setBounds(289, 23, 30, 38);
		}
		return search;
	}
	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("\uC131\uBCC4");
			label_8.setHorizontalAlignment(SwingConstants.RIGHT);
			label_8.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			label_8.setBounds(12, 214, 57, 15);
		}
		return label_8;
	}
	private JTextField getSmale() {
		if (smale == null) {
			smale = new JTextField();
			smale.setFont(new Font("돋움", Font.PLAIN, 12));
			smale.setColumns(10);
			smale.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			smale.setBounds(80, 212, 197, 21);
		}
		return smale;
	}
	private JLabel getLabel_9() {
		if (label_9 == null) {
			label_9 = new JLabel("\uAC15\uC0AC\uBC88\uD638");
			label_9.setHorizontalAlignment(SwingConstants.RIGHT);
			label_9.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			label_9.setBounds(15, 242, 57, 15);
		}
		return label_9;
	}
	private JTextField getEno() {
		if (eno == null) {
			eno = new JTextField();
			eno.setFont(new Font("돋움", Font.PLAIN, 12));
			eno.setColumns(10);
			eno.setBorder(new LineBorder(new Color(255, 127, 80), 2));
			eno.setBounds(80, 240, 197, 21);
		}
		return eno;
	}
}
