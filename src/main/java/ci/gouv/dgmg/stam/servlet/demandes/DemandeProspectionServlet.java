package ci.gouv.dgmg.stam.servlet.demandes;

import java.io.IOException;

import ci.gouv.dgmg.stam.managers.DemandeNouvelleManagerImpl;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleProspection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemandeProspectionServlet
 */
@WebServlet(
		urlPatterns = {"/demandes/prospections","/demandes/prospections/add",
				"/demandes/prospections/modify","/demandes/prospections/delete"}
		)
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024, //1Mo
        maxFileSize         = 1024 * 1024 * 2, //2Mo
        maxRequestSize      = 1024 * 1024 * 10, //10Mo
        location            = "C:\\Users\\bigoh\\Documents\\Stam\\temp"
)
public class DemandeProspectionServlet extends DemandeServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
    public DemandeProspectionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		
		demandeNouvelleManager = new DemandeNouvelleManagerImpl(request, response);
		
		if(uri.endsWith("/stam/demandes/prospections/add")) {
			dispatcher = this.getServletContext()
			.getRequestDispatcher("/WEB-INF/demandeView/demande/prospection/add-dmdprospec.jsp");
		}
		if(uri.endsWith("/stam/demandes/prospections/modify")) {
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/demande/prospection/add-dmdprospec.jsp");
		}
		if(uri.endsWith("/stam/demandes/prospections/del")) {
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/demande/prospection/dmdnv.jsp");
		}
		if(uri.endsWith("/stam/demandes/prospections")) {
			request.setAttribute("listeDemandeProspections", 
					demandeNouvelleManager.getDemandeNouvelleProspection(0, 0, null));
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/demande/prospection/dmdprospec.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI().toString();
		if(uri.endsWith("/stam/demandes/prospections/uploads")) {
			try {
				demandeNouvelleManager = new DemandeNouvelleManagerImpl(request, response);
				DemandeNouvelleProspection demandeProspection = demandeNouvelleManager.
						getDemandeNouvelleProspection();
				demandeNouvelleManager.addDemandeNouvelleProspection(demandeProspection);
				request.setAttribute("message", this.SUCCESS_MESSAGE);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				request.setAttribute("message", this.SUCCESS_MESSAGE);
			}
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/demandeView/demande/agrement/add-dmdagr.jsp");
			dispatcher.forward(request, response);
		}
	}

}
