package ci.gouv.dgmg.stam.servlet.renouvellements;

import java.io.IOException;

import ci.gouv.dgmg.stam.managers.DemandeRenouvellementManagerImpl;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementPR;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RenouvellementAgrementServlet
 */
@WebServlet(
		urlPatterns = {"/renouvellement/recherches","/renouvellement/recherches/add",
				"/renouvellement/recherches/modify","/renouvellement/recherches/delete"}
		)
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024, //1Mo
        maxFileSize         = 1024 * 1024 * 5, //5Mo
        maxRequestSize      = 1024 * 1024 * 10, //10Mo
        location            = "C:\\Users\\bigoh\\Documents\\Stam\\temp"
)
public class RenouvellementRechercheServlet extends RenouvellementServlet {
	private static final long serialVersionUID = 1L;
       
    public RenouvellementRechercheServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if(uri.endsWith("/stam/renouvellement/recherches/add")) {
			dispatcher = this.getServletContext()
			.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/recherche/add-renvpr.jsp");
		}
		
		demandeRenouvellementManager = new DemandeRenouvellementManagerImpl(request, response);
		
		if(uri.endsWith("/stam/renouvellement/recherches/modify")) {
			String id = request.getParameter("id");
			DemandeRenouvellementPR demandeRenouvellementPR = 
					demandeRenouvellementManager.getDemandeRenouvellementPR(id);
			
			if(demandeRenouvellementPR != null)
				request.setAttribute("demandeRenouvellementPR", demandeRenouvellementPR);
			
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/recherche/add-renvpr.jsp");
		}
		if(uri.endsWith("/stam/renouvellement/recherches/del")) {
			String id = request.getParameter("id");
			DemandeRenouvellementPR demandeRenouvellementPR = 
					demandeRenouvellementManager.getDemandeRenouvellementPR(id);
			
			if(demandeRenouvellementPR != null)
				demandeRenouvellementManager.delDemandeRenouvellementPR(demandeRenouvellementPR);
			
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/recherche/dmdnv.jsp");
		}
		if(uri.endsWith("/stam/renouvellement/recherches")) {
			request.setAttribute("listeDemandeRenouvellementPR", 
					demandeRenouvellementManager.getDemandeRenouvellementPR(0, 0, null));
			
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/recherche/renvpr.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
