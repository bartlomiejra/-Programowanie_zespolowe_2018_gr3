/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *\est polaczenia z baza
 * @author Gaba
 */
public class ConnectionClassTest {
    
    public ConnectionClassTest() {
    }

    @Test
    public void testGetConnection() {
        System.out.println("Test polaczenia z baza ");
        ConnectionClass instance = new ConnectionClass();
        Connection conn = instance.getConnection();
        assertNotNull(conn);
        System.out.println("Test przebiegł pomyslnie");
    }
    
}
