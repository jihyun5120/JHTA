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
import java.awt.Component;
import javax.swing.Box;

public class MemberUpdate extends JInternalFrame {
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
	private JButton btnNewButton_1;
	private JLabel status;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberUpdate frame = new MemberUpdate();
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
	public MemberUpdate() {
		super("학생정보수정", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 306, 289);
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
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getStatus());
		getContentPane().add(getLabel());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uC0DD\uC815\uBCF4\uC218\uC815");
			lblNewLabel.setBounds(0, 10, 290, 24);
			lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(22, 55, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC131   \uBA85");
			lblNewLabel_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(22, 90, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC785\uD559\uC77C");
			lblNewLabel_3.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			lblNewLabel_3.setBounds(22, 125, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uD559   \uB144");
			lblNewLabel_4.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			lblNewLabel_4.setBounds(22, 160, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 12));
			tmId.setBounds(68, 54, 116, 21);
			tmId.setColumns(10);
		}
		return tmId;
	}
	private JTextField getTmName() {
		if (tmName == null) {
			tmName = new JTextField();
			tmName.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 12));
			tmName.setBounds(68, 87, 116, 21);
			tmName.setColumns(10);
		}
		return tmName;
	}
	private JTextField getTrDate() {
		if (trDate == null) {
			trDate = new JTextField();
			trDate.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 12));
			trDate.setBounds(68, 122, 116, 21);
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
			tgrade.setBounds(68, 157, 78, 21);
		}
		return tgrade;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC218\uC815");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //저장
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					MemberDao dao = new MemberDao();
					MemberVo vo = new MemberVo();
					try {
						vo.setmId(tmId.getText());
						vo.setmName(tmName.getText());
						vo.setrDate(sdf.parse(trDate.getText()));
						vo.setGrade(tgrade.getSelectedIndex()+1);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					int r = dao.update(vo);
					if(r != 0) {
						status.setText(vo.getmId() + "학생의 정보가 수정되었습니다.");
					} else {
						status.setText("학생의 정보 수정 중 오류가 발생했습니다.");
						status.setBackground(Color.YELLOW);
					}
					tmId.requestFocus();
					tmId.selectAll();
				}
			});
			btnNewButton.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			btnNewButton.setBounds(98, 196, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uAC80\uC0C9");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //검색
					
					String mId = tmId.getText();
					MemberDao dao = new MemberDao();
					MemberVo vo = dao.search(mId);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					
					tmName.setText(vo.getmName());
					trDate.setText(sdf.format(vo.getrDate()));
					tgrade.setSelectedIndex(vo.getGrade()-1);
					
					tmName.requestFocus();
					tmName.selectAll();
				}
			});
			btnNewButton_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			btnNewButton_1.setBounds(196, 51, 78, 23);
		}
		return btnNewButton_1;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setOpaque(true);
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			status.setBounds(0, 229, 290, 21);
		}
		return status;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setOpaque(true);
			label.setBackground(new Color(255, 192, 203));
			label.setBounds(0, 7, 290, 32);
		}
		return label;
	}
}
