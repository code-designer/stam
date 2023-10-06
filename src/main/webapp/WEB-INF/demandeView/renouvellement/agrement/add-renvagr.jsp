<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="ajouter">
	
	<form method="post" action="" class="form-act" name="demande-agrement" id="demande-agrement">
		<h2>Ajouter une demande de renouvellement d'agrement</h2>
		
		<%@ include file="/WEB-INF/includes/requerent.jsp" %>
		<%@ include file="/WEB-INF/includes/demande.jsp" %>
		<div class="rubriques">
			<h3>Details de la demande</h3>
		</div>
		<fieldset>
			<div>
				<label for="type_activite">Type d'activité</label>
				<input type="text" name="type_activite" id="type_activite">
			</div>
			<div>
				<label for="rapport_technique_financier">Rapport technique et financier</label>
				<input type="file" name="rapport_technique_financier" id="rapport_technique_financier">
			</div>
			<div>
				<label for="copie_titre_minier">Copie du titre minier</label>
				<input type="file" name="copie_titre_minier" id="copie_titre_minier">
			</div>
		</fieldset>
		<input type="hidden" name="doc" value="Renouvellements">
		<input type="hidden" name="type" value="Agrements">
		<div>
			<input type="reset" value="Annuler">
			<input type="submit" value="Enregistrer">
		</div>
	</form>
</l:layout>