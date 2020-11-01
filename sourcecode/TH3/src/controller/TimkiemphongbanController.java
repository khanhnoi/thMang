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


import model.bean.PhongBan;
import model.bo.PhongBanBO;

/**
 * Servlet implementation class TimkiemphongbanController
 */
@WebServlet("/search")
public class TimkiemphongbanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TimkiemphongbanController() {
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
		PhongBanBO phongBanBO=new PhongBanBO();
		ArrayList<PhongBan>pbs=phongBanBO.searchPB(name);
		request.setAttribute("pbs",pbs);
		RequestDispatcher rd = request.getRequestDispatcher("/views/PhongBan/search.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
