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
	
	public void process() { //실행
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
		textArea.append("최소값 : " + entry.getKey() + " --> " + entry.getValue());
		
		entry = scores.lastEntry();
		textArea.append("\n최대값 : " + entry.getKey() + "--> " + entry.getValue());
		
		entry = scores.lowerEntry(50);
		textArea.append("\n50점 아래점수 : " + entry.getKey() + " --> " + entry.getValue());
		
		entry = scores.higherEntry(80);
		textArea.append("\n80점 위에점수 : " + entry.getKey() + " --> " + entry.getValue());
	}

	public void asc() { //오름차순 정렬
		if(scores != null){
			textArea.setText("[ 오름차순 정렬 ] \n");
			
			NavigableMap<Integer, String>tempMap = scores.descendingMap();
			NavigableMap<Integer, String> ascMap = tempMap.descendingMap();
			
			Set<Map.Entry<Integer, String>> set = ascMap.entrySet();
			for(Map.Entry<Integer, String> a : set) {
				textArea.append(a.getKey() + " : " + a.getValue() + "\n");
			}
		} else {
			textArea.setText("실행버튼을 클릭한 후 정렬해 주세요."); //scores에 값이 들어가고 난 뒤에 해야하기 때문.
		}
	}
	
	public void desc() { //내림차순 정렬
		if(scores != null) {
			textArea.setText("[ 내림차순 정렬 ] \n");
			
			NavigableMap<Integer, String> descMap = scores.descendingMap();
			Set<Map.Entry<Integer, String>> set = descMap.entrySet();
			
			for(Map.Entry<Integer, String> d : set) {
				textArea.append(d.getKey() + " : " + d.getValue() + "\n");
				} 
		} else {
			textArea.setText("실행버튼을 클릭한 후 정렬해 주세요.");
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
