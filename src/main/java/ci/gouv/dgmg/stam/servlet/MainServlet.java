package ci.gouv.dgmg.stam.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;

/**
 * Servlet implementation class MainServlet
 */

public abstract class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected RequestDispatcher dispatcher;
    protected final String SUCCESS_MESSAGE = "Operation effectuée avec succès";
    protected final String FAILURE_MESSAGE = "Echec de l'operation";
    protected String uri;
    public MainServlet() {
        super();
    }

}
