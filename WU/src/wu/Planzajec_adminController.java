package wu;

import Connection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

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
    private ComboBox<Przedmioty> cAPrzedmiot;
    @FXML
    private ComboBox<Pracownicy> cIPracownik;
    @FXML
    private ComboBox cGAdmin;
    @FXML
    private ComboBox<Specjalizacja> cISpec;
    @FXML
    private DatePicker dataAdmin;

    ObservableList<Pracownicy> dataPracownicy;
    ObservableList<Przedmioty> dataPrzedmioty;
    ObservableList<Specjalizacja> dataSpecjalizacja;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // combox godziny
        cGAdmin.getItems().addAll(
                "00:00",
                "00:30",
                "01:00",
                "01:30",
                "02:00",
                "02:30",
                "03:00",
                "03:30",
                "04:00",
                "04:30",
                "05:00",
                "05:30",
                "06:00",
                "06:30",
                "07:00",
                "07:30",
                "08:00",
                "08:30",
                "09:00",
                "09:30",
                "10:00",
                "10:30",
                "11:00",
                "11:30",
                "12:00",
                "12:30",
                "13:00",
                "13:30",
                "14:00",
                "14:30",
                "15:00",
                "15:30",
                "16:00",
                "16:30",
                "17:00",
                "17:30",
                "18:00",
                "18:30",
                "19:00",
                "19:30",
                "20:00",
                "20:30",
                "21:00",
                "21:30",
                "22:00",
                "22:30",
                "23:00",
                "23:30"
        );
        dataPracownicy = FXCollections.observableArrayList();
        dataPrzedmioty = FXCollections.observableArrayList();
        dataSpecjalizacja = FXCollections.observableArrayList();

        data = FXCollections.observableArrayList();

        Statement stmt = null;

        try {

            stmt = sesja.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT id_harmonogramu as idHarmonogramu, nazwa_przedmiotu as idPrzedmiotu, CONCAT(imie_p,\" \",nazwisko_p) as idPracownika, data_zajec_h as Data , godzina_h as Godzina, kierunek , rok from harmonogram, pracownicy, przedmioty, specjalizacja_studenci where harmonogram.id_przedmiotu=przedmioty.id_przedmiotu AND harmonogram.id_pracownika=pracownicy.id_pracownika and harmonogram.id_specjalizacji=specjalizacja_studenci.id_specjalizacji;");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {

                data.add(new Harmonogram(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));

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
        // wyswietlanie combox pracownicy

        Statement stmt2 = null;

        try {

            stmt2 = sesja.createStatement();

            ResultSet rs = stmt2.executeQuery("SELECT * from pracownicy;");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {

                dataPracownicy.add(new Pracownicy(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }

        } catch (Exception e) {

        }

        cIPracownik.setItems(null);
        cIPracownik.setItems(dataPracownicy);

        cIPracownik.setCellFactory(new Callback<ListView<Pracownicy>, ListCell<Pracownicy>>() {

            @Override
            public ListCell<Pracownicy> call(ListView<Pracownicy> p) {

                final ListCell<Pracownicy> cell = new ListCell<Pracownicy>() {

                    @Override
                    protected void updateItem(Pracownicy t, boolean bln) {
                        super.updateItem(t, bln);

                        if (t != null) {
                            setText(t.getimie_p() + " " + t.getnazwisko_p());
                        } else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        });

        cIPracownik.setConverter(new StringConverter<Pracownicy>() {
            @Override
            public String toString(Pracownicy object) {
                if (object == null) {
                    return "";
                } else {
                    return object.getimie_p() + " " + object.getnazwisko_p();
                }
            }

            @Override
            public Pracownicy fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        //KONIEC pracownicy
        // wyswietlanie combox przedmioty
        Statement stmt3 = null;

        try {

            stmt3 = sesja.createStatement();

            ResultSet rs = stmt3.executeQuery("SELECT * from przedmioty;");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {

                dataPrzedmioty.add(new Przedmioty(rs.getInt(1), rs.getString(2)));

            }

        } catch (Exception e) {

        }

        cAPrzedmiot.setItems(null);
        cAPrzedmiot.setItems(dataPrzedmioty);

        cAPrzedmiot.setCellFactory(new Callback<ListView<Przedmioty>, ListCell<Przedmioty>>() {

            @Override
            public ListCell<Przedmioty> call(ListView<Przedmioty> p) {

                final ListCell<Przedmioty> cell = new ListCell<Przedmioty>() {

                    @Override
                    protected void updateItem(Przedmioty t, boolean bln) {
                        super.updateItem(t, bln);

                        if (t != null) {
                            setText(t.getnazwa_przedmiotu());
                        } else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        });

        cAPrzedmiot.setConverter(new StringConverter<Przedmioty>() {
            @Override
            public String toString(Przedmioty object) {
                if (object == null) {
                    return "";
                } else {
                    return object.getnazwa_przedmiotu();
                }
            }

            @Override
            public Przedmioty fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        //KONIEC przedmioty
        // wyswietlanie combox specjalizacja
        Statement stmt4 = null;

        try {

            stmt4 = sesja.createStatement();

            ResultSet rs = stmt4.executeQuery("SELECT id_specjalizacji,kierunek,rok from specjalizacja_studenci;");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {

                dataSpecjalizacja.add(new Specjalizacja(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }

        } catch (Exception e) {

        }

        cISpec.setItems(null);
        cISpec.setItems(dataSpecjalizacja);

        cISpec.setCellFactory(new Callback<ListView<Specjalizacja>, ListCell<Specjalizacja>>() {

            @Override
            public ListCell<Specjalizacja> call(ListView<Specjalizacja> p) {

                final ListCell<Specjalizacja> cell = new ListCell<Specjalizacja>() {

                    @Override
                    protected void updateItem(Specjalizacja t, boolean bln) {
                        super.updateItem(t, bln);

                        if (t != null) {
                            setText(t.getkierunek() + " - " + t.getrok() + " rok");
                        } else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        });

        cISpec.setConverter(new StringConverter<Specjalizacja>() {
            @Override
            public String toString(Specjalizacja object) {
                if (object == null) {
                    return "";
                } else {
                    return object.getkierunek() + " - " + object.getrok() + " rok";
                }
            }

            @Override
            public Specjalizacja fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        //KONIEC specjalizacja
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
            LocalDate value = dataAdmin.getValue();
            stmt.executeUpdate("INSERT INTO `harmonogram` (`id_harmonogramu`, `id_przedmiotu`, `id_pracownika`, `data_zajec_h`, `godzina_h`, `id_specjalizacji`) VALUES (null,'" + cAPrzedmiot.getSelectionModel().getSelectedItem().getid_przedmiotu() + "','" + cIPracownik.getSelectionModel().getSelectedItem().getid_pracownika() + "','" + value + "','" + cGAdmin.getSelectionModel().getSelectedItem().toString() + "','" + cISpec.getSelectionModel().getSelectedItem().getid_specjalizacji() + "');");

            Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Planzajec_admin.fxml"));
            Scene assessment_page_scene = new Scene(assessment_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(assessment_page_scene);
            app_stage.show();
            // cIPracownik.getSelectionModel().getSelectedItem().getid_pracownika()
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
    private void delete_wykładowcaButtonAction(ActionEvent event) throws IOException, SQLException {

        int id = (tableHarmonogramAdmin.getSelectionModel().getSelectedItem().getidHarmonogramu());

        try {

            PreparedStatement statement = sesja.prepareStatement("DELETE FROM harmonogram WHERE id_harmonogramu = ?");
            statement.setInt(1, id);
            statement.executeUpdate();

            Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Planzajec_admin.fxml"));
            Scene assessment_page_scene = new Scene(assessment_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(assessment_page_scene);
            app_stage.show();
        } catch (Exception e) {

        }

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
