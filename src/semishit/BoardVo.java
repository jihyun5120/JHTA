package semishit;

import java.util.Date;

public class BoardVo {
	int number;
	Date writedate;
	String title;
	String content;
	int readcount;
	String writer;
	int price;
	
	public BoardVo() {}
	public BoardVo(int n, Date w, String t, String c, int r, String wr) {
		this.number=n;
		this.writedate=w;
		this.title=t;
		this.content=c;
		this.readcount=r;
		this.writer=wr;
	}

	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

	
	

}
