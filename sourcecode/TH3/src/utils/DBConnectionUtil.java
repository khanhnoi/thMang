package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionUtil {
	private static final String URL="jdbc:mysql://localhost:3306/dulieu";
	private static final String USER="root";
	private static final String PASSWORD="";
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return conn;
	}
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void close(Statement st) {
		if(st!=null) {
			try {
				st.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn,Statement st,ResultSet rs) {
		close(conn);
		close(st);
		close(conn);
	}
	public static void close(Connection conn, PreparedStatement pst) {
		
		close(conn);
		close(pst);
	}

}
