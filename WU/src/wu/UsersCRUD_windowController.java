package wu;

import Connection.ConnectionClass;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.input.MouseEvent;
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

    // buttony dopowiedzialne za obsługę cześci seeny dotyczącej pracowników
    @FXML
    private Button add_usersp;
    @FXML
    private Button edit_usersp;
    @FXML
    private Button delete_usersp;
    @FXML
    private TextField tf_Imie;
    @FXML
    private TextField tf_Nazwisko;
    @FXML
    private TextField tf_Pesel;
    @FXML
    private TextField tf_Email;
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
    @FXML
    private Button usersMenu;
    @FXML
    private TextField tf_Numer_tel;
    @FXML
    private TextField tf_login;
    @FXML
    private TextField tf_haslo;
    @FXML
    private TextField tf_nr_albumu;
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
    private TextField tf_specjalizacja_p;
    @FXML
    private DatePicker data_ur_p;
    @FXML
    private DatePicker dataStudent_s;

    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Student> data;
    private ObservableList<Pracownicy> data1;
    @FXML
    private TextField tfSzukaj;
    @FXML
    private TextField tfSzukaj_p;
    private TextField tfSzukajPracownik;
    private Student s = null;
    private Pracownicy p = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        InputConstraints.lettersOnly(tf_Imie_p);
        InputConstraints.lettersOnly(tf_nazwisko_p);
        InputConstraints.numbersOnlyP(tf_pesel_p);
        InputConstraints.numbersOnly(tf_NumerTel_p);
        InputConstraints.lettersOnly(tf_Imie);
        InputConstraints.lettersOnly(tf_Nazwisko);
        InputConstraints.numbersOnlyP(tf_Pesel);
        InputConstraints.numbersOnly(tf_Numer_tel);

        data = FXCollections.observableArrayList();
        Statement stmt = null;

        try {

            stmt = sesja.createStatement();
            ResultSet rs = stmt.executeQuery("select id_studenta,imie_s , nazwisko_s, pesel_s, email_s, data_urodzenia_s, nr_tel_s, login_s, haslo_s, nr_albumu_s from studenci;");
            while (rs.next()) {
                data.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10)));

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
            ResultSet rs = stmt1.executeQuery("select id_pracownika,imie_p , nazwisko_p, pesel_p, email_p, data_urodzenia_p, nr_tel_p, login_p, haslo_p,specjalizacja_p from pracownicy;");
            while (rs.next()) {
                data1.add(new Pracownicy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10)));

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

        // filtrowanie tabeli student
        FilteredList<Student> filteredProdukt = new FilteredList<>(table_student.getItems(), e -> true);
        tfSzukaj.setOnKeyReleased(e -> {
            tfSzukaj.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filteredProdukt.setPredicate((Predicate<? super Student>) k -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lcFilter = newValue.toLowerCase();
                    if (k.getimie_s().toLowerCase().contains(lcFilter) || k.getnazwisko_s().toString().toLowerCase().contains(lcFilter) || k.getpesel_s().toString().contains(lcFilter)) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Student> sortedProdukty = new SortedList<>(filteredProdukt);
            table_student.setItems(sortedProdukty);
        });
        // filtrowanie tabeli student koniec

        // filtrowanie tabeli pracownik
        FilteredList<Pracownicy> filteredProdukt1 = new FilteredList<>(table_pracownik.getItems(), e -> true);
        tfSzukaj_p.setOnKeyReleased(e -> {
            tfSzukaj_p.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filteredProdukt1.setPredicate((Predicate<? super Pracownicy>) k -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lcFilter = newValue.toLowerCase();
                    if (k.getimie_p().toLowerCase().contains(lcFilter) || k.getnazwisko_p().toString().toLowerCase().contains(lcFilter) || k.getpesel_p().toString().contains(lcFilter)) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Pracownicy> sortedProdukty = new SortedList<>(filteredProdukt1);
            table_pracownik.setItems(sortedProdukty);
        });

        // filtrowanie tabeli pracownik koniec
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
    private void close_adminButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }

    /**
     * metoda odpowiedzalna za dodawanie uzytkowników
     *
     * @param event
     */
    @FXML
    private void add_usersButtonActionPrac(ActionEvent event) throws NoSuchAlgorithmException {
        System.out.println("Dodawanie pracownika");
        //System.out.println(data_ur_p.getEditor().getText());

        String s = tf_haslo_p.getText();
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());

        try {
            LocalDate value = data_ur_p.getValue();
            //Statement stmt = sesja.createStatement();
            //System.out.println(data_ur_p.getEditor().getText());

            sesja.createStatement().executeUpdate("INSERT INTO pracownicy (id_pracownika, imie_p, nazwisko_p, pesel_p, email_p, data_urodzenia_p,nr_tel_p,login_p,haslo_p,specjalizacja_p,ostatnie_logowanie_pracownicy,zalogowany_p) VALUES (null,'" + tf_Imie_p.getText() + "','" + tf_nazwisko_p.getText() + "','" + tf_pesel_p.getText() + "','" + tf_email_p.getText() + "','" + value + "','" + tf_NumerTel_p.getText() + "','" + tf_login_p.getText() + "','" + new BigInteger(1, m.digest()).toString(16) + "','" + tf_specjalizacja_p.getText() + "',null,null);");

            Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("usersCRUD_window.fxml"));
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
     * metoda odpowiedzalna za edycje studentow
     *
     * @param event
     */
    @FXML
    private void edit_usersButtonAction(ActionEvent event) throws SQLException, IOException {
        if (s != null) {

            sesja.createStatement().executeUpdate("UPDATE studenci SET imie_s='" + tf_Imie.getText() + "', nazwisko_s='" + tf_Nazwisko.getText() + "', pesel_s='" + tf_Pesel.getText() + "', email_s='" + tf_Email.getText() + "', nr_tel_s='" + tf_Numer_tel.getText() + "', login_s='" + tf_login.getText() + "', haslo_s='" + tf_haslo.getText() + "', data_urodzenia_s='" + dataStudent_s.getValue() + "', nr_albumu_s='" + tf_nr_albumu.getText() + "' WHERE id_studenta=" + s.getid_studenta() + ";");
            Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("usersCRUD_Dziekanatwindow.fxml"));
            Scene assessment_page_scene = new Scene(assessment_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(assessment_page_scene);
            app_stage.show();
        }
        

    }

    /**
     * metoda odpowiedzalna za usuwanie użytkowników
     *
     * @param event
     */
    @FXML
    private void delete_usersButtonAction(ActionEvent event) {

        int id = (table_student.getSelectionModel().getSelectedItem().getid_studenta());

        try {

            PreparedStatement statement = sesja.prepareStatement("DELETE FROM studenci WHERE id_studenta = ?");
            statement.setInt(1, id);
            statement.executeUpdate();

            Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("usersCRUD_window.fxml"));
            Scene assessment_page_scene = new Scene(assessment_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(assessment_page_scene);
            app_stage.show();
        } catch (Exception e) {

        }

    }

    @FXML

    //dodawanie studenta
    private void add_usersButtonAction(ActionEvent event) throws NoSuchAlgorithmException {
        System.out.println("Dodawanie studenta");

        String s = tf_haslo.getText();
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());

        try {
            LocalDate value = dataStudent_s.getValue();
            //Statement stmt = sesja.createStatement();
            //System.out.println(data_ur_p.getEditor().getText());
            sesja.createStatement().executeUpdate("INSERT INTO studenci (id_studenta, imie_s, nazwisko_s, pesel_s, email_s, data_urodzenia_s,nr_tel_s,login_s,haslo_s,nr_albumu_s,ostatnie_logowanie_studenta,zalogowany_s) VALUES (null,'" + tf_Imie.getText() + "','" + tf_Nazwisko.getText() + "','" + tf_Pesel.getText() + "','" + tf_Email.getText() + "','" + value + "','" + tf_Numer_tel.getText() + "','" + tf_login.getText() + "','" + new BigInteger(1, m.digest()).toString(16) + "','" + tf_nr_albumu.getText() + "',null,null);");
            // INSERT INTO studenci (`id_studenta`,`imie_s`,`nazwisko_s`,`pesel_s`,`email_s`,`data_urodzenia_s`,`nr_tel_s`,`login_s`,`haslo_s`,`nr_albumu_s`,`ostatnie_logowanie_studenta`,`zalogowany_s`) VALUES (null,'ghjghgjg"','hjgjghj','43242','sdadasd','567567','6576767','fghhgfh','jhkhk','546 ',null,null)
            Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("usersCRUD_window.fxml"));
            Scene assessment_page_scene = new Scene(assessment_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(assessment_page_scene);
            app_stage.show();
            // cIPracownik.getSelectionModel().getSelectedItem().getid_pracownika()
        } catch (Exception e) {

        }

    }

    @FXML
    private void edit_usersButtonActionPrac(ActionEvent event) throws SQLException, IOException {
        System.out.println("Dziala");
        if (p != null) {

            sesja.createStatement().executeUpdate("UPDATE pracownicy SET imie_p='" + tf_Imie_p.getText() + "', nazwisko_p='" + tf_nazwisko_p.getText() + "', pesel_p='" + tf_pesel_p.getText() + "', email_p='" + tf_email_p.getText() + "', nr_tel_p='" + tf_NumerTel_p.getText() + "', login_p='" + tf_login_p.getText() + "', haslo_p='" + tf_haslo_p.getText() + "', data_urodzenia_p='" + data_ur_p.getValue() + "', specjalizacja_p='" + tf_specjalizacja_p.getText() + "' WHERE id_pracownika=" + p.getid_pracownika() + ";");
            //      sesja.createStatement().executeUpdate("UPDATE studenci SET imie_s='"+tf_Imie.getText()+"', nazwisko_s='"+tf_Nazwisko.getText()+"', pesel_s='"+tf_Pesel.getText()+"', email_s='"+tf_Email.getText()+"', nr_tel_s='"+tf_Numer_tel.getText()+"', login_s='"+tf_login.getText()+"', haslo_s='"+tf_haslo.getText()+"', data_urodzenia_s='"+dataStudent_s.getValue()+"', nr_albumu_s='"+tf_nr_albumu.getText()+"' WHERE id_studenta="+s.getid_studenta()+";");
            Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("usersCRUD_Dziekanatwindow.fxml"));
            Scene assessment_page_scene = new Scene(assessment_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(assessment_page_scene);
            app_stage.show();
        }

    }

    @FXML
    private void delete_usersButtonActionPrac(ActionEvent event) {

        int id = (table_pracownik.getSelectionModel().getSelectedItem().getid_pracownika());

        try {

            PreparedStatement statement = sesja.prepareStatement("DELETE FROM pracownicy WHERE id_pracownika = ?");
            statement.setInt(1, id);
            statement.executeUpdate();

            Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("usersCRUD_window.fxml"));
            Scene assessment_page_scene = new Scene(assessment_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(assessment_page_scene);
            app_stage.show();
        } catch (Exception e) {

        }
    }
    // edycja studenta uzupelnianie pol

    @FXML
    private void edytujStudenta(MouseEvent event) {
        if (table_student.getSelectionModel().getSelectedItem() != null) {
            s = table_student.getSelectionModel().getSelectedItem();
            tf_Imie.setText(s.getimie_s());
            tf_Nazwisko.setText(s.getnazwisko_s());
            tf_Email.setText(s.getemail_s());
            tf_Pesel.setText(s.getpesel_s().toString());
            dataStudent_s.getEditor().setText(s.getdata_urodzenia_s());
            tf_login.setText(s.getlogin_s());
            tf_haslo.setText(s.gethaslo_s());
            tf_nr_albumu.setText(s.getnr_albumu_s());
            tf_Numer_tel.setText(s.getnr_tel_s().toString());
        }
    }

    //  edycja studenta uzupelnianie pol koniec
    //   edycja praconicy uzupelnianie pol
    @FXML
    private void edytujPracownika(MouseEvent event) {

        if (table_pracownik.getSelectionModel().getSelectedItem() != null) {
            p = table_pracownik.getSelectionModel().getSelectedItem();
            tf_Imie_p.setText(p.getimie_p());
            tf_nazwisko_p.setText(p.getnazwisko_p());
            tf_email_p.setText(p.getemail_p());
            tf_pesel_p.setText(p.getpesel_p().toString());
            data_ur_p.getEditor().setText(p.getdata_urodzenia_p());
            tf_login_p.setText(p.getlogin_p());
            tf_haslo_p.setText(p.gethaslo_p());
            tf_specjalizacja_p.setText(p.getspecjalizacja_p());
            tf_NumerTel_p.setText(p.getnr_tel_p().toString());
        }
    }
    //edycja pracownicy uzupelnianie pol koniec
}
