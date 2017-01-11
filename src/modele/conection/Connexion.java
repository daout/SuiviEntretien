package modele.conection;

import java.sql.*;



/**Classe  pour se connecter à  la base de donnees mySql
 * Si dans le futur on doit changer de base de  données , on aura juste à modifier cette classe pour l'adapter 
 * à une autre classe .
 */

 
public class Connexion 

{
   static String bd = "suivientretien";  /// nom de la base de données
   static String login = "root";
   static String password = "";
   static String url = "jdbc:mysql://localhost/"+bd;

   Connection conn = null;


   
   /**
 *      Constructor de DbConnection 
 */
public Connexion() {
      try
      {
         // Obtention du driver pour mysql 
         Class.forName("com.mysql.jdbc.Driver");
         
         // Obtention de la connection
         conn = DriverManager.getConnection(url,login,password);

         if (conn!=null)
         {
            System.out.println("Connection à  la bases de  données "+bd+" OK");
         }
      }
      
      catch(SQLException e)
      {
         System.out.println(e);
      }
      
      catch(ClassNotFoundException e)
      
      {
         System.out.println(e);
      }
      catch(Exception e)
      
      {
         System.out.println(e);
      }
   }
   
  /** Permet de  retourner la connection*/


   public Connection getConnection(){
      return conn;
   }

   public void deconnecter(){
      conn = null;
   }

}