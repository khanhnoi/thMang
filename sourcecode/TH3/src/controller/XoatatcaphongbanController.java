package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.PhongBanBO;

/**
 * Servlet implementation class XoatatcaphongbanController
 */
@WebServlet("/XoatatcaphongbanController")
public class XoatatcaphongbanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XoatatcaphongbanController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PhongBanBO phongBanBO=new PhongBanBO();
		
		 int del=phongBanBO.delALL();
		if(del>0)
		{
			response.sendRedirect(request.getContextPath()+"/PhongBanController?msg=4");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/PhongBanController?msg=0");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
