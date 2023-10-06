<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="Ajouter">
	<section>
		
		<form action="" method="post" class="form-act">
			<h2>Ajouter un permis de recherche</h2>			
			
			<div>
				<label for="dosdmd">Dossier de demande</label>
				<select name="dossier-demande" id="dosdmd">
					<option></option>
				</select>
			</div>
			<div>
				<label for="numoctroi">Numéro d'octroi</label>
				<input type="text" name="numero-octroi" class="" id="numoctroi">
			</div>
			<div>
				<label for="entreprise">Entreprise</label>
				<input type="text"  name="entreprise" id="entreprise">
			</div>
			<div>
				<label for="numacte">Numéro d'acte</label>
				<input type="text" placeholder="numéro d'acte" name="numero-acte" id="numacte">
			</div>
			<div>
				<label for="statut">Statut</label>
				<select name="statut-acte" id="statut">
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
				<textArea name="observations" id="obs"></textArea>
			</div>
			<div>
				<label for="annee-octroi">Année d'octroi</label>
				<input type="date" name="annee-octroi" id="annee-octroi">
			</div>			
			<div>
				<label for="annee-expiration">Année d'expiration</label>
				<input type="date" name="annee-expiration" id="annee-expiration">
			</div>
			<div>
				<label for="acte-numerise">Télécharger le permis de recherche</label>
				<input type="file" name="acte-numerise" id="acte-numerise">
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