package semishit;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ScDao {
	Connection conn;
	DefaultTableModel tm;
	
	public ScDao(){
		conn = Conn.getConn();
	}
	
	public DefaultTableModel search(String str) {
		Vector vec=null;
		
		String sql = " select st.sno, st.sname, sc.subject, sc.score, sc.pass, sc.ntry, sc.rdate "
				   + " from student st left outer join score sc"
				   + " on st.sno = sc.sno "
				   + " where st.sno like ? "
				   + " or st.sname like ? "
				   + " or sc.subject like ? "
				   + " or sc.score like ? "
				   + " or sc.pass like ? "
				   + " or sc.ntry like ? "
				   + " or sc.rdate like ?";
		
		try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+str+"%");
		pstmt.setString(2, "%"+str+"%");
		pstmt.setString(3, "%"+str+"%");
		pstmt.setString(4, "%"+str+"%");	
		pstmt.setString(5, "%"+str+"%");
		pstmt.setString(6, "%"+str+"%");
		pstmt.setString(7, "%"+str+"%");
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData meta = pstmt.getMetaData();
		int cc = meta.getColumnCount();
		tm=new DefaultTableModel();
		for(int i=1; i<=cc; i++) {
			tm.addColumn(meta.getColumnName(i));
		}
		
		while(rs.next()) {
			vec = new Vector();
			for(int i=1; i<=cc; i++) {
				vec.add(rs.getString(i));
			}
			tm.addRow(vec);
		}
		pstmt.close();
		rs.close();
		conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return tm;
		}
	}
	
	public ScVo searchsno(int sno) {
		ScVo vo = null;
		
		String sql = " select st.sno, st.sname, sc.subject, sc.score, sc.pass, sc.ntry, sc.rdate "
				   + " from student st left outer join score sc "
				   + " on st.sno = sc.sno"
				   + " where st.sno = ?";
		try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sno);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			vo = new ScVo();
			vo.setSno(rs.getInt("sno"));
			vo.setName(rs.getString("sname"));
			vo.setSub(rs.getString("subject"));
			vo.setSco(rs.getInt("score"));
			vo.setPass(rs.getString("pass"));
			vo.setnTry(rs.getString("ntry"));
			vo.setrDate(rs.getDate("rdate"));
		}
		pstmt.close();
		rs.close();
		conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return vo;
		}
		
	}
	
	public int insert(ScVo vo) {
		int r = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "insert into score values(?,?,?,?,?,?)";
		try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		
		pstmt.setInt(1, vo.getSno());
		pstmt.setString(2, vo.getSub());
		pstmt.setInt(3, vo.getSco());
		pstmt.setString(4, vo.getPass());
		pstmt.setString(5, vo.getnTry());
		pstmt.setString(6, sdf.format(vo.getrDate()));
		r = pstmt.executeUpdate();
		conn.setAutoCommit(false);
		if(r>0) {
			conn.commit();
			pstmt.close();
			conn.close();
		}
		else conn.rollback();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return r;
		}
		
		
		
	}
	
	public int update(ScVo vo) {
		int r = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = " update score set subject=?, score=?, pass=?, ntry=?, rdate=? where sno=? ";
		try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getSub());
		pstmt.setInt(2, vo.getSco());
		pstmt.setString(3, vo.getPass());
		pstmt.setString(4, vo.getnTry());
		pstmt.setString(5, sdf.format(vo.getrDate()));
		pstmt.setInt(6, vo.getSno());
		r = pstmt.executeUpdate();
		conn.setAutoCommit(false);
		if(r>0) {
			conn.commit();
			pstmt.close();
			conn.close();
		}
		else conn.rollback();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return r;
		}
	}
	
	public int delete(int sno) {
		int r = 0;
		
		String sql = "delete from score where sno= ?";
		try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sno);
		r = pstmt.executeUpdate();
		conn.setAutoCommit(false);
		if(r>0) {
			conn.commit();
			pstmt.close();
			conn.close();
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return r;
		}
	}
}
