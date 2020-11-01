package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVien;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class ThemnhanvienController
 */
@WebServlet("/ThemnhanvienController")
public class ThemnhanvienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NhanVienBO nhanVienBO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemnhanvienController() {
		super();
		// TODO Auto-generated constructor stub
		nhanVienBO=new NhanVienBO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/NhanVien/add.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String ma=request.getParameter("ma");
		String ten=request.getParameter("ten");
		String diachi=request.getParameter("diachi");
		String idpb=request.getParameter("idpb");
		
		NhanVien nv=new NhanVien(ma, ten, diachi, idpb);
		int addNV=nhanVienBO.addItem(nv);
		if(addNV>0)
		{
			response.sendRedirect(request.getContextPath()+"/NhanVienController?msg=1");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/ThemnhanvienController?msg=0");
			return;
		}
	}

}
