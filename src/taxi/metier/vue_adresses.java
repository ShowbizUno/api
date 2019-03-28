
package taxi.metier;

import java.time.LocalDate;

/**
 * classe métier de gestion des locations via une vue
 * @author Van Gysegem Allison
 * @version 1.0
 * 
 */
public class vue_adresses {
    
   /**
   * Identifiant de location
   */
    private int idloc;
    
   /**
   * Date de la location
   */
    private LocalDate dateloc;
    
   /**
   * Nombre de km totaux
   */
    private int kmtotal;
    
   /**
   * Valeur de l'acompte
   */
    private float acompte;
        
   /**
   * Total à payer
   */
    private float total;
        
   /**
   * identifiant du client
   */
    private int idclient;
        
   /**
   * identifiant du taxi
   */
    private int idtaxi;
       
   /**
   * code postal aller
   */
    private int cp;
        
   /**
   * Localité aller
   */
    private String localite;
        
   /**
   * Nom de la rue aller
   */
    private String rue;
        
   /**
   * Numéro de la maison aller
   */
    private String num;
        
   /**
   * Code postal du retour
   */
    private int cp_retour;
        
   /**
   * Nom de la localité retour
   */
    private String loc_retour;
        
   /**
   * Nom de la rue retour
   */
    private String rue_retour;
        
   /**
   * Numéro de la maison retour
   */
    private String num_retour;
    
    /**
    * constructeur par défaut
    */
    public vue_adresses() {
    }
    
    /**
    * constructeur paramétré
    * @param idloc Identifiant unique de la location, affecté par la base de données
    * @param dateloc Date de la location
    * @param kmtotal Nombre de km totaux
    * @param acompte Valeur de l'acompte payé
    * @param total prix total à payer
    * @param idclient Identifiant du client
    * @param idtaxi Identifiant du taxi
    * @param cp Code postal aller
    * @param localite Nom de la localité aller
    * @param rue Nom de la rue aller
    * @param num Numéro de maison aller
    * @param cp_retour Code postal de la localité retour
    * @param loc_retour Nom de la localité retour
    * @param rue_retour Nom de la rue retour
    * @param num_retour Numéro de maison retour
    */
    public vue_adresses(int idloc, LocalDate dateloc, int kmtotal, float acompte, float total, int idclient, int idtaxi, int cp, String localite, String rue, String num, int cp_retour, String loc_retour, String rue_retour, String num_retour) {
        this.idloc = idloc;
        this.dateloc = dateloc;
        this.kmtotal = kmtotal;
        this.acompte = acompte;
        this.total = total;
        this.idclient = idclient;
        this.idtaxi = idtaxi;
        this.cp = cp;
        this.localite = localite;
        this.rue = rue;
        this.num = num;
        this.cp_retour = cp_retour;
        this.loc_retour = loc_retour;
        this.rue_retour = rue_retour;
        this.num_retour = num_retour;
    }
    
    /**
    * getter identifiant de la localité
    * @return identifiant de la localité
    */
    public int getIdloc() {
        return idloc;
    }

    /**
     * setter identifiant de la localité
     * @param idloc identifiant de la localité
     */
    public void setIdloc(int idloc) {
        this.idloc = idloc;
    }

    /**
    * getter date de la location
    * @return Date de la location
    */
    public LocalDate getDateloc() {
        return dateloc;
    }

    /**
    * setter date de la location
    * @param dateloc Date de la location
    */
    public void setDateloc(LocalDate dateloc) {
        this.dateloc = dateloc;
    }

    /**
    * getter nom de km totaux
    * @return Nombre de km totaux
    */
    public int getKmtotal() {
        return kmtotal;
    }

    /**
     * setter kmtotal
     * @param kmtotal Nombre de km totaux
     */
    public void setKmtotal(int kmtotal) {
        this.kmtotal = kmtotal;
    }

     /**
    * getter acompte
    * @return Prix de l'acompte versé
    */
    public float getAcompte() {
        return acompte;
    }

    /**
     * setter acompte
     * @param acompte Acompte payé
     */
    public void setAcompte(float acompte) {
        this.acompte = acompte;
    }

     /**
    * getter total
    * @return Total a payer
    */
    public float getTotal() {
        return total;
    }

    /**
     * setter total
     * @param total Total à payer
     */
    public void setTotal(float total) {
        this.total = total;
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
    * getter identifiant taxi
    * @return identifiant du taxi
    */
    public int getIdtaxi() {
        return idtaxi;
    }

    /**
     * setter identifiant taxi
     * @param idtaxi identifiant du taxi
     */
    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
    }

     /**
    * getter cp
    * @return Code postal de la localité aller
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
    * getter localite
    * @return Nom de la localité de l'aller
    */
    public String getLocalite() {
        return localite;
    }

    /**
     * setter localite
     * @param localite Nom de la localité aller
     */
    public void setLocalite(String localite) {
        this.localite = localite;
    }

     /**
    * getter rue
    * @return Nom de la rue de l'aller
    */
    public String getRue() {
        return rue;
    }

    /**
     * setter rue
     * @param rue Nom de la rue aller
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

     /**
    * getter num
    * @return Numéro de rue de l'aller
    */
    public String getNum() {
        return num;
    }

    /**
     * setter numero
     * @param num Numero de la localité aller
     */
    public void setNum(String num) {
        this.num = num;
    }
 /**
    * getter code postal retour
    * @return Code postal de la localité du retour
    */
    
    public int getCp_retour() {
        return cp_retour;
    }

    /**
     * setter Code postal retour
     * @param cp Code postal de la localité retour
     */
    public void setCp_retour(int cp_retour) {
        this.cp_retour = cp_retour;
    }

     /**
    * getter localité retour
    * @return Nom de la localité du retour
    */
    public String getLoc_retour() {
        return loc_retour;
    }

    /**
     * setter Localité retour
     * @param loc_retour Nom de la localité retour
     */
    public void setLoc_retour(String loc_retour) {
        this.loc_retour = loc_retour;
    }

     /**
    * getter rue retour
    * @return Nom de la rue de la localité de retour
    */
    public String getRue_retour() {
        return rue_retour;
    }

    /**
     * setter Nom de la rue retour
     * @param rue_retour nom de la rue de la localité retour
     */
    public void setRue_retour(String rue_retour) {
        this.rue_retour = rue_retour;
    }

     /**
    * getter numero retour
    * @return Numéro de maison de la localité de retour
    */
    public String getNum_retour() {
        return num_retour;
    }

    /**
     * setter Numéro retour
     * @param num_retour Numéro de la maison de la localité retour
     */
    public void setNum_retour(String num_retour) {
        this.num_retour = num_retour;
    }
    
    
}
