package semishit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class BoardInsert extends JDialog {


	public 	BoardList bl;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;


	public static void main(String[] args) {
		try {
			BoardInsert dialog = new BoardInsert();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BoardInsert() {
		setBounds(100, 100, 598, 434);
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(0, 0, 582, 396);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getTextField());
		contentPanel.add(getScrollPane());
		contentPanel.add(getBtnNewButton());
		contentPanel.add(getLblNewLabel_1());
		setVisible(true);

	}
	
	public BoardInsert(BoardList bl) {
		this();
		this.bl=bl;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uACF5\uC9C0\uC0AC\uD56D \uAE00\uC4F0\uAE30");
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 558, 21);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBorder(new LineBorder(Color.BLACK));
			textField.setBounds(69, 35, 501, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 79, 558, 234);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBorder(new LineBorder(Color.BLACK));
		}
		return textArea;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC785\uB825");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textField.getText().equals("") || textArea.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
					}else {
						BoardVo vo = new BoardVo();
						String title = textField.getText();
						String con = textArea.getText();
						BoardDao dao = new BoardDao();
						vo.setTitle(title);
						vo.setWriter("KIm");
						vo.setContent(con); 
						int re = dao.insert(vo);
						if(re>0) {
							JOptionPane.showMessageDialog(null, "공지사항이 등록되었습니다.");
							textField.setText("");
							textArea.setText("");;
							bl.tt();
						}else {
							JOptionPane.showMessageDialog(null, "등록오류!!.");
						}
					}
				}
			});
			btnNewButton.setBounds(395, 323, 175, 38);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC81C\uBAA9");
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
			lblNewLabel_1.setBounds(12, 35, 45, 21);
		}
		return lblNewLabel_1;
	}
}
