package ci.gouv.dgmg.stam.servlet.renouvellements;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RenouvellementAgrementServlet
 */
@WebServlet(
		urlPatterns = {"/renouvellement/recherches","/renouvellement/recherches/add",
				"/renouvellement/recherches/modify","/renouvellement/recherches/delete"}
		)
public class RenouvellementRechercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
    public RenouvellementRechercheServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if(uri.endsWith("/stam/renouvellement/recherches/add")) {
			dispatcher = this.getServletContext()
			.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/recherche/add-renvpr.jsp");
		}
		if(uri.endsWith("/stam/renouvellement/recherches/modify")) {
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/recherche/add-renvpr.jsp");
		}
		if(uri.endsWith("/stam/renouvellement/recherches/del")) {
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/recherche/dmdnv.jsp");
		}
		if(uri.endsWith("/stam/renouvellement/recherches")) {
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/recherche/renvpr.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
