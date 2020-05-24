package h_api;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class SortByScore extends JPanel {
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private JLabel lblNewLabel_1;
	public JLabel status;

	/**
	 * Create the panel.
	 */
	
	public SortByScore(JLabel status) {
		this();
		this.status = status;
		ScoreList();
	}
	
	public SortByScore() {
		setLayout(null);
		add(getLblNewLabel());
		add(getTextArea());
		add(getLblNewLabel_1());
		ScoreList();
	}
	
	public void ScoreList() {
		for(int i=0; i<StudentApp.count; i++) {
			textArea.append(StudentApp.st[i] + "\n");
	    }
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC21C \uC815\uB82C");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 20));
			lblNewLabel.setBounds(12, 18, 281, 29);
		}
		return lblNewLabel;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(12, 76, 281, 240);
		}
		return textArea;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD559\uBC88             \uC774\uB984               \uC131\uC801");
			lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 13));
			lblNewLabel_1.setBounds(12, 57, 281, 21);
		}
		return lblNewLabel_1;
	}
}
