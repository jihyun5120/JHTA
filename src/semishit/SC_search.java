package semishit;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class SC_search extends JInternalFrame {
	private JPanel panel;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SC_search frame = new SC_search();
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
	public SC_search() {
		super("학생 성적 조회", false, true, true, true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setVisible(true);
		setBounds(100, 100, 869, 507);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane_1(), BorderLayout.CENTER);
		
		restart();
	}
	
	public void restart() {
		ScDao dao = new ScDao();
		DefaultTableModel tm = dao.search("");
		table.setModel(tm);
		table.setAutoCreateRowSorter(true);
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getBtnNewButton_1(), BorderLayout.EAST);
			panel.add(getTextField(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC131\uC801 \uC870\uD68C");
			btnNewButton_1.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 15));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {//여기부터
					
					String str = textField.getText();
					ScDao dao = new ScDao();
					DefaultTableModel tm = dao.search(str);
					table.setModel(tm);
					
					
			
					
				}//여기까지
			});
		}
		return btnNewButton_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(255, 255, 255));
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setBackground(new Color(255, 255, 255));
			table.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					ScDao dao = new ScDao();
					int selec = table.getSelectedRow();
					int sno = Integer.parseInt((String)table.getValueAt(selec, 0));			
					ScVo scvo = dao.searchsno(sno);
					new ScTrinity(scvo, SC_search.this);
					
					
					
				}
			});
		}
		return table;
	}
}
