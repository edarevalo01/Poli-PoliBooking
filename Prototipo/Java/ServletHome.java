package co.edu.poli.ing.polibooking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletHome
 */
@WebServlet("/ServletHome")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletHome() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		doGet(request, response);
		String code = request.getParameter("codigo");
		String pass = request.getParameter("password");
		System.out.println(code + " - " + pass);
		CrudUsuario user = new CrudUsuario();
		boolean successfullLogin = user.login(code, pass);
		if(successfullLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", user.retrieveUser(code));
			request.setAttribute("message", "Login Exitoso");
			if(code.equals("0987654321") && pass.equals("Ozzy123*")) {
				response.sendRedirect("admin");				
			}
			else {
				response.sendRedirect("serviceBib");
			}
		}
		else {
			request.setAttribute("message", "Login Fallido");
			doGet(request, response);
		}

	}

}
