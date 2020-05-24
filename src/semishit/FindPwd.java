package semishit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class FindPwd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField teno;
	private JTextField tmName;
	private JTextField tmId;
	private JTextField tpwdAn;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FindPwd dialog = new FindPwd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FindPwd() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
			
			}
		});
		setModal(true);

		setBounds(100, 100, 356, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton button = new JButton("\uCC3E\uAE30");
			button.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			button.setBackground(Color.PINK);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// ã��
				  try {
					joinDao dao = new joinDao();
					String ranPw = dao.randomPwd();

					int eno = Integer.parseInt(teno.getText());
					String mId = tmId.getText();
					String pwd = ranPw;
					String mName = tmName.getText();
					String pwdQu = comboBox.getSelectedIndex() + "";
					String pwdAn = tpwdAn.getText();

					int r = dao.findPwd(eno, mId, mName, pwdQu, pwdAn);

					switch (r) {

					case -1: // �����ȣ�� ��������������
						JOptionPane.showMessageDialog(FindPwd.this, "�����ȣ�� �������� �ʽ��ϴ�!");
						break;
					case 0: // ���̵� �������� ������
						JOptionPane.showMessageDialog(FindPwd.this, "���̵� �������� �ʽ��ϴ�. ȸ�������� �������ּ���");
						break;

					case 1: // �̸��� ����ġ�ҋ�
						JOptionPane.showMessageDialog(FindPwd.this, "�̸��� ��ġ���� �ʽ��ϴ�!");
						break;

					case 2: // ��й�ȣ ������ ��ġ���� ������

						JOptionPane.showMessageDialog(FindPwd.this, "��й�ȣ ������ ��ġ���� �ʽ��ϴ�");
						break;

					case 3:// ��й�ȣ ����� ��ġ���� ������
						JOptionPane.showMessageDialog(FindPwd.this, "��й�ȣ ����� ��ġ���� �ʽ��ϴ�!");
						break;

					case 4: // ��й�ȣ ã�� ����

						JoinVo vo = new JoinVo(eno, mName, mId, pwd, pwdQu, pwdAn);
						int r2 = dao.savePwd(vo);

						JOptionPane.showMessageDialog(FindPwd.this,
								"�ӽú�й�ȣ�� ���� ������ ����� �̸��Ϸ� �߼۵Ǿ����ϴ�!");
						break;

					}
				  }catch(Exception ex) {
					  JOptionPane.showMessageDialog(FindPwd.this, "��� ĭ�� ä���ּ���~!");
				  }

				}
			});
			button.setBounds(106, 313, 117, 34);
			contentPanel.add(button);
		}
		{
			JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
			label.setFont(new Font("���� ���", Font.BOLD, 20));
			label.setBounds(85, 10, 177, 53);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("\uC0AC\uC6D0\uBC88\uD638");
			label.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label.setBounds(36, 88, 57, 15);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("\uC774\uB984");
			label.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label.setBounds(36, 171, 57, 15);
			contentPanel.add(label);
		}
		{
			teno = new JTextField();
			teno.setColumns(10);
			teno.setBounds(118, 85, 156, 23);
			contentPanel.add(teno);
		}
		{
			tmName = new JTextField();
			tmName.setColumns(10);
			tmName.setBounds(118, 165, 157, 23);
			contentPanel.add(tmName);
		}
		{
			JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel.setBounds(36, 126, 57, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			tmId = new JTextField();
			tmId.setBounds(118, 126, 156, 21);
			contentPanel.add(tmId);
			tmId.setColumns(10);
		}
		{
			JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBD84\uC2E4\uC2DC ");
			label.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label.setBounds(36, 206, 86, 21);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("\uD655\uC778\uC9C8\uBB38");
			label.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label.setBounds(36, 223, 80, 21);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("\uD655\uC778\uC9C8\uBB38 \uC815\uB2F5");
			label.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			label.setBounds(36, 256, 83, 17);
			contentPanel.add(label);
		}
		{
			tpwdAn = new JTextField();
			tpwdAn.setColumns(10);
			tpwdAn.setBounds(118, 253, 157, 21);
			contentPanel.add(tpwdAn);
		}
		contentPanel.add(getComboBox());
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			comboBox.setModel(
					new DefaultComboBoxModel(new String[] { "\uC81C\uC77C \uC88B\uC544\uD558\uB294 \uC0C9\uAE54\uC740?",
							"\uC5B4\uB9B0 \uC2DC\uC808 \uBCC4\uBA85\uC740?",
							"\uAC00\uC7A5 \uC88B\uC544\uD558\uB294 \uACFC\uC77C\uC740?",
							"\uAC00\uC7A5 \uC874\uACBD\uD558\uB294 \uC778\uBB3C\uC740?" }));
			comboBox.setBounds(118, 204, 163, 23);
		}
		return comboBox;
	}
}
