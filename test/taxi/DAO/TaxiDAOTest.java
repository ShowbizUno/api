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
        System.out.println("create");
        API_TAXI obj = new API_TAXI(0,"ImmaTest","Carb",1,"DescriTest");
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbConnect);
        API_TAXI expResult = new API_TAXI(0,"ImmaTest","Carb",1,"DescriTest");
        API_TAXI result = instance.create(obj);
        
        assertEquals("Immatriculations différentes",expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("Carburants différents", expResult.getCarburant(),result.getCarburant());
        assertEquals("Prix au km différents",expResult.getPrixkm(),result.getPrixkm(),0);
        assertEquals("Descriptions différentes",expResult.getDescription(),result.getDescription());
        assertNotEquals("Idtaxi restée a 0",result.getIdtaxi(),expResult.getIdtaxi());
        
        
        obj = new API_TAXI(0,"ImmaTest","Car2",2,"DescriTest2");
        try{
            API_TAXI resultat_2=instance.create(obj);
            fail("Exception de doublon non générée");
            instance.deleteSolo(resultat_2);
        }
        catch(SQLException e){
             instance.deleteSolo(result);
        }
      
        obj = new API_TAXI(0,"ImmaTest","Car2",-1,"DescriTest2");
        try{
            API_TAXI resultat_3 = instance.create(obj);
            fail("Exception de check du prix au km non déclanché");
            instance.deleteSolo(resultat_3);
        }
        catch(SQLException e){
            
        }
       
    }

    /**
     * Test of read method, of class TaxiDAO.
     */
   // @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idtaxi = 0;
        TaxiDAO instance = new TaxiDAO();
        API_TAXI expResult = null;
        API_TAXI result = instance.read(idtaxi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class TaxiDAO.
     */
    //@Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        API_TAXI obj = null;
        TaxiDAO instance = new TaxiDAO();
        API_TAXI expResult = null;
        API_TAXI result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
     * Test of deleteSolo method, of class TaxiDAO.
     */
    //@Test
    public void testDeleteSolo() throws Exception {
        System.out.println("deleteSolo");
        API_TAXI obj = null;
        TaxiDAO instance = new TaxiDAO();
        instance.deleteSolo(obj);
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
     * Test of rechDesc method, of class TaxiDAO.
     */
    //@Test
    public void testRechDesc() throws Exception {
        System.out.println("rechDesc");
        String desc = "";
        TaxiDAO instance = new TaxiDAO();
        List<API_TAXI> expResult = null;
        List<API_TAXI> result = instance.rechDesc(desc);
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
     * Test of rechloc method, of class TaxiDAO.
     */
    //@Test
    public void testRechloc() throws Exception {
        System.out.println("rechloc");
        int idloc = 0;
        TaxiDAO instance = new TaxiDAO();
        List<vue_adresses> expResult = null;
        List<vue_adresses> result = instance.rechloc(idloc);
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
