package ci.gouv.dgmg.stam.servlet.actes;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgrementServlet
 */

@WebServlet(
		urlPatterns = {"/agrements","/agrements/add","/agrements/modify"},
		description = "This servlet is intented to manage agrements pages"
		)
public class AgrementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RequestDispatcher dispatcher;
    public AgrementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().matches("/agrements/add")) {
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/agrement/add.jsp");
		}
		if(request.getServletPath().matches("/agrements")) {
			this.dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/actesView/agrement/agrements.jsp");
		}
		this.dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
