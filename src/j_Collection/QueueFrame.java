package j_Collection;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class QueueFrame extends JInternalFrame {
	Queue<Message> queue = new LinkedList<Message>(); //Queue는 인터페이스 타입이라서 new Queue로 만들 수 X.
	
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueueFrame frame = new QueueFrame();
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
	public QueueFrame() {
		super("Queue", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 347, 266);
		getContentPane().setLayout(null);
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getScrollPane());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getComboBox());
		getContentPane().add(getLblNewLabel_1());
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(36, 40, 154, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("offer");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					queue.offer(new Message(comboBox.getSelectedItem() + "", textField.getText()));
				}
			});
			btnNewButton.setBounds(167, 9, 65, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("poll");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText("");
					while(!queue.isEmpty()) {
						Message message = queue.poll();
						switch(message.command){
							case "Mail" :
								textArea.append(message.to + "님에게 메일을 보냅니다.");
								break;
							case "SMS" :
								textArea.append(message.to + "님에게 SMS를 보냅니다.");
								break;
							case "KakaoTalk" :
								textArea.append(message.to + "님에게 카카오톡을 보냅니다.");
								break;
						}
						textArea.append("\n");
					}
				}
			});
			btnNewButton_1.setBounds(202, 39, 73, 23);
		}
		return btnNewButton_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 71, 305, 154);
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
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Command");
			lblNewLabel.setBounds(12, 13, 65, 15);
		}
		return lblNewLabel;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
				comboBox.addItem("Mail");
				comboBox.addItem("SMS");
				comboBox.addItem("KakaoTalk");
			comboBox.setBounds(81, 10, 73, 21);
		}
		return comboBox;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("To");
			lblNewLabel_1.setBounds(12, 43, 57, 15);
		}
		return lblNewLabel_1;
	}
}
