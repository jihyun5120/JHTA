package k_io;
import java.awt.Rectangle;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread{ //�����͸� �����ϴ� Ŭ����.
	String mId;
	ServerFrame frame;
	Socket socket;
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	public ServerThread(ServerFrame frame, Socket socket) {
		this.frame = frame;
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			while(true) {
				ChattData cd = (ChattData)ois.readObject(); //Object�� ChattDataŸ������ ������⶧����.
				String html = "";
				
				switch(cd.getCommand()) {
				case ChattData.LOGIN : 
					this.mId = cd.getmId(); //�ڽŰ� ����� Ŭ���̾�Ʈ�� mId�� ����.
					html = "<font color = '006400'>" + cd.getmId() + "���� �����Ͽ����ϴ�.</font>";	
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					
					//���� �ڽŰ� ����� oos���� ���� ������ ����� ����.
					ChattData cd2 = new ChattData(); //���ŵ� ��X ���Ӱ� ����.
					List<String> users = new ArrayList<String>();
					for(int i=0; i<frame.model.size(); i++) { //���̵� �ϳ��� ������.
						users.add(frame.model.get(i));
					}
					cd2.setCommand(ChattData.LOGIN);
					cd2.setUsers(users);
					oos.writeObject(cd2); //cd2�� �ڱ��ڽ��� ����.
					oos.flush();
					
					//�ڽ��� ���̵� model�� �߰�.
					frame.model.addElement(cd.getmId());
					
					//��� �����ڿ��� ���� �ڽ��� ���̵� ����.
					cd2 = new ChattData();
					cd2.setCommand(ChattData.LOGIN);
					users = new ArrayList<String>();
					
					users.add(cd.getmId());
					cd2.setUsers(users);
					sendAll(cd2); //cd2�� ��ο��� ����.
					break;
				
				case ChattData.MESSAGE : 				
						html = "<div style = 'border:1px solid #f0b4b4; padding:3px; background-color:#ffdfdf;'>" + cd.toString() + "</div>";
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					sendAll(cd);
					break;
			
				case ChattData.WHISPER : 
					int[] to = new int[cd.getUsers().size()];
					int index = 0;
					for(String str : cd.getUsers()) {
						for(int i=0; i<frame.clients.size(); i++) {
							ServerThread st = frame.clients.get(i);
							if(str.equals(st.mId)) {
								to[index] = i;
								index++;
							}
						}
					}
					frame.sendAll(cd, to);
					break;
				
				case ChattData.LOGOUT :
					throw new Exception(); //����ó���� �߻����� catch�� �귯�� �� �ְ���.
				}
				
				frame.getTextPane().scrollRectToVisible(new Rectangle(0, frame.getTextPane().getHeight() + 100, 1, 1));
			}
			
		} catch(Exception ex) {
			//�� �ڽ��� ������ ����.
			int index = frame.clients.indexOf(ServerThread.this);
			frame.model.remove(index);
			frame.clients.remove(index);
			
			//�ٸ� ��� �������� �ش����� �α׾ƿ��� ����� �뺸.
			ChattData cd = new ChattData();
			cd.setCommand(ChattData.LOGOUT);
			cd.setmId(this.mId);
			try {
				sendAll(cd);
			} catch(Exception e) {
			}
		}
	}
	
	public void sendAll(ChattData cd) throws Exception{
		for(ServerThread st : frame.clients) { // frame�� ������ �ִ� ��� clients(�ڽ�����).
			st.oos.writeObject(cd);
			st.oos.flush();
		}
	}
}
