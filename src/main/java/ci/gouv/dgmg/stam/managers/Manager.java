package ci.gouv.dgmg.stam.managers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ci.gouv.dgmg.stam.common.Personne;
import ci.gouv.dgmg.stam.models.acte.Acte;
import ci.gouv.dgmg.stam.models.acte.Agrement;
import ci.gouv.dgmg.stam.models.acte.Detenteur;
import ci.gouv.dgmg.stam.models.acte.PermisExploitation;
import ci.gouv.dgmg.stam.models.acte.PermisRecherche;
import ci.gouv.dgmg.stam.models.acte.Prospection;
import ci.gouv.dgmg.stam.models.acte.StatutActe;
import ci.gouv.dgmg.stam.models.acte.Titre;
import ci.gouv.dgmg.stam.models.acteur.Entite;
import ci.gouv.dgmg.stam.models.acteur.Operateur;
import ci.gouv.dgmg.stam.models.acteur.Requerent;
import ci.gouv.dgmg.stam.models.demande.Demande;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvelle;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleAgrement;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvellePE;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvellePR;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleProspection;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellement;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementAgrement;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementPE;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementPR;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementProspection;
import ci.gouv.dgmg.stam.models.demande.Demandeur;
import ci.gouv.dgmg.stam.models.demande.StatutDemande;
import ci.gouv.dgmg.stam.models.user.Agent;
import ci.gouv.dgmg.stam.models.user.Contact;
import ci.gouv.dgmg.stam.models.user.Localisation;
import ci.gouv.dgmg.stam.models.user.Sexe;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Manager {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected final String CHEMIN_FICHIER = "C:\\Users\\bigoh\\Documents\\Stam\\";
	protected final String PHOTO_FOLDER = CHEMIN_FICHIER + "Photos\\";
	protected final String REQUERENT_FOLDER = CHEMIN_FICHIER + "Requerents\\";
	protected final String ENTREPRISE_FOLDER = CHEMIN_FICHIER + "Entreprises\\";
	protected final String SEPARATOR  = "\\";
	protected Path cheminEntier;
	
	private final String ENTREPRISE = "entreprise";
	private final String PERSONNE = "personne";
	
	private static final Logger logger = LoggerFactory.getLogger(Manager.class);
	
	/**
	 * Construit l'objet operateur à partir d'un HttpServletRequest
	 * @return Operateur
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public Operateur setOperateur(Operateur operateur) throws ServletException, IOException {
		logger.trace("Build operateur");
		System.out.println("buildOperateur");
		
		String typeOperateur = request.getParameter("demandeur");
		if(typeOperateur.equals(ENTREPRISE)) {
			long id = Long.parseLong(request.getParameter("id") == null ? "0" : request.getParameter("id"));
			String raisonSociale = request.getParameter("raison_sociale");
			String gerant = request.getParameter("gerant");
			Path statuts = getFormFilePath(ENTREPRISE_FOLDER,
					getFilename(request.getPart("statuts")));
			
			operateur.setEntite(new Entite(id, raisonSociale, gerant, statuts));
		}
		
		if(typeOperateur.equals(PERSONNE)) {
			Requerent requerent = new Requerent();
			setPersonne(requerent);
			Path casier = getFormFilePath(REQUERENT_FOLDER + requerent.getNumeroDePiece(),
					getFilename(request.getPart("casier_judiciaire")));
			Path certificat = getFormFilePath(REQUERENT_FOLDER + requerent.getNatureDePiece(),
					getFilename(request.getPart("certificat_residence")));
			String natureDePiece = request.getParameter("nature_piece");
			String npiece = request.getParameter("npiece");
			Path piece_identite = getFormFilePath(REQUERENT_FOLDER + requerent.getNatureDePiece(),
					getFilename(request.getPart("piece_identite")));
			requerent.setCasierJudiciaire(casier);
			requerent.setCertificatResidence(certificat);
			requerent.setNatureDePiece(natureDePiece);
			requerent.setNumeroDePiece(npiece);
			requerent.setPieceIdentite(piece_identite);
			operateur.setRequerent(requerent);
		}
		
		return operateur;
	}
	
	private Demandeur buildDemandeur() throws ServletException, IOException {
		Demandeur demandeur = new Demandeur();
		setOperateur(demandeur);
		return demandeur;
	}
	
	private Detenteur buildDetenteur() throws ServletException, IOException {
		Detenteur detenteur = new Detenteur();
		setOperateur(detenteur);
		return detenteur;
	}
	
	/**
	 * Construit l'objet Personne à partir d'un HttpServletRequest
	 * @param p Personne
	 */
	private void setPersonne(Personne p) throws ServletException, IOException {
		logger.trace("Populate personne");
		System.out.println("setPersonne");
		
		String nom = request.getParameter("nom");
		String prenoms = request.getParameter("prenoms");
		Sexe sexe = Sexe.toSexe(request.getParameter("sexe"));
		LocalDate dateDeNaissance = LocalDate.parse(request.getParameter("date_naissance"));
		Path photo = getFormFilePath(PHOTO_FOLDER, getFilename(request.getPart("photo")));
		
		p.setNom(nom);
		p.setPrenoms(prenoms);
		p.setSexe(sexe);
		p.setDateDeNaissance(dateDeNaissance);
		p.setPhoto(photo);
		p.setContacts(buildContact());
	}
	
	/**
	 * Construit la classe Agent à partir de la classe HttpServletRequest
	 * @return Agent
	 * @throws ServletException
	 * @throws IOException
	 */
	public Agent buildAgent() throws ServletException, IOException {
		logger.trace("Build agent");
		Agent agent = new Agent();
		setPersonne(agent);
		
		String matricule = request.getParameter("matricule");
		String fonction = request.getParameter("fonction");
		String service = request.getParameter("service");
		agent.setMatricule(matricule);
		agent.setFonction(fonction);
		agent.setService(service);
		agent.setLocalisation(buildLocalisation());
		return agent;
	}
	
	public Agent buildAuthenticatedAgent() throws ServletException, IOException {
		if(!request.getSession().getAttribute("connexionStatus").equals("Connected"))
			return null;
		return (Agent)request.getSession().getAttribute("agentinfos");
	}
	
	/**
	 * Construit la classe Contact à partir de la classe HttpServletRequest
	 * @return Contact
	 */
	public Contact buildContact() {
		logger.trace("Build contact");
		System.out.println("BuildContact");
		
		String telephoneMob = request.getParameter("telperso");
		String telephonePro = request.getParameter("telpro");
		String emailPerso = request.getParameter("emailperso");
		String emailPro = request.getParameter("emailpro");
		String adressePostale = request.getParameter("adressePostale");
		Contact contact = new Contact(telephoneMob, telephonePro, emailPerso, emailPro, adressePostale);
		return contact;
	}
	
	/**
	 * Construit la classe Localisation à partir de la classe HttpServletRequest
	 * @return Localisation
	 */
	public Localisation buildLocalisation() {
		logger.trace("Build Localisation");
		System.out.println("BuildLocalisation");
		
		long id = Long.parseLong(request.getParameter("id_loc") == null ? "0" : request.getParameter("id_loc"));
		String quartier = request.getParameter("quartier");
		String commune = request.getParameter("commune");
		String ville = request.getParameter("ville");
		String description = request.getParameter("description");
		Localisation localisation = new Localisation();
		localisation.setId(id);
		localisation.setCommune(commune);
		localisation.setQuartier(quartier);
		localisation.setVille(ville);
		localisation.setDescription(description);
		return localisation;
	}
	
	/**
	 * Construit le chemin de sauvegarde des fichiers à partir du type et du document
	 * @return Path
	 */
	private Path getFolderPath() {
		String type =  request.getParameter("type");
		String doc = request.getParameter("doc");
		return Paths.get(CHEMIN_FICHIER).resolve(type).resolve(doc);
	}
	
	/**
	 * Affecte les valeurs aux differents attributs de l'objet acte à partir d'une requete
	 * HttpServletRequest
	 * @param acte
	 * @throws IOException
	 * @throws ServletException
	 */
	private void setActe(Acte acte) throws IOException, ServletException {
		logger.trace("Populate Acte object");
		System.out.println("setActe");
		
		String numeroOctroi = request.getParameter("numero_octroi");
		this.cheminEntier = getFolderPath().resolve(numeroOctroi);
		String numeroActe = request.getParameter("numero_acte");
		StatutActe statut = StatutActe.toStatut(request.getParameter("statut_acte"));
		LocalDate anneeOctroi = LocalDate.parse(request.getParameter("annee_octroi"));
		LocalDate anneeExpiration = LocalDate.parse(request.getParameter("annee_expiration"));
		Path acteNumerise = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("acte_numerise")));
		
		acte.setNumeroOctroi(numeroOctroi);
		acte.setNumeroActe(numeroActe);
		acte.setStatut(statut);
		acte.setAnneeOctroi(anneeOctroi);
		acte.setAnneeExpiration(anneeExpiration);
		acte.setActeNumerise(acteNumerise);
		acte.setDetenteur(buildDetenteur());
		//acte.setAgent(buildAuthenticatedAgent());	
		}
	
	/**
	 * Affecte les valeurs aux differents attributs de l'objet titre à partir d'une requete
	 * HttpServletRequest
	 * @param titre
	 * @throws IOException
	 * @throws ServletException
	 */
	private void setTitre(Titre titre) throws IOException, ServletException {
		logger.trace("Populate Titre Object");
		System.out.println("setTitre");
		
		setActe(titre);
		double superfice = Double.parseDouble(request.getParameter("superficie"));
		String localite = request.getParameter("localite");
		String region = request.getParameter("region");
		titre.setSuperficie(superfice);
		titre.setRegion(region);
		titre.setLocalite(localite);
	}
	
	/**
	 * Construit la classe Agrement à partir de la classe HttpServletRequest et de l'heritage de la classe
	 * Acte
	 * @return Agrement
	 * @throws IOException
	 * @throws ServletException
	 */
	public Agrement buildAgrement() throws IOException, ServletException {
		logger.trace("Build Agrement Object");
		System.out.println("buildAgrement");
		
		Agrement agrement = new Agrement();
		setActe(agrement);
		String domaine = request.getParameter("domaine");
		String etat = request.getParameter("etat");
		String observations = request.getParameter("observations");
		agrement.setDomaine(domaine);
		agrement.setEtat(etat);
		agrement.setObservations(observations);
		return agrement;
	}
	
	/**
	 *  Construit la classe PermisExploitation de l'heritage de la classe Titre
	 * 
	 * @return PermisExploitation
	 * @throws IOException
	 * @throws ServletException
	 */
	public PermisExploitation buildPE() throws IOException, ServletException {
		logger.trace("Build PermisExploitation Object");
		PermisExploitation pe = new PermisExploitation();
		setTitre(pe);
		return pe;
	}
	
	/**
	 * Construit la classe PermisRecherche à partir de la classe HttpServletRequest et 
	 * de l'heritage de la classe Titre
	 * @return PermisRecherche
	 * @throws IOException
	 * @throws ServletException
	 */
	public PermisRecherche buildPR() throws IOException, ServletException {
		logger.trace("Build PermisRecherche Object");
		PermisRecherche pr = new PermisRecherche();
		setTitre(pr);
		int ordre = Integer.parseInt(request.getParameter("ordre"));
		pr.setOrdre(ordre);
		return pr;
	}
	
	/**
	 * Construit la classe Prospection à partir de la classe HttpServletRequest et 
	 * de l'heritage de la classe Titre
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	public Prospection buildProspection() throws IOException, ServletException {
		logger.trace("Build Prospection Object");
		Prospection prospec = new Prospection();
		setActe(prospec);
		int ordre = Integer.parseInt(request.getParameter("ordre"));
		prospec.setOrdre(ordre);
		return prospec;
	}
	
	/**
	 * Affecte les valeurs aux differents attributs de l'objet demande à partir d'une requete
	 * HttpServletRequest
	 * @param demande
	 * @throws IOException
	 * @throws ServletException
	 */
	private void setDemande(Demande demande) throws IOException, ServletException {
		logger.trace("Populate Demande object");
		System.out.println("setDemande");
		
		String cadastreId = request.getParameter("cadastre_id");
		this.cheminEntier =  this.getFolderPath().resolve(cadastreId);
		
		LocalDate dateSoumission = LocalDate.parse(request.getParameter("date_soumission"));
		Path droit_fixe = getFormFilePath(this.cheminEntier, getFilename(request.getPart("droit_fixe")));
		
		Path dossier_complementaire = getFormFilePath(this.cheminEntier,getFilename(request.getPart("dossier_complementaire")));
		StatutDemande statutDemande = StatutDemande.toStatut(request.getParameter("statut_demande"));
		
		demande.setCadastreId(cadastreId);
		demande.setDateSoumission(dateSoumission);
		demande.setDroitFixe(droit_fixe);
		demande.setStatut(statutDemande);
		demande.setDossierComplementaire(dossier_complementaire);
		demande.setDemandeur(buildDemandeur());
		//demande.setAgent(buildAuthenticatedAgent());
		
	}
	
	/**
	 * Affecte les valeurs aux differents attributs de l'objet de type DemandeNouvelle à partir d'une requete
	 * HttpServletRequest
	 * @param demandeNouvelle
	 * @throws IOException
	 * @throws ServletException
	 */
	private void setDemandeNouvelle(DemandeNouvelle demandeNouvelle) throws IOException, ServletException {
		logger.trace("populate DemandeNouvelle Object");
		System.out.println("setDemandeNouvelle");
		
		setDemande(demandeNouvelle);
		Path lettre_demande = getFormFilePath(this.cheminEntier,getFilename(request.getPart("lettre_demande")));
		Path rccm = getFormFilePath(this.cheminEntier,getFilename(request.getPart("rccm")));
		demandeNouvelle.setLettreDeDemande(lettre_demande);
		demandeNouvelle.setRccm(rccm);
	}
	
	/**
	 * Construit la classe DemandeNouvelleAgrement à partir de la classe HttpServletRequest.
	 * @return DemandeNouvellementAgrement
	 * @throws IOException
	 * @throws ServletException
	 */
	public DemandeNouvelleAgrement buildDemandeNouvelleAgrement() throws IOException, ServletException {
		logger.trace("Build DemandeNouvelleAgrement Object");
		System.out.println("buildDemandeNouvelleAgrement");
		
		DemandeNouvelleAgrement dmdNouvAgrmt = new DemandeNouvelleAgrement();
		setDemandeNouvelle(dmdNouvAgrmt);
		
		String typeActivite = request.getParameter("type_activite");
		
		Path cvRT = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("cv_respo_tech")));
		
		Path memoire = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("memoire")));
		
		String numeroCC = request.getParameter("nrccm");
		
		Path listeAutresActivites = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("liste_autres_activites")));
		
		Path contratSousTraitance = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("contrat_sous_traitance")));
		
		Path copieTitreMinier = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("copie_titre_minier")));
		
		Path declarationSurHonneur = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("declaration_honneur")));
		
		Path listeDePosteCategorie = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("liste_postes_categories")));
		
		Path listePersonnel = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("liste_personnel")));
		
		dmdNouvAgrmt.setCvRT(cvRT);	
		dmdNouvAgrmt.setMemoire(memoire);
		dmdNouvAgrmt.setTypeActivite(typeActivite);
		dmdNouvAgrmt.setNumeroCompteContribuable(numeroCC);
		dmdNouvAgrmt.setListeAutresActivites(listeAutresActivites);
		dmdNouvAgrmt.setContratDeSousTraitance(contratSousTraitance);
		dmdNouvAgrmt.setCopietitreMinier(copieTitreMinier);
		dmdNouvAgrmt.setDeclarationSurHonneur(declarationSurHonneur);
		dmdNouvAgrmt.setListeDesPostesParCategorie(listeDePosteCategorie);
		dmdNouvAgrmt.setListePersonnel(listePersonnel);
		return dmdNouvAgrmt;
	}
	
	/**
	 * Construit la classe DemandeNouvelleAgrement à partir de la classe HttpServletRequest.
	 * @return DemandeNouvellePE
	 * @throws IOException
	 * @throws ServletException
	 */
	public DemandeNouvellePE buildDemandeNouvellePE() throws IOException, ServletException {
		logger.trace("Build DemandeNouvellePE Object");
		System.out.println("buildDemandeNouvellePE");
		
		DemandeNouvellePE demandeNouvellePE = new DemandeNouvellePE();
		setDemandeNouvelle(demandeNouvellePE);
		
		Path rapportTravauxRecherches = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("rapport_travaux_recherches")));
		
		Path rapportEtudeFaisabilite = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("rapport_etude_faisabilite")));
		
		Path arreteApprobationEIES = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("arrete_approbation_eies")));
		
		Path planFinancement = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("plan_financement")));
		
		Path nombreEmploiCategorie = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("nombre_emploi_par_categorie")));
		
		Path rapportVisiteTerrain = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("rapport_visite_terrain")));
		
		demandeNouvellePE.setRapportDesTravauxDeRecherche(rapportTravauxRecherches);
		demandeNouvellePE.setRapportEtudeFaisabilite(rapportEtudeFaisabilite);
		demandeNouvellePE.setArreteApprobatioinEIES(arreteApprobationEIES);
		demandeNouvellePE.setPlanDeFinancement(planFinancement);
		demandeNouvellePE.setNombreEmploiParCategorie(nombreEmploiCategorie);
		demandeNouvellePE.setRapportVisite(rapportVisiteTerrain);
		
		return demandeNouvellePE;
	}
	
	/**
	 * Construit la classe DemandeNouvellePR à partir de la classe HttpServletRequest.
	 * @return DemandeNouvellePR
	 * @throws IOException
	 * @throws ServletException
	 */
	public DemandeNouvellePR buildDemandeNouvellePR() throws IOException, ServletException {
		logger.trace("Build DemandeNouvellePR Object");
		System.out.println("buildDemandeNouvellePR");
		
		DemandeNouvellePR demandeNouvellePR = new DemandeNouvellePR();
		setDemandeNouvelle(demandeNouvellePR);
		
		Path cvRT = getFormFilePath(this.cheminEntier,getFilename(request.getPart("cv_respo_tech")));
		Path programmeGeneralDesTravaux = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("prog_general_travaux")));
		
		Path programmeDetaille = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("programme_detaille")));
		
		Path listeDesPostes = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("liste_des_postes")));
		
		Path lettreDeDesignation = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("lettre_designation")));
		
		Path photocopiesDiplomes = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("photocopie_diplomes")));
		
		Path experienceDemandeur = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("experience_demandeur")));
		
		Path attestationBancaire = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("attestation_bancaire")));
		
		Path releveBancaire = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("releve_bancaire")));
		
		Path attestationRegulariteFiscale = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("attestation_regularite_fiscale")));
		
		Path carteA4 = getFormFilePath(this.cheminEntier, getFilename(request.getPart("carte_A4")));
		
		Path carte200_000 = getFormFilePath(this.cheminEntier, getFilename(request.getPart("carte_200000")));
				
		demandeNouvellePR.setCvRT(cvRT);
		demandeNouvellePR.setProgrammeGeneralDesTravauxSurQuatreAns(programmeGeneralDesTravaux);
		demandeNouvellePR.setProgrammeDetailleDeLaPremiereAnnee(programmeDetaille);
		demandeNouvellePR.setListeDesPostesParCategorie(listeDesPostes);
		demandeNouvellePR.setLettreDeDesignationDuRT(lettreDeDesignation);
		demandeNouvellePR.setPhotocopieDesDiplomes(photocopiesDiplomes);
		demandeNouvellePR.setExperienceDuDemandeur(experienceDemandeur);
		demandeNouvellePR.setAttestationBancaire(attestationBancaire);
		demandeNouvellePR.setReleveBancaire(releveBancaire);
		demandeNouvellePR.setAttestationDeRegulariteFiscale(attestationRegulariteFiscale);
		demandeNouvellePR.setCarteA4(carteA4);
		demandeNouvellePR.setCarte200000(carte200_000);
		return demandeNouvellePR;
	}
	
	/**
	 * Construit la classe DemandeNouvelleProspection à partir de la classe HttpServletRequest.
	 * @return DemandeNouvelleProspection
	 * @throws IOException
	 * @throws ServletException
	 */
	public DemandeNouvelleProspection buildDemandeNouvelleProspection() throws IOException, ServletException {
		logger.trace("Build DemandeNouvelleProspection Object");
		System.out.println("buildDemandeNouvelleProspection");
		
		DemandeNouvelleProspection demandeNouvelleProspection = new DemandeNouvelleProspection();
		setDemandeNouvelle(demandeNouvelleProspection);
		
		Path carteZone = getFormFilePath(this.cheminEntier,getFilename(request.getPart("carte_zone")));
		Path programmeDeProspection = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("programme_prospection")));
		Path cvRespoTech = getFormFilePath(this.cheminEntier,getFilename(request.getPart("cv_respo_tech")));
		Path rapportVisiteTerrain = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("rapport_visite_terrain")));
		
		demandeNouvelleProspection.setCarteZone(carteZone);
		demandeNouvelleProspection.setProgrammeDePropection(programmeDeProspection);
		demandeNouvelleProspection.setCvRT(cvRespoTech);
		demandeNouvelleProspection.setRapportVisite(rapportVisiteTerrain);
		return demandeNouvelleProspection;
	}
	
	/**
	 * Affecte les valeurs aux differents attributs de l'object de type DemandeRenouvellement
	 * @param dr
	 * @throws IOException
	 * @throws ServletException
	 */
	private void setDemandeRenouvellement(DemandeRenouvellement dr) throws IOException, ServletException {
		logger.trace("Populate DemandeRenouvellement Object");
		System.out.println("setDemandeRenouvellement");
		setDemande(dr);
		Path lettreDemandeRenouvellement = Paths.get(request.getParameter("lettre_demande"));
		dr.setLettreDeDemandeDeRenouvellement(lettreDemandeRenouvellement);
	}
	
	/**
	 * Affecte les valeurs aux differents attributs de l'objet de type DemandeRenouvellementAgrement
	 * @return DemandeRenouvellementAgrement 
	 * @throws IOException
	 * @throws ServletException
	 */
	public DemandeRenouvellementAgrement buildDemandeRenouvellementAgrement() 
			throws IOException, ServletException {
		logger.trace("Build DemandeRenouvellementAgrement");
		System.out.println("buildDemandeRenouvellementAgrement");
		
		DemandeRenouvellementAgrement dmdRenAgrmt = new DemandeRenouvellementAgrement();
		setDemandeRenouvellement(dmdRenAgrmt);
		
		Path typeActivite = Paths.get(request.getParameter("type_activite"));
		Path rapportTechFin = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("rapport_technique_financier")));
		
		Path copieTitreMinier = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("copie_titre_minier")));
		
		dmdRenAgrmt.setTypeActivite(typeActivite);
		dmdRenAgrmt.setRapportGeneralTechnFin(rapportTechFin);
		dmdRenAgrmt.setCopieTitreMinier(copieTitreMinier);
		return dmdRenAgrmt;
	}
	
	/**
	 * Construit la classe DemandeNouvellePR à partir de la classe HttpServletRequest.
	 * @return DemandeRenouvellementPE
	 * @throws IOException
	 * @throws ServletException
	 */
	public DemandeRenouvellementPE buildDemandeRenouvellementPE() throws IOException, ServletException {
		logger.trace("DemandeRenouvellementPE");
		System.out.println("buildDemandeRenouvellementPE");
		
		DemandeRenouvellementPE dmdRenPE = new DemandeRenouvellementPE();
		setDemandeRenouvellement(dmdRenPE);
		
		Path rapportFaisabilite = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("rapport_faisabilite")));
		
		Path planEiesActualise = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("plan_eies_actualise")));
		
		dmdRenPE.setPlanEIESactualise(planEiesActualise);
		dmdRenPE.setRapportFaisabiliteTechEco(rapportFaisabilite);
		return dmdRenPE;
	}
	
	/**
	 * Construit la classe DemandeRenouvellementPR à partir de la classe HttpServletRequest.
	 * @return DemandeRenouvellementPR
	 * @throws IOException
	 * @throws ServletException
	 */
	public DemandeRenouvellementPR buildDemandeRenouvellementPR() 
			throws IOException, ServletException {
		logger.trace("DemandeRenouvellementPR");
		System.out.println("buildDemandeRenouvellement");
		
		DemandeRenouvellementPR dmdRenPR = new DemandeRenouvellementPR();
		setDemandeRenouvellement(dmdRenPR);
		
		Path situationCarte = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("extrait_carte")));
		
		Path rapportGeneral = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("programme_general_travaux")));
		
		Path programmeGeneralEtDetaille = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("programme_general_detaille")));
		
		Path droitOption = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("droit_option")));
		
		dmdRenPR.setSituationDeLaCarte(situationCarte);
		dmdRenPR.setRapportGeneralDesTravauxDeRecherche(rapportGeneral);
		dmdRenPR.setProgrammeGeneralEtDetailleDesTravaux(programmeGeneralEtDetaille);
		dmdRenPR.setDroitOption(droitOption);
		
		return dmdRenPR;
	}
	
	/**
	 * Construit la classe DemandeRenouvellementProspection à partir de la classe HttpServletRequest.
	 * @return DemandeRenouvellementProspection
	 * @throws IOException
	 * @throws ServletException
	 */
	public DemandeRenouvellementProspection buildDemandeRenouvellementProspection() 
			throws IOException, ServletException {
		logger.trace("DemandeRenouvellementProspection Object");
		
		DemandeRenouvellementProspection drp = new DemandeRenouvellementProspection();
		setDemandeRenouvellement(drp);
		
		Path rapportActivite = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("rapport_activite_prospec")));
		
		Path programmeProspection = getFormFilePath(this.cheminEntier,
				getFilename(request.getPart("programme_prospection")));
		
		drp.setRapportActiviteDeProspection(rapportActivite);
		drp.setProgrammeProspection(programmeProspection);
		return null;
	}
	
	private Path getFormFilePath( Path path, String filename) throws IOException {
		logger.trace("resolve path");
		return filename == null ? null : path.resolve(filename);
	}
	
	private Path getFormFilePath( String path, String filename) throws IOException {
		logger.trace("Resolve path from string");
		Path folder = Paths.get(path);
		return getFormFilePath(folder, filename);
	}
	
	public void copyFile(Part source, Path destination) throws IOException {
		logger.trace("Copy files...");
		Files.copy(source.getInputStream(), destination);
	}
	
	public String getFilename(Part part) {
		logger.trace("get part header");
		for(String contentDisposition:part.getHeader("content-disposition").split(";")) {
			if(contentDisposition.trim().startsWith("filename")) {
				return contentDisposition.substring(contentDisposition.indexOf("=") + 1)
				.trim().replace("\"", "");
			}
		}
		return null;
	}
	
}
