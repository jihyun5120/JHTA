package semishit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class joinMem extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField tmId;
	private JTextField tpwdan;
	private JTextField teno;
	private JPasswordField tpwd;
	private JPasswordField tpwdck;
	private JTextField tmName;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			joinMem dialog = new joinMem();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public joinMem() {
		setTitle("회원가입");
		setModal(true);

		setBounds(100, 100, 398, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
			label.setFont(new Font("나눔고딕", Font.BOLD, 25));
			label.setBounds(21, 10, 138, 53);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("\uC544\uC774\uB514");
			label.setBounds(21, 123, 57, 15);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
			label.setBounds(21, 148, 57, 15);
			contentPanel.add(label);
		}
		{
			tmId = new JTextField();
			tmId.setToolTipText("\uC601\uBB38\uACFC \uC22B\uC790\uB97C \uC870\uD569\uD558\uC5EC 4~20 \uC790\uB9AC\uB85C \uC124\uC815\uD574\uC8FC\uC138\uC694");
			tmId.setColumns(10);
			tmId.setBounds(116, 120, 157, 21);
			contentPanel.add(tmId);
		}
		{
			JButton button = new JButton("\uC785\uB825");
			button.setBackground(Color.PINK);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// 입력
					JoinVo vo = new JoinVo();
					joinDao dao = new joinDao();
					int cnt = 0;

					// 아이디 알파벳&숫자 사용가능, 4~20 자리
					String regexp = "^[a-zA-Z0-9]{4,20}$";
					String value = tmId.getText();
					boolean idcheck = Pattern.matches(regexp, value);

					// 암호 영문, 숫자, 특수문자 조합, 9~12자리

					String patt = "^[a-z0-9!@#$%^&*]{9,12}$";
					String val = tpwd.getText();
					boolean pwdcheck = Pattern.matches(patt, val);

					try {
						vo.setEno(Integer.parseInt(teno.getText()));
						vo.setmId(tmId.getText());
						vo.setPwd(tpwd.getText());
						vo.setPwdQu(comboBox.getSelectedIndex() + "");
						vo.setPwdAn(tpwdan.getText());
						if (idcheck == true) { // 아이디 정규식이 일치할때
							if (pwdcheck == true) {// 비밀번호 정규식이 일치할때
								if (tpwd.getText().equals(tpwdck.getText())) {// 비밀번호 재확인이 비밀번호와 일치할때
									cnt = dao.insert(vo);

									if (cnt > 0) {

										JOptionPane.showMessageDialog(joinMem.this, "회원가입이 완료되었습니다!");
									} else {

										JOptionPane.showMessageDialog(joinMem.this, "회원가입 중 오류가 발생했습니다. 다시 확인해주세요~");
									}
								} else {

									JOptionPane.showMessageDialog(joinMem.this, "비밀번호가 일치하지 않습니다!");
									tpwdck.requestFocus();
									tpwdck.selectAll();

								}
							} else {
								JOptionPane.showMessageDialog(joinMem.this, "비밀번호가 형식에 맞지 않습니다.");

								tpwd.requestFocus();
								tpwd.selectAll();

							}
						} else {
							JOptionPane.showMessageDialog(joinMem.this, "아이디가 형식에 맞지 않습니다.");
							tmId.requestFocus();
							tmId.selectAll();
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(joinMem.this, "모든 칸을 채워주세요~!");

					}

				}
			});
			button.setBounds(127, 302, 97, 23);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("\uC911\uBCF5\uAC80\uC0AC");
			button.setBackground(Color.PINK);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// 중복검사

					joinDao dao = new joinDao();
					String mId = tmId.getText();
					int r = dao.checkmId(mId);
					if (tmId.getText().isEmpty()) {
						JOptionPane.showMessageDialog(joinMem.this, "아이디를 입력해주세요.");
					} else {
						if (r == 0) {

							JOptionPane.showMessageDialog(joinMem.this, "아이디를 사용하셔도 괜찮습니다.");

						} else if (r == 1) {

							JOptionPane.showMessageDialog(joinMem.this, "아이디가 중복됩니다!");

						}
					}
				}
			});
			button.setBounds(277, 119, 97, 23);
			contentPanel.add(button);
		}
		{
			JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638\uD655\uC778");
			label.setBounds(21, 173, 80, 15);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBD84\uC2E4\uC2DC ");
			label.setBounds(21, 212, 117, 21);
			contentPanel.add(label);
		}
		{
			tpwdan = new JTextField();
			tpwdan.setColumns(10);
			tpwdan.setBounds(116, 258, 157, 21);
			contentPanel.add(tpwdan);
		}
		{
			JLabel label = new JLabel("\uC0AC\uC6D0\uBC88\uD638");
			label.setBounds(21, 71, 57, 15);
			contentPanel.add(label);
		}
		{
			teno = new JTextField();
			teno.setToolTipText("\uC22B\uC790\uB85C\uB9CC \uC785\uB825\uD574\uC8FC\uC138\uC694");
			teno.setColumns(10);
			teno.setBounds(116, 68, 157, 21);
			contentPanel.add(teno);
		}
		{
			JButton button = new JButton("\uAC80\uC0C9");
			button.setBackground(Color.PINK);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {// 검색
					joinDao dao = new joinDao();
					String g = teno.getText();
					JoinVo vo = dao.searchEno(Integer.parseInt(g));
					String gg = vo.getEno() + "";
					if (g.equals(gg)) {
						JOptionPane.showMessageDialog(joinMem.this, "사원번호가 일치합니다!");
						tmName.setText(vo.getmName());

					} else {

						JOptionPane.showMessageDialog(joinMem.this, "사원번호가  존재하지 않습니다!");

					}
				}
			});
			button.setBounds(277, 67, 97, 23);
			contentPanel.add(button);
		}
		{
			JLabel label = new JLabel("\uD655\uC778\uC9C8\uBB38 \uC815\uB2F5");
			label.setBounds(21, 262, 83, 17);
			contentPanel.add(label);
		}
		{
			tpwd = new JPasswordField();
			tpwd.setToolTipText("\uC601\uBB38,\uC22B\uC790,\uD2B9\uC218\uAE30\uD638\uB97C \uC870\uD569\uD558\uC5EC 9~12\uC790\uB9AC\uB85C \uC124\uC815\uD574\uC8FC\uC138\uC694.");
			tpwd.setBounds(116, 145, 157, 21);
			contentPanel.add(tpwd);
		}
		{
			tpwdck = new JPasswordField();
			tpwdck.setBounds(116, 169, 157, 23);
			contentPanel.add(tpwdck);
		}
		{
			JLabel label = new JLabel("\uD655\uC778\uC9C8\uBB38");
			label.setBounds(21, 231, 80, 21);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("\uC774\uB984");
			label.setBounds(21, 96, 57, 15);
			contentPanel.add(label);
		}
		{
			tmName = new JTextField();
			tmName.setText("");
			tmName.setColumns(10);
			tmName.setBounds(116, 93, 157, 21);
			contentPanel.add(tmName);
		}
		contentPanel.add(getComboBox());
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBackground(Color.WHITE);
			comboBox.setModel(
					new DefaultComboBoxModel(new String[] { "\uC81C\uC77C \uC88B\uC544\uD558\uB294 \uC0C9\uAE54\uC740?",
							"\uC5B4\uB9B0 \uC2DC\uC808 \uBCC4\uBA85\uC740?",
							"\uAC00\uC7A5 \uC88B\uC544\uD558\uB294 \uACFC\uC77C\uC740?",
							"\uAC00\uC7A5 \uC874\uACBD\uD558\uB294 \uC778\uBB3C\uC740?" }));
			comboBox.setBounds(116, 212, 157, 21);
		}
		return comboBox;
	}
}
