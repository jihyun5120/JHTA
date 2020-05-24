package m_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ScoreDao {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Connection conn;
	PreparedStatement ps;
	
	public ScoreDao() {
		conn = DBConn.getConn();
	}
	
	public int insert(ScoreVo vo) {
		int r = 0;
		
		try {
			String sql = "insert into score values(seq_score.nextval, ?, ?, ?, ?)"; //mId는 시퀀스를 사용.
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getmId());
			ps.setString(2, sdf.format(vo.getrDate()));
			ps.setString(3, vo.getSubject());
			ps.setInt(4, vo.getScore());
			
			conn.setAutoCommit(false);
			r = ps.executeUpdate();
			if(r>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch(Exception ex) {
			
		} finally {
			try {
				ps.close(); //원래는 try말고 finally에 넣는 것이 정석!
				conn.close();
			} catch (SQLException e) {}
		}
		return r;				
	}
	
	public int delete(int serial) {
		int r = 0;
		try {
			String sql = "delete from score where serial=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, serial);
			
			conn.setAutoCommit(false);
			r = ps.executeUpdate();
			if(r>0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			ps.close();
		} catch(Exception ex){
			ex.printStackTrace();
		} finally {
			return r;			
		}
		
	}
	
	public ScoreVo search(int serial) {
		ScoreVo vo = null;
		try {
			String sql = "select S.serial, S.mId, S.rDate, S.subject, S.score, M.mName from score S join memberEx M on S.mId=M.mId where S.serial=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, serial);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo = new ScoreVo();
				vo.setmId(rs.getString("mId"));
				vo.setrDate(rs.getDate("rDate"));
				vo.setSubject(rs.getString("subject"));
				vo.setScore(rs.getInt("score"));
				vo.setmName(rs.getString("mName"));
			}
			rs.close(); 
			ps.close();
//			conn.close(); 조회한 다음 수정 또는 삭제 할 거기 때문에 close하면 안됨. 

		}catch(Exception ex) {
			ex.printStackTrace();
		} finally {
		}
		return vo;			
	}
	
	public int update(ScoreVo vo) {
		int r = 0;
		try {
			String sql = "update score set rDate=?, subject=?, score=? where serial=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sdf.format(vo.getrDate()));
			ps.setString(2, vo.getSubject());
			ps.setInt(3, vo.getScore());
			ps.setInt(4, vo.getSerial());
			r = ps.executeUpdate();
			
			sql= "update memberEx set mName=?, mId=? where mId=(select mId from score where serial=?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getmName());
			ps.setString(2, vo.getmId());
			ps.setInt(3, vo.getSerial());
			
			r = ps.executeUpdate();
			
			if(r>0) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return r;			
		}
	}
	
	public List<ScoreVo> select(String find){
		List<ScoreVo> list = new ArrayList<ScoreVo>();
		String sql = "select S.serial, M.mId, M.mName, S.rDate, S.subject, S.score from memberEx M left outer join score S on M.mId=S.mId" 
					+ " where M.mId like ? or S.subject like ? or mName like ?";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, "%" + find + "%");
			ps.setString(2, "%" + find + "%");
			ps.setString(3, "%" + find + "%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ScoreVo vo = new ScoreVo();
				vo.setSerial(rs.getInt("serial"));
				vo.setmId(rs.getString("mId"));
				vo.setmName(rs.getString("mName"));
				vo.setrDate(rs.getDate("rDate"));
				vo.setSubject(rs.getString("subject"));
				vo.setScore(rs.getInt("score"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
