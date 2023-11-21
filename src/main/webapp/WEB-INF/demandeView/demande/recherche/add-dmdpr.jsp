<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="ajouter">
	
	<form method="post" enctype="multipart/form-data" class="form-act"
		action="${pageContext.request.contextPath }/demandes/recherches/uploads">
		<h2>Ajouter une demande de PR</h2>
		
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
				<label for="nrccm">Numéro de compte contribuable</label>
				<input type="text" name="nrccm" id="nrccm">
			</div>
			<div>
				<label for="rccm">Registre de commerce</label>
				<input type="file" name="rccm" id="rccm">
			</div>
			<div>
				<label for="attestation_bancaire">Attestation bancaire</label>
				<input type="file" name="attestation_bancaire" id="attestation_bancaire">
			</div>
			<div>
				<label for="releve_bancaire">Relevé bancaire</label>
				<input type="file" name="releve_bancaire" id="releve_bancaire">
			</div>
			<div>
				<label for="attestation_regularite_fiscale">Attestation de regularité fiscale</label>
				<input type="file" name="attestation_regularite_fiscale" id="attestation_regularite_fiscale">
			</div>
			<div>
				<label for="carte_200000">Carte de situation 1/200 000</label>
				<input type="file" name="carte_200000" id="carte_200000">
			</div>
			<div>
				<label for="carte_A4">Extrait de la carte au format A4</label>
				<input type="file" name="carte_A4" id="carte_A4">
			</div>
			<div>
				<label for="prog_general_travaux">Programme général des travaux sur les quatres années</label>
				<input type="file" name="prog_general_travaux" id="prog_general_travaux">
			</div>
			<div>
				<label for="programme_detaille">Programme détaillé des travaux sur la première année</label>
				<input type="file" name="programme_detaille" id="programme_detaille">
			</div>
			<div>
				<label for="liste_des_postes">Liste des postes prévus par catégorie</label>
				<input type="file" name="liste_des_postes" id="liste_des_postes">
			</div>
			<div>
				<label for="lettre_designation">Lettre de designation du responsable technique</label>
				<input type="file" name="lettre_designation" id="lettre_designation">
			</div>
			<div>
				<label for="cv_respo_tech">CV du responsable technique</label>
				<input type="file" name="cv_respo_tech" id="cv_respo_tech">
			</div>
			<div>
				<label for="photocopie_diplomes">Photocopies des Diplomes et autres qualifications</label>
				<input type="file" name="photocopie_diplomes" id="photocopie_diplomes">
			</div>
			<div>
				<label for="experience_demandeur">Memoire faisant l'expérience du demandeur</label>
				<input type="file" name="experience_demandeur" id="experience_demandeur">
			</div>
			<div>
				<label for="rapport_visite_terrain">Rapport de visite de terrain</label>
				<input type="file" name="rapport_visite_terrain" id="rapport_visite_terrain">
			</div>
		</fieldset>
		<input type="hidden" name="doc" value="Demandes">
		<input type="hidden" name="type" value="PR">
		<div>
			<input type="reset" value="Annuler">
			<input type="submit" value="Enregistrer">
		</div>
	</form>
</l:layout>