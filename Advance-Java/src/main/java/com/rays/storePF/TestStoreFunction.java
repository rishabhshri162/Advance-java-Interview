package com.rays.storePF;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestStoreFunction {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");

		CallableStatement callstmt = conn.prepareCall("{?=CALL square(?)}");

		callstmt.registerOutParameter(1, Types.INTEGER);

		callstmt.setInt(2, 2);

		callstmt.execute();

		System.out.println(callstmt.getInt(1));

		conn.close();


	}
}
