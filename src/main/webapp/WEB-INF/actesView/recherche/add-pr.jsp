<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="Ajouter">
	<section>
		
		<form method="post" enctype="multipart/form-data" class="form-act"
			action="${pageContext.request.contextPath }/actes/permis-recherches/uploads">
			<h2>Ajouter un permis de recherche</h2>			
			
			<div>
				<label for="dossier_demande">Dossier de demande</label>
				<select name="dossier_demande" id="dossier_demande">
					<option></option>
				</select>
			</div>
			<div>
				<label for="numero_ordre">Numéro d'ordre</label>
				<input type="text" name="numero_ordre" class="" id="numero_ordre">
			</div>
			<div>
				<label for="numero_octroi">Numéro d'octroi</label>
				<input type="text" name="numero_octroi" class="" id="numero_octroi">
			</div>
			<div>
				<label for="entreprise">Entreprise</label>
				<input type="text"  name="entreprise" id="entreprise">
			</div>
			<div>
				<label for="numero_acte">Numéro d'acte</label>
				<input type="text" placeholder="numéro d'acte" name="numero_acte" id="numero_acte">
			</div>
			<div>
				<label for="statut_acte">Statut</label>
				<select name="statut_acte" id="statut_acte">
					<option></option>
				</select>
			</div>
			<div>
				<label for="superficie">Superficie (km<sup>2</sup>)</label>
				<input type="number" name="superficie" id="superficie" step="0.01">
			</div>
			<div>
				<label for="region">Region</label>
				<input type="text" name="region" id="region">
			</div>
			<div>
				<label for="localite">Localité</label>
				<input type="text" name="localite" id="localite"></input>
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
				<label for="acte_numerise">Télécharger le permis de recherche</label>
				<input type="file" name="acte_numerise" id="acte_numerise">
			</div>
			<input type="hidden" name="doc" value="Actes">
			<input type="hidden" name="type" value="PR">
			<div>
				<input type="reset" value="Annuler">
				<input type="submit" value="Ajouter">
			</div>
		</form>
		<div class="visualisation">
		
		</div>
	</section>
</l:layout>