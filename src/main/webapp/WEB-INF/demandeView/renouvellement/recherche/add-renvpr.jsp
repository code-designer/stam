<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="ajouter">
	
	<form method="post" action="${pageContext.servletContext.contextPath }/renouvellement/recherche/add"
	enctype="multipart/form-data" class="form-act">
		<h2>Ajouter une demande de renouvellement de PR</h2>
		
		<%@ include file="/WEB-INF/includes/requerent.jsp" %>
		<%@ include file="/WEB-INF/includes/demande.jsp" %>
		<div>
			<h3>Details de la demande</h3>
		</div>
		<fieldset>
			<div>
				<label for="extrait_carte">Extrait de la situation de la carte</label>
				<input type="file" name="extrait_carte" id="extrait_carte">
			</div>
			<div>
				<label for="programme_general_travaux">Rapport général des travaux de recherche</label>
				<input type="file" name="programme_general_travaux" id="programme_general_travaux">
			</div>
			<div>
				<label for="programme_general_detaille">Programme général et détaillé des travaux </label>
				<input type="file" name="programme_general_detaille" id="programme_general_detaille">
			</div>
			<div>
				<label for="droit_option">Droit d'option</label>
				<input type="file" name="droit_option" id="droit_option">
			</div>
			<div>
				<label for="rapport_visite">Rapport de visite de terrain</label>
				<input type="file" name="rapport_visite" id="rapport_visite">
			</div>
		</fieldset>
		<input type="hidden" name="doc" value="Renouvellements">
		<input type="hidden" name="type" value="PR">
		<div>
			<input type="reset" value="Annuler">
			<input type="submit" value="Enregistrer">
		</div>
	</form>
</l:layout>