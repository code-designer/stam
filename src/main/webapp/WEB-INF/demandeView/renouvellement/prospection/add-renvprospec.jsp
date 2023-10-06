<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="ajouter">
	
	<form method="post" action="" class="form-act">
		<h2>Ajouter une demande de renouvellement de prospection</h2>
		
		<%@ include file="/WEB-INF/includes/requerent.jsp" %>
		<%@ include file="/WEB-INF/includes/demande.jsp" %>
		<div>
			<h3>Details de la demande</h3>
		</div>
		<fieldset>
			<div>
				<label for="rapport_activite_prospec">Rapport d'activité de prospection</label>
				<input type="file" name="rapport_activite_prospec" id="rapport_activite_prospec">
			</div>
			<div>
				<label for="programme_prospection">Programme de prospection à réaliser</label>
				<input type="file" name="programme_prospection" id="programme_prospection">
			</div>
			<div>
				<label for="rapport_visite">Rapport de visite de terrain</label>
				<input type="file" name="rapport_visite" id="rapport_visite">
			</div>
		</fieldset>
		<input type="hidden" name="doc" value="Renouvellements">
		<input type="hidden" name="type" value="Prospections">
		<div>
			<input type="reset" value="Annuler">
			<input type="submit" value="Enregistrer">
		</div>
	</form>
</l:layout>