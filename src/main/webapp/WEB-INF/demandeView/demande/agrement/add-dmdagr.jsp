<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="ajouter">
	<span>
		<c:if test="${!empty message}">
			<c:out value="${message}"/>
		</c:if>
	</span>
	
	<form method="post" action="${pageContext.servletContext.contextPath }/demandes/agrements/uploads" 
	enctype="multipart/form-data" class="form-act" name="demande-agrement" id="demande-agrement">
		<h2>Ajouter une demande d'agrement</h2>
		
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
				<label for="liste_autres_activites">Liste des autres activtés</label>
				<input type="file" name="liste_autres_activites" id="liste_autres_activites">
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
				<label for="contrat_sous_traitance">Contract de sous-traitance</label>
				<input type="file" name="contrat_sous_traitance" id="contrat_sous_traitance">
			</div>
			<div>
				<label for="copie_titre_minier">Copie du titre minier</label>
				<input type="file" name="copie_titre_minier" id="copie_titre_minier">
			</div>
			<div>
				<label for="declaration_honneur">Declaration sur l'honneur</label>
				<input type="file" name="declaration_honneur" id="declaration_honneur">
			</div>
			<div>
				<label for="postes">Liste des postes par categorie</label>
				<input type="file" name="postes" id="postes">
			</div>
			<div>
				<label for="liste_personnel">Liste du personnel</label>
				<input type="file" name="liste_personnel" id="liste_personnel">
			</div>
		</fieldset>
		<input type="hidden" name="doc" value="Demandes">
		<input type="hidden" name="type" value="Agrements">
		<div>
			<input type="reset" value="Annuler">
			<input type="submit" value="Enregistrer">
		</div>
	</form>
</l:layout>