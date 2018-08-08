package com.itcast.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class JdbcTest {

	@Test
	public void jdbcDemo() throws Exception {
		//加载数据库驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//获取连接
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.116.128:1521:orcl", "myOracle", "myOracle");
		//得到预编译对象
		PreparedStatement pstm = connection.prepareStatement("select * from person where pid=?");
		//给占位符赋值
		pstm.setObject(1, 1);
		//执行数据库操作
		ResultSet rs = pstm.executeQuery();
		//输出结果
		while(rs.next()) {
			System.out.println(rs.getObject("pname"));
		}
	}
	@Test
	public void OracleTest() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.116.128:1521:orcl","myOracle","myOracle");
		PreparedStatement preparedStatement = con.prepareStatement("select * from person where pid =?");
		preparedStatement.setObject(1, 2);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getObject(2));
		}
	}
	@Test
	public void Demo() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.116.128:1521:orcl","myOracle","myOracle");
		PreparedStatement pstm = con.prepareStatement("select * from person where pid=?");
		pstm.setObject(1, 2);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getObject(2));
		}
	}
	
	
	
}
