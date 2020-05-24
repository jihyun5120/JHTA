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
			
			conn.setAutoCommit(false); //�⺻�� true
			int cnt = pstmt.executeUpdate();
			if(cnt>0) { //���������� �ԷµǸ�.
				conn.commit();
				System.out.println("�����ԷµǾ����ϴ�.");
			}else {
				conn.rollback();
				System.out.println("�Է��� ������ �߻��߽��ϴ�.");
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
