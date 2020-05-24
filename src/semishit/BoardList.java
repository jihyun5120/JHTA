package semishit;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class BoardList extends JInternalFrame {
	private JPanel panel;
	private JScrollPane scrollPane;
	private JButton upload;
	private JTable table;
	static DefaultTableModel dm;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					BoardList frame = new BoardList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public BoardList() {
		super("                                               \uACF5\uC9C0\uC0AC\uD56D",false, true, true, true);
		setBounds(100, 100, 472, 360);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.SOUTH);
		getContentPane().add(getScrollPane_1(), BorderLayout.CENTER);
		getContentPane().add(getPanel_1(), BorderLayout.NORTH);
		setVisible(true);
		
		tt();
	}
	
	public void tt() {
		BoardDao dao = new BoardDao();
		dm = dao.list();
		table.setModel(dm);
		table.setAutoCreateRowSorter(true);
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 50));
			panel.setLayout(null);
			panel.add(getUpload());
			panel.add(getComboBox());
			panel.add(getTextField());
			panel.add(getBtnNewButton());
		}
		return panel;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(240, 230, 140));
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	private JButton getUpload() {
		if (upload == null) {
			upload = new JButton("\uB4F1\uB85D");
			upload.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			if(!login.idck.equals("asdf123")) {
				upload.setVisible(false);
			}    // employee_number==100
			upload.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BoardInsert bi = new BoardInsert(BoardList.this);
				}
			});
			upload.setBounds(358, 10, 86, 30);
		}
		return upload;
	}
	
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					String s = (String) table.getValueAt(row, 0);
					BoardDao dao = new BoardDao();
					BoardVo vo = dao.deList(s);
					DeList2 dl = new DeList2(vo, BoardList.this);
				}
			});
		}
		return table;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC804\uCCB4", "\uC81C\uBAA9", "\uB0B4\uC6A9"}));
			comboBox.setBounds(12, 10, 65, 30);
		}
		return comboBox;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(82, 10, 192, 30);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String find = textField.getText();
					int index = comboBox.getSelectedIndex();
					BoardDao dao = new BoardDao();
					dm = dao.dList(index, find);
					table.setModel(dm);
				}
			});
			btnNewButton.setBounds(277, 10, 69, 30);
		}
		return btnNewButton;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getLabel());
		}
		return panel_1;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\\uC0AC\uC9C4\\\uBA54\uC778\uCC3D\\\uD478\uB978\uBC14.png"));
			label.setPreferredSize(new Dimension(57, 30));
			label.setOpaque(true);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(Color.WHITE);
			label.setBackground(new Color(106, 90, 205));
		}
		return label;
	}
}
