package wu;

import Connection.ConnectionClass;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import generatorpdf.Raporty;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
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
 * Klasa obsługująca oceny, scena admina
 *
 * @author Zbyszek
 */
public class Oceny_AdminController implements Initializable {

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
    @FXML
    private Button generate_wykladowca;
    @FXML
    private Button assesment_menu;
    @FXML
    private Button assesment_logout;
    @FXML
    private Button close_users;
    @FXML
    private TextField tfProwadzacy;
    @FXML
    private TextField tfPrzedmiot;
    @FXML
    private TextField tfLiczba_godzin;
    @FXML
    private TextField tfOcena;
    @FXML
    private TextField tf_student;
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
    private ComboBox<Pracownicy> comboProwadzacy;
    @FXML
    private ComboBox<Przedmioty> comboPrzedmiot;
    @FXML
    private ComboBox comboOcena;
    @FXML
    private ComboBox<Student> comboStudent;

    ObservableList<Pracownicy> dataPracownicy;
    ObservableList<Przedmioty> dataPrzedmioty;
    ObservableList<Student> dataStudent;

    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Oceny> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // combox oceny
        comboOcena.getItems().addAll(
                "2",
                "3",
                "4",
                "5"
        );
        dataPracownicy = FXCollections.observableArrayList();
        dataPrzedmioty = FXCollections.observableArrayList();
        dataStudent = FXCollections.observableArrayList();

        data = FXCollections.observableArrayList();

        Statement stmt = null;

        try {

            stmt = sesja.createStatement();

            ResultSet rs = stmt.executeQuery("Select CONCAT(imie_s,\" \",nazwisko_s) as student,CONCAT(imie_p,\" \",nazwisko_p) as prowadzacy ,ocena, nazwa_przedmiotu from oceny,pracownicy,przedmioty,studenci where oceny.id_przedmiotu=przedmioty.id_przedmiotu and oceny.id_studenta=studenci.id_studenta and oceny.id_pracownika=pracownicy.id_pracownika;");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {
                data.add(new Oceny(rs.getInt(3), rs.getString(4), rs.getString(1), rs.getString(2)));

            }

            columnStudent.setCellValueFactory(new PropertyValueFactory<>("student"));
            columnOcena.setCellValueFactory(new PropertyValueFactory<>("ocena"));
            columnPrzedmiot.setCellValueFactory(new PropertyValueFactory<>("nazwa_przedmiotu"));
            columnProwadzacy.setCellValueFactory(new PropertyValueFactory<>("prowadzacy"));
            table_oceny.setItems(null);
            table_oceny.setItems(data);

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

        comboProwadzacy.setItems(null);
        comboProwadzacy.setItems(dataPracownicy);

        comboProwadzacy.setCellFactory(new Callback<ListView<Pracownicy>, ListCell<Pracownicy>>() {

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

        comboProwadzacy.setConverter(new StringConverter<Pracownicy>() {
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

        comboPrzedmiot.setItems(null);
        comboPrzedmiot.setItems(dataPrzedmioty);

        comboPrzedmiot.setCellFactory(new Callback<ListView<Przedmioty>, ListCell<Przedmioty>>() {

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

        comboPrzedmiot.setConverter(new StringConverter<Przedmioty>() {
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
        // wyswietlanie combox student
        Statement stmt4 = null;

        try {

            stmt4 = sesja.createStatement();

            ResultSet rs = stmt4.executeQuery("SELECT * from studenci;");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {

                dataStudent.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }

        } catch (Exception e) {

        }

        comboStudent.setItems(null);
        comboStudent.setItems(dataStudent);

        comboStudent.setCellFactory(new Callback<ListView<Student>, ListCell<Student>>() {

            @Override
            public ListCell<Student> call(ListView<Student> p) {

                final ListCell<Student> cell = new ListCell<Student>() {

                    @Override
                    protected void updateItem(Student t, boolean bln) {
                        super.updateItem(t, bln);

                        if (t != null) {
                            setText(t.getimie_s() + " " + t.getnazwisko_s());
                        } else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        });

        comboStudent.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                if (object == null) {
                    return "";
                } else {
                    return object.getimie_s() + " " + object.getnazwisko_s();
                }
            }

            @Override
            public Student fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        //KONIEC student
    }

    @FXML
    private void comboprzedmiotAction(ActionEvent event) throws IOException {

    }

    @FXML
    private void comboprowadzacyAction(ActionEvent event) throws IOException {

    }

    @FXML
    private void comboocenaAction(ActionEvent event) throws IOException {

    }

    @FXML
    private void comboAdminStudent(ActionEvent event) throws IOException {

    }

    /**
     * Metoda powracająca do menu
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
     * Metoda wylogowująca
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
     * Metoda wyłączająca program
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void close_usersButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }

    /**
     * Metoda generująca pdf
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void generate_wykladowcaButtonAction(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, DocumentException {

        Raporty rap = new Raporty();
        Raporty.rs = Raporty.executeDefaultQuery();
        Raporty.rs.first();
        Raporty.savePdf();
        Raporty.document = Raporty.setDocumentInfo(Raporty.document, "autor", "title ", "language", "creator");
        Raporty.document.open();
        Raporty.document.add(Raporty.setHeaderTab());
        Raporty.document.add(Raporty.setInfoTable(Raporty.setInfoCell("Nadawca", "Grupa ", "Numer 3"), Raporty.setInfoCell("Odbiorca", "UR", "Wydział Matematyczno - Przyrodniczy")));
        Raporty.document.add(Raporty.setItemTable());
        Raporty.document.close();

    }

    /**
     * Metoda wyszukująca użytkowników
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void search_usersButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * Metoda ładująca użytkowników
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void load_usersButonAction(ActionEvent event) throws IOException {

    }

    /**
     * Metoda czyszcząca pole
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void clear_usersButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * Medoda usuwająca pole
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void delete_wykładowcaButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * Metoda edytująca pole
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void edit_wykladowcaButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * Metoda dodająca pole
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void add_wykladowcaButtonAction(ActionEvent event) throws IOException {
        
        
         Statement stmt = null;

        try {

            stmt = sesja.createStatement();
 
            stmt.executeUpdate("INSERT INTO `oceny` (`id_oceny`, `id_przedmiotu`, `id_studenta`, `id_pracownika`,`ocena`) VALUES (null,'" + comboPrzedmiot.getSelectionModel().getSelectedItem().getid_przedmiotu() + "','" + comboStudent.getSelectionModel().getSelectedItem().getid_studenta() + "','" + comboProwadzacy.getSelectionModel().getSelectedItem().getid_pracownika() + "','" + comboOcena.getSelectionModel().getSelectedItem().toString() +  "');");

            Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Oceny_Admin.fxml"));
            Scene assessment_page_scene = new Scene(assessment_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(assessment_page_scene);
            app_stage.show();
            // cIPracownik.getSelectionModel().getSelectedItem().getid_pracownika()
        } catch (Exception e) {

        }
        
        
    }

    private void insertStatement(String insert_query) {

        Connection c = null;
        Statement stmt = null;
        try {

            stmt = sesja.createStatement();

            stmt.executeUpdate(insert_query);
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());

        }

    }
}
