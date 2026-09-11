package junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLifeCycle {

	private static Connection conn = null;
	private PreparedStatement ps = null;

	@BeforeClass
	public static void beforeClass() throws ClassNotFoundException, SQLException {
		System.out.println("Before Class");
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

	}

	@Before
	public void before() throws Exception {
		System.out.println("before");

		ps = conn.prepareStatement("insert into junit(id, name, salary)values(?, ?, ?)");

		ps.setInt(1, 6);
		ps.setString(2, "rishabh");
		ps.setInt(3, 1300);

		int i = ps.executeUpdate();
		System.out.println("data insert =" + i);
	}

	@Test
    public void test() {

    System.out.println("test method");

    int a = 10;
    int b = 20;

    assertEquals(30, a + b);
    }

	@After
	public void after() throws Exception {
		System.out.println("after");

		ps = conn.prepareStatement("select * from junit where id = ?");
		ps.setInt(1, 6);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));

		}

	}

	@AfterClass
	public static void afterClass() throws Exception {
		System.out.println("after class");

		if (conn != null) {
			conn.close();
		}

	}

}
