package ci.gouv.dgmg.stam.servlet.actes;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
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
public class ProspectionServlet extends HttpServlet {
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
		if(uri.endsWith("/stam/actes/prospections/modify")) {
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/prospection/add-prospec.jsp");
		}
		if(uri.endsWith("/stam/actes/prospections/del")) {
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/prospection/add.jsp");
		}
		if(uri.endsWith("/stam/actes/prospections")) {
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/prospection/prospections.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
