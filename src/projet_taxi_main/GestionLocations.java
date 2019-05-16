//TODO imports
package projet_taxi_main;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import taxi.DAO.LocationDAO;
import taxi.metier.API_LOCATIONTAXI;
import myconnections.DBConnection;

/**
 *
 * @author Allison
 */
public class GestionLocations {

    Connection dbConnect = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);
    API_LOCATIONTAXI loc = null;
    LocationDAO locationDAO = new LocationDAO();
    List<API_LOCATIONTAXI> locations =null;

    public void gestionLocations() {
        locationDAO.setConnection(dbConnect);
        int rep = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menu des locations");

            try {
                System.out.println("1.Créer une location\n2.Rechercher une location\n3.Modification d'une location\n4.Suppression d'une location \n5.rech loc par id taxi\n6.fin");
                System.out.println("Votre réponse: ");
                rep = Integer.parseInt(sc.nextLine());
                switch (rep) {
                    case 1:
                        creation();
                        break;
                    case 2:
                        //recherche();
                        break;
                    case 3:
                        modification();
                        break;
                    case 4:
                        suppression();
                        break;
                    case 5:
                        rechloc();
                        break;
                    case 6:
                        System.out.println("Fin");
                    default:
                        System.out.println("Erreur!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur: " + e);
            }
        } while (rep != 6);
        DBConnection.closeConnection();
    }

    public void creation() {
        try {
            System.out.println("Entrez la date de location 'YYYY MM DD' : ");
            int year = sc.nextInt();
            sc.skip("\n");
            int month = sc.nextInt();
            sc.skip("\n");
            int day = sc.nextInt();
            sc.skip("\n");
            LocalDate dt = LocalDate.of(year, month, day);
            System.out.println("Entrez le nombre de km totaux: ");
            int kmtotal= sc.nextInt();
            sc.skip("\n");
            System.out.println("Entrez l'acompte: ");
            float acompte = sc.nextFloat();
             sc.skip("\n");
            System.out.println("Entrez le total à payer: ");
            float total = sc.nextFloat();
            sc.skip("\n");
            System.out.println("Entrez l'identifiant de l'adresse de début: ");
            int adrdebut= sc.nextInt();
            sc.skip("\n");
            System.out.println("Entrez l'identifiant de l'adresse de fin: ");
            int adrfin = sc.nextInt();
            sc.skip("\n");
            System.out.println("Entrez l'identifiant du client: ");
            int idclient=sc.nextInt();
            sc.skip("\n");
            System.out.println("Entrez l'identifiant du taxi: ");
            int idtaxi=sc.nextInt();
            sc.skip("\n");
            
            loc = new API_LOCATIONTAXI(0,dt,kmtotal,acompte,total,adrdebut,adrfin,idclient,idtaxi);
            loc=locationDAO.create(loc);
            System.out.println("Location actuelle: "+loc);
        } catch (SQLException e) {
            System.out.println("Erreur: " + e);
        }
    }
    
    public void modification(){
        try{
            loc=locationDAO.read(1);
            System.out.println("Entrez la date de location 'YYYY MM DD' : ");
            
            LocalDate dt = LocalDate.of(2000, 2, 20);
            loc.setDateloc(dt);
            
            
            System.out.println("Entrez le nombre de km totaux: ");
            
            loc.setKmtotal(20);
            
            System.out.println("Entrez l'acompte: ");
            
             loc.setAcompte(20);
             
            System.out.println("Entrez le total à payer: ");
           
            loc.setTotal(20);
            
            System.out.println("Entrez l'identifiant de l'adresse de début: ");
            
            loc.setAdrdebut(1);
            
            System.out.println("Entrez l'identifiant de l'adresse de fin: ");
            
            loc.setAdrfin(2);
            
            System.out.println("Entrez l'identifiant du client: ");
            
            loc.setIdclient(1);
            
            System.out.println("Entrez l'identifiant du taxi: ");
            
            loc.setIdtaxi(1);
            
            loc=locationDAO.update(loc);
            System.out.println(loc);
            
        }catch(Exception e){
            System.out.println("erreur: "+e);
        }
    }
    
    public void suppression(){
        try{
            loc=locationDAO.read(42);
            
            locationDAO.delete(loc);
            
        }catch(Exception e){
            System.out.println("erreur: "+e);
        }
    }
    
    public void rechloc(){
        try{
            locations=locationDAO.rechTaxi(1);
            for (API_LOCATIONTAXI lo : locations) {
                    System.out.println(lo);
                }
        }catch(Exception e){
            System.out.println("erreur "+e);
        }
    }

}
