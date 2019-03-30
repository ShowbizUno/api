
package projet_taxi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import taxi.DAO.ClientDAO;
import taxi.DAO.DAO;
import taxi.metier.API_CLIENTTAXI;
import taxi.metier.API_LOCATIONTAXI;
import myconnections.DBConnection;

/**
 *
 * @author Allison
 */
public class GestionClients {
    Connection dbConnect = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);
    API_CLIENTTAXI client = null;
    DAO<API_CLIENTTAXI> clientDAO = new ClientDAO();
    List<API_LOCATIONTAXI> ListelocationsActuelles = null;
    
    public void gestionClients(){
        clientDAO.setConnection(dbConnect);
        int rep = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menu des clients");

            try {
                System.out.println("1.Créer un nouveau client\n2.Rechercher un client\n3.Modification du client\n4.Suppression du client \n5. Fin");
                System.out.println("Votre réponse: ");
                rep = Integer.parseInt(sc.nextLine());
                switch (rep) {
                    case 1:
                        creation();
                        break;
                    case 2:
                        System.out.println("En construction");
                        //recherche();
                        break;
                    case 3:
                        System.out.println("En construction");
                        //modification();
                        break;
                    case 4:
                        System.out.println("En construction");
                        //suppression();
                        break;
                    case 5:
                        System.out.println("Fin du programme. Merci");
                        break;
                    default:
                        System.out.println("Erreur!");
                }
            } catch (Exception e) {
                System.out.println("Erreur: " + e);
            }
        } while (rep != 5);
        DBConnection.closeConnection();
    }
    
    public void creation(){
        try{
            System.out.println("Nom du client: ");
            String nom=sc.nextLine();
            System.out.println("Prénom du client: ");
            String prenom=sc.nextLine();
            System.out.println("Numéro de téléphone du client: ");
            String tel=sc.nextLine();
            System.out.println("Id de l'adresse du client: ");
            int idadresse=sc.nextInt();
            sc.skip("\n");
            client=new API_CLIENTTAXI(0,nom,prenom,tel,idadresse);
            client=clientDAO.create(client);
            System.out.println("Client actuel: " + client);
        }catch(SQLException e){
            System.out.println("Erreur: "+e);
        }
    }
    
}
