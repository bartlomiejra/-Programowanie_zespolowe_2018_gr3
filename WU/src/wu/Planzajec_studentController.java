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
 * Klasa obslugujaca dzialanie planu zajec dla studenta
 *
 * @author Teo
 */
public class Planzajec_studentController implements Initializable {

    
     @FXML
    private TableView<Harmonogram> tableHarmonogramStudent;
    @FXML
    private TableColumn<Harmonogram, String> columnIdprzedmiotuStudent;
    @FXML
    private TableColumn<Harmonogram, String> columnIdpracownikaStudent;
    @FXML
    private TableColumn<Harmonogram, String> columnDataStudent;
    @FXML
    private TableColumn<Harmonogram, String> columnGodzinaStudent;
    
    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Harmonogram> data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     // Harmonogram student select
     
     data = FXCollections.observableArrayList();

        Statement stmt = null;

        try {

            stmt = sesja.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT id_harmonogramu as idHarmonogramu, nazwa_przedmiotu as idPrzedmiotu, CONCAT(imie_p,\" \",nazwisko_p) as idPracownika, data_zajec_h as Data , godzina_h as Godzina, kierunek , rok from studenci, harmonogram, pracownicy, przedmioty, specjalizacja_studenci where harmonogram.id_przedmiotu=przedmioty.id_przedmiotu AND harmonogram.id_pracownika=pracownicy.id_pracownika and harmonogram.id_specjalizacji=specjalizacja_studenci.id_specjalizacji and specjalizacja_studenci.id_studenta = studenci.id_studenta and studenci.zalogowany_s='1' GROUP BY id_harmonogramu;");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {

                data.add(new Harmonogram(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));

            }

            //columnIdharmonogramuAdmin.setCellValueFactory(new PropertyValueFactory<>("idHarmonogramu"));
            columnIdprzedmiotuStudent.setCellValueFactory(new PropertyValueFactory<>("idPrzedmiotu"));
            columnIdpracownikaStudent.setCellValueFactory(new PropertyValueFactory<>("idPracownika"));
            columnDataStudent.setCellValueFactory(new PropertyValueFactory<>("Data"));
            columnGodzinaStudent.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
            //columnKierunekAdmin.setCellValueFactory(new PropertyValueFactory<>("kierunek"));
            //columnRokAdmin.setCellValueFactory(new PropertyValueFactory<>("rok"));

            tableHarmonogramStudent.setItems(null);
            tableHarmonogramStudent.setItems(data);

        } catch (Exception e) {

        }
        
        // koniec harmonogram student select
        
        
    }  
    
   /**
    * Metoda odpowiedzialna za przejscie do sceny z menu studenta
    * @param event
    * @throws IOException 
    */
    @FXML
    private void scheduleSMenuActionButton(ActionEvent event) throws IOException {

        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Student_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();
    }
    
    /**
     * metoda odpowiedzalna za wylogowanie studenta
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
    
}
