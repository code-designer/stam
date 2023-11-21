package ci.gouv.dgmg.stam.servlet.renouvellements;

import java.io.IOException;

import ci.gouv.dgmg.stam.managers.DemandeRenouvellementManagerImpl;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementProspection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RenouvellementAgrementServlet
 */
@WebServlet(
		urlPatterns = {"/renouvellement/prospections","/renouvellement/prospections/add",
				"/renouvellement/prospections/modify","/renouvellement/prospections/delete"}
		)
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024, //1Mo
        maxFileSize         = 1024 * 1024 * 2, //2Mo
        maxRequestSize      = 1024 * 1024 * 10, //10Mo
        location            = "C:\\Users\\bigoh\\Documents\\Stam\\temp"
)
public class RenouvellementProspectionServlet extends RenouvellementServlet {
	private static final long serialVersionUID = 1L;
       
    public RenouvellementProspectionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if(uri.endsWith("/stam/renouvellement/prospections/add")) {
			dispatcher = this.getServletContext()
			.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/prospection/add-renvprospec.jsp");
		}
		
		demandeRenouvellementManager = new DemandeRenouvellementManagerImpl(request, response);
		
		if(uri.endsWith("/stam/renouvellement/prospections/modify")) {
			String id = request.getParameter("id");
			DemandeRenouvellementProspection demandeRenouvellementProspection = 
					demandeRenouvellementManager.getDemandeRenouvellementProspection(id);
			
			if(demandeRenouvellementProspection != null)
				request.setAttribute("demandeRenouvellementProspection", 
						demandeRenouvellementProspection);
			
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/prospection/add-renvprospec.jsp");
		}
		if(uri.endsWith("/stam/renouvellement/prospections/del")) {
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/prospection/dmdnv.jsp");
		}
		if(uri.endsWith("/stam/renouvellement/prospections")) {
			request.setAttribute("listeDemandeRenouvellementProspec", 
					demandeRenouvellementManager.getDemandeRenouvellementProspections(0, 0, null));
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/renouvellement/prospection/renvprospec.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
