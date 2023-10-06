<div class="rubriques">
	<h3>Demande</h3>
</div>

<fieldset>
	<div>
		<label for="cadastreId">Numero du cadastre</label>
		<input type="text" name="cadastreId" id="cadastreId" required>
	</div>
	<div>
		<label for="lettre_demande">Lettre de demande</label>
		<input type="file" name="lettre_demande" id="lettre_demande" required>
	</div>
	<div>
		<label for="droit_fixe">Droit fixe</label>
		<input type="file" name="droit_fixe" id="droit_fixe" required>
	</div>
	<div>
		<label for="dossier_complementaire">Dossier complementaire</label>
		<input type="file" name="dossier_complementaire" id="dossier_complementaire">
	</div>
	<div>
		<label for="statut_demande">Statut</label>
		<select name="statut_demande" id="statut_demande">
			<option value="inprocess">En traitement</option>
		</select>
	</div>
	<div>
		<label for="datesoumission">Date de soumission</label>
		<input type="date" name="datesoumission" id="datesoumission">
	</div>
</fieldset>