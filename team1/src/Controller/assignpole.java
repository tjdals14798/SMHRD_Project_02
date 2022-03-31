package Controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.xml.ws.Response;

import Model.poleDAO;
import Model.tiltDAO;

 

@WebServlet("/assignpole")

public class assignpole extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		request.setCharacterEncoding("euc-kr");		
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
		
		poleDAO dao = new poleDAO();
		tiltDAO tao = new tiltDAO();
		
		/* ---------------------------------------�����---------------------------------- */
		int cnt = dao.addmachine(mac_code);
		
		if(cnt>0) {
			System.out.println("����ϼ���!");
		} else {
			System.out.println("����Ͻ���!");
		}
		/* ---------------------------------------�����---------------------------------- */
		
		/* ---------------------------------------�⺻�����---------------------------------- */
		cnt = tao.insert_tilt(mac_code);
		
		if(cnt>0) {
			System.out.println("�⺻�� ���� ����!");
		} else {
			System.out.println("�⺻�� ���� ����!");
		}
		/* ---------------------------------------�⺻�����---------------------------------- */
		
		/* ---------------------------------------���ֵ��---------------------------------- */
		cnt = dao.addpole(pole_code, mac_code, pole_height, pole_addr, pole_high, pole_down, pole_com, transformer_yn, pole_level, emp_id, pole_office, pole_date);

		if(cnt>0) {
			System.out.println("���Լ���!");
			//forward ������� ������ �̵�
			RequestDispatcher rd = request.getRequestDispatcher("Main.jsp");
			//request������ ����ؾ��� ������ ����
			request.setAttribute("pole_code", pole_code);
			//������ �̵��� �� request, response��ü ����
			rd.forward(request, response);
		} else {
			System.out.println("���Խ���!");
			response.sendRedirect("Main.jsp");
		}
		/* ---------------------------------------���ֵ��---------------------------------- */
	}
}