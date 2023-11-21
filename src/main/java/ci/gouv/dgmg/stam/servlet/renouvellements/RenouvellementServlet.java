package ci.gouv.dgmg.stam.servlet.renouvellements;

import java.io.IOException;

import ci.gouv.dgmg.stam.managers.DemandeRenouvellementManager;
import ci.gouv.dgmg.stam.servlet.MainServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RenouvellementServlet
 */
public class RenouvellementServlet extends MainServlet {
	private static final long serialVersionUID = 1L;
	protected DemandeRenouvellementManager demandeRenouvellementManager;
    public RenouvellementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
