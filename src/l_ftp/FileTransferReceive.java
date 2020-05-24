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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FileTransferReceive extends JPanel implements Runnable{
	long fileSize;
	int port;
	
	FileOutputStream fos;
	Socket socket;
	InputStream is;
	
	private JLabel fileName;
	private JProgressBar progressBar;
	private JLabel status;
	private JButton btnX;

	/**
	 * Create the panel.
	 */
	public FileTransferReceive() {
		setPreferredSize(new Dimension(450, 60));
		setLayout(null);
		add(getFileName());
		add(getProgressBar());
		add(getStatus());
		add(getBtnX());
	}
	
	public FileTransferReceive(int port, String file, long fileSize) {
		this();
		this.port = port;
		this.fileSize = fileSize;
		
		getFileName().setText(file);
		DecimalFormat df = new DecimalFormat("#,##0.0");
		getStatus().setText("0/" + df.format((double)fileSize/1000)); //kbũ��� ǥ�õǵ���.
		
		try {
			Thread t = new Thread(this);
			t.start();
		} catch(Exception ex) {}
	}
	
	@Override
	public void run() {
		//������ ������ FileInputStream���� �о.
		//Socket�� DataOutputStream���� ����.
		byte[] readData = new byte[4096]; //�ѹ��� 4kb�� ����, ���۵Ǵ� ������� ���ŵǴ� ����� �����ϰ�.
		int readSize = 0;
		long readTotSize = 0;
		getProgressBar().setValue(0);
		try {
			ServerSocket ss = new ServerSocket(port);
			socket = ss.accept();
			File dir = new File("c:/Temp");
			if(!dir.exists()) {
				dir.mkdir();
			}
			
			fos = new FileOutputStream("c:/Temp/" + getFileName().getText()); //��� ������ c����̺� Temp�� ��.
			is = socket.getInputStream();
			while((readSize = is.read(readData)) != -1) {
				readTotSize += readSize;
				getStatus().setText(readTotSize + "/" + fileSize);
				getProgressBar().setValue((int)((double)readTotSize/fileSize*100));
				
				fos.write(readData,0, readSize); //������ �� ���� fos�� �����Ͱ� �� ����.
			}
			fos.flush();
			fos.close();
			is.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private JLabel getFileName() {
		if (fileName == null) {
			fileName = new JLabel("\uD30C\uC77C\uBA85");
			fileName.setFont(new Font("������������� Regular", Font.PLAIN, 12));
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
			status.setFont(new Font("������������� Regular", Font.PLAIN, 12));
			status.setHorizontalAlignment(SwingConstants.RIGHT);
			status.setBounds(12, 41, 426, 15);
		}
		return status;
	}
	private JButton getBtnX() {
		if (btnX == null) {
			btnX = new JButton("");
			btnX.setOpaque(false);
			btnX.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\\uC0ADd\uC81C.png"));
			btnX.setBackground(new Color(255, 255, 255));
			btnX.setMargin(new Insets(0, 0, 2, 0));
			btnX.setFont(new Font("������������� Regular", Font.PLAIN, 11));
			btnX.setBounds(419, 6, 28, 33);
		}
		return btnX;
	}

}
