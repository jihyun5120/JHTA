package h_api;

import java.util.Comparator;

public class BoardComparator implements Comparator<BoardVo> {
 
   @Override
   public int compare(BoardVo o1, BoardVo o2) { //instanceof 를 이용하여 o1,o2가 BoardVo타입인지 한번 더 비교하면 더 좋음.
   int r = 0;
   	if(o1 != null && o2 != null){ //배열의 null부분이 서핑되지않도록.
   		r = o2.getmDate().compareTo(o1.getmDate());
   	}
   	return r;
	}
}