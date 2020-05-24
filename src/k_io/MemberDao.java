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
		
		//member.dat에 있는 자료들을 읽어 list에 추가한 후 반환
		try {
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			String find = ms.getFindstr().getText(); //getFindstr 조회할때 검색창.
			
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
	
	public boolean insert(MemberVo vo) { //회원조회
		boolean b = true;
		
		try {
			//파일의 정보를 읽어서 메모리에 적재
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is); 
			List<MemberVo> list = (List)ois.readObject();
			ois.close();
			is.close();
			
			//매개변수로 입력된 vo를 메모리에 추가
			list.add(vo);
			
			//해당 내용을 다시 파일에 저장
			OutputStream os = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			os.close();
		} catch(Exception ex) {
			b = false;
		} finally { //에러가 있든 없든 항상 실행됨.
			return b;
		}
	}
	
	public MemberVo search(String findMid) { //회원수정|삭제의 조회
		MemberVo vo = null;
		List<MemberVo> list;
		try {
			InputStream is = new FileInputStream(fileName); //좌변에 FileInputStream으로 넣어도됨. 다형화때문에 저렇게 넣음.
			ObjectInputStream ois = new ObjectInputStream(is);
			list = (List)ois.readObject();
			for(MemberVo v : list) {
				if(v.getMid().equals(findMid)) {
					vo = v;
					break; // findMid에 해당하는 값을 찾으면 찾는루핑을 그만하기 위해.
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
	
	public boolean modify(MemberVo vo) { //수정
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
					index = i; //수정한 값을 i번째에 다시 넣기 위해서.
					break;
				}
			}
			ois.close();
			is.close();
			
			if(index == -1) { //수정을 안 했으면.
				b = false; //수정을 하지 않았기 때문에 false리턴.
			} else { //수정을 했으면 저장.
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
	
	public boolean delete(String mId){ //삭제
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
