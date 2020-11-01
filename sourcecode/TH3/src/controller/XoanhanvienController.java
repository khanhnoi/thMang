package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.NhanVienBO;

/**
 * Servlet implementation class XoanhanvienController
 */
@WebServlet("/XoanhanvienController")
public class XoanhanvienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XoanhanvienController() {
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
		NhanVienBO nhanVienBO=new NhanVienBO();
		String id=request.getParameter("id");
		int del=nhanVienBO.delItem(id);
		if(del>0)
		{
			response.sendRedirect(request.getContextPath()+"/NhanVienController?msg=3");
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
