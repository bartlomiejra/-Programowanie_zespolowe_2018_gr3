package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
public Connection connection;
    public  Connection getConnection(){


        String dbName="WUdb";


        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,"root","");
        


        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }

}

