package h_api_exam;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Objects;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.SystemColor;

public class SortBySnoT extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JTextArea textArea;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	public JLabel status;

	/**
	 * Create the panel.
	 */
	public SortBySnoT(JLabel status) {
		this();
		this.status = status;
		SnoList();
	}
	public SortBySnoT() {
		setBackground(Color.PINK);
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());
		add(getChckbxNewCheckBox());
		add(getChckbxNewCheckBox_1());
	}
	
	
	public void SnoList() {
		textArea.setText(""); //기존에 표시된 내용을 모두 삭제.
		for(int i=0; i<StudentAppT.count; i++) {
			textArea.append(StudentAppT.st[i] + "\n");
		}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uBC88\uC21C \uC815\uB82C");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel.setBounds(77, 22, 135, 24);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 56, 281, 260);
			scrollPane.setColumnHeaderView(getLblNewLabel_2());
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uD559\uBC88             \uC774\uB984               \uC131\uC801");
			lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
			lblNewLabel_2.setOpaque(true);
			lblNewLabel_2.setBackground(SystemColor.inactiveCaption);
		}
		return lblNewLabel_2;
	}
	private JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}
	private JCheckBox getChckbxNewCheckBox() {
		if (chckbxNewCheckBox == null) {
			chckbxNewCheckBox = new JCheckBox("\uB0B4\uB9BC\uCC28\uC21C");
			chckbxNewCheckBox.setBackground(Color.PINK);
			chckbxNewCheckBox.setFont(new Font("굴림", Font.PLAIN, 11));
			chckbxNewCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentT temp = null;
					int result = 0;
					for(int i=0; i<StudentAppT.count-1; i++) {
						for(int j=i+1; j<StudentAppT.count; j++) {
							StudentT s1 = StudentAppT.st[i];
							StudentT s2 = StudentAppT.st[j];
							result = Objects.compare(s1, s2, new StudentCompT('n'));
							if(result<0) {
								temp = StudentAppT.st[i];
								 StudentAppT.st[i] =  StudentAppT.st[j];
								 StudentAppT.st[j] = temp;
							} //if of end
						} //for j of end
					} //for i of end
					textArea.setText(""); //기존에 표시된 내용을 모두 삭제.
					for(int i=0; i<StudentAppT.count; i++) {
						textArea.append(StudentAppT.st[i] + "\n");
					}
					status.setText("데이터가 내림차순으로 정렬되었습니다.");
				}
			});
			chckbxNewCheckBox.setBounds(8, 25, 73, 23);
		}
		return chckbxNewCheckBox;
	}
	private JCheckBox getChckbxNewCheckBox_1() {
		if (chckbxNewCheckBox_1 == null) {
			chckbxNewCheckBox_1 = new JCheckBox("\uC624\uB984\uCC28\uC21C");
			chckbxNewCheckBox_1.setBackground(Color.PINK);
			chckbxNewCheckBox_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentT temp = null;
					int result = 0;
					for(int i=0; i<StudentAppT.count-1; i++) {
						for(int j=i+1; j<StudentAppT.count; j++) {
							StudentT s1 = StudentAppT.st[i];
							StudentT s2 = StudentAppT.st[j];
							result = Objects.compare(s1, s2, new StudentCompT('n'));
							if(result>0) {
								temp = StudentAppT.st[i];
								 StudentAppT.st[i] =  StudentAppT.st[j];
								 StudentAppT.st[j] = temp;
							} //if of end
						} //for j of end
					} //for i of end
					textArea.setText(""); //기존에 표시된 내용을 모두 삭제.
					for(int i=0; i<StudentAppT.count; i++) {
						textArea.append(StudentAppT.st[i] + "\n");
					}
					status.setText("데이터가 오름차순으로 정렬되었습니다.");
				}
			});
			chckbxNewCheckBox_1.setFont(new Font("굴림", Font.PLAIN, 11));
			chckbxNewCheckBox_1.setBounds(8, 6, 73, 23);
		}
		return chckbxNewCheckBox_1;
	}
}
