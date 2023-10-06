<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="Agrements">
	<section class = "main-section">
		<div class = "main-frame">
			<div class="frame-title">Demande de renouvellement d'AP</div>
			<div class ="bloc-items">
				<form class="searchbar">
					<input type="search" placeholder="Recherche">
					<button><img alt="" src="${pageContext.servletContext.contextPath }/images/icons/search.png"></button>
				</form>
				<nav class="nav-tools">
					<ul class="tools-list">
						<li><a href="${pageContext.servletContext.contextPath }/renouvellement/prospections/add" class="btn btn-add">+</a></li>
						<li><a href="#" class="btn btn-del" id="delete-rows">-</a></li>
					</ul>
				</nav>
				
				<div class="table-block">
					<table>
						<thead>
							<tr>
								<th><input type="checkbox" name="all" id="check-all"></th>
								<th class = "nd-col-1">N° demande</th>
								<th class = "nd-col-2">Demandeur</th>
								<th class = "nd-col-3">N° RCCM</th>
								<th class = "nd-col-5">Date de soumission</th>
								<th class = "nd-col-4">Statut</th>
							</tr>
						</thead>
						<tbody>
							<tr class="row" data-id="DOO1">
								<td><input type="checkbox" name="agr" class="checked-all"></td>
								<td class = "pe-col-1">D 001</td>
								<td class = "pe-col-2">Entreprise d'agrement authentique</td>
								<td class = "pe-col-3">RCCM 6789</td>
								<td class = "pe-col-4">15-Mai-2023</td>
								<td class = "pe-col-5">En traitement</td>
							</tr>
							<tr class="row" data-id="DOO2">
								<td><input type="checkbox" name="agr" class="checked-all"></td>
								<td class = "pe-col-1">D 002</td>
								<td class = "pe-col-2">Entreprise d'agrement authentique</td>
								<td class = "pe-col-3">RCCM 6789</td>
								<td class = "pe-col-4">15-Avril-2023</td>
								<td class = "pe-col-5">En traitement</td>
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