package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.bean.NhanVien;
import model.bean.PhongBan;
import utils.DBConnectionUtil;

public class PhongBanDAO {

	private Statement st;
	private ResultSet rs;
	private Connection conn;
	private PreparedStatement pst;

	public List<PhongBan> getItems() {
		List<PhongBan> pbList=new ArrayList<PhongBan>();
		conn=DBConnectionUtil.getConnection();
		final String sql="SELECT idpb,mota,thoigian FROM phongban";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				PhongBan pb=new PhongBan(rs.getString("idpb"), rs.getString("mota"), rs.getString("thoigian"));
				pbList.add(pb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(conn,st,rs);
		}
		
		return pbList;
	}
	
	public PhongBan getItembyId(String idpb) {
		PhongBan objpb=null;
		conn=DBConnectionUtil.getConnection();
		final String sql="SELECT idpb,mota,thoigian FROM phongban WHERE idpb=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, idpb);
			rs=pst.executeQuery();
			while(rs.next())
			{
				 objpb=new PhongBan(rs.getString("idpb"), rs.getString("mota"), rs.getString("thoigian"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(conn,st,rs);
		}
		
		return objpb;
	}
	public int addItem(PhongBan pb) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		final String sql = "INSERT INTO phongban(idpb,mota,thoigian) VALUES(?,?,?) ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, pb.getIdpb());
			pst.setString(2, pb.getMota());
			pst.setString(3, pb.getThoigian());
			
			result = pst.executeUpdate();
			System.out.println("sucess" + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(new PhongBanDAO().delAll());
	}

	public int editItem(PhongBan pb) {
		int result=0;
		conn=DBConnectionUtil.getConnection();
		final String sql="UPDATE phongban SET mota=?,thoigian=? WHERE idpb=?"; 
		try {
			pst= conn.prepareStatement(sql);
			
			pst.setString(1,pb.getMota());
			pst.setString(2,pb.getThoigian());
			pst.setString(3, pb.getIdpb());
			
			result=pst.executeUpdate();
			System.out.println("sucess"+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectionUtil.close(conn, pst);
		}
		return result;

	}

	public int delItem(String id) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		final String sql = "DELETE FROM phongban WHERE idpb=? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			result = pst.executeUpdate();
			System.out.println("sucess:" + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}

	public ArrayList<PhongBan> searchPB(String name) {
		ArrayList<PhongBan> listItem = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		final String sql="SELECT idpb,mota,thoigian FROM phongban WHERE idpb LIKE ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1, "%"+name+"%");
			
			rs=pst.executeQuery();
			while (rs.next()) {
				PhongBan pb=new PhongBan(rs.getString("idpb"), rs.getString("mota"), rs.getString("thoigian"));
				listItem.add(pb);


				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn,pst,rs);
		}
		System.out.println("sanh sach phong ban"+listItem.size());
		return listItem;
	}

	

	public int delAll() {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		final String sql = "DELETE FROM phongban";
		try {
			st=conn.createStatement();
			
			result = st.executeUpdate(sql);
			System.out.println("sucess:" + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}
	

}
