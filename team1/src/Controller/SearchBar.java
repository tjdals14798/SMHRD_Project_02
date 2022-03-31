package Controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchBar")

public class SearchBar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String pole_height = request.getParameter("pole_height");
		String pole_date = request.getParameter("pole_date");
		String transformer_yn = request.getParameter("transformer_yn");
		String emp_id = request.getParameter("emp_id");
		String pole_office = request.getParameter("pole_office");
		
		System.out.println("�˻��� Ȯ��");
		System.out.println(pole_height);
		System.out.println(pole_date);
		System.out.println(transformer_yn);
		System.out.println(emp_id);
		System.out.println(pole_office);
		
		
		if(pole_height!=null) {
			String sql = "Select * from pole_info where 1=1 DESC limit 10";
		}else {
			String sql = "Select * from pole_info where pole_height = ? and pole_date = ? transformer_yn = ? emp_id = ? pole_office = ?";
		}
		
		
	}

}
