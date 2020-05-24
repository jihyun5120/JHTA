package semishit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JTextArea;

public class Update extends JPanel {
	public JTextField title;
	public JTextField wrDate;
	public JTextField writer;
	public JTextField rdCnt;
	private JScrollPane scrollPane;
	public JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public Update() {
		setBackground(Color.WHITE);
		setLayout(null);
		add(getTitle());
		add(getWrDate());
		add(getWriter());
		add(getRdCnt());
		add(getScrollPane());

	}

	private JTextField getTitle() {
		if (title == null) {
			title = new JTextField();
			title.setFont(new Font("±¼¸²", Font.BOLD, 12));
			title.setSelectionColor(Color.BLACK);
			title.setBorder(new LineBorder(Color.BLACK));
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setOpaque(false);
			title.setBounds(12, 5, 475, 21);
			title.setColumns(10);
		}
		return title;
	}
	private JTextField getWrDate() {
		if (wrDate == null) {
			wrDate = new JTextField();
			wrDate.setFont(new Font("±¼¸²", Font.BOLD, 12));
			wrDate.setBorder(new LineBorder(Color.BLACK));
			wrDate.setEditable(false);
			wrDate.setBounds(12, 48, 116, 21);
			wrDate.setColumns(10);
		}
		return wrDate;
	}
	private JTextField getWriter() {
		if (writer == null) {
			writer = new JTextField();
			writer.setFont(new Font("±¼¸²", Font.BOLD, 12));
			writer.setBorder(new LineBorder(Color.BLACK));
			writer.setEditable(false);
			writer.setBounds(196, 48, 116, 21);
			writer.setColumns(10);
		}
		return writer;
	}
	private JTextField getRdCnt() {
		if (rdCnt == null) {
			rdCnt = new JTextField();
			rdCnt.setFont(new Font("±¼¸²", Font.BOLD, 12));
			rdCnt.setBorder(new LineBorder(Color.BLACK));
			rdCnt.setEditable(false);
			rdCnt.setBounds(371, 48, 116, 21);
			rdCnt.setColumns(10);
		}
		return rdCnt;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 90, 475, 171);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		}
		return textArea;
	}
}
