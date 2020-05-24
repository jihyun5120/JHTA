package j_Collection;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MemberMain extends JFrame {
	
	static String idCheck = "\\w{4,10}";
	static String pwdCheck = "[\\w!$] {4,10}";
	static String nameCheck = "[가-휗] {2,10}";
	static String phoneCheck = "\\d{2,3}-\\d{3,4}-\\d{4}";
	
	List<MemberVo> list = new ArrayList<MemberVo>(); //기본크기 10 --> 11개가 되면 10개씩 기본크기만큼늘어남.
	
	Set<ProductVo> piList = new HashSet<ProductVo>(); //입고 리스트
	Set<ProductVo> peList = new HashSet<ProductVo>(); //출고 리스트
	static int iSerial = 1; //입고의 순번
	static int eSerial = 1; //출고의 순번
	
	Map<String, List<ScoreVo>> map = new HashMap<String, List<ScoreVo>>(); //성적관리 (key는 String타입, value는 List타입)
	
	private JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem menuItem;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JLabel lblNewLabel;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JMenuItem mntmNewMenuItem_10;
	private JMenuItem mntmNewMenuItem_11;
	private JMenuItem mntmNewMenuItem_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMain frame = new MemberMain();
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
	public MemberMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 602);
		setJMenuBar(getMenuBar_1());
		contentPane = new JDesktopPane();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		
		//회원관리 MemberVo sample data insert
		for(int i=0; i<500; i++) {
			MemberVo vo = new MemberVo("no"+i, "pwd"+i, "name"+i, "010-1111-"+i);
			list.add(vo);
		}
	
		//ProductVo 입고, 출고 sample data
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0; i<100; i++) {
			String tempSerial = sdf.format(new Date()) + "-" + MemberMain.iSerial; 
			ProductVo vo = new ProductVo(tempSerial, "pCode" + i, "pName" + i, 3000, new Date());
			
			piList.add(vo); //입고리스트에 추가
			peList.add(vo); //출고리스트에 추가
			MemberMain.iSerial++; //입고개수 증가
			MemberMain.eSerial++; //출고개수 증가
		}
		
		//성적관리 sample
		List<ScoreVo> list1 = new ArrayList<ScoreVo>(); //ArrayList 생성.

		//첫번째 학생
		list1.add(new ScoreVo("1", "kim", "중간", 1, 90, 90, 90));
		list1.add(new ScoreVo("1", "kim", "기말", 1, 80, 70, 60));
		list1.add(new ScoreVo("1", "kim", "기말", 2, 50, 60, 70));
		map.put("1", list1); //key 학번
		// 두번째 학생
		list1 = new ArrayList<ScoreVo>();
		list1.add(new ScoreVo("2", "lee", "중간", 3, 90, 80,70));
		list1.add(new ScoreVo("2", "lee", "기말", 3, 80, 70, 60));
		map.put("2", list1);
		//세번째 학생
		list1 = new ArrayList<ScoreVo>();
		list1.add(new ScoreVo("3", "hong", "중간", 2, 40, 50, 80));
		list1.add(new ScoreVo("3", "hong", "기말", 2, 50, 70, 90));
		list1.add(new ScoreVo("3", "hong", "중간", 3, 90, 50, 80));
		map.put("3", list1);
		
	} //생성자 of end	

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(new Color(176, 196, 222));
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
			menuBar.add(getMnNewMenu_2());
			menuBar.add(getMnNewMenu_3());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uD68C\uC6D0\uAD00\uB9AC");
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_2());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uC785\uB825");
			mntmNewMenuItem.setBackground(new Color(240, 248, 255));
			mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\\uC800\uC7A5.111png.png"));
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					MemberInput m = new MemberInput(list);
					contentPane.add(m);
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uC870\uD68C");
			mntmNewMenuItem_1.setBackground(new Color(240, 248, 255));
			mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\\uB3CB\uBCF4\uAE30dfdsfs.png"));
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					MemberSearch m = new MemberSearch(list);
					contentPane.add(m);
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uC218\uC815 \uBC0F \uC0AD\uC81C");
			mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\\uC218ddddddddd\uC815.png"));
			mntmNewMenuItem_2.setBackground(new Color(240, 248, 255));
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberModify m = new MemberModify(list);
					contentPane.add(m);
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("자재관리");
			mnNewMenu_1.add(getMntmNewMenuItem_3());
			mnNewMenu_1.add(getMenuItem());
			mnNewMenu_1.add(getMntmNewMenuItem_4());
			mnNewMenu_1.add(getMntmNewMenuItem_5());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("입고");
			mntmNewMenuItem_3.setBackground(UIManager.getColor("CheckBox.light"));
			mntmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\입고1.png"));
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ProductInput panel = new ProductInput(piList);
					contentPane.add(panel);
					panel.toFront(); // 창을 열었을 때 맨 앞으로(패널을 만들고 사용가능)
				}
			});
		}
		return mntmNewMenuItem_3;
	}
	private JMenuItem getMenuItem() {
		if (menuItem == null) {
			menuItem = new JMenuItem("출고");
			menuItem.setBackground(UIManager.getColor("CheckBox.light"));
			menuItem.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\출고1.png"));
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ProductOutput panel = new ProductOutput(peList);
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return menuItem;
	}
	private JMenuItem getMntmNewMenuItem_4() {
		if (mntmNewMenuItem_4 == null) {
			mntmNewMenuItem_4 = new JMenuItem("조회");
			mntmNewMenuItem_4.setBackground(UIManager.getColor("CheckBox.light"));
			mntmNewMenuItem_4.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\재고조회1.png"));
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ProductSearch panel = new ProductSearch(piList, peList);
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_4;
	}
	private JMenuItem getMntmNewMenuItem_5() {
		if (mntmNewMenuItem_5 == null) {
			mntmNewMenuItem_5 = new JMenuItem("수정 및 삭제");
			mntmNewMenuItem_5.setBackground(UIManager.getColor("CheckBox.light"));
			mntmNewMenuItem_5.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\수정 및 삭제1.png"));
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ProductModify panel = new ProductModify(piList, peList);
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_5;
	}
	private JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("성적관리");
			mnNewMenu_2.add(getMntmNewMenuItem_6());
			mnNewMenu_2.add(getMntmNewMenuItem_7());
		}
		return mnNewMenu_2;
	}
	private JMenuItem getMntmNewMenuItem_6() {
		if (mntmNewMenuItem_6 == null) {
			mntmNewMenuItem_6 = new JMenuItem("입력");
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ScoreInput panel = new ScoreInput(map , MemberMain.this);
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_6;
	}
	private JMenuItem getMntmNewMenuItem_7() {
		if (mntmNewMenuItem_7 == null) {
			mntmNewMenuItem_7 = new JMenuItem("조회");
			mntmNewMenuItem_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreSearch panel = new ScoreSearch(map);
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_7;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(5, 5, 802, 538);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\크리스마스배경.PNG"));
		}
		return lblNewLabel;
	}
	private JMenu getMnNewMenu_3() {
		if (mnNewMenu_3 == null) {
			mnNewMenu_3 = new JMenu("기타 컬렉션");
			mnNewMenu_3.add(getMntmNewMenuItem_8());
			mnNewMenu_3.add(getMntmNewMenuItem_9());
			mnNewMenu_3.add(getMntmNewMenuItem_10());
			mnNewMenu_3.add(getMntmNewMenuItem_11());
			mnNewMenu_3.add(getMntmNewMenuItem_12());
		}
		return mnNewMenu_3;
	}
	private JMenuItem getMntmNewMenuItem_8() {
		if (mntmNewMenuItem_8 == null) {
			mntmNewMenuItem_8 = new JMenuItem("Properties");
			mntmNewMenuItem_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PropertiesFrame panel = new PropertiesFrame();
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_8;
	}
	private JMenuItem getMntmNewMenuItem_9() {
		if (mntmNewMenuItem_9 == null) {
			mntmNewMenuItem_9 = new JMenuItem("TreeSet");
			mntmNewMenuItem_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TreeSetFrame panel = new TreeSetFrame();
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_9;
	}
	private JMenuItem getMntmNewMenuItem_10() {
		if (mntmNewMenuItem_10 == null) {
			mntmNewMenuItem_10 = new JMenuItem("TreeMap");
			mntmNewMenuItem_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TreeMapFrame panel = new TreeMapFrame();
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_10;
	}
	private JMenuItem getMntmNewMenuItem_11() {
		if (mntmNewMenuItem_11 == null) {
			mntmNewMenuItem_11 = new JMenuItem("Stack");
			mntmNewMenuItem_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StackFrame panel = new StackFrame();
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_11;
	}
	private JMenuItem getMntmNewMenuItem_12() {
		if (mntmNewMenuItem_12 == null) {
			mntmNewMenuItem_12 = new JMenuItem("Queue");
			mntmNewMenuItem_12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QueueFrame panel = new QueueFrame();
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_12;
	}
}
