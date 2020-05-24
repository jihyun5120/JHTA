package m_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpInsert {

	public EmpInsert() {
		try {	
			Connection conn = DBConn.getConn();
			
			String sql = "insert into emp1(employee_id, last_name, hire_date, salary, job_id, email) values(?,?,?,?,?,?)";
			PreparedStatement pstmt;
				pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 500);
			pstmt.setString(2, "hong");
			pstmt.setDate(3, new Date(2020,01,15));
			pstmt.setInt(4, 10000);
			pstmt.setInt(5, 100);
			pstmt.setString(6, "hello");
			
			conn.setAutoCommit(false); //기본은 true
			int cnt = pstmt.executeUpdate();
			if(cnt>0) { //정상적으로 입력되면.
				conn.commit();
				System.out.println("정상입력되었습니다.");
			}else {
				conn.rollback();
				System.out.println("입력중 오류가 발생했습니다.");
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EmpInsert();

	}

}
