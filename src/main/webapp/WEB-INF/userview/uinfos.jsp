<%@ taglib tagdir="/WEB-INF/tags/" prefix="l" %>

<l:layout title="Infos">
	
	<form method="post" action="" class="form-act">
		<h2>Informations personnelles</h2>
		<div>
			<label for="matricule">N° matricule</label>
			<input type="text" name="matricule" id="matricule" maxlength="7" required>
		</div>
		<%@ include file="/WEB-INF/includes/perso.jsp" %>
		<div>
			<label for="fonction">Fonction</label>
			<input type="text" name="fonction" id="fonction">
		</div>
		<div>
			<label for="direction">Direction</label>
			<input type="text" name="direction" id="direction">
		</div>
		<div>
			<label>
				<input type="checkbox" name="trainee" id="trainee">
				<span></span>
			</label>
			<label>
				<input type="checkbox" name="junior" id="junior">
				<span></span>
			</label>
			<label>
				<input type="checkbox" name="senior" id="senior">
				<span></span>
			</label>
			<label>
				<input type="checkbox" name="manager" id="manager">
				<span></span>
			</label>
			<label>
				<input type="checkbox" name="topmanager" id="topmanager">
				<span></span>
			</label>
		</div>
		<div>
			<label for="mdp">Mot de passe (par defaut)</label>
			<input type="password" name="mdp" id="mdp">
		</div>
		<div>
			<label for="photo">Photo</label>
			<input type="file" name="photo" id="photo">
		</div>
		<div>
			<input type="reset" value="Annuler">
			<input type="submit" value="Enregistrer">
		</div>
	</form>
</l:layout>