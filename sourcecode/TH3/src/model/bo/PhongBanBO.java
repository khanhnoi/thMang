package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.bean.NhanVien;
import model.bean.PhongBan;
import model.dao.NhanVienDAO;
import model.dao.PhongBanDAO;

public class PhongBanBO {
	private PhongBanDAO phongbanDAO=new PhongBanDAO();
	public List<PhongBan> getItems(){
		return phongbanDAO.getItems();
	}
	public PhongBan getItembyId(String idpb) {
		return phongbanDAO.getItembyId(idpb);
	}
	public int addItem(PhongBan pb) {
		return phongbanDAO.addItem(pb);
	}
	public int editItem(PhongBan pb) {
		return phongbanDAO.editItem(pb);
	}
	public int delItem(String id) {
		return phongbanDAO.delItem(id);
	}
	public ArrayList<PhongBan> searchPB(String name) {
	return phongbanDAO.searchPB(name);
	}
	public int delALL() {
		return phongbanDAO.delAll();
	}

}
