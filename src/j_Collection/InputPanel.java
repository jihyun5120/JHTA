package j_Collection;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InputPanel extends JPanel {
	
	ButtonGroup group = new ButtonGroup();
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	
	public JRadioButton rExam1;
	public JRadioButton rExam2;
	public JComboBox cGrade;
	public JTextField tSno;
	public JTextField tmName;
	public JTextField tKor;
	public JTextField tEng;
	public JTextField tMat;
	public JTextField tTot;
	public JTextField tAvg;

	/**
	 * Create the panel.
	 */
	public InputPanel() {
		setBackground(new Color(255, 250, 205));
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getLblNewLabel_4());
		add(getLblNewLabel_5());
		add(getLblNewLabel_6());
		add(getLblNewLabel_7());
		add(getLblNewLabel_8());
		add(getRExam1());
		add(getRExam2());
		add(getCGrade());
		add(getTSno());
		add(getTmName());
		add(getTKor());
		add(getTEng());
		add(getTMat());
		add(getTTot());
		add(getTAvg());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559      \uBC88");
			lblNewLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
			lblNewLabel.setBounds(12, 13, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC131      \uBA85");
			lblNewLabel_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(12, 48, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC2DC\uD5D8\uC885\uB958");
			lblNewLabel_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(12, 83, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uD559      \uB144");
			lblNewLabel_3.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
			lblNewLabel_3.setBounds(12, 112, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uAD6D      \uC5B4");
			lblNewLabel_4.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
			lblNewLabel_4.setBounds(12, 144, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uC601      \uC5B4");
			lblNewLabel_5.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
			lblNewLabel_5.setBounds(12, 175, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("\uC218      \uD559");
			lblNewLabel_6.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
			lblNewLabel_6.setBounds(12, 210, 57, 15);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("\uCD1D      \uC810");
			lblNewLabel_7.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
			lblNewLabel_7.setBounds(12, 245, 57, 15);
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("\uD3C9      \uADE0");
			lblNewLabel_8.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
			lblNewLabel_8.setBounds(12, 280, 57, 15);
		}
		return lblNewLabel_8;
	}
	private JRadioButton getRExam1() {
		if (rExam1 == null) {
			rExam1 = new JRadioButton("\uC911\uAC04");
			rExam1.setBackground(new Color(255, 250, 205));
			rExam1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
			rExam1.setBounds(72, 79, 57, 23);
			
			group.add(rExam1);
			rExam1.setSelected(true);
		}
		return rExam1;
	}
	private JRadioButton getRExam2() {
		if (rExam2 == null) {
			rExam2 = new JRadioButton("\uAE30\uB9D0");
			rExam2.setBackground(new Color(255, 250, 205));
			rExam2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
			rExam2.setBounds(130, 78, 54, 25);
			
			group.add(rExam2);
		}
		return rExam2;
	}
	private JComboBox getCGrade() {
		if (cGrade == null) {
			cGrade = new JComboBox();
			cGrade.setBackground(SystemColor.menu);
			cGrade.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
			cGrade.setBounds(72, 108, 70, 23);
			
			cGrade.addItem("1ÇÐ³â");
			cGrade.addItem("2ÇÐ³â");
			cGrade.addItem("3ÇÐ³â");
			cGrade.addItem("4ÇÐ³â");
			cGrade.setSelectedIndex(0);
		}
		return cGrade;
	}
	private JTextField getTSno() {
		if (tSno == null) {
			tSno = new JTextField();
			tSno.setBackground(Color.WHITE);
			tSno.setColumns(10);
			tSno.setBounds(72, 10, 105, 21);
		}
		return tSno;
	}
	private JTextField getTmName() {
		if (tmName == null) {
			tmName = new JTextField();
			tmName.setBackground(Color.WHITE);
			tmName.setColumns(10);
			tmName.setBounds(72, 45, 105, 21);
		}
		return tmName;
	}
	private JTextField getTKor() {
		if (tKor == null) {
			tKor = new JTextField();
			tKor.setBackground(Color.WHITE);
			tKor.setColumns(10);
			tKor.setBounds(72, 141, 105, 21);
		}
		return tKor;
	}
	private JTextField getTEng() {
		if (tEng == null) {
			tEng = new JTextField();
			tEng.setBackground(Color.WHITE);
			tEng.setColumns(10);
			tEng.setBounds(72, 172, 105, 21);
		}
		return tEng;
	}
	private JTextField getTMat() {
		if (tMat == null) {
			tMat = new JTextField();
			tMat.setBackground(Color.WHITE);
			tMat.setColumns(10);
			tMat.setBounds(72, 207, 105, 21);
		}
		return tMat;
	}
	private JTextField getTTot() {
		if (tTot == null) {
			tTot = new JTextField();
			tTot.setBackground(Color.WHITE);
			tTot.setEditable(false);
			tTot.setColumns(10);
			tTot.setBounds(72, 242, 105, 21);
		}
		return tTot;
	}
	private JTextField getTAvg() {
		if (tAvg == null) {
			tAvg = new JTextField();
			tAvg.setBackground(Color.WHITE);
			tAvg.setEditable(false);
			tAvg.setColumns(10);
			tAvg.setBounds(72, 277, 105, 21);
		}
		return tAvg;
	}
}
