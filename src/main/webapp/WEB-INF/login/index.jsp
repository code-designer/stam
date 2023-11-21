<%@ page session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<c:set var="log">
	
  	  <div class="bgcover" id="bgcover">  	
	  <form action="j_security_check" method="POST" class="form-login glass">
	  	<h2>Connexion</h2>
	  	<%
	  		String failed = request.getParameter("failed");
	  		if(failed != null && !failed.isEmpty()) 
	  			out.println("<div>Compte utilisateur ou mot de passe incorrect</div>"); 
  		%>
	    <div>
	      <label for="j_username">Login</label>
	      <input type="text" name="j_username" id="j_username">
	    </div>
	    <div>
	      <label for="j_password">Password</label>
	      <input type="password" name="j_password" id="j_password">
	    </div>
	    <div>
	    	<input type="submit" value="Connexion">
	    </div>
	  </form>
	</div>
</c:set>

<l:layoutAccess title="login">
	<jsp:body>
	${log}
	</jsp:body>
</l:layoutAccess>
