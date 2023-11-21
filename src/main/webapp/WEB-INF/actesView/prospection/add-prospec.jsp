<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="Ajouter">
	<section>
		
		<form method="post" enctype="multipart/form-data" class="form-act"
			action="${pageContext.request.contextPath }/actes/prospections/uploads">
			<h2>Ajouter une autorisation de prospection</h2>			
			
			<div>
				<label for="dossier-demande">Dossier de demande</label>
				<select name="dossier-demande" id="dossier-demande">
					<option></option>
				</select>
			</div>
			<div>
				<label for="numero_ordre">Numéro d'ordre</label>
				<input type="text" name="numero_ordre" class="" id="numero_ordre">
			</div>
			<div>
				<label for="numero-octroi">Numéro d'octroi</label>
				<input type="text" name="numero-octroi" class="" id="numero-octroi">
			</div>
			<div>
				<label for="entreprise">Entreprise</label>
				<input type="text"  name="entreprise" id="entreprise">
			</div>
			<div>
				<label for="numero-acte">Numéro d'acte</label>
				<input type="text" placeholder="numéro d'acte" name="numero-acte" id="numero-acte">
			</div>
			<div>
				<label for="statut-acte">Statut</label>
				<select name="statut-acte" id="statut-acte">
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
				<label for="acte-numerise">Télécharger l'agrément</label>
				<input type="file" name="acte-numerise" id="acte-numerise">
			</div>
			<input type="hidden" name="doc" value="Actes">
			<input type="hidden" name="type" value="Prospections">
			<div>
				<input type="reset" value="Annuler">
				<input type="submit" value="Ajouter">
			</div>
		</form>
		<div class="visualisation">
		
		</div>
	</section>
</l:layout>