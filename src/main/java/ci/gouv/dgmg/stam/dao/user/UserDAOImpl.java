package ci.gouv.dgmg.stam.dao.user;

import java.util.List;

import ci.gouv.dgmg.stam.model.user.Agent;

public class UserDAOImpl extends UserDAO<Agent>{
	
	@Override
	public void create(Agent agent) {
		em.getTransaction().begin();
		em.persist(agent);
		em.getTransaction().commit();
	}
	
	@Override
	public void del(Agent agent) {
		em.getTransaction().begin();
		em.find(agent.getClass(), agent.getMatricule());
		em.remove(agent);
		em.getTransaction().commit();
	}
	
	@Override
	public Agent get(String matricule) {
		return em.find(Agent.class, matricule);
	}
	
	@Override
	public void update(Agent agent) {
		em.getTransaction().begin();
		Agent ag = em.find(agent.getClass(), agent.getMatricule());
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Agent> getAll() {
		return em.createQuery("from Agent").getResultList();
	}
	
	@Override
	public void setPassword(Agent agent, String pwd) {
		em.getTransaction().begin();
		Agent ag = em.find(agent.getClass(), agent.getMatricule());
		ag.getCredentials().setPassword(pwd);
		em.getTransaction().commit();
	}
}
