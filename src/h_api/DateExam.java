package h_api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExam {
	
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) hh시 mm분 ss초");
		System.out.println(sdf.format(now));
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		System.out.println(year + "년");
		
		int month = cal.get(Calendar.MONTH)+1;
		System.out.println(month + "월");
	}
}
