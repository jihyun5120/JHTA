package m_jdbc;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MemberSelect extends JInternalFrame {
	private JLabel label;
	private JTextField find;
	private JButton button;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberSelect frame = new MemberSelect();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberSelect() {
		super("학생정보조회", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 365, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel());
		getContentPane().add(getFind());
		getContentPane().add(getButton());
		getContentPane().add(getScrollPane());
		getContentPane().add(getLabel_1());
	}
	

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uD559\uC0DD\uC815\uBCF4\uC870\uD68C");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("나눔고딕", Font.BOLD, 20));
			label.setBounds(0, 10, 349, 24);
		}
		return label;
	}
	private JTextField getFind() {
		if (find == null) {
			find = new JTextField();
			find.setBounds(126, 45, 136, 21);
			find.setColumns(10);
		}
		return find;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uC870\uD68C");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //조회
					
					MemberDao dao = new MemberDao();
					String f = find.getText();
					List<MemberVo> list = dao.select(f);
					textArea.setText("");					
					for(MemberVo vo : list) {
						textArea.append(vo.toString());
					}
					if(list.isEmpty()) {
						textArea.setText("해당 정보가 없습니다.");
					}
					find.requestFocus();
					find.selectAll();
				}
			});
			button.setBounds(268, 44, 71, 23);
		}
		return button;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 79, 323, 182);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
		}
		return textArea;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setOpaque(true);
			label_1.setBackground(new Color(255, 192, 203));
			label_1.setBounds(0, 6, 349, 32);
		}
		return label_1;
	}
}
