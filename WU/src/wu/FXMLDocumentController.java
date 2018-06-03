/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wu;

import Connection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Klasa obsługująca menu logowania
 * @author Zbyszek
 */

public class FXMLDocumentController implements Initializable {
    
    /**
     * Przyciski, pola oraz labele występujące w klasie
     */

    @FXML
    private Label login,haslo,label ;
    @FXML
    private Button button;
    @FXML
    private TextField loginTekst;
    @FXML
    private PasswordField hasloTekst;
    
    
    /**
     * Metoda obsługująca przycisk "loguj"
     * @param event
     * @throws Exception 
     */
    @FXML
    private void loginButtonAction(ActionEvent event) throws Exception {
        
        
        
        Parent student_window = FXMLLoader.load(getClass().getResource("Student_window.fxml"));
        Scene student_window_scene = new Scene(student_window);
        Stage app_stage_student_window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        Parent admin_window = FXMLLoader.load(getClass().getResource("Admin_window.fxml"));
        Scene admin_window_scene = new Scene(admin_window);
        Stage app_stage_admin_window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        Parent dziekanat_window = FXMLLoader.load(getClass().getResource("Dziekanat_window.fxml"));
        Scene dziekanat_window_scene = new Scene(dziekanat_window);
        Stage app_stage_dziekanat_window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        Parent wykladowca_window = FXMLLoader.load(getClass().getResource("Prowadzacy_window.fxml"));
        Scene wykladowca_window_scene = new Scene(wykladowca_window);
        Stage app_stage_wykladowca_window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        
        if (isValidCredentialsStudent())
            {
                logged_s();
                app_stage_student_window.hide(); //optional
                app_stage_student_window.setScene(student_window_scene);
                app_stage_student_window.show();  
            }
        
         if (isValidCredentialsAdmin())
            {   
                logged_p();
                app_stage_admin_window.hide(); //optional
                app_stage_admin_window.setScene(admin_window_scene);
                app_stage_admin_window.show();  
            }
        
         if (isValidCredentialsWykladowca())
            {
                logged_p();
                app_stage_wykladowca_window.hide(); //optional
                app_stage_wykladowca_window.setScene(wykladowca_window_scene);
                app_stage_wykladowca_window.show();  
            }
         if (isValidCredentialsDziekanat())
            {
                logged_p();
                app_stage_dziekanat_window.hide(); //optional
                app_stage_dziekanat_window.setScene(dziekanat_window_scene);
                app_stage_dziekanat_window.show();  
            }
        else
            {
                loginTekst.clear();
                hasloTekst.clear();
            }
        
       
        
        
//        Parent student_window = FXMLLoader.load(getClass().getResource("Student_window.fxml"));
//        Scene student_window_scene = new Scene(student_window);
//        Stage app_stage_student_window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        
//        if((loginTekst.getText().equals("student"))&& (hasloTekst.getText().equals("student"))) 
//        {
//                
//                app_stage_student_window.hide(); //optional
//                app_stage_student_window.setScene(student_window_scene);
//                app_stage_student_window.show();
//       
//        }
//      
//        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Admin_window.fxml"));
//        Scene home_page_scene = new Scene(home_page_parent);
//        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        
//        if((loginTekst.getText().equals("admin"))&& (hasloTekst.getText().equals("admin"))) 
//        {
//                
//                app_stage.hide(); //optional
//                app_stage.setScene(home_page_scene);
//                app_stage.show();
//       
//        }
//        else {
//   
//       }
    
    }
    /**
     * Metoda sprawdzająca czy dane logowania studenta są poprawne
     * @return zwraca true jeśli dane są poprawne, a jeśli nie to false
     */
     public boolean isValidCredentialsStudent()
    {
        boolean let_in = false;
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        
        try {
            String passwordH = hasloTekst.getText();

            Statement statement=connection.createStatement();           
            String sql="SELECT * FROM studenci WHERE login_s = '"+loginTekst.getText()+"' AND haslo_s = '"+getHash(passwordH, "md5")+"';";
            ResultSet rs=statement.executeQuery(sql);
            
            
                
            while ( rs.next() ) {
                 if (rs.getString("login_s") != null && rs.getString("haslo_s") != null) { 
                     String  username = rs.getString("login_s");
                     System.out.println( "login = " + username );
                     String password = rs.getString("haslo_s");
                     System.out.println("haslo = " + password);
                     let_in = true;
                 }  
            }
            rs.close();
            statement.close();
            connection.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("isValidCredentials operation done successfully");
            return let_in;
    
    }
     
     /**
      * Metoda sprawdzająca czy dane logowania admina są poprawne
      * @return zwraca true jeśli dane są poprawne, a jeśli nie to false
      */
     public boolean isValidCredentialsAdmin()
    {
        boolean let_in = false;
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        
        try {
            String passwordH = hasloTekst.getText();
            Statement statement=connection.createStatement();           
            String sql="SELECT * FROM pracownicy WHERE specjalizacja_p = '1' AND login_p = '"+loginTekst.getText()+"' AND haslo_p = '"+getHash(passwordH, "md5")+"';";
            ResultSet rs=statement.executeQuery(sql);
            
            
                
            while ( rs.next() ) {
                 if (rs.getString("login_p") != null)// && rs.getString("haslo_p") != null) 
                 { 
                     String  username = rs.getString("login_p");
                     System.out.println( "login = " + username );
                    // String password = rs.getString("haslo_p");
                   //  System.out.println("haslo = " + password);
                     let_in = true;
                 }  
            }
            rs.close();
            statement.close();
            connection.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("isValidCredentials operation done successfully");
            return let_in;
    
    }
     
      
     public boolean isValidCredentialsWykladowca()
    {
        boolean let_in = false;
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        
        try {
            String passwordH = hasloTekst.getText();
            Statement statement=connection.createStatement();           
            String sql="SELECT * FROM pracownicy WHERE specjalizacja_p = '2' AND login_p = '"+loginTekst.getText()+"' AND haslo_p = '"+getHash(passwordH, "md5")+"';";
            ResultSet rs=statement.executeQuery(sql);
            
            
                
            while ( rs.next() ) {
                 if (rs.getString("login_p") != null)// && rs.getString("haslo_p") != null) 
                 { 
                     String  username = rs.getString("login_p");
                     System.out.println( "login = " + username );
                    // String password = rs.getString("haslo_p");
                   //  System.out.println("haslo = " + password);
                     let_in = true;
                 }  
            }
            rs.close();
            statement.close();
            connection.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("isValidCredentials operation done successfully");
            return let_in;
    
    }
     
     public boolean isValidCredentialsDziekanat()
    {
        boolean let_in = false;
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        
        try {
            String passwordH = hasloTekst.getText();
            Statement statement=connection.createStatement();           
            String sql="SELECT * FROM pracownicy WHERE specjalizacja_p = '3' AND login_p = '"+loginTekst.getText()+"' AND haslo_p = '"+getHash(passwordH, "md5")+"';";
            ResultSet rs=statement.executeQuery(sql);
            
            
                
            while ( rs.next() ) {
                 if (rs.getString("login_p") != null)// && rs.getString("haslo_p") != null) 
                 { 
                     String  username = rs.getString("login_p");
                     System.out.println( "login = " + username );
                    // String password = rs.getString("haslo_p");
                   //  System.out.println("haslo = " + password);
                     let_in = true;
                 }  
            }
            rs.close();
            statement.close();
            connection.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("isValidCredentials operation done successfully");
            return let_in;
    
    }
     public String getHash(String password, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
            byte[] array = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            //error action
        }
        return null;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void logged_p() throws SQLException {
        
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        Statement statement=connection.createStatement();  
        
        String username = loginTekst.getText();
        try {
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            LocalDateTime now = LocalDateTime.now();
            String query2 = "Update pracownicy set ostatnie_logowanie_pracownicy="+"'"+dtf.format(now)+"'"+" where login_p=" + "'" + username + "'";
            String query1 = "Update pracownicy set zalogowany_p='1' where login_p=" + "'" + username + "'";
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            statement.close();

            connection.close();

        } catch (SQLException e) {
            System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());

        }
    }
    
    @FXML
    public void logged_s() throws SQLException {
        
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        Statement statement=connection.createStatement();  
        
        String username = loginTekst.getText();
        try {
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            LocalDateTime now = LocalDateTime.now();
            String query2 = "Update studenci set ostatnie_logowanie_studenta="+"'"+dtf.format(now)+"'"+" where login_s=" + "'" + username + "'";
            String query1 = "Update studenci set zalogowany_s='1' where login_s=" + "'" + username + "'";
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            statement.close();

            connection.close();

        } catch (SQLException e) {
            System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());

        }
    }

}
