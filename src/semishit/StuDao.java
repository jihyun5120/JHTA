package semishit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class StuDao {
	Connection conn = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	DefaultTableModel model = new DefaultTableModel();

	public StuDao() {
		conn = DBConn.getConn();
	}

	public int Sinput(StuVo vo) {
		int r = 0;
		PreparedStatement ps = null;

		try {
			String sql = "insert into student(sno , sname , sbirth, saddress, sphone, semail, smale, employee_number, impath, imname) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getSno());
			ps.setString(2, vo.getSname());
			ps.setString(3, sdf.format(vo.getSbirth())); 
			ps.setString(4, vo.getSaddress());
			ps.setString(5, vo.getSphone());
			ps.setString(6, vo.getSemail());
			ps.setString(7, vo.getSmale());
			ps.setInt(8, vo.getEno());
			ps.setString(9, vo.getImpath());
			ps.setString(10, vo.getImname());
			
			conn.setAutoCommit(false);
			r = ps.executeUpdate();

			Thread send = new Send1(vo.imname,vo.impath);
			send.start();
			
			if (r > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			return r;
		}
	}

	public StuVo select(String r) {
		StuVo vo = new StuVo();
		model.setNumRows(0);
		try {

			String sql = "select sno 학번, sname 성명, to_char(sbirth,'yyyy-MM-dd') 생년월일, saddress 주소, sphone 연락처, semail 이메일, smale 성별, employee_number 강사번호 from student where sno like ? or sname like ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + r + "%");
			ps.setString(2, "%" + r + "%");

			ResultSetMetaData meta = ps.getMetaData();

			int cnt = meta.getColumnCount();
			for (int i = 1; i <= cnt; i++) {
				model.addColumn(meta.getColumnName(i) + "\n");
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector row = new Vector();
				for (int i = 1; i <= cnt; i++) {
					row.add(rs.getString(i));
				}
				model.addRow(row);

			}
			rs.close();
			ps.close();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			return vo;
		}

	}

	public void selectAll() {
		StudentSelect ss = new StudentSelect();
		model.setNumRows(0); // 모델 초기화
		try {

			String sql = "select sno 학번, sname 성명, to_char(sbirth,'yyyy-MM-dd') 생년월일, saddress 주소, sphone 연락처, semail 이메일, smale 성별,employee_number 강사번호  from student";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSetMetaData meta = ps.getMetaData();

			int cnt = meta.getColumnCount();
			for (int i = 1; i <= cnt; i++) {
				model.addColumn(meta.getColumnName(i) + "\n");
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector row = new Vector();
				for (int i = 1; i <= cnt; i++) {
					row.add(rs.getString(i));
				}
				model.addRow(row);

			}
			ps.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public StuVo search(int sno) {
		StuVo vo = null;

		try {
			String sql = "select sno, sname, sbirth, saddress, sphone, semail, smale, employee_number, imname, impath from student where sno = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sno);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vo = new StuVo();
				vo.setSno(rs.getInt("sno"));
				vo.setSname(rs.getString("sname"));
				vo.setSbirth(rs.getDate("sbirth"));
				vo.setSaddress(rs.getString("saddress"));
				vo.setSphone(rs.getString("sphone"));
				vo.setSemail(rs.getString("semail"));
				vo.setSmale(rs.getString("smale"));
				vo.setEno(rs.getInt("employee_number"));
				vo.setImname(rs.getString("imname"));
				vo.setImpath(rs.getString("impath"));
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return vo;
		}
	}

	public int update(StuVo vo) {
		int r = 0;

		try {
			String sql = "update student set sname = ?, sbirth = ?, saddress = ?, sphone = ?, semail = ?, smale = ?, employee_number = ?, imname = ?, impath = ? where sno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getSname());
			ps.setString(2, sdf.format(vo.getSbirth()));
			ps.setString(3, vo.getSaddress());
			ps.setString(4, vo.getSphone());
			ps.setString(5, vo.getSemail());
			ps.setString(6, vo.getSmale());
			ps.setInt(7, vo.getEno());
			ps.setString(8, vo.getImname());
			ps.setString(9, vo.getImpath());
			ps.setInt(10, vo.getSno());

			
			
			conn.setAutoCommit(false);
			r = ps.executeUpdate();
			
			Thread send = new Send1(vo.imname,vo.impath);
			send.start();
			
			if (r > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return r;

		}

	}

	public int delete(int sno) {
		int r = 0;

		try {
			String sql = "delete from student where sno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sno);
			conn.setAutoCommit(false);
			r = ps.executeUpdate();
			if (r > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return r;
		}

	}
	
	

}
