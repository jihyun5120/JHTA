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
import java.awt.Font;
import java.awt.Rectangle;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ServerFrame extends JFrame implements Runnable{
	
	ServerSocket server;
	
	HTMLEditorKit kit = new HTMLEditorKit();
	HTMLDocument doc = new HTMLDocument();
	
	List<ServerThread> clients = new ArrayList<ServerThread>(); //
	
	DefaultListModel<String> model = new DefaultListModel<String>(); //접속자 목록
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField port;
	private JButton stBtn;
	private JButton eBtn;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_1;
	private JTextPane textPane;
	public JButton gBtn;
	private JButton xBtn;
	private JComboBox comboBox;
	private JTextField message;
	private JButton sBtn;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame();
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
	public ServerFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				serverStop();
			}
		});
		
		setTitle("\uCC44\uD305\uC11C\uBC84");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPort());
		contentPane.add(getStBtn());
		contentPane.add(getEBtn());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getGBtn());
		contentPane.add(getXBtn());
		contentPane.add(getComboBox());
		contentPane.add(getMessage());
		contentPane.add(getSBtn());
	}
	
	@Override
	public void run() {
		try {
			int p = Integer.parseInt(port.getText());
			server = new ServerSocket(p);
			
			String html = "<font size = '3' color = '#696969'>서버가 시작됨</font>"; //#ffGGBB : RR레드 GG그린 BB블루, 00~55 농도, ff가장진한. 
			kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);
			
			while(true) {
				html = "[클라이언트 접속 대기중]";
				kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);
				
				
				Socket clientSorcket = server.accept(); //서버에 연결
				ServerThread st = new ServerThread(ServerFrame.this, clientSorcket);
				st.start();
				clients.add(st);
				
				InetSocketAddress addr = (InetSocketAddress)clientSorcket.getRemoteSocketAddress();
				
				html = "<div style = 'border:2px solid #4B0082;padding:5px;width:130px'>" + addr.getAddress().getHostAddress() + "님이 접속함"
					 + "</div>"; //padding : 여백
				kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);
				
				getTextPane().scrollRectToVisible(new Rectangle(0, textPane.getHeight() + 100, 1, 1));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void send() { //enter, 전송이 눌려졌을 때.
		ChattData cd = new ChattData();
		cd.setmId("SERVER");
		cd.setCommand(ChattData.MESSAGE);
		cd.setMessage(message.getText());
		
		if(comboBox.getSelectedIndex()==0) { //전체
			sendAll(cd);			
		} else{ //귓속말
			int[] indexs = getList().getSelectedIndices();
			sendAll(cd, indexs);
		}
	}
	
	public void sendAll(ChattData cd) { //전체목록
		for(ServerThread st : clients) {
			try {
				st.oos.writeObject(cd);
				st.oos.flush();
			} catch (Exception e) {}
		}
	}
	
	public void sendAll(ChattData cd, int[] to) { //귓속말
		for(int i=0; i<to.length; i++) {
			ServerThread st = clients.get(to[i]);
			try {
				st.oos.writeObject(cd);
				st.oos.flush();				
			} catch (Exception ex){
			}
		}
	}
	
	//1. 모든 유저들에게 서버 종료 통보.
	//2. clients의 serverThread를 종료.
	//3. 접속자 목록을 모두 제거.
	//4. serverSocket 종료.
	public void serverStop() {
		ChattData cd = new ChattData();
		cd.setCommand(ChattData.GETOUT);
		cd.setmId("SERVER");
		sendAll(cd);
		
		clients.clear();
		clients = new ArrayList<ServerThread>();
		
		model.clear();
		
		try {
			server.close();
			server = null;
		} catch(Exception ex) {}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("IP");
			lblNewLabel.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 18));
			lblNewLabel.setBounds(12, 23, 27, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBackground(new Color(245, 245, 245));
			textField.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 12));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setBounds(33, 19, 105, 21);
			textField.setColumns(10);
			
			try {
				InetAddress local = InetAddress.getLocalHost();
				textField.setText(local.getHostAddress());
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return textField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Port");
			lblNewLabel_1.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(150, 23, 37, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getPort() {
		if (port == null) {
			port = new JTextField();
			port.setBackground(new Color(245, 245, 245));
			port.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 12));
			port.setHorizontalAlignment(SwingConstants.CENTER);
			port.setText("4444");
			port.setBounds(189, 19, 93, 21);
			port.setColumns(10);
		}
		return port;
	}
	private JButton getStBtn() {
		if (stBtn == null) {
			stBtn = new JButton("\uC2DC\uC791");
			stBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Thread t = new Thread(ServerFrame.this);
					t.start();
					stBtn.setEnabled(false);
					eBtn.setEnabled(true);
				}
			});
			stBtn.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			stBtn.setBounds(294, 18, 66, 23);
		}
		return stBtn;
	}
	private JButton getEBtn() {
		if (eBtn == null) {
			eBtn = new JButton("\uC885\uB8CC");
			eBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					serverStop();
					eBtn.setEnabled(false);
					stBtn.setEnabled(true);
				}
			});
			eBtn.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			eBtn.setBounds(366, 18, 66, 23);
		}
		return eBtn;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 55, 156, 233);
			scrollPane.setViewportView(getList());
			scrollPane.setColumnHeaderView(getLblNewLabel_2());
		}
		return scrollPane;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setBackground(new Color(245, 245, 245));
			list.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 12));
			list.setModel(model); //model --> 데이터 관리 위임.
		}
		return list;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC811\uC18D\uC790\uBAA9\uB85D");
			lblNewLabel_2.setOpaque(true);
			lblNewLabel_2.setBackground(new Color(153, 204, 204));
			lblNewLabel_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_2;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(176, 55, 256, 257);
			scrollPane_1.setViewportView(getTextPane());
			scrollPane_1.setColumnHeaderView(getLblNewLabel_3());
		}
		return scrollPane_1;
	}
	public JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setBackground(new Color(245, 245, 245));
			textPane.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 12));
			textPane.setContentType("text/html");
			textPane.setEditorKit(kit);
			textPane.setDocument(doc);
			
		}
		return textPane;
	}
	public JButton getGBtn() { //강퇴
		if (gBtn == null) {
			gBtn = new JButton("\uAC15\uD1F4");
			gBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Object[] indexs = getList().getSelectedValues();
					ChattData cd = new ChattData();
					cd.setCommand(ChattData.GETOUT);
					cd.setmId("SERVER");
					List<String> users = new ArrayList<String>();
					for(int i=0; i<indexs.length; i++) {
						users.add((String)indexs[i]);
					}
					cd.setUsers(users);
					sendAll(cd);
				}
			});
			gBtn.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			gBtn.setBounds(12, 292, 75, 23);
		}
		return gBtn;
	}
	private JButton getXBtn() { //해제
		if (xBtn == null) {
			xBtn = new JButton("\uD574\uC81C");
			xBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getList().clearSelection(); //선택되어있는 것을 해제시킴.
				}
			});
			xBtn.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			xBtn.setBounds(93, 291, 75, 23);
		}
		return xBtn;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			comboBox.setBounds(12, 320, 156, 21);
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
			message.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 12));
			message.setBounds(176, 319, 191, 21);
			message.setColumns(10);
		}
		return message;
	}
	private JButton getSBtn() {
		if (sBtn == null) {
			sBtn = new JButton("\uC804\uC1A1");
			sBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					send();
				}
			});
			sBtn.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			sBtn.setBounds(374, 318, 57, 23);
		}
		return sBtn;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uBA54\uC138\uC9C0");
			lblNewLabel_3.setOpaque(true);
			lblNewLabel_3.setBackground(new Color(153, 204, 204));
			lblNewLabel_3.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_3;
	}
}
