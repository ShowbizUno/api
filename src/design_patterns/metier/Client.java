
package design_patterns.metier;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Allison
 */
public class Client {
    private int idclient;
  
    private String nom;
    
    private String prenom;
    
    private String tel;
   
    private int idadr;
    
    private Set<Location> location=new HashSet<>();
    
    private Adresse adresse;

    public Client() {
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getIdadr() {
        return idadr;
    }

    public void setIdadr(int idadr) {
        this.idadr = idadr;
    }

    public Set<Location> getLocation() {
        return location;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    
    
}
