package wu;

import Connection.ConnectionClass;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Teo
 */
public class PrzedmiotAdmin_windowController implements Initializable {

    @FXML
    private TableView<Przedmiotyedycja> table_przedmioty;
    @FXML
    private TableColumn<Przedmiotyedycja, String> tf_NazwaPrzedmiotu_table;
    @FXML
    private TextField tf_NazwaPrzedmiotu;
    @FXML
    private Button addPrzedmiotAdmin;
    @FXML
    private Button editPrzedmiotAdmin;
    @FXML
    private Button deletePrzedmiotAdmin;
    @FXML
    private Button przedmiotyMenu;
    @FXML
    private Button close_users;
    @FXML
    private TextField tf_SzukajPrzedmioty;
    @FXML
    private Button szukajPrzedmiot;
    @FXML
    private Button wczytajPrzedmiot;
    @FXML
    private Button wyczyscPrzedmiot;

    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Przedmiotyedycja> data;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        


        //wyswietlanie select przedmioty
        data = FXCollections.observableArrayList();

        Statement stmt = null;

        try {

            stmt = sesja.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT id_przedmiotu, nazwa_przedmiotu from przedmioty;");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {

                data.add(new Przedmiotyedycja(rs.getInt(1), rs.getString(2)));

            }

            //columnIdharmonogramuAdmin.setCellValueFactory(new PropertyValueFactory<>("idHarmonogramu"));
          //  columnIdprzedmiotuPracownik.setCellValueFactory(new PropertyValueFactory<>("idPrzedmiotu"));
            // columnIdpracownikaPracownik.setCellValueFactory(new PropertyValueFactory<>("idPracownika"));
            tf_NazwaPrzedmiotu_table.setCellValueFactory(new PropertyValueFactory<>("nazwa_przedmiotu"));
          

            table_przedmioty.setItems(null);
            table_przedmioty.setItems(data);

        } catch (Exception e) {

        }

        // koniec wyswietlanie select przedmioty
        
        
        
          // filtrowanie tabeli student
        
        FilteredList<Przedmiotyedycja> filteredProdukt = new FilteredList<>(table_przedmioty.getItems(), e -> true);
        tf_SzukajPrzedmioty.setOnKeyReleased(e -> {
            tf_SzukajPrzedmioty.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filteredProdukt.setPredicate((Predicate<? super Przedmiotyedycja>) k -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lcFilter = newValue.toLowerCase();
                    if (k.getnazwa_przedmiotu().toLowerCase().contains(lcFilter)) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Przedmiotyedycja> sortedProdukty = new SortedList<>(filteredProdukt);
            table_przedmioty.setItems(sortedProdukty);
        });
        
        // filtrowanie tabeli student koniec
    }    

    @FXML
    private void addPrzedmiotAdminButtonAction(ActionEvent event) {
        
          System.out.println("Dodawanie pracownika");
        //System.out.println(data_ur_p.getEditor().getText());
        
          
        
        try {
          
            //Statement stmt = sesja.createStatement();
            //System.out.println(data_ur_p.getEditor().getText());

            sesja.createStatement().executeUpdate("INSERT INTO `przedmioty` (`id_przedmiotu`, `nazwa_przedmiotu`) VALUES (null,'" + tf_NazwaPrzedmiotu.getText() + "');");

            Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("przedmiotAdmin_window.fxml"));
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
    private void editPrzedmiotButtonAction(ActionEvent event) {
    }

    @FXML
    private void deletePrzedmiotButtonAction(ActionEvent event) {
    }

    @FXML
    private void przedmiotyMenuButtonAction(ActionEvent event) throws IOException {
        
        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Admin_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();
        
    }

    @FXML
    private void close_app(ActionEvent event) {
        
        System.exit(0);
        
    }
    

    @FXML
    private void szukajPrzedmiotButtonAction(ActionEvent event) {
    }

    @FXML
    private void wczytajPrzedmiotButtonAction(ActionEvent event) {
    }

    @FXML
    private void wyczyscPrzedmiotButtonAction(ActionEvent event) {
    }
    
}
