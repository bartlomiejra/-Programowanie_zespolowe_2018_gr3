/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * FXML Controller class
 *
 * @author Teo
 */
public class UsersCRUD_windowController implements Initializable {
    
    @FXML
    private Button close_users;
    
    @FXML
    private Button assesment_logout;
    @FXML
    private Button assesment_menu;
    @FXML
    private Button add_users;
    @FXML
    private Button edit_users;
    @FXML
    private Button delete_users;
    @FXML
    private Button search_users;
    @FXML
    private Button load_users;
    @FXML
    private Button clear_users;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     /**
      * metoda pzowalające na przejście do okna menu Admina
      * @param event
      * @throws IOException 
      */
    @FXML
    private void usersMenuActionButton(ActionEvent event) throws IOException {

        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Admin_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();
    }
    /**
     * metoda odpowiedzalna za wylogowanie uzytkownika
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
     * metoda odpowiedzalna za dodawanie uzytkowników
     * @param event 
     */
    @FXML
    private void add_usersButtonAction(ActionEvent event) {
    }
    /**
     * metoda odpowiedzalna za edycja użytkowników
     * @param event 
     */
    @FXML
    private void edit_usersButtonAction(ActionEvent event) {
    }
    /**
     * metoda odpowiedzalna za usuwanie użytkowników
     * @param event 
     */
    @FXML
    private void delete_usersButtonAction(ActionEvent event) {
    }
    /**
     *  metoda odpowiedzalna za wyszukiwanie uzytkowników
     * @param event 
     */
    @FXML
    private void search_usersButtonAction(ActionEvent event) {
    }
    /**
     * metoda ładowanie bazych danych z listą użytkowników
     * @param event 
     */
    @FXML
    private void load_usersButonAction(ActionEvent event) {
    }
    /**
     * czyszczenie okna wyników
     * @param event 
     */
    @FXML
    private void clear_usersButtonAction(ActionEvent event) {
    }
    
}
