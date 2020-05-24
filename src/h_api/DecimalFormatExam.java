package h_api;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

public class DecimalFormatExam extends JInternalFrame {
	private JLabel lblNewLabel;
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
					DecimalFormatExam frame = new DecimalFormatExam();
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
	public DecimalFormatExam() {
		super("DecimalFormat", false, true, true, true); //Ã¢ÀÌ¸§, Ã¢Å©±âº¯°æ, Ã¢´Ý±âÅ°, Ã¢ÀüÃ¼È­¸éÅ°, Ã¢³»¸®±âÅ°
		getContentPane().setBackground(new Color(255, 255, 240));
		
		setTitle("DecimalFormat");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getScrollPane());
		
		setVisible(true);

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC785\uAE08\uC561");
			lblNewLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.BOLD, 14));
			lblNewLabel.setBounds(39, 27, 51, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(85, 21, 290, 23);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCC9C\uB2E8\uC704");
			btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			btnNewButton.setBackground(new Color(255, 250, 250));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					long v = Long.parseLong(textField.getText());
					DecimalFormat df = new DecimalFormat("00,000,000,000.00");
					String r = df.format(v);
					
					textArea.append(r + "\n");
				}
			});
			btnNewButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 12));
			btnNewButton.setBounds(29, 54, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC18C\uC218\uC810\uD45C\uC2DC");
			btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			btnNewButton_1.setBackground(new Color(255, 250, 250));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double v = Double.parseDouble(textField.getText());
					DecimalFormat df = new DecimalFormat("##,###,###,###.##");
					
					textArea.append(df.format(v) + "\n");
				}
			});
			btnNewButton_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 12));
			btnNewButton_1.setBounds(160, 54, 97, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC6D0\uD654\uD45C\uC2DC");
			btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			btnNewButton_2.setBackground(new Color(255, 250, 250));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double v = Double.parseDouble(textField.getText());
					DecimalFormat df = new DecimalFormat("\u00a4 #,###,##");
					
					textArea.append(df.format(v) + "\n");
				}
			});
			btnNewButton_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 12));
			btnNewButton_2.setBounds(296, 54, 97, 23);
		}
		return btnNewButton_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(29, 87, 364, 161);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 14));
		}
		return textArea;
	}
}
