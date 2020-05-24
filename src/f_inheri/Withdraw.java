package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Withdraw extends JPanel {
	private JLabel lblNewLabel;
	private JTextField sno;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField mName;
	private JLabel lblNewLabel_3;
	private JTextField amount;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_4;
	private JTextField wAmt;
	private int pos;
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public Withdraw() {
		setBackground(new Color(153, 153, 204));
		setLayout(null);
		add(getLblNewLabel());
		add(getSno());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getMName());
		add(getLblNewLabel_3());
		add(getAmount());
		add(getBtnNewButton_1());
		add(getLblNewLabel_4());
		add(getWAmt());
		add(getStatus());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uCD9C\uAE08");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
			lblNewLabel.setBounds(12, 14, 296, 24);
		}
		return lblNewLabel;
	}
	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBounds(81, 54, 116, 21);
			sno.setColumns(10);
		}
		return sno;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DecimalFormat df = new DecimalFormat("##,###,###,###.#");
					String find = sno.getText();
					pos = -1;
					for(int i=0; i<Bank.count; i++) {
						Account1 a = Bank.ac[i];
						
						if(a.getsNo().equals(find)) {
							mName.setText(a.getmName());
							amount.setText(df.format(a.getAmount()));
							pos = i;
						} else {
							status.setText("°èÁÂ Á¤º¸°¡ ¾ø½À´Ï´Ù.");
							sno.requestFocus();
							sno.selectAll();
						}
					}
				}
			});
			btnNewButton.setBounds(209, 53, 72, 23);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uACC4\uC88C\uBC88\uD638");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			lblNewLabel_1.setBounds(12, 56, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC608\uAE08\uC8FC");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			lblNewLabel_2.setBounds(12, 87, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setEditable(false);
			mName.setBounds(81, 85, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uD604 \uC794\uC561");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			lblNewLabel_3.setBounds(12, 118, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setEditable(false);
			amount.setBounds(81, 116, 116, 21);
			amount.setColumns(10);
		}
		return amount;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uCD9C\uAE08\uCC98\uB9AC");
			btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
			btnNewButton_1.setBackground(Color.LIGHT_GRAY);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Long amt = Long.parseLong(wAmt.getText());
						if(pos>=0) {
							Account1 a = Bank.ac[pos];
							if(a.getAmount()>=amt) {
								long temp = a.getAmount() - amt;
								a.setAmount(temp);								
							} else {
								status.setText("Ãâ±Ý¾×ÀÌ ¿¹±Ý¾×º¸´Ù ¸¹½À´Ï´Ù.");
								wAmt.requestFocus();
								wAmt.selectAll();
							}
						}
						
					} catch(Exception ex) {
						status.setText("¿¹±Ý¾×¿¡ ¹®ÀÚ³ª °ø¹éÀÌ ÀÖ½À´Ï´Ù.");
						wAmt.requestFocus();
						wAmt.selectAll();
					}
				}
			});
			btnNewButton_1.setBounds(91, 178, 97, 23);
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uCD9C\uAE08\uC561");
			lblNewLabel_4.setForeground(Color.WHITE);
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			lblNewLabel_4.setBounds(12, 149, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getWAmt() {
		if (wAmt == null) {
			wAmt = new JTextField();
			wAmt.setBounds(81, 147, 116, 21);
			wAmt.setColumns(10);
		}
		return wAmt;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(Color.WHITE);
			status.setBounds(12, 211, 296, 21);
		}
		return status;
	}
}
