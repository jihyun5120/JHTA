package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AccountList extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public AccountList() {
		setBackground(new Color(153, 153, 204));
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());
		showList();
	}
	
	public void showList() {
		String str = "";
		DecimalFormat df = new DecimalFormat("##,###,###,###.#"); //õ���� �з����ִ� Ŭ����(���ڷμ��� ����� ����ϰ� ���ڷμ��� ���)
		
		for(int i = 0; i<Bank.count; i++) {
			Account1 a = Bank.ac[i];
			str += a.getsNo();
			str += "\t" + a.getmName();
			str += "\t" + df.format(a.getAmount());
			str += "\n";
		}
		textArea.setText(str); //setText() : textArea�� ���� �ٽ� �ִ´�, addText() : �߰�.
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uACC4\uC815 \uBAA9\uB85D");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(new Color(147, 112, 219));
			lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 20));
			lblNewLabel.setBounds(12, 10, 307, 31);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 50, 307, 191);
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getLblNewLabel_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBackground(Color.WHITE);
		}
		return textArea;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uACC4\uC88C\uBC88\uD638           \uC608\uAE08\uC8FC                 \uC608\uAE08\uC794\uC561");
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setBackground(new Color(204, 204, 255));
			lblNewLabel_1.setFont(new Font("���� ���", Font.BOLD, 14));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setForeground(new Color(147, 112, 219));
		}
		return lblNewLabel_1;
	}
}
