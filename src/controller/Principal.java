package controller;

import vue.FenetreRechercher;
import vue.FenetrePrincipale;
import modele.Coherence;
import vue.FenetreEnregistrement;

public class Principal {
	
	Coherence maLogique;
	FenetrePrincipale maFenetrePrincipale;
	FenetreRechercher maFenetreRechercher;
	FenetreEnregistrement maFenetreEnregistrer;
	Coordinateur monCoordinateur;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Principal appliPrincipal=new Principal();
		appliPrincipal.depart();
	}

	 
	  //  Permet d'instancier toutes les classes avec le systeme 
	  
	private void depart() {
		// On instancie les classes
		maFenetrePrincipale=new FenetrePrincipale();
		maFenetreEnregistrer=new FenetreEnregistrement();
		maFenetreRechercher= new FenetreRechercher();
		maLogique=new Coherence();
		monCoordinateur= new Coordinateur();
		
		//On etablit les relations entre les classes et le coordinateur*/
		maFenetrePrincipale.setCoordinateur(monCoordinateur);
		maFenetreEnregistrer.setCoordinateur(monCoordinateur);
		maFenetreRechercher.setCoordinateur(monCoordinateur);
		maLogique.setCoordinateur(monCoordinateur); 
		
		//On etablit les relations entre le coordinateur et les classes
		monCoordinateur.setMaFenetrePrincipale(maFenetrePrincipale);
		monCoordinateur.setMaFenetreEnregistrer(maFenetreEnregistrer);
		monCoordinateur.setMaFenetreRechercher(maFenetreRechercher);
		monCoordinateur.setMaLogique(maLogique);
				
		maFenetrePrincipale.setVisible(true);
	}

}
