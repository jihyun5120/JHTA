/* [과제]
 *  StringExam.java(JFrame)
 * String 클래스의 length(), substring(), charAt()을 사용하여 아래의 내용을 해결하시오.
 * 1)JTextField를 사용하여 주민번호 입력.
 * 2)확인 버튼을 클릭하여 문자열의 길이, 생년월일, 성별을 구분하여 textArea에 출력.
 */
package h_api;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class StringExam extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField ssn;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StringExam frame = new StringExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StringExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getSsn());
		contentPane.add(getBtnNewButton());
		contentPane.add(getScrollPane());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 14));
			lblNewLabel.setBounds(12, 52, 65, 18);
		}
		return lblNewLabel;
	}
	private JTextField getSsn() {
		if (ssn == null) {
			ssn = new JTextField();
			ssn.setBounds(74, 52, 204, 21);
			ssn.setColumns(10);
		}
		return ssn;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uD655\uC778");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sn = "950621-2012345";
					String str = "";
					
					int length = sn.length();
					str += "문자열의 길이 : " + length;
					
//					String sn = sno.getText(); 
//					str += "문자열의 길이 : " + sn.length() + "\n";
					
					String fn = sn.substring(0,6);
					str += "\n생년월일 : " + fn;
					
//					str +="\n생년 : " + sn.substring0(0,2);
//					str +="\n생월 : " + sn.substring(2,4);
//					str +="\n생일 : " + sn.substring(4,6);
					
					char cv = sn.charAt(7);
					switch(cv) {
					case '1' :  case '3' :
						str += "\n성별 : 남자";
						break;
					case '2' : case '4' :
						str += "\n성별 : 여자";
						break;
						
//						str += "\n성별 :" + ((cv%2==0)? "여자" : "남자");
					}
					
					
					textArea.append(str);
				}
			});
			btnNewButton.setBounds(290, 51, 87, 23);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 80, 365, 159);
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
