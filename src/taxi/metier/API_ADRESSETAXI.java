
package taxi.metier;

/**
 * classe métier de gestion de l'adresse d'un client
 * @author Van Gysegem Allison
 * @version 1.0
 * 
 */

public class API_ADRESSETAXI {
   /**
   * Identifiant d'adresse unique
   */
    private int idadr;
    
   /**
   * Code postal de la localité
   */
    private int cp;
    
   /**
   * Nom de la localité
   */
    private String localite;
    
   /**
   * Nom de la rue
   */
    private String rue;
    
   /**
   * Numéro de maison de la rue concernée
   */
    private String num;
    
    /**
     * constructeur par défaut
    */
    public API_ADRESSETAXI(){
        
    }
    
    /**
     * constructeur paramétré
     * @param idadr Identifiant unique de l'adresse, affectée par la base de données
     * @param cp Code postal de la localité
     * @param localite Nom de la localité
     * @param rue Nom de la rue
     * @param num Numéro de la maison dans la rue concernée
     */
    public API_ADRESSETAXI(int idadr, int cp, String localite, String rue, String num) {
        this.idadr = idadr;
        this.cp = cp;
        this.localite = localite;
        this.rue = rue;
        this.num = num;
    }
    
    /**
    * getter idadr
    * @return identifiant de l'adresse
    */
    public int getIdadr() {
        return idadr;
    }
    
    /**
     * setter idadr
     * @param idadr identifiant de l'adresse
     */
    public void setIdadr(int idadr) {
        this.idadr = idadr;
    }

    /**
    * getter Code postal
    * @return Code postal de la localité
    */
    public int getCp() {
        return cp;
    }
    
    /**
     * setter code postal
     * @param cp Code postal de la localité
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
    * getter Nom de la localité
    * @return Nom de la localité
    */
    public String getLocalite() {
        return localite;
    }

    /**
     * setter localité
     * @param localite Nom de la localité
     */
    public void setLocalite(String localite) {
        this.localite = localite;
    }

    /**
    * getter Nom de rue
    * @return identifiant de l'adresse
    */
    public String getRue() {
        return rue;
    }

    /**
     * setter nom de rue
     * @param rue Nom de la rue
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
    * getter Numéro de maison
    * @return Numéro de la maison
    */
    public String getNum() {
        return num;
    }

    /**
     * setter numéro de maison
     * @param num Numéro de la maison
     */
    public void setNum(String num) {
        this.num = num;
    }
    
    /**
     * méthode toString
     * @return informations complètes
     */
    @Override
    public String toString() {
        return "API_ADRESSETAXI{" + "idadr=" + idadr + ", cp=" + cp + ", localite=" + localite + ", rue=" + rue + ", num=" + num + '}';
    }
    
}
