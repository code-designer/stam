package ci.gouv.dgmg.stam.managers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import ci.gouv.dgmg.stam.common.Personne;
import ci.gouv.dgmg.stam.models.acte.Acte;
import ci.gouv.dgmg.stam.models.acte.Agrement;
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
import ci.gouv.dgmg.stam.models.demande.StatutDemande;
import ci.gouv.dgmg.stam.models.user.Agent;
import ci.gouv.dgmg.stam.models.user.Contact;
import ci.gouv.dgmg.stam.models.user.Localisation;
import ci.gouv.dgmg.stam.models.user.Sexe;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
	
	public Operateur buildOperateur() {
		long id = Long.parseLong(request.getParameter("id"));
		String raisonSociale = request.getParameter("raison_social");
		String gerant = request.getParameter("gerant");
		Path pathStatut = Paths.get(request.getParameter("pathStatut"));
		
		Entite entite = new Entite(id, raisonSociale, gerant, pathStatut);
		
		Requerent requerent = new Requerent();
		setPersonne(requerent);
		Path casier = Paths.get(request.getParameter("casier_judiciaire"));
		Path certificat = Paths.get(request.getParameter("certificat_residence"));
		requerent.setCasierJudiciaire(casier);
		requerent.setCertificatResidence(certificat);
		
		Operateur operateur = new Operateur();
		operateur.setEntite(entite);
		operateur.setRequerent(requerent);
		
		return operateur;
	}
	
	private void setPersonne(Personne p) {
		String nom = request.getParameter("nom");
		String prenoms = request.getParameter("prenoms");
		Sexe sexe = Sexe.toSexe(request.getParameter("sexe"));
		LocalDate dateDeNaissance = LocalDate.parse(request.getParameter("date_de_naissance"));
		Path photo = Paths.get(request.getParameter("photo"));
		
		p.setNom(nom);
		p.setPrenoms(prenoms);
		p.setSexe(sexe);
		p.setDateDeNaissance(dateDeNaissance);
		p.setPhoto(photo);
	}
	
	public Agent buildAgent() {
		Agent agent = new Agent();
		setPersonne(agent);
		
		String matricule = request.getParameter("matricule");
		String fonction = request.getParameter("fonction");
		String service = request.getParameter("service");
		agent.setMatricule(matricule);
		agent.setFonction(fonction);
		agent.setService(service);
		return agent;
	}
	
	public Contact buildContact() {
		String telephoneMob = request.getParameter("telephone_mob");
		String telephonePro = request.getParameter("telephone_pro");
		String emailPerso = request.getParameter("email_perso");
		String emailPro = request.getParameter("email_pro");
		String adressePostal = request.getParameter("adressePostal");
		Contact contact = new Contact(telephoneMob, telephonePro, emailPerso, emailPro, adressePostal);
		return contact;
	}
	
	public Localisation buildLocalisation() {
		long id = Long.parseLong(request.getParameter("id_loc"));
		String quartier = request.getParameter("quartier");
		String commune = request.getParameter("ville");
		String ville = request.getParameter("descrition");
		String description = request.getParameter("description");
		Localisation localisation = new Localisation();
		localisation.setId(id);
		localisation.setCommune(commune);
		localisation.setQuartier(quartier);
		localisation.setVille(ville);
		localisation.setDescription(description);
		return localisation;
	}
	
	private void setActe(Acte acte) {
		String numeroOctroi = request.getParameter("numero-octroi");
		String numeroActe = request.getParameter("numero-acte");
		StatutActe statut = StatutActe.toStatut(request.getParameter("statut-acte"));
		LocalDate anneeOctroi = LocalDate.parse(request.getParameter("annee-octroi"));
		LocalDate anneeExpiration = LocalDate.parse(request.getParameter("annee-expiration"));
		Path acteNumerise = Paths.get(request.getParameter("acte-numerise"));
		
		acte.setNumeroOctroi(numeroOctroi);
		acte.setNumeroActe(numeroActe);
		acte.setStatut(statut);
		acte.setAnneeOctroi(anneeOctroi);
		acte.setAnneeExpiration(anneeExpiration);
		acte.setActeNumerise(acteNumerise);
	}
	
	private void setTitre(Titre titre) {
		setActe(titre);
		double superfice = Double.parseDouble(request.getParameter("superficie"));
		String localite = request.getParameter("localite");
		String region = request.getParameter("region");
		titre.setSuperficie(superfice);
		titre.setRegion(region);
		titre.setLocalite(localite);
	}
	
	public Agrement buildAgrement() {
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
	
	public PermisExploitation buildPE() {
		PermisExploitation pe = new PermisExploitation();
		setTitre(pe);
		return pe;
	}
	
	public PermisRecherche buildPR() {
		PermisRecherche pr = new PermisRecherche();
		setTitre(pr);
		int ordre = Integer.parseInt(request.getParameter("ordre"));
		pr.setOrdre(ordre);
		return pr;
	}
	
	public Prospection buildProspection() {
		Prospection prospec = new Prospection();
		setTitre(prospec);
		int ordre = Integer.parseInt(request.getParameter("ordre"));
		prospec.setOrdre(ordre);
		return prospec;
	}
	
	private void setDemande(Demande demande) {
		String cadastreId = request.getParameter("cadastre_id");
		LocalDate dateSoumission = LocalDate.parse(request.getParameter("date_soumission"));
		Path droit_fixe = Paths.get(request.getParameter("droit_fixe"));
		Path dossier_complementaire = Paths.get(request.getParameter("dossier_complementaire"));
		StatutDemande statutDemande = StatutDemande.toStatut(request.getParameter("statut_demande"));
		
		demande.setCadastreId(cadastreId);
		demande.setDateSoumission(dateSoumission);
		demande.setDroitFixe(droit_fixe);
		demande.setStatut(statutDemande);
		demande.setDossierComplementaire(dossier_complementaire);
	}
	
	private void setDemandeNouvelle(DemandeNouvelle demandeNouvelle) {
		setDemande(demandeNouvelle);
		Path lettre_demande = Paths.get(request.getParameter("lettre_demande"));
		Path rccm = Paths.get(request.getParameter("rccm"));
		demandeNouvelle.setLettreDeDemande(lettre_demande);
		demandeNouvelle.setRccm(rccm);
	}
	
	public DemandeNouvelleAgrement buildDemandeNouvelleAgrement() {
		String typeActivite = request.getParameter("type_activite");
		String numeroCC = request.getParameter("compte_contribuable");
		Path listeAutresActivites = Paths.get(request.getParameter("liste_autres_activites"));
		Path contratSoustraitance = Paths.get(request.getParameter("contract_soustraitance"));
		Path copieTitreMinier = Paths.get(request.getParameter("copieTitreMinier"));
		Path declarationSurHonneur = Paths.get(request.getParameter("declaration_honneur"));
		Path listeDePosteCategorie = Paths.get(request.getParameter("liste_postes_categories"));
		Path listePersonnel = Paths.get(request.getParameter("liste_autres_activites"));
		
		DemandeNouvelleAgrement dmdNouvAgrmt = new DemandeNouvelleAgrement();
		setDemandeNouvelle(dmdNouvAgrmt);
		dmdNouvAgrmt.setTypeActivite(typeActivite);
		dmdNouvAgrmt.setNumeroCompteContribuable(numeroCC);
		dmdNouvAgrmt.setListeAutresActivites(listeAutresActivites);
		dmdNouvAgrmt.setContratDeSousTraitance(contratSoustraitance);
		dmdNouvAgrmt.setCopietitreMinier(copieTitreMinier);
		dmdNouvAgrmt.setDeclarationSurHonneur(declarationSurHonneur);
		dmdNouvAgrmt.setListeDesPostesParCategorie(listeDePosteCategorie);
		dmdNouvAgrmt.setListePersonnel(listePersonnel);
		return dmdNouvAgrmt;
	}
	
	public DemandeNouvellePE buildDemandeNouvellePE() {
		Path rapportTravauxRecherches = Paths.get(request.getParameter("rapport_travaux_recherche"));
		Path rapportEtudeFaisabilite = Paths.get(request.getParameter("rapport_etude_faisabilite"));
		Path arreteApprobationEIES = Paths.get(request.getParameter("arrete_approbation_eies"));
		Path planFinancement = Paths.get(request.getParameter("plan_financement"));
		Path nombreEmploiCategorie = Paths.get(request.getParameter("nombre_emploi_par_categorie"));
		
		DemandeNouvellePE demandeNouvellePE = new DemandeNouvellePE();
		setDemandeNouvelle(demandeNouvellePE);
		demandeNouvellePE.setRapportDesTravauxDeRecherche(rapportTravauxRecherches);
		demandeNouvellePE.setRapportEtudeFaisabilite(rapportEtudeFaisabilite);
		demandeNouvellePE.setArreteApprobatioinEIES(arreteApprobationEIES);
		demandeNouvellePE.setPlanDeFinancement(planFinancement);
		demandeNouvellePE.setNombreEmploiParCategorie(nombreEmploiCategorie);
		
		return demandeNouvellePE;
	}
	
	public DemandeNouvellePR buildDemandeNouvellePR() {
		Path cvRT = Paths.get(request.getParameter("cv_respo_tech"));
		Path programmeGeneralDesTravaux = Paths.get(request.getParameter("prog_general_travaux"));
		Path programmeDetaille = Paths.get(request.getParameter("programme_detaille"));
		Path listeDesPostes = Paths.get(request.getParameter("liste_des_postes"));
		Path lettreDeDesignation = Paths.get(request.getParameter("lettre_de_designation"));
		Path photocopiesDiplomes = Paths.get(request.getParameter("photocopie_diplome"));
		Path experienceDemandeur = Paths.get(request.getParameter("experience_demandeur"));
		Path attestationBancaire = Paths.get(request.getParameter("attestation_bancaire"));
		Path releveBancaire = Paths.get(request.getParameter("releve_bancaire"));
		
		DemandeNouvellePR demandeNouvellePR = new DemandeNouvellePR();
		setDemandeNouvelle(demandeNouvellePR);
		
		demandeNouvellePR.setCvRT(cvRT);
		demandeNouvellePR.setProgrammeGeneralDesTravauxSurQuatreAns(programmeGeneralDesTravaux);
		demandeNouvellePR.setProgrammeDetailleDeLaPremiereAnnee(programmeDetaille);
		demandeNouvellePR.setListeDesPostesParCategorie(listeDesPostes);
		demandeNouvellePR.setLettreDeDesignationDuRT(lettreDeDesignation);
		demandeNouvellePR.setPhotocopieDesDiplomes(photocopiesDiplomes);
		demandeNouvellePR.setExperienceDuDemandeur(experienceDemandeur);
		demandeNouvellePR.setAttestationBancaire(attestationBancaire);
		demandeNouvellePR.setReleveBancaire(releveBancaire);
		return demandeNouvellePR;
	}
	
	public DemandeNouvelleProspection buildDemandeNouvelleProspection() {
		Path carteZone = Paths.get(request.getParameter("carte_zone"));
		Path programmeDeProspection = Paths.get(request.getParameter("programme_de_prospection"));
		
		DemandeNouvelleProspection demandeNouvelleProspection = new DemandeNouvelleProspection();
		setDemandeNouvelle(demandeNouvelleProspection);
		
		demandeNouvelleProspection.setCarteZone(carteZone);
		demandeNouvelleProspection.setProgrammeDePropection(programmeDeProspection);
		return demandeNouvelleProspection;
	}
	
	private void setDemandeRenouvellement(DemandeRenouvellement dr) {
		setDemande(dr);
		Path lettreDemandeRenouvellement = Paths.get(request.getParameter("lettre_demande_renouvellemet"));
		dr.setLettreDeDemandeDeRenouvellement(lettreDemandeRenouvellement);
	}
	
	public DemandeRenouvellementAgrement buildDemandeRenouvellementAgrement() {
		Path typeActivite = Paths.get(request.getParameter("type_activite"));
		Path rapportGeneral = Paths.get(request.getParameter("rapport_general_tech"));
		Path copieTitreMinier = Paths.get(request.getParameter("copie_titre_minier"));
		DemandeRenouvellementAgrement dmdRenAgrmt = new DemandeRenouvellementAgrement();
		setDemandeRenouvellement(dmdRenAgrmt);
		dmdRenAgrmt.setTypeActivite(typeActivite);
		dmdRenAgrmt.setRapportGeneralTechnFin(rapportGeneral);
		dmdRenAgrmt.setCopieTitreMinier(copieTitreMinier);
		return dmdRenAgrmt;
	}
	
	public DemandeRenouvellementPE buildDemandeRenouvellementPE() {
		Path rapportFaisabilite = Paths.get(request.getParameter("rapport_faisabilite"));
		Path planEiesActualise = Paths.get(request.getParameter("plan_eies_actualise"));
		DemandeRenouvellementPE dmdRenPE = new DemandeRenouvellementPE();
		setDemandeRenouvellement(dmdRenPE);
		dmdRenPE.setPlanEIESactualise(planEiesActualise);
		dmdRenPE.setRapportFaisabiliteTechEco(rapportFaisabilite);
		return dmdRenPE;
	}
	
	public DemandeRenouvellementPR buildDemandeRenouvellementPR() {
		Path situationCarte = Paths.get(request.getParameter("situatioin_carte"));
		Path rapportGeneral = Paths.get(request.getParameter("rapport_general"));
		Path programmeGeneralEtDetaille = Paths.get(request.getParameter("programme_general_detaille"));
		Path droitOption = Paths.get(request.getParameter("droit_option"));
		
		DemandeRenouvellementPR dmdRenPR = new DemandeRenouvellementPR();
		setDemandeRenouvellement(dmdRenPR);
		
		dmdRenPR.setSituationDeLaCarte(situationCarte);
		dmdRenPR.setRapportGeneralDesTravauxDeRecherche(rapportGeneral);
		dmdRenPR.setProgrammeGeneralEtDetailleDesTravaux(programmeGeneralEtDetaille);
		dmdRenPR.setDroitOption(droitOption);
		
		return dmdRenPR;
	}
	
	public DemandeRenouvellementProspection buildDemandeRenouvellementProspection() {
		Path rapportActivite = Paths.get(request.getParameter("rapport_activite_prospec"));
		Path programmeProspection = Paths.get(request.getParameter("programme_prospection"));
		DemandeRenouvellementProspection drp = new DemandeRenouvellementProspection();
		setDemandeRenouvellement(drp);
		drp.setRapportActiviteDeProspection(rapportActivite);
		drp.setProgrammeProspection(programmeProspection);
		return null;
	}
	
}
