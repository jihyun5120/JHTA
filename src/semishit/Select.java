package semishit;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;

public class Select extends JPanel {
	public JLabel title;
	public JLabel wrDate;
	public JLabel writer;
	public JLabel rdCnt;
	private JScrollPane scrollPane;
	public JLabel content;

	/**
	 * Create the panel.
	 */
	public Select() {
		setBorder(null);
		setPreferredSize(new Dimension(513, 271));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		add(getTitle());
		add(getWrDate());
		add(getWriter());
		add(getRdCnt());
		add(getScrollPane());

	}

	private JLabel getTitle() {
		if (title == null) {
			title = new JLabel("");
			title.setBorder(new LineBorder(Color.BLACK));
			title.setOpaque(true);
			title.setBackground(Color.WHITE);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setBounds(12, 10, 486, 25);
		}
		return title;
	}
	private JLabel getWrDate() {
		if (wrDate == null) {
			wrDate = new JLabel("");
			wrDate.setBorder(new LineBorder(Color.BLACK));
			wrDate.setBackground(Color.WHITE);
			wrDate.setOpaque(true);
			wrDate.setBounds(12, 50, 107, 25);
		}
		return wrDate;
	}
	private JLabel getWriter() {
		if (writer == null) {
			writer = new JLabel("");
			writer.setBorder(new LineBorder(Color.BLACK));
			writer.setBackground(Color.WHITE);
			writer.setOpaque(true);
			writer.setBounds(203, 50, 107, 25);
		}
		return writer;
	}
	private JLabel getRdCnt() {
		if (rdCnt == null) {
			rdCnt = new JLabel("");
			rdCnt.setBorder(new LineBorder(Color.BLACK));
			rdCnt.setBackground(Color.WHITE);
			rdCnt.setOpaque(true);
			rdCnt.setBounds(391, 50, 107, 25);
		}
		return rdCnt;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 94, 486, 163);
			scrollPane.setViewportView(getContent());
		}
		return scrollPane;
	}
	private JLabel getContent() {
		if (content == null) {
			content = new JLabel("");
			content.setVerticalAlignment(SwingConstants.TOP);
			content.setBorder(new LineBorder(new Color(0, 0, 0)));
			content.setBackground(Color.WHITE);
			content.setOpaque(true);
		}
		return content;
	}
}
