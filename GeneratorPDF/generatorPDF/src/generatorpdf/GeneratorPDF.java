package generatorpdf;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gaba
 */
public class GeneratorPDF {

    Connection generatorPDF() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


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
            e2.printStackTrace();
        }
        return null;
        
    }}}
        
      
     
        
    
   
    

