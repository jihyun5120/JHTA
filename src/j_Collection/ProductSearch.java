package j_Collection;

import java.awt.EventQueue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductSearch extends JInternalFrame {
	//��ȸ�� �԰�,��� �����Ͱ� ��� �ʿ�.
	Set<ProductVo> piList; 
	Set<ProductVo> peList;
	
	ButtonGroup group = new ButtonGroup(); //��ư �׷�ȭ(�� �߿� �ϳ��� ���õǾ� ���ǵ��� �ϱ� ����)
	
	private JPanel panel;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JTextField textField;
	private JPanel panel_1;
	private JRadioButton imBtn;
	private JRadioButton exBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductSearch frame = new ProductSearch(); //�̰��� ���� null.(���� �������� �ʾұ� ������)
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
	public ProductSearch() {
		super("��ǰ��ȸ", false, true, true, true);
		setVisible(true);
		setTitle("\uC81C\uD488\uC870\uD68C");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);
	}
	
	public ProductSearch(Set<ProductVo> pi, Set<ProductVo> pe) {
		this();
		//�Ű������� ���� ���� �ʵ�� ����.
		this.piList = pi;
		this.peList = pe;
	}
	
	public void Search() {
		Set<ProductVo> list = null; //�ϳ��� ��ü�� �̿��Ͽ� �� ���� ��ü�� �ڵ鸵�ϱ� ���� null���� ��.
		
		//�˻���(�ø���, ��ǰ�ڵ�, ��ǰ��)
		
			ProductVo find = new ProductVo(); // ProductVo�� find�� ȣ��.
			find.setSerial( textField.getText() );
			find.setpCode( textField.getText() );
			find.setpName( textField.getText() );
			
			textArea.setText("");
			
			if(imBtn.isSelected()) { //�԰��ư(imBtn)�� ���õǾ��� ��.
				list = piList;
			}else {
				list = peList;
			}
			Iterator<ProductVo> iter = list.iterator(); //�ݺ��� ȣ��.
			while(iter.hasNext()) {
				ProductVo vo = iter.next();
				if(vo.equals(find)) { //ProductVo���� equals�� �������̵��ؼ� ()�ȿ� ProductVoŸ������ �־����.
					textArea.append(vo.toString()); //ProductVo�� toString�� �������̵��Ͽ��⶧���� �� ���·� ��µ�.
				}
			}
	} //select of end.

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 30));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getTextField(), BorderLayout.CENTER);
			panel.add(getBtnNewButton(), BorderLayout.EAST);
			panel.add(getPanel_1(), BorderLayout.WEST);
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Search();
				}
			});
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\\uB3CB\uBCF4\uAE301.png"));
			btnNewButton.setFont(new Font("������������� Light", Font.PLAIN, 12));
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
			textArea.setFont(new Font("������������� Bold", Font.PLAIN, 13));
			textArea.setBackground(new Color(144, 238, 144));
		}
		return textArea;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(220, 220, 220));
			panel_1.setPreferredSize(new Dimension(110, 10));
			panel_1.add(getImBtn());
			panel_1.add(getExBtn());
		}
		return panel_1;
	}
	private JRadioButton getImBtn() {
		if (imBtn == null) {
			imBtn = new JRadioButton("\uC785\uACE0");
			imBtn.setBackground(new Color(220, 220, 220));
			imBtn.setFont(new Font("������������� Light", Font.PLAIN, 12));
			group.add(imBtn); //imBtn�׷�ȭ
			imBtn.setSelected(true); //�⺻���� �����ְ� ����.
		}
		return imBtn;
	}
	private JRadioButton getExBtn() {
		if (exBtn == null) {
			exBtn = new JRadioButton("\uCD9C\uACE0");
			exBtn.setBackground(new Color(220, 220, 220));
			exBtn.setFont(new Font("������������� Light", Font.PLAIN, 12));
			group.add(exBtn);//exBtn�׷�ȭ
		}
		return exBtn;
	}
}
