package h_api;

import java.util.Comparator;

public class BoardComparator implements Comparator<BoardVo> {
 
   @Override
   public int compare(BoardVo o1, BoardVo o2) { //instanceof �� �̿��Ͽ� o1,o2�� BoardVoŸ������ �ѹ� �� ���ϸ� �� ����.
   int r = 0;
   	if(o1 != null && o2 != null){ //�迭�� null�κ��� ���ε����ʵ���.
   		r = o2.getmDate().compareTo(o1.getmDate());
   	}
   	return r;
	}
}