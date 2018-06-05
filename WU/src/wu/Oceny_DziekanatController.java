package wu;

import Connection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Klasa odpowiedzialna za wyswietlenie okna Oceny_Dziekanat
 *
 * @author Teo
 */
public class Oceny_DziekanatController implements Initializable {

    
      @FXML
    private TableView<Oceny> table_oceny;
    @FXML
    private TableColumn<Oceny, String> columnProwadzacy;
    @FXML
    private TableColumn<Oceny, String> columnPrzedmiot;
    @FXML
    private TableColumn<Oceny, Integer> columnOcena;
    @FXML
    private TableColumn<Oceny, String> columnStudent;
    
    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Oceny> data;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    data = FXCollections.observableArrayList();
        
        Statement stmt = null;

        try {

            stmt = sesja.createStatement();

            ResultSet rs = stmt.executeQuery("Select CONCAT(imie_s,\" \",nazwisko_s) as student,CONCAT(imie_p,\" \",nazwisko_p) as prowadzacy ,ocena, nazwa_przedmiotu from oceny,pracownicy,przedmioty,studenci where oceny.id_przedmiotu=przedmioty.id_przedmiotu and oceny.id_studenta=studenci.id_studenta and oceny.id_pracownika=pracownicy.id_pracownika;");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {
               // data.add(new Oceny(rs.getInt(3), rs.getString(4), rs.getString(1), rs.getString(2)));

            }

            columnStudent.setCellValueFactory(new PropertyValueFactory<>("student"));
            columnOcena.setCellValueFactory(new PropertyValueFactory<>("ocena"));
            columnPrzedmiot.setCellValueFactory(new PropertyValueFactory<>("nazwa_przedmiotu"));
            columnProwadzacy.setCellValueFactory(new PropertyValueFactory<>("prowadzacy"));
            table_oceny.setItems(null);
            table_oceny.setItems(data);

        } catch (Exception e) {

        }
        
        
    } 
    
    /**
     * Metoda odpowiedzialna za ładowanie sceny z oknem dziekanatu
     * @param event
     * @throws IOException 
     */
    @FXML
     private void assesmentDziekanat_menuActionButton(ActionEvent event) throws IOException {
    
        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Dziekanat_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();        
     }
     
     /**
      * Metoda odpowiedzialna za ładowanie sceny Login_window 
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
     * Metoda odpowiedzialna za generowanie pdf dla dziekanatu 
     * @param event
     * @throws IOException 
     */
     @FXML
    private void generate_dziekanatButtonAction(ActionEvent event) throws IOException {
            
    }
    
    /**
     * Metoda odpowiedzialna za dodanie oceny do bazy
     * @param event
     * @throws IOException 
     */
     @FXML
    private void add_dziekanatButtonAction(ActionEvent event) throws IOException {
            
    }
    
    /**
     * Metoda odpowiedzialna za edycje oceny w oknie Dziekanat
     * @param event
     * @throws IOException 
     */
    @FXML
    private void edit_dziekanatButtonAction(ActionEvent event) throws IOException {
            
    }
    
    /**
     * Metoda odpowiedzialna za usuniecie oceny z bazy w oknie Dziekanatu 
     * @param event
     * @throws IOException 
     */ 
    @FXML
    private void delete_dziekanatButtonAction(ActionEvent event) throws IOException {
            
    }
    
    @FXML
    private void add_ocenaDziekanatBtn(ActionEvent event) throws IOException {
            
    }
    
    @FXML
    private void edit_ocenaDziekanatBtn(ActionEvent event) throws IOException {
            
    }
    
    @FXML
    private void delete_ocenaDziekanatBtn(ActionEvent event) throws IOException {
            
    }
    
    @FXML
    private void comboPDziekanatBtn(ActionEvent event) throws IOException {
            
    }
    
    @FXML
    private void comboPrzDziekanatBtn(ActionEvent event) throws IOException {
            
    }
    
    @FXML
    private void comboODziekanatBtn(ActionEvent event) throws IOException {
            
    }
    
    @FXML
    private void comboSDziekanatBtn(ActionEvent event) throws IOException {
            
    }
       
}
