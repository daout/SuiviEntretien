package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Coordinateur;
import modele.valueObject.PersonneVo;
import modele.valueObject.MotoVo;

/**
 * @author titiandco
 *
 */
public class FenetreEnregistrement extends JFrame implements ActionListener {

	/** patron modele view pour représenter les fenêtres et interface graphique 
	 * qui permettent l'interaction entre l 'application et le client 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Coordinateur monCoordinateur;
	/** Objet monCoordinateur qui permet de
	* faire la relation entre cette classe
	* et le coordinateur
	*/
										 
	private JLabel labelTitre, labelTitreMoto;
	private JTextField textCodePostal, textVille, textPrenom, textAdresse, textTelephone, textMail, textNom;
	private JTextField textModeleMoto, textMarqueMoto, textAnneeMoto;
	private JLabel nom, prenom, adresse, codePostal, ville, telephone, mail; // JLabel CLIENT
	private JLabel modeleMoto, marqueMoto,anneeMoto; // JLabel MOTO
	private JButton boutonEnregistrer, boutonAnnuler;

	/** Constructeur ou s'initialisent tous les composants de la fenetre enregistrement
	*/
	public FenetreEnregistrement() {

		boutonEnregistrer = new JButton();
		boutonEnregistrer.setBounds(110, 500, 120, 25); // Thierry 
		boutonEnregistrer.setText("Enregistrer");

		boutonAnnuler = new JButton();
		boutonAnnuler.setBounds(250, 500, 120, 25);
		boutonAnnuler.setText("Annuler");

		/**LES JLabels CLIENTS 
		*/
		labelTitre = new JLabel();
		labelTitre.setText("ENREGISTREMENT NOUVEAU CLIENT");
		labelTitre.setBounds(245, 20, 380, 30);
		labelTitre.setFont(new java.awt.Font("Verdana", 1, 18));

		nom = new JLabel();
		nom.setText("Nom");
		nom.setBounds(20, 80, 80, 25);
		add(nom);
		
		prenom = new JLabel();
		prenom.setText("Prenom");
		prenom.setBounds(310, 80, 80, 25);
		add(prenom);

		adresse = new JLabel();
		adresse.setText("Adresse");
		adresse.setBounds(20, 120, 80, 25);
		add(adresse);
		
		codePostal = new JLabel();
		codePostal.setText("Code postal");
		codePostal.setBounds(20, 160, 80, 25);
		add(codePostal);

		ville = new JLabel();
		ville.setText("Ville");
		ville.setBounds(310, 160, 80, 25);
		add(ville);
		
		telephone = new JLabel();
		telephone.setText("tel ");
		telephone.setBounds(20, 200, 80, 25);
		add(telephone);
		
		mail = new JLabel();
		mail.setText("mail ");
		mail.setBounds(310, 200, 80, 25); 
		add(mail);
		
		labelTitreMoto = new JLabel();
		labelTitreMoto.setText("SAISIE CARACTERISTIQUES MOTO CLIENT");
		labelTitreMoto.setBounds(200, 280, 450, 30);
		labelTitreMoto.setFont(new java.awt.Font("Verdana", 1, 18));

		 /** JLabels MOTO  
		*/
		marqueMoto = new JLabel();
		marqueMoto.setText("Marque");
		marqueMoto.setBounds(20, 320, 80, 25);
		add(marqueMoto);
		
		modeleMoto = new JLabel();
		modeleMoto.setText("Modele");
		modeleMoto.setBounds(220, 320, 80, 25);
		add(modeleMoto);
		
		anneeMoto = new JLabel();
		anneeMoto.setText("Annee de mise en circulation");
		anneeMoto.setBounds(420, 320, 180, 25);
		add(anneeMoto);
		
		/** LES JTextFields CLIENTS///
		*/
		textNom = new JTextField();  
		textNom.setBounds(100, 80, 190, 25);
		add(textNom);
		
		textPrenom = new JTextField();
		textPrenom.setBounds(370, 80, 190, 25);
		add(textPrenom);
		
		textAdresse = new JTextField();
		textAdresse.setBounds(100, 120, 500, 25);
		add(textAdresse);
		
		textCodePostal = new JTextField(); 
		textCodePostal.setBounds(100, 160, 60, 25);
		add(textCodePostal);
		
		textVille = new JTextField(); 
		textVille.setBounds(360, 160, 190, 25);
		add(textVille);

		textTelephone = new JTextField();
		textTelephone.setBounds(100, 200, 80, 25);
		add(textTelephone);

		textMail = new JTextField();
		textMail.setBounds(360, 200, 220, 25);
		add(textMail);

		/** JTextField pour MOTO */
		
		textMarqueMoto = new JTextField();
		textMarqueMoto.setBounds(100, 320, 80, 25);
		add(textMarqueMoto);
		
		textModeleMoto = new JTextField();
		textModeleMoto.setBounds(280, 320, 80, 25);
		add(textModeleMoto);
		
		textAnneeMoto = new JTextField();
		textAnneeMoto.setBounds(600, 320, 60, 25);
		add(textAnneeMoto);
		
		boutonEnregistrer.addActionListener(this);
		boutonAnnuler.addActionListener(this);
		add(boutonAnnuler);
		add(boutonEnregistrer);
		add(labelTitre);
		add(labelTitreMoto);
		clean();
		setSize(800, 600);
		setTitle("Moto Entretien  essai  MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}

	private void clean() {
		/**textPrenom.setText("");
		textNom.setText(""); 
		textAdresse.setText("");
		textCodePostal.setText("");
		textVille.setText("");
		textTelephone.setText("");
		textMail.setText("");
		textMarqueMoto.setText("");
		textModeleMoto.setText("");
		textAnneeMoto.setText("");*/
		
		 /** Préremplissage des zones écran pour test de l'appli */
		textPrenom.setText("René");
		textNom.setText("Kalou"); 
		textAdresse.setText("25 rue des bois");
		textCodePostal.setText("34000");
		textVille.setText("Montpellier");
		textTelephone.setText("0467010203");
		textMail.setText("r.kalou@orange.fr");
		textMarqueMoto.setText("Kawasaki");
		textModeleMoto.setText("ER6");
		textAnneeMoto.setText("2010");
	}

	public void setCoordinateur(Coordinateur monCoordinateur) {
		this.monCoordinateur = monCoordinateur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonEnregistrer) {
			try {
				PersonneVo monNouveauClient = new PersonneVo();  /** on instancie un nouvel objet de type PersonneVo */ 
				
				monNouveauClient.setNomPersonne(textNom.getText());
				monNouveauClient.setPrenomPersonne(textPrenom.getText());
				monNouveauClient.setAdresseClient(textAdresse.getText());
				monNouveauClient.setCodePostalClient(Integer.parseInt(textCodePostal.getText()));
				monNouveauClient.setVilleClient(textVille.getText());
				monNouveauClient.setTelephoneClient(Integer.parseInt(textTelephone.getText()));
				monNouveauClient.setMailClient(textMail.getText());
				
				monCoordinateur.enregistrerNouveauClient(monNouveauClient);
				
				/**On recupere les JTextField de la moto nouveau Client */
				
				MotoVo maNouvelleMoto = new MotoVo();
				
				maNouvelleMoto.setMarqueMoto(textMarqueMoto.getText());
				maNouvelleMoto.setModeleMoto(textModeleMoto.getText());
				maNouvelleMoto.setAnneeMoto(Integer.parseInt(textAnneeMoto.getText()));
				
				monCoordinateur.enregistrerNouvelleMoto(maNouvelleMoto);
				this.dispose();
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erreur d'enregistrement de donnees", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == boutonAnnuler) {
			this.dispose();
		}
	}

}
