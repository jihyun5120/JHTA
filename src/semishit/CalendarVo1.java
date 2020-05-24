package semishit;

import java.util.Date;

public class CalendarVo1 {

	int sno;
	Date sdate;
	Date stin;
	Date stout;
	String status;
	
	public CalendarVo1() {
		
	}
	
	public CalendarVo1(int sno, Date sdate, Date stin, Date stout, String status) {
		this.sno = sno;
		this.sdate = sdate;
		this.stin = stin;
		this.stout = stout;
		this.status = status;
		
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}


	public Date getStin() {
		return stin;
	}

	public void setStin(Date stin) {
		this.stin = stin;
	}

	public Date getStout() {
		return stout;
	}

	public void setStout(Date stout) {
		this.stout = stout;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
