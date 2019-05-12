/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design_patterns.metier.observer;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Allison
 */
public class test_observer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        Taxi taxi=new Taxi(1,"abc","Essence",3,"Taxi de test");
        Adresse adresseDepart = new Adresse(1,7000,"Mons","rue des Braises","24a");
        Adresse adresseFin= new Adresse(2,7000,"Mons","rue des Houx","32b");
        Client client= new Client(1,"Reaper","Syal","0411/112233",adresseDepart);
        adresseDepart.getClient().add(client);
        Location location=new Location(1,50,20,400,taxi,adresseDepart,adresseFin,client);
        taxi.getLocation().add(location);
        adresseDepart.getLocdeb().add(location);
        adresseFin.getLocfin().add(location);

        Taxi taxi2=new Taxi(1,"abcd","Essence",4,"Taxi de test2");
        
        location.setVehicule(taxi2);
        
    }
}
