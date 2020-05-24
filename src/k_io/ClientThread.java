package k_io;

import java.awt.Rectangle;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientThread extends Thread{
	ClientFrame frame;
	Socket socket;
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	public ClientThread(ClientFrame frame, Socket socket) {
		this.frame = frame;
		this.socket = socket;
	}
	
	
	@Override
	public void run() {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			frame.login();
			
			while(true) {
				ChattData cd = (ChattData)ois.readObject();
				String html = "";
				switch(cd.getCommand()){
				case ChattData.WHISPER : 	
				case ChattData.MESSAGE :
					if(cd.getmId().equals(frame.getTmId().getText())) {
						html = "<div style = 'border:1px solid #f0b4b4; background-color:#ffdfdf; padding:10px; width:150px; margin-left:100px;'>"
								+ cd.toString() + "</div>" + "</font>>" ;
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					} else {
						html = "<div style = 'border:1px solid #f0b4b4; background-color:#ffdfdf; padding:10px; width:150px; margin-left:0px;'>"
								+ cd.toString() + "</div>" + "</font>>" ;
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					}
					
					break;
				
				case ChattData.LOGIN :
					frame.textPane.setText("");
					for(int i=0; i<cd.getUsers().size(); i++) {
						String mId = cd.getUsers().get(i);
						frame.model.addElement(mId);
						//����� ���ŵ��� �ʴ� ���
						frame.getList().updateUI();
						frame.getList().paint(frame.getList().getGraphics()); //getlist�� ������ �ִ� �׷��Ƚ��� �����ͼ� �ڱ��ڽ����� ����Ʈ�� ��.
					}
					break;
					
					
				case ChattData.LOGOUT : 
				
					frame.model.removeElement(cd.getmId());
					frame.getList().updateUI();
					frame.getList().paint(frame.getList().getGraphics());
					break;
					
				case ChattData.GETOUT :
					//������ ���� or Ư�������� ����.
					if(cd.getUsers() == null) { //������ ����
						frame.model.clear(); 
						throw new Exception();//������ ������ ���� catch������ ������ ��.
					} else { //����
						for(String mId : cd.getUsers()) {
							if(mId.equals(frame.getTmId().getText())) {
								frame.model.clear();
								frame.textPane.setText("����Ǿ����ϴ�.");
								frame.eBtn.setEnabled(false);
								frame.stBtn.setEnabled(true);
								throw new Exception();
							} else {
								frame.model.removeElement(mId);
							}
						}
					}
				}
				frame.getTextPane().scrollRectToVisible(new Rectangle(0, frame.getTextPane().getHeight() + 100, 1, 1));
			}
		} catch(Exception ex) {
			try{
				ois.close();
				oos.close();
				socket.close();
				
				ois = null;
				oos = null;
				socket = null;
			} catch(Exception e) {}
		}
	}
	
}