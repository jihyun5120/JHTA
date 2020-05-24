package semishit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

public class StuAttendance extends JDialog implements ActionListener {
	String titleStr[] = { "일", "월", "화", "수", "목", "금", "토" };
	int ck = -1;
	DefaultComboBoxModel<Integer> yearmodel = new DefaultComboBoxModel<Integer>();
	DefaultComboBoxModel<Integer> monthmodel = new DefaultComboBoxModel<Integer>();
	private final JPanel contentPanel = new JPanel();
	public JTextField sno;
	private JScrollPane scrollPane;
	private JTextArea status;
	private JLabel lblNewLabel_1;
	JPanel topPane = new JPanel();
	JPanel panel = new JPanel();
	private JPanel panCal;
	JPanel panCal1 = new JPanel();
	Integer day;
	Calendar now;
	Calendar cal;
	int year, month, date = 0;
	JButton prevBtn = new JButton("\u25C0");
	JButton nextBtn = new JButton("\u25B6");
	private final JLabel lblNewLabel_2 = new JLabel("\uB4F1\uAD50\uC2DC\uAC04");
	private final JLabel lblNewLabel_3 = new JLabel("\uD558\uAD50\uC2DC\uAC04");
	private final JTextField stin = new JTextField();
	private final JTextField stout = new JTextField();
	private JComboBox yearcombo;
	private JComboBox monthcombo;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");

	JButton[] bo = new JButton[49];
	JPanel titlePane = new JPanel(new GridLayout(1, 7));
	JPanel datePane = new JPanel(new GridLayout(0, 7));
	private JButton addBtn;
	private JButton delBtn;
	private JLabel lblNewLabel_4;
	private JTextField sdate;
	String ill = "";
	StudentSelect ss = new StudentSelect();
	CalendarDao dao = new CalendarDao();
	CalendarVo1 vo = new CalendarVo1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StuAttendance dialog = new StuAttendance();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StuAttendance() {
		setVisible(true);
		Color c = new Color(255, 204, 051);
		stout.setBounds(62, 85, 126, 21);
		stout.setColumns(10);
		stin.setBounds(62, 60, 126, 21);
		stin.setColumns(10);
		setBounds(100, 100, 733, 511);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		topPane.setBackground(new Color(245, 222, 179));

		topPane.setBorder(new LineBorder(new Color(255, 140, 0), 2));
		topPane.setPreferredSize(new Dimension(10, 80));
		contentPanel.add(topPane, BorderLayout.NORTH);
		topPane.setLayout(null);
		prevBtn.setForeground(new Color(255, 255, 255));
		prevBtn.setBackground(new Color(211, 211, 211));

		prevBtn.setBounds(165, 9, 79, 50);
		topPane.add(prevBtn);
		nextBtn.setForeground(new Color(255, 255, 255));
		nextBtn.setBackground(new Color(211, 211, 211));

		nextBtn.setBounds(444, 9, 79, 50);
		topPane.add(nextBtn);
		topPane.add(getYearcombo());
		topPane.add(getMonthcombo());
		panel.setBackground(new Color(245, 222, 179));

		panel.setBorder(new LineBorder(new Color(255, 140, 0), 2));
		panel.setPreferredSize(new Dimension(200, 10));
		contentPanel.add(panel, BorderLayout.EAST);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uD559\uBC88");
		lblNewLabel.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(20, 10, 37, 15);
		panel.add(lblNewLabel);

		sno = new JTextField();
		sno.setBounds(62, 7, 126, 21);
		panel.add(sno);
		sno.setColumns(10);

		panel.add(getScrollPane());
		panel.add(getLblNewLabel_1());
		lblNewLabel_2.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(0, 63, 57, 15);

		panel.add(lblNewLabel_2);
		lblNewLabel_3.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(0, 88, 57, 15);

		panel.add(lblNewLabel_3);

		panel.add(stin);

		panel.add(stout);
		panel.add(getAddBtn());
		panel.add(getDelBtn());
		panel.add(getLblNewLabel_4());
		panel.add(getSdate());

		panCal1.setBorder(new LineBorder(new Color(255, 140, 0), 2));
		contentPanel.add(panCal1, BorderLayout.CENTER);
		panCal1.setLayout(new BorderLayout(0, 0));

		///////////////////////////////////////////////////

		panCal = new JPanel(new GridLayout(0, 7));

		now = Calendar.getInstance();
		year = now.get(Calendar.YEAR);
		month = now.get(Calendar.MONTH) + 1;
		date = now.get(Calendar.DATE);

		titlePane.setBackground(Color.white);
		for (int i = 0; i < titleStr.length; i++) {
			JLabel lbl = new JLabel(titleStr[i], JLabel.CENTER);
			if (i == 0) {
				lbl.setForeground(Color.red);
			} else if (i == 6) {
				lbl.setForeground(Color.blue);
			}
			titlePane.add(lbl);
		}
		panCal1.add(titlePane, "North");

		// dayprint
		dayPrint(year, month);
		datePane.setBackground(Color.WHITE);
		panCal1.add(datePane, "Center");

		// ActionListener
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		yearcombo.addActionListener(this);
		monthcombo.addActionListener(this);

		addBtn.addActionListener(this);
		delBtn.addActionListener(this);

	}

