package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.PhongBan;
import model.bo.PhongBanBO;

/**
 * Servlet implementation class SuaphongbanController
 */
@WebServlet("/SuaphongbanController")
public class SuaphongbanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhongBanBO phongBanBO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaphongbanController() {
		super();
		phongBanBO=new PhongBanBO();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String idpb=request.getParameter("idpb");
		PhongBan pb=phongBanBO.getItembyId(idpb);
		request.setAttribute("pb", pb);
		RequestDispatcher rd=request.getRequestDispatcher("/views/PhongBan/edit.jsp");
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
		String idpb=request.getParameter("ma");
		String mota=request.getParameter("mota");
		String thoigian=request.getParameter("thoigian");
		PhongBan pb=new PhongBan(idpb, mota, thoigian);
		int edit=phongBanBO.editItem(pb);
		if(edit>0)
		{
			response.sendRedirect(request.getContextPath()+"/PhongBanController?msg=2");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/SuaphongbanController?msg=0&idpb="+idpb);
			return;
		}
		
	}

}
