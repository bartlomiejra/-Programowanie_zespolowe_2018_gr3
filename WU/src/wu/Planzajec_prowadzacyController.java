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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Klasa odpowiedzialna za obsluge sceny z planem zajec dla prowadzacego
 *
 * @author Teo
 */
public class Planzajec_prowadzacyController implements Initializable {

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
    @FXML
    private TextField tfSzukaj;

    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Harmonogram> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //wyswietlanie select plan zajec
        data = FXCollections.observableArrayList();

        Statement stmt = null;

        try {

            stmt = sesja.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT id_harmonogramu as idHarmonogramu, nazwa_przedmiotu as idPrzedmiotu, CONCAT(imie_p,\" \",nazwisko_p) as idPracownika, data_zajec_h as Data , godzina_h as Godzina, kierunek , rok from harmonogram, pracownicy, przedmioty, specjalizacja_studenci where harmonogram.id_przedmiotu=przedmioty.id_przedmiotu AND harmonogram.id_pracownika=pracownicy.id_pracownika and harmonogram.id_specjalizacji=specjalizacja_studenci.id_specjalizacji and pracownicy.zalogowany_p='1';");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {

                data.add(new Harmonogram(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));

            }

            //columnIdharmonogramuAdmin.setCellValueFactory(new PropertyValueFactory<>("idHarmonogramu"));
            columnIdprzedmiotuPracownik.setCellValueFactory(new PropertyValueFactory<>("idPrzedmiotu"));
            // columnIdpracownikaPracownik.setCellValueFactory(new PropertyValueFactory<>("idPracownika"));
            columnDataPracownik.setCellValueFactory(new PropertyValueFactory<>("Data"));
            columnGodzinaPracownik.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
            columnKierunekPracownik.setCellValueFactory(new PropertyValueFactory<>("kierunek"));
            columnRokPracownik.setCellValueFactory(new PropertyValueFactory<>("rok"));

            tableHarmonogramPracownik.setItems(null);
            tableHarmonogramPracownik.setItems(data);

        } catch (Exception e) {

        }

        // koniec wyswietlania select wykladowca
    }

    /**
     * Metoda odpowiedzialna za przejscie do okna z menu prowadzacego
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void schedulePMenuActionButton(ActionEvent event) throws IOException {

        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Prowadzacy_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();
    }

    /**
     * Metoda odpowiedzialna za wylogowanie uzytkownika i przejscie do sceny
     * logowania
     *
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
     * Metoda odpowiedzialna za zamkniecie aplikacji
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void close_adminButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }

}
