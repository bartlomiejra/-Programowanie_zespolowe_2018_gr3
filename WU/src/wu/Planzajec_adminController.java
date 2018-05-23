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
 * Klasa obslugujaca dzialanie sceny z planem zajec dla administratora
 * @author Teo
 */
public class Planzajec_adminController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    /**
     * Metoda edytujaca 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void edit_wykladowcaButtonAction(ActionEvent event) throws IOException {

    }
    
    
    /**
     * Metoda dodajaca
     * @param event
     * @throws IOException 
     */
    @FXML
    private void add_wykladowcaButtonAction(ActionEvent event) throws IOException {

    }
    
    /**
     * Metoda usuwajaca 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void delete_wykładowcaButtonAction(ActionEvent event) throws IOException {

    }
    
    /**
     * Meotda szukajaca
     * @param event
     * @throws IOException 
     */
    @FXML
    private void search_usersButtonAction(ActionEvent event) throws IOException {

    }
    
    /**
     * Metoda ladujaca
     * @param event
     * @throws IOException 
     */
    @FXML
    private void load_usersButonAction(ActionEvent event) throws IOException {

    }
    
    /**
     * Metoda czyszczaca
     * @param event
     * @throws IOException 
     */
    @FXML
    private void clear_usersButtonAction(ActionEvent event) throws IOException {

    }
    
    /**
     * Metoda odpowiedzialna za powrot do menu admina
     * @param event
     * @throws IOException 
     */
    @FXML
    private void assesmentAdmin_menuActionButton(ActionEvent event) throws IOException {

        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Admin_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();
    }
    
    /**
     * Metoda odpowiedzialna za wylogowanie i przejscie do okna logowania
     * @param event
     * @throws IOException 
     */
    @FXML
    private void assesment_logoutActionButton(ActionEvent event) throws IOException {

        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("Login_window.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();
    }
    
    /**
     * Metoda zamykajaca aplikacje
     * @param event
     * @throws IOException 
     */
    @FXML
    private void close_usersButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
}
