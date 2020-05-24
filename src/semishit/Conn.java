package semishit;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

	public static Connection getConn() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.22:1521:xe";
		String dbUser="chta";
		String dbPwd="chta";
		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
			conn=DriverManager.getConnection(url, dbUser, dbPwd);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}