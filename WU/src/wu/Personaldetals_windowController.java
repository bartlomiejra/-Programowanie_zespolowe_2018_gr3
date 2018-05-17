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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Klasa obslugujaca dzialanie sceny personaldetails
 *
 * @author Teo
 */
public class Personaldetals_windowController implements Initializable {
/**
 * Przyciski wykorzystane w scenie
 */
    @FXML
    private Button assesment_menu;
    @FXML
    private Button assesment_logout;
    @FXML
    private Button close_history;
    @FXML
    private Button edit_detals;
    @FXML
    private Button save_detals;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /**
     * Metoda odopowiedzialna za przejscie do okna studenta
     * @param event
     * @throws IOException 
     */
    @FXML
     private void personalDetailsActionButton(ActionEvent event) throws IOException {
    
        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Student_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();        
     }
     
     /**
      * Metoda odpowiedzialna za zamknięcie programu 
      * @param event
      * @throws IOException 
      */
    @FXML
    private void close_adminButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    /**
     * Metoda odpowiedzialna za wylogowanie i przejscie do okna logowania
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
     * Metoda odpowiedzialna za edycje danych 
     * @param event 
     */
    @FXML
    private void edit_detalsButtonAction(ActionEvent event) {
    }
    
    /**
     * Metoda odpowiedzialna za zapisanie danych
     * @param event 
     */
    @FXML
    private void save_detalsButtonAction(ActionEvent event) {
    }
    
}
