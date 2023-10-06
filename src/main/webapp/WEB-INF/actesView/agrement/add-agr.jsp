<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="Ajouter agrement">
	<section>
		
		<form action="${pageContect.servletContext.contextPath }/actes/agrements/uploads" method="post" class="form-act">
			<h2>Ajouter un Agrement de sous-traitance minière</h2>
			
			<div>
				<label for="dosdmd">Dossier de demande</label>
				<select name="dossier-demande" id="dosdmd">
					<option></option>
				</select>
			</div>
			<div>
				<label for="numero_octroi">Numéro d'octroi</label>
				<input type="text" name="numero_octroi" class="" id="numero_octroi">
			</div>
			<div>
				<label for="entreprise">Entreprise</label>
				<input type="text" name="entreprise" id="entreprise">
			</div>
			<div>
				<label for="numero_acte">Numéro d'acte</label>
				<input type="text" name="numero_acte" id="numero_acte">
			</div>
			<div>
				<label for="statut_acte">Statut</label>
				<select name="statut_acte" id="statut_acte">
					<option></option>
				</select>
			</div>
			<div>
				<label for="domaine">Domaine</label>
				<input type="text" name="domaine" id="domaine">
			</div>
			<div>
				<label for="etat">Etat</label>
				<input type="text" name="etat" id="etat">
			</div>
			<div>
				<label for="obs">Observations</label>
				<textArea type="text" name="observations" id="obs"></textArea>
			</div>
			<div>
				<label for="annee_octroi">Année d'octroi</label>
				<input type="date" name="annee_octroi" id="annee_octroi">
			</div>			
			<div>
				<label for="annee_expiration">Année d'expiration</label>
				<input type="date" name="annee_expiration" id="annee_expiration">
			</div>
			<div>
				<label for="acte_numerise">Télécharger l'agrément</label>
				<input type="file" name="acte_numerise" id="acte_numerise">
			</div>
			<input type="hidden" name="doc" value="Actes">
			<input type="hidden" name="type" value="Agrements">
			<div>
				<input type="reset" value="Annuler">
				<input type="submit" value="Ajouter">
			</div>
		</form>
		<div class="visualisation">
		
		</div>
	</section>
</l:layout>