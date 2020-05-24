package j_Collection;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.sql.rowset.serial.SerialArray;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.security.acl.Group;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductModify extends JInternalFrame {
	//조회, 수정 및 삭제에 입고, 출고 데이터가 모두 필요.
	Set<ProductVo> piList;
	Set<ProductVo> peList;
	
	Set<ProductVo> list; // 검색, 수정, 삭제에서 사용해야 해서 필드에서 호출.
	ButtonGroup group = new ButtonGroup();
	ProductVo oldVo; //수정 및 삭제 전.
	
	private JLabel lblNewLabel;
	private JRadioButton imBtn;
	private JRadioButton exBtn;
	private JLabel lblNewLabel_1;
	private JTextField serial;
	private JButton btnNewButton;
	private JSeparator separator;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField pCode;
	private JTextField pName;
	private JTextField ea;
	private JTextField nal;
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
					ProductModify frame = new ProductModify();
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
	public ProductModify() {
		super("제품 수정 | 삭제", false, true, true, true);
		getContentPane().setBackground(new Color(144, 238, 144));
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getImBtn());
		getContentPane().add(getExBtn());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getSerial());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getSeparator());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getLblNewLabel_5());
		getContentPane().add(getPCode());
		getContentPane().add(getPName());
		getContentPane().add(getEa());
		getContentPane().add(getNal());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getStatus());
		setVisible(true);
		setBounds(100, 100, 332, 301);
	}
	
	public ProductModify(Set<ProductVo> pi, Set<ProductVo> pe) {
		this();
		this.piList = pi;
		this.peList = pe;
	}
	
	public void search() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 수정에서도 필요하기 때문에 필드에 넣으면 더 편함.
		
		if(imBtn.isSelected()) {
			list = piList; //입고목록에서 검색.
		} else {
			list = peList; //출고목록에서 검색.
		}
		
		String find = serial.getText();
		oldVo = null; // 두 번째 찾을 때 못 찾아도 그 전에 데이터를 가져오기 때문에 초기화를 시켜줘야 함.
		status.setText("자료를 검색중입니다.");
		
		// 향상된 for문으로 검색하는 방법.
		for(ProductVo vo : list) {
			if(vo.getSerial().equals(find)) {
				oldVo = vo;
				pCode.setText(vo.getpCode());
				pName.setText(vo.getpName());
				ea.setText(String.valueOf(vo.getEa())); // ea.setText(vo.getEa() + ""); 도 가능.
				nal.setText(sdf.format(vo.getNal()));
				status.setText("자료가 검색되었습니다.");
				break;
			}
		}
		//iterator() 으로 검색하는 방법.
