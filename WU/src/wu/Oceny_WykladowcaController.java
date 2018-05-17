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
 *  * Klasa odpowiedzialna za wyswietlenie okna Oceny_Wykladowca 
 *
 * @author Teo
 */
public class Oceny_WykladowcaController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }   
    /**
     * Metoda do zamkniecia programu
     * @param event
     * @throws IOException 
     */
     @FXML
    private void close_usersButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    /**
     * metoda do przejscia do okna dziekanat_window po kliknieciu menu
     * @param event
     * @throws IOException 
     */
    @FXML
     private void assesmentWykladowca_menuActionButton(ActionEvent event) throws IOException {
    
        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Dziekanat_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();        
     }
     
     /**
      * metoda odpowiedzialna za przejscie do okna logowania
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
     * Metoda do generowania pdf dla wykładowcy
     * @param event
     * @throws IOException 
     */
    @FXML
    private void generate_wykladowcaButtonAction(ActionEvent event) throws IOException {
            
    }
    
    /**
     * Metoda do usuniecia wykladowcy z bazy 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void delete_wykładowcaButtonAction(ActionEvent event) throws IOException {
            
    }
    
    /**
     * Metoda do edycji danych wykładowcy w bazie
     * @param event
     * @throws IOException 
     */
    @FXML
    private void edit_wykladowcaButtonAction(ActionEvent event) throws IOException {
            
    }
    
    /**
     * Metoda do dodania wykladowcy do bazy 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void add_wykladowcaButtonAction(ActionEvent event) throws IOException {
            
    }
    
    /**
     * metoda szukajaca 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void search_usersButtonAction(ActionEvent event) throws IOException {
            
    }
    
    /**
     * metoda ladujaca
     * @param event
     * @throws IOException 
     */
    @FXML
    private void load_usersButonAction(ActionEvent event) throws IOException {
            
    }
    
    /**
     * metoda czyszczaca
     * @param event
     * @throws IOException 
     */
    @FXML
    private void clear_usersButtonAction(ActionEvent event) throws IOException {
            
    }
    
}
