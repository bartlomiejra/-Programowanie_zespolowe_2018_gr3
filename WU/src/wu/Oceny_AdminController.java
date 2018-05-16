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
 * Klasa obsługująca oceny, scena admina 
 *
 * @author Zbyszek
 */
public class Oceny_AdminController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    /**
     * Metoda powracająca do menu
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
      * Metoda wylogowująca
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
     * Metoda wyłączająca program
     * @param event
     * @throws IOException 
     */
     @FXML
    private void close_usersButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    /**
     * Metoda generująca pdf
     * @param event
     * @throws IOException 
     */
     @FXML
    private void generate_wykladowcaButtonAction(ActionEvent event) throws IOException {

    }
    
    /**
     * Metoda wyszukująca użytkowników
     * @param event
     * @throws IOException 
     */
    @FXML
    private void search_usersButtonAction(ActionEvent event) throws IOException{
        
    }
    
    /**
     * Metoda ładująca użytkowników
     * @param event
     * @throws IOException 
     */
   @FXML
    private void load_usersButonAction(ActionEvent event) throws IOException{
        
    } 
    
    /**
     * Metoda czyszcząca pole
     * @param event
     * @throws IOException 
     */
   @FXML
    private void clear_usersButtonAction(ActionEvent event) throws IOException{
        
    }  
    
    /**
     * Medoda usuwająca pole
     * @param event
     * @throws IOException 
     */
    @FXML
    private void delete_wykładowcaButtonAction(ActionEvent event) throws IOException{
        
    }  
    
    /**
     * Metoda edytująca pole
     * @param event
     * @throws IOException 
     */
     @FXML
    private void edit_wykladowcaButtonAction(ActionEvent event) throws IOException{
        
    }  
    
    /**
     * Metoda dodająca pole
     * @param event
     * @throws IOException 
     */
     @FXML
    private void add_wykladowcaButtonAction(ActionEvent event) throws IOException{
        
    }  
    
}
