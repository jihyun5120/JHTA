package semishit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class BoardDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet set;
	
	public BoardDao() {
		conn=DBConn.getConn();
	}
	
	public DefaultTableModel dList(int in, String fi) {
		DefaultTableModel dm = new DefaultTableModel();
		
		try {
			if(in==0) {
				String query = "select num 번호, writer 작성자 , title 제목, to_char(writedate, 'rrrr-MM-dd') 작성일자, readcount 조회수  from board";
				pstmt = conn.prepareStatement(query);
			}else if(in==1){
				String query = "select num 번호, writer 작성자 , title 제목, to_char(writedate, 'rrrr-MM-dd') 작성일자, readcount 조회수  from board where title like ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%"+fi+"%");
			}else if(in==3) {
				String query = "select num 번호, writer 작성자 , title 제목, to_char(writedate, 'rrrr-MM-dd') 작성일자, readcount 조회수  from board where conten like ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%"+fi+"%"); 
			}
			ResultSetMetaData rsmd = pstmt.getMetaData();
			
			int cnt = rsmd.getColumnCount();
			for(int i=1; i<=cnt; i++) { //1부터 시작
				dm.addColumn(rsmd.getColumnName(i));
			}
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector row = new Vector<>();
				for(int i=1; i<=cnt; i++) {
					row.add(rs.getString(i));
				}
				dm.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(set!=null) try { set.close();} catch (Exception e2) {e2.printStackTrace();}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		return dm;
	}
	
	public DefaultTableModel list() {
		String query = "select num 번호, writer 작성자 , title 제목, to_char(writedate, 'rrrr-MM-dd') 작성일자, readcount 조회수 from board";
		DefaultTableModel dm = new DefaultTableModel();
		
		try {
			pstmt = conn.prepareStatement(query);
			ResultSetMetaData rsmd = pstmt.getMetaData();
			
			int cnt = rsmd.getColumnCount();
			for(int i=1; i<=cnt; i++) { //1부터 시작
				dm.addColumn(rsmd.getColumnName(i));
			}
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector row = new Vector<>();
				for(int i=1; i<=cnt; i++) {
					row.add(rs.getString(i));
				}
				dm.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(set!=null) try { set.close();} catch (Exception e2) {e2.printStackTrace();}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		return dm;
	}
	
	public BoardVo deList(String num) {
		BoardVo vo = null;
		upCnt(num);
		
		String query = "select num , to_char(writedate, 'rrrr-MM-dd') we, title , conten , "
				+ " readcount , writer from board where num=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, num);
			
			set=pstmt.executeQuery();
			if(set.next()) {
				vo = new BoardVo();
				vo.setNumber(set.getInt("num"));
				vo.setWritedate(set.getDate("we"));
				vo.setTitle(set.getString("title"));
				vo.setContent(set.getString("conten"));
				vo.setReadcount(set.getInt("readcount"));
				vo.setWriter(set.getString("writer"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(set!=null) try { set.close();} catch (Exception e2) {e2.printStackTrace();}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		return vo;
	}
	
	public int insert(BoardVo vo) {
		int r =0;
		String query = "insert into board values(board_se.nextval, sysdate, ?, ?, 0, ?)";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent()); 
			pstmt.setString(3, vo.getWriter());
			
			r = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
			
		}
		return r;
	}
	
	public int update(String t, String c, int num) {
		int r = 0;
		String query = "update board set title=?, conten=? where num=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, t);
			pstmt.setString(2, c);
			pstmt.setInt(3, num);
			
			r = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		return r;
	}
	
	public int delete(int num) {
		int r = 0;
		String query = "delete from board where num=?";
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, num);
			r = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		return r;
	}
	
	public void upCnt(String num) {
		String query = "update board set readcount=readcount+1 where num=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(pstmt!=null) try {pstmt.close();} catch(Exception e2) {e.printStackTrace();}
			if(conn!=null) try {conn.close();} catch(Exception e2) {e.printStackTrace();}
		}
	}
	
	public List<BoardVo> ch(){
		List<BoardVo> list= new ArrayList<BoardVo>();
		String query="select price from board";
		
		try {
			pstmt=conn.prepareStatement(query);
			set=pstmt.executeQuery();
			
			while(set.next()) {
				BoardVo vo = new BoardVo();
				vo.setPrice(set.getInt("price"));
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			if(set!=null) try { set.close();} catch (Exception e2) {e2.printStackTrace();}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		return list;
	}
}
