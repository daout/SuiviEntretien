package modele;

import javax.swing.JOptionPane;

import controller.Coordinateur;
import modele.dataAccesObject.MotoDao;
import modele.dataAccesObject.PersonneDao;
import modele.valueObject.MotoVo;
import modele.valueObject.PersonneVo;

public class Coherence {
	
	private Coordinateur monCoordinateur;
	public static boolean consultationClient=false;
	public static boolean modificationCLient=false;
	
	public void setCoordinateur(Coordinateur monCoordinateur) {
		this.monCoordinateur=monCoordinateur;
		
		
	}

	/** Dans cette classe cohérence on va rassembler les méthodes en relation avec la logique du systéme 
	* comme tel ( validation, appels aux opérations Create Read Update Delete ). */ 
	
	
	
	public void validerEnregistrementClient(PersonneVo monClient) 
	{
		PersonneDao monClientDaoEnregistrementClient;
		
		if (monClient.getNomPersonne().length()<2) {
			JOptionPane.showMessageDialog(null,"Le nom du client doit comporter au moins 2 lettres","Infos",JOptionPane.WARNING_MESSAGE);
		}
		else {
			monClientDaoEnregistrementClient = new PersonneDao();
			monClientDaoEnregistrementClient.enregisterClient(monClient);	
		}
	}
	
	public void validerNouvelleMoto(MotoVo maMoto)
	{
		MotoDao maMotoDaoEnregistrementMoto;
		
		maMotoDaoEnregistrementMoto = new MotoDao();
		maMotoDaoEnregistrementMoto.enregisterMoto(maMoto);
	}
	
    /** methode test lors d'une recherche client par la saisie idClient ,
	* l'id doit être superieur à zero et doit etre numerique 
	*/
	
	public PersonneVo validerRechercheClient(String idClient) {
		PersonneDao monCLientDaoRechercheClient;
		
		try {
			int codeId=Integer.parseInt(idClient);	
			if (codeId > 0) {
				monCLientDaoRechercheClient = new PersonneDao();
				consultationClient=true;
				return monCLientDaoRechercheClient.rechercherPersonne(codeId);						
			}else{
				JOptionPane.showMessageDialog(null,"L'Id du client doit être superieur a 0","Avis ",JOptionPane.WARNING_MESSAGE);
				consultationClient=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Entrez une valeur numerique ","Erreur",JOptionPane.ERROR_MESSAGE);
			consultationClient=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erreur générée","Erreur",JOptionPane.ERROR_MESSAGE);
			consultationClient=false;
		}
					
		return null;
	}
    /**  autre exemple de validation avant la modification de champs client */
	
	public void validerModification(PersonneVo monCLient) {
		PersonneDao monCLientDaoModificationClient;
		if (monCLient.getNomPersonne().length()>2) {
			monCLientDaoModificationClient = new PersonneDao();
			monCLientDaoModificationClient.modifierClient(monCLient);	
			modificationCLient=true;
		}else{
			JOptionPane.showMessageDialog(null,"Le nom du client doit comporter au moins 2 lettres","Infos",JOptionPane.WARNING_MESSAGE);
			modificationCLient=false;
		}
	}

	public void validerElimination(String codeId) {
		PersonneDao monCLientElimination=new PersonneDao();
		monCLientElimination.eliminarPersona(codeId);
	}



}
