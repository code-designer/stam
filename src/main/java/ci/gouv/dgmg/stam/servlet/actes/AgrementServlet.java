package ci.gouv.dgmg.stam.servlet.actes;

import java.io.IOException;

import ci.gouv.dgmg.stam.managers.ActeManagerImpl;
import ci.gouv.dgmg.stam.models.acte.Agrement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgrementServlet
 */

@WebServlet(
		urlPatterns = {"/actes/agrements","/actes/agrements/add","/actes/agrements/modify",
				"/actes/agrements/del", "/actes/agrements/uploads"},
		description = "This servlet is intented to manage agrements pages"
		)
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024, //1Mo
        maxFileSize         = 1024 * 1024 * 2, //2Mo
        maxRequestSize      = 1024 * 1024 * 10, //10Mo
        location            = "C:\\Users\\bigoh\\Documents\\Stam\\temp"
)
public class AgrementServlet extends ActeServlet {
	private static final long serialVersionUID = 1L;
	
    public AgrementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI().toString();
		
		if(uri.endsWith("/stam/actes/agrements/add")) {
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/agrement/add-agr.jsp");
		}
		
		acteManager = new ActeManagerImpl(request, response);
		
		if(uri.endsWith("/stam/actes/agrements/modify")) {
			String id = request.getParameter("id");
			Agrement agrement = acteManager.getAgrement(id);
			
			if(agrement != null)
				request.setAttribute("agrement", agrement);
			
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/agrement/add-agr.jsp");
		}
		if(uri.endsWith("/stam/actes/agrements/del")) {
			String id = request.getParameter("id");
			Agrement agrement = acteManager.getAgrement(id);
			
			if(agrement != null)
				acteManager.delAgrement(agrement);
			
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/agrement/add.jsp");
		}
		if(uri.endsWith("/stam/actes/agrements")) {
			request.setAttribute("listeAgrements", acteManager.getAgrements(0, 0, null));
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/agrement/agrements.jsp");
		}
		this.dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		uri = request.getRequestURI().toString();
		if(uri.endsWith("/stam/agrements/uploads"))
		try {
			acteManager = new ActeManagerImpl(request, response);
			Agrement agrement = acteManager.getAgrement();
			acteManager.addAgrement(agrement);
			request.setAttribute("message", this.SUCCESS_MESSAGE);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("message", this.SUCCESS_MESSAGE);
		}
		this.dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/actesView/agrement/add.jsp");
		dispatcher.forward(request, response);
		
	}

}
