package m_jdbc;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;

public class ScoreSelect extends JInternalFrame {
	private JLabel label;
	private JTextField textField;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreSelect frame = new ScoreSelect();
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
	public ScoreSelect() {
		super("ÇÐ»ý¼ºÀûÁ¶È¸", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 385, 371);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel());
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getScrollPane());
		getContentPane().add(getLabel_1());

	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uD559\uC0DD\uC131\uC801\uC870\uD68C");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("³ª´®°íµñ", Font.BOLD, 20));
			label.setBounds(0, 10, 369, 35);
		}
		return label;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(132, 55, 141, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC870\uD68C");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreDao dao = new ScoreDao();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					
					String find = textField.getText();
					List<ScoreVo> list = dao.select(find);
					
					textArea.setText("");
					for(ScoreVo vo : list) {
						textArea.append(vo.toString());
					}
					
				}
			});
			btnNewButton.setBounds(283, 55, 74, 23);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 93, 345, 239);
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
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setOpaque(true);
			label_1.setBackground(new Color(173, 216, 230));
			label_1.setBounds(0, 10, 369, 35);
		}
		return label_1;
	}
}
