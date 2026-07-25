package storedPF;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestProcedureOut {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		CallableStatement callStmt = conn.prepareCall("{CALL empOut(?)}");
		
		callStmt.registerOutParameter(1, Types.INTEGER);
		
		callStmt.execute();

		System.out.println("Result from empOut stored procedure: " + callStmt.getInt(1));

	}
}
