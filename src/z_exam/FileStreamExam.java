package z_exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;

public class FileStreamExam {
		public FileStreamExam() throws Exception{ //������ ������ ��ü ȣ���� ������ �Ѱܹ���.
			JFileChooser jc = new JFileChooser();
			int flag = jc.showOpenDialog(null); //showOpenDialog : ������â, flag���� X,����,��� �� ���� ��ư�� ���� ��.
			
			if(flag!=JFileChooser.APPROVE_OPTION) { //APPROVE_OPTION : ������ ���������� �����ϰ� ���⸦ ������.
				return;
			}
			String fileName = jc.getSelectedFile().getPath(); //������ ������ ��ΰ� fileName�� ��.
			System.out.println("file : " + fileName);
			
			File file = new File(fileName);//�о���̴� ����
			FileInputStream readFile = new FileInputStream(file); //FileInputStream�� byte������ ������ ����, InputStreamReader�� ���ڴ����� ������ ����.
			
			flag = jc.showSaveDialog(null); //showSaveDialog : ������â
			if(flag != JFileChooser.APPROVE_OPTION) {
				return;
			}
			String fileName2 = jc.getSelectedFile().getPath();
			File file2 = new File(fileName2); 
			FileOutputStream writeFile = new FileOutputStream(file2);
			
			byte[] readByte = new byte[4096]; //4kb�� ����.
			int readSize = 0;
			
			while((readSize=readFile.read(readByte))!= -1) { //-1 : ������ �� ���� ������,�ѹ��� readByte��(4096byte��)����.
				//writeFile.write(readByte); ���� ����Ʈ�� ������������ �б� ������ �̷��� ���X
				writeFile.write(readByte, 0, readSize);//readByte�迭���� ù��°byte���� readSize���� ����(������ ���� ������ ũ�Ⱑ ��������)				
			}
			writeFile.flush();
			writeFile.close();
			readFile.close();
		}
		
	public static void main(String[] args) throws Exception{//���ο��� ���� ������ ����ӽ��� ����.
		FileStreamExam fs = new FileStreamExam(); //�� 3�� �۾��� �� ���ɼ��� ����.
		//new FileStreamExam(); �͸���. �� 3�� �۾��� ����X.
	}
}
