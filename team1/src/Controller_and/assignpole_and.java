package Controller_and;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.xml.ws.Response;

import Model.poleDAO;
import Model.tiltDAO;

 

@WebServlet("/assignpole_and")

public class assignpole_and extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		request.setCharacterEncoding("UTF-8"); // �ȵ���̵�� UTF-8
		
		String pole_code = request.getParameter("pole_code");
		String mac_code = request.getParameter("pole_code");
		String pole_height = request.getParameter("pole_height");
		String pole_addr = request.getParameter("pole_addr");
		String pole_high = request.getParameter("pole_high");
		String pole_down = request.getParameter("pole_down");
		String pole_com = request.getParameter("pole_com");
		String transformer_yn = request.getParameter("transformer_yn");
		String emp_id = request.getParameter("emp_id");
		String pole_level = request.getParameter("pole_level");
		String pole_office = request.getParameter("pole_office");
		String pole_date = request.getParameter("pole_date");
		
		tiltDAO tao = new tiltDAO();
		poleDAO dao = new poleDAO();
		
		int cnt = dao.addmachine(mac_code);

		cnt = tao.insert_tilt(mac_code);
		
		if(cnt>0) {
			System.out.println("�⺻�� ���� ����!");
		} else {
			System.out.println("fail");
		}
		
		PrintWriter out = response.getWriter();
		
		cnt = dao.addpole(pole_code, mac_code, pole_height, pole_addr, pole_high, pole_down, pole_com, transformer_yn, pole_level, emp_id, pole_office, pole_date);
		if(cnt>0) {
			System.out.println("���Լ���!");
		} else {
			System.out.println("���Խ���!");
			out.print("fail");
		}
		response.setCharacterEncoding("UTF-8");
		
		
	}

	

 

}