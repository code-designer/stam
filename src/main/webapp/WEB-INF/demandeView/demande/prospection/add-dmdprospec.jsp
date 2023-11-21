<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="ajouter">
	
	<form method="post" enctype="multipart/form-data" class="form-act"
		action="${pageContext.request.contextPath }/demandes/prospections/uploads" >
		<h2>Ajouter une demande d'agrement</h2>
		
		<%@ include file="/WEB-INF/includes/requerent.jsp" %>
		<%@ include file="/WEB-INF/includes/demande.jsp" %>
		<div>
			<h3>Details de la demande</h3>
		</div>
		<fieldset>
			<div>
				<label for="sustance">Substance</label>
				<select id="substance" name="substance">
					<option value="1">OR</option>
				</select>
			</div>
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
				<label for="rapport_visite_terrain">Rapport de visite de terrain</label>
				<input type="file" name="rapport_visite_terrain" id="rapport_visite_terrain">
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