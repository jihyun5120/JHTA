package m_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	
	public static Connection getConn() { //static������ ���� ���� : ���� DBConnŬ������ ��ü�� ������� ������ ���� �ʰ� ����ϱ� ����.
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUser = "hr";
		String dbPwd = "hr";

		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, dbUser, dbPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}