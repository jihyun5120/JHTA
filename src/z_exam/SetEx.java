package z_exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetEx extends JFrame {
	
	Set<String> set = new HashSet<String>();

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JTextField textField_1;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetEx frame = new SetEx();
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
	public SetEx() {
		setTitle("SetEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextField());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getBtnNewButton_3());
		contentPane.add(getTextField_1());
		contentPane.add(getScrollPane());
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(12, 10, 116, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC785\uB825");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //�Է�
					
					String d = textField.getText();
					set.add(d);
					
					textField.requestFocus();
					textField.selectAll();
				}
			});
			btnNewButton.setBounds(140, 9, 70, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC0AD\uC81C");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //����
					
					String find = textField.getText();
					set.remove(find);
					
				}
			});
			btnNewButton_1.setBounds(222, 9, 70, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC870\uD68C");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //��ȸ
					
					textArea.setText("");
					String find = textField.getText();
					int n = 0; //�� �տ� �ߴ� ��Ĺ�ȣ.
					Iterator<String> iter = set.iterator();
					while(iter.hasNext()) {
						String d = iter.next();
						if(d.indexOf(find)>=0||find.equals("")) { //indexOf : ex) "ABC"���� A�� ã���� 0, B�� ã���� 1, C�� ã���� 2�� ����. 0����ũ�� ���ڸ� ã�� ��.
							n++;
							textArea.append((n) + " : " + d + "\n");	
						}
					}
					textField.requestFocus();
					textField.selectAll();
				}
			});
			btnNewButton_2.setBounds(140, 40, 70, 23);
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("\uC218\uC815");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //����
					
					String find = textField.getText();
					set.remove(find);
					set.add(textField_1.getText());
					
					textField.setText("");
					textField.requestFocus();
				}
			});
			btnNewButton_3.setBounds(222, 42, 70, 23);
		}
		return btnNewButton_3;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(12, 41, 116, 21);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 72, 280, 211);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
