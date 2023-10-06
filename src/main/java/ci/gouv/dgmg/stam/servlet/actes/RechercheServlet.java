package ci.gouv.dgmg.stam.servlet.actes;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PRServlet
 */
@WebServlet(
	urlPatterns = {"/actes/recherches","/actes/recherches/add","/actes/recherches/modify",
			"/actes/recherches/del"},
	description = "This servlet is intented to manage recherche pages"
		)
public class RechercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
    public RechercheServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if(uri.endsWith("/stam/actes/recherches/add")){
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/recherche/add-pr.jsp");
		}
		if(uri.endsWith("/stam/actes/recherches/modify")) {
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/recherche/add-pr.jsp");
		}
		if(uri.endsWith("/stam/actes/recherches/del")) {
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/recherche/add.jsp");
		}
		if(uri.endsWith("/stam/actes/recherches")) {
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/recherche/recherches.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
