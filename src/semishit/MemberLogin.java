package semishit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberLogin extends JPanel {
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField;
	private JButton button;
	private JPasswordField passwordField;
	private JSeparator separator;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Create the panel.
	 */
	public MemberLogin() {
		setBackground(new Color(255, 250, 250));
		setLayout(null);
		add(getLabel());
		add(getLabel_1());
		add(getLabel_2());
		add(getTextField());
		add(getButton());
		add(getPasswordField());
		add(getSeparator());
		add(getBtnNewButton());
		add(getBtnNewButton_1());
		add(getBtnNewButton_2());

	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uB85C\uADF8\uC778");
			label.setFont(new Font("나눔고딕", Font.BOLD, 30));
			label.setBounds(26, 10, 106, 34);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC544\uC774\uB514");
			label_1.setBounds(41, 71, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
			label_2.setBounds(41, 108, 57, 15);
		}
		return label_2;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(115, 68, 163, 21);
		}
		return textField;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("LOGIN");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					joinDao dao = new joinDao();
					String id = textField.getText();
					String pw =passwordField.getText();
					TestFrame tf = new TestFrame();
					
					
					int r = dao.login(id, pw);
					
					    if(r == -1) {
					    	
					    JOptionPane.showMessageDialog(MemberLogin.this, "로그인 실패!");
					    
					    	
					    }else if ( r == 0){
					 
					    			  
					    	  JOptionPane.showMessageDialog(MemberLogin.this, "로그인  성공");
					    	  
					    	   
					    	  
					    }else {
					    	
					    	
					    	   JOptionPane.showMessageDialog(MemberLogin.this, "아이디와 비밀번호가 일치하지 않습니다.!");
							    
					    }
					
					
					
					
					
					
				}
			});
			button.setBackground(new Color(230, 230, 250));
			button.setBounds(181, 154, 97, 23);
		}
		return button;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(115, 105, 163, 21);
		}
		return passwordField;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(0, 187, 438, 7);
		}
		return separator;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {//회원가입
          joinMem mm = new joinMem();
          mm.show();
				}
			});
			btnNewButton.setBounds(281, 154, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// 아이디 / 비밀번호 분실시.
					FindID mm = new FindID();
					mm.show();
				}
			});
			btnNewButton_1.setBounds(169, 204, 106, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_2.setBounds(281, 204, 120, 23);
		}
		return btnNewButton_2;
	}
}
