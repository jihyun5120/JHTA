/* [Pattern 예제]
 * 1. 아이디 : 영숫자와 기호포함($, !, _) 4~10자
 * 2. 암  호 : 영숫자와 기호포함 4~10자
 * 3. 성  명 : 한글 2~20자까지 허용
 * 4. 연락처 : 사업자(2~3)-국번호(3~4)-전화번호(4)
 * 5. 이메일 : 영숫자@영문.영문(영문.영문)
 * 6. 우편번호 : (2)-(3) 
 */
package h_api;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class PatternExam2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField id;
	private JTextField pwd;
	private JTextField mName;
	private JTextField phone;
	private JTextField email;
	private JTextField zip;
	private JButton btnNewButton;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatternExam2 frame = new PatternExam2();
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
	public PatternExam2() {
		setTitle("\uD68C\uC6D0\uAC00\uC785(Pattern Check)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 308);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getId());
		contentPane.add(getPwd());
		contentPane.add(getMName());
		contentPane.add(getPhone());
		contentPane.add(getEmail());
		contentPane.add(getZip());
		contentPane.add(getBtnNewButton());
		contentPane.add(getStatus());
	}
	
	public void check() {
		String regexp = "";
		String value = "";
		status.setText("");
		
		//아이디
		regexp = "[\\w+!$_]{4,10}";
//		regexp = "([\\w+])(?=.*[!$_]).{3,9}"; // !$_ 기호 중에 한가지 기호를 반드시 포함시킬때.
		value = id.getText();
		if(!Pattern.matches(regexp, value)) {
			status.setText("아이디를 설정할 수 없습니다.");
			id.requestFocus();
			id.selectAll();
		} 
		//암호
		regexp = "[\\\\w+!$_]{4,10}";
		value = pwd.getText();
		if(!Pattern.matches(regexp, value)) {
			status.setText("암호를 설정할 수 없습니다.");
			pwd.requestFocus();
			pwd.selectAll();
		}
		//성명
		regexp = "[가-힣]{2,20}";
		value = mName.getText();
		if(!Pattern.matches(regexp, value)) {
			status.setText("성명이 올바르지않습니다.");
			mName.requestFocus();
			mName.selectAll();
		}
		
		//연락처
		regexp = "\\d{2,3}-\\d{3,4}-\\d{4}";
		value = phone.getText();
		if(!Pattern.matches(regexp, value)) {
			status.setText("연락처가 올바르지않습니다.");
			phone.requestFocus();
			phone.selectAll();
		}
		//이메일 체크
		regexp = "\\w+@+\\w+\\.\\w+(\\.\\w+)?";
		value = email.getText();
		if(!Pattern.matches(regexp, value)) {
			status.setText("이메일이 올바르지않습니다.");
			email.requestFocus();
			email.selectAll();
		}
//		
		//우편번호
		regexp = "\\d{2}-\\d{3}";
		value = zip.getText();
		if(!Pattern.matches(regexp, value)) {
			status.setText("우편번호가 올바르지않습니다.");
			zip.requestFocus();
			zip.selectAll();
		}
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 13));
			lblNewLabel.setBounds(12, 25, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC554   \uD638");
			lblNewLabel_1.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 13));
			lblNewLabel_1.setBounds(12, 50, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC131   \uBA85");
			lblNewLabel_2.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 13));
			lblNewLabel_2.setBounds(12, 75, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC5F0\uB77D\uCC98");
			lblNewLabel_3.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 13));
			lblNewLabel_3.setBounds(12, 100, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC774\uBA54\uC77C");
			lblNewLabel_4.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 13));
			lblNewLabel_4.setBounds(12, 125, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uC6B0\uD3B8\uBC88\uD638");
			lblNewLabel_5.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 13));
			lblNewLabel_5.setBounds(12, 150, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JTextField getId() {
		if (id == null) {
			id = new JTextField();
			id.setBounds(66, 22, 116, 21);
			id.setColumns(10);
		}
		return id;
	}
	private JTextField getPwd() {
		if (pwd == null) {
			pwd = new JTextField();
			pwd.setBounds(66, 47, 116, 21);
			pwd.setColumns(10);
		}
		return pwd;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(66, 72, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setBounds(66, 97, 116, 21);
			phone.setColumns(10);
		}
		return phone;
	}
	private JTextField getEmail() {
		if (email == null) {
			email = new JTextField();
			email.setBounds(66, 122, 174, 21);
			email.setColumns(10);
		}
		return email;
	}
	private JTextField getZip() {
		if (zip == null) {
			zip = new JTextField();
			zip.setBounds(66, 147, 116, 21);
			zip.setColumns(10);
		}
		return zip;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCCB4\uD06C");
			btnNewButton.setBackground(new Color(255, 228, 225));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check();
					
				}
			});
			btnNewButton.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 12));
			btnNewButton.setBounds(76, 178, 87, 23);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setForeground(new Color(105, 105, 105));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.BOLD, 14));
			status.setOpaque(true);
			status.setBackground(new Color(255, 240, 245));
			status.setBounds(12, 211, 280, 51);
		}
		return status;
	}
}
