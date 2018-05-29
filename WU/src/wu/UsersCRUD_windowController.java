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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Klasa odpowiadajaca za wyswietlenie
 *
 * @author Teo
 */
public class UsersCRUD_windowController implements Initializable {
    // buttony dopowiedzialne za obsługę cześci seeny dotyczącej studentów

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

    // buttony dopowiedzialne za obsługę cześci seeny dotyczącej pracowników
    @FXML
    private Button add_usersp;
    @FXML
    private Button edit_usersp;
    @FXML
    private Button delete_usersp;
    @FXML
    private Button search_usersp;
    @FXML
    private Button load_usersp;
    @FXML
    private Button clear_usersp;
    @FXML
    private TextField tf_Imie;
    @FXML
    private TextField tf_Nazwisko;
    @FXML
    private TextField tf_Pesel;
    @FXML
    private TextField tf_Email;
    @FXML
    private DatePicker data_urodzenia;
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
    private Button close_admin;
    @FXML
    private Button logout_admin;
    @FXML
    private Button usersMenu;
    @FXML
    private TextField tf_Numer_tel;
    @FXML
    private TextField tf_login;
    @FXML
    private TextField tf_haslo;
    @FXML
    private TextField tf_allbumu;
    @FXML
    private TableView<?> table_pracownicy;
    @FXML
    private TextField tf_Imie_p;
    @FXML
    private TextField tf_nazwisko_p;
    @FXML
    private TextField tf_pesel_p;
    @FXML
    private TextField tf_email_p;
    @FXML
    private TextField tf_haslo_p;
    @FXML
    private TextField tf_NumerTel_p;
    @FXML
    private TextField tf_login_p;
    @FXML
    private DatePicker data_ur_p;
    @FXML
    private TextField tf_specjalizacja_p;
    @FXML
    private TableColumn<Student, String> columnDataUrStudent;

    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Student> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        data = FXCollections.observableArrayList();
        Statement stmt = null;

        try {

            stmt = sesja.createStatement();
            ResultSet rs = stmt.executeQuery("select imie_s , nazwisko_s, pesel_s, email_s, data_urodzenia_s, nr_tel_s, login_s, haslo_s, nr_albumu_s from studenci;");
            while (rs.next()) {
                data.add(new Student(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getString(7), rs.getString(8), rs.getString(9)));

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
    }

    /**
     * Metoda odpowiedzialna za przejscie do okna administratora
     *
     * @param event
     * @throws IOException
     */
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
     * metoda odpowiedzalna za wylogowanie uzytkownika
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
     * metoda odpowiedzalna za dodawanie uzytkowników
     *
     * @param event
     */
    @FXML
    private void add_usersButtonAction(ActionEvent event) {

    }

    /**
     * metoda odpowiedzalna za edycje użytkowników
     *
     * @param event
     */
    @FXML
    private void edit_usersButtonAction(ActionEvent event) {

    }

    /**
     * metoda odpowiedzalna za usuwanie użytkowników
     *
     * @param event
     */
    @FXML
    private void delete_usersButtonAction(ActionEvent event) {

    }

    /**
     * metoda odpowiedzalna za wyszukiwanie uzytkowników
     *
     * @param event
     */
    @FXML
    private void search_usersButtonAction(ActionEvent event) {

    }

    /**
     * metoda ładowanie bazych danych z listą użytkowników
     *
     * @param event
     */
    @FXML
    private void load_usersButonAction(ActionEvent event) {

    }

    /**
     * czyszczenie okna wyników
     *
     * @param event
     */
    @FXML
    private void clear_usersButtonAction(ActionEvent event) {

    }

}
