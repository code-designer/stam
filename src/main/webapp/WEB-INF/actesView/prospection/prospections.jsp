<%@ taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:layout title="Agrements">
	<section class = "main-section">
		<div class = "main-frame">
			<div class="frame-title">Prospections</div>
			<div class ="bloc-items">
				<form class="searchbar">
					<input type="search" placeholder="Recherche">
					<button><img alt="" src="${pageContext.servletContext.contextPath }/images/icons/search.png"></button>
				</form>
				<nav class="nav-tools">
					<ul class="tools-list">
						<li><a href="${pageContext.servletContext.contextPath }/actes/prospections/add" class="btn btn-add">+</a></li>
						<li><a href="#" class="btn btn-del" id="delete-rows">-</a></li>
					</ul>
				</nav>
				
				<div class="table-block">
					<table>
						<thead>
							<tr>
								<th><input type="checkbox" name="all" id="check-all"></th>
								<th >Numéro d'octroi</th>
								<th class = "agr-col-2">Entreprise</th>
								<th class = "agr-col-3">Domaine</th>
								<th class = "agr-col-4">Arrêté d'agrement</th>
								<th class = "agr-col-5">Année d'octroi</th>
							</tr>
						</thead>
						<tbody>
							<tr class="row" data-id="asm001">
								<td><input type="checkbox" name="agr" class="checked-all"></td>
								<td class = "agr-col-1">ASM 001</td>
								<td class = "agr-col-2">Entreprise d'agrement authentique</td>
								<td class = "agr-col-3">Domaine d'authenticité en transport miner et carrière</td>
								<td class = "agr-col-4">097/MMPE/MPMBPE du 24/08/2023</td>
								<td class = "agr-col-5">2023</td>
							</tr>
							<tr class="row" data-id="asm002">
								<td><input type="checkbox" name="agr" class="checked-all"></td>
								<td class = "agr-col-1">ASM 002</td>
								<td class = "agr-col-2">Entreprise d'agrement Nikolo</td>
								<td class = "agr-col-3">Domaine Fab miner et carrière</td>
								<td class = "agr-col-4">112/MMPE/MPMBPE du 07/11/2022</td>
								<td class = "agr-col-5">2022</td>
							</tr>
							<tr class="row" data-id="asm003">
								<td><input type="checkbox" name="agr" class="checked-all"></td>
								<td class = "agr-col-1">ASM 003</td>
								<td class = "agr-col-2">Entreprise d'agrement Nikolo</td>
								<td class = "agr-col-3">Domaine Fab miner et carrière</td>
								<td class = "agr-col-4">112/MMPE/MPMBPE du 07/11/2022</td>
								<td class = "agr-col-5">2022</td>
							</tr>
							<tr class="row" data-id="asm004">
								<td><input type="checkbox" name="agr" class="checked-all"></td>
								<td class = "agr-col-1">ASM 004</td>
								<td class = "agr-col-2">Entreprise d'agrement Nikolo</td>
								<td class = "agr-col-3">Domaine Fab miner et carrière</td>
								<td class = "agr-col-4">112/MMPE/MPMBPE du 07/11/2022</td>
								<td class = "agr-col-5">2022</td>
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