package stopwatch;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class StopWatchThread extends JPanel implements Runnable{
	private static JLabel stopwatch;
	boolean stop = false;
	int count;
	/**
	 * Create the panel.
	 */
	public StopWatchThread() {
		setLayout(new BorderLayout(0, 0));
		add(getStopwatch(), BorderLayout.CENTER);
	}

	@Override
	public void run() {
		while(!stop) {
			try{
				String str = String.valueOf(count);
				stopwatch.setText(str);
				Thread.sleep(1);
				count++;
			} catch (InterruptedException ex) {
			}
			
		}
	}

	private JLabel getStopwatch() {
		if (stopwatch == null) {
			stopwatch = new JLabel("");
			stopwatch.setOpaque(true);
			stopwatch.setBackground(new Color(255, 204, 204));
			stopwatch.setFont(new Font("³ª´®½ºÄù¾î Bold", Font.BOLD, 25));
			stopwatch.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return stopwatch;
	}
}
