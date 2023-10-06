<header>
	<div class="top-banniere">
		<div class="img-frame">
			<img class="logo" alt="logo de la dgmg" src="${pageContext.servletContext.contextPath }/images/img/dgmg.png">
		</div>
		<input type="checkbox" class="menu-checker" id="menu-checker">
		<label for="menu-checker" class="menu-icon">
			<span class="menu-btn-icon "></span>
		</label>
		<nav class="menu">
			<ul class="menu-list">
				<li class="menu-item"><a href="#">Accueil</a></li>
				<li class="menu-item"><a href="#">Demandes</a>
					<ul class="submenu">
						<li class="sub-menu-item"><a href="#">Agrements</a>
							<ul class="submenu-2">
								<li><a href="${pageContext.servletContext.contextPath }/demandes/agrements">Demandes</a></li>
								<li><a href="${pageContext.servletContext.contextPath }/renouvellement/agrements">Renouvellements</a></li>
							</ul>
						</li>
						<li class="sub-menu-item"><a href="#">Permis d'exploitation</a>
							<ul class="submenu-2">
								<li><a href="${pageContext.servletContext.contextPath }/demandes/exploitations">Demandes</a></li>
								<li><a href="${pageContext.servletContext.contextPath }/renouvellement/exploitations">Renouvellements</a></li>
							</ul>
						</li>
						<li class="sub-menu-item"><a href="#">Permis de recherche</a>
							<ul class="submenu-2">
								<li><a href="${pageContext.servletContext.contextPath }/demandes/recherches">Demandes</a></li>
								<li><a href="${pageContext.servletContext.contextPath }/renouvellement/recherches">Renouvellements</a></li>
							</ul>
						</li>
						<li class="sub-menu-item"><a href="#" class="">Prospections</a>
							<ul class="submenu-2">
								<li><a href="${pageContext.servletContext.contextPath }/demandes/prospections">Demandes</a></li>
								<li><a href="${pageContext.servletContext.contextPath }/renouvellement/prospections">Renouvellements</a></li>
							</ul>
						</li>
					</ul>
				</li>
				<li class="menu-item"><a href="#" class="">Actes</a>
					<ul class="submenu">
						<li><a href="${pageContext.servletContext.contextPath }/actes/agrements" class="">Agrements</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/actes/exploitations" class="">Permis d'exploitation</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/actes/recherches" class="">Permis de recherche</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/actes/prospections" class="">Prospections</a></li>
					</ul>
				</li>
				<li class="menu-item "><a href="#" class="">Productions &amp; taxes</a>
					<ul class="submenu">
						<li><a href="#">Productions </a></li>
						<li><a href="#">Ventes</a></li>
						<li><a href="#">Charges</a></li>
						<li><a href="#">Taxes</a></li>
					</ul>
				</li>
				<li class="menu-item"><a href="${pageContext.servletContext.contextPath }/users">Utilisateurs</a></li>
				<li class="menu-item"><a href="#">User</a>
					<ul class="submenu">
						<li><a href="${pageContext.servletContext.contextPath }/user/profile" class="">Mon profile</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/user/settings" class="">Configuration</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/user/password" class="">Changer de mot de passe</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/user/logout" class="">Déconnexion</a></li>
					</ul>
				</li>
				</ul>
		</nav>
		
		<div class="img-frame">
			<img class="amoiries" alt="les amoiries de la Côte d'Ivoire" src="${pageContext.servletContext.contextPath }/images/img/amoiries.png">
		</div>
		
	</div>
</header>