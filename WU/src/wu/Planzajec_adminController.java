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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Klasa obslugujaca dzialanie sceny z planem zajec dla administratora
 *
 * @author Teo
 */
public class Planzajec_adminController implements Initializable {

    @FXML
    private TableView<Harmonogram> tableHarmonogramAdmin;
    @FXML
    private TableColumn<Harmonogram, String> columnIdprzedmiotuAdmin;
    @FXML
    private TableColumn<Harmonogram, String> columnIdpracownikaAdmin;
    @FXML
    private TableColumn<Harmonogram, String> columnDataAdmin;
    @FXML
    private TableColumn<Harmonogram, String> columnGodzinaAdmin;
    @FXML
    private TableColumn<Harmonogram, String> columnKierunekAdmin;
    @FXML
    private TableColumn<Harmonogram, Integer> columnRokAdmin;

    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Harmonogram> data;
    @FXML
    private Button assesment_menu;
    @FXML
    private Button assesment_logout;
    @FXML
    private Button close_users;
    @FXML
    private Button add_wykladowca;
    @FXML
    private Button edit_wykladowca;
    @FXML
    private Button delete_wykładowca;
    @FXML
    private Button search_users;
    @FXML
    private Button load_users;
    @FXML
    private Button clear_users;
    @FXML
    private TextField PrzedmiotUpdate;
    @FXML
    private TextField ProwadzacyUpdate;
    @FXML
    private TextField DataUpdate;
    @FXML
    private TextField GodzinaUpdate;
    @FXML
    private TextField KierunekUpdate;
    @FXML
    private TextField RokUpdate;
    @FXML
    private ComboBox cAPrzedmiot;
    @FXML
    private ComboBox cIPracownik;
    @FXML
    private ComboBox cGAdmin;
    @FXML
    private ComboBox cISpec;
    @FXML
    private DatePicker dataAdmin;
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        data = FXCollections.observableArrayList();
        
        Statement stmt = null;

        try {

            stmt = sesja.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT id_harmonogramu as idHarmonogramu, nazwa_przedmiotu as idPrzedmiotu, CONCAT(imie_p,\" \",nazwisko_p) as idPracownika, data_zajec_h as Data , godzina_h as Godzina, kierunek , rok from harmonogram, pracownicy, przedmioty, specjalizacja_studenci where harmonogram.id_przedmiotu=przedmioty.id_przedmiotu AND harmonogram.id_pracownika=pracownicy.id_pracownika and harmonogram.id_specjalizacji=specjalizacja_studenci.id_specjalizacji;");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {
                
                data.add(new Harmonogram(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6),rs.getInt(7)));

            }

            //columnIdharmonogramuAdmin.setCellValueFactory(new PropertyValueFactory<>("idHarmonogramu"));
            columnIdprzedmiotuAdmin.setCellValueFactory(new PropertyValueFactory<>("idPrzedmiotu"));
            columnIdpracownikaAdmin.setCellValueFactory(new PropertyValueFactory<>("idPracownika"));
            columnDataAdmin.setCellValueFactory(new PropertyValueFactory<>("Data"));
            columnGodzinaAdmin.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
            columnKierunekAdmin.setCellValueFactory(new PropertyValueFactory<>("kierunek"));
            columnRokAdmin.setCellValueFactory(new PropertyValueFactory<>("rok"));
            
            tableHarmonogramAdmin.setItems(null);
            tableHarmonogramAdmin.setItems(data);

           
        } catch (Exception e) {

        }

    }

    /**
     * Metoda edytujaca
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void edit_wykladowcaButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * Metoda dodajaca
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void add_wykladowcaButtonAction(ActionEvent event) throws IOException {
        
        
        
        Statement stmt = null;

        try {

            stmt = sesja.createStatement();

            stmt.executeUpdate("INSERT INTO `przedmioty` (`id_przedmiotu`, `nazwa_przedmiotu`) VALUES (null,'"+PrzedmiotUpdate.getText()+"');");
            

          

           
        } catch (Exception e) {

        }
    }

    /**
     * Metoda usuwajaca
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void delete_wykładowcaButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * Meotda szukajaca
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void search_usersButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * Metoda ladujaca
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void load_usersButonAction(ActionEvent event) throws IOException {

    }

    /**
     * Metoda czyszczaca
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void clear_usersButtonAction(ActionEvent event) throws IOException {

    }
    
    @FXML
    private void comboAdminPrzedmiot(ActionEvent event) throws IOException {

    }
    
    @FXML
    private void comboAdminPracownik(ActionEvent event) throws IOException {

    }
    
    @FXML
    private void comboAdminGodziny(ActionEvent event) throws IOException {

    }
    
    @FXML
    private void comboAdminSpec(ActionEvent event) throws IOException {

    }
    
    @FXML
    private void dataAdmin(ActionEvent event) throws IOException {

    }

    /**
     * Metoda odpowiedzialna za powrot do menu admina
     *
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
     *
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
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void close_usersButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }

}
