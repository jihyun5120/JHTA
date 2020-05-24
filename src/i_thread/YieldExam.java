/*
 *  YieldA, YieldB
 */
package i_thread;

public class YieldExam {
	public static void main(String[] args) {
		YieldA y1 = new YieldA(); 
		YieldB y2 = new YieldB();
		
		y1.start();
		y2.start();
		
		try {
			Thread.sleep(3000);
		} catch(Exception ex) {}
		
		y1.work = false;
		
		try {
			Thread.sleep(3000);
		} catch(Exception ex) {}
		
		y1.work = true;
		
		try {
			Thread.sleep(3000);
		} catch(Exception ex) {}
		
		y1.stop = true;
		y2.stop = true;
	}
}
