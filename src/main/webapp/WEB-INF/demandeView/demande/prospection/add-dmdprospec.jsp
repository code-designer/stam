<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="ajouter">
	
	<form method="post" action="" class="form-act">
		<h2>Ajouter une demande d'agrement</h2>
		
		<%@ include file="/WEB-INF/includes/requerent.jsp" %>
		<%@ include file="/WEB-INF/includes/demande.jsp" %>
		<div>
			<h3>Details de la demande</h3>
		</div>
		<fieldset>
			<div>
				<label for="cv_respo_tech">CV du responsable technique</label>
				<input type="file" name="cv_respo_tech" id="cv_respo_tech">
			</div>
			<div>
				<label for="carte_zone">Carte de la zone</label>
				<input type="file" name="carte_zone" id="carte_zone">
			</div>
			<div>
				<label for="programme_prospection">Programme de prospection</label>
				<input type="file" name="programme_prospection" id="programme_prospection">
			</div>
			<div>
				<label for="rapportvisite">Rapport de visite de terrain</label>
				<input type="file" name="rapport_visite" id="rapport_visite">
			</div>
		</fieldset>
		<input type="hidden" name="doc" value="Demandes">
		<input type="hidden" name="type" value="Prospections">
		<div>
			<input type="reset" value="Annuler">
			<input type="submit" value="Enregistrer">
		</div>
	</form>
</l:layout>