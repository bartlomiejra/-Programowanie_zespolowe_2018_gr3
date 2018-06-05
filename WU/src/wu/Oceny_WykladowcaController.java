package wu;

import Connection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
 *  * Klasa odpowiedzialna za wyswietlenie okna Oceny_Wykladowca
 *
 * @author Teo
 */
public class Oceny_WykladowcaController implements Initializable {

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
    private ComboBox<Przedmioty> comboPrzedmiot;
    @FXML
    private ComboBox comboOcena;
    @FXML
    private ComboBox<Student> comboStudent;
    @FXML
    private TextField tfSzukaj;

    ObservableList<Pracownicy> dataPracownicy;
    ObservableList<Przedmioty> dataPrzedmioty;
    ObservableList<Student> dataStudent;

    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Oceny> data;
    private ObservableList<Oceny> data1;

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

        // select oceny
        data = FXCollections.observableArrayList();
        data1 = FXCollections.observableArrayList();

        Statement stmt = null;

        try {

            stmt = sesja.createStatement();

            ResultSet rs = stmt.executeQuery("Select id_oceny,CONCAT(imie_s,\" \",nazwisko_s) as student,CONCAT(imie_p,\" \",nazwisko_p) as prowadzacy ,ocena, nazwa_przedmiotu from oceny,pracownicy,przedmioty,studenci where oceny.id_przedmiotu=przedmioty.id_przedmiotu and oceny.id_studenta=studenci.id_studenta and oceny.id_pracownika=pracownicy.id_pracownika and pracownicy.zalogowany_p='1';");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {
                data.add(new Oceny(rs.getInt(1), rs.getInt(4), rs.getString(5), rs.getString(2), rs.getString(3)));

            }

            columnStudent.setCellValueFactory(new PropertyValueFactory<>("student"));
            columnOcena.setCellValueFactory(new PropertyValueFactory<>("ocena"));
            columnPrzedmiot.setCellValueFactory(new PropertyValueFactory<>("nazwa_przedmiotu"));
            // columnProwadzacy.setCellValueFactory(new PropertyValueFactory<>("prowadzacy"));
            table_oceny.setItems(null);
            table_oceny.setItems(data);

        } catch (Exception e) {

        }

//        // filtrowanie tabeli student
//        FilteredList<Oceny> filteredProdukt = new FilteredList<>(table_oceny.getItems(), e -> true);
//        tfSzukaj.setOnKeyReleased(e -> {
//            tfSzukaj.textProperty().addListener((observableValue, oldValue, newValue) -> {
//                filteredProdukt.setPredicate((Predicate<? super Oceny>) k -> {
//                    if (newValue == null || newValue.isEmpty()) {
//                        return true;
//                    }
//                    String lcFilter = newValue.toLowerCase();
//                    if (k.getimie_s().toLowerCase().contains(lcFilter) || k.getnazwisko_s().toString().toLowerCase().contains(lcFilter) ) {
//                        return true;
//                    }
//                    return false;
//                });
//            });
//            SortedList<Oceny> sortedProdukty = new SortedList<>(filteredProdukt);
//            table_oceny.setItems(sortedProdukty);
//        });
//
//        // filtrowanie tabeli student koniec
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

    /**
     * Metoda do zamkniecia programu
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void close_usersButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }

    /**
     * metoda do przejscia do okna dziekanat_window po kliknieciu menu
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void assesmentWykladowca_menuActionButton(ActionEvent event) throws IOException {

        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Prowadzacy_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();
    }

    /**
     * metoda odpowiedzialna za przejscie do okna logowania
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
     * Metoda do generowania pdf dla wykładowcy
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void generate_wykladowcaButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * Metoda do usuniecia wykladowcy z bazy
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void delete_wykładowcaButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * Metoda do edycji danych wykładowcy w bazie
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void edit_wykladowcaButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * Metoda do dodania ocen do bazy wykladowca
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void add_wykladowcaButtonAction(ActionEvent event) throws IOException {

        // dodawanie id pracownik insert
        //koniec id pracownik insert
        Statement stmt = null;
        Statement stmt5 = null;
        int a = 0;
        try {

            stmt5 = sesja.createStatement();

            ResultSet rs = stmt5.executeQuery("select id_pracownika FROM pracownicy WHERE zalogowany_p='1';");

            while (rs.next()) {
                a = rs.getInt(1);
                System.out.println(a);

            }

            stmt = sesja.createStatement();

            stmt.executeUpdate("INSERT INTO `oceny` (`id_oceny`, `id_przedmiotu`, `id_studenta`, `id_pracownika`,`ocena`) VALUES (null,'" + comboPrzedmiot.getSelectionModel().getSelectedItem().getid_przedmiotu() + "','" + comboStudent.getSelectionModel().getSelectedItem().getid_studenta() + "','" + a + "','" + comboOcena.getSelectionModel().getSelectedItem().toString() + "');");

            Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Oceny_Wykladowca.fxml"));
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
     * metoda szukajaca
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void search_usersButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * metoda ladujaca
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void load_usersButonAction(ActionEvent event) throws IOException {

    }

    /**
     * metoda czyszczaca
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void clear_usersButtonAction(ActionEvent event) throws IOException {

    }

    @FXML
    private void comboPWykladowcaBtn(ActionEvent event) throws IOException {

    }

    @FXML
    private void comboPrzWykladowcaBtn(ActionEvent event) throws IOException {

    }

    @FXML
    private void comboOWykladowcaBtn(ActionEvent event) throws IOException {

    }

    @FXML
    private void comboSWykladowcaBtn(ActionEvent event) throws IOException {

    }

}
