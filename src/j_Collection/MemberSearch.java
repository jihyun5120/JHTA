package j_Collection;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MemberSearch extends JInternalFrame {
	List<MemberVo> list;
	
	private JPanel panel;
	private JTextField findstr;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberSearch frame = new MemberSearch();
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
	public MemberSearch() {
		super("회원정보 조회", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);
	}
	
	public MemberSearch(List<MemberVo> list) {
		this();
		this.list = list;
	}

	public void Search() {
		textArea.setText("");
		String find = findstr.getText();
		
		for(int i=0; i<list.size(); i++) {
			MemberVo vo = list.get(i);
			
			if(vo.getMid().indexOf(find)>=0 || 
			   vo.getmNmae().indexOf(find)>=0 ||
			   vo.getPhone().indexOf(find)>=0) {				
				textArea.append(vo.toString() + "\n");
			} else {
				textArea.setText("찾는 정보가 없습니다.");
			}
		}
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 25));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getFindstr(), BorderLayout.CENTER);
			panel.add(getBtnNewButton(), BorderLayout.EAST);
		}
		return panel;
	}
	private JTextField getFindstr() {
		if (findstr == null) {
			findstr = new JTextField();
			findstr.setColumns(10);
		}
		return findstr;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 12));
			btnNewButton.setIconTextGap(5);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Search();
				}
			});
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\\uB3CB\uBCF4\uAE301.png"));
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setRequestFocusEnabled(false);
			textArea.setBackground(new Color(176, 196, 222));
		}
		return textArea;
	}
}
