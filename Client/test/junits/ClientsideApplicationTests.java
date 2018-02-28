/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junits;

import clientprocesses.FileReceiver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author srich
 */
public class ClientsideApplicationTests {
    static FileReceiver fr;
    public ClientsideApplicationTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        fr = new FileReceiver();
        fr.init();
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("after class");
    }
    
//    @Before
//    public void setUp() {
//        
//    }
    
//    @After
//    public void tearDown() {
//        
//    }
    @Test
    public void connectionCheck(){
        assertEquals("success", fr.checkConnection());
    }
     @Test
     /*Less than 10 MB*/
     public void smallFile() {
         assertEquals(true, fr.downloadFile("recovery-20141213-recoveryflash.zip", 1));
     }
     @Test
     /*Greater than 200 MB*/
     public void mediumSizedFile() {
         assertEquals(true, fr.downloadFile("gapps-lpmr1-20150503-signed.zip", 1));
     }
     @Test
     /*Greater than 1 GB*/
     public void largeFile() {
         assertEquals(true, fr.downloadFile("Office Professional plus 13.zip", 1));
     }
}
