package z_exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;

public class FileStreamExam {
		public FileStreamExam() throws Exception{ //오류를 메인의 객체 호출한 곳으로 넘겨버림.
			JFileChooser jc = new JFileChooser();
			int flag = jc.showOpenDialog(null); //showOpenDialog : 열기모드창, flag에는 X,열기,취소 중 누른 버튼의 값이 들어감.
			
			if(flag!=JFileChooser.APPROVE_OPTION) { //APPROVE_OPTION : 파일을 정상적으로 선택하고 열기를 누른것.
				return;
			}
			String fileName = jc.getSelectedFile().getPath(); //선택한 파일의 경로가 fileName에 들어감.
			System.out.println("file : " + fileName);
			
			File file = new File(fileName);//읽어들이는 파일
			FileInputStream readFile = new FileInputStream(file); //FileInputStream은 byte단위로 파일을 읽음, InputStreamReader는 문자단위로 파일을 읽음.
			
			flag = jc.showSaveDialog(null); //showSaveDialog : 저장모드창
			if(flag != JFileChooser.APPROVE_OPTION) {
				return;
			}
			String fileName2 = jc.getSelectedFile().getPath();
			File file2 = new File(fileName2); 
			FileOutputStream writeFile = new FileOutputStream(file2);
			
			byte[] readByte = new byte[4096]; //4kb씩 읽음.
			int readSize = 0;
			
			while((readSize=readFile.read(readByte))!= -1) { //-1 : 파일을 다 읽을 때까지,한번에 readByte씩(4096byte씩)읽음.
				//writeFile.write(readByte); 남는 바이트는 쓰레기정보를 읽기 때문에 이렇게 사용X
				writeFile.write(readByte, 0, readSize);//readByte배열에서 첫번째byte부터 readSize까지 읽음(원본과 읽은 데이터 크기가 동일해짐)				
			}
			writeFile.flush();
			writeFile.close();
			readFile.close();
		}
		
	public static void main(String[] args) throws Exception{//메인에서 던진 오류를 가상머신이 받음.
		FileStreamExam fs = new FileStreamExam(); //제 3의 작업을 할 가능성이 있음.
		//new FileStreamExam(); 익명형. 제 3의 작업을 하지X.
	}
}
