package ci.gouv.dgmg.stam.managers;

import java.util.List;

import ci.gouv.dgmg.stam.models.user.Agent;
import ci.gouv.dgmg.stam.models.user.UserRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserManager {
	public void addAgent(Agent ag);
	public void delAgent(Agent ag);
	public void updateAgent(Agent ag);
	public Agent get(String index);
	public List<Agent> getAll();
	public boolean setPassword(String oldPwd, String newPwd);
	public boolean resetPassword(String pwd);
	public void setRoles(UserRole role);
	public Agent get(HttpServletRequest request, HttpServletResponse response);
}