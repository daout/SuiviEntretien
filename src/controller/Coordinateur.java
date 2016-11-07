package controller;

import modele.Coherence;
import modele.dataAccesObject.PersonneDao;
import modele.valueObject.MotoVo;
import modele.valueObject.PersonneVo;
import vue.FenetreRechercher;
import vue.FenetrePrincipale;
import vue.FenetreEnregistrement;
/** classe en charge de mettre en relation et coordonner les classes du MVC */


public class Coordinateur {

	private Coherence logique;
	private FenetrePrincipale maFenetrePricipale;
	private FenetreEnregistrement maFenetreSaisieClient;
	private FenetreRechercher maFenetreRechercheClient;
	
	public FenetrePrincipale getMaFenetrePrincipale() {
		return maFenetrePricipale;
	}
	public void setMaFenetrePrincipale(FenetrePrincipale maFenetrePrincipale) {
		this.maFenetrePricipale = maFenetrePrincipale;
	}
	public FenetreEnregistrement getMaFenetreEnregistrer() {
		return maFenetreSaisieClient;
	}
	public void setMaFenetreEnregistrer(FenetreEnregistrement maFenetreEnregistrer) {
		this.maFenetreSaisieClient = maFenetreEnregistrer;
	}
	public FenetreRechercher getMaFenetreRechercher() {
		return maFenetreRechercheClient;
	}
	public void setMaFenetreRechercher(FenetreRechercher maFenetreRechercher) {
		this.maFenetreRechercheClient = maFenetreRechercher;
	}
	public Coherence getMaLogique() {
		return logique;
	}
	public void setMaLogique(Coherence maLogique) {
		this.logique = maLogique;
	}
	
 
	/**methode suite aux actions sur les boutons rechercher, enregistrer, eliminer . . . ////
	*/
	public void montrerFenetreSaisie() {
		maFenetreSaisieClient.setVisible(true);
	}
	public void montrerFenetreRecherche() {
		maFenetreRechercheClient.setVisible(true);
	}
	
	public void enregistrerNouveauClient(PersonneVo monClient) {
		logique.validerEnregistrementClient(monClient);
	}
	
	public void enregistrerNouvelleMoto(MotoVo maMoto) {
		logique.validerNouvelleMoto(maMoto);
	}
	
	
	public PersonneVo rechercherClient(String idClient) {
		return logique.validerRechercheClient(idClient);
	}
	
	public void modifierClient(PersonneVo monCLient) {
		logique.validerModification(monCLient);
	}
	public void eliminerClient(String idCLient) {
		logique.validerElimination(idCLient);
	}
	/** public void afficherInventaireClient() */

}
