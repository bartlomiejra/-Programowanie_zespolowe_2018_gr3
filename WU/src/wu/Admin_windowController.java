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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Klasa obslugujaca dzialanie okna z menu administratora
 *
 * @author Zbyszek
 */
public class Admin_windowController implements Initializable {


    /**
     * Przyciski, ktore wystepuja w tej scenie
     */
    @FXML
    private Button close_admin;
    @FXML
    private Button logout_admin;
    @FXML
    private Label users_name_admin;
    @FXML
    private Button assessment_admin;
    @FXML
    private Button schedule_admin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    /**
     * Metoda odpowiedzialna za ladowanie sceny z ocenami dla administratora i ukrycie sceny z menu administratora
     * @param event
     * @throws IOException 
     */
    @FXML
    private void assessment_adminButtonAction(ActionEvent event) throws IOException {

        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Oceny_Admin.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();
    }

    /**
     * Metoda, ktora zamyka program po nacisnieciu przycisku 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void close_adminButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    /**
     * Metoda odpowiedzialna za wylogowanie z danego konta i przejscie do okna logowania
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
     * Metoda odpowiedzialna za ladowanie sceny z uzytkownikami i ukrycie sceny z menu administratora
     * @param event
     * @throws IOException 
     */
    @FXML
    private void users_adminButtonAction(ActionEvent event) throws IOException {

        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("usersCRUD_Dziekanatwindow.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();
    }
    
    /**
     * Metoda odpowiedzialna za ladowanie sceny z historia logowania uzytkownikow i ukrycie sceny z menu administratora
     * @param event
     * @throws IOException 
     */
    @FXML
    private void logged_history_adminButtonAction(ActionEvent event) throws IOException {

        Parent logged_history_parent = FXMLLoader.load(getClass().getResource("loghistory_window.fxml"));
        Scene logged_history_scene = new Scene(logged_history_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logged_history_scene);
        app_stage.show();
    }
    
    /**
     * Metoda odpowiedzialna za ladowanie sceny z planem zajec i ukrycie sceny z menu administratora
     * @param event
     * @throws IOException 
     */
    @FXML
    private void schedule_adminButtonAction(ActionEvent event) throws IOException {

        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("Planzajec_admin.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();             
    }
}
