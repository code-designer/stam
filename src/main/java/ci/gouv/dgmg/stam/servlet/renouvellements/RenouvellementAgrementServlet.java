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
		urlPatterns = {"/renouvellement/agrements","/renouvellement/agrements/add",
				"/renouvellement/agrements/modify","/renouvellement/agrements/delete"}
		)
public class RenouvellementAgrementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RenouvellementAgrementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if(uri.endsWith("/stam/renouvellement/agrements/add")) {
			dispatcher = this.getServletContext()
			.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/agrement/add-renvagr.jsp");
		}
		if(uri.endsWith("/stam/renouvellement/agrements/modify")) {
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/agrement/add-renvagr.jsp");
		}
		if(uri.endsWith("/stam/renouvellement/agrements/del")) {
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/agrement/dmdnv.jsp");
		}
		if(uri.endsWith("/stam/renouvellement/agrements")) {
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/agrement/renvagr.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