	public void dayPrint(int year, int month) {

		CalendarDao dao = new CalendarDao();
		Calendar cal = Calendar.getInstance();

		String st1 = yearcombo.getSelectedItem().toString();
		String st2 = monthcombo.getSelectedItem().toString();
		if (st2.length() == 1) {
			st2 = "0" + st2;
		}

		String st3 = st1 + "-" + st2 + "-";
		String ssno = ss.getNom();
		String nill = "";

		cal.set(year, month - 1, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		for (int i = 1; i < week; i++) {
			datePane.add(new JLabel(" "));
		}
		for (int i = 0; i <= lastDate - 1; i++) {
			bo[i] = new JButton(String.valueOf(i + 1));
			bo[i].addActionListener(this);
			bo[i].setBackground(Color.white);
			cal.set(year, month - 1, 1);
			datePane.add(bo[i]);
			nill = Integer.toString(i + 1);
			if (nill.length() == 1) {
				nill = "0" + nill;
			}
			int r = dao.check(ssno + st3 + nill);
			CalendarVo1 cvo = dao.Com(ssno + st3 + nill);
			ck = r;
			Color a = new Color(51, 153, 0);
			if (ck == 1) {
				bo[i].setForeground(Color.white);
				Date d = cvo.getStin();
				Date d2 = cvo.getStout();
				d = compareDate(d);
				d2 = compareDate2(d2);
				// 지각/조퇴 체크
				if (cvo.getStin().compareTo(d) < 1 && cvo.getStout().compareTo(d2) >= 0) {
					bo[i].setBackground(a);
				} else {
					bo[i].setBackground(Color.red);
				}
			}

		}

	}

	public Date compareDate(Date d) {
		Date  dB = new Date();
		SimpleDateFormat asdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(d);
		str += " 09:00:00";
		try {
			dB = asdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("dB: " + dB);

		return dB;
	}
	
	public Date compareDate2(Date d) {
		Date  dB = new Date();
		SimpleDateFormat asdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(d);
		str += " 18:00:00";
		try {
			dB = asdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("dB: " + dB);

		return dB;
	}
	

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 194, 176, 132);
			scrollPane.setViewportView(getStatus());
		}
		return scrollPane;
	}

