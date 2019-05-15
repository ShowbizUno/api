/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

/**
 *
 * @author Allison
 */

import java.sql.*;
import java.util.*;
import taxi.metier.API_LOCATIONTAXI;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class LocationDAO extends DAO<API_LOCATIONTAXI>{

    @Override
    public API_LOCATIONTAXI create(API_LOCATIONTAXI obj) throws SQLException {
        String query1 = "insert into api_locationtaxi(dateloc,kmtotal,acompte,total,adrdebut,adrfin,idclient,idtaxi)" + "VALUES(?,?,?,?,?,?,?,?)";
        String query2 = "select idloc from api_locationtaxi where dateloc=? and kmtotal=? and acompte=? and total=? and adrdebut=? and adrfin=? and idclient=? and idtaxi=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {
            pstm1.setDate(1, java.sql.Date.valueOf(obj.getDateloc()));
            pstm1.setInt(2, obj.getKmtotal());
            pstm1.setFloat(3, obj.getAcompte());
            pstm1.setFloat(4, obj.getTotal());
            pstm1.setInt(5, obj.getAdrdebut());
            pstm1.setInt(6, obj.getAdrfin());
            pstm1.setInt(7, obj.getIdclient());
            pstm1.setInt(8, obj.getIdtaxi());
            int nl = pstm1.executeUpdate();
            if (nl == 0) {
                throw new SQLException("Erreur lors de la création de la location, aucune ligne n'est créée");
            }
            System.out.println(nl + "ligne insérée");

            pstm2.setDate(1, java.sql.Date.valueOf(obj.getDateloc()));
            pstm2.setInt(2, obj.getKmtotal());
            pstm2.setFloat(3, obj.getAcompte());
            pstm2.setFloat(4, obj.getTotal());
            pstm2.setInt(5, obj.getAdrdebut());
            pstm2.setInt(6, obj.getAdrfin());
            pstm2.setInt(7, obj.getIdclient());
            pstm2.setInt(8, obj.getIdtaxi());

            try (ResultSet rs = pstm2.executeQuery()) {

                if (rs.next()) {
                    int idloc = rs.getInt(1);
                    return read(idloc);

                } else {
                    throw new SQLException("erreur de création de taxi, record introuvable");
                }

            }
        }
    }
    
    @Override
    public API_LOCATIONTAXI read(int id) throws SQLException {
        String req = "select * from api_locationtaxi where idloc= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    LocalDate date = rs.getDate("DATELOC").toLocalDate();
                    int kmtot = rs.getInt("KMTOTAL");
                    float acompte = rs.getFloat("ACOMPTE");
                    float total = rs.getFloat("TOTAL");
                    int adrdebut = rs.getInt("ADRDEBUT");
                    int adrfin = rs.getInt("ADRFIN");
                    int idclient = rs.getInt("IDCLIENT");
                    int idtaxi = rs.getInt("IDTAXI");
                    return new API_LOCATIONTAXI(id,date,kmtot,acompte,total,adrdebut,adrfin,idclient,idtaxi);

                } else {
                    throw new SQLException("Id inconnu");
                }

            }
        }
    }

    @Override
    public API_LOCATIONTAXI update(API_LOCATIONTAXI obj) throws SQLException {
        String req = "update api_locationtaxi set dateloc=?,kmtotal=?,acompte=?,total=?, adrdebut=?, adrfin=?, idclient=?, idtaxi=? where idloc= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(9, obj.getIdloc());
            pstm.setDate(1, java.sql.Date.valueOf(obj.getDateloc()));
            pstm.setInt(2, obj.getKmtotal());
            pstm.setFloat(3, obj.getAcompte());
            pstm.setFloat(4, obj.getTotal());
            pstm.setInt(5, obj.getAdrdebut());
            pstm.setInt(6, obj.getAdrfin());
            pstm.setInt(7, obj.getIdclient());
            pstm.setInt(8, obj.getIdtaxi());
            
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne de location mise à jour");
            }
            return read(obj.getIdtaxi());
        }
    }

    @Override
    public void delete(API_LOCATIONTAXI obj) throws SQLException {
       String query1 = "delete from api_locationtaxi where idloc=? ";
        try(PreparedStatement pstm=dbConnect.prepareStatement(query1)){
            pstm.setInt(1, obj.getIdloc());
            int nl = pstm.executeUpdate();
            if (nl == 0) {
                throw new SQLException("Aucune location effacée");
            }
            System.out.println("Location supprimée");
        }
    }
    
}
