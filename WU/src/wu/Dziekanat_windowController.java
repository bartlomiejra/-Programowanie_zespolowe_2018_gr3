package wu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Klasa obslugujaca dzialanie okna dziekanatu
 *
 * @author Teo
 */
public class Dziekanat_windowController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
               
    }  
    
    /**
     * Metoda odpowiedzialna za ladowanie sceny z ocenami dla dziekanatu i ukrywa scene z menu dziekanatu
     * @param event
     * @throws IOException 
     */
    @FXML
     private void assessment_dziekanatButtonAction(ActionEvent event) throws IOException {
    
        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Oceny_Dziekanat.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();        
     }
     
     /**
      * Metoda odpowiedzialna za ladowanie sceny z uzytkownikami i ukrycie okna z menu dziekanatu
      * @param event
      * @throws IOException 
      */
     @FXML
     private void users_dziekanatButtonAction(ActionEvent event) throws IOException {
    
        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("usersCRUD_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();        
     }
     
     /**
      * Metoda odpowiedzialna za wylogowanie uzytkownika i przejscie do okna logowania
      * @param event
      * @throws IOException 
      */
      @FXML
    private void logout_adminButtonAction(ActionEvent event) throws IOException {

        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("Login_window.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();             
    }
    
    /**
     * Metoda odpowiedzialna za ladowanie sceny z planem zajec i ukryciem sceny z menu dziekanatu
     * @param event
     * @throws IOException 
     */
    @FXML
    private void schedule_dziekanatButtonAction(ActionEvent event) throws IOException {

        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("Planzajec_dziekanatwindow.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();             
    }
    
    /**
     * Metoda odpowiedzialna za zamkniecie programu po nacisnieciu przycisku
     * @param event
     * @throws IOException 
     */
     @FXML
    private void close_adminButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
}
