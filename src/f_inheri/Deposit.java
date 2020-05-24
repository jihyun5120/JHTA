package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deposit extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField sno;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JTextField mName;
	private JLabel lblNewLabel_3;
	private JTextField amount;
	private JButton btnNewButton_1;
	private int pos;
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public Deposit() {
		setBackground(new Color(153, 153, 204));
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getSno());
		add(getLblNewLabel_2());
		add(getBtnNewButton());
		add(getMName());
		add(getLblNewLabel_3());
		add(getAmount());
		add(getBtnNewButton_1());
		add(getStatus());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC785\uAE08");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 23));
			lblNewLabel.setBounds(12, 10, 296, 33);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uACC4\uC88C\uBC88\uD638");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			lblNewLabel_1.setBounds(12, 55, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBounds(81, 53, 116, 21);
			sno.setColumns(10);
		}
		return sno;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC608\uAE08\uC8FC");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			lblNewLabel_2.setBounds(12, 86, 57, 15);
		}
		return lblNewLabel_2;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String find = sno.getText();
					pos = -1;

					for (int i = 0; i < Bank.count; i++) {
						Account1 a = Bank.ac[i];
						if (a.getsNo().equals(find)) {
							mName.setText(a.getmName());
							pos = i;
						} else {
							status.setText("°èÁÂÁ¤º¸°¡ ¾ø½À´Ï´Ù.");
							sno.requestFocus();
							sno.selectAll();
						}
					}

				}
			});
			btnNewButton.setBounds(209, 52, 70, 23);
		}
		return btnNewButton;
	}

	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setEditable(false);
			mName.setBounds(81, 84, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC608\uAE08\uC561");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			lblNewLabel_3.setBounds(12, 117, 57, 15);
		}
		return lblNewLabel_3;
	}

	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setBounds(81, 115, 116, 21);
			amount.setColumns(10);
		}
		return amount;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC785\uAE08\uCC98\uB9AC");
			btnNewButton_1.setBackground(Color.LIGHT_GRAY);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Long amt = Long.parseLong(amount.getText());
						if (pos >= 0) {
							Account1 a = Bank.ac[pos];
							Long temp = a.getAmount() + amt;
							a.setAmount(temp);
						}
					} catch (Exception ex) {
						status.setText("¿¹±Ý¾×¿¡ ¹®ÀÚ³ª °ø¹éÀÌ ÀÖ½À´Ï´Ù.");
						amount.requestFocus();
						amount.selectAll();
					}

				}
			});
			btnNewButton_1.setBounds(91, 146, 97, 23);
		}
		return btnNewButton_1;
	}

	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(Color.WHITE);
			status.setBounds(12, 183, 296, 21);
		}
		return status;
	}
}
