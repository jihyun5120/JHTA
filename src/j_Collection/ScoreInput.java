package j_Collection;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScoreInput extends JInternalFrame {
	Map<String, List<ScoreVo>> map;
	MemberMain mm;
	
	private JLabel lblNewLabel;
	private InputPanel panel; //JPanel을 InputPanel로 바꿈.
	private JButton btnNewButton;
	private JLabel status;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreInput frame = new ScoreInput();
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
	public ScoreInput() {
		super("성적입력", false, true, true, true);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		setVisible(true);
		setBounds(100, 100, 236, 488);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getStatus());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel());

	}
	
	public ScoreInput(Map<String, List<ScoreVo>> map, MemberMain mm) { //MemberMain을 주는 것이 보안상 걱정되면 JPanel으로 줘도됨.
		this();
		this.map = map;
		this.mm = mm;
	}
	
	public void sync(){ //성적이 추가되면 자동으로 조회프레임의 내용 수정.
		Object[] obj = mm.getContentPane().getComponents();
		for(int i=0; i<obj.length; i++) {
			if(obj[i] instanceof ScoreSearch) {
				ScoreSearch ss = (ScoreSearch)obj[i];
				ss.btnFind.doClick();
			}
		}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC785\uB825");
			lblNewLabel.setBounds(12, 40, 89, 33);
			lblNewLabel.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20));
		}
		return lblNewLabel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new InputPanel();
			panel.setBackground(new Color(255, 250, 205));
			panel.setBounds(12, 69, 196, 308);
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//무결성 체크
					
					
					
					String sno = panel.tSno.getText();
					String mName = panel.tmName.getText();
					String exam = "";
					int kor = Integer.parseInt(panel.tKor.getText());
					int eng = Integer.parseInt(panel.tEng.getText());
					int mat = Integer.parseInt(panel.tMat.getText());
					int grade = 0;
					if(panel.rExam1.isSelected()) {
						exam = "중간";
					}else {
						exam = "기말";
					}
					grade = panel.cGrade.getSelectedIndex()+1;
					
					ScoreVo vo = new ScoreVo(sno, mName, exam, grade, kor, eng, mat);
					
					panel.tTot.setText(vo.getTot() + "");
					panel.tAvg.setText(String.format("%5.1f", vo.getAvg()));
					
					ScoreDao dao = new ScoreDao(map);
					boolean b = dao.insert(vo);
					if(b) {
						status.setText("성적이 저장되었습니다.");
						sync();
					} else {
						status.setText("저장 중 오류가 발생했습니다.");
					}
				}
			});
			btnNewButton.setBackground(SystemColor.menu);
			btnNewButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			btnNewButton.setBounds(74, 387, 71, 26);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setBackground(new Color(211, 211, 211));
			status.setOpaque(true);
			status.setForeground(new Color(0, 0, 0));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 14));
			status.setBounds(12, 423, 196, 26);
		}
		return status;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\christmas11.png"));
			lblNewLabel_1.setBounds(0, 0, 208, 33);
		}
		return lblNewLabel_1;
	}
}
