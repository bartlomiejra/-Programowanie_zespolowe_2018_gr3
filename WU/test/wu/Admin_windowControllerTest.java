/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wu;

import java.net.URL;
import java.util.ResourceBundle;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaba
 */
public class Admin_windowControllerTest {
    
    public Admin_windowControllerTest() {
    }
 

    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        Admin_windowController instance = new Admin_windowController();
        instance.initialize(url, rb);
        fail("The test case is a prototype.");
    }

    @Test
    public void testLoggedout_p() throws Exception {
        System.out.println("loggedout_p");
        Admin_windowController instance = new Admin_windowController();
        instance.loggedout_p();
        fail("The test case is a prototype.");
    }
    
}
