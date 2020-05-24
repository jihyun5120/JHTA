package semishit;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FindID extends JDialog {

	ButtonGroup group = new ButtonGroup();

	private final JPanel contentPanel = new JPanel();
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField teno;
	private JTextField tmName;
	private JTextField findPhone;
	private JPanel panel;
	private JSeparator separator;
	private JTextField findemail;
	private JComboBox comboBox;
	private JRadioButton btnphone;
	private JRadioButton btnemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FindID dialog = new FindID();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FindID() {
		setModal(true);
		setBounds(100, 100, 486, 391);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnNewButton_1());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getTeno());
		contentPanel.add(getTmName());
		contentPanel.add(getFindPhone());
		contentPanel.add(getPanel());
		contentPanel.add(getSeparator());
		contentPanel.add(getFindemail());
		contentPanel.add(getComboBox());
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC870\uD68C");
			btnNewButton_1.setBackground(Color.PINK);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// ��ȸ�ϱ�

					try {
						JoinVo vo = new JoinVo();
						joinDao dao = new joinDao();

						if (btnphone.isSelected()) { // ������ư ��ȭ��ȣ�� ���õɋ�

							int eno = Integer.parseInt(teno.getText());
							String mName = tmName.getText();
							String phone = findPhone.getText();

							int r = dao.findIdphone(eno, mName, phone);

							switch (r) {
							case -1: // �����ȣ�� ��������������
								JOptionPane.showMessageDialog(FindID.this, "�����ȣ�� �������� �ʽ��ϴ�!");
								break;

							case 1: // �̸��� ����ġ�ҋ�
								JOptionPane.showMessageDialog(FindID.this, "�̸��� ��ġ���� �ʽ��ϴ�!");
								break;

							case 2: // ��� ���� ��ġ�� �� (����!)
								String findid = dao.IDfind(eno);
								JOptionPane.showMessageDialog(FindID.this, "������ ���̵�� " + findid + " �Դϴ�!");
								break;

							case 3:// ��ȭ��ȣ���� ����ġ�Ҷ�
								JOptionPane.showMessageDialog(FindID.this, "��ȭ��ȣ�� ��ġ���� �ʽ��ϴ�!");

								break;

							}

						} else if (btnemail.isSelected()) {// ������ư �̸����� ���õ� ��

							int eno = Integer.parseInt(teno.getText());
							String mName = tmName.getText();
							String email = "";
							if (comboBox.getSelectedIndex() == 3) {

								email = findemail.getText();

							} else {

								email = findemail.getText() + comboBox.getSelectedIndex();

							}

							int r = dao.findIdEmail(eno, mName, email);

							switch (r) {
							case -1: // �����ȣ�� ��������������
								JOptionPane.showMessageDialog(FindID.this, "�����ȣ�� �������� �ʽ��ϴ�!");
								break;

							case 1: // �̸��� ����ġ�ҋ�
								JOptionPane.showMessageDialog(FindID.this, "�̸��� ��ġ���� �ʽ��ϴ�!");
								break;

							case 2: // ��� ���� ��ġ�� �� (����!)
								String findid = dao.IDfind(eno);
								JOptionPane.showMessageDialog(FindID.this, "������ ���̵�� " + findid + " �Դϴ�!");
								break;

							case 3:// ���ϰ��� ����ġ�Ҷ�
								JOptionPane.showMessageDialog(FindID.this, "������ ��ġ���� �ʽ��ϴ�!");

								break;

							}

						}
					} catch (Exception ex) {

						JOptionPane.showMessageDialog(FindID.this, "��� ĭ�� ä���ּ���~");
					}
				}
			});
			btnNewButton_1.setBounds(183, 295, 117, 33);
		}
		return btnNewButton_1;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
			lblNewLabel.setFont(new Font("12롯데마트드림Medium", Font.BOLD, 20));
			lblNewLabel.setBounds(176, 21, 181, 53);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC0AC\uC6D0\uBC88\uD638");
			lblNewLabel_1.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(94, 103, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC774\uB984");
			lblNewLabel_2.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(94, 142, 57, 15);
		}
		return lblNewLabel_2;
	}

	private JTextField getTeno() {
		if (teno == null) {
			teno = new JTextField();
			teno.setBounds(183, 99, 156, 23);
			teno.setColumns(10);
		}
		return teno;
	}

	private JTextField getTmName() {
		if (tmName == null) {
			tmName = new JTextField();
			tmName.setBounds(183, 137, 156, 25);
			tmName.setColumns(10);
		}
		return tmName;
	}

	private JTextField getFindPhone() {
		if (findPhone == null) {
			findPhone = new JTextField();
			findPhone.setToolTipText("\uC804\uD654\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
			findPhone.setBounds(25, 243, 156, 23);
			findPhone.setColumns(10);

		}
		return findPhone;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(58, 196, 354, 33);
			panel.add(getBtnphone());
			panel.add(getBtnemail());
		}
		return panel;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 177, 446, 9);
		}
		return separator;
	}

	private JTextField getFindemail() {
		if (findemail == null) {
			findemail = new JTextField();
			findemail.setToolTipText("\uC774\uBA54\uC77C\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
			findemail.setBounds(192, 243, 127, 23);
			findemail.setColumns(10);

			findemail.setVisible(false);

		}
		return findemail;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBackground(Color.WHITE);

			comboBox.setModel(new DefaultComboBoxModel(new String[] { "@naver.com", "@gmail.com", "@hanmail.com",
					"\uC9C1\uC811\uC785\uB825\uD558\uAE30" }));
			comboBox.setBounds(320, 243, 138, 23);

			comboBox.setVisible(false);

		}
		return comboBox;
	}

	private JRadioButton getBtnphone() {
		if (btnphone == null) {
			btnphone = new JRadioButton("\uC804\uD654\uBC88\uD638");
			btnphone.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			btnphone.setBackground(Color.WHITE);
			btnphone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// ��ȭ��ȣ
					findPhone.setVisible(true);
					findemail.setVisible(false);
					comboBox.setVisible(false);
				}
			});
			group.add(btnphone);
			btnphone.setSelected(true);

		}

		return btnphone;
	}

	private JRadioButton getBtnemail() {
		if (btnemail == null) {
			btnemail = new JRadioButton("\uC774\uBA54\uC77C");
			btnemail.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
			btnemail.setBackground(Color.WHITE);
			btnemail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// �̸���
					findPhone.setVisible(false);
					findemail.setVisible(true);
					comboBox.setVisible(true);
				}
			});

			group.add(btnemail);
		}
		return btnemail;
	}
}
