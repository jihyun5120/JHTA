package m_jdbc;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class ScoreDelete extends JInternalFrame {
	
	ScoreDao dao = new ScoreDao();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField tmId;
	private JTextField tmName;
	private JTextField tsubject;
	private JTextField tscore;
	private JButton button;
	private JLabel status;
	private JLabel label_6;
	private JTextField tserial;
	private JButton button_1;
	private JSeparator separator;
	private JLabel label_7;
	private JTextField trDate;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreDelete frame = new ScoreDelete();
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
	public ScoreDelete() {
		super("학생성적삭제", false, true, true, true);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				try {
					dao.conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		setVisible(true);
		setBounds(100, 100, 329, 357);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_1());
		getContentPane().add(getLabel_2());
		getContentPane().add(getLabel_3());
		getContentPane().add(getLabel_4());
		getContentPane().add(getTmId());
		getContentPane().add(getTmName());
		getContentPane().add(getTsubject());
		getContentPane().add(getTscore());
		getContentPane().add(getButton());
		getContentPane().add(getStatus());
		getContentPane().add(getLabel_6());
		getContentPane().add(getTserial());
		getContentPane().add(getButton_1());
		getContentPane().add(getSeparator());
		getContentPane().add(getLabel_7());
		getContentPane().add(getTrDate());
		getContentPane().add(getLblNewLabel());

	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uD559\uC0DD\uC131\uC801\uC0AD\uC81C");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("나눔고딕", Font.BOLD, 20));
			label.setBounds(0, 10, 313, 35);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC544 \uC774 \uB514");
			label_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			label_1.setBounds(29, 115, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC131     \uBA85");
			label_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			label_2.setBounds(29, 145, 57, 15);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uACFC     \uBAA9");
			label_3.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			label_3.setBounds(29, 205, 57, 15);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC810     \uC218");
			label_4.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			label_4.setBounds(29, 235, 57, 15);
		}
		return label_4;
	}
	private JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			tmId.setColumns(10);
			tmId.setBounds(85, 111, 116, 21);
		}
		return tmId;
	}
	private JTextField getTmName() {
		if (tmName == null) {
			tmName = new JTextField();
			tmName.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			tmName.setColumns(10);
			tmName.setBounds(85, 142, 116, 21);
		}
		return tmName;
	}
	private JTextField getTsubject() {
		if (tsubject == null) {
			tsubject = new JTextField();
			tsubject.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			tsubject.setColumns(10);
			tsubject.setBounds(85, 202, 116, 21);
		}
		return tsubject;
	}
	private JTextField getTscore() {
		if (tscore == null) {
			tscore = new JTextField();
			tscore.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			tscore.setColumns(10);
			tscore.setBounds(85, 232, 116, 21);
		}
		return tscore;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uC0AD\uC81C");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int serial = Integer.parseInt(tserial.getText());
					int r = dao.delete(serial);
					if(r>0) {
						status.setText("정보가 삭제되었습니다.");
					} else {
						status.setText("정보 삭제 중 오류가 발생했습니다.");
					}
					tmId.setText("");
					tmName.setText("");
					trDate.setText("");
					tsubject.setText("");
					tscore.setText("");
					tserial.requestFocus();
					tserial.selectAll();
				}
			});
			button.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			button.setBounds(104, 263, 97, 23);
		}
		return button;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 12));
			status.setBounds(0, 296, 313, 22);
		}
		return status;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("Serial");
			label_6.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.BOLD, 13));
			label_6.setBounds(29, 65, 57, 15);
		}
		return label_6;
	}
	private JTextField getTserial() {
		if (tserial == null) {
			tserial = new JTextField();
			tserial.setColumns(10);
			tserial.setBounds(85, 61, 116, 21);
		}
		return tserial;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("\uC870\uD68C");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //조회
					
					int serial = Integer.parseInt(tserial.getText());
					ScoreVo vo = dao.search(serial);
					if(vo==null) {
						status.setText("정보가 없습니다.");
					}else {
						tmId.setText(vo.getmId());
						tmName.setText(vo.getmName());
						trDate.setText(sdf.format(vo.getrDate()));
						tsubject.setText(vo.getSubject());
						tscore.setText(vo.getScore() + "");
						status.setText("정보를 삭제해주세요");
					}
					
				}
			});
			button_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			button_1.setBounds(210, 60, 68, 23);
		}
		return button_1;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 95, 291, 10);
		}
		return separator;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("\uC751 \uC2DC \uC77C");
			label_7.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			label_7.setBounds(29, 175, 57, 15);
		}
		return label_7;
	}
	private JTextField getTrDate() {
		if (trDate == null) {
			trDate = new JTextField();
			trDate.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			trDate.setColumns(10);
			trDate.setBounds(85, 172, 116, 21);
		}
		return trDate;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(173, 216, 230));
			lblNewLabel.setBounds(0, 10, 313, 35);
		}
		return lblNewLabel;
	}
}
