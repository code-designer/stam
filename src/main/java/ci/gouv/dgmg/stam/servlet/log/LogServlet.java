package ci.gouv.dgmg.stam.servlet.log;

import java.io.IOException;

import ci.gouv.dgmg.stam.servlet.MainServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(
		urlPatterns = {"/home","/logout"}
		)
public class LogServlet extends MainServlet {
	private static final long serialVersionUID = 1L;
       
    public LogServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if(uri.endsWith("/stam/home")) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("/");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
