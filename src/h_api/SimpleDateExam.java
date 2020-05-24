package h_api;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class SimpleDateExam extends JInternalFrame {
	private JButton btnNewButton;
	private JLabel status;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleDateExam frame = new SimpleDateExam();
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
	public SimpleDateExam() {
		super("SuperDateFormat", false, true, true, true);
		getContentPane().setBackground(new Color(240, 248, 255));
		getContentPane().setLayout(null);
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getStatus());
		getContentPane().add(getLblNewLabel());
		setVisible(true);
		setBounds(100, 100, 450, 193);

	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC624\uB298 \uB0A0\uC9DC");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Date now = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E)¿äÀÏ hh:mm:ss");
					
					status.setText(sdf.format(now));
				}
			});
			btnNewButton.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 12));
			btnNewButton.setBackground(new Color(255, 250, 250));
			btnNewButton.setBounds(148, 10, 109, 34);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setForeground(new Color(105, 105, 105));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.PLAIN, 25));
			status.setBounds(120, 41, 302, 90);
		}
		return status;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\1.png"));
			lblNewLabel.setBounds(12, 41, 99, 90);
		}
		return lblNewLabel;
	}
}
