package h_api;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreInput extends JPanel {
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField sno;
	private JTextField mName;
	private JTextField score;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public ScoreInput() {
		setLayout(null);
		add(getLabel());
		add(getLabel_1());
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getSno());
		add(getMName());
		add(getScore());
		add(getBtnNewButton());

	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC131\uC801\uC785\uB825");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("±¼¸²", Font.BOLD, 23));
			label.setBounds(27, 22, 243, 33);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uD559\uBC88");
			label_1.setFont(new Font("±¼¸²", Font.BOLD, 13));
			label_1.setBounds(37, 77, 57, 15);
		}
		return label_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC774\uB984");
			lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 13));
			lblNewLabel.setBounds(37, 111, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC131\uC801");
			lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 13));
			lblNewLabel_1.setBounds(37, 144, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBounds(83, 74, 116, 21);
			sno.setColumns(10);
		}
		return sno;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(83, 108, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JTextField getScore() {
		if (score == null) {
			score = new JTextField();
			score.setBounds(83, 141, 116, 21);
			score.setColumns(10);
		}
		return score;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCD94\uAC00");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Integer Sno = Integer.parseInt(sno.getText());
					Integer s = Integer.parseInt(score.getText());
					Student st = new Student(Sno, mName.getText(), s);
					Student.st[Student.count] = st;
					Student.count++;
					
				}
			});
			btnNewButton.setBounds(211, 89, 69, 59);
		}
		return btnNewButton;
	}
}
