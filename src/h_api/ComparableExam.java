/* [과제]
 * 1. 숫자정렬  
 *  (1) 입력된 문자열을 정수형 배열로 split.
 *  (2) 오름차 정렬한 값을 textArea에 출력.
 * 2. 문자정렬
 *  (1) 입력된 문자열을 split.
 *  (2) 내림차 정렬한 값을 textArea에 출력.
 * 3. 객체정렬
 *  (1) 입력된 문자열을 숫자로 split하여 Score클래스의 kor필드에 대입하시오.
 *  (2) Score클래스는 Comparable을 구현함.
 *  (3) kor순으로 정렬된 결과를 textArea에 출력.  
 */
package h_api;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ComparableExam extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComparableExam frame = new ComparableExam();
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
	public ComparableExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 222, 173));
			panel.setPreferredSize(new Dimension(10, 80));
			panel.setLayout(null);
			panel.add(getTextField());
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
			panel.add(getBtnNewButton_2());
		}
		return panel;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(12, 10, 400, 21);
			textField.setColumns(10);
		}
		return textField;
	}

	// 1번 숫자정렬
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC22B\uC790\uC815\uB82C");
			btnNewButton.setFont(new Font("나눔스퀘어 Bold", Font.BOLD, 12));
			btnNewButton.setBackground(new Color(255, 239, 213));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] str = textField.getText().split(",");
					int[] s = new int[str.length];
					for (int i = 0; i < s.length; i++) {
						s[i] = Integer.parseInt(str[i]);
					}
					Arrays.sort(s);

					String text = "";
					for (int i = 0; i < str.length; i++) {
						text += s[i] + "\n";
						textArea.setText(text);
					}
				}
			});
			btnNewButton.setBounds(22, 41, 97, 29);
		}
		return btnNewButton;
	}

	// 2번 문자정렬
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uBB38\uC790\uC815\uB82C");
			btnNewButton_1.setFont(new Font("나눔스퀘어 Bold", Font.BOLD, 12));
			btnNewButton_1.setBackground(new Color(255, 239, 213));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] str = textField.getText().split(",");

					Arrays.sort(str, Collections.reverseOrder());
					String text = "";
					for (int i = 0; i < str.length; i++) {
						text += str[i] + "\n";
						textArea.setText(text);
					}

				}
			});
			btnNewButton_1.setBounds(164, 41, 97, 29);
		}
		return btnNewButton_1;
	}

	// 3번 객체정렬
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uAC1D\uCCB4\uC815\uB82C");
			btnNewButton_2.setFont(new Font("나눔스퀘어 Bold", Font.BOLD, 12));
			btnNewButton_2.setBackground(new Color(255, 239, 213));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] str = textField.getText().split(",");
					int[] s = new int[str.length];
					Score[] score = new Score[s.length];
					for (int i = 0; i < s.length; i++) {
						s[i] = Integer.parseInt(str[i]);
						Score sc1 = new Score(s[i]);
						score[i] = sc1;
					}
					Arrays.sort(score);

					String text = "";
					for (int i = 0; i < score.length; i++) {
						text += score[i].kor + "\n";
					}
					textArea.setText(text);
				}
			});
			btnNewButton_2.setBounds(303, 41, 97, 29);
		}
		return btnNewButton_2;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBackground(new Color(255, 239, 213));
		}
		return textArea;
	}
}