	private JTextArea getStatus() {
		if (status == null) {
			status = new JTextArea();
		}
		return status;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD2B9\uC774\uC0AC\uD56D");
			lblNewLabel_1.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(72, 169, 57, 15);
		}
		return lblNewLabel_1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj instanceof JButton) {
			JButton eventBtn = (JButton) obj;
			int yy = (Integer) yearcombo.getSelectedItem();
			int mm = (Integer) monthcombo.getSelectedItem();
			String m = "";
			if (eventBtn.equals(prevBtn)) {
				if (mm == 1) {
					yy--;
					mm = 12;
				} else {
					mm--;
				}
			} else if (eventBtn.equals(nextBtn)) {
				if (mm == 12) {
					yy++;
					mm = 1;

				} else {
					mm++;
				}
			} else if (eventBtn.equals(addBtn)) {
				System.out.println("애드버튼");
			} else if (eventBtn.equals(delBtn)) {
				System.out.println("델리트버튼");
			} else if (Integer.parseInt(e.getActionCommand()) >= 1 && Integer.parseInt(e.getActionCommand()) <= 31) {
				System.out.println("여기도 지나감");
				sdate.setText("");
				stin.setText("");
				stout.setText("");
				status.setText("");
				ill = eventBtn.getActionCommand();
				if (ill.length() == 1) {
					ill = "0" + ill;
				}

				if (monthcombo.getSelectedItem().toString().length() == 1) {
					m = "0" + monthcombo.getSelectedItem().toString();
				}
				sdate.setText(yearcombo.getSelectedItem().toString() + "-" + m + "-" + ill);

				try {
					vo = dao.search(sno.getText() + sdate.getText());
					stin.setText(sdf1.format(vo.getStin()));
					stout.setText(sdf1.format(vo.getStout()));
					status.setText(vo.getStatus());
				} catch (Exception e2) {
					System.out.println("출석 정보 없는 칸");
				}
			}

			yearcombo.setSelectedItem(yy);
			monthcombo.setSelectedItem(mm);
		} else if (obj instanceof JComboBox) {
			createDayStart();
		}

	}

	public void createDayStart() {
		datePane.setVisible(false);

		datePane.removeAll();
		dayPrint((Integer) yearcombo.getSelectedItem(), (Integer) monthcombo.getSelectedItem());
		datePane.setVisible(true);
	}

	private JComboBox getYearcombo() {
		if (yearcombo == null) {
			yearcombo = new JComboBox();
			yearcombo.setForeground(Color.WHITE);
			yearcombo.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			yearcombo.setBackground(Color.PINK);
			yearcombo.setBounds(246, 9, 116, 50);
			now = Calendar.getInstance();
			year = now.get(Calendar.YEAR);
			month = now.get(Calendar.MONTH) + 1;
			date = now.get(Calendar.DATE);
			// 콤보 년 추가
			for (int i = year - 100; i <= year + 50; i++) {
				yearmodel.addElement(i);
			}
			yearcombo.setModel(yearmodel);
			yearcombo.setSelectedItem(year);
		}
		return yearcombo;
	}

	private JComboBox getMonthcombo() {
		if (monthcombo == null) {
			monthcombo = new JComboBox();
			monthcombo.setForeground(Color.WHITE);
			monthcombo.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			monthcombo.setBackground(Color.PINK);
			monthcombo.setBounds(363, 9, 79, 50);
			now = Calendar.getInstance();
			year = now.get(Calendar.YEAR);
			month = now.get(Calendar.MONTH) + 1;
			date = now.get(Calendar.DATE);
			// 콤보 월 추가
			for (int i = 1; i <= 12; i++) {
				monthmodel.addElement(i);
			}
			monthcombo.setModel(monthmodel);
			monthcombo.setSelectedItem(month);
		}
		return monthcombo;
	}

	private JButton getAddBtn() {
		if (addBtn == null) {
			addBtn = new JButton("\uCD94\uAC00/\uC218\uC815");
			addBtn.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String no0 = sno.getText();
					int no = Integer.parseInt(no0);
					Date nal = new Date();
					Date nalin = new Date();
					Date nalout = new Date();

					String d = sdate.getText(); // stdate 값
					String in = d + " " + stin.getText();
					String out = d + " " + stout.getText();
					String str = status.getText();

					System.out.println(in);
					System.out.println(out);
					try {
						nal = sdf.parse(d);
						nalin = sdf1.parse(in);
						nalout = sdf1.parse(out);
					} catch (ParseException e) {
						e.printStackTrace();
					}

					CalendarVo1 vo = new CalendarVo1(no, nal, nalin, nalout, str);
					CalendarDao dao = new CalendarDao();
					if (no0.length() == 1) {
						no0 = "0" + no0;
					}
					int r = dao.check(no0 + d);
					if (r == 0) {
						int i = dao.Cinput(vo);
						System.out.println("입력완료");
					} else {
						dao.update(vo);
						System.out.println("수정완료");
					}

					createDayStart();

				}
			});
			addBtn.setBounds(3, 336, 97, 23);
		}
		return addBtn;
	}

	private JButton getDelBtn() {
		if (delBtn == null) {
			delBtn = new JButton("\uC0AD\uC81C");
			delBtn.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			delBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CalendarDao dao = new CalendarDao();
					String no = sno.getText();
					String rd = sdate.getText();
					String nr = no + rd;

					int r = dao.delete(nr);
					createDayStart();
				}
			});
			delBtn.setBounds(101, 336, 95, 23);
		}
		return delBtn;
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uB0A0\uC9DC");
			lblNewLabel_4.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4.setBounds(0, 38, 57, 15);
		}
		return lblNewLabel_4;
	}

	private JTextField getSdate() {
		if (sdate == null) {
			sdate = new JTextField();
			sdate.setBounds(62, 35, 126, 21);
			sdate.setColumns(10);
		}
		return sdate;
	}
}
