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
 * Klasa odpowiedzialna za oblusge sceny z uzytkownikami dla administratora
 * @author Teo
 */
public class usersCRUD_DziekanatwindowController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    /**
     * metoda odpowiedzialna za wylogowanie i przejscie do okna logowania
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
     * metoda odpowiedzalna za zamknięcie aplikacji
     * @param event
     * @throws IOException 
     */
    @FXML
    private void close_adminButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    /**
     * nnetoda odpowiedzialna za za przejscie do okna admina
     * @param event
     * @throws IOException 
     */
    @FXML
    private void usersDziekanatMenuActionButton (ActionEvent event) throws IOException {
        
        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("Admin_window.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();
        
    }
    
    @FXML
    private void delete_usersDButtonAction(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void add_usersDButtonAction(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void edit_usersDButtonAction(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void delete_usersButtonActionPrac(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void add_usersButtonActionPrac(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void edit_usersButtonActionPrac(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void search_usersDButtonAction(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void load_usersDButonAction(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void clear_usersDButtonAction(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void search_usersButtonActionPrac(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void load_usersButonActionPrac(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void clear_usersButtonActionPrac(ActionEvent event) throws IOException {
        
    }
    
    
    
    
    
}
