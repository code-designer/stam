package ci.gouv.dgmg.stam.servlet.demandes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DemandeProspectionServlet
 */
@WebServlet(
		urlPatterns = {"/demandes/prospections","/demandes/prospections/add",
				"/demandes/prospections/modify","/demandes/prospections/delete"}
		)
public class DemandeProspectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
    public DemandeProspectionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
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
			dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/demandeView/demande/prospection/dmdprospec.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
