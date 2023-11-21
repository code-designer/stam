package ci.gouv.dgmg.stam.servlet.renouvellements;

import java.io.IOException;

import ci.gouv.dgmg.stam.managers.DemandeRenouvellementManagerImpl;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementAgrement;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RenouvellementAgrementServlet
 */
@WebServlet(
		urlPatterns = {"/renouvellement/agrements","/renouvellement/agrements/add",
				"/renouvellement/agrements/modify","/renouvellement/agrements/delete"}
		)
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024, //1Mo
        maxFileSize         = 1024 * 1024 * 2, //2Mo
        maxRequestSize      = 1024 * 1024 * 10, //10Mo
        location            = "C:\\Users\\bigoh\\Documents\\Stam\\temp"
)
public class RenouvellementAgrementServlet extends RenouvellementServlet {
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
		
		demandeRenouvellementManager = new DemandeRenouvellementManagerImpl(request, response);
		
		if(uri.endsWith("/stam/renouvellement/agrements/modify")) {
			String id = request.getParameter("id");
			DemandeRenouvellementAgrement demandeRenouvellementAgrement = 
					demandeRenouvellementManager.getDemandeRenouvellementAgrement(id);
			
			if(demandeRenouvellementAgrement != null)
				request.setAttribute("demandeRenouvellementAgrement", demandeRenouvellementAgrement);
			
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/agrement/add-renvagr.jsp");
		}
		if(uri.endsWith("/stam/renouvellement/agrements/del")) {
			String id = request.getParameter("id");
			DemandeRenouvellementAgrement demandeRenouvellementAgrement = 
					demandeRenouvellementManager.getDemandeRenouvellementAgrement(id);
			
			if(demandeRenouvellementAgrement != null)
				demandeRenouvellementManager.
				delDemandeRenouvellementAgrement(demandeRenouvellementAgrement);
			
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/agrement/dmdnv.jsp");
		}
		if(uri.endsWith("/stam/renouvellement/agrements")) {
			request.setAttribute("listeDemandeRenouvellementAgrements", 
					demandeRenouvellementManager.getDemandeRenouvellementAgrements(0, 0, null));
			
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/agrement/renvagr.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
