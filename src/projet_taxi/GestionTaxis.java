package projet_taxi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import taxi.DAO.TaxiDAO;
import taxi.DAO.DAO;
import taxi.metier.API_TAXI;
import myconnections.DBConnection;
import taxi.metier.vue_adresses;

/**
 *
 * @author Allison
 */
public class GestionTaxis {

    Connection dbConnect = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);
    API_TAXI taxi = null;
    //DAO<API_TAXI> taxiDAO = new TaxiDAO();
    TaxiDAO taxiDAO = new TaxiDAO();
    List<API_TAXI> ListeTaxisActuels = null;
    List<vue_adresses> ListeAdresses = null;

    public void gestionTaxi() {
        taxiDAO.setConnection(dbConnect);
        int rep = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menu des taxis");

            try {
                System.out.println("1.Créer un nouveau taxi\n2.Rechercher un taxi\n3.Modification du taxi\n4.Suppression du taxi \n5. Affichage des locations via l'id client\n6. Prix total d'une location\n7.Fin");
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
                        affichageTotal();
                        break;
                    case 6:
                        affichagePrix();
                        break;
                    case 7: 
                        System.out.println("Fin du programme. Merci");
                        break;
                    default:
                        System.out.println("Erreur!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur: " + e);
            }
        } while (rep != 7);
        DBConnection.closeConnection();
    }

    public void creation() {
        try {
            System.out.println("Immatriculation du véhicule: ");
            String imma = sc.nextLine();
            System.out.println("Carburant du véhicule: ");
            String carburant = sc.nextLine();
            System.out.println("Prix au kilomètre du véhicule: ");
            float prixkm = sc.nextFloat();
            sc.skip("\n");
            System.out.println("description du taxi: ");
            String description = sc.nextLine();
            taxi = new API_TAXI(0, imma, carburant, prixkm, description);
            taxi = taxiDAO.create(taxi);
            System.out.println("Taxi actuel: " + taxi);
        } catch (SQLException e) {
            System.out.println("Erreur: " + e);
        }
    }

    public void recherche() {
        int rep = 0;
        do {
            System.out.println("Voulez-vous rechercher via\n1/L'immatriculation\n2/La description\n3/Retourner au menu");
            try {
                rep = Integer.parseInt(sc.nextLine());
                switch (rep) {
                    case 1:
                        rechercheImma();
                        break;
                    case 2:
                        rechercheDesc();
                        break;
                    case 3:
                        System.out.println("Retour au menu");
                        break;
                    default:
                        System.out.println("Erreur!");
                }
            } catch (Exception e) {
                System.out.println("erreur: " + e);
            }
        } while (rep > 3 || rep < 1);

    }

    public void rechercheImma() {
        try {
            System.out.println("Veuillez entrer l'immatriculation du taxi recherché: ");
            String imma = sc.nextLine();
            taxi = ((TaxiDAO) taxiDAO).rechImma(imma);
            System.out.println("Voici le nouveau taxi actuel: " + taxi);
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
    }

    public void rechercheDesc() {
        int ok = -1;
        do {
            try {
                System.out.println("Veuillez entrer la description du taxi recherché: ");
                String desc = sc.nextLine();
                ListeTaxisActuels = taxiDAO.rechDesc(desc);
                for (API_TAXI tx : ListeTaxisActuels) {
                    System.out.println(tx);
                }
                ok = prepaActuel();

            } catch (SQLException e) {
                System.out.println("erreur " + e.getMessage());
            }
        } while (ok == 1);
    }

    public void modification() {
        if (taxi == null) {
            System.out.println("Veuillez d'abord choisir un taxi actuel");
            recherche();
        }

        try {
            System.out.println("Immatriculation du taxi recherché: " + taxi.getImmatriculation());
            System.out.println("Entrez l'immatriculation: ");
            sc.skip("\n");
            String imma = sc.nextLine();
            taxi.setImmatriculation(imma);

            System.out.println("Carburant du taxi recherché: " + taxi.getCarburant());
            System.out.println("Entrez le carburant: ");

            String carb = sc.nextLine();
            taxi.setCarburant(carb);

            System.out.println("Prix au kilomètre du taxi recherché: " + taxi.getPrixkm());
            System.out.println("Entrez le prix au km: ");

            float prixkm = sc.nextFloat();
            taxi.setPrixkm(prixkm);

            System.out.println("Description du taxi recherché: " + taxi.getDescription());
            System.out.println("Entrez la description du taxi: ");
            sc.skip("\n");
            String desc = sc.nextLine();
            taxi.setDescription(desc);

            taxiDAO.update(taxi);
            System.out.println(taxi);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void suppression() {
        if (taxi == null) {
            System.out.println("Veuillez d'abord choisir un taxi actuel");
            recherche();
        }

        int recup = -1;
        int rep = -1;
        try {
            System.out.println("Suppression du taxi actuel");
            recup = ((TaxiDAO) taxiDAO).rechercheLocations(taxi);

            if (recup == 0) {
                ((TaxiDAO) taxiDAO).deleteSolo(taxi);
            } else if (recup == 1) {
                System.out.println("Voulez-vous bien supprimer ce taxi ainsi que ses locations? 1/Oui 2/Non");
                rep = Integer.parseInt(sc.nextLine());
                switch (rep) {
                    case 1:
                        taxiDAO.delete(taxi);
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Erreur lors de la saisie");
                }

            } else {
                throw new SQLException("renvoi de l'int autre que 0 et -1!");
            }

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public int prepaActuel() {
        Boolean ok = false;
        Boolean erreur = false;
        do {
            System.out.println("Voulez-vous faire d'un de ce(s) taxi(s) le taxi actuel?");
            System.out.println("1.Oui\n2.Recommencer la recherche\n3.Annuler");
            System.out.println("Entrez le nombre voulu: ");
            String rep = sc.nextLine();
            switch (rep) {
                case "1":
                    actuel();
                    erreur = false;
                    break;
                case "2":
                    return 1;
                case "3":
                    erreur = false;
                    break;
                default:
                    System.out.println("Erreur!");
                    erreur = true;
            }
        } while (erreur == true);
        return -1;
    }

    public void affichageTotal() {
        try {
            System.out.println("Veuillez entrer l'id de la location");
            int id = sc.nextInt();
            ListeAdresses = taxiDAO.rechloc(id);
            for (vue_adresses va : ListeAdresses) {
                System.out.println(va);
            }

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());

        }

    }
    
    public void affichagePrix(){
        try{
            System.out.println("Veuillez entrer l'id de la location: ");
            int id=sc.nextInt();
            Float prix=taxiDAO.prixTotalLoc(id);
            System.out.println("Le prix de votre location est de: "+prix+" euro(s).");
        }catch (SQLException e){
            System.out.println("Erreur "+e.getMessage());
        }
    }

    public void actuel() {
        System.out.println("Veuillez entrer l'id du taxi correspondant: ");
        int id = sc.nextInt();
        try {
            taxi = taxiDAO.read(id);
            System.out.println("Le taxi actuel est: " + taxi);
        } catch (SQLException e) {
            System.out.println("Erreur: taxi inexistant");
        }
    }

}
