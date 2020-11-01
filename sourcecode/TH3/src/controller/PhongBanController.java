package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVien;
import model.bean.PhongBan;
import model.bo.NhanVienBO;
import model.bo.PhongBanBO;
import model.dao.NhanVienDAO;

@WebServlet("/PhongBanController")
public class PhongBanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhongBanBO phongbanBO=new PhongBanBO();

	public PhongBanController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		List<PhongBan> listPB=phongbanBO.getItems();
		request.setAttribute("listPB", listPB);
		RequestDispatcher rd=request.getRequestDispatcher("/views/PhongBan/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
