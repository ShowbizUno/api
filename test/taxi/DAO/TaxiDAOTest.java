/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import myconnections.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taxi.metier.API_TAXI;
import taxi.metier.vue_adresses;

/**
 *
 * @author Allison
 */
public class TaxiDAOTest {

    static Connection dbConnect;

    public TaxiDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class TaxiDAO.
     */
    @Test
    public void testCreate() throws Exception {
        //Test of a simple create
        System.out.println("create");
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbConnect);
        API_TAXI obj = new API_TAXI(0, "ImmaTest", "Carb", 1, "DescriTest");
        API_TAXI expResult = new API_TAXI(0, "ImmaTest", "Carb", 1, "DescriTest");
        API_TAXI result = instance.create(obj);

        assertEquals("Immatriculations différentes", expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("Carburants différents", expResult.getCarburant(), result.getCarburant());
        assertEquals("Prix au km différents", expResult.getPrixkm(), result.getPrixkm(), 0);
        assertEquals("Descriptions différentes", expResult.getDescription(), result.getDescription());
        assertNotEquals("Idtaxi restée a 0", result.getIdtaxi(), expResult.getIdtaxi());

        //Test of creating an existing object
        obj = new API_TAXI(0, "ImmaTest", "Car2", 2, "DescriTest2");
        try {
            API_TAXI resultat_2 = instance.create(obj);
            fail("Exception de doublon non générée");
            instance.deleteSolo(resultat_2);
        } catch (SQLException e) {
            instance.deleteSolo(result);
        }

        //Test of creating an object with incorrect "Prixkm"
        obj = new API_TAXI(0, "ImmaTest", "Car2", -1, "DescriTest2");
        try {
            API_TAXI resultat_3 = instance.create(obj);
            fail("Exception de check du prix au km non déclanchée");
            instance.deleteSolo(resultat_3);
        } catch (SQLException e) {

        }

    }

