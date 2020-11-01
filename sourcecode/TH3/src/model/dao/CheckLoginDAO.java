package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.User;
import utils.DBConnectionUtil;



public class CheckLoginDAO {
	
	
	private static Connection conn;
	private Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	public boolean isExistUser(String userName,String password) {
		//connect vao database lam mo so viec
		//tat ca nhung cau SQL deu phai dat o DAO
			conn=DBConnectionUtil.getConnection();
			String sql="SELECT Username,PassWord FROM admin WHERE Username=? AND PassWord=?";
			try {
				pst=conn.prepareStatement(sql);
				pst.setString(1, userName);
				pst.setString(2, password);
				rs=pst.executeQuery();
				if (rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		return false;
		
	}
	public ArrayList<User> getUserList(String userName){
		ArrayList<User> result=new ArrayList<User>();
		//connect vao database lam mot so viec
		User user=new User();
		user.setUsername("Ha");
		
		result.add(user);
		
		
		return result;
	}
	public static void main(String[] args) {
		CheckLoginDAO dao=new CheckLoginDAO();
		System.out.println(dao.isExistUser("admin", "123"));
	}
	public User CheckLogin(String username, String password) {
		User user = null;
		conn = DBConnectionUtil.getConnection();
		final String sql = "SELECT * FROM admin WHERE Username=? and PassWord=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs=pst.executeQuery();
			while (rs.next()) {
				user=new User(rs.getString("Username"), rs.getString("PassWord"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}

		return user;
	}
}
