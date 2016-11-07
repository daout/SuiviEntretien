package modele.dataAccesObject;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import modele.conection.Connexion;
import modele.valueObject.MotoVo;

/**
 * Classe qui permet l acces a la base de donnees  table moto
 * Dans ce modele Data Access nous avons les  classes qui gèrent à niveau interne le CRUD .
 * Ici juste  la méthode enregistrer une nouvelle moto , champ annee 
 *
 */

public class MotoDao {

	public void enregisterMoto(MotoVo maMoto )
	{
		Connexion conex= new Connexion();
		// requete mysql pour enregistrer une nouvelle moto
		try {
			//SELECT MAX(cli_id) FROM client; requète permettant de retourner l'ID du client
		// ajout des champ moto
			Statement etatEnregistrerMoto = conex.getConnection().createStatement();
			etatEnregistrerMoto.executeUpdate("INSERT INTO moto (mto_Annee) VALUES ('"
					+maMoto. getAnneeMoto()+ "')");
						
			JOptionPane.showMessageDialog(null, "Enregistrement OK ","Information",JOptionPane.INFORMATION_MESSAGE);
			etatEnregistrerMoto.close();
			conex.deconnecter();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Echec enregistrement");
		}
	}

	
	
	
	
}
