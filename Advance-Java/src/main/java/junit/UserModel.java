package junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserModel {

	public static Integer nextPk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select max(id) from junit");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;
	}

	public static UserBean findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from junit where id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setSalary(rs.getInt(1));

		}
		return bean;

	}

	public UserBean findByLogin(String name) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from junit where name = ?");

		ps.setString(1, name);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setSalary(rs.getInt(1));

		}
		return bean;

	}

	public static void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into junit values(?, ?, ?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getSalary());

		int i = ps.executeUpdate();

		System.out.println("Data Inserted " + i);

	}

	public static void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement ps = conn.prepareStatement("update junit set name = ?, salary = ? where id = ?");

		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getSalary());
		ps.setInt(3, bean.getId());

		int i = ps.executeUpdate();

		System.out.println("Data Updated " + i);

	}

	public static void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement ps = conn.prepareStatement("delete from junit where id = ?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();

		System.out.println("Data Deleted " + i);

	}

}