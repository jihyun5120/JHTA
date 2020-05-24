package j_Collection;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ScoreSearch extends JInternalFrame {
	Map<String, List<ScoreVo>> map; //�����ڸ� ���� ���޹���.
	DefaultListModel<String> modelSno = new DefaultListModel<>(); //JList�� ��ü����(listSno)
	DefaultListModel<String> modelExam = new DefaultListModel<>();//JList�� ��ü����(listExam)
	List<ScoreVo> list;
	
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JList listSno;
	private JScrollPane scrollPane_1;
	private InputPanel panel; //JPanel�� InputPanel�� �ٲ�.
	private JTextField textField;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JList listExam;
	private JLabel status;
	private JLabel lblNewLabel_2;

	public JButton btnFind;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreSearch frame = new ScoreSearch();
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
	public ScoreSearch() {
		super("������ȸ", false, true, true, true);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		setBounds(100, 100, 595, 442);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getScrollPane_3());
		getContentPane().add(getScrollPane_1_1());
		getContentPane().add(getPanel());
		getContentPane().add(getTextField_1());
		getContentPane().add(getBtnFind());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getStatus());
		getContentPane().add(getLblNewLabel_2());

	}
	
	public ScoreSearch(Map<String, List<ScoreVo>> map) {
		this(); //�Ű��������� ������ȣ��
		this.map = map; //�Ű������� �ʵ�map�� ����
		
		//�й��� �����Ͽ� JList�� ǥ��
		Set<String> set = map.keySet(); //map�� ������ �ִ� Ű��(�й�)�� ȣ���ϱ� ���� keySet���
		
		//JList�� �߰�
		Iterator<String> iter = set.iterator(); //�ݺ����� ���� list�� �ִ� �� ����(���� for���� ����)
		while(iter.hasNext()) { //���� �����Ͱ� �ִ�?
			modelSno.addElement(iter.next()); //���� �����ͷ� �̵��ؼ� ������.
		}
		listSno.setModel(modelSno); //model�� �����͸� listSno�� ����
		
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC218\uC815 | \uC0AD\uC81C");
			lblNewLabel.setFont(new Font("������������� ExtraBold", Font.PLAIN, 20));
			lblNewLabel.setBounds(12, 10, 137, 49);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane_3() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 60, 126, 310);
			scrollPane.setViewportView(getListSno());
		}
		return scrollPane;
	}
	private JList getListSno() {
		if (listSno == null) {
			listSno = new JList();
			listSno.setBackground(new Color(240, 255, 240));
			listSno.setFont(new Font("������������� Bold", Font.PLAIN, 14));
			listSno.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent ev) {
					
					String sno = (String)listSno.getSelectedValue();
					if(sno == null) { return; }
					
					list = map.get(sno); 
					modelExam = new DefaultListModel<>(); //ȣ��
					for(int i=0; i<list.size(); i++) {
						ScoreVo vo = list.get(i);
						String temp = String.format("%s : %d (%s)", vo.getmName(), vo.getGrade(), vo.getExam());
						modelExam.addElement(temp);
					}//end of for
					listExam.setModel(modelExam);
				}
			});
		}
		return listSno;
	}
	private JScrollPane getScrollPane_1_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(143, 60, 226, 310);
			scrollPane_1.setViewportView(getListExam());
		}
		return scrollPane_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new InputPanel();
			panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, new Color(245, 245, 220), null));
			panel.setBounds(374, 60, 191, 310);
		}
		return panel;
	}
	private JTextField getTextField_1() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(297, 30, 200, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnFind() {
		if (btnFind == null) {
			btnFind = new JButton("\uAC80\uC0C9");
			btnFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String findStr = textField.getText();
					ScoreDao dao = new ScoreDao(map);
					Map<String, List<ScoreVo>>newMap = dao.list(findStr);
					
					Set<String> set = newMap.keySet();
					modelSno = new DefaultListModel<String>(); //model.clear �ص���.
					
					Iterator<String> iter = set.iterator();
					while(iter.hasNext()) {
						modelSno.addElement(iter.next());
					}
					listSno.setModel(modelSno);
					modelExam.clear();
					
					//�ƹ� �˻����� �˻���ư�� ������ �� ������ ĭ ����
					panel.tSno.setText("");
					panel.tmName.setText("");
					panel.tKor.setText("");
					panel.tEng.setText("");
					panel.tMat.setText("");
					panel.tTot.setText("");
					panel.tAvg.setText("");
				}
			});
			btnFind.setBackground(SystemColor.menu);
			btnFind.setFont(new Font("�����ٸ����", Font.PLAIN, 12));
			btnFind.setBounds(500, 30, 65, 23);
		}
		return btnFind;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String key = panel.tSno.getText();
					int index = listExam.getSelectedIndex();
					String mName = panel.tmName.getText();
					String exam = "";
					int kor = Integer.parseInt(panel.tKor.getText());
					int eng = Integer.parseInt(panel.tEng.getText());
					int mat = Integer.parseInt(panel.tMat.getText());
					int grade = 0;
					if(panel.rExam1.isSelected()) {
						exam = "�߰�";
					}else {
						exam = "�⸻";
					}
					grade = panel.cGrade.getSelectedIndex()+1;
					
					ScoreVo vo = new ScoreVo(key, mName, exam, grade, kor, eng, mat);
					
					ScoreDao dao = new ScoreDao(map);
					boolean b = dao.update(key, index, vo);
					if(b) {
						status.setText("������ �����Ǿ����ϴ�.");
					} else {
						status.setText("���� �� ������ �߻��߽��ϴ�.");
					}
					
				}
			});
			btnNewButton_1.setBackground(SystemColor.menu);
			btnNewButton_1.setFont(new Font("�����ٸ����", Font.PLAIN, 12));
			btnNewButton_1.setBounds(388, 380, 77, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC0AD\uC81C");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String key = panel.tSno.getText();
					int index = listExam.getSelectedIndex();
					
					ScoreDao dao = new ScoreDao(map);
					boolean b = dao.delecte(key, index);
					if(b) {
						status.setText("�ڷᰡ �����Ǿ����ϴ�.");
						panel.tSno.setText("");
						panel.tmName.setText("");
						panel.tKor.setText("");
						panel.tEng.setText("");
						panel.tMat.setText("");
						panel.tTot.setText("");
						panel.tAvg.setText("");
						if(modelExam.size()>0) {
							modelExam.remove(index);							
						}
					} else {
						status.setText("���� �� ������ �߻��Ͽ����ϴ�.");
					}
				}
			});
			btnNewButton_2.setBackground(SystemColor.menu);
			btnNewButton_2.setFont(new Font("�����ٸ����", Font.PLAIN, 12));
			btnNewButton_2.setBounds(480, 380, 77, 23);
		}
		return btnNewButton_2;
	}
	private JList getListExam() {
		if (listExam == null) {
			listExam = new JList();
			listExam.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					int index = listExam.getSelectedIndex();
					int grade = -1;
					if(index < 0) {
						return;
					}
					
					ScoreVo vo = list.get(index);
					panel.tSno.setText(vo.getSno());
					panel.tmName.setText(vo.getmName());
					panel.tKor.setText(vo.getKor() + "");
					panel.tEng.setText(vo.getEng() + "");
					panel.tMat.setText(vo.getMat() + "");
					panel.tTot.setText(vo.getTot() + "");
					panel.tAvg.setText(String.format("%4.1f", vo.getAvg()));
					//������������
					if(vo.getExam().equals("�߰�")) {
						panel.rExam1.setSelected(true);
					} else {
						panel.rExam2.setSelected(true);
					}
					//�г⼱��
					grade = vo.getGrade()-1; //1�г��� �ε����� 0���̱⶧���� -1
					panel.cGrade.setSelectedIndex(grade);
				}
			});
			listExam.setBackground(new Color(255, 240, 245));
			listExam.setFont(new Font("������������� Bold", Font.PLAIN, 14));
		}
		return listExam;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setForeground(Color.BLUE);
			status.setFont(new Font("������� ExtraBold", Font.PLAIN, 13));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(new Color(220, 220, 220));
			status.setBounds(12, 379, 357, 23);
		}
		return status;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\\uB8E8\uB3CC\uD5041.png"));
			lblNewLabel_2.setBounds(145, 0, 142, 59);
		}
		return lblNewLabel_2;
	}
}
