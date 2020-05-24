package semishit;

import javax.swing.JPanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import m_jdbc.DBConn;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class StudentSelect extends JPanel {
	private JLabel lblNewLabel;
	private JTable table;
	private JTextField textField;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;
	static String nom;
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Create the panel.
	 */
	public StudentSelect() {
		setBackground(new Color(255, 228, 181));
		setLayout(null);
		add(getLblNewLabel());
		add(getTextField());
		add(getBtnNewButton());
		add(getScrollPane());
		add(getBtnNewButton_1());
		add(getBtnNewButton_2());
		add(getBtnNewButton_3());
		
	}
	


	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uC0DD \uC870\uD68C");
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
			lblNewLabel.setBounds(24, 10, 155, 47);
		}
		return lblNewLabel;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFont(new Font("12·Ôµ¥¸¶Æ®µå¸²Light", Font.PLAIN, 12));
			table.setBackground(new Color(255, 228, 225));
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int x = table.getSelectedRow();
					nom = (String)table.getValueAt(x, 0);
				}
			});
			
		}
		return table;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(334, 40, 184, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(255, 160, 122));
			btnNewButton.setBorder(new LineBorder(Color.PINK, 2));
			btnNewButton.setFont(new Font("12·Ôµ¥¸¶Æ®µå¸²Medium", Font.PLAIN, 14));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StuDao dao = new StuDao();
					dao.select(textField.getText());
					table.setModel(dao.model);
				}
			});
			btnNewButton.setBounds(520, 39, 97, 23);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(245, 245, 220));
			scrollPane.setBorder(new LineBorder(new Color(138, 43, 226), 2));
			scrollPane.setBounds(12, 67, 607, 310);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC804\uCCB4 \uC870\uD68C");
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.setBackground(new Color(255, 160, 122));
			btnNewButton_1.setBorder(new LineBorder(Color.PINK, 2));
			btnNewButton_1.setFont(new Font("12·Ôµ¥¸¶Æ®µå¸²Medium", Font.PLAIN, 14));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StuDao dao = new StuDao();
					dao.selectAll();
					table.setModel(dao.model);
				}
			});
			btnNewButton_1.setBounds(519, 10, 97, 23);
		}
		return btnNewButton_1;
	}
	TableCellRenderer renderer = new TableCellRenderer() {
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			return null;
		}
	};
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC218\uC815");
			btnNewButton_2.setForeground(new Color(255, 255, 255));
			btnNewButton_2.setBackground(new Color(255, 160, 122));
			btnNewButton_2.setBorder(new LineBorder(Color.PINK, 2));
			btnNewButton_2.setFont(new Font("12·Ôµ¥¸¶Æ®µå¸²Medium", Font.PLAIN, 14));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UpdateDialog ud = new UpdateDialog();
					ud.sno.setText(nom);
				}
			});
			btnNewButton_2.setBounds(212, 387, 97, 23);
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("\uCD9C\uACB0");
			btnNewButton_3.setForeground(new Color(255, 255, 255));
			btnNewButton_3.setBackground(new Color(255, 160, 122));
			btnNewButton_3.setBorder(new LineBorder(Color.PINK, 2));
			btnNewButton_3.setFont(new Font("12·Ôµ¥¸¶Æ®µå¸²Medium", Font.PLAIN, 14));
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					StuAttendance sa = new StuAttendance();
					sa.sno.setText(nom);
				}
			});
			btnNewButton_3.setBounds(311, 387, 97, 23);
		}
		return btnNewButton_3;
	}
}
