package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVien;
import model.bean.PhongBan;
import model.bo.NhanVienBO;
import model.bo.PhongBanBO;
import model.dao.NhanVienDAO;


@WebServlet("/searchnv")
public class TimkiemnhanvienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TimkiemnhanvienController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		String name="";
		if(request.getParameter("editbox_search")!=null) {
			name=request.getParameter("editbox_search");
			session.setAttribute("name", name);
		}
		if(session.getAttribute("name") != null) {
			name = (String)session.getAttribute("name");
		}
		NhanVienBO nhanVienBO=new NhanVienBO();
		NhanVien nv=nhanVienBO.searchNV(name);
		request.setAttribute("nv",nv);
		RequestDispatcher rd = request.getRequestDispatcher("/views/NhanVien/search.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
