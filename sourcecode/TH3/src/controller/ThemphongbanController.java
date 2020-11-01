package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.PhongBan;
import model.bo.PhongBanBO;

/**
 * Servlet implementation class ThemphongbanController
 */
@WebServlet("/ThemphongbanController")
public class ThemphongbanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhongBanBO phongBanBO;
	public ThemphongbanController() {
		super();
		phongBanBO=new PhongBanBO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/PhongBan/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		SimpleDateFormat date=new SimpleDateFormat("dd-MM-YYYY");
		String ma=request.getParameter("ma");
		String mota=request.getParameter("mota");
		
		String thoigian=request.getParameter("thoigian");
		PhongBan pb=new PhongBan(ma, mota, thoigian);
		
		int addpb=phongBanBO.addItem(pb);
		if(addpb>0)
		{
			response.sendRedirect(request.getContextPath()+"/PhongBanController?msg=1");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/ThemphongbanController?msg=0");
			return;
		}
		
		
	}

}
