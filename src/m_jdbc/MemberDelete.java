package m_jdbc;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MemberDelete extends JInternalFrame {
	private JLabel label;
	private JLabel label_1;
	private JTextField tmId;
	private JButton button;
	private JLabel label_2;
	private JTextField tmName;
	private JTextField trDate;
	private JLabel label_3;
	private JLabel label_4;
	private JComboBox tgrade;
	private JButton button_1;
	private JLabel status;
	private JLabel label_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberDelete frame = new MemberDelete();
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
	public MemberDelete() {
		super("학생정보삭제", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 308, 294);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_1());
		getContentPane().add(getTmId());
		getContentPane().add(getButton());
		getContentPane().add(getLabel_2());
		getContentPane().add(getTmName());
		getContentPane().add(getTrDate());
		getContentPane().add(getLabel_3());
		getContentPane().add(getLabel_4());
		getContentPane().add(getTgrade());
		getContentPane().add(getButton_1());
		getContentPane().add(getStatus());
		getContentPane().add(getLabel_5());

	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uD559\uC0DD\uC815\uBCF4\uC0AD\uC81C");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("나눔고딕", Font.BOLD, 20));
			label.setBounds(0, 10, 290, 24);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC544\uC774\uB514");
			label_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			label_1.setBounds(22, 55, 57, 15);
		}
		return label_1;
	}
	private JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 12));
			tmId.setColumns(10);
			tmId.setBounds(68, 54, 116, 21);
		}
		return tmId;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uAC80\uC0C9");
			button.addActionListener(new ActionListener() { //검색
				public void actionPerformed(ActionEvent e) {
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					MemberDao dao = new MemberDao();
					String mId = tmId.getText();
					MemberVo vo = dao.search(mId);
					
					tmId.setText(vo.getmId());
					tmName.setText(vo.getmName());
					trDate.setText(sdf.format(vo.getrDate()));
					tgrade.setSelectedIndex(vo.getGrade()-1);
					
					tmId.requestFocus();
					tmId.selectAll();
					
				}
			});
			button.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			button.setBounds(196, 51, 78, 23);
		}
		return button;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC131   \uBA85");
			label_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			label_2.setBounds(22, 90, 57, 15);
		}
		return label_2;
	}
	private JTextField getTmName() {
		if (tmName == null) {
			tmName = new JTextField();
			tmName.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 12));
			tmName.setColumns(10);
			tmName.setBounds(68, 87, 116, 21);
		}
		return tmName;
	}
	private JTextField getTrDate() {
		if (trDate == null) {
			trDate = new JTextField();
			trDate.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 12));
			trDate.setColumns(10);
			trDate.setBounds(68, 122, 116, 21);
		}
		return trDate;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC785\uD559\uC77C");
			label_3.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			label_3.setBounds(22, 125, 57, 15);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uD559   \uB144");
			label_4.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			label_4.setBounds(22, 160, 57, 15);
		}
		return label_4;
	}
	private JComboBox getTgrade() {
		if (tgrade == null) {
			tgrade = new JComboBox();
			tgrade.setModel(new DefaultComboBoxModel(new String[] {"1\uD559\uB144", "2\uD559\uB144", "3\uD559\uB144", "4\uD559\uB144", "5\uD559\uB144", "6\uD559\uB144", "7\uD559\uB144", "8\uD559\uB144", "9\uD559\uB144", "10\uD559\uB144"}));
			tgrade.setMaximumRowCount(5);
			tgrade.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			tgrade.setBounds(68, 157, 78, 21);
		}
		return tgrade;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("\uC0AD\uC81C");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //삭제
					
					String mId = tmId.getText();
					MemberDao dao = new MemberDao();
					int r = dao.delete(mId);
					if(r != 0) {
						status.setText(mId + "학생의 정보가 삭제되었습니다.");
					} else {
						status.setText("학생의 정보가 삭제 중 오류가 발생했습니다.");
						status.setBackground(Color.YELLOW);
					}
					tmName.setText("");
					trDate.setText("");
					tgrade.setSelectedIndex(0);
					tmId.requestFocus();
					tmId.selectAll();
					
				}
			});
			button_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			button_1.setBounds(66, 197, 97, 23);
		}
		return button_1;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			status.setBounds(0, 230, 290, 21);
		}
		return status;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("");
			label_5.setOpaque(true);
			label_5.setBackground(new Color(255, 192, 203));
			label_5.setBounds(0, 6, 290, 32);
		}
		return label_5;
	}
}
