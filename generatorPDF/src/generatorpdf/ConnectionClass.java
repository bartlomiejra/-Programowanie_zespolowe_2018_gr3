package generatorpdf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gaba
 */
public class ConnectionClass {

  
  
    

        public Connection connection;
        
        public  Connection getConnection() throws ClassNotFoundException{

        String dbName="sss";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,"root","");
                 System.out.println("Połączono pomyślnie");
            return connection;
        }catch (SQLException e){
            System.err.println("Problem z otwarciem połączenia");
        }catch(ClassNotFoundException e2){
            System.err.println("Niewłaściwy sterownik JDBC ");
        }
        return null;
        
    }

  
}
        
      
     
        
    
   
    

