package semishit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentM extends JInternalFrame implements Runnable {
	private JPanel panel;
	private JLabel insert;
	private JLabel update;
	private JLabel select;
	private JLabel delete;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel status;
	private JLabel runningman;
	int x = 323;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentM frame = new StudentM();
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
	public StudentM() {
		super("학생정보",false,true,true,true);
		setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
		getContentPane().setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
		getContentPane().setBackground(new Color(245, 245, 220));
		setPreferredSize(new Dimension(420, 300));
		setVisible(true);
		setBounds(100, 100, 768, 591);
		getContentPane().setLayout(null);
		getContentPane().add(getInsert());
		getContentPane().add(getUpdate());
		getContentPane().add(getSelect());
		getContentPane().add(getDelete());
		getContentPane().add(getPanel());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getStatus());
		status.setText(SemiMain.welcome+"님 화이팅!!");
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getRunningman());
		runningman.setBounds(x, 0, 130, 93);
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new LineBorder(Color.PINK, 3));
			panel.setBounds(119, 93, 631, 461);
			panel.setBackground(new Color(255, 255, 255));
			panel.setPreferredSize(new Dimension(500, 500));
			panel.setLayout(new BorderLayout(0, 0));
		}
		return panel;
	}
	private JLabel getInsert() {
		if (insert == null) {
			insert = new JLabel("");
			insert.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\edit.png"));
			insert.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					panel.removeAll();
					StudentInput si = new StudentInput();
					panel.add(si);
					panel.updateUI();
				}
			});
			insert.setBounds(26, 10, 49, 49);
		}
		return insert;
	}
	private JLabel getUpdate() {
		if (update == null) {
			update = new JLabel("");
			update.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					panel.removeAll();
					StudentUpdate su = new StudentUpdate();
					panel.add(su);
					panel.updateUI();
				}
			});
			update.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\writing.png"));
			update.setBounds(102, 10, 49, 49);
		}
		return update;
	}
	private JLabel getSelect() {
		if (select == null) {
			select = new JLabel("");
			select.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\file (1).png"));
			select.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					panel.removeAll();
					StudentSelect ss = new StudentSelect();
					panel.add(ss);
					panel.updateUI();
				}
			});
			select.setBounds(179, 10, 49, 49);
		}
		return select;
	}
	private JLabel getDelete() {
		if (delete == null) {
			delete = new JLabel("");
			delete.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					panel.removeAll();
					StudentDelete sd = new StudentDelete();
					panel.add(sd);
					panel.updateUI();
				}
			});
			delete.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\\uAC00\uBE44\uC9C0.png"));
			delete.setBounds(252, 10, 49, 49);
		}
		return delete;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uC0DD \uCD94\uAC00");
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel.setBounds(26, 63, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC815\uBCF4 \uC218\uC815");
			lblNewLabel_1.setForeground(new Color(0, 0, 0));
			lblNewLabel_1.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(99, 63, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uD559\uC0DD \uC870\uD68C");
			lblNewLabel_2.setForeground(new Color(0, 0, 0));
			lblNewLabel_2.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(180, 62, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uD559\uC0DD \uC0AD\uC81C");
			lblNewLabel_3.setForeground(new Color(0, 0, 0));
			lblNewLabel_3.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(254, 62, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("asdf");
			status.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			status.setBounds(12, 103, 95, 49);
		}
		return status;
	}
	private JLabel getRunningman() {
		if (runningman == null) {
			runningman = new JLabel("");
			runningman.setIcon(new ImageIcon("C:\\Users\\JHTA\\Documents\\pho\\\uB2EC\uB9B0\uB2E4.gif"));
			
		}
		return runningman;
	}

	@Override
	public void run() {
		
		try {
			while(true) {
				Thread.sleep(200);
				x+=100;
				if(x>1000) {
					x=323;
				}
				runningman.setBounds(x, 0, 130, 93);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					x+=100;
					runningman.setBounds(x, 0, 130, 93);
				}
			});
			btnNewButton.setBounds(12, 184, 97, 23);
		}
		return btnNewButton;
	}
}
