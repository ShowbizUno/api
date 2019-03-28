package taxi.DAO;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class DAO<T> {

   protected Connection dbConnect ;
	
        
   /**
   * méthode  permettant d'injecter la connexion à la DB venue de l'application principale
   * @param nouvdbConnect connexion à la base de données
   */
   public  void setConnection(Connection nouvdbConnect) {
      dbConnect=nouvdbConnect;
   }
	/**
	 * Permet de récupérer un objet via son ID
	 * @param id identifiant de l'objet recherché
	 * @return T objet trouvé
         * @throws SQLException objet non trouvé
	 */
	public abstract T read(int id)throws SQLException;
	
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj objet à créer
         * @return T objet créé
         * @throws SQLException exception de création
	 */
	public abstract T create(T obj) throws SQLException;
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj objet à mettre à jour
         * @throws SQLException exception  mise à jour
         * @return T objet mis à jour
	 */
	public abstract T update(T obj)throws SQLException;
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj objet à effacer
         * @throws SQLException exception d'effacement
	 */
	public abstract void delete(T obj) throws SQLException;
        
      
}


