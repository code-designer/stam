package ci.gouv.dgmg.stam.servlet.users;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(
	urlPatterns = {"/user/profile","/user/settings","/user/password", "/user/logout", "/users"}
		)
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session == null) {
			this.dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/login/index.jsp");
			this.dispatcher.forward(request, response);
			return;	
		} 
		String uri = request.getRequestURI().toString();
		
		if(uri.endsWith("/stam/users"))
			this.dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/userview/users.jsp");
		
		if(uri.endsWith("/stam/user/profile"))
			this.dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/userview/uinfos.jsp");
		
		if(uri.endsWith("/stam/user/logout")) {
			session.invalidate();
			response.sendRedirect(this.getServletContext().getContextPath() + "/");
			return;
		}
		this.dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
