package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.emp_infoDAO;
import Model.emp_infoVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");

		String emp_id = request.getParameter("emp_id");
		String emp_pw = request.getParameter("emp_pw");
		System.out.println("�α��� Ȯ��");
		System.out.println(emp_id);
		System.out.println(emp_pw);

		emp_infoDAO dao = new emp_infoDAO();
		emp_infoVO vo = dao.login(emp_id, emp_pw);

		if (vo != null) {

			HttpSession session = request.getSession();
			session.setAttribute("admin", vo);
			response.sendRedirect("Main.jsp");

		} else {
			PrintWriter out = response.getWriter();

			out.println("<script>alert('�α��� ������ ��ġ���� �ʽ��ϴ�.'); location.href='LoginMain.jsp'</script>");
			out.flush();

		}

	}

}
