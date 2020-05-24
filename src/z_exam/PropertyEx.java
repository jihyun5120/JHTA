package z_exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.awt.event.ActionEvent;

public class PropertyEx extends JFrame {

	String fileName = "PropertyEx.properties";
	
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JTextArea txtrABabcd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropertyEx frame = new PropertyEx();
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
	public PropertyEx() {
		setTitle("PropertyEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getScrollPane());
	}

	private JButton getBtnNewButton() { //저장
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String[] data = txtrABabcd.getText().split("\n"); //getText에 있는 문자열을 \n를 기준으로 쪼개라
					Properties prop = new Properties();
					try{
						FileWriter fw = new FileWriter(fileName);
						for(String temp : data) {
							String[] d = temp.split("="); //\n로 나눠진 문자열을 date[]를 = 기준으로 나누어 d에 넣음.
							String key = new String(d[0].getBytes(), "utf-8");
							String value = new String(d[1].getBytes(), "utf-8");
							prop.setProperty(key, value);
						}
						prop.store(fw, "property test"); //저장은 store!
						
						fw.flush();
						fw.close();
					} catch(Exception ex) {}
				}
			});
			btnNewButton.setBounds(97, 10, 97, 34);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() { //읽기
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC77D\uAE30");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Properties prop = new Properties();
					txtrABabcd.setText("");
					try {
						FileReader fr = new FileReader(fileName);
						prop.load(fr); //읽기는 load!
						
						Set set = prop.keySet();
						for(Object o : set) {
							String key = (String)o;
							String value = prop.getProperty(key);
							
							key = new String(key.getBytes(), "utf-8");
						value = new String(value.getBytes(), "utf-8");
							
							txtrABabcd.append(key + " = " + value + "\n");
						}
						
					} catch(Exception ex) {}
					
				}
			});
			btnNewButton_1.setBounds(225, 10, 97, 34);
		}
		return btnNewButton_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 54, 410, 198);
			scrollPane.setViewportView(getTxtrABabcd());
		}
		return scrollPane;
	}
	private JTextArea getTxtrABabcd() {
		if (txtrABabcd == null) {
			txtrABabcd = new JTextArea();
		}
		return txtrABabcd;
	}
}
