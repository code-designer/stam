<div class="rubriques">
	<h3>Demandeur</h3>
</div>
<fieldset class="demandeur">
	<div>
		<label for="demandeur">Type de demandeur</label>
		<select id="demandeur" name="demandeur">
			<option value="personne">Personne physique</option>
			<option value="entreprise">Personne morale</option>
		</select>
	</div>
	
	<div id="personne-physique">
		<%@ include file="/WEB-INF/includes/perso.jsp" %>
		<div>
			<label for="naturepiece">Nature de la pièce</label>
			<select id="naturepiece" name="nature_piece">
				<option value="CNI">CNI</option>
				<option value="Passeport">Passeport</option>
			</select>
		</div>
		<div>
			<label for="npiece">N° de la pièce</label>
			<input type="text" name="npiece" id="npiece">
		</div>
		<div>
			<label for="piece">Pièce d'identité</label>
			<input type="file" name="piece" id="piece">
		</div>
		<div>
			<label for="casier_judiciaire">Casier judiciaire</label>
			<input type="file" name="casier_judiciaire" id="casier_judiciaire">
		</div>
		<div>
			<label for="certificat_residence">Certificat de residence</label>
			<input type="file" name="certificat_residence" id="certificat_residence">
		</div>
	</div>
	
	<div id="personne-morale">
		<div>
			<label for="raison_sociale">Raison sociale</label>
			<input type="text" name="raison_sociale" id="raison_sociale">
		</div>
		<div>
			<label for="gerant">Gerant</label>
			<input type="text" name="gerant" id="gerant">
		</div>
		<div>
			<label for="statuts">Statuts</label>
			<input type="file" name="statuts" id="statuts">
		</div>
	</div>
</fieldset>