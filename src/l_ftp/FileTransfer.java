package l_ftp;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.text.DecimalFormat;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FileTransfer extends JPanel implements Runnable{
	long fileSize;
	String ip;
	int port; //파일 전송을 하기 위한 포트
	
	Socket socket;
	OutputStream os;
	FileInputStream fis;
	
	private JLabel fileName;
	private JProgressBar progressBar;
	private JLabel status;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public FileTransfer() {
		setPreferredSize(new Dimension(450, 60));
		setLayout(null);
		add(getFileName());
		add(getProgressBar());
		add(getStatus());
		add(getBtnNewButton());
	}
	
	public FileTransfer(String file) {
		this();
		getFileName().setText(file);
		File f = new File(file);
		fileSize = f.length();
		DecimalFormat df = new DecimalFormat("#,###.##");
		getStatus().setText("0/" + df.format((double)fileSize/1000)); //kb크기로 표시되도록.
	}
	
	@Override
	public void run() {
		//지정된 파일을 FileInputStream으로 읽어서.
		//Socket의 DataOutputStream으로 전송.
		byte[] readData = new byte[4096]; //한번에 4kb정도만 읽자!
		int readSize = 0;
		long readTotSize = 0;
		getProgressBar().setValue(0);
		try {
			socket = new Socket(ip, port);
			os = socket.getOutputStream();
			
			fis = new FileInputStream(getFileName().getText());
			while((readSize = fis.read(readData)) != -1) {
				readTotSize += readSize;
				getStatus().setText(readTotSize + "/" + fileSize);
				getProgressBar().setValue((int)((double)readTotSize/fileSize*100));
				os.write(readData, 0, readSize);
			}
			os.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public JLabel getFileName() {
		if (fileName == null) {
			fileName = new JLabel("\uD30C\uC77C\uBA85");
			fileName.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			fileName.setBounds(12, 6, 400, 15);
		}
		return fileName;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setForeground(new Color(255, 127, 80));
			progressBar.setBounds(12, 24, 400, 14);
		}
		return progressBar;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uD30C\uC77C \uC804\uC1A1\uC0C1\uD0DC");
			status.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			status.setHorizontalAlignment(SwingConstants.RIGHT);
			status.setBounds(12, 41, 426, 15);
		}
		return status;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						fis.close();
						os.close();
						socket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnNewButton.setOpaque(false);
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\\uC0ADd\uC81C.png"));
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setMargin(new Insets(0, 0, 2, 0));
			btnNewButton.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 11));
			btnNewButton.setBounds(419, 6, 28, 33);
		}
		return btnNewButton;
	}

}
