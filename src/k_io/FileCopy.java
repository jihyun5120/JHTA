package k_io;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FileCopy extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField original;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField target;
	private JProgressBar progressBar;
	private JButton btnNewButton_2;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileCopy frame = new FileCopy();
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
	public FileCopy() {
		super("FileCopy", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 479, 188);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getOriginal());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getTarget());
		getContentPane().add(getProgressBar());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getStatus());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC6D0\uBCF8\uD30C\uC77C");
			lblNewLabel.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 13));
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uB300\uC0C1\uD30C\uC77C");
			lblNewLabel_1.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(12, 43, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getOriginal() {
		if (original == null) {
			original = new JTextField();
			original.setBounds(66, 7, 283, 21);
			original.setColumns(10);
		}
		return original;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCC3E\uC544\uBCF4\uAE30");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JFileChooser fc = new JFileChooser();
					int state = fc.showOpenDialog(FileCopy.this); //파일을 찾아열때 사용, (FileCopy.this) 상자가 프레임가운데 뜰 수 있게함.
					if(state == JFileChooser.APPROVE_OPTION) { //열기버튼이 클릭된 경우.
						original.setText(fc.getSelectedFile().getPath());
					}
				}
			});
			btnNewButton.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			btnNewButton.setBounds(361, 6, 89, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uB300\uC0C1\uD30C\uC77C");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					 
				}
			});
			btnNewButton_1.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			btnNewButton_1.setBounds(361, 39, 89, 23);
		}
		return btnNewButton_1;
	}
	private JTextField getTarget() {
		if (target == null) {
			target = new JTextField();
			target.setBounds(66, 40, 283, 21);
			target.setColumns(10);
		}
		return target;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setBackground(Color.WHITE);
			progressBar.setForeground(Color.ORANGE);
			progressBar.setBounds(12, 71, 438, 14);
		}
		return progressBar;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uBCF5\uC0AC\uD558\uAE30");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					FileCopyThread fct = new FileCopyThread(getProgressBar()); //ProgressBar로 해도 상관없음.
					fct.setOiginal(original.getText());
					fct.setTarget(target.getText());
					
					status.setText("복사 중입니다.");
					try {
						fct.join();
						fct.start();
					} catch(Exception ex) {}
					status.setText("복사가 완료되었습니다.");
					
				}
			});
			btnNewButton_2.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			btnNewButton_2.setBounds(188, 95, 81, 23);
		}
		return btnNewButton_2;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setBackground(Color.LIGHT_GRAY);
			status.setOpaque(true);
			status.setForeground(Color.BLACK);
			status.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 12));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setBounds(12, 128, 438, 21);
		}
		return status;
	}
}
