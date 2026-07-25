package storedPF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionHandling {

	public static void main(String[] args) {

		add();
	}

	public static void add() {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement("INSERT INTO transaction(name, salary) VALUES(?, ?)");

			pstmt.setString(1, "parth");
			pstmt.setInt(2, 50000);

			pstmt.executeUpdate();

			conn.commit();

			System.out.println("Transaction Committed Successfully");

		} catch (Exception e) {

			try {
				if (conn != null) {
					conn.rollback();
					System.out.println("Transaction Rolled Back");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} finally {

			try {
				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
