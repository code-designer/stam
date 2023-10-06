package ci.gouv.dgmg.stam.servlet.demandes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DemandeRechercheServlet
 */
@WebServlet(
		urlPatterns = {"/demandes/recherches","/demandes/recherches/add",
				"/demandes/recherches/modify","/demandes/recherches/delete"}
		)
public class DemandeRechercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
    public DemandeRechercheServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if(uri.endsWith("/stam/demandes/recherches/add")) {
			dispatcher = this.getServletContext()
			.getRequestDispatcher("/WEB-INF/demandeView/demande/recherche/add-dmdpr.jsp");
		}
		if(uri.endsWith("/stam/demandes/recherches/modify")) {
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/demande/recherche/add-dmdpr.jsp");
		}
		if(uri.endsWith("/stam/demandes/recherches/del")) {
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/demande/recherche/dmdnv.jsp");
		}
		if(uri.endsWith("/stam/demandes/recherches")) {
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/demande/recherche/dmdpr.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
