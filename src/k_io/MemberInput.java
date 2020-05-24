package k_io;

import java.awt.EventQueue;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MemberInput extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField mid;
	private JTextField pwd;
	private JTextField mName;
	private JTextField phone;
	private JButton btnNewButton;
	private JLabel status;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInput frame = new MemberInput();
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
	public MemberInput() {
		super("회원입력", false, true, true, true);
		setBackground(new Color(192, 192, 192));
		getContentPane().setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 13));
		getContentPane().setBackground(new Color(154, 205, 50));
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getMid());
		getContentPane().add(getPwd());
		getContentPane().add(getMName());
		getContentPane().add(getPhone());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getStatus());
		setVisible(true);
		setBounds(30, 50, 316, 300);
	}
	
	public void input() {
		String id = mid.getText();
		String p = pwd.getText();
		String n = mName.getText();
		String ph = phone.getText();

		boolean flag = true;
//				Pattern.matches(FileExam2.idCheck, id) &&
//				       Pattern.matches(FileExam2.pwdCheck, p) &&
//				       Pattern.matches(FileExam2.nameCheck, n) &&
//				       Pattern.matches(FileExam2.phoneCheck, ph);
		
		
		if(!flag) {
			status.setText("입력하신 정보에 오류가 있습니다.");
			return;
		} 
		
		MemberVo vo = new MemberVo(id, p, n, ph);
		MemberDao dao = new MemberDao();
		boolean b = dao.insert(vo);
		
		if(b) {
		mid.setText("");
		pwd.setText("");
		mName.setText("");
		phone.setText("");
		
		mid.requestFocus();
		mid.selectAll();
		
		status.setText("회원 정보가 추가되었습니다.");
		} else {
			status.setText("저장 중 오류가 발생했습니다.");
		}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544  \uC774  \uB514");
			lblNewLabel.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 13));
			lblNewLabel.setBounds(12, 35, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
			lblNewLabel_1.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 13));
			lblNewLabel_1.setBounds(12, 71, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC774      \uB984");
			lblNewLabel_2.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 13));
			lblNewLabel_2.setBounds(12, 108, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC804\uD654\uBC88\uD638");
			lblNewLabel_3.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 13));
			lblNewLabel_3.setBounds(12, 146, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getMid() {
		if (mid == null) {
			mid = new JTextField();
			mid.setBounds(67, 30, 109, 21);
			mid.setColumns(10);
		}
		return mid;
	}
	private JTextField getPwd() {
		if (pwd == null) {
			pwd = new JTextField();
			pwd.setBounds(67, 66, 109, 21);
			pwd.setColumns(10);
		}
		return pwd;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(67, 103, 109, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setBounds(67, 140, 109, 21);
			phone.setColumns(10);
		}
		return phone;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 11));
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\\uC800\uC7A511.png"));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					input();
				}
			});
			btnNewButton.setBounds(188, 59, 100, 70);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 14));
			status.setForeground(new Color(70, 130, 180));
			status.setOpaque(true);
			status.setBackground(new Color(255, 255, 255));
			status.setBounds(12, 220, 276, 29);
		}
		return status;
	}
}
