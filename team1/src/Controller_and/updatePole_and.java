package Controller_and;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.poleDAO;
import Model.poleVO;

@WebServlet("/updatePole_and")
public class updatePole_and extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8"); // �ȵ���̵�� UTF-8
		
		String pole_code = request.getParameter("pole_code");
		String pole_office = request.getParameter("pole_office");
		String pole_high = request.getParameter("pole_high");
		String pole_down = request.getParameter("pole_down");
		String pole_com = request.getParameter("pole_com");
		String transformer_yn = request.getParameter("transformer_yn");
		String emp_id = request.getParameter("emp_id");
		String pole_comment = request.getParameter("pole_comment");
		
		
		poleDAO dao = new poleDAO();
		
		int cnt = dao.pole_update_and(pole_code, pole_office, pole_high, pole_down, pole_com, transformer_yn, emp_id, pole_comment);
		
		PrintWriter out = response.getWriter();
		if(cnt>0) {
			System.out.println("��������");
		}else {
			System.out.println("��������");
			out.print("fail");
		}
		request.setCharacterEncoding("UTF-8"); // �ȵ���̵�� UTF-8
	
	}

}
