package projet_taxi_main;

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
    ClientDAO clientDAO = new ClientDAO();
    List<API_LOCATIONTAXI> ListelocationsActuelles = null;

    public void gestionClients() {
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
                        recherche();
                        break;
                    case 3:
                        modification();
                        break;
                    case 4:
                        suppression();
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

    public void creation() {
        try {
            System.out.println("Nom du client: ");
            String nom = sc.nextLine();
            System.out.println("Prénom du client: ");
            String prenom = sc.nextLine();
            System.out.println("Numéro de téléphone du client: ");
            String tel = sc.nextLine();
            System.out.println("Id de l'adresse du client: ");
            int idadresse = sc.nextInt();
            sc.skip("\n");
            client = new API_CLIENTTAXI(0, nom, prenom, tel, idadresse);
            client = clientDAO.create(client);
            System.out.println("Client actuel: " + client);
        } catch (SQLException e) {
            System.out.println("Erreur: " + e);
        }
    }

    public void recherche() {
        try {
            System.out.println("Veuillez entrer l'identifiant du client recherché: ");
            int id = sc.nextInt();
            client = clientDAO.rechercheID(id);
            System.out.println("Voici le nouveau client actuel: " + client);
        } catch (SQLException e) {
            System.out.println("Erreur: " + e);
        }
    }

    public void modification() {
        if (client == null) {
            System.out.println("Veuillez d'abord rechercher un client afin d'avoir un client actuel");
            recherche();
        }
        try {
            sc.skip("\n");
            System.out.println("Nom du client actuel: " + client.getNom());
            System.out.println("Entrez le nouveau nom: ");

            String nom = sc.nextLine();
            client.setNom(nom);

            System.out.println("Prénom du client actuel: " + client.getPrenom());
            System.out.println("Entrez le nouveau prénom: ");
            String prenom = sc.nextLine();
            client.setPrenom(prenom);

            System.out.println("Numéro de téléphone du client actuel: " + client.getTel());
            System.out.println("Entrez le nouveau numéro de téléphone: ");
            String tel = sc.nextLine();
            client.setTel(tel);

            System.out.println("Identifiant de l'adresse du client actuel: " + client.getIdadr());
            System.out.println("Entrez le nouvel identifiant de l'adresse: ");
            int idadr = sc.nextInt();
            client.setIdadr(idadr);
            sc.skip("\n");

            clientDAO.update(client);
            System.out.println(client);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void suppression() {
        if (client == null) {
            System.out.println("Veuillez d'abord rechercher un client afin d'avoir un client actuel");
            recherche();
        }
        
        try {
            System.out.println("Suppression du client actuel");
            clientDAO.delete(client);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
}
