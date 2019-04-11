
package taxi.metier;

import java.util.Objects;

/**
 * classe métier de gestion d'un taxi
 * @author Van Gysegem Allison
 * @version 1.0
 * 
 */



public class API_TAXI {
   /**
   * Identifiant de taxi unique
   */
   private int idtaxi;
   
   /**
   * Immatriculation du taxi
   */
   private String immatriculation;
   
   /**
   * Carburant du taxi
   */
   private String carburant;
   
   /**
   * Prix au km du taxi
   */
   private float prixkm;
   
   /**
   * Description du taxi
   */
   private String description;

   /**
    * constructeur par défaut
    */
    public API_TAXI() {
    }

    /**
    * constructeur paramétré
    * @param idtaxi identifiant unique du taxi, affecté par la base de données
    * @param immatriculation Numero d'immatriculation du taxi
    * @param carburant Carburant du taxi
    * @param prixkm Prix au km tu taxi
    * @param description Description du taxi
    */
    public API_TAXI(int idtaxi, String immatriculation, String carburant, float prixkm, String description) {
        this.idtaxi = idtaxi;
        this.immatriculation = immatriculation;
        this.carburant = carburant;
        this.prixkm = prixkm;
        this.description = description;
    }

    /**
    * getter identifiant taxi
    * @return Identifiant du taxi
    */
    public int getIdtaxi() {
        return idtaxi;
    }

    /**
     * setter identifiant taxi
     * @param idtaxi Identifiant du taxi
     */
    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
    }

    /**
    * getter immatriculation
    * @return Immatriculation du taxi
    */
    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * setter immatriculation
     * @param immatriculation Immatriculation du taxi
     */
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    /**
    * getter carburant
    * @return Carburant du taxi
    */
    public String getCarburant() {
        return carburant;
    }

    /**
     * setter carburant
     * @param carburant Carburant du taxi
     */
    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    /**
    * getter prixkm
    * @return Prix au km du taxi
    */
    public float getPrixkm() {
        return prixkm;
    }

    /**
     * setter prixkm
     * @param prixkm Prix au km du taxi
     */
    public void setPrixkm(float prixkm) {
        this.prixkm = prixkm;
    }

    /**
    * getter description
    * @return Description du taxi
    */
    public String getDescription() {
        return description;
    }

    /**
     * setter description
     * @param description Description du taxi
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
    * méthode toString
    * @return informations complètes
    */
    @Override
    public String toString() {
        return "API_TAXI{" + "idtaxi=" + idtaxi + ", immatriculation=" + immatriculation + ", carburant=" + carburant + ", prixkm=" + prixkm + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final API_TAXI other = (API_TAXI) obj;
        if (Float.floatToIntBits(this.prixkm) != Float.floatToIntBits(other.prixkm)) {
            return false;
        }
        if (!Objects.equals(this.immatriculation, other.immatriculation)) {
            return false;
        }
        if (!Objects.equals(this.carburant, other.carburant)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    
   
}
