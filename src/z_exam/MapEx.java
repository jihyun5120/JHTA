package z_exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.awt.event.ActionEvent;

public class MapEx extends JFrame {
	
	Map<String, Integer> map = new HashMap <String, Integer>();

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapEx frame = new MapEx();
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
	public MapEx() {
		setTitle("MapEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTextField_1());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getBtnNewButton_3());
		contentPane.add(getBtnNewButton_4());
		contentPane.add(getBtnNewButton_5());
		contentPane.add(getBtnNewButton_6());
		contentPane.add(getScrollPane());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Key");
			lblNewLabel.setBounds(12, 13, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(51, 10, 116, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Value");
			lblNewLabel_1.setBounds(12, 49, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(51, 46, 116, 21);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Keys");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					textArea.setText("---keys---\n");
					
					Set<String> key = map.keySet();
					for(String k : key) {
						textArea.append(k + "\n");
					}
					
					//향상된 for문
//					 Set<String> key2 = map.keySet();
//					 for(String k : key2) {
//						 textArea.append(k + "\n");
//					 }
					
				}
			});
			btnNewButton.setBounds(257, 13, 83, 21);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Values");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					textArea.setText("---values---\n");
					
					Set<String> key = map.keySet();
					for(String k : key) {
						Integer v = map.get(k);
						textArea.append(v + "\n");
					}
					
					//향상된 for문
//					 Set<String> key2 = map.keySet();
//					 for(String k : key2) {
//						 Integer v = map.get(k);
//						 textArea.append(v + "\n");
//					 }
				}
			});
			btnNewButton_1.setBounds(257, 45, 83, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() { //입력
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC785\uB825");
			btnNewButton_2.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent arg0) {
					String key = textField.getText();
					int value = Integer.parseInt(textField_1.getText());
					map.put(key, value);
					
					textField.requestFocus();;
					textField.selectAll();
					textField_1.setText("");
				}
			});
			btnNewButton_2.setBounds(12, 74, 75, 23);
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() { //수정
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("\uC218\uC815");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String key = textField.getText();
					Integer value = Integer.parseInt(textField_1.getText());
					
					if(map.containsKey(key)) { //map에 해당키가 있다면.
						map.put(key, value);
					} else {
						JOptionPane.showMessageDialog(MapEx.this, "키값이 존재하지 않습니다."); //단순 메시지를 출력하는 창.
					}
					
				}
			});
			btnNewButton_3.setBounds(92, 74, 75, 23);
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("\uC0AD\uC81C");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String key = textField.getText();
					if(map.containsKey(key)) { //map에 해당키가 있다면.
						map.remove(key);
						textField_1.setText("");
						
					}else {
						JOptionPane.showMessageDialog(MapEx.this, "삭제가 키가 없습니다."); //단순 메시지를 출력하는 창.
					}
					textField.requestFocus();
					textField.selectAll();
					
				}
			});
			btnNewButton_4.setBounds(171, 74, 75, 23);
		}
		return btnNewButton_4;
	}
	private JButton getBtnNewButton_5() {
		if (btnNewButton_5 == null) {
			btnNewButton_5 = new JButton("\uC870\uD68C");
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					textArea.setText("");
					textField_1.setText("");
					
					String key = textField.getText();
					Integer value = map.get(key);
					if(value != null) {
						textField_1.setText(value + "\n");
					} else {
						JOptionPane.showMessageDialog(MapEx.this, "키 값이 없습니다."); //단순 메시지를 출력하는 창.
					}
					
				}
			});
			btnNewButton_5.setBounds(179, 13, 66, 51);
		}
		return btnNewButton_5;
	}
	private JButton getBtnNewButton_6() {
		if (btnNewButton_6 == null) {
			btnNewButton_6 = new JButton("Map.Entry");
			btnNewButton_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					textArea.setText("");
					Set<Map.Entry<String, Integer>> entry = map.entrySet();
					
					//how1
					textArea.append("---how1---\n");
					for(Map.Entry<String, Integer> m : entry) {
						textArea.append(m.getKey() +  " : " + m.getValue() + "\n");
					}
					
					//how2
					Iterator<Map.Entry<String, Integer>> iter = entry.iterator();
					textArea.append("---how2---\n");
					while(iter.hasNext()) {
						Map.Entry<String, Integer> m = iter.next();
						textArea.append(m.getKey() + " : " + m.getValue() + "\n");
					}
					
					
				}
			});
			btnNewButton_6.setBounds(250, 74, 90, 23);
		}
		return btnNewButton_6;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 108, 329, 144);
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
