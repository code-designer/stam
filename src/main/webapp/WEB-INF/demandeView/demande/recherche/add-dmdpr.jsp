<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="ajouter">
	
	<form method="post" action="" class="form-act">
		<h2>Ajouter une demande de PR</h2>
		
		<%@ include file="/WEB-INF/includes/requerent.jsp" %>
		<%@ include file="/WEB-INF/includes/demande.jsp" %>
		<div>
			<h3>Details de la demande</h3>
		</div>
		<fieldset>
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
				<label for="attestation_regularite">Attestation de regularité fiscale</label>
				<input type="file" name="attestation_regularite" id="attestation_regularite">
			</div>
			<div>
				<label for="carte200000">Carte de situation 1/200 000</label>
				<input type="file" name="carte200000" id="carte200000">
			</div>
			<div>
				<label for="carteA4">Extrait de la carte au format A4</label>
				<input type="file" name="carteA4" id="carteA4">
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
				<label for="rapport_visite">Rapport de visite de terrain</label>
				<input type="file" name="rapport_visite" id="rapport_visite">
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