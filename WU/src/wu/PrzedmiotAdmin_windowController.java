package wu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Teo
 */
public class PrzedmiotAdmin_windowController implements Initializable {

    @FXML
    private TableView<?> table_przedmioty;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addPrzedmiotAdminButtonAction(ActionEvent event) {
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
