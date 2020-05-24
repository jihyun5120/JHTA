package z_exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListEx extends JFrame {
	
	List<String> list = new ArrayList<String>();

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
					ListEx frame = new ListEx();
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
	public ListEx() {
		setTitle("ListEx");
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
				public void actionPerformed(ActionEvent e) { //입력
					
					String d = textField.getText();
					list.add(d);
					
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
				public void actionPerformed(ActionEvent e) { //삭제
					
					String d = textField.getText();
					for(int i=list.size()-1; i>=0; i--) { //삭제를 할 때는 루핑을 역행해야 함.(뒤부터 앞으로)
						String temp = list.get(i);
						if(d.equals(temp)) {
							list.remove(i);
						}
					} //hashcode와 equals를 재정의하면 꼭 루핑을 돌리지 않아도 됨.
					/*
					 * ex) public class Data{
					 * 			@Override
					 * 			public void hash() {}
					 * 			@Override
					 * 			public void equals(Object o){}
					 * 
					 * 		list.remove(new Data(d));
					 */
					
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
				public void actionPerformed(ActionEvent e) { //조회
					
					textArea.setText("");
					String find = textField.getText();
					int n = 0; //값 앞에 뜨는 행렬번호.
					for(int i=0; i< list.size(); i++) {
						String d = list.get(i);
						if(d.indexOf(find)>=0||find.equals("")) { //indexOf : ex) "ABC"에서 A를 찾으면 0, B를 찾으면 1, C를 찾으면 2가 나옴. 0보다크면 문자를 찾은 것.
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
				public void actionPerformed(ActionEvent e) { //수정
					
					String find = textField.getText();
					String repl = textField_1.getText();
					
					for(int i=0; i<list.size(); i++) {
						String d = list.get(i);
						if(d.equals(find)) {
							list.set(i, repl);
						}
					}
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
