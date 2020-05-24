package k_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	String fileName = "member.dat";
	
	public List<MemberVo> search(MemberSearch ms){
		List<MemberVo> list = new ArrayList<MemberVo>();
		
		//member.dat�� �ִ� �ڷ���� �о� list�� �߰��� �� ��ȯ
		try {
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			String find = ms.getFindstr().getText(); //getFindstr ��ȸ�Ҷ� �˻�â.
			
			List<MemberVo> temp = (List)ois.readObject();
			for(MemberVo vo : temp) {
				if(vo.equals(find)) {
					list.add(vo);
				}
			}
		} catch(Exception ex) {
			list = null;
		}
		return list;
	}
	
	public boolean insert(MemberVo vo) { //ȸ����ȸ
		boolean b = true;
		
		try {
			//������ ������ �о �޸𸮿� ����
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is); 
			List<MemberVo> list = (List)ois.readObject();
			ois.close();
			is.close();
			
			//�Ű������� �Էµ� vo�� �޸𸮿� �߰�
			list.add(vo);
			
			//�ش� ������ �ٽ� ���Ͽ� ����
			OutputStream os = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			os.close();
		} catch(Exception ex) {
			b = false;
		} finally { //������ �ֵ� ���� �׻� �����.
			return b;
		}
	}
	
	public MemberVo search(String findMid) { //ȸ������|������ ��ȸ
		MemberVo vo = null;
		List<MemberVo> list;
		try {
			InputStream is = new FileInputStream(fileName); //�º��� FileInputStream���� �־��. ����ȭ������ ������ ����.
			ObjectInputStream ois = new ObjectInputStream(is);
			list = (List)ois.readObject();
			for(MemberVo v : list) {
				if(v.getMid().equals(findMid)) {
					vo = v;
					break; // findMid�� �ش��ϴ� ���� ã���� ã�·����� �׸��ϱ� ����.
				}
			}
			ois.close();
			is.close();
		} catch(Exception ex) {
			vo = null;
		} finally {
			return vo;
		}
	}
	
	public boolean modify(MemberVo vo) { //����
		boolean b = true;
		try {
			int index = -1;
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			List<MemberVo> list = (List)ois.readObject();
			for(int i=0; i<list.size(); i++) {
				MemberVo v = list.get(i);
				if(v.getMid().equals(vo.getMid())) {
					list.set(i, vo);
					index = i; //������ ���� i��°�� �ٽ� �ֱ� ���ؼ�.
					break;
				}
			}
			ois.close();
			is.close();
			
			if(index == -1) { //������ �� ������.
				b = false; //������ ���� �ʾұ� ������ false����.
			} else { //������ ������ ����.
				OutputStream os = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(list);
				oos.flush();
				oos.close();
				os.close();
			}
		} catch(Exception ex) {
			b = false;
			ex.printStackTrace();
		} finally {
			return b;
		}
	}
	
	public boolean delete(String mId){ //����
		boolean b = true;
		int index = -1;
		try {
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			List<MemberVo> list = (List)ois.readObject();
			for(int i=0; i<list.size(); i++) {
				MemberVo v = list.get(i);
				if(v.getMid().equals(mId)) {
					index = i;
					list.remove(index);
					break;	
				}
			}
			ois.close();
			is.close();
			if(index >= 0) {
				OutputStream os = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(list);
				oos.flush();
				oos.close();
				os.close();
			}
		} catch(Exception ex) {
			b = false;
			ex.printStackTrace();
		} finally {
			return b;
		}
	}
}
