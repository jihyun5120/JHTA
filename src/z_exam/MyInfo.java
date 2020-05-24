package z_exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class MyInfo extends JFrame implements ActionListener{//ActionListener�� interface�� class�� Ÿ���� �޶� implements���.

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnABC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					MyInfo frame = new MyInfo();
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public MyInfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getBtnNewButton(), BorderLayout.CENTER);
		contentPane.add(getBtnABC(), BorderLayout.NORTH);
	}
	
	public void job() { //�޼ҵ� ��ȯ�� �տ� synchronized�� ���̸� �޼ҵ尡 ����ȭ�޼ҵ尡 ��.
		//A() //����ȭ����X
		synchronized(this) {
			//B(��ȣǥ..) //����ȭ O
		}
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("123");
			
			btnNewButton.addActionListener(this); //MyClass�� JFrame��, ActionListener�� �Ǳ� ������ this���.
		}
		return btnNewButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			try {
				SubThread st = new SubThread();
				Thread t = new Thread(st);
				t.setDaemon(true); //setDeamon(true);�� ���� ������ �ֽ����尡 ����Ǿ �ν����尡 ����X.
				t.start(); 
			} catch(Exception ex) {}
	}
	
	private JButton getBtnABC() {
		if (btnABC == null) {
			btnABC = new JButton("abc");
			btnABC.addActionListener(this);
		}
		return btnABC;
	}
}


















