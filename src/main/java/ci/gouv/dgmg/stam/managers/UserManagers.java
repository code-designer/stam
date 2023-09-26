package ci.gouv.dgmg.stam.managers;

import java.util.List;

import ci.gouv.dgmg.stam.models.user.Agent;
import ci.gouv.dgmg.stam.models.user.UserRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class UserManagers {
	public abstract void addAgent(Agent ag);
	public abstract void delAgent(Agent ag);
	public abstract void updateAgent(Agent ag);
	public abstract Agent get(String index);
	public abstract List<Agent> getAll();
	public abstract boolean setPassword(String oldPwd, String newPwd);
	public abstract boolean resetPassword(String pwd);
	public abstract void setRoles(UserRole role);
	public abstract Agent get(HttpServletRequest request, HttpServletResponse response);
}
