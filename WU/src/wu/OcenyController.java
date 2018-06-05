package wu;

import Connection.ConnectionClass;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;


/**
 * Klasa obsługująca oceny studenta
 *
 * @author Zbyszek
 * @author Jacek
 */
public class OcenyController implements Initializable {
   
    @FXML
    private TableView<Oceny> table_oceny_student;
    @FXML
    private TableColumn<Oceny, String> przedmiot_student;
    @FXML
    private TableColumn<Oceny, String> prowadzacy_student;
    @FXML
    private TableColumn<Oceny, Integer> oceny_student;
    
    
    
    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Oceny> data;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //oceny student select
         data = FXCollections.observableArrayList();

        Statement stmt = null;

        try {

            stmt = sesja.createStatement();

            ResultSet rs = stmt.executeQuery("Select id_oceny,CONCAT(imie_s,\" \",nazwisko_s),CONCAT(imie_p,\" \",nazwisko_p) as prowadzacy ,ocena as ocena, nazwa_przedmiotu as nazwa_przedmiotu from oceny,pracownicy,przedmioty,studenci where oceny.id_przedmiotu=przedmioty.id_przedmiotu and oceny.id_studenta=studenci.id_studenta and oceny.id_pracownika=pracownicy.id_pracownika;");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {
               data.add(new Oceny(rs.getInt(1),rs.getInt(4), rs.getString(5), rs.getString(2), rs.getString(3)));

            }

            przedmiot_student.setCellValueFactory(new PropertyValueFactory<>("nazwa_przedmiotu"));
            prowadzacy_student.setCellValueFactory(new PropertyValueFactory<>("prowadzacy"));
            oceny_student.setCellValueFactory(new PropertyValueFactory<>("ocena"));
            
            table_oceny_student.setItems(null);
            table_oceny_student.setItems(data);

        } catch (Exception e) {

        }
        
    }    
    
    /**
     * Metoda powracająca do menu
     * @param event
     * @throws IOException 
     */
     @FXML
     private void assesment_menuActionButton(ActionEvent event) throws IOException {
    
        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Student_window.fxml"));
        Scene assessment_page_scene = new Scene(assessment_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(assessment_page_scene);
        app_stage.show();        
     }
     
     /**
      * Metoda wylogowująca
      * @param event
      * @throws IOException 
      */
     @FXML
    private void assesment_logoutActionButton(ActionEvent event) throws IOException {

        Parent logout_page_parent = FXMLLoader.load(getClass().getResource("Login_window.fxml"));
        Scene logout_page_scene = new Scene(logout_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(logout_page_scene);
        app_stage.show();             
    }
    
   /**
    * Metoda generująca pdf z ocenami
    * @param event
    * @throws IOException 
    */
   @FXML
    private void generate_studentButtonAction(ActionEvent event) throws IOException {
           
    } 
    
    
    
    
}
