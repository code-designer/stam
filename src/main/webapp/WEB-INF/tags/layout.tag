<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="m" %>
<%@ attribute name="title" required="true"%>

<!Doctype html>
<html lang="fr">
  <head>
    <title>${title} | STAM</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Application de Suivi des Titres et Autorisation
    Minières (STAM) permet le suivi des differents actes et de generer des données 
    statistiques.">
    <link media="screen" rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/mobile.css">
    <link media="screen and (min-width:768.5px)" rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/style.css">
    <!-- <script src="https://kit.fontawesome.com/d660bfd93f.js" crossorigin="anonymous"></script> -->
    <script src="${pageContext.servletContext.contextPath}/js/app.js" type="module" defer></script>
  </head>
  <body>
  	<m:menu></m:menu>
    <jsp:doBody/>
    <m:foot></m:foot>
  </body>
</html>