    /**
     * Test of read method, of class TaxiDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idtaxi = 0;
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbConnect);
        API_TAXI obj = new API_TAXI(0, "ImmaTest", "Carb", 1, "DescriTest");
        API_TAXI expResult = instance.create(obj);
        idtaxi = expResult.getIdtaxi();
        API_TAXI result = instance.read(idtaxi);
        assertEquals("Id de taxi différents", expResult.getIdtaxi(), result.getIdtaxi());
        assertEquals("Immatriculations différentes", expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("Carburants différents", expResult.getCarburant(), result.getCarburant());
        assertEquals("Prix au km différents", expResult.getPrixkm(), result.getPrixkm(), 0);
        assertEquals("Descriptions différentes", expResult.getDescription(), result.getDescription());

        try {
            result = instance.read(0);
            fail("Exception d'id inconnu non générée! ");
        } catch (SQLException e) {
            instance.deleteSolo(result);
        }
    }

    /**
     * Test of update method, of class TaxiDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        //test of a simple update
        System.out.println("update");
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbConnect);
        API_TAXI obj = new API_TAXI(0, "ImmaTest", "Carb", 1, "DescriTest");
        obj = instance.create(obj);
        obj.setImmatriculation("ImmaTest2");
        obj.setCarburant("Car2");
        obj.setPrixkm(2);
        obj.setDescription("DescriTest2");

        API_TAXI expResult = obj;
        API_TAXI result = instance.update(obj);

        assertEquals("Id de taxi différents", expResult.getIdtaxi(), result.getIdtaxi());
        assertEquals("Immatriculations différentes", expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("Carburants différents", expResult.getCarburant(), result.getCarburant());
        assertEquals("Prix au km différents", expResult.getPrixkm(), result.getPrixkm(), 0);
        assertEquals("Descriptions différentes", expResult.getDescription(), result.getDescription());

        instance.deleteSolo(obj);

        //Test of an update based on an existing object
        API_TAXI obj1 = new API_TAXI(0, "ImmaTest", "Carb", 1, "DescriTest");
        obj1 = instance.create(obj1);
        API_TAXI obj2 = new API_TAXI(0, "ImmaTest2", "Carb", 1, "DescriTest");
        obj2 = instance.create(obj2);

        obj1.setImmatriculation("ImmaTest2");

        try {
            instance.update(obj1);
            fail("Exception de doublon non générée");
        } catch (SQLException e) {
            instance.deleteSolo(obj1);
            instance.deleteSolo(obj2);
        }

        //test of an update based on an incorrect CP
        API_TAXI obj3 = new API_TAXI(0, "ImmaTest", "Carb", 1, "DescriTest");
        obj3 = instance.create(obj3);

        obj3.setPrixkm(-1);

        try {
            instance.update(obj3);
            fail("Exception de check du prix au km non déclanchée");
        } catch (SQLException e) {
            instance.deleteSolo(obj3);
        }
    }

    /**
     * Test of deleteSolo method, of class TaxiDAO.
     */
    @Test
    public void testDeleteSolo() throws Exception {
        //Test of a simple delete
        System.out.println("deleteSolo");
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbConnect);
        API_TAXI obj = new API_TAXI(0, "ImmaTest", "Carb", 1, "DescriTest");
        obj = instance.create(obj);
        int idtaxi = obj.getIdtaxi();
        instance.deleteSolo(obj);
        try {
            instance.read(idtaxi);
            fail("Exception de record introuvable non générée");
        } catch (SQLException e) {
            
        }
    }
    
    /**
     * Test of rechDesc method, of class TaxiDAO.
     */
    @Test
    public void testRechDesc() throws Exception {
        //Test of a research based on a part of description
        //Test sur l'indexOf non concluant dans un autre fichier de test sur un autre ordinateur(le mien ayant été indisponible quelques heures)
        //J'ai essayé d'aider Gregoire Jacquemin sur un de ses pb et ai vu son indexOf différent du mien
        //J'ai donc recopié celui-là et le test a fonctionné. Aide inconsciente mais existante.
        System.out.println("rechDesc");
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbConnect);
        API_TAXI obj1 = new API_TAXI(0, "ImmaTest", "Carb", 1, "DescriTest");
        API_TAXI obj2 = new API_TAXI(0, "ImmaTest2", "Car2", 2, "DescriTest");
        obj1=instance.create(obj1);
        obj2=instance.create(obj2);
        String desc = "DescriTest";
        List<API_TAXI> result = instance.rechDesc(desc);
       if(result.indexOf(obj1)<0){
           fail ("Cet objet est introuvable: "+obj1);
       }
       if(result.indexOf(obj2)<0){
           fail("Cet objet est introuvable: "+obj2);
       }
       instance.deleteSolo(obj1);
       instance.deleteSolo(obj2);
    }
    
     /**
     * Test of rechloc method, of class TaxiDAO.
     */
    //@Test
    public void testRechloc() throws Exception {
        //Test on a research based on a view
        //TODO CRUD Clienttaxi et CRUD adressestaxi
        System.out.println("rechloc");
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbConnect);
        
        int idloc = 0;
        
        List<vue_adresses> expResult = null;
        List<vue_adresses> result = instance.rechloc(idloc);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of delete method, of class TaxiDAO.
     */
    //@Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        API_TAXI obj = null;
        TaxiDAO instance = new TaxiDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rechercheLocations method, of class TaxiDAO.
     */
    //@Test
    public void testRechercheLocations() throws Exception {
        System.out.println("rechercheLocations");
        API_TAXI obj = null;
        TaxiDAO instance = new TaxiDAO();
        int expResult = 0;
        int result = instance.rechercheLocations(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

    /**
     * Test of rechImma method, of class TaxiDAO.
     */
    //@Test
    public void testRechImma() throws Exception {
        System.out.println("rechImma");
        String imma = "";
        TaxiDAO instance = new TaxiDAO();
        API_TAXI expResult = null;
        API_TAXI result = instance.rechImma(imma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   

    /**
     * Test of prixTotalLoc method, of class TaxiDAO.
     */
    //@Test
    public void testPrixTotalLoc() throws Exception {
        System.out.println("prixTotalLoc");
        int idloc = 0;
        TaxiDAO instance = new TaxiDAO();
        float expResult = 0.0F;
        float result = instance.prixTotalLoc(idloc);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
