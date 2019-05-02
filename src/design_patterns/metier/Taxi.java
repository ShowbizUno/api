
package design_patterns.metier;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Allison
 */
public class Taxi {
 
   private int idtaxi;
 
   private String immatriculation;
  
   private String carburant;
 
   private float prixkm;
  
   private String description;

   private Set<Location> location=new HashSet<>();

   
    public Taxi() {
    }

    public Taxi(int idtaxi, String immatriculation, String carburant, float prixkm, String description) {
        this.idtaxi = idtaxi;
        this.immatriculation = immatriculation;
        this.carburant = carburant;
        this.prixkm = prixkm;
        this.description = description;
    }

    public int getIdtaxi() {
        return idtaxi;
    }

    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public float getPrixkm() {
        return prixkm;
    }

    public void setPrixkm(float prixkm) {
        this.prixkm = prixkm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Location> getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Taxi{" + "idtaxi=" + idtaxi + ", immatriculation=" + immatriculation + ", carburant=" + carburant + ", prixkm=" + prixkm + ", description=" + description + ", location=" + location + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.immatriculation);
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
        final Taxi other = (Taxi) obj;
        if (!Objects.equals(this.immatriculation, other.immatriculation)) {
            return false;
        }
        return true;
    }
   
    
   
}
