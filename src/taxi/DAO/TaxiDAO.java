package taxi.DAO;

/**
 * classe de mappage poo-relationnel taxi
 *
 * @author Van Gysegem Allison
 * @version 1.0
 * @see API_TAXI
 */
import java.sql.*;
import java.util.*;
import taxi.metier.API_TAXI;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import taxi.metier.vue_adresses;

public class TaxiDAO extends DAO<API_TAXI> {

    /**
     * création d'un taxi sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj api_taxi à créer
     * @return taxi créé
     */
    @Override
    public API_TAXI create(API_TAXI obj) throws SQLException {
        String query1 = "insert into API_TAXI(IMMATRICULATION,CARBURANT,PRIXKM,DESCRIPTION)" + "VALUES(?,?,?,?)";
        String query2 = "select IDTAXI from API_TAXI where IMMATRICULATION=? and CARBURANT=? and PRIXKM=? and DESCRIPTION=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {
            pstm1.setString(1, obj.getImmatriculation());
            pstm1.setString(2, obj.getCarburant());
            pstm1.setFloat(3, obj.getPrixkm());
            pstm1.setString(4, obj.getDescription());
            int nl = pstm1.executeUpdate();
            if (nl == 0) {
                throw new SQLException("Erreur lors de la création du taxi, aucune ligne n'est créée");
            }
            System.out.println(nl + "ligne insérée");

            pstm2.setString(1, obj.getImmatriculation());
            pstm2.setString(2, obj.getCarburant());
            pstm2.setFloat(3, obj.getPrixkm());
            pstm2.setString(4, obj.getDescription());

            try (ResultSet rs = pstm2.executeQuery()) {

                if (rs.next()) {
                    int idtaxi = rs.getInt(1);
                    return read(idtaxi);

                } else {
                    throw new SQLException("erreur de création de taxi, record introuvable");
                }

            }
        }
    }

    /**
     * récupération des données d'un taxi sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idtaxi identifiant du taxi
     * @return API_TAXI trouvé
     */
    @Override
    public API_TAXI read(int idtaxi) throws SQLException {
        String req = "select * from api_taxi where idtaxi= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idtaxi);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String imma = rs.getString("IMMATRICULATION");
                    String carburant = rs.getString("CARBURANT");
                    float prixkm = rs.getFloat("PRIXKM");
                    String description = rs.getString("DESCRIPTION");
                    return new API_TAXI(idtaxi, imma, carburant, prixkm, description);

                } else {
                    throw new SQLException("Id inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données du taxi sur base de son identifiant
     *
     * @return API_TAXI
     * @param obj API_TAXI à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public API_TAXI update(API_TAXI obj) throws SQLException {
        String req = "update api_taxi set immatriculation=?,carburant=?,prixkm=?,description=? where idtaxi= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(5, obj.getIdtaxi());
            pstm.setString(1, obj.getImmatriculation());
            pstm.setString(2, obj.getCarburant());
            pstm.setFloat(3, obj.getPrixkm());
            pstm.setString(4, obj.getDescription());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne de taxi mise à jour");
            }
            return read(obj.getIdtaxi());
        }
    }

    /**
     * effacement du taxi sur base de son immatriculation ainsi que sa/ses locations sur base de l'identifiant du taxi
     *
     * @throws SQLException Erreur d'effacement de location ou erreur d'effacement de taxi
     * @param obj API_TAXI et API_LOCATION à effacer car liés
     */
    @Override
    public void delete(API_TAXI obj) throws SQLException {
        String query1 = "DELETE FROM API_TAXI WHERE IMMATRICULATION = ?";
        String query2 = "DELETE FROM API_LOCATIONTAXI WHERE IDTAXI = ?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {

            pstm2.setInt(1, obj.getIdtaxi());
            int n = pstm2.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne location effacée");
            }
            System.out.println(n+" lignes de locations supprimées");
            pstm1.setString(1, obj.getImmatriculation());
            int nl = pstm1.executeUpdate();
            if (nl == 0) {
                throw new SQLException("aucun taxi effacé");
            }
            System.out.println("Taxi suprimé");
            //TODO si client a une location => ds le SQLException demander si on veut vraiment le del et renvoyer vers un autre void
        }
    }
    
  /**
     * effacement du taxi sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement de taxi
     * @param obj API_TAXI à effacer
     */
    public void deleteSolo(API_TAXI obj) throws SQLException{
        String query1 = "DELETE FROM API_TAXI WHERE IDTAXI = ?";
        try(PreparedStatement pstm=dbConnect.prepareStatement(query1)){
            pstm.setInt(1, obj.getIdtaxi());
            int nl = pstm.executeUpdate();
            if (nl == 0) {
                throw new SQLException("aucun taxi effacé");
            }
            System.out.println("Taxi supprimé");
        }
    }
    
    /**
     * méthode permettant de récupérer toutes les locations ayant un certain id_taxi
     *
     * @param obj Taxi recherché
     * @return entier variant en fonction de la recherche de location
     */
    public int rechercheLocations(API_TAXI obj) throws SQLException{
        String query1="select * from api_locationtaxi where idtaxi=?";
        try(PreparedStatement pstm=dbConnect.prepareStatement(query1)){
            pstm.setInt(1, obj.getIdtaxi());
            
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Il existe au moins une location liée à ce taxi");
                    return 1;

                } else {
                    System.out.println("Il n'existe aucune location liée à ce taxi");
                    System.out.println("Suppression immédiate du taxi");
                    return 0;
                }

            }
        }
    }

    /**
     * méthode permettant de récupérer tous les taxis ayant une certaines
     * description
     *
     * @param desc description recherchée
     * @return liste de taxis
     * @throws SQLException description inconnue
     */
    public List<API_TAXI> rechDesc(String desc) throws SQLException {
        List<API_TAXI> plusieurs = new ArrayList<>();
        String req = "select * from api_taxi where description like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%" + desc + "%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idtaxi = rs.getInt("IDTAXI");
                    String imma = rs.getString("IMMATRICULATION");
                    String carburant = rs.getString("CARBURANT");
                    float prixkm = rs.getFloat("PRIXKM");
                    String description = rs.getString("DESCRIPTION");
                    plusieurs.add(new API_TAXI(idtaxi, imma, carburant, prixkm, description));
                }

                if (!trouve) {
                    throw new SQLException("Description inconnue");
                } else {
                    return plusieurs;
                }
            }
        }
    }
    
    /**
     * récupération des données d'un taxi sur base de son immatriculation
     *
     * @throws SQLException immatriculation inconnue
     * @param imma immatriculation du taxi
     * @return API_TAXI trouvé
     */

    public API_TAXI rechImma(String imma) throws SQLException{
        String req= "select * from api_taxi where immatriculation=?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(req)){
            pstm.setString(1, imma);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    int idtaxi=rs.getInt("IDTAXI");
                    String carburant = rs.getString("CARBURANT");
                    float prixkm = rs.getFloat("PRIXKM");
                    String description = rs.getString("DESCRIPTION");
                    return new API_TAXI(idtaxi, imma, carburant, prixkm, description);

                } else {
                    throw new SQLException("Immatriculation inconnue");
                }

            }
        }
    }
    
    /**
     * méthode permettant de récupérer toutes les locations relatives à un id location
     *
     * @param idloc Identificateur de la location
     * @return liste des locations
     * @throws java.sql.SQLException
     */
    public List<vue_adresses> rechloc(int idloc) throws SQLException{
        List<vue_adresses> loca = new ArrayList<>();
        String req = "select * from vue_adresses where idloc = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1,idloc);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    LocalDate dateloc = rs.getDate("DATELOC").toLocalDate();
                    int kmtotal = rs.getInt("KMTOTAL");
                    Float acompte = rs.getFloat("ACOMPTE");
                    Float total = rs.getFloat("TOTAL");
                    int idclient=rs.getInt("IDCLIENT");
                    int idtaxi=rs.getInt("IDTAXI");
                    int cp=rs.getInt("CP");
                    String localite = rs.getString("LOCALITE");
                    String rue = rs.getString("RUE");
                    String num = rs.getString("NUM");
                    int cp_retour=rs.getInt("cp retour");
                    String localite_retour = rs.getString("loc retour");
                    String rue_retour = rs.getString("rue retour");
                    String num_retour = rs.getString("num retour");
                    loca.add(new vue_adresses(idloc,dateloc,kmtotal,acompte,total,idclient,idtaxi,cp,localite,rue,num,cp_retour,localite_retour,rue_retour,num_retour));
                }

                if (!trouve) {
                    throw new SQLException("idloc inconnu");
                } else {
                    return loca;
                }
            }
        }
    }
    
    public float prixTotalLoc(int idloc) throws SQLException{
        String req = "select * from vue_prixtotal where idloc = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idloc);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    Float prixtot=rs.getFloat("TOTAL");
                    return prixtot;

                } else {
                    throw new SQLException("Id inconnu");
                }

            }
        }
    }
    
}
