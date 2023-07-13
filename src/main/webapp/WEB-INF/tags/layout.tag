<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true"%>

<!Doctype html>
<html lang="fr">
  <head>
    <title>${title}</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Application de Suivi des Titres et Autorisation
    Minières (STAM) permet le suivi des differents actes et de generer des données 
    statistiques.">
    <link media="screen" rel="stylesheet" href="">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body>
    <jsp:doBody/>
  </body>
</html>