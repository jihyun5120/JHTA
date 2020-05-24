/* [����]
 *  StringExam.java(JFrame)
 * String Ŭ������ length(), substring(), charAt()�� ����Ͽ� �Ʒ��� ������ �ذ��Ͻÿ�.
 * 1)JTextField�� ����Ͽ� �ֹι�ȣ �Է�.
 * 2)Ȯ�� ��ư�� Ŭ���Ͽ� ���ڿ��� ����, �������, ������ �����Ͽ� textArea�� ���.
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
			lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
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
					str += "���ڿ��� ���� : " + length;
					
//					String sn = sno.getText(); 
//					str += "���ڿ��� ���� : " + sn.length() + "\n";
					
					String fn = sn.substring(0,6);
					str += "\n������� : " + fn;
					
//					str +="\n���� : " + sn.substring0(0,2);
//					str +="\n���� : " + sn.substring(2,4);
//					str +="\n���� : " + sn.substring(4,6);
					
					char cv = sn.charAt(7);
					switch(cv) {
					case '1' :  case '3' :
						str += "\n���� : ����";
						break;
					case '2' : case '4' :
						str += "\n���� : ����";
						break;
						
//						str += "\n���� :" + ((cv%2==0)? "����" : "����");
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
