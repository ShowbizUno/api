/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design_patterns.metier.builder;

/**
 *
 * @author Allison
 */
public class test_builder {
    public static void main(String[] args) {
        System.out.println("Test avec taxi complet: ");
        try{
            Taxi ta1 = new Taxi.TaxiBuilder().
                    setIdtaxi(1).
                    setImmatriculation("abc").
                    setCarburant("essence").
                    setPrixkm(2).
                    setDescription("taxi de test").
                    build();
            System.out.println(ta1);
        }
        catch(Exception e){
            System.out.println("Erreur: "+e);
        }
        
        System.out.println("Test avec taxi incomplet: (immatriculation)");
        try{
            Taxi ta2 = new Taxi.TaxiBuilder().
                    setIdtaxi(1).
                    setCarburant("essence").
                    setPrixkm(2).
                    setDescription("taxi de test").
                    build();
            System.out.println(ta2);
        }
        catch(Exception e){
            System.out.println("Erreur: "+e);
        }
        
        System.out.println("Test avec taxi incomplet: (prixkm)");
        try{
            Taxi ta3 = new Taxi.TaxiBuilder().
                    setIdtaxi(1).
                    setImmatriculation("abc").
                    setCarburant("essence").
                    setDescription("taxi de test").
                    build();
            System.out.println(ta3);
        }
        catch(Exception e){
            System.out.println("Erreur: "+e);
        }
        
    }
}
