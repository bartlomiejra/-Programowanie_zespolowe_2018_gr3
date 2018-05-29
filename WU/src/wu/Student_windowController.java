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
import javafx.stage.Stage;

/**
 * Klasa odpowiedzialna za obsluge sceny z menu studenta
 * @author Zbyszek
 */
public class Student_windowController implements Initializable {

    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /**
     * metoda odpowiedzialna za przejście do okna Oceny
     * @param event
     * @throws IOException 
     */
    @FXML
     private void assessment_studentButtonAction(ActionEvent event) throws IOException {
    
        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Oceny.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();        
     }
     
     /**
      * metoda odpowiedzialna za wyjście z aplikacji
      * @param event
      * @throws IOException 
      */
     @FXML
       private void close_studentButtonAction(ActionEvent event) throws IOException{
        System.exit(0);  
    }
       
       /**
        * przejśćie do okna z danymi personalnymi studenta
        * @param event
        * @throws IOException 
        */
       @FXML
    private void users_studentButtonAction(ActionEvent event) throws IOException {

        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("personaldetals_window.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();                           
    }
    
    /**
     * metoda odpowiedzialna za wylogowanie studenta, przejście do okna logowania
     * @param event
     * @throws IOException 
     */
    @FXML
    private void logout_studentButtonAction(ActionEvent event) throws IOException {

        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("Login_window.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();             
    }
    
   /**
    * metoda odpowiedzialna za przejście do okna z planem zajęć
    * @param event
    * @throws IOException 
    */
    @FXML
    private void schedule_studentButtonAction(ActionEvent event) throws IOException {

        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("Planzajec_student.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();             
    }
    
}
