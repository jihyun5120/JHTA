package semishit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import m_jdbc.DBConn;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class joinDao {
	Connection conn = null;

	public joinDao() {
		conn = DBConn.getConn();

	}

	public void sendMail(String mailId, String rePwd) { // recipient �� ���� ���� ����� �����ּ� (naver.com)

		String host = "smtp.naver.com";

		final String username = "sungbae_academy"; // ���̹� ���̵� �Է�
		final String password = "dbwls2002"; // ���̹� �̸��� ��й�ȣ

		int port = 465; // ��Ʈ��ȣ

		// ���� ����

		String recipient = mailId; // �޴� ����� �����ּ�

		String subject = "�ӽú�й�ȣ�� �߱޵Ǿ����ϴ�."; // ���� ����

		String body = "�ӽ� ��й�ȣ�� " + rePwd + " �Դϴ�. \n" + "�α��� �� �ݵ�� ��й�ȣ�� �������ּ���~"; // ���� ���� �Է�

		Properties props = System.getProperties();

		// ������ ��� ���� ��ü ����

		// SMTP ���� ���� ����

		props.put("mail.smtp.host", host);

		props.put("mail.smtp.port", port);

		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.ssl.enable", "true");

		props.put("mail.smtp.ssl.trust", host);

		// Session ����

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

			String un = username;

			String pw = password;

			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {

				return new javax.mail.PasswordAuthentication(un, pw);

			}

		});

		session.setDebug(true); // for debug

		Message mimeMessage = new MimeMessage(session); // MimeMessage ����

		try {
			mimeMessage.setFrom(new InternetAddress(mailId));
			// �߽��� ���� , ������ ����� �̸����ּҸ� �ѹ� �� �Է�. �̶��� �̸��� Ǯ �ּҸ� �� �ۼ��ؾ��Ѵ�..

			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); // �����ڼ���

			mimeMessage.setSubject(subject); // �������

			mimeMessage.setText(body); // �������

			Transport.send(mimeMessage); // javax.mail.Transport.send() �̿�

			System.out.println("���� ������ ������.");
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public int login(String id, String pw) { // �α���

		int r = 0;

		try {
			String sql = "select * from membership where mId =?  ";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next() == false || id.isEmpty() == true) { // id�� �����ͺ��̽��� ������

				r = -1;

			} else { // id �� �����ͺ��̽��� ������

				sql = "select * from membership where mId = (select * from membership where mId =? )";

				ps.setString(1, id);
				rs = ps.executeQuery();

				while (rs.next()) {

					if (rs.getString(3).equals(pw)) { // �α��� ����

						r = 0;
					} else {// id�� ������ pwd�� Ʋ�� ��

						r = 1;
					}

				}

			}
			
			rs.close();
			ps.close();
            conn.close();
		} catch (Exception ex) {

		} finally {

			return r;
		}
	}

	public int findIdphone(int eno, String mName, String phone) {// ��ȭ��ȣ�� �˻�������
		int r = 0;
		try {

			String sql = "select * from membership where employee_number = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, eno);

			ResultSet rs = ps.executeQuery();

			if (rs.next() == false || (eno + "").isEmpty() == true) {
				r = -1; // �����ȣ�� �����ͺ��̽��� ��������������

			} else {

				sql = "select *  from employees where employee_number  =? ";
				PreparedStatement ps1 = conn.prepareStatement(sql);

				ps1.setInt(1, eno);

				ResultSet rs1 = ps1.executeQuery();

				while (rs1.next()) { // �����ȣ�� �����ͺ��̽��� �����Ҷ�

					if (rs1.getString(2).equals(mName)) { // �̸��� ��ġ�ϸ�

						r = 0;

						if (rs1.getString(4).equals(phone)) { // ��ȭ�� ��ġ�ϸ�

							r = 2; // ���������� mId ���� �ѷ��� ���ϰ�

						} else {// ��ȭ�� ��ġ���� ������

							r = 3;

						}

					} else {// �̸��� ��ġ���� ������

						r = 1;

					}

				}

				rs1.close();
				ps1.close();

			}

			rs.close();
			ps.close();

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			return r;

		}
	}

	public int findIdEmail(int eno, String mName, String email) {// ���Ϸ� �˻�������
		int r = 0;
		try {

			String sql = "select * from membership where employee_number = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, eno);
			ResultSet rs = ps.executeQuery();

			if (rs.next() == false || (eno + "").isEmpty() == true) {
				r = -1; // �����ȣ�� �����ͺ��̽��� ��������������

			} else {// �����ȣ�� �����ͺ��̽��� �����Ҷ�

				sql = "select *  from employees where email  =? and employee_number=?";
				PreparedStatement ps1 = conn.prepareStatement(sql);

				ps1.setString(1, email);
				ps1.setInt(2, eno);
				ResultSet rs1 = ps1.executeQuery();

				while (rs1.next()) {

					if (rs1.getString(2).equals(mName)) { // �̸��� ��ġ�ϸ�

						r = 0;

						if (rs1.getString(5).equals(email)) { // �̸����� ��ġ�ϸ�
							System.out.println(rs1.getString(5));
							r = 2; // ���������� mId ���� �ѷ��� ���ϰ�

						} else {// �̸����� ��ġ���� ������

							r = 3;

						}

					} else {// �̸��� ��ġ���� ������

						r = 1;

					}

				}

				rs1.close();
				ps1.close();

			}

			rs.close();
			ps.close();
        
		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			return r;

		}
	}

	public String IDfind(int eno) {
		String findid = "";
		JoinVo vo = new JoinVo();

		try {

			String sql = "select m.mId from membership m ,employees e where m.employee_number = ? and  m.employee_number=e.employee_number ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, eno);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				vo.setmId(rs.getString("mId"));

				findid = vo.getmId();
				System.out.println(findid);

			}
			rs.close();
			ps.close();

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		return findid;
	}

	public int findPwd(int eno, String mId, String mName, String pwdQu, String pwdAn) {

		int r = 0;

		try {

			String sql = "select m.employee_number,m.mId,e.employee_name,m.pwdQu,m.pwdAns,e.email from membership m join employees e on m.employee_number=e.employee_number where m.employee_number=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, eno);

			ResultSet rs = ps.executeQuery();

			if (rs.next() == false || (eno + "").isEmpty() == true) {
				r = -1; // �����ȣ�� �����ͺ��̽��� ��������������

			} else {// �����ȣ�� �����ͺ��̽��� �����Ҷ�
				if (rs.getString(2).equals(mId)) { // mId �� �����ҋ�

					if (rs.getString(3).equals(mName)) {// mName�� �����ҋ�
						if (rs.getString(4).equals(pwdQu)) {// ��й�ȣ ������ ��ġ�ҋ�
							if (pwdAn.equals(rs.getString(5))) {// ��й�ȣ ��䵵 ��ġ == ��й�ȣ �ѷ��ټ��ִ�

								String mailId = rs.getString(6);
								String rePwd = randomPwd();

								sendMail(mailId, rePwd);
								
								r = 4; // ����^^

							} else {// ��й�ȣ ����� ����ġ��!!!!!

								r = 3;
							}

						} else {// ��� ������ ��ġ���� ������

							r = 2;
						}

					} else {// �̸��� ����ġ�Ҷ�
						r = 1;

					}

				} else {// mId�� �������� ������

					r = 0;
				}

			}
			rs.close();
			ps.close();

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			return r;
		}
	}

	/*
	 * UUID�� ���Ϲ����� ID�� ����� ǥ�ر�� �� �ٸ� ���δ� ���� ���� ��ȣ��� �Ҹ��� 128 ��Ʈ�� ���ڿ� ����(�ҹ���)�� ��������
	 * ���������.
	 */
	public static String randomPwd() { // �������� ��й�ȣ �߻���Ų��.
		char pwCollection[] = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'B', 'C', 'D', 'E',
				'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')' };// �迭�� ����

		String ranPw = "";

		for (int i = 0; i < 10; i++) {
			int selectRandomPw = (int) (Math.random() * (pwCollection.length));// Math.rondom()�� 0.0�̻� 1.0�̸��� ������ ������
																				// �ش�.
			ranPw += pwCollection[selectRandomPw];
		}
		return ranPw;
	}

	public int savePwd(JoinVo vo) { // ���� ����� �ѷ��ذ� �����ؾ���.
		int r = 0;

		String givePwd = randomPwd();

		try {

			String sql = "update membership set pwd=?  where employee_number=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getPwd());
			ps.setInt(2, vo.getEno());

			System.out.println(vo.getPwd());
			System.out.println(vo.getEno());

			r = ps.executeUpdate();
			
			ps.close();
			conn.close();

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		return r;
	}

	public int checkmId(String mId) {
		int r = 0;

		try {

			String sql = "select * from membership where mId =?  ";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, mId);

			ResultSet rs = ps.executeQuery();

			if (rs.next() == false || mId.isEmpty() == true) { // id�� �����ͺ��̽��� ������

				r = 0;

			} else { // id �� �����ͺ��̽��� ������

				r = 1;
			}

			rs.close();
			ps.close();
		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {

			return r;
		}
	}

	public JoinVo searchEno(int eno) {
		JoinVo vo = null;

		try {
			String sql = " select employee_number , employee_name from employees where employee_number =?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, eno);
			conn.setAutoCommit(false);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vo = new JoinVo();
				vo.setEno(rs.getInt("Employee_number"));
				vo.setmName(rs.getString("Employee_name"));

				rs.close();
				ps.close();

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return vo;
	}

	public int insert(JoinVo vo) {
		int r = 0;

		try {

			String sql = "insert into membership (mId,pwd,pwdQu,pwdAns,employee_number) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, vo.getmId());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getPwdQu());
			ps.setString(4, vo.getPwdAn());
			ps.setInt(5, vo.getEno());

			conn.setAutoCommit(false);
			r = ps.executeUpdate();

			if (r > 0)
				conn.commit();
			else
				conn.rollback();

			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			return r;
		}
	}

	public JoinVo search(int eno) {// ������ư �����ȣ�� �����Ҷ�.
		JoinVo vo = null;

		try {

			String sql = "select e.employee_name,m.mId,m.pwd,m.pwdQu,m.pwdAns from membership m ,employees e where m.employee_number = ? and  m.employee_number=e.employee_number ";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, eno);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				vo = new JoinVo();

				vo.setmId(rs.getString("mId"));
				vo.setPwd(rs.getString("pwd"));
				vo.setmName(rs.getString("employee_name"));
				vo.setPwdQu(rs.getString("pwdQu"));
				vo.setPwdAn(rs.getString("pwdAns"));

				rs.close();
				ps.close();

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			return vo;
		}
	}

	public JoinVo search(String mId) {// ������ư ���̵� �����Ҷ�.
		JoinVo vo = null;

		try {

			String sql = " select m.employee_number,e.employee_name,m.pwd,m.pwdQu,m.pwdAns from membership m ,employees e where m.mId = ? and  m.employee_number=e.employee_number ";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, mId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				vo = new JoinVo();

				vo.setEno(rs.getInt("employee_number"));
				vo.setmName(rs.getString("employee_name"));
				vo.setPwd(rs.getString("pwd"));

				vo.setPwdQu(rs.getString("pwdQu"));
				vo.setPwdAn(rs.getString("pwdAns"));

				rs.close();
				ps.close();

			}

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {

			return vo;
		}
	}

	public int delete(String mId) {
		int r = 0;

		try {
			JoinVo vo = new JoinVo();

			String sql = "delete from membership where mId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, mId);

			conn.setAutoCommit(false);
			r = ps.executeUpdate();

			if (r > 0)
				conn.commit();
			else
				conn.rollback();

			ps.close();
            conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			return r;
		}
	}

	public int update(JoinVo vo) {

		int r = 0;

		try {

			String sql = "update membership  set pwd=?,pwdQu=?, pwdAns=?  ,employee_number=? where mId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, vo.getPwd());
			ps.setString(2, vo.getPwdQu());
			ps.setString(3, vo.getPwdAn());
			ps.setInt(4, vo.getEno());
			ps.setString(5, vo.getmId());
	

			conn.setAutoCommit(false);

			r = ps.executeUpdate();

			if (r > 0)
				conn.commit();
			if (r < 0)
				conn.rollback();

			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			return r;
		}
	}

	public Vector select(String find) {
		Vector data = new Vector();

		try {
			String sql = "select e.employee_number,m.mId,m.pwd,e.employee_name,m.pwdAns from membership m join employees e on e.employee_number=m.employee_number where e.employee_number like ? or e.employee_name like ? or m.mId like ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, "%" + find + "%");
			ps.setString(2, "%" + find + "%");
			ps.setString(3, "%" + find + "%");

			ResultSetMetaData meta = ps.getMetaData();
			DefaultTableModel model = new DefaultTableModel();

			int cnt = meta.getColumnCount();
			for (int i = 1; i < cnt; i++) {

				model.addColumn(meta.getColumnName(i));

			}

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				JoinVo vo = new JoinVo();

				int eno = rs.getInt("employee_number");
				String mId = rs.getString("mId");
				String pwd = rs.getString("pwd");
				String mName = rs.getString("employee_name");
				String pwdAn = rs.getString("pwdAns");

				Vector row = new Vector();
				row.add(eno);
				row.add(mId);
				row.add(pwd);
				row.add(mName);
				row.add(pwdAn);

				data.add(row);

			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			return data;
		}
	}

}
