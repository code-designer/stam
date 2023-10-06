<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="Agrements">
	<section class = "main-section">
		<div class = "main-frame">
			<div class="frame-title">Permis de recherche</div>
			<div class ="bloc-items">
				<form class="searchbar">
					<input type="search" placeholder="Recherche">
					<button><img alt="" src="./images/icons/search.png"></button>
				</form>
				<nav class="nav-tools">
					<ul class="tools-list">
						<li><a href="#" class="btn btn-add">+</a></li>
						<li><a href="#" class="btn btn-del" id="delete-rows">-</a></li>
					</ul>
				</nav>
				
				<div class="table-block">
					<table>
						<thead>
							<tr>
								<th><input type="checkbox" name="all" id="check-all"></th>
								<th class = "pr-col-1">N°Ordre</th>
								<th class = "pr-col-2">Numéro d'octroi</th>
								<th class = "pr-col-3">Entreprise</th>
								<th class = "pr-col-4">Décret</th>
								<th class = "pr-col-5">Substance</th>
								<th class = "pr-col-6">Année d'octroi</th>
							</tr>
						</thead>
						<tbody>
							<tr class="row" data-id="PR001">
								<td><input type="checkbox" name="agr" class="checked-all"></td>
								<td class = "pr-col-1">105</td>
								<td class = "pr-col-2">PR 001</td>
								<td class = "pr-col-3">Entreprise d'agrement authentique</td>
								<td class = "pr-col-4">097/MMPE/MPMBPE du 24/08/2023</td>
								<td class = "pr-col-5">OR</td>
								<td class = "pr-col-6">2023</td>
							</tr>
							<tr class="row" data-id="PR002">
								<td><input type="checkbox" name="agr" class="checked-all"></td>
								<td class = "pr-col-1">102</td>
								<td class = "pr-col-2">PR 002</td>
								<td class = "pr-col-3">Entreprise d'agrement Nikolo</td>
								<td class = "pr-col-4">097/MMPE/MPMBPE du 24/08/2023</td>
								<td class = "pr-col-5">OR</td>
								<td class = "pr-col-6">2022</td>
							</tr>
							<tr class="row" data-id="PR003">
								<td><input type="checkbox" name="agr" class="checked-all"></td>
								<td class = "pr-col-1">99</td>
								<td class = "pr-col-2">PR 003</td>
								<td class = "pr-col-3">Entreprise d'agrement Nikolo</td>
								<td class = "pr-col-4">097/MMPE/MPMBPE du 24/08/2023</td>
								<td class = "pr-col-5">OR</td>
								<td class = "pr-col-6">2022</td>
							</tr>
							<tr class="row" data-id="PR001">
								<td><input type="checkbox" name="agr" class="checked-all"></td>
								<td class = "pr-col-1">95</td>
								<td class = "pr-col-2">PR 001</td>
								<td class = "pr-col-3">Entreprise d'agrement Nikolo</td>
								<td class = "pr-col-4">097/MMPE/MPMBPE du 24/08/2023</td>
								<td class = "pr-col-5">OR</td>
								<td class = "pr-col-6">2022</td>
							</tr>
						</tbody>
					</table>
				</div>
				<form class="pagination">
					<button>&lt</button>
					<label id="page">1</label>
					<button>&gt</button>
				</form>
			</div>
		</div>
	</section>
</l:layout>