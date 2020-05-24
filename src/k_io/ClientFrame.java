package k_io;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Font;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientFrame extends JFrame implements Runnable{ //is a 관계(상속관계) : 부모 자식관계
	//ClienFrame과 필드에 있는 것들은 has a 관계 : 특정 클래스 안에 가지고 있는 멤버들
	
	Socket socket;
	//출력스트림을 먼저 만든 후 입력스트림을 만들어야 오류가 없음.
	
	HTMLEditorKit kit = new HTMLEditorKit();
	HTMLDocument doc = new HTMLDocument(); 
	
	ClientThread ct;
	
	DefaultListModel<String> model = new DefaultListModel<String>();
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField serverIP;
	private JLabel lblNewLabel_1;
	private JTextField port;
	private JTextField tmId;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField tPwd;
	public JButton stBtn;
	public JButton eBtn;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane_1;
	public JTextPane textPane;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_2;
	private JComboBox comboBox;
	private JTextField message;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
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
	public ClientFrame() {
		setTitle("\uCC44\uD305 \uD074\uB77C\uC774\uC5B8\uD2B8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 449);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getServerIP());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPort());
		contentPane.add(getTmId());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getTPwd());
		contentPane.add(getStBtn());
		contentPane.add(getEBtn());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getComboBox());
		contentPane.add(getMessage());
		contentPane.add(getBtnNewButton_3());
	}
	
	@Override
	public void run() {
		try {
			String ip = serverIP.getText();
			int p = Integer.parseInt(port.getText()); 
			socket = new Socket(ip, p);
			 
			 ct = new ClientThread(ClientFrame.this, socket);
			 ct.start();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void login() throws Exception{
		String mid = tmId.getText();
		String pwd = tPwd.getText(); //현재 불필요
		String msg = "방가방가";
		int cmd = ChattData.LOGIN;
		
		ChattData cd = new ChattData(mid, cmd, msg);
		ct.oos.writeObject(cd);
		ct.oos.flush();
	}
	public void logout() {
	//1. 서버에게 로그아웃통보.
		ChattData cd = new ChattData();
		cd.setmId(tmId.getText());
		cd.setCommand(ChattData.LOGOUT);
		try {
			ct.oos.writeObject(cd);
			ct.oos.flush();
			
	//2. 자신의 유저목록을 모두 제거.
			model.clear();
			
	//3. ClientThread를 종료.
			ct.stop();
			socket.close();
			socket = null;
		} catch(Exception ex) {}
	}

	public void send() {
		try {
			String mid = tmId.getText();
			String msg = message.getText();
			int cmd = ChattData.MESSAGE;
			ChattData cd = new ChattData(mid, cmd, msg);
			
			if(comboBox.getSelectedIndex() == 1) { //귓속말
				Object[] obj = getList().getSelectedValues();
				List<String> users = new ArrayList<String>();
				for(Object str : obj) {
					users.add((String)str);
				}
				cd.setUsers(users);
				cd.setCommand(ChattData.WHISPER);
			}
			
			if(socket.isConnected()) { //socket이 연결되어있으면.
				ct.oos.writeObject(cd);
				ct.oos.flush();
				message.selectAll();
			}
		} catch (Exception ex) {
		}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Server");
			lblNewLabel.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 18));
			lblNewLabel.setBounds(15, 23, 66, 15);
		}
		return lblNewLabel;
	}
	private JTextField getServerIP() {
		if (serverIP == null) {
			serverIP = new JTextField();
			serverIP.setBackground(new Color(245, 245, 245));
			serverIP.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			serverIP.setHorizontalAlignment(SwingConstants.CENTER);
			serverIP.setBounds(59, 19, 116, 21);
			serverIP.setColumns(10);
			
			try {
				InetAddress local = InetAddress.getLocalHost();
				serverIP.setText(local.getHostAddress());
			} catch(Exception ex){
				
			}
		}
		return serverIP;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Port");
			lblNewLabel_1.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(187, 23, 36, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getPort() {
		if (port == null) {
			port = new JTextField();
			port.setBackground(new Color(245, 245, 245));
			port.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			port.setHorizontalAlignment(SwingConstants.CENTER);
			port.setText("4444");
			port.setBounds(222, 19, 116, 21);
			port.setColumns(10);
		}
		return port;
	}
	public JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setBackground(new Color(245, 245, 245));
			tmId.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			tmId.setHorizontalAlignment(SwingConstants.CENTER);
			tmId.setText("Choi");
			tmId.setBounds(35, 48, 106, 21);
			tmId.setColumns(10);
		}
		return tmId;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("ID");
			lblNewLabel_2.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 18));
			lblNewLabel_2.setBounds(15, 52, 25, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Password");
			lblNewLabel_3.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 18));
			lblNewLabel_3.setBounds(150, 52, 73, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getTPwd() {
		if (tPwd == null) {
			tPwd = new JTextField();
			tPwd.setBackground(new Color(245, 245, 245));
			tPwd.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			tPwd.setHorizontalAlignment(SwingConstants.CENTER);
			tPwd.setText("1234");
			tPwd.setBounds(210, 48, 116, 21);
			tPwd.setColumns(10);
		}
		return tPwd;
	}
	public JButton getStBtn() {
		if (stBtn == null) {
			stBtn = new JButton("\uC811\uC18D");
			stBtn.setBackground(new Color(255, 255, 255));
			stBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Thread t = new Thread(ClientFrame.this);
					t.start(); //Run메소드 실행.
					stBtn.setEnabled(false);
					eBtn.setEnabled(true);
				}
			});
			stBtn.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			stBtn.setBounds(347, 16, 66, 53);
		}
		return stBtn;
	}
	public JButton getEBtn() {
		if (eBtn == null) {
			eBtn = new JButton("\uD574\uC81C");
			eBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logout();
						eBtn.setEnabled(false);
						stBtn.setEnabled(true);
				}
			});
			eBtn.setBackground(new Color(255, 255, 255));
			eBtn.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			eBtn.setBounds(418, 16, 66, 53);
		}
		return eBtn;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(15, 88, 158, 252);
			scrollPane.setViewportView(getList());
			scrollPane.setColumnHeaderView(getLblNewLabel_4());
		}
		return scrollPane;
	}
	public JList getList() {
		if (list == null) {
			list = new JList();
			list.setBackground(new Color(245, 245, 245));
			list.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			
			list.setModel(model); //접속자 목록.
		}
		return list;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC811\uC18D\uC790\uBAA9\uB85D");
			lblNewLabel_4.setOpaque(true);
			lblNewLabel_4.setBackground(new Color(153, 204, 204));
			lblNewLabel_4.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_4;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(179, 88, 306, 279);
			scrollPane_1.setViewportView(getTextPane());
			scrollPane_1.setColumnHeaderView(getLblNewLabel_5());
		}
		return scrollPane_1;
	}
	public JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setContentType("text/html");//mime type.
			textPane.setBackground(new Color(245, 245, 245));
			textPane.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			
			textPane.setEditorKit(kit);
			textPane.setDocument(doc);
		}
		return textPane;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uBA54\uC138\uC9C0");
			lblNewLabel_5.setOpaque(true);
			lblNewLabel_5.setBackground(new Color(153, 204, 204));
			lblNewLabel_5.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_5;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uD574\uC81C");
			btnNewButton_2.setBackground(new Color(255, 255, 255));
			btnNewButton_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			btnNewButton_2.setBounds(15, 344, 158, 23);
		}
		return btnNewButton_2;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			comboBox.setBounds(15, 377, 158, 21);
			
			comboBox.addItem("전   체");
			comboBox.addItem("귓속말");
		}
		return comboBox;
	}
	private JTextField getMessage() {
		if (message == null) {
			message = new JTextField();
			message.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) { //엔터가 눌렸을 때.
						send();						
					}
				}
			});
			message.setBackground(new Color(245, 245, 245));
			message.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			message.setBounds(179, 377, 227, 21);
			message.setColumns(10);
		}
		return message;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("\uC804\uC1A1");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					send();
				}
			});
			btnNewButton_3.setBackground(new Color(255, 255, 255));
			btnNewButton_3.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			btnNewButton_3.setBounds(418, 377, 66, 23);
		}
		return btnNewButton_3;
	}
}
