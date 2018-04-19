package co.edu.poli.ing.polibooking;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/serviceBib")
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		String loginURI = request.getContextPath() + "/home";
		
		boolean loggedIn = session != null && session.getAttribute("usuario") != null;
		boolean loginRequest = request.getRequestURI().equals(loginURI);
		
		if(loggedIn || loginRequest) {
			chain.doFilter(request, response);
			System.out.println("Algo en el if");
		}
		else {
			response.sendRedirect(loginURI);
			System.out.println("Algo en el else");
		}
	}

}
