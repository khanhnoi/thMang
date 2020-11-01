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

/**
 * Servlet implementation class SuanhanvienController
 */
@WebServlet("/SuanhanvienController")
public class SuanhanvienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuanhanvienController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		NhanVienBO nhanVienBO=new NhanVienBO();
		NhanVien nv=nhanVienBO.getItemByid(id);
		if(nv==null) {
			response.sendRedirect(request.getContextPath()+"/NhanVienController?error=2");
			return;
		}
		request.setAttribute("nv", nv); 
		PhongBanBO pb=new PhongBanBO();
		PhongBan objpb=pb.getItembyId(nv.getIdpb());
		request.setAttribute("objpb", objpb);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/NhanVien/edit.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String ma=request.getParameter("ma");
		String ten=request.getParameter("ten");
		String diachi=request.getParameter("diachi");
		String mapb=request.getParameter("mapb");
		NhanVienBO nhanVienBO=new NhanVienBO();
		NhanVien nv=nhanVienBO.getItemByid(ma);
		if(nv==null) {
			response.sendRedirect(request.getContextPath()+"/NhanVienController?error=2");
			return;
		}
		
		NhanVien item=new NhanVien(ma, ten, diachi,mapb );
		if(nhanVienBO.editItem(item)>0) {
			response.sendRedirect(request.getContextPath()+"/NhanVienController?msg=2");
			return;
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("/NhanVienController?error=1");
			return;
		}
		
		
	}

}
