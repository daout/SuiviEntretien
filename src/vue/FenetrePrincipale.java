package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controller.Coordinateur;

public class FenetrePrincipale extends JFrame implements ActionListener{
	
	/**
	 * Fenetre pricipale
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Coordinateur monCoordinateur; // objet coordinateur qui permet la relation entre cette classe Fenetre Principale et le coordinateur 
	private JTextArea areaIntroduction;
	private JLabel labelTitre, labelChoix;
	private JButton boutonEnregistrer,boutonRechercher,boutonInventaireClient;
	

	/**
	 * Etablit l information qui apparait dans le textArea de la fenetre principale 
	 */
	public String texteIntroduction = "";

     /** Constructeur de la classe : initialise tous les composant de la fenetre principale */
	 
	public FenetrePrincipale() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		boutonEnregistrer = new JButton();
		boutonEnregistrer.setBounds(100, 280, 220, 55);
		boutonEnregistrer.setText("Enregistrer Client nouveau ");
		
		boutonRechercher = new JButton();
		boutonRechercher.setBounds(330, 280, 180, 55);
		boutonRechercher.setText("Rechercher client ");

		boutonInventaireClient = new JButton();
		boutonInventaireClient.setBounds(520, 280, 200, 55);
		boutonInventaireClient.setText("Inventaire Clients");
		
		
		
		labelTitre = new JLabel();
		labelTitre.setText("Logiciel Moto Entretien et maintenance");
		labelTitre.setBounds(60, 40, 380, 30);
		labelTitre.setFont(new java.awt.Font("Verdana", 1, 15));

		labelChoix = new JLabel();
		labelChoix.setText("Faite votre choix :"); // affectation d un texte a labelSeleccion 
 		labelChoix.setBounds(370, 240, 250, 25);

		texteIntroduction = "Logiciel permettant de gérer la maintenance , le suivi et l'entetien d'une moto "
				+ "\n"
				+ "L'application permet :\n d'enregistrer, \n actualiser,\n chercher \n eliminer \n les champs d'une table ." +
				"\n";

		areaIntroduction = new JTextArea();
		areaIntroduction.setBounds(50, 90, 700, 140);  // (marge G,hauteur,Largeur Area,HauteurArea)
		areaIntroduction.setEditable(false);
		areaIntroduction.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduction.setLineWrap(true);
		areaIntroduction.setText(texteIntroduction);
		areaIntroduction.setWrapStyleWord(true);
		areaIntroduction.setBorder(javax.swing.BorderFactory.createBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null, null, null,
				new java.awt.Color(0, 0, 0)));

		boutonEnregistrer.addActionListener(this);
		boutonRechercher.addActionListener(this);
		add(boutonRechercher);add(boutonEnregistrer);add(boutonInventaireClient);
		
		add(labelChoix);
		add(labelTitre);
		add(areaIntroduction);
	
		setSize(800, 600);   // definition de la taille de la fenetre principale
		setTitle("Moto Entretien");
		setLocationRelativeTo(null);   // position centrée
		setResizable(false);   // taille non modifiable 
		setLayout(null);

	}

  /** le coordinateur que j ai cree va rester dans ma fenetre principale 
	  relation entre cette fenetre et le coordinateur 
	*/
	
	public void setCoordinateur(Coordinateur monCoordinateur) {
		this.monCoordinateur=monCoordinateur;
	}


	/// on récupère la réponse à l'action du bouton enregistrer , rechercher . . . 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==boutonEnregistrer) {
			monCoordinateur.montrerFenetreSaisie();			
		}
		if (e.getSource()==boutonRechercher) {
			monCoordinateur.montrerFenetreRecherche();			
		}
        //if (e.getSource()==boutonInventaireClient){
        	//monCoordinateur.
        //}
	
	
	}
}
