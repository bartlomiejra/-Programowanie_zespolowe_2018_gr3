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
 * Klasa odpowiedzialna za oblusge sceny z uzytkownikami dla administratora
 *
 * @author Teo
 */
public class usersCRUD_DziekanatwindowController implements Initializable {

    @FXML
    private TableView<Student> table_student;
    @FXML
    private TableColumn<Student, String> columnImieStudent;
    @FXML
    private TableColumn<Student, String> columntNazwiskoStudent;
    @FXML
    private TableColumn<Student, String> columnPeselStudent;
    @FXML
    private TableColumn<Student, String> ColumnEmailStudent;
    @FXML
    private TableColumn<Student, String> ColumnDataurodzeniaStudent;
    @FXML
    private TableColumn<Student, String> ColumnNrtelStudent;
    @FXML
    private TableColumn<Student, String> ColumnLoginStudent;
    @FXML
    private TableColumn<Student, String> ColumnHasloStudent;
    @FXML
    private TableColumn<Student, String> ColumnAlbumStudent;
    @FXML
    private TableView<Pracownicy> table_pracownik;
    @FXML
    private TableColumn<Pracownicy, String> columnImiePracownik;
    @FXML
    private TableColumn<Pracownicy, String> columntNazwiskoPracownik;
    @FXML
    private TableColumn<Pracownicy, String> columnPeselPracownik;
    @FXML
    private TableColumn<Pracownicy, String> ColumnEmailPracownik;
    @FXML
    private TableColumn<Pracownicy, String> ColumnDataurodzeniaPracownik;
    @FXML
    private TableColumn<Pracownicy, String> ColumnNrtelPracownik;
    @FXML
    private TableColumn<Pracownicy, String> ColumnLoginPracownik;
    @FXML
    private TableColumn<Pracownicy, String> ColumnHasloPracownik;
    @FXML
    private TableColumn<Pracownicy, String> Columnspecjalizacja_pPracownik;

    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Student> data;
    private ObservableList<Pracownicy> data1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        data = FXCollections.observableArrayList();
        Statement stmt = null;

        try {

            stmt = sesja.createStatement();
            ResultSet rs = stmt.executeQuery("select imie_s , nazwisko_s, pesel_s, email_s, data_urodzenia_s, nr_tel_s, login_s, haslo_s, nr_albumu_s from studenci;");
            while (rs.next()) {
               // data.add(new Student(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9)));

            }
            System.out.println(rs);
            columnImieStudent.setCellValueFactory(new PropertyValueFactory<>("imie_s"));
            columntNazwiskoStudent.setCellValueFactory(new PropertyValueFactory<>("nazwisko_s"));
            columnPeselStudent.setCellValueFactory(new PropertyValueFactory<>("pesel_s"));
            ColumnEmailStudent.setCellValueFactory(new PropertyValueFactory<>("email_s"));
            ColumnDataurodzeniaStudent.setCellValueFactory(new PropertyValueFactory<>("data_urodzenia_s"));
            ColumnNrtelStudent.setCellValueFactory(new PropertyValueFactory<>("nr_tel_s"));
            ColumnLoginStudent.setCellValueFactory(new PropertyValueFactory<>("login_s"));
            ColumnHasloStudent.setCellValueFactory(new PropertyValueFactory<>("haslo_s"));
            ColumnAlbumStudent.setCellValueFactory(new PropertyValueFactory<>("nr_albumu_s"));

            table_student.setItems(null);
            table_student.setItems(data);

        } catch (Exception e) {

        }

        data1 = FXCollections.observableArrayList();
        Statement stmt1 = null;

        try {

            stmt1 = sesja.createStatement();
            ResultSet rs = stmt1.executeQuery("select imie_p , nazwisko_p, pesel_p, email_p, data_urodzenia_p, nr_tel_p, login_p, haslo_p,specjalizacja_p from pracownicy;");
            while (rs.next()) {
                data1.add(new Pracownicy(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9)));

            }
            System.out.println(rs);
            columnImiePracownik.setCellValueFactory(new PropertyValueFactory<>("imie_p"));
            columntNazwiskoPracownik.setCellValueFactory(new PropertyValueFactory<>("nazwisko_p"));
            columnPeselPracownik.setCellValueFactory(new PropertyValueFactory<>("pesel_p"));
            ColumnEmailPracownik.setCellValueFactory(new PropertyValueFactory<>("email_p"));
            ColumnDataurodzeniaPracownik.setCellValueFactory(new PropertyValueFactory<>("data_urodzenia_p"));
            ColumnNrtelPracownik.setCellValueFactory(new PropertyValueFactory<>("nr_tel_p"));
            ColumnLoginPracownik.setCellValueFactory(new PropertyValueFactory<>("login_p"));
            ColumnHasloPracownik.setCellValueFactory(new PropertyValueFactory<>("haslo_p"));
            Columnspecjalizacja_pPracownik.setCellValueFactory(new PropertyValueFactory<>("specjalizacja_p"));

            table_pracownik.setItems(null);
            table_pracownik.setItems(data1);

        } catch (Exception e) {

        }

    }

    /**
     * metoda odpowiedzialna za wylogowanie i przejscie do okna logowania
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
     * metoda odpowiedzalna za zamknięcie aplikacji
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void close_adminButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }

    /**
     * nnetoda odpowiedzialna za za przejscie do okna dziekanatu
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void usersDziekanatMenuActionButton(ActionEvent event) throws IOException {

        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("Dziekanat_window.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();

    }

    /**
     * metoda usuwajaca uzytkownika
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void delete_usersDButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * metoda dodajaca uzytkownika
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void add_usersDButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * metoda edytujaca dane uzytkownika
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void edit_usersDButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * metoda usuwajaca pracownika
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void delete_usersButtonActionPrac(ActionEvent event) throws IOException {

    }

    /**
     * metoda dodajaca pracownika
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void add_usersButtonActionPrac(ActionEvent event) throws IOException {

    }

    /**
     * metoda edytujaca pracownika
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void edit_usersButtonActionPrac(ActionEvent event) throws IOException {

    }

    /**
     * metoda szukajaca pracownika
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void search_usersDButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * metoda ladujaca uzytkownikow
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void load_usersDButonAction(ActionEvent event) throws IOException {

    }

    /**
     * metoda czyszczaca okno
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void clear_usersDButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * metoda szukajaca pracownikow
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void search_usersButtonActionPrac(ActionEvent event) throws IOException {

    }

    /**
     * metoda ladujaca pracownikow
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void load_usersButonActionPrac(ActionEvent event) throws IOException {

    }

    /**
     * metoda czyszczaca okno
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void clear_usersButtonActionPrac(ActionEvent event) throws IOException {

    }

}
