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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Teo
 */
public class Loghistory_windowController implements Initializable {

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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
    @FXML
    private void menuAdminButtonAction(ActionEvent event) throws IOException {

        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Admin_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();
    }
    
    @FXML
    private void logoutAdminButtonAction(ActionEvent event) throws IOException {

        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Login_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();
    }
    
    @FXML
    private void closeAdminButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    
    @FXML
    private void clearButtonAction(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void loadButtonAction(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void searchButtonAction(ActionEvent event) throws IOException {
        
    }
    
    
    
    
}
