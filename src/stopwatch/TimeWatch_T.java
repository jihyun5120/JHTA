package stopwatch;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimeWatch_T extends JFrame {

	private JPanel contentPane;
	private JLabel watch;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel labelTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeWatch_T frame = new TimeWatch_T();
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
	public TimeWatch_T() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getWatch());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPanel());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getLabelTime());
		
		DateTimeThread_T dft = new DateTimeThread_T(labelTime);
		dft.setDaemon(true);
		dft.start();
	}
	private JLabel getWatch() {
		if (watch == null) {
			watch = new JLabel("\uC2DC\uACC4");
			watch.setBounds(12, 10, 57, 15);
		}
		return watch;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC2A4\uD1B1\uC6CC\uCE58");
			lblNewLabel_1.setBounds(12, 122, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new StopwatchThread_T();
			panel.setBounds(12, 147, 410, 73);
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					StopwatchThread_T st = (StopwatchThread_T)panel;
					st.stop = false;
					Thread t = new Thread();
					t.setDaemon(true);
					t.start();
				}
			});
			btnNewButton.setBounds(60, 230, 97, 23);
			
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("New button");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StopwatchThread_T st = (StopwatchThread_T)panel;
					st.stop = true;
				}
			});
			btnNewButton_1.setBounds(259, 230, 97, 23);
		}
		return btnNewButton_1;
	}
	private JLabel getLabelTime() {
		if (labelTime == null) {
			labelTime = new JLabel("");
			labelTime.setBounds(12, 35, 410, 65);
		}
		return labelTime;
	}
}
