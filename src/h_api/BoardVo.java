package h_api;

import java.text.MessageFormat;

public class BoardVo {

   private int no;
   private String subject;
   private String content;
   private String mId;
   private String mDate;
   private String cnt;
   
   public BoardVo(int n, String s, String c, String m, String d, String t ) {
      this.no = n;
      this.subject = s;
      this.content = c;
      this.mId = m;
      this.mDate = d;
      this.cnt = t;
   }
   
 
public int getNo() {
	return no;
}

public void setNo(int no) {
	this.no = no;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getmId() {
	return mId;
}

public void setmId(String mId) {
	this.mId = mId;
}

public String getmDate() {
	return mDate;
}

public void setmDate(String mDate) {
	this.mDate = mDate;
}

public String getCnt() {
	return cnt;
}

public void setCnt(String cnt) {
	this.cnt = cnt;
}

@Override
   public String toString() {
      String result = "게시물번호 : {0}, 제목 : {1}, 내용: {2}, 작성자 아이디: {3}, 작성일 {4}, 조회수:{5}\n";
      result += "--------------------------------------------------------------------------\n";

      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < BoardMain.count; i++) {
         String temp = 
               MessageFormat.format(result, BoardMain.data[i].no,  BoardMain.data[i].subject,  BoardMain.data[i].content,  BoardMain.data[i].mId, BoardMain.data[i].mDate,  BoardMain.data[i].cnt);
         sb.append(temp);
      }
      
      return String.format("%d, %s, %s, %s, %s, %s \n", no, subject, content, mId, mDate, cnt);
   }
      
}
