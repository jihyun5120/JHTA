package semishit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class DeList2 extends JDialog {
	String id;
	Update ud;
	BoardVo s;
	private final JPanel contentPanel = new JPanel();
	public BoardList bl;
	public JPanel panel;
	private JButton upda;
	private JButton button;
	private JButton upda1;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeList2 dialog = new DeList2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DeList2() {
		setBounds(100, 100, 550, 367);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setVisible(true);
		{
			panel = new JPanel();
			panel.setBounds(12, 10, 510, 268);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
		}
		contentPanel.add(getUpda());
		contentPanel.add(getButton());
		contentPanel.add(getUpda1());
		contentPanel.add(getLblNewLabel());
	}
	
	public DeList2(BoardVo s, BoardList bl) {
		this();
		this.s=s;
		this.bl=bl;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		panel.removeAll();
		Select se = new Select();
		panel.add(se);
		panel.updateUI();
		
		se.title.setText(s.getTitle());
		se.wrDate.setText(sdf.format(s.getWritedate()));
		se.writer.setText(s.getWriter());
		se.rdCnt.setText(s.getReadcount()+"");
		se.content.setText(s.getContent());

	}
	private JButton getUpda() {
		if (upda == null) {
			upda = new JButton("\uC218\uC815");
			if(!login.idck.equals("asdf123")) {
				upda.setVisible(false);
			}
			upda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					panel.removeAll();
					ud = new Update();
					panel.add(ud);
					panel.updateUI();
					
					ud.title.setText(s.getTitle());
					ud.wrDate.setText(sdf.format(s.getWritedate()));
					ud.writer.setText(s.getWriter());
					ud.rdCnt.setText(s.getReadcount()+"");
					ud.textArea.setText(s.getContent());
					upda.setVisible(false);
				} 
			});
			upda.setBounds(268, 278, 118, 56);
		}
		return upda;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uC0AD\uC81C");
			if(!login.idck.equals("사장")) {
				button.setVisible(false);
			} 
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?");
					
					if(result==0) {
						int num = s.getNumber();
						BoardDao dao = new BoardDao();
						int re = dao.delete(num);
						
						if(re>0) {
							JOptionPane.showMessageDialog(null, "삭제되었습니다.");
							bl.tt();
						}else {
							JOptionPane.showMessageDialog(null, "삭제실패!!");
						}
					}else {
						System.out.println("삭제불가능");
					}
					
				}
			});
			button.setBounds(404, 278, 118, 56);
		}
		return button;
	}
	private JButton getUpda1() {
		
		
		if (upda1 == null) {
			upda1 = new JButton("\uC218\uC815\uC644\uB8CC");
			if(!login.idck.equals("사장")) {
				upda1.setVisible(false);
			} 
			upda1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ud.title.getText().equals("") || ud.textArea.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "빈칸이 있습니다.!!");
					}else {
						String title = ud.title.getText();
						String content = ud.textArea.getText();
						int num = s.getNumber(); 
						
						BoardDao dao = new BoardDao();
						int re = dao.update(title, content, num);
						if(re>0) {
							JOptionPane.showMessageDialog(null, "수정되었습니다.");
							bl.tt();
						}else {
							JOptionPane.showMessageDialog(null, "수정실패!!");
						}
					}
				}
			});
			upda1.setBounds(268, 278, 118, 56);
		}
		return upda1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setIcon(null);
			lblNewLabel.setBounds(0, 0, 534, 334);
		}
		return lblNewLabel;
	}
}
