package j_Collection;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductOutput extends JInternalFrame {
	Set<ProductVo> peList;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField pCode;
	private JTextField pName;
	private JTextField ea;
	private JTextField nal;
	private JButton btnNewButton;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductOutput frame = new ProductOutput();
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
	public ProductOutput() {
		super("제품출고", false, true, true, true);
		getContentPane().setFont(new Font("나눔스퀘어라운드 Light", Font.BOLD, 13));
		setVisible(true);
		getContentPane().setBackground(new Color(144, 238, 144));
		setBounds(100, 100, 360, 275);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getPCode());
		getContentPane().add(getPName());
		getContentPane().add(getEa());
		getContentPane().add(getNal());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getStatus());

	}

	public ProductOutput(Set<ProductVo> pe) {
		this();
		this.peList = pe;
	}

	public void Output() {
		// 폼의 값을 가져다 ProductVo 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if(pCode.getText().equals("") || pName.getText().equals("") || ea.getText().equals("") || nal.getText().equals("")) {
			status.setText("입력항목에 오류가 있습니다.");
			pCode.requestFocus();
			return;
		}
		
		try {
			String serial = sdf.format(new Date()) + "-" + MemberMain.eSerial;
			String pC = pCode.getText();
			String pN = pName.getText();
			int e = Integer.parseInt(ea.getText());
			Date n = sdf.parse(nal.getText());
			
			// peList에 추가
			ProductVo vo = new ProductVo(serial, pC, pN, e, n);
			peList.add(vo);
			
			MemberMain.eSerial++;
			status.setText("출고 자료가 정상적으로 입력되었습니다.");
			pName.setText("");
			ea.setText("");
			pCode.requestFocus();
			pCode.selectAll();

		} catch (ParseException e1) {
			status.setText("날짜 형식을 yyyy-MM-dd 로 입력해주세요.");
			nal.requestFocus();
			nal.selectAll();
		}catch (NumberFormatException e2) {
			status.setText("숫자만 입력해주세요.");
			ea.requestFocus();
			ea.selectAll();
		}
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC81C\uD488\uCF54\uB4DC");
			lblNewLabel.setFont(new Font("나눔스퀘어라운드 Light", Font.BOLD, 13));
			lblNewLabel.setBounds(28, 21, 57, 15);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC81C \uD488 \uBA85");
			lblNewLabel_1.setFont(new Font("나눔스퀘어라운드 Light", Font.BOLD, 13));
			lblNewLabel_1.setBounds(28, 59, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uCD9C\uACE0\uC218\uB7C9");
			lblNewLabel_2.setFont(new Font("나눔스퀘어라운드 Light", Font.BOLD, 13));
			lblNewLabel_2.setBounds(28, 102, 57, 15);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uCD9C\uACE0\uB0A0\uC9DC");
			lblNewLabel_3.setFont(new Font("나눔스퀘어라운드 Light", Font.BOLD, 13));
			lblNewLabel_3.setBounds(28, 146, 57, 15);
		}
		return lblNewLabel_3;
	}

	private JTextField getPCode() {
		if (pCode == null) {
			pCode = new JTextField();
			pCode.setRequestFocusEnabled(false);
			pCode.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			pCode.setHorizontalAlignment(SwingConstants.CENTER);
			pCode.setBounds(99, 18, 144, 21);
			pCode.setColumns(10);
		}
		return pCode;
	}

	private JTextField getPName() {
		if (pName == null) {
			pName = new JTextField();
			pName.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			pName.setHorizontalAlignment(SwingConstants.CENTER);
			pName.setBounds(97, 56, 146, 21);
			pName.setColumns(10);
		}
		return pName;
	}

	private JTextField getEa() {
		if (ea == null) {
			ea = new JTextField();
			ea.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			ea.setHorizontalAlignment(SwingConstants.CENTER);
			ea.setBounds(97, 99, 146, 21);
			ea.setColumns(10);
		}
		return ea;
	}

	private JTextField getNal() {
		if (nal == null) {
			nal = new JTextField();
			nal.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			nal.setHorizontalAlignment(SwingConstants.CENTER);
			nal.setBounds(97, 143, 146, 21);
			nal.setColumns(10);

			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			nal.setText(sdf.format(new Date()));
		}
		return nal;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCD9C\uACE0");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Output();
				}
			});
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 12));
			btnNewButton.setBounds(124, 174, 97, 23);
		}
		return btnNewButton;
	}

	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setFont(new Font("나눔스퀘어라운드 Light", Font.BOLD, 12));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBounds(12, 207, 319, 25);
		}
		return status;
	}
}
