package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AccountCreate extends JPanel {
	private JLabel lblNewLabel;
	private JLabel label;
	private JTextField sno;
	private JLabel lblNewLabel_1;
	private JTextField mName;
	private JLabel lblNewLabel_2;
	private JTextField amount;
	private JButton btnNewButton;
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public AccountCreate() {
		setBackground(new Color(153, 153, 204));
		setLayout(null);
		add(getLblNewLabel());
		add(getLabel());
		add(getSno());
		add(getLblNewLabel_1());
		add(getMName());
		add(getLblNewLabel_2());
		add(getAmount());
		add(getBtnNewButton());
		add(getStatus());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uACC4\uC815 \uC0DD\uC131");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
			lblNewLabel.setBounds(12, 10, 265, 35);
		}
		return lblNewLabel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uACC4\uC88C\uBC88\uD638");
			label.setForeground(Color.WHITE);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			label.setBounds(12, 57, 57, 15);
		}
		return label;
	}
	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBounds(73, 55, 116, 21);
			sno.setColumns(10);
		}
		return sno;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC608\uAE08\uC8FC");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblNewLabel_1.setBounds(12, 82, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(73, 79, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC608\uAE08\uC561");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblNewLabel_2.setBounds(12, 107, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setBounds(73, 104, 116, 21);
			amount.setColumns(10);
		}
		return amount;
	}
	private JButton getBtnNewButton() { //'추가' 버튼
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCD94\uAC00");
			btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//모든 항목이 입력되었는가 체크
					if(!sno.getText().equals("") && !mName.getText().equals("") && !amount.getText().equals("")) {

						try {
							//계좌번호의 중복 여부 체크
							for(int i=0; i<Bank.count; i++) {
								Account1 a = Bank.ac[i];
								if(a.getsNo().equals(sno.getText())) {
									throw new IOException("계좌번호가 중복되었습니다."); //이 메세지를 만나면 for문 종료하고 catch로감(강제로 catch을 실행시켜라!)
								}
							}
							//예금액이 숫자로만 이루어졌는지 체크
							Long amt = Long.parseLong(amount.getText()); //amount는 long타입이기때문에 getText문자형을 Long.parseLong()을 이용해 다시 숫자형으로 바꿔줌.
							Account1 ac = new Account1(mName.getText(), sno.getText(), amt);
							Bank.ac[Bank.count] = ac;
							Bank.count++;
							
							status.setText(Bank.count + "번째 고객이 등록되었습니다.");
							mName.setText("");
							amount.setText("");
							sno.requestFocus();
							sno.selectAll();
						}catch(IOException ex2) {
							status.setText(ex2.getMessage());
							sno.requestFocus();
							sno.selectAll();
						}catch(Exception ex) {
							status.setText("예금액에 문자나 공백이 있습니다.");
							amount.requestFocus();
							amount.selectAll();
						}
						
					}else {
						status.setText("입력항목을 확인하세요.");
						sno.selectAll();
						sno.requestFocus();
					}
					
				}
			});
			btnNewButton.setBounds(83, 135, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(Color.WHITE);
			status.setBounds(12, 172, 265, 21);
		}
		return status;
	}
}
