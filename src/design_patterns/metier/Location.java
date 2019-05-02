
package design_patterns.metier;

import java.time.LocalDate;

/**
 *
 * @author Allison
 */
public class Location {
 
  private int idloc;
  
  private LocalDate dateloc;
 
  private int kmtotal;
 
  private float acompte;
 
  private float total;
 
  private int adrdebut;
 
  private int adrfin;
 
  private int idclient;
 
  private int idtaxi;
  
  private Taxi vehicule;
  
  private Adresse adrDebut;
  
  private Adresse adrFin;
  
  private Client client;
  

    public Location() {
    }

    public Location(int idloc, LocalDate dateloc, int kmtotal, float acompte, float total, int adrdebut, int adrfin, int idclient, int idtaxi) {
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

    public int getIdloc() {
        return idloc;
    }

    public void setIdloc(int idloc) {
        this.idloc = idloc;
    }

    public LocalDate getDateloc() {
        return dateloc;
    }

    public void setDateloc(LocalDate dateloc) {
        this.dateloc = dateloc;
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

    public int getAdrdebut() {
        return adrdebut;
    }

    public void setAdrdebut(int adrdebut) {
        this.adrdebut = adrdebut;
    }

    public int getAdrfin() {
        return adrfin;
    }

    public void setAdrfin(int adrfin) {
        this.adrfin = adrfin;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdtaxi() {
        return idtaxi;
    }

    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
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
        return "Location{" + "idloc=" + idloc + ", dateloc=" + dateloc + ", kmtotal=" + kmtotal + ", acompte=" + acompte + ", total=" + total + ", adrdebut=" + adrdebut + ", adrfin=" + adrfin + ", idclient=" + idclient + ", idtaxi=" + idtaxi + ", vehicule=" + vehicule + '}';
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
