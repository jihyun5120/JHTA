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

public class MyInfo extends JFrame implements ActionListener{//ActionListener가 interface라서 class와 타입이 달라 implements사용.

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
	
	public void job() { //메소드 반환형 앞에 synchronized를 붙이면 메소드가 동기화메소드가 됨.
		//A() //동기화되지X
		synchronized(this) {
			//B(번호표..) //동기화 O
		}
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("123");
			
			btnNewButton.addActionListener(this); //MyClass가 JFrame도, ActionListener도 되기 때문에 this사용.
		}
		return btnNewButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			try {
				SubThread st = new SubThread();
				Thread t = new Thread(st);
				t.setDaemon(true); //setDeamon(true);를 하지 않으면 주스레드가 종료되어도 부스레드가 종료X.
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


















