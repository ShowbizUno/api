package projet_taxi_main;

import java.util.Scanner;

/**
 *
 * @author Allison
 */
public class GestionGenerale {

    Scanner sc = new Scanner(System.in);

    
    public GestionGenerale() {

    }

    public void gestion() {
        int rep = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menu principal");
            System.out.println("1.Taxis\n2.Clients\n3.Locations\n5. Fin");
            System.out.println("Votre réponse: ");
            rep = Integer.parseInt(sc.nextLine());

            switch (rep) {
                case 1:
                   appelTaxi();
                    break;
                case 2:
                    appelClient();
                    break;
                case 3:
                    appelAdresses();
                    break;
                case 4:
                    System.out.println("En cours de constuction");
                    break;
                case 5:
                    System.out.println("Fin du programme. Merci");
                    break;
                default:
                    System.out.println("Erreur de saisie!");

            }
        } while (rep != 6);

    }
    
    public void appelTaxi(){
        GestionTaxis gt = new GestionTaxis();
        gt.gestionTaxi();
    }
    
    public void appelClient(){
        GestionClients gc = new GestionClients();
        gc.gestionClients();
    }
    
    public void appelAdresses(){
        GestionLocations ga=new GestionLocations();
        ga.gestionLocations();
    }

    public static void main(String[] args) {
        GestionGenerale pgm = new GestionGenerale();
        pgm.gestion();
    }

}
