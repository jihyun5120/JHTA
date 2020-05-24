package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountModify extends JPanel {
	private JLabel lblNewLabel;
	private JTextField sno;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField mName;
	private JLabel lblNewLabel_2;
	private JTextField amount;
	private JButton button;

	private int pos; // 검색된 고객의 위치번호
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public AccountModify() {
		setBackground(new Color(153, 153, 204));
		setLayout(null);
		add(getLblNewLabel());
		add(getSno());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getMName());
		add(getLblNewLabel_2());
		add(getAmount());
		add(getButton());
		add(getStatus());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uACC4\uC88C \uC815\uBCF4 \uC218\uC815");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
			lblNewLabel.setBounds(12, 10, 306, 31);
		}
		return lblNewLabel;
	}

	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBounds(69, 56, 169, 21);
			sno.setColumns(10);
		}
		return sno;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String find = sno.getText();
					pos = -1; // 검색하기 전에 pos의 못 찾았다 값이 있어야함, pos의 값이 다시 검색하기 전 값으로 돌아가야함.
					for (int i = 0; i < Bank.count; i++) {
						Account1 a = Bank.ac[i];
						if (a.getsNo().equals(find)) {
							mName.setText(a.getmName());
							amount.setText(a.getAmount() + ""); //amount에 쓰여진 문자를 보는 거라서 ""를 넣어줌.
							pos = i;
							break;
						} else {
							status.setText("계좌 정보가 없습니다.");
							sno.requestFocus();
							sno.selectAll();
						}
					}
				}
			});
			btnNewButton.setBounds(250, 55, 68, 23);
		}
		return btnNewButton;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC608\uAE08\uC8FC");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblNewLabel_1.setBounds(12, 89, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(69, 87, 116, 21);
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
			lblNewLabel_2.setBounds(12, 116, 57, 15);
		}
		return lblNewLabel_2;
	}

	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setBounds(69, 114, 116, 21);
			amount.setColumns(10);
		}
		return amount;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uC218\uC815\uD655\uC778");
			button.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			button.setBackground(Color.LIGHT_GRAY);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (!mName.getText().equals("")) {
						try {
							if (pos >= 0) {
								Account1 a = Bank.ac[pos];
								Long amt = Long.parseLong(amount.getText());
								a.setmName(mName.getText());
								a.setAmount(amt);
							}
						} catch (Exception ex) {
							status.setText("예금액에 문자나 공백이 있습니다.");
							amount.requestFocus();
							amount.selectAll();
						}
					} else {
						status.setText("예금주에 공백이 있습니다.");
					}

				}
			});
			button.setBounds(79, 145, 97, 23);
		}
		return button;
	}

	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(Color.WHITE);
			status.setBounds(12, 187, 306, 24);
		}
		return status;
	}
}
