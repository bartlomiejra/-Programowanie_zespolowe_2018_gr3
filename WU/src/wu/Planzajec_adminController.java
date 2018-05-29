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
 * Klasa obslugujaca dzialanie sceny z planem zajec dla administratora
 *
 * @author Teo
 */
public class Planzajec_adminController implements Initializable {

    @FXML
    private TableView<Harmonogram> tableHarmonogramAdmin;
    @FXML
    private TableColumn<Harmonogram, Integer> columnIdharmonogramuAdmin;
    @FXML
    private TableColumn<Harmonogram, String> columnIdprzedmiotuAdmin;
    @FXML
    private TableColumn<Harmonogram, String> columnIdpracownikaAdmin;
    @FXML
    private TableColumn<Harmonogram, String> columnDataAdmin;
    @FXML
    private TableColumn<Harmonogram, String> columnGodzinaAdmin;

    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Harmonogram> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        data = FXCollections.observableArrayList();
        
        Statement stmt = null;

        try {

            stmt = sesja.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT id_harmonogramu,  nazwa_przedmiotu as idPrzedmiotu, CONCAT(imie_p,\" \",nazwisko_p) as idPracownika, data_zajec_h, godzina_h "
                    + "from harmonogram, pracownicy, przedmioty"
                    + " where harmonogram.id_przedmiotu=przedmioty.id_przedmiotu and harmonogram.id_pracownika=pracownicy.id_pracownika ;");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {
                data.add(new Harmonogram(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5)));

            }

            columnIdharmonogramuAdmin.setCellValueFactory(new PropertyValueFactory<>("idHarmonogramu"));
            columnIdprzedmiotuAdmin.setCellValueFactory(new PropertyValueFactory<>("idPrzedmiotu"));
            columnIdpracownikaAdmin.setCellValueFactory(new PropertyValueFactory<>("idPracownika"));
            columnDataAdmin.setCellValueFactory(new PropertyValueFactory<>("Data"));
            columnGodzinaAdmin.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
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
