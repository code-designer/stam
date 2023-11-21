package ci.gouv.dgmg.stam.servlet.demandes;

import java.io.IOException;

import ci.gouv.dgmg.stam.managers.DemandeNouvelleManagerImpl;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvellePR;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemandeRechercheServlet
 */
@WebServlet(
		urlPatterns = {"/demandes/recherches","/demandes/recherches/add",
				"/demandes/recherches/modify","/demandes/recherches/delete",
				"/demandes/recherches/uploads"}
		)
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024, //1Mo
        maxFileSize         = 1024 * 1024 * 2, //2Mo
        maxRequestSize      = 1024 * 1024 * 10, //10Mo
        location            = "C:\\Users\\bigoh\\Documents\\Stam\\temp"
)
public class DemandeRechercheServlet extends DemandeServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
    public DemandeRechercheServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		
		demandeNouvelleManager = new DemandeNouvelleManagerImpl(request, response);
		
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
			request.setAttribute("listeDemandePR", 
					demandeNouvelleManager.getDemandeNouvellePR(0, 0, null));
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/demande/recherche/dmdpr.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI().toString();
		if(uri.endsWith("/stam/demandes/recherches/uploads")) {
			try {
				demandeNouvelleManager = new DemandeNouvelleManagerImpl(request, response);
				DemandeNouvellePR demandePR = demandeNouvelleManager.
						getDemandeNouvellePR();
				demandeNouvelleManager.addDemandeNouvellePR(demandePR);
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
