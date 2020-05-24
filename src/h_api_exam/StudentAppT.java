package h_api_exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import h_api_exam.ScoreInputT;
import h_api_exam.SortByScoreT;
import h_api_exam.SortBySnoT;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class StudentAppT extends JFrame {

	static StudentT[] st = new StudentT[100];
	static int count;
	static {
		st[0] = new StudentT(1839, "��", 90);
		st[1] = new StudentT(3736, "��", 95);
		st[2] = new StudentT(3434, "��", 80);
		st[3] = new StudentT(9389, "ȫ", 88);
		count = 4;
	}
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem menuItem;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	
	JPanel panel; //�ؿ� status�� �� ������� ��� ���� �� �ְ� panel�̶�� ���� �ϳ� ����.
	private JLabel status;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAppT frame = new StudentAppT();
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
	public StudentAppT() {
		setTitle("\uC131\uC801\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 442);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getStatus(), BorderLayout.SOUTH);
		
		panel = new Main();
		contentPane.add(panel, BorderLayout.CENTER);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uC131\uC801\uAD00\uB9AC");
			mnNewMenu.add(getMntmNewMenuItem_2());
			mnNewMenu.add(getMenuItem());
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
		}
		return mnNewMenu;
	}
	private JMenuItem getMenuItem() {
		if (menuItem == null) {
			menuItem = new JMenuItem("\uC131\uC801\uC785\uB825");
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(panel != null) {
						contentPane.remove(panel);
					}
					panel = new ScoreInputT(status); //�߰���ư�� ������ �� Input�� �ִ� satus�޼����� ����ϱ� ����.
					contentPane.add(panel);
					contentPane.updateUI();
					status.setText("�й�, �л���, ������ �Է��ϼ���.");
				}
			});
		}
		return menuItem;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uD559\uBC88\uC21C \uC815\uB82C");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(panel != null) { // panel�� ������ ������ ������ �� �� �ֱ� ������.
						contentPane.remove(panel); //removeAll�� �� �������ϱ� �ش�panel�� �������� ����� �� �ְ�.
					}
					panel = new SortBySnoT(status);
					contentPane.add(panel);
					contentPane.updateUI();
					status.setText("�й������� ����Դϴ�.");
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uC131\uC801\uC21C \uC815\uB82C");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(panel != null) {
						contentPane.remove(panel);
					}
					panel = new SortByScoreT(status);
					contentPane.add(panel);
					contentPane.updateUI();
					status.setText("���������� ����Դϴ�.");
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uD648\uC774\uC608\uC694! \uBA54\uB274\uB97C \uC120\uD0DD\uD558\uC138\uC694.");
			status.setForeground(SystemColor.text);
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("����", Font.BOLD, 15));
			status.setOpaque(true);
			status.setBackground(SystemColor.activeCaption);
		}
		return status;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("Home");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(panel != null) {
						contentPane.remove(panel);
					}
					panel = new Main();
					contentPane.add(panel);
					contentPane.updateUI();
					status.setText("Ȩ�̿���! �޴��� �����ϼ���.");
				}
			});
		}
		return mntmNewMenuItem_2;
	}
}
