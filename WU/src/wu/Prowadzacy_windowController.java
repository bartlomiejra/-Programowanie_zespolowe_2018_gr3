package wu;

import Connection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Prowadzacy_windowController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    /**
     * metody zamykająca okno aplikacji
     * @param event
     * @throws IOException 
     */
    @FXML
    private void close_adminButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    /**
     * metoda służy do wylogowania z aplikacji, przejście do okna logowania do aplikacji
     * @param event
     * @throws IOException 
     */
    @FXML
    private void logout_adminButtonAction(ActionEvent event) throws IOException, SQLException {

        loggedout_p();
        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("Login_window.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();

    }
    /**
     * metoda odpowiedzialna za przejście do sceny z planem zajęć
     * @param event
     * @throws IOException 
     */
    @FXML
    private void schedule_ProwadzacyButtonAction(ActionEvent event) throws IOException {

        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("Planzajec_prowadzacy.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();             
    }
    /**
     * metoda odpowiedzialna za przejśćie do okna Wystawianie ocen dla wykładowy
     * @param event
     * @throws IOException 
     */
    @FXML
    private void assessment_ProwadzacyButtonAction(ActionEvent event) throws IOException {

        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Oceny_Wykladowca.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();

    }
    
    public void loggedout_p() throws SQLException {
        
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        Statement statement=connection.createStatement();  
        
        try {
            

            String query1 = "Update pracownicy set zalogowany_p='0'";
            statement.executeUpdate(query1);
            statement.close();

            connection.close();

        } catch (SQLException e) {
            System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());

        }
    
    
}
    
}