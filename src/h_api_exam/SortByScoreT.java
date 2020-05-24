package h_api_exam;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Objects;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.JRadioButton;

public class SortByScoreT extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JTextArea textArea;
	public JLabel status;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	
	

	/**
	 * Create the panel.
	 */
	public SortByScoreT(JLabel status) {
		this();
		this.status = status;
		ScoreList();
	}
	
	public SortByScoreT() {
		setBackground(Color.PINK);
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());
		add(getRdbtnNewRadioButton());
		add(getRdbtnNewRadioButton_1());
	}
	
	public void ScoreList() {
		for(int i=0; i<StudentAppT.count; i++) {
			textArea.append(StudentAppT.st[i] + "\n");
	    }
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC21C \uC815\uB82C");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel.setBounds(84, 18, 131, 29);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 57, 281, 259);
			scrollPane.setColumnHeaderView(getLblNewLabel_1());
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD559\uBC88             \uC774\uB984               \uC131\uC801");
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setBackground(SystemColor.inactiveCaption);
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		}
		return lblNewLabel_1;
	}
	private JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("\uC624\uB984\uCC28\uC21C");
			rdbtnNewRadioButton.setBackground(new Color(255, 153, 153));
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					StudentT temp = null;
					int result = 0;
					for(int i=0; i<StudentAppT.count-1; i++) {
						for(int j=i+1; j<StudentAppT.count; j++) {
							StudentT s1 = StudentAppT.st[i];
							StudentT s2 = StudentAppT.st[j];
							result = Objects.compare(s1, s2, new StudentCompT('s'));
							if(result>0) {
								temp = StudentAppT.st[i];
								StudentAppT.st[i] = StudentAppT.st[j];
								StudentAppT.st[j] = temp;
							}
						}
					}
					
					textArea.setText("");
					for(int i=0; i<StudentAppT.count; i++) {
						textArea.append(StudentAppT.st[i] + "\n");
				    }
					status.setText("데이터를 오름차순으로 정렬하였습니다.");
				}
			});
			rdbtnNewRadioButton.setBounds(217, 3, 88, 23);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("\uB0B4\uB9BC\uCC28\uC21C");
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentT temp = null;
					int result = 0;
					for(int i=0; i<StudentAppT.count-1; i++) {
						for(int j=i+1; j<StudentAppT.count; j++) {
							StudentT s1 = StudentAppT.st[i];
							StudentT s2 = StudentAppT.st[j];
							result = Objects.compare(s1, s2, new StudentCompT('s'));
							if(result<0) {
								temp = StudentAppT.st[i];
								StudentAppT.st[i] = StudentAppT.st[j];
								StudentAppT.st[j] = temp;
							}
						}
					}
					
					textArea.setText("");
					for(int i=0; i<StudentAppT.count; i++) {
						textArea.append(StudentAppT.st[i] + "\n");
				    }
					status.setText("데이터를 내림차순으로 정렬하였습니다.");
				}
			});
			rdbtnNewRadioButton_1.setBackground(new Color(255, 153, 153));
			rdbtnNewRadioButton_1.setBounds(217, 23, 88, 23);
		}
		return rdbtnNewRadioButton_1;
	}
}
