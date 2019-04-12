package taxi.DAO;

/**
 * classe de mappage poo-relationnel client
 *
 * @author Van Gysegem Allison
 * @version 1.0
 * @see API_CLIENTTAXI
 */
import java.sql.*;
import java.util.*;
import taxi.metier.API_CLIENTTAXI;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAO extends DAO<API_CLIENTTAXI> {

    /**
     * création d'un client sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj client à créer
     * @return client créé
     */
    @Override
    public API_CLIENTTAXI create(API_CLIENTTAXI obj) throws SQLException {
        String query1 = "insert into api_clienttaxi(nom,prenom,tel,idadr)" + "VALUES(?,?,?,?)";
        String query2 = "select idclient from api_clienttaxi where nom=? and prenom=? and tel=? and idadr=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {
            pstm1.setString(1, obj.getNom());
            pstm1.setString(2, obj.getPrenom());
            pstm1.setString(3, obj.getTel());
            pstm1.setInt(4, obj.getIdadr());

            int nl = pstm1.executeUpdate();
            if (nl == 0) {
                throw new SQLException("Erreur lors de la création du client, aucune ligne n'est créée");
            }
            System.out.println(nl + "ligne insérée");

            pstm2.setString(1, obj.getNom());
            pstm2.setString(2, obj.getPrenom());
            pstm2.setString(3, obj.getTel());
            pstm2.setInt(4, obj.getIdadr());

            try (ResultSet rs = pstm2.executeQuery()) {

                if (rs.next()) {
                    int idclient = rs.getInt(1);
                    return read(idclient);

                } else {
                    throw new SQLException("erreur de création de taxi, record introuvable");
                }

            }
        }
    }

    @Override
    public API_CLIENTTAXI read(int idclient) throws SQLException {
        String req = "select * from api_clienttaxi where idclient= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idclient);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String tel = rs.getString("TEL");
                    int idadr = rs.getInt("IDADR");
                    return new API_CLIENTTAXI(idclient, nom, prenom, tel, idadr);

                } else {
                    throw new SQLException("Id inconnu");
                }

            }
        }
    }

    @Override
    public API_CLIENTTAXI update(API_CLIENTTAXI obj) throws SQLException {
        String req = "update api_clienttaxi set nom=?,prenom=?,tel=?,idadr=? where idclient=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(5, obj.getIdclient());
            pstm.setString(1, obj.getNom());
            pstm.setString(2, obj.getPrenom());
            pstm.setString(3, obj.getTel());
            pstm.setInt(4, obj.getIdadr());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne de client mise à jour");
            }
            return read(obj.getIdclient());
        }
    }

    @Override
    public void delete(API_CLIENTTAXI obj) throws SQLException {
        String req="delete from api_clienttaxi where idclient=?";
        try(PreparedStatement pstm=dbConnect.prepareStatement(req)){
            pstm.setInt(1, obj.getIdclient());
            int nl = pstm.executeUpdate();
            if (nl == 0) {
                throw new SQLException("aucun client effacé");
            }
            System.out.println("Client supprimé");
        }
    }

    public API_CLIENTTAXI rechercheID(int id) throws SQLException {
        String req = "select * from api_clienttaxi where idclient=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String tel = rs.getString("TEL");
                    int idadr = rs.getInt("IDADR");
                    return new API_CLIENTTAXI(id, nom, prenom, tel, idadr);

                } else {
                    throw new SQLException("Immatriculation inconnue");
                }
            }
        }

    }
}
