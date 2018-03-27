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
    private Button button; 
    private TextField loginTekst;
    private PasswordField hasloTekst;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        
        if(loginTekst.getText().equals("student")&& hasloTekst.getText().equals("student")) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
      Parent parent = FXMLLoader.load(getClass().getResource("/wu/Student_window.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        
       stage.setScene(scene);
       stage.setTitle("Okno studenta");
       stage.show();
       
        }
      
        
         if(loginTekst.getText().equals("admin")&& hasloTekst.getText().equals("admin")) {
                     ((Node) (event.getSource())).getScene().getWindow().hide();
      Parent parent = FXMLLoader.load(getClass().getResource("/wu/Admin_window.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        
       stage.setScene(scene);
       stage.setTitle("Okno studenta");
       stage.show();
       
        }
        else {
   
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

}