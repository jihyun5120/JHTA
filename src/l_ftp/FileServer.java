package l_ftp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.MenuItem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FileServer extends JFrame implements Runnable{
	
	static int port = 6000; //6000~50000
	ServerSocket server;
	
	List<FileTransferReceive> files = new ArrayList<FileTransferReceive>(); //파일이 들어왔을 때. 
	boolean threadFlag = true; //accept할건지 말건지.
	

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JScrollPane scrollPane_1;
	private JPanel panel;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileServer frame = new FileServer();
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
	public FileServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 348);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.NORTH);
		contentPane.add(getScrollPane_1(), BorderLayout.CENTER);
	}

	@Override
	public void run() {
		threadFlag = true;
		try {
			server = new ServerSocket(5555);
			textArea.setText("서버가 시작되었습니다. \n");
		} catch (Exception e) {}
		
		while(threadFlag) { //서버중지를 하면 threadFlag를 false로 만들 것.
			try {
				Socket s = server.accept(); //블럭킹
				textArea.append("클라이언트가 접속되었습니다. \n");
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());//파일수신
				Data data = (Data)ois.readObject(); //Data타입으로 데이터를 받음.
				
				textArea.append("전송될 파일 정보가 수신되었습니다. \n");
				
				for(int i=0; i<data.fileName.size(); i++) {
					FileServer.port++;
					
					if(FileServer.port>50000) {
						FileServer.port = 6000;
					}

					FileTransferReceive st = new FileTransferReceive(FileServer.port, data.fileName.get(i), data.fileSize.get(i));
					files.add(st);
					panel.add(st);
					panel.updateUI();
					
					Data sendData = new Data();
					sendData.port = FileServer.port;
					oos.writeObject(sendData);
				}
				
				panel.removeAll();
//				panel.repaint();
				ois.close();
				oos.close();
			}catch(Exception ex) {}
		}
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
			mnNewMenu = new JMenu("\uC11C\uBC84");
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_2());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uC11C\uBC84\uC2DC\uC791");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					threadFlag = true;
					Thread t = new Thread(FileServer.this); //FileSrever자신이 Runnable.
					t.start();
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uC11C\uBC84\uC911\uC9C0");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					threadFlag = false;
					textArea.append("서버가 중지되었습니다. \n");
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uC885\uB8CC");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					try {
						server.close();
						panel.removeAll();
						textArea.append("서버가 종료되었습니다.");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(2, 120));
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setPreferredSize(new Dimension(460, 70));
			scrollPane_1.setViewportView(getPanel());
		}
		return scrollPane_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(460, 70));
		}
		return panel;
	}

}
