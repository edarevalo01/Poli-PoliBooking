package co.edu.poli.ing.polibooking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.ws.runtime.dev.Session;

/**
 * Servlet implementation class ServletServicio
 */
@WebServlet("/ServletServicio")
public class ServletServicioBiblioteca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletServicioBiblioteca() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bib = request.getParameter("servicio");
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("usuario");
		if(bib == null) {
			request.setAttribute("messageSer", "Bienvenido " + user.getName());
			RequestDispatcher view = request.getRequestDispatcher("servicios.jsp");
			view.forward(request, response);
		}
		else {
			if(bib.equals("biblioteca")) {			
				request.setAttribute("messageSer", "Biblioteca");
				CrudBib solicitud = new CrudBib();
//				solicitud.create(user);
				System.out.println("solicito biblioteca");
			}
			else if(bib.equals("gimnasio")) {
				request.setAttribute("messageSer", "Has solicitado turno en el Gimnasio");			
				System.out.println("solicito gim");
			}
			else {
				request.setAttribute("messageSer", "Tienes servicio ...");
				//Esto se supone que nunca deberia pasar 
			}
			RequestDispatcher view = request.getRequestDispatcher("servicios.jsp");
			view.forward(request, response);
		}

	}

}
