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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Klasa obslugujaca dzialanie okna z historia logowania uzytkownikow
 *
 * @author Teo
 */
public class Loghistory_windowController implements Initializable {

    @FXML
    private TableView<Loghistory> table_logHistory;
    @FXML
    private TableColumn<Loghistory, String> Columnlogin;
    @FXML
    private TableColumn<Loghistory, String> ColumnLastLogin;

    /**
     * Przyciski wystepujace w tej scenie
     */
    @FXML
    private Button search;
    @FXML
    private Button load;
    @FXML
    private Button clear;
    @FXML
    private Button assesment_menu;
    @FXML
    private Button assesment_logout;
    @FXML
    private Button close_history;
    @FXML
    private TextField tfSzukaj;
    
    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Loghistory> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        data = FXCollections.observableArrayList();
        Statement stmt = null;
        Statement stmt2 = null;

        try {

            stmt = sesja.createStatement();
            stmt2 = sesja.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT login_s as login,ostatnie_logowanie_studenta as ostatnie_logowanie FROM studenci;");

            while (rs.next()) {
                data.add(new Loghistory(rs.getString(1), rs.getString(2)));

            }
            
            
            
            ResultSet rs2 = stmt2.executeQuery("SELECT login_p as login,ostatnie_logowanie_pracownicy as ostatnie_logowanie FROM pracownicy;");
            while (rs2.next()) {
                data.add(new Loghistory(rs2.getString(1), rs2.getString(2)));

            }

            Columnlogin.setCellValueFactory(new PropertyValueFactory<>("login"));
            ColumnLastLogin.setCellValueFactory(new PropertyValueFactory<>("ostatnie_logowanie"));
            table_logHistory.setItems(null);
            table_logHistory.setItems(data);

        } catch (Exception e) {

        }

        
        
        
    }

    /**
     * Metoda odpowiedzialna za przejscie do menu administratora
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void menuAdminButtonAction(ActionEvent event) throws IOException {

        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Admin_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();
    }

    /**
     * Metoda odpowiedzialna za wylogowanie uzytkownika i przejscie do okna
     * logowania
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void logoutAdminButtonAction(ActionEvent event) throws IOException {

        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Login_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();
    }

    /**
     * Metoda odpowiedzialna za zamkniecie programu
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void closeAdminButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }

    /**
     * Metoda odpowiedzialna za czyszczenie zapytan
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void clearButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * Metoda odpowiedzialna za zaladowanie danych po wcisnieciu przycisku
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void loadButtonAction(ActionEvent event) throws IOException {

    }

    /**
     * Metoda odpowiedzialna za wyszukanie uzytkownika po wcisnieciu przycisku
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void searchButtonAction(ActionEvent event) throws IOException {

       
        // filtrowanie tabeli student koniec
        
        
    }

}
