package m_jdbc;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MemberInsert extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField tmId;
	private JTextField tmName;
	private JTextField trDate;
	private JComboBox tgrade;
	private JButton btnNewButton;
	private JLabel status;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInsert frame = new MemberInsert();
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
	public MemberInsert() {
		super("학생정보입력", false, true, true, true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setVisible(true);
		getContentPane().setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
		setBounds(100, 100, 237, 296);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getTmId());
		getContentPane().add(getTmName());
		getContentPane().add(getTrDate());
		getContentPane().add(getTgrade());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getStatus());
		getContentPane().add(getLblNewLabel_5());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uC0DD\uC815\uBCF4\uC785\uB825");
			lblNewLabel.setBounds(0, 11, 221, 24);
			lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(22, 53, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC131   \uBA85");
			lblNewLabel_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(22, 88, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC785\uD559\uC77C");
			lblNewLabel_3.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			lblNewLabel_3.setBounds(22, 123, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uD559   \uB144");
			lblNewLabel_4.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			lblNewLabel_4.setBounds(22, 158, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 12));
			tmId.setBounds(68, 52, 116, 21);
			tmId.setColumns(10);
		}
		return tmId;
	}
	private JTextField getTmName() {
		if (tmName == null) {
			tmName = new JTextField();
			tmName.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 12));
			tmName.setBounds(68, 85, 116, 21);
			tmName.setColumns(10);
		}
		return tmName;
	}
	private JTextField getTrDate() {
		if (trDate == null) {
			trDate = new JTextField();
			trDate.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 12));
			trDate.setBounds(68, 120, 116, 21);
			trDate.setColumns(10);
		}
		return trDate;
	}
	private JComboBox getTgrade() {
		if (tgrade == null) {
			tgrade = new JComboBox();
			tgrade.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			tgrade.setMaximumRowCount(5);
			tgrade.setModel(new DefaultComboBoxModel(new String[] {"1\uD559\uB144", "2\uD559\uB144", "3\uD559\uB144", "4\uD559\uB144", "5\uD559\uB144", "6\uD559\uB144", "7\uD559\uB144", "8\uD559\uB144", "9\uD559\uB144", "10\uD559\uB144"}));
			tgrade.setBounds(68, 155, 78, 21);
		}
		return tgrade;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					MemberVo vo = new MemberVo();
					MemberDao dao = new MemberDao();
					try {
						vo.setmId(tmId.getText());
						vo.setmName(tmName.getText());
						vo.setrDate(sdf.parse(trDate.getText()));
						vo.setGrade(tgrade.getSelectedIndex()+1);
					} catch (Exception ex) {} 
					
					
					int r = dao.insert(vo);
					if(r>0) {
						status.setText(vo.getmId() + "학생의 정보가 입력되었습니다.");
					} else {
						status.setText("학생의 정보 입력 중 오류가 발생했습니다.");
						status.setBackground(Color.YELLOW);
					}
					tmName.setText("");
					trDate.setText("");
					tgrade.setSelectedIndex(0);
					tmId.requestFocus();
					tmId.selectAll();
				}
			});
			btnNewButton.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			btnNewButton.setBounds(68, 200, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			status.setBounds(0, 233, 233, 24);
		}
		return status;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setOpaque(true);
			lblNewLabel_5.setBackground(new Color(255, 192, 203));
			lblNewLabel_5.setBounds(0, 7, 221, 32);
		}
		return lblNewLabel_5;
	}
}
