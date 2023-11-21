package ci.gouv.dgmg.stam.servlet.actes;

import java.io.IOException;

import ci.gouv.dgmg.stam.managers.ActeManagerImpl;
import ci.gouv.dgmg.stam.models.acte.Prospection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProspectionServlet
 */
@WebServlet(
	urlPatterns = {"/actes/prospections","/actes/prospections/add","/actes/prospections/modify",
			"/actes/prospections/delete"},
	description = "This servlet is intented to manage prospection pages"
		)
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024, //1Mo
        maxFileSize         = 1024 * 1024 * 2, //2Mo
        maxRequestSize      = 1024 * 1024 * 10, //10Mo
        location            = "C:\\Users\\bigoh\\Documents\\Stam\\temp"
)
public class ProspectionServlet extends ActeServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProspectionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if(uri.endsWith("/stam/actes/prospections/add")){
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/prospection/add-prospec.jsp");
		}
		
		acteManager = new ActeManagerImpl(request, response);
		
		if(uri.endsWith("/stam/actes/prospections/modify")) {
			String id = request.getParameter("id");
			Prospection prospec = acteManager.getProspection(id);
			
			if(prospec != null)
				request.setAttribute("prospection", prospec);
			
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/prospection/add-prospec.jsp");
		}
		if(uri.endsWith("/stam/actes/prospections/del")) {
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/prospection/add.jsp");
		}
		if(uri.endsWith("/stam/actes/prospections")) {
			request.setAttribute("listeProspections", 
					acteManager.getProspection(0, 0, null));
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/prospection/prospections.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
