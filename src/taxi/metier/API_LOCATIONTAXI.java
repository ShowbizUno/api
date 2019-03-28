
package taxi.metier;
import java.time.LocalDate;

/**
 * classe métier de gestion de la location d'un taxi
 * @author Van Gysegem Allison
 * @version 1.0
 * 
 */

        
public class API_LOCATIONTAXI {
   /**
   * Identifiant de location unique
   */
  private int idloc;
  
  /**
   * Date de la location
   */
  private LocalDate dateloc;
  
  /**
   * Nombre de kilomètres totaux
   */
  private int kmtotal;
  
  /**
   * Montant de l'acompte versé
   */
  private float acompte;
  
  /**
   * Prix total
   */
  private float total;
  
  /**
   * Identifiant de l'adresse de début
   */
  private int adrdebut;
  
  /**
   * Identifiant de l'adresse de fin
   */
  private int adrfin;
  
   /**
   * Identifiant du client
   */
  private int idclient;
  
   /**
   * Identifiant du taxi
   */
  private int idtaxi;

    /**
    * constructeur par défaut
    */
    public API_LOCATIONTAXI() {
    }

    /**
    * constructeur paramétré
    * @param idloc identifiant unique de la location, affecté par la base de données
    * @param dateloc Date de la location
    * @param kmtotal Nombre de kilomètres totaux
    * @param acompte Acompte versé
    * @param total Prix total à payer
    * @param adrdebut Identifiant de l'adresse de début
    * @param adrfin Identifiant de l'adresse de fin
    * @param idclient Identifiant unique du client
    * @param idtaxi Identifiant unique du taxi
    */
    public API_LOCATIONTAXI(int idloc, LocalDate dateloc, int kmtotal, float acompte, float total, int adrdebut, int adrfin, int idclient, int idtaxi) {
        this.idloc = idloc;
        this.dateloc = dateloc;
        this.kmtotal = kmtotal;
        this.acompte = acompte;
        this.total = total;
        this.adrdebut = adrdebut;
        this.adrfin = adrfin;
        this.idclient = idclient;
        this.idtaxi = idtaxi;
    }

    /**
    * getter idloc
    * @return Identifiant de la location du taxi
    */
    public int getIdloc() {
        return idloc;
    }

    /**
     * setter idloc
     * @param idloc Identifiant de la location du taxi
     */
    public void setIdloc(int idloc) {
        this.idloc = idloc;
    }

    /**
    * getter dateLoc
    * @return Date de la location du taxi
    */
    public LocalDate getDateloc() {
        return dateloc;
    }

    /**
     * setter dateloc
     * @param dateloc Date de la location du taxi
     */
    public void setDateloc(LocalDate dateloc) {
        this.dateloc = dateloc;
    }
    
    /**
    * getter kmtotal
    * @return Nombre de km totaux a effectuer
    */
    public int getKmtotal() {
        return kmtotal;
    }

    /**
     * setter kmtotal
     * @param kmtotal Nombre de km totaux à effectuer
     */
    public void setKmtotal(int kmtotal) {
        this.kmtotal = kmtotal;
    }

    /**
    * getter acompte
    * @return Montant de l'acompte
    */
    public float getAcompte() {
        return acompte;
    }

    /**
     * setter acompte
     * @param acompte Montant de l'acompte
     */
    public void setAcompte(float acompte) {
        this.acompte = acompte;
    }

    /**
    * getter total
    * @return Montant total à payer
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
    * getter adrdebut
    * @return Identifiant de l'adresse de début
    */
    public int getAdrdebut() {
        return adrdebut;
    }

    /**
     * setter adrdebut
     * @param adrdebut Identifiant de l'adresse de début
     */
    public void setAdrdebut(int adrdebut) {
        this.adrdebut = adrdebut;
    }

    /**
    * getter adrfin
    * @return Identifiant de l'adresse de fin
    */
    public int getAdrfin() {
        return adrfin;
    }

    /**
     * setter adrfin
     * @param adrfin Identifiant de l'adresse de fin
     */
    public void setAdrfin(int adrfin) {
        this.adrfin = adrfin;
    }

    /**
    * getter idclient
    * @return Identitfiant du client
    */
    public int getIdclient() {
        return idclient;
    }

    /**
     * setter idclient
     * @param idclient Identifiant du client
     */
    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    /**
    * getter idtaxi
    * @return Identitfiant du taxi
    */
    public int getIdtaxi() {
        return idtaxi;
    }

    /**
     * setter idtaxi
     * @param idtaxi Identifiant du taxi
     */
    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
    }

    /**
    * méthode toString
    * @return informations complètes
    */
    @Override
    public String toString() {
        return "API_LOCATIONTAXI{" + "idloc=" + idloc + ", dateloc=" + dateloc + ", kmtotal=" + kmtotal + ", acompte=" + acompte + ", total=" + total + ", adrdebut=" + adrdebut + ", adrfin=" + adrfin + ", idclient=" + idclient + ", idtaxi=" + idtaxi + '}';
    }


}