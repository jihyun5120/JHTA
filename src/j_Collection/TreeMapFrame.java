package j_Collection;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.awt.event.ActionEvent;

public class TreeMapFrame extends JInternalFrame {
	TreeMap<Integer, String> scores;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeMapFrame frame = new TreeMapFrame();
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
	public TreeMapFrame() {
		super("TreeMap", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 292, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getScrollPane());
	}
	
	public void process() { //����
		scores = new TreeMap<Integer, String>();
		
		scores.put(80, "kim");
		scores.put(70, "hong");
		scores.put(100, "choi");
		scores.put(40, "cho");
		scores.put(45, "park");
		scores.put(85, "lee");
		
		textArea.setText("");
		Map.Entry<Integer, String> entry = null;
		
		entry = scores.firstEntry();
		textArea.append("�ּҰ� : " + entry.getKey() + " --> " + entry.getValue());
		
		entry = scores.lastEntry();
		textArea.append("\n�ִ밪 : " + entry.getKey() + "--> " + entry.getValue());
		
		entry = scores.lowerEntry(50);
		textArea.append("\n50�� �Ʒ����� : " + entry.getKey() + " --> " + entry.getValue());
		
		entry = scores.higherEntry(80);
		textArea.append("\n80�� �������� : " + entry.getKey() + " --> " + entry.getValue());
	}

	public void asc() { //�������� ����
		if(scores != null){
			textArea.setText("[ �������� ���� ] \n");
			
			NavigableMap<Integer, String>tempMap = scores.descendingMap();
			NavigableMap<Integer, String> ascMap = tempMap.descendingMap();
			
			Set<Map.Entry<Integer, String>> set = ascMap.entrySet();
			for(Map.Entry<Integer, String> a : set) {
				textArea.append(a.getKey() + " : " + a.getValue() + "\n");
			}
		} else {
			textArea.setText("�����ư�� Ŭ���� �� ������ �ּ���."); //scores�� ���� ���� �� �ڿ� �ؾ��ϱ� ����.
		}
	}
	
	public void desc() { //�������� ����
		if(scores != null) {
			textArea.setText("[ �������� ���� ] \n");
			
			NavigableMap<Integer, String> descMap = scores.descendingMap();
			Set<Map.Entry<Integer, String>> set = descMap.entrySet();
			
			for(Map.Entry<Integer, String> d : set) {
				textArea.append(d.getKey() + " : " + d.getValue() + "\n");
				} 
		} else {
			textArea.setText("�����ư�� Ŭ���� �� ������ �ּ���.");
		}
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC2E4\uD589");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					process();
				}
			});
			btnNewButton.setBounds(12, 10, 78, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Desc");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					desc();
				}
			});
			btnNewButton_1.setBounds(185, 10, 78, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Asc");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					asc();
				}
			});
			btnNewButton_2.setBounds(98, 10, 78, 23);
		}
		return btnNewButton_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 43, 251, 218);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
