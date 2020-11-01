package model.bean;

public class NhanVien {

	private String idnv;
	private String hoten;
	private String diachi;
	private String idpb;
	private PhongBan pb;
	public PhongBan getPb() {
		return pb;
	}
	public void setPb(PhongBan pb) {
		this.pb = pb;
	}
	public String getIdnv() {
		return idnv;
	}
	public void setIdnv(String idnv) {
		this.idnv = idnv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getIdpb() {
		return idpb;
	}
	public void setIdpb(String idpb) {
		this.idpb = idpb;
	}
	public NhanVien(String idnv, String hoten, String diachi, String idpb) {
		super();
		this.idnv = idnv;
		this.hoten = hoten;
		this.diachi = diachi;
		this.idpb = idpb;
	}
	public NhanVien() {
		super();
	}
	public NhanVien(String idnv, String hoten, String diachi,PhongBan pb) {
		super();
		this.idnv = idnv;
		this.hoten = hoten;
		this.diachi = diachi;
		this.pb = pb;
	}
	
	

}
