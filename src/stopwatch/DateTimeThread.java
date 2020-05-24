package stopwatch;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;

public class DateTimeThread extends Thread{
	JTextField field = new JTextField();
	
	
	@Override
	public void run() {
		while(true) {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E) a hh:mm:ss");
			String txt = sdf.format(now);
			try {
				Thread.sleep(1000);
			} catch(Exception ex) {}
			TimeWatch tw = new TimeWatch(txt);
		}
	}
}
