package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
public Connection connection;
    public  Connection getConnection(){


        String dbName="sss";


        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,"root","");
        


        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }

}

