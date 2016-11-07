package modele.valueObject;



/** application du patron value object où l'on représente les entité de la future table Client avec se s
/// futurs champs ( id, nom. prénom . . . .) 
/// Plain Old Java Object
*/
public class PersonneVo {
	
	private Integer idClient;
	private String nomClient;
	private String prenomClient;
	private String adresseClient;
	private Integer codePostalClient;
	private String villeClient;
	private Integer telephoneClient;
	private String mailClient;
	
	public Integer getIdClient() {
		return idClient;
	}
	public void setIdClient(Integer idCLient) {
		this.idClient = idCLient;
	}
	
	public String getNomPersonne() {
		return nomClient;
	}
	
	public void setNomPersonne(String nomClient) {
		this.nomClient = nomClient;
	}
	
	public String getPrenomPersonne() {
		return prenomClient;
	}
	
	public void setPrenomPersonne(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	
	
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	public Integer getCodePostalClient() {
		return codePostalClient;
	}
	public void setCodePostalClient(Integer codePostalClient) {
		this.codePostalClient = codePostalClient;
	}
	public String getVilleClient() {
		return villeClient;
	}
	public void setVilleClient(String villeClient) {
		this.villeClient = villeClient;
	}
	public String getMailClient() {
		return mailClient;
	}
	public void setMailClient(String mailClient) {
		this.mailClient = mailClient;
	}
	public Integer getTelephoneClient() {
		return telephoneClient;
	}
	
	public void setTelephoneClient(Integer telephoneClient) {
		this.telephoneClient = telephoneClient;
	}
	

}
