/* - JFrame
 * BankApp.java (���� ������)
 * Bank.java (����) - �����ڿ�
 * - JPanel
 * AccountCreate.java (���� ����)
 * AccountList.java (���� ���)
 * AccountModify.java (���� ����)
 * Deposit.java (����)
 * Withdraw.java (���)
 * 
 * [ �����䱸���� ]
 * AccountModify
 *  - �����ֳ� ���ݾ��� �� �����̸� ���� �޼������
 *  - ���ݾ��� ���ڳ� ������ �ִ� ��� ���� �޼��� ���
 *  Deposit
 *  - ���������� ������ �޼��� ���
 *  - ���ݾ׿� ���ڳ� ������ �ִ� ��� ���� �޼��� ���
 *  Withdraw
 *  - ���� ������ ������ �޼��� ���
 *  - ���ݾ׿� ���ڳ� ������ ������ ���� �޼��� ���
 *  - ��ݾ��� ���ݾ׺��� ������ ���� �޼��� ���
 */
package f_inheri;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class BankApp extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankApp frame = new BankApp();
					frame.setVisible(true); //true�� ȭ�鿡 ���.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BankApp() {
		setForeground(new Color(153, 153, 204));
		setBackground(new Color(147, 112, 219));
		setTitle("\uC740\uD589\uAD00\uB9AC(Ver 0.9)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 352);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 204));
		contentPane.setForeground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setFont(new Font("���� ���", Font.BOLD, 12));
			menuBar.setForeground(Color.WHITE);
			menuBar.setBackground(Color.WHITE);
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uACC4\uC88C");
			mnNewMenu.setBackground(Color.WHITE);
			mnNewMenu.setForeground(Color.BLACK);
			mnNewMenu.setFont(new Font("���� ���", Font.PLAIN, 14));
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_2());
		}
		return mnNewMenu;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("\uC785\uCD9C\uAE08");
			mnNewMenu_1.setForeground(Color.BLACK);
			mnNewMenu_1.setFont(new Font("���� ���", Font.PLAIN, 14));
			mnNewMenu_1.add(getMntmNewMenuItem_3());
			mnNewMenu_1.add(getMntmNewMenuItem_4());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uACC4\uC815\uC0DD\uC131");
			mntmNewMenuItem.setFont(new Font("���� ���", Font.PLAIN, 12));
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					AccountCreate ac = new AccountCreate();
					contentPane.add(ac);
					contentPane.updateUI();
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uACC4\uC815\uBAA9\uB85D");
			mntmNewMenuItem_1.setFont(new Font("���� ���", Font.PLAIN, 12));
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					AccountList al = new AccountList();
					contentPane.add(al);
					contentPane.updateUI();
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uACC4\uC815\uC218\uC815");
			mntmNewMenuItem_2.setFont(new Font("���� ���", Font.PLAIN, 12));
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					AccountModify am = new AccountModify();
					contentPane.add(am);
					contentPane.updateUI();
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	private JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("\uC785\uAE08");
			mntmNewMenuItem_3.setFont(new Font("���� ���", Font.PLAIN, 12));
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					Deposit d = new Deposit();
					contentPane.add(d);
					contentPane.updateUI();
				}
			});
		}
		return mntmNewMenuItem_3;
	}
	private JMenuItem getMntmNewMenuItem_4() {
		if (mntmNewMenuItem_4 == null) {
			mntmNewMenuItem_4 = new JMenuItem("\uCD9C\uAE08");
			mntmNewMenuItem_4.setFont(new Font("���� ���", Font.PLAIN, 12));
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					Withdraw w = new Withdraw();
					contentPane.add(w);
					contentPane.updateUI();
				}
			});
		}
		return mntmNewMenuItem_4;
	}
}
