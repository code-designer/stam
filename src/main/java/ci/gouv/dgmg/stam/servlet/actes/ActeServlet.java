package ci.gouv.dgmg.stam.servlet.actes;

import ci.gouv.dgmg.stam.managers.ActeManager;
import ci.gouv.dgmg.stam.servlet.MainServlet;

/**
 * Servlet implementation class ActeServlet
 */
public abstract class ActeServlet extends MainServlet {
	private static final long serialVersionUID = 1L;
    protected ActeManager acteManager;
    
    public ActeServlet() {
        super();
    }



}
