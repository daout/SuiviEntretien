package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Coordinateur;
import modele.Coherence;
import modele.valueObject.PersonneVo;

public class FenetreRechercher  extends JFrame implements ActionListener {

	/**
	 * fenetre recherche un client 
	 */
	private static final long serialVersionUID = 1L;
	private Coordinateur monCoordinateur; //  objet cordinateur qui permet la relation entre cette classe FenetreRecherche et le coordinateur 
	private JLabel labelTitreFenetreRechercher;
	private JTextField textCod,textNom,textPrenom,textAdresse,textCodePostal,textVille,textMail,textTelephone;
	private JLabel idClient,nom,prenom,adresse,ville,codePostal,telephone,mail;
	private JButton boutonEnregistrer,boutonAnnuler,boutonRechercher,boutonModifier,boutonEliminer;
	
	 
	 /** Constructeur de la classe : initialise tous les composants de la fenetre rechercher */ 
	  
	public FenetreRechercher() {

		boutonRechercher = new JButton();
		boutonRechercher.setBounds(170, 80, 50, 25);
		boutonRechercher.setText("Ok");
		
		boutonEnregistrer = new JButton();
		boutonEnregistrer.setBounds(50, 420, 120, 25);
		boutonEnregistrer.setText("Enregistrer");
		
		boutonAnnuler = new JButton();
		boutonAnnuler.setBounds(190, 450, 120, 25);
		boutonAnnuler.setText("Annuler");
		
		boutonEliminer = new JButton();
		boutonEliminer.setBounds(330, 420, 120, 25);
		boutonEliminer.setText("Supprimer");
		
		boutonModifier = new JButton();
		boutonModifier.setBounds(190, 420, 120, 25);
		boutonModifier.setText("Modifier");

		labelTitreFenetreRechercher = new JLabel();
		labelTitreFenetreRechercher.setText("RECHERCHE ET MODIFICATION CLIENT");
		labelTitreFenetreRechercher.setBounds(200, 20, 400, 30);
		labelTitreFenetreRechercher.setFont(new java.awt.Font("Verdana", 1, 18));

		/** positionnement des Jlabel*/
		idClient=new JLabel();
		idClient.setText("Code");
		idClient.setBounds(20, 80, 80, 25);
		add(idClient);
		
		nom=new JLabel();
		nom.setText("Nom");
		nom.setBounds(20, 120, 80, 25);
		add(nom);
		
		prenom=new JLabel();
		prenom.setText("Prenom");
		prenom.setBounds(290, 120, 80, 25);
		add(prenom);
		
		adresse=new JLabel();
		adresse.setText("Adresse");
		adresse.setBounds(20, 160, 80, 25);
		add(adresse);
		
		codePostal=new JLabel();
		codePostal.setText("Code Postal");
		codePostal.setBounds(20, 200, 80, 25);
		add(codePostal);
		
		ville=new JLabel();
		ville.setText("Ville");
		ville.setBounds(290, 200, 80, 25);
		add(ville);
		
		telephone=new JLabel();
		telephone.setText("tel ");
		telephone.setBounds(20, 240, 80, 25);
		add(telephone);
		
		mail=new JLabel();
		mail.setText("mail");
		mail.setBounds(290, 240, 80, 25);
		add(mail);
		
		/** positionnement des JtextField */
		textCod=new JTextField();
		textCod.setBounds(80, 80, 80, 25);
		add(textCod);
		
		textNom=new JTextField();
		textNom.setBounds(80, 120, 190, 25);
		add(textNom);
		
		textPrenom=new JTextField();
		textPrenom.setBounds(350, 120, 190, 25);
		add(textPrenom);

		textAdresse=new JTextField();
		textAdresse.setBounds(80, 160, 500, 25);
		add(textAdresse);
		
		textCodePostal=new JTextField();
		textCodePostal.setBounds(100, 200, 60, 25);
		add(textCodePostal);
		
		textVille=new JTextField();
		textVille.setBounds(340, 200, 190, 25);
		add(textVille);
		
		textMail=new JTextField();
		textMail.setBounds(340, 240, 190, 25);
		add(textMail);
		
		textTelephone=new JTextField();
		textTelephone.setBounds(80, 240, 190, 25);
		add(textTelephone);
		
		boutonModifier.addActionListener(this);
		boutonEliminer.addActionListener(this);
		boutonRechercher.addActionListener(this);
		boutonEnregistrer.addActionListener(this);
		boutonAnnuler.addActionListener(this);

		add(boutonAnnuler);
		add(boutonRechercher);
		add(boutonModifier);
		add(boutonEliminer);
		add(boutonEnregistrer);
		add(labelTitreFenetreRechercher);
		clean();
				
		setSize(800, 600);  /** taille pannel Rechercher client */
		setTitle("Moto Entretien  modele MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}


	public void setCoordinateur(Coordinateur monCoordinateur) {
		this.monCoordinateur=monCoordinateur;
	}


	@Override
	/**  Modification données client */
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==boutonEnregistrer)
		{
			try {
				PersonneVo monClientEnregistrer=new PersonneVo();
				monClientEnregistrer.setIdClient(Integer.parseInt(textCod.getText()));
				monClientEnregistrer.setNomPersonne(textNom.getText());
				monClientEnregistrer.setPrenomPersonne(textPrenom.getText());
				monClientEnregistrer.setAdresseClient(textAdresse.getText());
				monClientEnregistrer.setCodePostalClient(Integer.parseInt(textCodePostal.getText()));
				monClientEnregistrer.setVilleClient(textVille.getText());
				monClientEnregistrer.setTelephoneClient(Integer.parseInt(textTelephone.getText()));
				monClientEnregistrer.setMailClient(textMail.getText());

				monCoordinateur.modifierClient(monClientEnregistrer);
				
				clean();
				this.dispose();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Erreur enregistrement de donnees","Erreur",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==boutonRechercher)
		{
			PersonneVo monClient=monCoordinateur.rechercherClient(textCod.getText());
			if (monClient!=null)
			{
				montrerClient(monClient);
			}
			else if(Coherence.consultationClient==true){
				JOptionPane.showMessageDialog(null, "Le client n'existe pas","Info",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==boutonModifier)
		{
			habiliter(false, false, false, false, false, false, false, false, false, true, false, false);
			
		}
		
		if (e.getSource()==boutonEliminer)
		{
			if (!textCod.getText().equals(""))
			{
				int reponse = JOptionPane.showConfirmDialog(this,
						"Etes vous sur de vouloir supprimer ce client   ?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (reponse == JOptionPane.YES_NO_OPTION)
				{
					monCoordinateur.eliminerClient(textCod.getText());
					clean();
					this.dispose();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Entrer un numero Id ", "Information",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==boutonAnnuler)
		{
			clean();
			this.dispose();// dispose permet de liberer la fenetre 
		}

	}

	/**
	 * permet de charger les donnees de la personne consultée
	 * @param monClient
	 */
	
	private void montrerClient(PersonneVo monClient) {
		textNom.setText(monClient.getNomPersonne());
		textPrenom.setText(monClient.getPrenomPersonne());
		textAdresse.setText(monClient.getAdresseClient()+"");
		textCodePostal.setText(monClient.getCodePostalClient()+"");
		textVille.setText(monClient.getVilleClient()+"");
		textTelephone.setText(monClient.getTelephoneClient()+"");
		textMail.setText(monClient.getMailClient());
		habiliter(false, true, true, true, true, true, true, true, true, false, true, true); // Situation aprés clic sur bouton OK
		//La methode habiliter nous permet de masquer ou non des champs ou bouton
	}


	/**
	 * Raffraichissement des composants 
	 */
	public void clean()
	{
		textCod.setText("");
		textNom.setText("");
		textPrenom.setText("");
		textAdresse.setText("");
		textCodePostal.setText("");
		textVille.setText("");
		textTelephone.setText("");
		textMail.setText("");
		habiliter(true, false, false, false, false, false, false, false, true, false, false, false);
	}


	/**
	 * Permet d'habiliter les composants pour effectuer des modifications 
	 * @param codeIdClient
	 * @param nom
	 * @param adresse
	 * @param tel
	 * @param profesion
	 * @param cargo
	 * @param bRechercher
	 * @param bGarder
	 * @param bModifier
	 * @param bSupprimer
	 */
	
	
	///  methode habiliter pour rendre accessible ou nom les champs textFields de saisie
	
	public void habiliter(boolean codeIdClient, boolean nom, boolean prenom, boolean adresse, boolean codePostal, boolean ville,  boolean tel, boolean mail,
			boolean bRechercher, boolean bGarder, boolean bModifier, boolean bSupprimer)
	{
		textCod.setEditable(codeIdClient); 
		textNom.setEditable(nom);
		textPrenom.setEditable(prenom);
		textAdresse.setEditable(adresse);
		textCodePostal.setEditable(codePostal);
		textVille.setEditable(ville);
		textTelephone.setEditable(tel);
		textMail.setEditable(mail);
		boutonRechercher.setEnabled(bRechercher);
		boutonEnregistrer.setEnabled(bGarder);
		boutonModifier.setEnabled(bModifier);
		boutonEliminer.setEnabled(bSupprimer);
	}
}
