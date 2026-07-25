package storedPF;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestProcedureInOut {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		CallableStatement call = conn.prepareCall("{CALL empInOut(?)}");

		call.setInt(1, 2);
		
		call.registerOutParameter(1, Types.INTEGER);
		
		call.execute();
		
		System.out.println(call.getInt(1));
	}
}
