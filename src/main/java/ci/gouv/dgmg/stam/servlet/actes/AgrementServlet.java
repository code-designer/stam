package ci.gouv.dgmg.stam.servlet.actes;

import java.io.IOException;

import ci.gouv.dgmg.stam.managers.ActeManagerImpl;
import ci.gouv.dgmg.stam.models.acte.Agrement;
import jakarta.servlet.ServletException;
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
public class AgrementServlet extends ActeServlet {
	private static final long serialVersionUID = 1L;
	
    public AgrementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI().toString();
		acteManager = new ActeManagerImpl(request, response);
		
		if(uri.endsWith("/stam/actes/agrements/add")) {
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/agrement/add-agr.jsp");
		}
		if(uri.endsWith("/stam/actes/agrements/modify")) {
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/agrement/add-agr.jsp");
		}
		if(uri.endsWith("/stam/actes/agrements/del")) {
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/agrement/add.jsp");
		}
		if(uri.endsWith("/stam/actes/agrements")) {
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
