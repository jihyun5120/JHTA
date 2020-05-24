package k_io;

import java.awt.EventQueue;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import org.omg.Messaging.SyncScopeHelper;

import h_api.Member;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class MemberModify extends JInternalFrame {
	List<MemberVo> list;// 검색, 수정, 삭제에 모두 쓰여서 필드로 뺌.
	int index = -1;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JTextField mid;
	private JTextField pwd;
	private JTextField mName;
	private JTextField phone;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberModify frame = new MemberModify();
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
	public MemberModify() {
		super("회원 정보 수정 및 삭제", false, true, true, true);
		getContentPane().setBackground(new Color(154, 205, 50));
		setVisible(true);
		setBounds(300, 100, 352, 303);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getMid());
		getContentPane().add(getPwd());
		getContentPane().add(getMName());
		getContentPane().add(getPhone());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getStatus());
	}

	public void search() { // 검색
		index = -1;
		pwd.setText("");
		mName.setText("");
		phone.setText("");

		String find = mid.getText();
		MemberDao dao = new MemberDao();
		MemberVo vo = dao.search(find); //MemberDao클래스 search메소드의 반환형이 MemberVo 타입.

			if (vo != null) {
				pwd.setText(vo.getPwd());
				mName.setText(vo.getmNmae());
				phone.setText(vo.getPhone());

				status.setText("정보가 검색되었습니다.");

			} else {
				status.setBackground(Color.YELLOW);
				status.setText("찾는 정보가 없습니다.");

				mid.requestFocus();
				mid.selectAll();
			}
		}

	public void modify() { // 수정
		String id = mid.getText();
		String p = pwd.getText();
		String n = mName.getText();
		String ph = phone.getText();

		boolean flag = Pattern.matches(FileExam2.idCheck, id) &&
				       Pattern.matches(FileExam2.pwdCheck, p) &&
				       Pattern.matches(FileExam2.nameCheck, n) &&
				       Pattern.matches(FileExam2.phoneCheck, ph);
		
		if (flag) {
			MemberVo vo = new MemberVo(id, p, n, ph);
			MemberDao dao = new MemberDao();
			boolean b = dao.modify(vo);
			if(b) {
				status.setText("정보가 수정되었습니다");
				mid.requestFocus();
				mid.selectAll();	
			} else {
				status.setBackground(Color.YELLOW);
				status.setText("저장 중 오류가 발생했습니다.");
			}
		} else {
			status.setBackground(Color.YELLOW);
			status.setText("입력 창을 확인해주세요.");
		}

	}

	public void delete() { // 삭제
		String findMid = mid.getText();
		MemberDao dao = new MemberDao();
		boolean b = dao.delete(findMid);
		if(b) {
			status.setText("정보가 삭제되었습니다.");
			mid.requestFocus();

			mid.setText("");
			pwd.setText("");
			mName.setText("");
			phone.setText("");

			mid.requestFocus();
			mid.selectAll();
		} else {
			status.setBackground(Color.YELLOW);
			status.setText("자료 삭제 중 오류가 발생했습니다.");
		}

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544  \uC774  \uB514");
			lblNewLabel.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 13));
			lblNewLabel.setBounds(12, 35, 57, 15);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
			lblNewLabel_1.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 13));
			lblNewLabel_1.setBounds(12, 80, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC774      \uB984");
			lblNewLabel_2.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 13));
			lblNewLabel_2.setBounds(12, 125, 57, 15);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC804\uD654\uBC88\uD638");
			lblNewLabel_3.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 13));
			lblNewLabel_3.setBounds(12, 170, 57, 15);
		}
		return lblNewLabel_3;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC218\uC815");
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setIcon(new ImageIcon(
					"C:\\Users\\Public\\Pictures\\Sample Pictures\\\uC218dddddddddddddddddddddddd\uC815.png"));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modify();
				}
			});
			btnNewButton.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 12));
			btnNewButton.setBounds(227, 163, 97, 29);
		}
		return btnNewButton;
	}

	private JTextField getMid() {
		if (mid == null) {
			mid = new JTextField();
			mid.setBounds(81, 31, 116, 21);
			mid.setColumns(10);
		}
		return mid;
	}

	private JTextField getPwd() {
		if (pwd == null) {
			pwd = new JTextField();
			pwd.setBounds(81, 76, 116, 21);
			pwd.setColumns(10);
		}
		return pwd;
	}

	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(81, 121, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}

	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setBounds(81, 166, 116, 21);
			phone.setColumns(10);
		}
		return phone;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC0AD\uC81C");
			btnNewButton_1.setBackground(new Color(255, 255, 255));
			btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\\uC0ADd\uC81C.png"));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					delete();
				}
			});
			btnNewButton_1.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 12));
			btnNewButton_1.setBounds(227, 196, 97, 29);
		}
		return btnNewButton_1;
	}

	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uAC80\uC0C9");
			btnNewButton_2.setBackground(new Color(255, 255, 255));
			btnNewButton_2
					.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\\uB3CB\uBCF4\uAE301.png"));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					search();
				}
			});
			btnNewButton_2.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 12));
			btnNewButton_2.setBounds(210, 31, 97, 23);
		}
		return btnNewButton_2;
	}

	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setForeground(new Color(70, 130, 180));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 14));
			status.setOpaque(true);
			status.setBounds(12, 235, 312, 29);
		}
		return status;
	}
}
