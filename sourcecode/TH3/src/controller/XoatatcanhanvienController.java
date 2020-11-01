package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.NhanVienBO;
import model.bo.PhongBanBO;

/**
 * Servlet implementation class XoatatcaphongbanController
 */
@WebServlet("/XoatatcanhanvienController")
public class XoatatcanhanvienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XoatatcanhanvienController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		NhanVienBO nhanvienBO=new NhanVienBO();
		
		 int del=nhanvienBO.delALL();
		if(del>0)
		{
			response.sendRedirect(request.getContextPath()+"/NhanVienController?msg=4");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/NhanVienController?msg=0");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
