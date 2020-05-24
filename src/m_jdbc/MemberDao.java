package m_jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class MemberDao {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Connection conn;
	
	public MemberDao() {
		conn = DBConn.getConn(); //DB와 연결.
	}
	
	public int delete(String mId) {
		int r = 0;
		
		try {
			String sql = "delete from memberEx where mId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mId);
			conn.setAutoCommit(false);
			r = ps.executeUpdate();
			if(r>0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return r;			
		}
		
	}
	
	public int insert(MemberVo vo) {
		int r = 0;
		
		String sql = "insert into memberEx(mid, mName, rDate, grade) values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			ps.setString(1, vo.getmId());
			ps.setString(2, vo.getmName());
			ps.setString(3, sdf.format(vo.getrDate()));
			ps.setInt(4, vo.getGrade());
			r = ps.executeUpdate();
			if(r>0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			ps.close();
			conn.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			return r;			
		}
	}
	
	public MemberVo search(String mId) {
		MemberVo vo = new MemberVo();
		String sql = "select * from memberEx where mId=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setmId(rs.getString("mId"));
				vo.setmName(rs.getString("mName"));
				vo.setrDate(rs.getDate("rDate"));
				vo.setGrade(rs.getInt("grade"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch(Exception ex) {
			
		}finally {
			return vo;			
		}
	}
	
	public int update(MemberVo vo) {
		int r = 0;
		try {
			String sql = "update memberEx set mName = ?, rDate = ?, grade = ? where mId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			
			ps.setString(1, vo.getmName());
			ps.setString(2, sdf.format(vo.getrDate()));
			ps.setInt(3, vo.getGrade());
			ps.setString(4, vo.getmId());
			
			r = ps.executeUpdate();
			if(r>0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			ps.close();
			conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return r;
		}
	}
	
	public List<MemberVo> select(String find) {
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "select * from memberEx where mId like ? or mName like ?"; //?에 들어가는 단어가 mId나 mName에 포함되어있으면 조회.
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + find + "%"); //sql의 %?%로 넣을 수 없어서 여기서 %를 넣음. -> '%find%'가 됨.
			ps.setString(2, "%" + find + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String mId = rs.getString("mId");
				String mName = rs.getString("mName");
				Date rDate = rs.getDate("rDate");
				int grade = rs.getInt("grade");
				MemberVo vo = new MemberVo(mId, mName, rDate, grade);
				list.add(vo);
				
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return list;			
		}
	}
	
	
	
}
