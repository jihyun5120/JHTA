package m_jdbc;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class ScoreInsert extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JTextField tmId;
	private JTextField tsubject;
	private JTextField tscore;
	private JButton btnNewButton;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField trDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreInsert frame = new ScoreInsert();
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
	public ScoreInsert() {
		super("학생성적입력", false, true, true, true);
		setVisible(true);
		getContentPane().setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
		setBounds(100, 100, 259, 241);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLabel());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getTmId());
		getContentPane().add(getTsubject());
		getContentPane().add(getTscore());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getLabel_1());
		getContentPane().add(getLabel_2());
		getContentPane().add(getTrDate());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uC0DD\uC131\uC801\uC785\uB825");
			lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 10, 243, 35);
		}
		return lblNewLabel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC544  \uC774  \uB514");
			label.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			label.setBounds(27, 55, 57, 15);
		}
		return label;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uACFC       \uBAA9");
			lblNewLabel_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(27, 115, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC810       \uC218");
			lblNewLabel_4.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			lblNewLabel_4.setBounds(27, 145, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			tmId.setBounds(86, 52, 116, 21);
			tmId.setColumns(10);
		}
		return tmId;
	}
	private JTextField getTsubject() {
		if (tsubject == null) {
			tsubject = new JTextField();
			tsubject.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			tsubject.setBounds(85, 112, 116, 21);
			tsubject.setColumns(10);
		}
		return tsubject;
	}
	private JTextField getTscore() {
		if (tscore == null) {
			tscore = new JTextField();
			tscore.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			tscore.setBounds(85, 140, 116, 21);
			tscore.setColumns(10);
		}
		return tscore;
	}
	private JButton getBtnNewButton() { //저장
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						ScoreVo vo = new ScoreVo();
						ScoreDao dao = new ScoreDao();
						Pattern pattern = Pattern.compile("/^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/"); 
						Matcher ma = pattern.matcher(trDate.getText());
						if(tmId.getText().equals("")) {
							JOptionPane.showMessageDialog(ScoreInsert.this, "회원아이디를 입력해주세요.");
						} else if(trDate.getText().equals("")) {
							JOptionPane.showMessageDialog(ScoreInsert.this, "응시일자를 입력해주세요");
						}else if(ma.find()==false){
							JOptionPane.showMessageDialog(ScoreInsert.this, "ex 2020-01-17의 양식으로 입력해주세요."); 
						}else if(tsubject.getText().equals("")) {
							JOptionPane.showMessageDialog(ScoreInsert.this, "과목명을 입력해주세요."); 
						}else if(tscore.getText().equals("")) {
							JOptionPane.showMessageDialog(ScoreInsert.this, "성적을 입력해주세요."); 
						} else {
							vo.setmId(tmId.getText());
							vo.setrDate(sdf.parse(trDate.getText()));
							vo.setSubject(tsubject.getText());
							vo.setScore(Integer.parseInt(tscore.getText()));
							
							int cnt = dao.insert(vo);
							
							if(cnt>0) {
								JOptionPane.showMessageDialog(ScoreInsert.this, "성적정보가 입력되었습니다.");
							}else {
								JOptionPane.showMessageDialog(ScoreInsert.this, "성적정보 입력 중 오류가 발생했습니다.");
							}
						}
						tmId.requestFocus();
						tmId.selectAll();
						
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			btnNewButton.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			btnNewButton.setBounds(73, 170, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setOpaque(true);
			label_1.setBackground(new Color(173, 216, 230));
			label_1.setBounds(0, 10, 243, 35);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC751\uC2DC\uC77C\uC790");
			label_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			label_2.setBounds(27, 85, 57, 15);
		}
		return label_2;
	}
	private JTextField getTrDate() {
		if (trDate == null) {
			trDate = new JTextField();
			trDate.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			trDate.setColumns(10);
			trDate.setBounds(85, 82, 116, 21);
		}
		return trDate;
	}
}
