package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import model.bean.NhanVien;
import model.bean.PhongBan;
import utils.DBConnectionUtil;

public class NhanVienDAO {

	private Statement st;
	private ResultSet rs;
	private Connection conn;
	private PreparedStatement pst;

	public List<NhanVien> getItems() {
		List<NhanVien> nhvList=new ArrayList<NhanVien>();
		conn=DBConnectionUtil.getConnection();
		final String sql="SELECT idnv,hoten,diachi,idpb FROM nhanvien";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				NhanVien nhanVien=new NhanVien(rs.getString("idnv"), rs.getString("hoten"), rs.getString("diachi"), rs.getString("idpb"));
				nhvList.add(nhanVien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(conn,st,rs);
		}
		
		return nhvList;
	}
	public static void main(String[] args) {
		System.out.println(new NhanVienDAO().getItems().size());
	}
	public int delItem(String id) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		final String sql = "DELETE FROM nhanvien WHERE idnv=? ";
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
	public NhanVien getItemByid(String id) {
		NhanVien nv = null;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT idnv,hoten,diachi,idpb FROM nhanvien WHERE idnv=?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				String idnv = rs.getString("idnv");
				String hoten = rs.getString("hoten");
				String diachi = rs.getString("diachi");
				String idpb=rs.getString("idpb");
				
				nv=new NhanVien(idnv, hoten, diachi, idpb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}

		return nv;
	}
	public int editItem(NhanVien item) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		final String sql = "UPDATE nhanvien SET hoten=?,diachi=?,idpb=? WHERE idnv=?";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, item.getHoten());
			pst.setString(2, item.getDiachi());
			pst.setString(3, item.getIdpb());
			pst.setString(4, item.getIdnv());
			

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
	public int addItem(NhanVien nv) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		final String sql = "INSERT INTO nhanvien(idnv,hoten,diachi,idpb) VALUES(?,?,?,?) ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, nv.getIdnv());
			pst.setString(2, nv.getHoten());
			pst.setString(3, nv.getDiachi());
			pst.setString(4, nv.getIdpb());
			
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
	public ArrayList<NhanVien> getItemsbyidpb(String idpb) {
		ArrayList<NhanVien> nhvList=new ArrayList<NhanVien>();
		conn=DBConnectionUtil.getConnection();
		final String sql="SELECT idnv,hoten,diachi,idpb FROM nhanvien WHERE idpb=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, idpb);
			rs=pst.executeQuery();
			while(rs.next())
			{
				NhanVien nhanVien=new NhanVien(rs.getString("idnv"), rs.getString("hoten"), rs.getString("diachi"), rs.getString("idpb"));
				nhvList.add(nhanVien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(conn,st,rs);
		}
		
		return nhvList;
	}
	public NhanVien searchNV(String name) {
		NhanVien nv=null;
		conn = DBConnectionUtil.getConnection();
		final String sql="SELECT idnv,hoten,diachi,idpb FROM nhanvien WHERE idnv LIKE ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1, "%"+name+"%");
			
			rs=pst.executeQuery();
			while (rs.next()) {
				nv=new NhanVien(rs.getString("idnv"), rs.getString("hoten"), rs.getString("diachi"), rs.getString("diachi"));
				


				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn,pst,rs);
		}
		
		return nv;
	}
	public int delALL() {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		final String sql = "DELETE FROM nhanvien";
		try {
			st=conn.createStatement();
			result=st.executeUpdate(sql);
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
