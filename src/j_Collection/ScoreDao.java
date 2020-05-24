package j_Collection;

import java.util.*; //패키지 안에 있는 것을 다 import해줘라!

public class ScoreDao{
	Map<String, List<ScoreVo>> map;
	List<ScoreVo> list;
	
	public ScoreDao() {}
	
	public ScoreDao(Map<String, List<ScoreVo>> map) {
		this.map = map;
	}
	
	public boolean insert(ScoreVo vo){ //입력
		boolean b = true;
		try {
		String key = vo.getSno();
			if(map.containsKey(key)) { //containKey : 키가 존재하느냐
				list = map.get(key);
				list.add(vo); //
			} else { //키가 없는경우
				list = new ArrayList<ScoreVo>();
				list.add(vo);
			
				map.put(key, list); //map은 기존데이터가 있는 상태에서 put을 하면 수정이됨.
			}
		} catch(Exception ex) {
			b = false;
		}
		return b;
	}
	
	public boolean update(String key, int index, ScoreVo vo) { //수정
		boolean b = true;
		
		try {
			List<ScoreVo> list = map.get(key);
			list.set(index, vo);
		}catch(Exception ex) {
			b = false;
		}
		return b;
	}
	
	public boolean delecte(String sno, int index) { //삭제
		boolean b = true;
		try {
			List<ScoreVo> list = map.get(sno);
			list.remove(index);
		} catch(Exception ex) {
			b = false;
		}
		return b;
	}
	
	public Map<String, List<ScoreVo>> list(String findStr) { //검색
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
