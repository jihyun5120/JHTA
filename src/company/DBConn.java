package company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
   public static Connection getConn() { //static형으로 만든 이유 : 괜히 DBConn클래스의 객체를 만들었다 지웠다 하지 않고 사용하기 위해.
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@192.168.0.22:1521:xe";
      String dbUser = "chta";
      String dbPwd = "chta";

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