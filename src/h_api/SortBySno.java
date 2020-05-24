package h_api;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Objects;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class SortBySno extends JPanel {
	ButtonGroup group = new ButtonGroup();
	
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private JLabel lblNewLabel_1;
	private JRadioButton btn1;
	private JRadioButton btn2;

	/**
	 * Create the panel.
	 */
	public SortBySno() {
		setLayout(null);
		add(getLblNewLabel());
		add(getTextArea());
		add(getLblNewLabel_1());
		add(getBtn1());
		add(getBtn2());
	}
	
	public void asending() {
		textArea.setText("");
		Student temp = null;
		for (int i = 0; i < StudentApp.count - 1; i++) {
			for (int j = 1; j < StudentApp.count; j++) {
				Student s1 = StudentApp.st[i];
				Student s2 = StudentApp.st[j];
				int result = Objects.compare(s1, s2, new StudentComp('n'));
				if (result > 0) {
					temp = StudentApp.st[i];
					StudentApp.st[i] = StudentApp.st[j];
					StudentApp.st[j] = temp;
				}
			}
		}
		for (int i = 0; i < StudentApp.count; i++) {
			textArea.append(StudentApp.st[i] + "\n");
		}

	}

	public void desending() {?
		textArea.setText("");
		Student temp = null;
		for (int i = 0; i < StudentApp.count - 1; i++) {
			for (int j = 1; j < StudentApp.count; j++) {
				Student s1 = StudentApp.st[i];
				Student s2 = StudentApp.st[j];
				int result = Objects.compare(s1, s2, new StudentComp('n'));
				if (result < 0) {
					temp = StudentApp.st[i];
					StudentApp.st[i] = StudentApp.st[j];
					StudentApp.st[j] = temp;
				}
			}
		}
		for (int i = 0; i < StudentApp.count; i++) {
			textArea.append(StudentApp.st[i] + "\n");
		}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uBC88\uC21C \uC815\uB82C");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 20));
			lblNewLabel.setBounds(77, 22, 135, 24);
		}
		return lblNewLabel;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(12, 81, 279, 235);
		}
		return textArea;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD559\uBC88             \uC774\uB984               \uC131\uC801");
			lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 13));
			lblNewLabel_1.setBounds(12, 56, 279, 15);
		}
		return lblNewLabel_1;
	}
	private JRadioButton getBtn1() {
		if (btn1 == null) {
			btn1 = new JRadioButton("\uC624\uB984\uCC28\uC21C");
			btn1.setFont(new Font("±¼¸²", Font.PLAIN, 11));
			btn1.setBounds(0, 10, 69, 23);
			group.add(btn1);
			btn1.setSelected(true);
			 asending();
		}
		return btn1;
	}
	private JRadioButton getBtn2() {
		if (btn2 == null) {
			btn2 = new JRadioButton("\uB0B4\uB9BC\uCC28\uC21C");
			btn2.setFont(new Font("±¼¸²", Font.PLAIN, 11));
			btn2.setBounds(0, 27, 69, 23);
			group.add(btn2);
			desending();
		}
		return btn2;
	}
}
