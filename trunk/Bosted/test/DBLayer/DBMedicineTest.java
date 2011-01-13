//package DBLayer;
//
//import ModelLayer.Client;
//import ModelLayer.ExternalContact;
//import ModelLayer.Frequency;
//import java.util.ArrayList;
//import ModelLayer.Medicine;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// * @author Gruppe 2 - DM71
// * December 2010
// */
//public class DBMedicineTest
//{
//
//    public DBMedicineTest()
//    {
//    }
//
//    @BeforeClass
//    public static void setUpClass() throws Exception
//    {
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception
//    {
//    }
//
//    @Before
//    public void setUp()
//    {
//    }
//
//    @After
//    public void tearDown()
//    {
//    }
//
//    @Test
//    public void testInsertMedicine()//(Medicine medi)
//    {
//        System.out.println("insert");
//        Frequency frequency = new Frequency();
//        int frequencyID = 1;
//        frequency.setFrequencyID(frequencyID);
//        ExternalContact externalContact = new ExternalContact();
//        int externalContactID = 1;
//        externalContact.setExternalContactID(externalContactID);
//        Client client = new Client();
//        int clientID = 1;
//        client.setClientID(clientID);
//        String name = "TEST MedicinNavn";
//        String description = "TEST MedicinBeskrivelse";
//        String date = "20100101";
//        int quantity = 100;
//        DBMedicine instance = new DBMedicine();
//        Medicine mediObj = new Medicine();
//        mediObj.setFrequency(frequency);
//        mediObj.setExternalContact(externalContact);
//        mediObj.setClient(client);
//        mediObj.setName(name);
//        mediObj.setDescription(description);
//        mediObj.setDate(date);
//        mediObj.setQuantity(quantity);
//        instance.insertMedicine(mediObj);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//        Medicine result = instance.findMedicineByClientIDAndName(1, "TEST MedicinNavn", false);
//        assertEquals(1, result.getFrequency().getFrequencyID());
//        assertEquals(1, result.getExternalContact().getExternalContactID());
//        assertEquals(1, result.getClient().getClientID());
//        assertEquals("TEST MedicinNavn", result.getName());
//        assertEquals("TEST MedicinBeskrivelse", result.getDescription());
//        assertEquals("2010-01-01",result.getDate());
//        assertEquals(100, result.getQuantity());
//    }
//
//    @Test
//    public void testFindMedicineByClientIDAndName()//(int clientID, String name, boolean retrieveAssociation)()
//    {
//        System.out.println("findMedicineByClientIDAndName");
//        Frequency frequency = new Frequency();
//        int frequencyID = 1;
//        frequency.setFrequencyID(frequencyID);
//        ExternalContact externalContact = new ExternalContact();
//        int externalContactID = 1;
//        externalContact.setExternalContactID(externalContactID);
//        Client client = new Client();
//        int clientID = 1;
//        client.setClientID(clientID);
//        String name = "TEST MedicinNavn";
//        String description = "TEST MedicinBeskrivelse";
//        String date = "2010-01-01";
//        int quantity = 100;
//        DBMedicine instance = new DBMedicine();
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//        Medicine result = instance.findMedicineByClientIDAndName(1, "TEST MedicinNavn", false);
//        System.out.println("MedicineID " + result.getMedicineID());
//        assertEquals(frequencyID, result.getFrequency().getFrequencyID());
//        System.out.println("FrequencyID " + result.getFrequency().getFrequencyID());
//        assertEquals(externalContactID, result.getExternalContact().getExternalContactID());
//        System.out.println("ExternalContactID " + result.getExternalContact().getExternalContactID());
//        assertEquals(clientID, result.getClient().getClientID());
//        System.out.println("ClientID " + result.getClient().getClientID());
//        assertEquals(name, result.getName());
//        System.out.println("Name " + result.getName());
//        assertEquals(description, result.getDescription());
//        System.out.println("Description " + result.getDescription());
//        assertEquals(date,result.getDate());
//        System.out.println("Date " + result.getDate());
//        assertEquals(quantity, result.getQuantity());
//        System.out.println("Quantity " + result.getQuantity());
//    }
//
//    @Test
//    public void testFindMedicineByID()//(int medicineID, boolean retrieveAssociation)
//    {// Run testFindMedicineByClientIDAndName first to find MedicineID
//        System.out.println("findMedicineByID");
//        Frequency frequency = new Frequency();
//        int frequencyID = 1;
//        frequency.setFrequencyID(frequencyID);
//        ExternalContact externalContact = new ExternalContact();
//        int externalContactID = 1;
//        externalContact.setExternalContactID(externalContactID);
//        Client client = new Client();
//        int clientID = 1;
//        client.setClientID(clientID);
//        String name = "TEST MedicinNavn";
//        String description = "TEST MedicinBeskrivelse";
//        String date = "2010-01-01";
//        int quantity = 100;
//        DBMedicine instance = new DBMedicine();
//        Medicine res = instance.findMedicineByClientIDAndName(clientID, name, true);
//        int medicineID = res.getMedicineID();
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//        Medicine result = instance.findMedicineByID(medicineID, false);
//        assertEquals(medicineID, result.getMedicineID());
//        System.out.println("MedicineID " + result.getMedicineID());
//        assertEquals(frequencyID, result.getFrequency().getFrequencyID());
//        System.out.println("FrequencyID " + result.getFrequency().getFrequencyID());
//        assertEquals(externalContactID, result.getExternalContact().getExternalContactID());
//        System.out.println("ExternalContactID " + result.getExternalContact().getExternalContactID());
//        assertEquals(clientID, result.getClient().getClientID());
//        System.out.println("ClientID " + result.getClient().getClientID());
//        assertEquals(name, result.getName());
//        System.out.println("Name " + result.getName());
//        assertEquals(description, result.getDescription());
//        System.out.println("Description " + result.getDescription());
//        assertEquals(date,result.getDate());
//        System.out.println("Date " + result.getDate());
//        assertEquals(quantity, result.getQuantity());
//        System.out.println("Quantity " + result.getQuantity());
//    }
//
//    @Test
//    public void testGetAllMedicine()//(boolean retriveAssociation)
//    {//if id at max is 100
//        System.out.println("getAllMedicine");
//        DBMedicine instance = new DBMedicine();
//        ArrayList<Medicine> expResult = new ArrayList<Medicine>();
//        for(int id = 1; id < 100; id++)
//        {
//            Medicine obj = instance.findMedicineByID(id, true);
//            if(obj.getClient().getClientID() != 0)
//            {
//                expResult.add(obj);
//            }
//        }
//        ArrayList<Medicine> result = instance.getAllMedicine(true);
//        assertEquals(expResult.size(), result.size());
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testUpdateMedicine()//(Medicine medi)
//    {
//        System.out.println("findMedicineByNameAndClientID");
//        DBMedicine instance = new DBMedicine();
//        Medicine mediObj = new Medicine();
//        mediObj = instance.findMedicineByClientIDAndName(1, "TEST MedicinNavn", true);
//        Frequency frequency = new Frequency();
//        int frequencyID = 1;
//        frequency.setFrequencyID(frequencyID);
//        ExternalContact externalContact = new ExternalContact();
//        int externalContactID = 1;
//        externalContact.setExternalContactID(externalContactID);
//        Client client = new Client();
//        int clientID = 1;
//        client.setClientID(clientID);
//        String name = "TEST MedicinNytNavn";
//        String description = "TEST MedicinNyBeskrivelse";
//        String date = "2010-12-15";
//        int quantity = 10;
//        System.out.println("updateMedicine");
//        mediObj.setFrequency(frequency);
//        mediObj.setExternalContact(externalContact);
//        mediObj.setClient(client);
//        mediObj.setName(name);
//        mediObj.setDescription(description);
//        mediObj.setDate(date);
//        mediObj.setQuantity(quantity);
//        instance.updateMedicine(mediObj);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//        Medicine result = instance.findMedicineByClientIDAndName(1, "TEST MedicinNytNavn", false);
//        assertEquals(1, result.getFrequency().getFrequencyID());
//        assertEquals(1, result.getExternalContact().getExternalContactID());
//        assertEquals(1, result.getClient().getClientID());
//        assertEquals("TEST MedicinNytNavn", result.getName());
//        assertEquals("TEST MedicinNyBeskrivelse", result.getDescription());
//        assertEquals("2010-12-15",result.getDate());
//        assertEquals(10, result.getQuantity());
//
//    }
//
//    @Test
//    public void testDeleteMedicine()//(int medicineID)
//    {
//        System.out.println("deleteMedicine");
//        DBMedicine instance = new DBMedicine();
//        Medicine mediObj = new Medicine();
//        mediObj = instance.findMedicineByClientIDAndName(1, "TEST MedicinNytNavn", true);
//        int medicineID = mediObj.getMedicineID();
//        System.out.println("Name " + mediObj.getName());
//        instance.deleteMedicine(medicineID);
//        Medicine mediObjResult = new Medicine();
//        mediObjResult = instance.findMedicineByClientIDAndName(1, "TEST MedicinNytNavn", true);
//        System.out.println("Name " + mediObjResult.getName());
//        assertEquals(null, mediObjResult.getName());
//    }
//
//}