package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.bean.NhanVien;
import model.dao.NhanVienDAO;

public class NhanVienBO {
	private NhanVienDAO nhanvienDA0=new NhanVienDAO();
	public List<NhanVien> getItems(){
		return nhanvienDA0.getItems();
	}
	public int delItem(String id) {
		return nhanvienDA0.delItem(id);
	}
	public NhanVien getItemByid(String id) {
		return nhanvienDA0.getItemByid(id);
	}
	public int editItem(NhanVien item) {
		return nhanvienDA0.editItem(item);
	}
	public int addItem(NhanVien nv) {
		return nhanvienDA0.addItem(nv);
	}
	public ArrayList<NhanVien> getItemsbyidpb(String idpb) {
		// TODO Auto-generated method stub
		return nhanvienDA0.getItemsbyidpb(idpb);
	}
	public NhanVien searchNV(String name) {
		return nhanvienDA0.searchNV(name);
	}
	public int delALL() {
		// TODO Auto-generated method stub
		return nhanvienDA0.delALL();
	}
	
	

}
