package ci.gouv.dgmg.stam.managers;

import java.util.List;

import ci.gouv.dgmg.stam.dao.DAOFactory;
import ci.gouv.dgmg.stam.dao.user.UserDAO;
import ci.gouv.dgmg.stam.dao.user.UserDAOImpl;
import ci.gouv.dgmg.stam.models.user.Agent;
import ci.gouv.dgmg.stam.models.user.UserRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserManagerImpl extends Manager implements UserManager {
	
	private final UserDAO<Agent> userDAO = (UserDAOImpl) DAOFactory.getUserDAO();
	
	@Override
	public void addAgent(Agent ag) {
		userDAO.create(ag);
	}

	@Override
	public void delAgent(Agent ag) {
		userDAO.del(ag);
	}

	@Override
	public void updateAgent(Agent ag) {
		userDAO.update(ag);
	}

	@Override
	public Agent get(String index) {
		return userDAO.get(index);
	}

	@Override
	public List<Agent> getAll() {
		return userDAO.getAll();
	}

	@Override
	public boolean setPassword(String oldPwd, String newPwd) {
		return false;
	}

	@Override
	public boolean resetPassword(String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRoles(UserRole role) {
		// TODO Auto-generated method stub

	}

	@Override
	public Agent get(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
