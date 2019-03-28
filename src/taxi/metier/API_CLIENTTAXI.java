
package taxi.metier;

/**
 * classe métier de gestion d'un client
 * @author Van Gysegem Allison
 * @version 1.0
 * 
 */


public class API_CLIENTTAXI {
   /**
   * Identifiant de client unique
   */
    private int idclient;
    
   /**
   * Nom du client
   */
    private String nom;
    
   /**
   * Prénom du client
   */
    private String prenom;
    
   /**
   * Numéro de téléphone du client
   */
    private String tel;
    
   /**
   * Identifiant de l'adresse du client
   */
    private int idadr;
    
    /**
    * constructeur par défaut
    */
    public API_CLIENTTAXI() {
    }

    /**
    * constructeur paramétré
    * @param idclient identifiant unique du client, affecté par la base de données
    * @param nom nom du client
    * @param prenom prénom du client
    * @param tel numéro de téléphone du client
    * @param idadr identifiant unique de l'adresse du client
    */
    public API_CLIENTTAXI(int idclient, String nom, String prenom, String tel, int idadr) {
        this.idclient = idclient;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.idadr = idadr;
    }

    /**
    * getter identifiant client
    * @return identifiant du client
    */
    public int getIdclient() {
        return idclient;
    }

    /**
     * setter identifiant client
     * @param idclient identifiant du client
     */
    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    /**
    * getter nom
    * @return Nom du client
    */
    public String getNom() {
        return nom;
    }

    /**
     * setter nom
     * @param nom Nom du client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
    * getter prenom
    * @return Prénom du client
    */
    public String getPrenom() {
        return prenom;
    }

    /**
     * setter prenom
     * @param prenom Prénom du client
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
    * getter tel
    * @return Numéro de téléphone du client
    */
    public String getTel() {
        return tel;
    }

    /**
     * setter tel
     * @param tel Numéro de téléphone du client
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
    * getter identifiant adresse
    * @return Identifiant de l'adresse du client
    */
    public int getIdadr() {
        return idadr;
    }

    /**
     * setter identifiant adresse
     * @param idadr Identifiant de l'adresse du client
     */
    public void setIdadr(int idadr) {
        this.idadr = idadr;
    }

   /**
    * méthode toString
    * @return informations complètes
    */
    @Override
    public String toString() {
        return "API_CLIENTTAXI{" + "idclient=" + idclient + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", idadr=" + idadr + '}';
    }
    
}
