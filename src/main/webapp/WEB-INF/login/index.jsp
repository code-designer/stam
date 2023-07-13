<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir = "/WEB-INF/tags" prefix="l" %>

<l:layout title="login">
  <div class="div-form">
	  <form action="j_security_check" method="POST">
	  <c:if test="${! empty failed}">
	    <div>
	  	  <c:out value="Compte utilisateur ou mot de passe invalides"></c:out>
	  	</div>
	  </c:if>
	    <div>
	      <label>Login</label>
	      <input type="text" name="j_username" id="j_username">
	    </div>
	    <div>
	      <label>Password</label>
	      <input type="password" name="j_password" id="j_password">
	    </div>
	    <button>Connexion</button>
	  </form>
	</div>
</l:layout>

<!-- 
<!Doctype html>
<html lang="fr">
  <head>
    <title>login</title>
    <meta charset="UTF-8">
  </head>
  <body>
    <div class="div-form">
	  <form action="j_security_check" method="POST">
	  	<%
	  		String failed = request.getParameter("failed");
	  		if(failed != null && !failed.isEmpty())
	  			out.println("<div>Compte utilisateur ou mot de passe incorrect</div>");
	  	%>
	    <div>
	      <label>Login</label>
	      <input type="text" name="j_username" id="j_username">
	    </div>
	    <div>
	      <label>Password</label>
	      <input type="password" name="j_password" id="j_password">
	    </div>
	    <button>Connexion</button>
	  </form>
	</div>
  </body>
</html>
-->


