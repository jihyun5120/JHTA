package m_jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class ProcedureCall {
	public static void main(String[] args) throws Exception{
		Connection conn = DBConn.getConn();
		String sql = "{call AAA(?,?)}";
		CallableStatement cst = conn.prepareCall(sql);
		cst.setString(1, "aaaaaaa");
		cst.registerOutParameter(2, Types.VARCHAR);
		
		cst.executeQuery();
		
		String a2 = cst.getString(2);
		System.out.println(a2);
		
		System.out.println("--------------------------");
		sql= "{call BBB(?,?,?)}";
		cst = conn.prepareCall(sql);
		cst.setInt(1, 123);
		cst.setInt(2, 456);
		cst.registerOutParameter(3, Types.INTEGER);
		
		cst.executeQuery();
		
		String a3 = cst.getString(3);
		System.out.println(a3);
	}
}
