package m_jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import h_api.ScoreInput;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class MemberMain extends JFrame {

	private JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JLabel lblNewLabel;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_4;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMain frame = new MemberMain();
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
	public MemberMain() {
		setTitle("Main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 591);
		setJMenuBar(getMenuBar_1());
		contentPane = new JDesktopPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.add(getLblNewLabel());
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(new Color(244, 164, 96));
			menuBar.setForeground(Color.WHITE);
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
			menuBar.add(getMnNewMenu_2());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uD559\uC0DD\uC815\uBCF4");
			mnNewMenu.setBackground(new Color(255, 228, 181));
			mnNewMenu.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_2());
			mnNewMenu.add(getMntmNewMenuItem_3());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uC785\uB825");
			mntmNewMenuItem.setBackground(new Color(255, 228, 181));
			mntmNewMenuItem.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					MemberInsert panel = new MemberInsert();
					contentPane.add(panel);
					panel.toFront();
					
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uC218\uC815");
			mntmNewMenuItem_1.setBackground(new Color(255, 228, 181));
			mntmNewMenuItem_1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					MemberUpdate panel = new MemberUpdate();
					contentPane.add(panel);
					panel.toFront();
					
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uC870\uD68C");
			mntmNewMenuItem_2.setBackground(new Color(255, 228, 181));
			mntmNewMenuItem_2.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					MemberSelect panel = new MemberSelect();
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	private JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("\uC0AD\uC81C");
			mntmNewMenuItem_3.setBackground(new Color(255, 228, 181));
			mntmNewMenuItem_3.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					MemberDelete panel = new MemberDelete();
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_3;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\\uD559\uAD50.PNG"));
			lblNewLabel.setBounds(0, 0, 750, 532);
		}
		return lblNewLabel;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("Query");
			mnNewMenu_1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
			mnNewMenu_1.setBackground(new Color(255, 228, 181));
			mnNewMenu_1.add(getMntmNewMenuItem_4());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMntmNewMenuItem_4() {
		if (mntmNewMenuItem_4 == null) {
			mntmNewMenuItem_4 = new JMenuItem("SQL");
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Query panel = new Query();
					contentPane.add(panel);
					panel.toFront();
				}
			});
			mntmNewMenuItem_4.setBackground(new Color(255, 160, 122));
			mntmNewMenuItem_4.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
		}
		return mntmNewMenuItem_4;
	}
	private JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("\uC131\uC801\uAD00\uB9AC");
			mnNewMenu_2.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
			mnNewMenu_2.add(getMntmNewMenuItem_5());
			mnNewMenu_2.add(getMntmNewMenuItem_6());
			mnNewMenu_2.add(getMntmNewMenuItem_7());
			mnNewMenu_2.add(getMntmNewMenuItem_8());
		}
		return mnNewMenu_2;
	}
	private JMenuItem getMntmNewMenuItem_5() {
		if (mntmNewMenuItem_5 == null) {
			mntmNewMenuItem_5 = new JMenuItem("\uC785\uB825");
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ScoreInsert panel = new ScoreInsert();
					contentPane.add(panel);
					panel.toFront();
				}
			});
			mntmNewMenuItem_5.setBackground(new Color(255, 99, 71));
			mntmNewMenuItem_5.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
		}
		return mntmNewMenuItem_5;
	}
	private JMenuItem getMntmNewMenuItem_6() {
		if (mntmNewMenuItem_6 == null) {
			mntmNewMenuItem_6 = new JMenuItem("\uC218\uC815");
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ScoreUpdate panel = new ScoreUpdate();
					contentPane.add(panel);
					panel.toFront();
				}
			});
			mntmNewMenuItem_6.setBackground(new Color(255, 99, 71));
			mntmNewMenuItem_6.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
		}
		return mntmNewMenuItem_6;
	}
	private JMenuItem getMntmNewMenuItem_7() {
		if (mntmNewMenuItem_7 == null) {
			mntmNewMenuItem_7 = new JMenuItem("\uC870\uD68C");
			mntmNewMenuItem_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ScoreSelect panel = new ScoreSelect();
					contentPane.add(panel);
					panel.toFront();
				}
			});
			mntmNewMenuItem_7.setBackground(new Color(255, 99, 71));
			mntmNewMenuItem_7.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
		}
		return mntmNewMenuItem_7;
	}
	private JMenuItem getMntmNewMenuItem_8() {
		if (mntmNewMenuItem_8 == null) {
			mntmNewMenuItem_8 = new JMenuItem("\uC0AD\uC81C");
			mntmNewMenuItem_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ScoreDelete panel = new ScoreDelete();
					contentPane.add(panel);
					panel.toFront();
				}
			});
			mntmNewMenuItem_8.setBackground(new Color(255, 99, 71));
			mntmNewMenuItem_8.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
		}
		return mntmNewMenuItem_8;
	}
}
