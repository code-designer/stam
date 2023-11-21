package ci.gouv.dgmg.stam.servlet.actes;

import java.io.IOException;

import ci.gouv.dgmg.stam.managers.ActeManagerImpl;
import ci.gouv.dgmg.stam.models.acte.PermisRecherche;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PRServlet
 */
@WebServlet(
	urlPatterns = {"/actes/recherches","/actes/recherches/add","/actes/recherches/modify",
			"/actes/recherches/del"},
	description = "This servlet is intented to manage recherche pages"
		)
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024, //1Mo
        maxFileSize         = 1024 * 1024 * 5, //5Mo
        maxRequestSize      = 1024 * 1024 * 10, //10Mo
        location            = "C:\\Users\\bigoh\\Documents\\Stam\\temp"
)
public class RechercheServlet extends ActeServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
    public RechercheServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if(uri.endsWith("/stam/actes/recherches/add")){
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/recherche/add-pr.jsp");
		}
		
		acteManager = new ActeManagerImpl(request, response);
		
		if(uri.endsWith("/stam/actes/recherches/modify")) {
			PermisRecherche pr = acteManager.getPermisRecherche(request.getParameter("id"));
			
			if(pr != null)
				request.setAttribute("pr", pr);
			
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/recherche/add-pr.jsp");
		}
		if(uri.endsWith("/stam/actes/recherches/del")) {
			PermisRecherche pr = acteManager.getPermisRecherche(request.getParameter("id"));
			
			if(pr != null)
				acteManager.delPermisRecherche(pr);
			
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/recherche/add.jsp");
		}
		if(uri.endsWith("/stam/actes/recherches")) {
			request.setAttribute("listePR", acteManager.getPermisRecherche(0, 0, null));
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/recherche/recherches.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
