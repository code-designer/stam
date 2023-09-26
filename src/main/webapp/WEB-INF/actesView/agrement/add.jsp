<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="Ajouter agrement">
	<section>
		<h3>Nouvelle Agrement</h3>
		<form action="" method="post">
			<div>
				<label for="dosdmd">Dossier de demande</label>
				<select name="dossier-demande" id="dosdmd">
					<option></option>
				</select>
			</div>
			<div>
				<label for="numoctroi">Numéro d'octroi</label>
				<input type="text" placeholder="numéro d'octroi" name="numero-octroi" class="" id="numoctroi">
			</div>
			<div>
				<label for="entreprise">Entreprise</label>
				<input type="text" placeholder="entreprise" name="entreprise" id="entreprise">
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
				<textArea type="text" name="observations" id="obs"></textArea>
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
				<label for="acte-numerise">Télécharger l'agrément</label>
				<input type="file" name="acte-numerise" id="acte-numerise">
			</div>
			<div>
				<input type="reset" value="Annuler">
				<input type="submit" value="Ajouter">
			</div>
		</form>
		<div class="visualisation">
		
		</div>
	</section>
</l:layout>