//		String find = serial.getText();
//		Iterator<ProductVo> iter = list.iterator();
//		while(iter.hasNext()) {
//			ProductVo vo = iter.next();	
//			if(vo.getSerial().equals(find)) {
//				pCode.setText(vo.getpCode());
//				pName.setText(vo.getpName());
//				ea.setText(String.valueOf(vo.getEa()));
//				nal.setText(sdf.format(vo.getNal()));
//			}
//		}
		
		if(oldVo == null) {
			pCode.setText("");
			pName.setText("");
			ea.setText("");
			nal.setText("");
			status.setText("자료가 없습니다.");
			serial.requestFocus();
			serial.selectAll();	
		}
		
	} //search of end.
	
	public void modify() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(oldVo != null) {
			try {
				String s = serial.getText();
				String pC = pCode.getText();
				String pN = pName.getText();
				int e = Integer.parseInt(ea.getText());
				Date n = sdf.parse(nal.getText());
				
				list.remove(oldVo);
				ProductVo newVo = new ProductVo(s, pC, pN, e, n);
				list.add(newVo);
				
				status.setText("자료가 수정되었습니다.");
				serial.requestFocus();
				serial.selectAll();
			}catch(ParseException e1) {
				status.setText("날짜 형식을 yyyy-MM-dd 로 입력해주세요.");
				nal.requestFocus();
				nal.selectAll();
			}catch(NumberFormatException e2) {
				status.setText("숫자만 넣어주세요.");
				ea.requestFocus();
				ea.selectAll();
			}
			
		} else {
			status.setText("검색 후 수정해주세요.");
		}
		
	} //modify of end.
	
	public void delecte() {
		if(oldVo != null) {
			list.remove(oldVo);
			pCode.setText("");
			pName.setText("");
			ea.setText("");
			nal.setText("");
			status.setText("자료가 삭제되었습니다.");
			serial.requestFocus();
			serial.selectAll();
			
		} else {
			status.setText("검색 후 삭제해주세요.");
			serial.requestFocus();
		}
		
	} //delecte of end.

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uAD6C     \uBD84");
			lblNewLabel.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 13));
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	private JRadioButton getImBtn() {
		if (imBtn == null) {
			imBtn = new JRadioButton("\uC785\uACE0");
			imBtn.setBackground(new Color(144, 238, 144));
			imBtn.setBounds(66, 6, 57, 23);
			group.add(imBtn);
			imBtn.setSelected(true);
		}
		return imBtn;
	}
	private JRadioButton getExBtn() {
		if (exBtn == null) {
			exBtn = new JRadioButton("\uCD9C\uACE0");
			exBtn.setBackground(new Color(144, 238, 144));
			exBtn.setBounds(119, 6, 61, 23);
			group.add(exBtn);
		}
		return exBtn;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC2DC \uB9AC \uC5BC");
			lblNewLabel_1.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 13));
			lblNewLabel_1.setBounds(12, 47, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getSerial() {
		if (serial == null) {
			serial = new JTextField();
			serial.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			serial.setBounds(64, 44, 116, 21);
			serial.setColumns(10);
		}
		return serial;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					search();
					
				}
			});
			btnNewButton.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 12));
			btnNewButton.setBounds(192, 43, 64, 23);
		}
		return btnNewButton;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 74, 292, 2);
		}
		return separator;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC81C\uD488\uCF54\uB4DC");
			lblNewLabel_2.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 13));
			lblNewLabel_2.setBounds(12, 94, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC81C \uD488 \uBA85");
			lblNewLabel_3.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 13));
			lblNewLabel_3.setBounds(12, 129, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC218     \uB7C9");
			lblNewLabel_4.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 13));
			lblNewLabel_4.setBounds(12, 164, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uB0A0     \uC9DC");
			lblNewLabel_5.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 13));
			lblNewLabel_5.setBounds(12, 199, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JTextField getPCode() {
		if (pCode == null) {
			pCode = new JTextField();
			pCode.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			pCode.setBounds(66, 91, 116, 21);
			pCode.setColumns(10);
		}
		return pCode;
	}
	private JTextField getPName() {
		if (pName == null) {
			pName = new JTextField();
			pName.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			pName.setBounds(66, 126, 116, 21);
			pName.setColumns(10);
		}
		return pName;
	}
	private JTextField getEa() {
		if (ea == null) {
			ea = new JTextField();
			ea.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			ea.setBounds(64, 161, 116, 21);
			ea.setColumns(10);
		}
		return ea;
	}
	private JTextField getNal() {
		if (nal == null) {
			nal = new JTextField();
			nal.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			nal.setBounds(66, 196, 116, 21);
			nal.setColumns(10);
		}
		return nal;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modify();
				}
			});
			btnNewButton_1.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 12));
			btnNewButton_1.setBounds(208, 125, 77, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC0AD\uC81C");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				delecte();	
				}
			});
			btnNewButton_2.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 12));
			btnNewButton_2.setBounds(208, 160, 77, 23);
		}
		return btnNewButton_2;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 12));
			status.setOpaque(true);
			status.setBounds(12, 230, 295, 30);
		}
		return status;
	}
}
