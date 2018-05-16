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
 * Klasa odpowiadajaca za wyswietlenie 
 * @author Teo
 */
public class UsersCRUD_windowController implements Initializable {
<<<<<<< HEAD
    /**
     * Przycisk wykorzystane w scenie
     */
=======
    
>>>>>>> 1a79dd4062cce38ed1dbbb4e4c34376b8c1845d5
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
<<<<<<< HEAD
    /**
     * Metoda odpowiedzialna za przejscie do okna administratora
     * @param event
     * @throws IOException 
     */
=======
     /**
      * metoda pzowalające na przejście do okna menu Admina
      * @param event
      * @throws IOException 
      */
>>>>>>> 1a79dd4062cce38ed1dbbb4e4c34376b8c1845d5
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
<<<<<<< HEAD
     * Metoda odpowiedziala za przejscie do okna logowania
=======
     * metoda odpowiedzalna za wylogowanie uzytkownika
>>>>>>> 1a79dd4062cce38ed1dbbb4e4c34376b8c1845d5
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
<<<<<<< HEAD
     * Metoda odpowiedziala za zamkniecie programu
=======
     * metoda odpowiedzalna za zamknięcie aplikacji
>>>>>>> 1a79dd4062cce38ed1dbbb4e4c34376b8c1845d5
     * @param event
     * @throws IOException 
     */
    @FXML
    private void close_adminButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    /**
<<<<<<< HEAD
     * Metoda odpowiedzialna za dodanie uzytkownika
=======
     * metoda odpowiedzalna za dodawanie uzytkowników
>>>>>>> 1a79dd4062cce38ed1dbbb4e4c34376b8c1845d5
     * @param event 
     */
    @FXML
    private void add_usersButtonAction(ActionEvent event) {
    }
    /**
<<<<<<< HEAD
     * Metoda odpowiedzialna za edycje uzytkownia
=======
     * metoda odpowiedzalna za edycja użytkowników
>>>>>>> 1a79dd4062cce38ed1dbbb4e4c34376b8c1845d5
     * @param event 
     */
    @FXML
    private void edit_usersButtonAction(ActionEvent event) {
    }
    /**
<<<<<<< HEAD
     * Metoda odpowiedzialna za usuniecie uzytkownia
=======
     * metoda odpowiedzalna za usuwanie użytkowników
>>>>>>> 1a79dd4062cce38ed1dbbb4e4c34376b8c1845d5
     * @param event 
     */
    @FXML
    private void delete_usersButtonAction(ActionEvent event) {
    }
    /**
<<<<<<< HEAD
     * Metoda odpowiedzialna za wyszukiwanie uzytkownika
=======
     *  metoda odpowiedzalna za wyszukiwanie uzytkowników
>>>>>>> 1a79dd4062cce38ed1dbbb4e4c34376b8c1845d5
     * @param event 
     */
    @FXML
    private void search_usersButtonAction(ActionEvent event) {
    }
    /**
<<<<<<< HEAD
     * Metoda odpowiedzialna za wczytanie danych uzytkownika
=======
     * metoda ładowanie bazych danych z listą użytkowników
>>>>>>> 1a79dd4062cce38ed1dbbb4e4c34376b8c1845d5
     * @param event 
     */
    @FXML
    private void load_usersButonAction(ActionEvent event) {
    }
    /**
<<<<<<< HEAD
     * Metoda odpowiedzialna za wyczyszczenie danych z uzytkownika
=======
     * czyszczenie okna wyników
>>>>>>> 1a79dd4062cce38ed1dbbb4e4c34376b8c1845d5
     * @param event 
     */
    @FXML
    private void clear_usersButtonAction(ActionEvent event) {
    }
    
}
