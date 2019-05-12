
package design_patterns.metier.builder;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Allison
 */
public class Adresse {
    
    private int idadr;
    
    private int cp;
    
    private String localite;
    
    private String rue;
   
    private String num;
    
    private Set<Location>locdeb=new HashSet<>();
    
    private Set<Location>locfin=new HashSet<>();
    
    private Set<Client>client=new HashSet<>();

    public Adresse() {
    }

    public Adresse(int idadr, int cp, String localite, String rue, String num) {
        this.idadr = idadr;
        this.cp = cp;
        this.localite = localite;
        this.rue = rue;
        this.num = num;
    }

    public int getIdadr() {
        return idadr;
    }

    public void setIdadr(int idadr) {
        this.idadr = idadr;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Set<Location> getLocdeb() {
        return locdeb;
    }

    public Set<Location> getLocfin() {
        return locfin;
    }

    public Set<Client> getClient() {
        return client;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idadr;
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
        final Adresse other = (Adresse) obj;
        if (this.idadr != other.idadr) {
            return false;
        }
        return true;
    }
    
    
}
