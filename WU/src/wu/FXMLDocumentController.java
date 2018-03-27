/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wu;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author student
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label login,haslo,label ;
    @FXML
    private Button button;
    @FXML
    private TextField loginTekst;
    @FXML
    private PasswordField hasloTekst;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        
        Parent student_window = FXMLLoader.load(getClass().getResource("Student_window.fxml"));
        Scene student_window_scene = new Scene(student_window);
        Stage app_stage_student_window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        if((loginTekst.getText().equals("student"))&& (hasloTekst.getText().equals("student"))) 
        {
                
                app_stage_student_window.hide(); //optional
                app_stage_student_window.setScene(student_window_scene);
                app_stage_student_window.show();
       
        }
      
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Admin_window.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        if((loginTekst.getText().equals("admin"))&& (hasloTekst.getText().equals("admin"))) 
        {
                
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();
       
        }
        else {
   
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

}