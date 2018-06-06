package wu;
 
import Connection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    @FXML 
    private Label id_label;
    @FXML 
    private Label imie_label;
    @FXML 
    private Label nazwisko_label;
    @FXML 
    private Label pesel_label;
    @FXML 
    private Label email_label;
    @FXML 
    private Label date_label;
    @FXML 
    private Label numer_label;
    @FXML 
    private Label login_label;
   
    @FXML 
    private Label kierunek_label;
    @FXML 
    private Label spec_label;
    @FXML 
    private Label rok_label;
    ConnectionClass PolaczenieDB = new ConnectionClass();
 
    Connection sesja = PolaczenieDB.getConnection();
    ObservableList<String> DaneList = FXCollections.observableArrayList();
 
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        
        Statement stmt = null;
 
        try {
            stmt = sesja.createStatement();
            ResultSet rs = stmt.executeQuery("select studenci.id_studenta, imie_s, nazwisko_s, pesel_s, email_s, data_urodzenia_s, nr_tel_s, login_s, haslo_s, nr_albumu_s, kierunek, rok from studenci, specjalizacja_studenci  where zalogowany_s='1' and studenci.id_studenta=specjalizacja_studenci.id_studenta");
 
            while (rs.next()) {
                
                imie_label.setText(rs.getString("imie_s"));
                nazwisko_label.setText(rs.getString("nazwisko_s"));
                pesel_label.setText(rs.getString("pesel_s"));
                email_label.setText(rs.getString("email_s"));
                date_label.setText(rs.getString("data_urodzenia_s"));
                numer_label.setText(rs.getString("nr_tel_s"));
                login_label.setText(rs.getString("login_s"));
                rok_label.setText(rs.getString("rok"));              
                kierunek_label.setText(rs.getString("kierunek"));
                
 
                
            }
 
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Personaldetals_windowController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 
        
        
        
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