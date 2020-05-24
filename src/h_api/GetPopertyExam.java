package h_api;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;
import java.awt.event.ActionEvent;

public class GetPopertyExam extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetPopertyExam frame = new GetPopertyExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void view() {
		String msg = "";
		
		String osName = System.getProperty("os.name");
		
		msg += "운영체제 이름 : " + osName + "\n";
		msg += "사용자이름 : " + System.getProperty("user.name") + "\n";
		msg += "사용자 홈 : " + System.getProperty("user.home") + "\n";
		msg += "-------------------------------------\n";
		msg += "[key] value \n";
		msg += "-------------------------------------\n";
		Properties props = System.getProperties();
		Set keys = props.keySet();
		for(Object objKey : keys) {
			String key = (String)objKey;
			String value = System.getProperty(key);
			msg += String.format("[%s] %s \n", key, value); // msg += "["  + key + "]" + value + "\n";
		}
		textArea.setText(msg);
	}
	
	public void viewClass() {
		String msg = "";
		Student st = new Student(0);
		Class clazz1 = st.getClass();
		msg += clazz1.getName() + "\n";
		msg += clazz1.getSimpleName() + "\n";
		msg += clazz1.getPackage().getName() + "\n";
		msg += "--------------------------\n";
		
		try {
			Class clazz2 = Class.forName("sec06.exam01_class.Car");
			msg += clazz2.getName() + "\n";
			msg += clazz2.getSimpleName() + "\n";
			msg += clazz2.getPackage().getName();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(msg);
	}
	
	public void viewReflect() {
		String msg = "";
		Class clazz = Class.forName("h_api.Student");
		
		msg += "[클래스 이름]";
		msg += clazz.getName() + "\n";
		msg += "\n";
		
		msg += "[생성자 정보]";
		Constructor constructor = clazz.getDeclaredConstructor();
		for (Constructor cs : constructor) {
			msg += cs.getName() + "( \n";
			Class[] parameters = cs.getParameterTypes();
			msg += parameters + "\n";
			msg += ") \n";
		}
		msg += "\n";
		
		msg += "[필드정보]" + "\n";
		Field[] fields = clazz.getDeclaredFields();
		for(Field f:fields) {
			msg += f.getType().getSimpleName() + " " + f.getName() + "\n";
		}
		msg += "\n";
		
		msg += "[메소드 정보]" + "\n";
		Method[] methods = clazz.getDeclaredMethods();
		
		for(Method m : methods) {
			msg += m.getName() + "(\n";
			Class[] parameters = m.getParameterTypes();
			printParam(parameters);
			msg += ") \n";
		} 
		
		public String printParam(Class[] parameters) {
		      String str = "";
		      for (int i = 0; i < parameters.length; i++) {
		         str += parameters[i].getName();
		         if (i < (parameters.length - 1)) {
		            str += ",";
		         }
		      }
		      return str;
		   }
	}

	/**
	 * Create the frame.
	 */
	public GetPopertyExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
			panel.add(getBtnNewButton_2());
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC18D\uC131\uBCF4\uAE30");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					view();
				}
			});
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
		}
		return textArea;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Class");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					viewClass();
				}
			});
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uB9AC\uD50C\uB809\uC158");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					viewReflect();
				}
			});
		}
		return btnNewButton_2;
	}
}
