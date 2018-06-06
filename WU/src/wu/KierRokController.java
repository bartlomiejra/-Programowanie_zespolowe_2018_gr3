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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Teo
 */
public class KierRokController implements Initializable {

    @FXML
    private Button kierunekMenu;
    @FXML
    private TextField tf_kierunek;
    @FXML
    private TextField tf_rok;
    @FXML
    private Button add_kierunek;
    @FXML
    private Button delete_kierunek;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void kierunekMenuBtn(ActionEvent event) throws IOException {
        
        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Admin_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();
        
    }

    @FXML
    private void add_kierunekBtn(ActionEvent event) {
    }

    @FXML
    private void delete_kierunekBtn(ActionEvent event) {
    }
    
}
