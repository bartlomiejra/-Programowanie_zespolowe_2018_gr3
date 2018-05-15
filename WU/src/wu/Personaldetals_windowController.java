/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Personaldetals_windowController implements Initializable {

    @FXML
    private Button assesment_menu;
    @FXML
    private Button assesment_logout;
    @FXML
    private Button close_history;
    @FXML
    private Button edit_detals;
    @FXML
    private Button save_detals;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
     private void personalDetailsActionButton(ActionEvent event) throws IOException {
    
        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Student_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();        
     }

    @FXML
    private void close_adminButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    @FXML
    private void logout_adminButtonAction(ActionEvent event) throws IOException {

        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("Login_window.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();

    }
    
    @FXML
    private void edit_detalsButtonAction(ActionEvent event) {
    }

    @FXML
    private void save_detalsButtonAction(ActionEvent event) {
    }
    
}
