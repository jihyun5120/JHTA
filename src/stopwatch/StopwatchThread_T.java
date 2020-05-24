package stopwatch;

import java.text.DecimalFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class StopwatchThread_T extends JPanel implements Runnable{
	boolean stop = false;
	private JLabel timeLabel;
	/**
	 * Create the panel.
	 */
	public StopwatchThread_T() {
		setLayout(new BorderLayout(0, 0));
		add(getTimeLabel(), BorderLayout.CENTER);

	}

	public void run() {
		DecimalFormat df = new DecimalFormat("##:##:00");
		long begin = new Date().getTime();
		while(!stop) {
			long end = new Date().getTime()-begin;
			try {
				Thread.sleep(1);
			} catch(Exception ex) {}
			timeLabel.setText(df.format(end/1000.0));
		}
	}
	private JLabel getTimeLabel() {
		if (timeLabel == null) {
			timeLabel = new JLabel("");
			timeLabel.setOpaque(true);
			timeLabel.setBackground(Color.BLACK);
		}
		return timeLabel;
	}
}
