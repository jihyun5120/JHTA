package semishit;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarDao {
	Connection conn = null;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date today = new Date();

	public CalendarDao() {
		conn = DBConn.getConn();
	}

	public int Cinput(CalendarVo1 vo) {
		int r = 0;
		PreparedStatement ps = null;

		try {
			
			
			String sql = "insert into attendance values (?, ?, ?, ?, ?, ?) ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getSno());
			ps.setString(2, sdf.format(vo.getSdate()));
			ps.setTimestamp(3, new java.sql.Timestamp(vo.getStin().getTime())); 
			ps.setTimestamp(4, new java.sql.Timestamp(vo.getStout().getTime()));
			ps.setString(5, vo.getStatus());
			ps.setString(6, vo.getSno() + "" + sdf.format(vo.getSdate()));

			conn.setAutoCommit(false);
			r = ps.executeUpdate();
			if (r > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return r;
		}
	}

	public int update(CalendarVo1 vo) {
		int r = 0;
		PreparedStatement ps = null;

		try {
			String sql = "update attendance set sno = ?, stdate = ?, stin = ?, stout = ?, status = ? where nodate = ?  ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getSno());
			ps.setString(2, sdf.format(vo.getSdate()));
			ps.setTimestamp(3, new java.sql.Timestamp(vo.getStin().getTime())); 
			ps.setTimestamp(4, new java.sql.Timestamp(vo.getStout().getTime()));
			ps.setString(5, vo.getStatus());
			ps.setString(6, vo.getSno() + "" + sdf.format(vo.getSdate()));
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

	public int delete(String str) {
		int r = 0;
		PreparedStatement ps = null;
		try {
			String sql = "delete from attendance where nodate = ?";
			ps = conn.prepareCall(sql);
			ps.setString(1, str);
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
	
	public CalendarVo1 Com(String str) {
		CalendarVo1 vo = null;

		try {
			String sql = "select stin, stout from Attendance where nodate = ? ";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, str);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vo = new CalendarVo1();
				vo.setStin(rs.getTimestamp("stin"));
				vo.setStout(rs.getTimestamp("stout"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return vo;
	}

	public CalendarVo1 search(String str) {
		CalendarVo1 vo = null;

		try {
			String sql = "select sno, stdate, stin, stout, status from Attendance where nodate = ? ";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, str);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vo = new CalendarVo1();
				vo.setSno(rs.getInt("sno"));
				vo.setSdate(rs.getDate("stdate"));
				vo.setStin(rs.getTimestamp("stin"));
				vo.setStout(rs.getTimestamp("stout"));
				vo.setStatus(rs.getString("status"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return vo;
	}

	public int check(String str) {
		int ck = 0;
		try {
			String sql = "select * from attendance where nodate = ? ";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, str);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ck = 1;
			} else {
				ck = 0;

			}

		} catch (Exception e) {
			System.out.println("nodata°ª ¾øÀ½");
			e.printStackTrace();
		} finally {
			return ck;
		}

	}

}
