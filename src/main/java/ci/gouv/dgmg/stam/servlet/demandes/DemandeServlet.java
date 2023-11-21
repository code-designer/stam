package ci.gouv.dgmg.stam.servlet.demandes;

import ci.gouv.dgmg.stam.managers.DemandeNouvelleManager;
import ci.gouv.dgmg.stam.servlet.MainServlet;
import jakarta.servlet.annotation.MultipartConfig;

/**
 * Servlet implementation class DemandeServlet
 */

public abstract class DemandeServlet extends MainServlet {
	private static final long serialVersionUID = 1L;
    protected DemandeNouvelleManager demandeNouvelleManager;
    public DemandeServlet() {
        super();
    }


}
