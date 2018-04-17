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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zbyszek
 */
public class Admin_windowController implements Initializable {

    @FXML
    private Button close_admin;
    @FXML
    private Button logout_admin;
    @FXML
    private Label users_name_admin;
    @FXML
    private Button assessment_admin;
    @FXML
    private Button users_admin;
    @FXML
    private Button schedule_admin;
    @FXML
    private Button logged_history_admin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void assessment_adminButtonAction(ActionEvent event) throws IOException {

        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Oceny.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();  
        
        
            
    }
    
    @FXML
    private void close_adminButtonAction(ActionEvent event) throws IOException{
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
    private void users_adminButtonAction(ActionEvent event) throws IOException {

        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("usersCRUD_window.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();  
        
        
            
    }
    
    @FXML
    private void logged_history_adminButtonAction(ActionEvent event) throws IOException {

        Parent logged_history_parent = FXMLLoader.load(getClass().getResource("loghistory_window.fxml"));
        Scene logged_history_scene = new Scene(logged_history_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logged_history_scene);
        app_stage.show();  
        
        
            
    }
}
