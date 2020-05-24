package semishit;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SemiMain extends JFrame implements Runnable{
	String s = login.idck;
	public JDesktopPane contentPane;
	private JLabel visible1;
	private JLabel visible2;
	private JLabel visible3;
	private JLabel status;
	private JLabel bg1;
	private JLabel bg2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_1;
	private JLabel label_10;
	private JLabel lblNewLabel_2;
	private JLabel label_9;
	private JLabel label_11;
	private JLabel timer;
	static String welcome = "";
	private JLabel loginbg;
	private JLabel lblAsdfasf;
	static public JButton btnNewButton;
	private JLabel logo;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemiMain frame = new SemiMain();
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
	public SemiMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\JHTA\\Downloads\\\uC0AC\uC9C4\\\uBA54\uC778\uCC3D\\\uB85C\uACE0.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				login l = new login();
				contentPane.add(l);
				l.toFront();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1212, 786);
		contentPane = new JDesktopPane();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getLoginbg());
		contentPane.add(getBtnNewButton());
		contentPane.add(getLogo());
		contentPane.add(getLblAsdfasf());
		contentPane.add(getVisible1());
		contentPane.add(getVisible2());
		contentPane.add(getVisible3());
		contentPane.add(getLabel_3_1());
		contentPane.add(getLabel_4());
		contentPane.add(getLabel_5());
		contentPane.add(getTimer());
		contentPane.add(getLabel_9_2());
		contentPane.add(getLabel_9_1());
		contentPane.add(getLabel_10());
		contentPane.add(getLabel_7());
		contentPane.add(getLabel_8());
		contentPane.add(getLabel_1());
		contentPane.add(getStatus());
		contentPane.add(getLabel_3());
		contentPane.add(getLabel_2_1());
		contentPane.add(getLabel_11());
		Thread t = new Thread(this);
		t.start();
		
		Toolkit toolkit = Toolkit.getDefaultToolkit(); 
		Image image = toolkit.getImage("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\마우스커서.png");
		Cursor cursor = toolkit.createCustomCursor(image, new Point(contentPane.getX(),contentPane.getY()), "image");
		contentPane.setCursor(cursor);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		
		
	}
	private JLabel getVisible1() {
		if (visible1 == null) {
			visible1 = new JLabel("\uACF5\uC9C0\uC0AC\uD56D");
			visible1.setVerticalAlignment(SwingConstants.BOTTOM);
			visible1.setFont(new Font("12롯데마트드림Bold", Font.BOLD, 24));
			visible1.setHorizontalAlignment(SwingConstants.CENTER);
			visible1.setForeground(new Color(255, 255, 255));
			visible1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					BoardList bl = new BoardList();
					contentPane.add(bl);
					bl.toFront();
				}
			});
			visible1.setBounds(845, 112, 152, 144);
		}
		return visible1;
	}
	private JLabel getVisible2() {
		if (visible2 == null) {
			visible2 = new JLabel("\uB85C\uADF8\uC544\uC6C3");
			visible2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					login l = new login();
					loginbg.setVisible(true);
					contentPane.add(l);
					l.toFront();
				}
			});
			visible2.setVerticalAlignment(SwingConstants.BOTTOM);
			visible2.setFont(new Font("12롯데마트드림Bold", Font.BOLD, 24));
			visible2.setHorizontalAlignment(SwingConstants.CENTER);
			visible2.setForeground(new Color(255, 255, 255));
			visible2.setBounds(1005, 113, 153, 143);
		}
		return visible2;
	}
	private JLabel getVisible3() {
		if (visible3 == null) {
			visible3 = new JLabel("\uC9C1\uC6D0\uAD00\uB9AC");
			visible3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Emplyoees em = new Emplyoees();
					contentPane.add(em);
					em.toFront();
				}
			});
			visible3.setVerticalAlignment(SwingConstants.BOTTOM);
			visible3.setFont(new Font("12롯데마트드림Bold", Font.BOLD, 24));
			visible3.setHorizontalAlignment(SwingConstants.CENTER);
			visible3.setForeground(new Color(255, 255, 255));
			visible3.setBounds(846, 268, 150, 141);
		}
		return visible3;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			status.setOpaque(true);
			status.setBackground(new Color(211, 211, 211));
			status.setBounds(0, 0, 1196, 15);
			
		}
		return status;
	}
	public void setStatus(JLabel status) {
		this.status = status;
	}

	private JLabel getLabel_3() {
		if (bg1 == null) {
			bg1 = new JLabel("");
			bg1.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\\uD30C\uB780\uAC70.png"));
			bg1.setBounds(-12, 96, 1230, 335);
		}
		return bg1;
	}
	private JLabel getLabel_2_1() {
		if (bg2 == null) {
			bg2 = new JLabel("");
			bg2.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\\uBE68\uAC04\uAC70.png"));
			bg2.setBounds(0, 430, 1331, 318);
		}
		return bg2;
	}
	private JLabel getLabel_3_1() {
		if (label_3 == null) {
			label_3 = new JLabel("\uD559\uC0DD\uAD00\uB9AC");
			label_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					StudentM sm = new StudentM();
					contentPane.add(sm);
					sm.toFront();
				}
			});
			label_3.setVerticalAlignment(SwingConstants.BOTTOM);
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setForeground(Color.WHITE);
			label_3.setFont(new Font("12롯데마트드림Bold", Font.BOLD, 24));
			label_3.setBounds(846, 439, 150, 141);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC131\uC801\uAD00\uB9AC");
			label_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SC_search ss = new SC_search();
					contentPane.add(ss);
					ss.toFront();
					
				}
			});
			label_4.setVerticalAlignment(SwingConstants.BOTTOM);
			label_4.setHorizontalAlignment(SwingConstants.CENTER);
			label_4.setForeground(Color.WHITE);
			label_4.setFont(new Font("12롯데마트드림Bold", Font.BOLD, 24));
			label_4.setBounds(1003, 439, 150, 141);
		}
		return label_4;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uBE44\uD488\uAD00\uB9AC");
			label_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ProductSelect ps = new ProductSelect();
					contentPane.add(ps);
					ps.toFront();
				}
			});
			label_5.setVerticalAlignment(SwingConstants.BOTTOM);
			label_5.setHorizontalAlignment(SwingConstants.CENTER);
			label_5.setForeground(Color.WHITE);
			label_5.setFont(new Font("12롯데마트드림Bold", Font.BOLD, 24));
			label_5.setBounds(846, 592, 150, 141);
		}
		return label_5;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("");
			label_7.setVerticalAlignment(SwingConstants.TOP);
			label_7.setHorizontalAlignment(SwingConstants.CENTER);
			label_7.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\\uACF5\uC9C0\uC0AC\uD56D.png"));
			label_7.setBounds(844, 123, 148, 138);
		}
		return label_7;
	}
	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("");
			label_8.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\\uC544\uC6C3.png"));
			label_8.setBounds(1032, 114, 111, 113);
		}
		return label_8;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\\uC9C1\uC6D0.png"));
			label_1.setBounds(871, 270, 116, 118);
		}
		return label_1;
	}
	private JLabel getLabel_10() {
		if (label_10 == null) {
			label_10 = new JLabel("");
			label_10.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\\uD559\uC0AC\uBAA8\uC624.png"));
			label_10.setBounds(867, 449, 116, 107);
		}
		return label_10;
	}
	private JLabel getLabel_9_1() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\\uC131\uC801.png"));
			lblNewLabel_2.setBounds(1027, 452, 102, 102);
		}
		return lblNewLabel_2;
	}
	private JLabel getLabel_9_2() {
		if (label_9 == null) {
			label_9 = new JLabel("");
			label_9.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\\uC790.png"));
			label_9.setBounds(868, 587, 113, 129);
		}
		return label_9;
	}
	private JLabel getLabel_11() {
		if (label_11 == null) {
			label_11 = new JLabel("\uD68C\uC6D0 \uAD00\uB9AC");
			label_11.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 28));
			label_11.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MemberUpdateDelete mud = new MemberUpdateDelete();
					contentPane.add(mud);
					mud.toFront();
				}
			});
			label_11.setBounds(1047, 39, 105, 34);
		}
		return label_11;
	}
	private JLabel getTimer() {
		if (timer == null) {
			timer = new JLabel("00:00:00");
			timer.setHorizontalAlignment(SwingConstants.RIGHT);
			timer.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			timer.setBounds(1047, -7, 148, 28);
		}
		return timer;
	}

	@Override
	public void run() {
		while(true) {
			Calendar cal = Calendar.getInstance();
			String h = cal.get(Calendar.HOUR_OF_DAY)+"";
			String m = cal.get(Calendar.MINUTE)+"";
			String s = cal.get(Calendar.SECOND)+"";
			
			if(h.length()==1) {h = "0"+h;}
			if(m.length()==1) {m = "0"+m;}
			if(s.length()==1) {s = "0"+s;}
			String time = h + ":" + m + ":" +s;
			timer.setText(time);
			status.setText(welcome+"님 환영합니다!!");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	private JLabel getLoginbg() {
		if (loginbg == null) {
			loginbg = new JLabel("");
			loginbg.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\realmain.gif"));
			loginbg.setBackground(new Color(255, 255, 255));
			loginbg.setBounds(1, -1, 1196, 748);
		}
		return loginbg;
	}
	private JLabel getLblAsdfasf() {
		if (lblAsdfasf == null) {
			lblAsdfasf = new JLabel("");
			lblAsdfasf.setForeground(new Color(255, 255, 255));
			lblAsdfasf.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 64));
			lblAsdfasf.setBounds(211, 164, 543, 196);
		}
		return lblAsdfasf;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uBCF4\uC774\uBA74 0\uC810");
			btnNewButton.setVisible(false);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loginbg.setVisible(false);
				}
			});
			btnNewButton.setBounds(12, 278, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getLogo() {
		if (logo == null) {
			logo = new JLabel("");
			logo.setIcon(new ImageIcon("C:\\Users\\JHTA\\eclipse-workspace\\1907-java\\pics\\\uB274\uB85C\uACE0.gif"));
			logo.setBounds(-14, -61, 587, 251);
		}
		return logo;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0 \uC870\uD68C");
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				JoinSearch js = new JoinSearch();
				contentPane.add(js);
				js.toFront();
				}
				
			});
			lblNewLabel.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 28));
			lblNewLabel.setBounds(917, 41, 132, 30);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("asdf");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Webview wv = new Webview();
					contentPane.add(wv);
					wv.toFront();
				}
			});
			btnNewButton_1.setBounds(402, 50, 97, 23);
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC7AC\uBB34 \uAD00\uB9AC");
			lblNewLabel_1.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 28));
			lblNewLabel_1.setBounds(783, 39, 105, 34);
		}
		return lblNewLabel_1;
	}
}
