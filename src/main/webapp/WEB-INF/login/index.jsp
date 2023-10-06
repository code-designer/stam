<%@ page session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<c:set var="log">
	<%
	  		String failed = request.getParameter("failed");
	  		if(failed != null && !failed.isEmpty()) 
	  			out.println("<div>Compte utilisateur ou mot de passe incorrect</div>"); 
  	%>
  	  <div class="div-form">  	
	  <form action="j_security_check" method="POST">
	    <div>
	      <label for="j_username">Login</label>
	      <input type="text" name="j_username" id="j_username">
	    </div>
	    <div>
	      <label for="j_password">Password</label>
	      <input type="password" name="j_password" id="j_password">
	    </div>
	    <input type="submit" value="Connexion">
	  </form>
	</div>
</c:set>

<l:layoutAccess title="login">
	<jsp:body>
	${log}
	</jsp:body>
</l:layoutAccess>
