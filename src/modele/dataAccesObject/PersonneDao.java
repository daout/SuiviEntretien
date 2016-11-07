package modele.dataAccesObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import modele.conection.Connexion;
import modele.valueObject.PersonneVo;




/**
 * Classe qui permet l acces � la base de donnees 
 * On va centraliser les processus d'acces à la base de données . On sépare ainsi la logique de negoce 
 * de la logique d'accès à la BD. + organisation , + flexibilité dans le système 
 *
 */
public class PersonneDao
{

	
	  public void afficherToutLesclients() 
	  
	  {
			Connexion conex= new Connexion();
			/**requete mysql pour afficher tous les clients */ 
			try {
				Statement inventaireClient = conex.getConnection().createStatement();
				inventaireClient.executeUpdate("SELECT * FROM `client`");
			}
	
			catch (SQLException e) {
	            System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(null, "Echec enregistrement");
			}
			
	  }
	
	public void enregisterClient(PersonneVo monClient )
	{
		Connexion conex= new Connexion();
		/**requete mysql pour enregistrer un nouveau client */
		try {
			Statement etatEnregistrerClient = conex.getConnection().createStatement();
			
			etatEnregistrerClient.executeUpdate("INSERT INTO client (cli_nom,cli_prenom,cli_adresse,cli_code_postal,cli_ville,cli_telephone,cli_mail) VALUES ('"
					+monClient.getNomPersonne()+"', '"
					+monClient.getPrenomPersonne()+"', '"
					+monClient.getAdresseClient()+"', '"
					+monClient.getCodePostalClient()+"', '"
					+monClient.getVilleClient()+"', '"
					+monClient.getTelephoneClient()+"', '"
					+monClient.getMailClient()+"')");
			
			JOptionPane.showMessageDialog(null, "Enregistrement OK ","Information",JOptionPane.INFORMATION_MESSAGE);
			etatEnregistrerClient.close();
			conex.deconnecter();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Echec enregistrement");
		}
	}
	
	/**  connection BD pour rechercher un client */ 
	public PersonneVo rechercherPersonne(int codeId) 
	{
		Connexion conex= new Connexion();
		PersonneVo client= new PersonneVo();
		boolean existe=false;
		try {
			PreparedStatement rechercheClient = conex.getConnection().prepareStatement("SELECT * FROM client where cli_id = ? ");
			rechercheClient.setInt(1, codeId);
			ResultSet res = rechercheClient.executeQuery();
			while(res.next()){
				existe=true;
				client.setNomPersonne(res.getString("cli_nom"));
				client.setPrenomPersonne(res.getString("cli_prenom"));
				client.setAdresseClient(res.getString("cli_adresse"));
				client.setCodePostalClient(Integer.parseInt(res.getString("cli_code_postal")));
				client.setVilleClient(res.getString("cli_ville"));
				client.setTelephoneClient(Integer.parseInt(res.getString("cli_telephone")));
				client.setMailClient(res.getString("cli_mail"));
			}
			res.close();
			conex.deconnecter();
					
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erreur, pas de connection");
					System.out.println(e);
			}
		
			if (existe) {
				return client;
			}
			else return null;				
	}

	
	/** connection BD pour modifier un client */ 
	public void modifierClient(PersonneVo monCLient) {
		
		Connexion conex= new Connexion();
		try{
			String consultation="UPDATE client SET cli_id= ?,cli_nom = ?,cli_prenom = ?,cli_adresse=?,cli_code_postal=?,"
					+ "cli_ville= ?,cli_telephone= ?, cli_mail= ? WHERE cli_id= ? ";
			PreparedStatement etatModifierClient = conex.getConnection().prepareStatement(consultation);
			
            etatModifierClient.setInt(1, monCLient.getIdClient());
            etatModifierClient.setString(2, monCLient.getNomPersonne());
            etatModifierClient.setString(3, monCLient.getPrenomPersonne());
            etatModifierClient.setString(4, monCLient.getAdresseClient());
            etatModifierClient.setInt(5,monCLient.getCodePostalClient());
            etatModifierClient.setString(6, monCLient.getVilleClient());
            etatModifierClient.setInt(7,monCLient.getTelephoneClient());
            etatModifierClient.setString(8, monCLient.getMailClient());
            etatModifierClient.setInt(9, monCLient.getIdClient());
            etatModifierClient.executeUpdate();

          JOptionPane.showMessageDialog(null, " Modification Client  OK  ","Confirmation",JOptionPane.INFORMATION_MESSAGE);
         
        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erreur de modification","Erreur",JOptionPane.ERROR_MESSAGE);

        }
	}

	
	/** connection BD pour supprimer un client */ 
	public void eliminarPersona(String codeId)
	{
		Connexion conex= new Connexion();
		try {
			Statement etatEliminerClient = conex.getConnection().createStatement();
			etatEliminerClient.executeUpdate("DELETE FROM client WHERE cli_id='"+codeId+"'");
            JOptionPane.showMessageDialog(null, " Elimination OK ","Information",JOptionPane.INFORMATION_MESSAGE);
			etatEliminerClient.close();
			conex.deconnecter();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Echec elimination ");
		}
	}

}
