
package design_patterns.metier.builder;

import java.time.LocalDate;

/**
 *
 * @author Allison
 */
public class Location{
 
  private int idloc;
 
  private int kmtotal;
 
  private float acompte;
 
  private float total;
  
  private Taxi vehicule;
  
  private Adresse adrDebut;
  
  private Adresse adrFin;
  
  private Client client;
  

    public Location() {
    }

    public Location(int idloc, int kmtotal, float acompte, float total, Taxi vehicule, Adresse adrDebut, Adresse adrFin, Client client) {
        this.idloc = idloc;
        this.kmtotal = kmtotal;
        this.acompte = acompte;
        this.total = total;
        this.vehicule = vehicule;
        this.adrDebut = adrDebut;
        this.adrFin = adrFin;
        this.client = client;
        
    }

    public int getIdloc() {
        return idloc;
    }

    public void setIdloc(int idloc) {
        this.idloc = idloc;
    }

    public int getKmtotal() {
        return kmtotal;
    }

    public void setKmtotal(int kmtotal) {
        this.kmtotal = kmtotal;
    }

    public float getAcompte() {
        return acompte;
    }

    public void setAcompte(float acompte) {
        this.acompte = acompte;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    

    public Taxi getVehicule() {
        return vehicule;
    }

    public void setVehicule(Taxi vehicule) {
        this.vehicule = vehicule;
        
    }

    public Adresse getAdrDebut() {
        return adrDebut;
    }

    public void setAdrDebut(Adresse adrDebut) {
        this.adrDebut = adrDebut;
    }

    public Adresse getAdrFin() {
        return adrFin;
    }

    public void setAdrFin(Adresse adrFin) {
        this.adrFin = adrFin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Location{" + "idloc=" + idloc + ", kmtotal=" + kmtotal + ", acompte=" + acompte + ", total=" + total + ", vehicule=" + vehicule + ", adrDebut=" + adrDebut + ", adrFin=" + adrFin + ", client=" + client + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idloc;
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
        final Location other = (Location) obj;
        if (this.idloc != other.idloc) {
            return false;
        }
        return true;
    }

  
}
