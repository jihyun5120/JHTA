package semishit;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class JoinSearch extends JInternalFrame {
	private JPanel panel;
	private JButton btnNewButton;
	private JTextField findStr;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinSearch frame = new JoinSearch();
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
	public JoinSearch() {
		super("조회", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 580, 467);
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);

	}

	public Vector getColumn() {
		Vector col = new Vector();

		col.add("사원번호");
		col.add("아이디");
		col.add("비밀번호");
		col.add("성명");
		col.add("비밀번호 정답");
	

		return col;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 35));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getBtnNewButton(), BorderLayout.EAST);
			panel.add(getFindStr(), BorderLayout.CENTER);
		}
		return panel;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setBackground(Color.PINK);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// 검색
					String find = findStr.getText();
					joinDao dao = new joinDao();
					DefaultTableModel model = new DefaultTableModel(dao.select(find), getColumn());

					table.setModel(model);

				}
			});
		}
		return btnNewButton;
	}

	private JTextField getFindStr() {
		if (findStr == null) {
			findStr = new JTextField();
			findStr.setToolTipText("\uC0AC\uC6D0\uBC88\uD638,\uC774\uB984,\uC544\uC774\uB514 \uC911 \uD558\uB098\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694~");
			findStr.setColumns(10);
		}
		return findStr;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
			String find = findStr.getText();
			joinDao dao = new joinDao();
			DefaultTableModel model = new DefaultTableModel(dao.select(find), getColumn());

			table.setModel(model);
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {//이부분 다시다시.
					
					JInternalFrame mm =   new MemberUpdateDelete();
				    
			
					
				}
			});
		}
		return table;
	}
}
