package ci.gouv.dgmg.stam.model.user;

public enum UserRole {
	Trainee("Trainee"),
	Junior("Junior"),
	Senior("Senior"),
	Manager("Manager"),
	TopManager("TopManager");
	private String role;
	
	UserRole(String role) {
		this.role = role;
	}
	
	public String toString() {
		return role;
	}
	
	public UserRole toUserRole(String role) {
		for (UserRole ur : values())
			if(ur.toString().equals(role))
				return ur;
		return Trainee;
	}
}
