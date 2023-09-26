package ci.gouv.dgmg.stam.dao.user;

import ci.gouv.dgmg.stam.dao.StringIndexDAO;
import ci.gouv.dgmg.stam.models.user.Agent;
import ci.gouv.dgmg.stam.models.user.UserRole;

public abstract class UserDAO<T> extends StringIndexDAO<T> {
	public abstract void setPassword(Agent agent, String pwd);
	public abstract void setRoles(Agent agent, UserRole role);
	public abstract void removeRoles(Agent agent, UserRole role);
}
