package wu;

import Connection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Klasa obslugujaca scene z planem zajec dla dziekanatu
 *
 * @author Teo
 */
public class Planzajec_dziekanatController implements Initializable {

     
    @FXML
    private TableView<Harmonogram> tableHarmonogramPracownik;
    @FXML
    private TableColumn<Harmonogram, String> columnIdprzedmiotuPracownik;
    @FXML
    private TableColumn<Harmonogram, String> columnIdpracownikaPracownik;
    @FXML
    private TableColumn<Harmonogram, String> columnDataPracownik;
    @FXML
    private TableColumn<Harmonogram, String> columnGodzinaPracownik;
    @FXML
    private TableColumn<Harmonogram, String> columnKierunekPracownik;
    @FXML
    private TableColumn<Harmonogram, Integer> columnRokPracownik;
    
    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Harmonogram> data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // select oceny pracownik
         data = FXCollections.observableArrayList();

        ConnectionClass PolaczenieDB2 = new ConnectionClass();

    Connection sesja2 = PolaczenieDB2.getConnection();
  

        try {

            //stmt = sesja.createStatement();

            ResultSet rs = sesja2.createStatement().executeQuery("SELECT id_harmonogramu as idHarmonogramu, nazwa_przedmiotu as idPrzedmiotu, CONCAT(imie_p,\" \",nazwisko_p) as idPracownika, data_zajec_h as Data , godzina_h as Godzina, kierunek , rok from harmonogram, pracownicy, przedmioty, specjalizacja_studenci where harmonogram.id_przedmiotu=przedmioty.id_przedmiotu AND harmonogram.id_pracownika=pracownicy.id_pracownika and harmonogram.id_specjalizacji=specjalizacja_studenci.id_specjalizacji and pracownicy.zalogowany_p='1';");
            ResultSet rs2 = sesja2.createStatement().executeQuery("SELECT id_harmonogramu as idHarmonogramu, nazwa_przedmiotu as idPrzedmiotu, CONCAT(imie_p,\" \",nazwisko_p) as idPracownika, data_zajec_h as Data , godzina_h as Godzina, kierunek , rok from harmonogram, pracownicy, przedmioty, specjalizacja_studenci where harmonogram.id_przedmiotu=przedmioty.id_przedmiotu AND harmonogram.id_pracownika=pracownicy.id_pracownika and harmonogram.id_specjalizacji=specjalizacja_studenci.id_specjalizacji and pracownicy.zalogowany_p='1';");
         
            //System.out.println("Dane:"+ rs.getString(2));
            while (rs2.next()) {
                System.out.println("1");
                 System.out.println( rs2.getString(2) + " " + rs2.getString(3));
                //data.add(new Harmonogram(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));

            }

            //columnIdharmonogramuAdmin.setCellValueFactory(new PropertyValueFactory<>("idHarmonogramu"));
            columnIdprzedmiotuPracownik.setCellValueFactory(new PropertyValueFactory<>("idPrzedmiotu"));
            columnIdpracownikaPracownik.setCellValueFactory(new PropertyValueFactory<>("idPracownika"));
            columnDataPracownik.setCellValueFactory(new PropertyValueFactory<>("Data"));
            columnGodzinaPracownik.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
            columnKierunekPracownik.setCellValueFactory(new PropertyValueFactory<>("kierunek"));
            columnRokPracownik.setCellValueFactory(new PropertyValueFactory<>("rok"));

            tableHarmonogramPracownik.setItems(null);
            tableHarmonogramPracownik.setItems(data);

            rs.close();
        } catch (Exception e) {

        }
        // koniec select oceny pracownik
        
    
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

    /**
     * Metoda odpowiedzialna za powrot do menu admina
     *
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
    
    @FXML
    private void comboDziekanatPrzedmiot(ActionEvent event) throws IOException {

    }
    
    @FXML
    private void comboDziekanatProwadzacy(ActionEvent event) throws IOException {

    }
    
    @FXML
    private void dataAdminBtn(ActionEvent event) throws IOException {

    }
    
    @FXML
    private void comboDziekanatGodzina(ActionEvent event) throws IOException {

    }
    
    @FXML
    private void comboDziekanatKiR(ActionEvent event) throws IOException {

    }

}
