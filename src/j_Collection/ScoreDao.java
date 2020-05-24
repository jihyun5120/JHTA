package j_Collection;

import java.util.*; //��Ű�� �ȿ� �ִ� ���� �� import�����!

public class ScoreDao{
	Map<String, List<ScoreVo>> map;
	List<ScoreVo> list;
	
	public ScoreDao() {}
	
	public ScoreDao(Map<String, List<ScoreVo>> map) {
		this.map = map;
	}
	
	public boolean insert(ScoreVo vo){ //�Է�
		boolean b = true;
		try {
		String key = vo.getSno();
			if(map.containsKey(key)) { //containKey : Ű�� �����ϴ���
				list = map.get(key);
				list.add(vo); //
			} else { //Ű�� ���°��
				list = new ArrayList<ScoreVo>();
				list.add(vo);
			
				map.put(key, list); //map�� ���������Ͱ� �ִ� ���¿��� put�� �ϸ� �����̵�.
			}
		} catch(Exception ex) {
			b = false;
		}
		return b;
	}
	
	public boolean update(String key, int index, ScoreVo vo) { //����
		boolean b = true;
		
		try {
			List<ScoreVo> list = map.get(key);
			list.set(index, vo);
		}catch(Exception ex) {
			b = false;
		}
		return b;
	}
	
	public boolean delecte(String sno, int index) { //����
		boolean b = true;
		try {
			List<ScoreVo> list = map.get(sno);
			list.remove(index);
		} catch(Exception ex) {
			b = false;
		}
		return b;
	}
	
	public Map<String, List<ScoreVo>> list(String findStr) { //�˻�
		Map<String, List<ScoreVo>> newMap = new HashMap<String, List<ScoreVo>>();
		
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			if(key.indexOf(findStr)>=0) {
				newMap.put(key, map.get(key));
			}
		}
		return newMap;
	}
}
