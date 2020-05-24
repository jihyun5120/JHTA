package h_api_exam;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class ScoreInputT extends JPanel {
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField sno;
	private JTextField mName;
	private JTextField score;
	private JButton btnNewButton;
	public JLabel status;
	/**
	 * Create the panel.
	 */
	public ScoreInputT(JLabel status) {
		this(); //ScoreInput(){} 생성자 안에 있는 내용을 똑같이 쓰기 위해서 생성자 자신을 호출.
		this.status = status;
	}
	public ScoreInputT() {
		setBackground(Color.PINK);
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
			label.setFont(new Font("굴림", Font.BOLD, 23));
			label.setBounds(27, 22, 243, 33);
		}
		return label;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uD559\uBC88");
			label_1.setForeground(Color.WHITE);
			label_1.setBackground(Color.WHITE);
			label_1.setFont(new Font("굴림", Font.BOLD, 13));
			label_1.setBounds(37, 77, 33, 15);
		}
		return label_1;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uC0DD\uBA85");
			lblNewLabel.setForeground(SystemColor.text);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 13));
			lblNewLabel.setBounds(37, 111, 57, 15);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC131\uC801");
			lblNewLabel_1.setForeground(SystemColor.text);
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 13));
			lblNewLabel_1.setBounds(37, 144, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBackground(SystemColor.text);
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
			btnNewButton.setFont(new Font("굴림", Font.BOLD, 14));
			btnNewButton.setForeground(SystemColor.text);
			btnNewButton.setBackground(SystemColor.activeCaption);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if(StudentAppT.count<StudentAppT.st.length) {
						int Sno = Integer.parseInt(sno.getText());
						String irum = mName.getText();
						int s = Integer.parseInt(score.getText());
						
						StudentT st = new StudentT(Sno, irum, s);
						StudentAppT.st[StudentAppT.count] = st;
						StudentAppT.count++;
					
					status.setText(StudentAppT.count + "번째 성적이 추가되었습니다.");
					} else {
						status.setText("성적을 추가할 수 없습니다.");
					}
				}
			});
			btnNewButton.setBounds(211, 89, 69, 59);
		}
		return btnNewButton;
	}
}
