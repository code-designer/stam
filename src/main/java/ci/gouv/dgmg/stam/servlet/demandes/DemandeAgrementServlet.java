package ci.gouv.dgmg.stam.servlet.demandes;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ci.gouv.dgmg.stam.managers.DemandeNouvelleManagerImpl;
import ci.gouv.dgmg.stam.models.acte.Agrement;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleAgrement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemandeAgrementServlet
 */
@WebServlet(
		urlPatterns = {"/demandes/agrements","/demandes/agrements/add",
				"/demandes/agrements/modify","/demandes/agrements/delete", "/demandes/agrements/uploads"}
		)
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024, //1Mo
        maxFileSize         = 1024 * 1024 * 2, //2Mo
        maxRequestSize      = 1024 * 1024 * 10, //10Mo
        location            = "C:\\Users\\bigoh\\Documents\\Stam\\temp"
)
public class DemandeAgrementServlet extends DemandeServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(DemandeAgrementServlet.class);
       
    public DemandeAgrementServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		
		if(uri.endsWith("/stam/demandes/agrements/add")) {
			dispatcher = this.getServletContext()
			.getRequestDispatcher("/WEB-INF/demandeView/demande/agrement/add-dmdagr.jsp");
			
		}
		
		demandeNouvelleManager = new DemandeNouvelleManagerImpl(request, response);
		
		if(uri.endsWith("/stam/demandes/agrements/modify")) {
			String param = request.getParameter("id");
			DemandeNouvelleAgrement dmdAgrement = demandeNouvelleManager.getDemandeNouvelleAgrement(param);
			
			if(dmdAgrement != null)
				request.setAttribute("agrement", dmdAgrement);
			
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/demande/agrement/add-dmdagr.jsp");
		}
		if(uri.endsWith("/stam/demandes/agrements/del")) {
			String param = request.getParameter("id");
			DemandeNouvelleAgrement dmdAgrement = demandeNouvelleManager.getDemandeNouvelleAgrement(param);
			demandeNouvelleManager.delDemandeNouvelleAgrement(dmdAgrement);
			
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/demande/agrement/dmdnv.jsp");
		}
		if(uri.endsWith("/stam/demandes/agrements")) {
			request.setAttribute("listeDemandeAgrements", 
					demandeNouvelleManager.getDemandeNouvelleAgrements(0, 0, null));			
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/demande/agrement/dmdagr.jsp");
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.trace("Traitement du formulaire");
		
		uri = request.getRequestURI().toString();
		if(uri.endsWith("/stam/demandes/agrements/uploads")) {
			try {
				demandeNouvelleManager = new DemandeNouvelleManagerImpl(request, response);
				DemandeNouvelleAgrement demandeAgrement = demandeNouvelleManager.getDemandeNouvelleAgrement();
				demandeNouvelleManager.addDemandeNouvelleAgrement(demandeAgrement);
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
