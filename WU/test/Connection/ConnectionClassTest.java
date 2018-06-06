/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaba
 */
public class ConnectionClassTest {
    
    public ConnectionClassTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        ConnectionClass instance = new ConnectionClass();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
