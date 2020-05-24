package company;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Send1 extends Thread{
	String fileName;
	String path;
	int port;
	
	public Send1() {}
	
	public Send1(String fileName, String path) {
		this.fileName = fileName;
		this.path = path; 
	}
   
	 public void run() {
	      Socket s;
	      OutputStream os;
	      InputStream is;
	      DataInputStream dis;
	      byte[] bytes = new byte[90000] ;
	      String message = "send";
	      
	      try {
	         
	         s = new Socket("192.168.0.22",5001); //System.out.println("서버에 연결함");
	         is = s.getInputStream();
	         os = s.getOutputStream();

	         bytes = message.getBytes();
	         os.write(bytes); //System.out.println("메세지 보냄");
	         
	         dis = new DataInputStream(is);
	         this.port = dis.readInt(); //System.out.println("포트번호 받음");
	         
	         Thread send2 = new Send2(this.port, this.fileName, this.path);
	         send2.start();
	         os.flush();
	         dis.close();
	         os.close();
	         is.close();
	         s.close();
	         
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      } 
	      
	   }


}