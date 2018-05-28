package wu;

import Connection.ConnectionClass;
import generatorpdf.GeneratorPDF;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javax.swing.text.Document;


/**
 * Klasa obsługująca oceny, scena admina 
 *
 * @author Zbyszek
 */
public class Oceny_AdminController implements Initializable {

    @FXML
    private TableView<Oceny> table_oceny;
    @FXML
    private TableColumn<Oceny, String> columnProwadzacy;
    @FXML
    private TableColumn<Oceny, String> columnPrzedmiot;
    @FXML
    private TableColumn<Oceny, Integer> columnOcena;
    @FXML
    private TableColumn<Oceny, String> columnStudent;
    @FXML
    private Button generate_wykladowca;
    @FXML
    private Button assesment_menu;
    @FXML
    private Button assesment_logout;
    @FXML
    private Button close_users;
    @FXML
    private TextField tfProwadzacy;
    @FXML
    private TextField tfPrzedmiot;
    @FXML
    private TextField tfLiczba_godzin;
    @FXML
    private TextField tfOcena;
    @FXML
    private TextField tf_student;
    @FXML
    private Button add_wykladowca;
    @FXML
    private Button edit_wykladowca;
    @FXML
    private Button delete_wykładowca;
    @FXML
    private Button search_users;
    @FXML
    private Button load_users;
    @FXML
    private Button clear_users;

        ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Oceny> data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         
         data = FXCollections.observableArrayList();
        Statement stmt = null;

        try {

            stmt = sesja.createStatement();
            
            
            
            ResultSet rs = stmt.executeQuery("Select CONCAT(imie_s,\" \",nazwisko_s) as student,CONCAT(imie_p,\" \",nazwisko_p) as prowadzacy ,ocena, nazwa_przedmiotu from oceny,pracownicy,przedmioty,studenci where oceny.id_przedmiotu=przedmioty.id_przedmiotu and oceny.id_studenta=studenci.id_studenta and oceny.id_pracownika=pracownicy.id_pracownika;");

         
            //System.out.println("Dane:"+ rs.getString(2));
           
            while (rs.next()) {
              data.add(new Oceny(rs.getInt(3),rs.getString(4),rs.getString(1),rs.getString(2)));
              System.out.println(rs.getString(3));

            }
               
            columnStudent.setCellValueFactory(new PropertyValueFactory<>("student"));
            columnOcena.setCellValueFactory(new PropertyValueFactory<>("ocena"));
            columnPrzedmiot.setCellValueFactory(new PropertyValueFactory<>("nazwa_przedmiotu"));
            columnProwadzacy.setCellValueFactory(new PropertyValueFactory<>("prowadzacy"));
      
       
             table_oceny.setItems(null);
            table_oceny.setItems(data);

        } catch (Exception e) {

        }  
        
        
        
        

    }
    
    /**
     * Metoda powracająca do menu
     * @param event
     * @throws IOException 
     */
    @FXML
    private void assesmentAdmin_menuActionButton(ActionEvent event) throws IOException {

        Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("Admin_window.fxml"));
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
     * Metoda wyłączająca program
     * @param event
     * @throws IOException 
     */
     @FXML
    private void close_usersButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    /**
     * Metoda generująca pdf
     * @param event
     * @throws IOException 
     */
     @FXML
    private void generate_wykladowcaButtonAction(ActionEvent event) throws IOException {
     
        //        cos jest jeszcze nie tak jak powinno 
        
//        Raporty asd=new Raporty();
//        Raporty.rs=Raporty.executeDefaultQuery();
//        Raporty.rs.first();
//        Raporty.savePdf();
//        
//        Raporty.document=raporty.Raporty.setDocumentInfo( raporty.Raporty.setDocumentInfo(raporty.Raporty.document, "autor", "x ", "x", "x")) ;
//        Raporty.document.open();
//        Raporty.document.add(raporty.Raporty.setHeaderTab());
//        Raporty.document.add(raporty.Raporty.setInfoTable(raporty.Raporty.setInfoCell("Nadawca", "Zespół", "Numer 3")
//                , v.setInfoCell("Nadawca", "Zespół", "Numer 3")));
//        Raporty.document.add(raporty.Raporty.setItemTable());
//        Raporty.document.close();
//    
       


    }


  
    /**
     * Metoda wyszukująca użytkowników
     * @param event
     * @throws IOException 
     */
    @FXML
    private void search_usersButtonAction(ActionEvent event) throws IOException{
        
    }
    
    /**
     * Metoda ładująca użytkowników
     * @param event
     * @throws IOException 
     */
   @FXML
    private void load_usersButonAction(ActionEvent event) throws IOException{
        
    } 
    
    /**
     * Metoda czyszcząca pole
     * @param event
     * @throws IOException 
     */
   @FXML
    private void clear_usersButtonAction(ActionEvent event) throws IOException{
        
    }  
    
    /**
     * Medoda usuwająca pole
     * @param event
     * @throws IOException 
     */
    @FXML
    private void delete_wykładowcaButtonAction(ActionEvent event) throws IOException{
        
    }  
    
    /**
     * Metoda edytująca pole
     * @param event
     * @throws IOException 
     */
     @FXML
    private void edit_wykladowcaButtonAction(ActionEvent event) throws IOException{
        
    }  
    
    /**
     * Metoda dodająca pole
     * @param event
     * @throws IOException 
     */
     @FXML
    private void add_wykladowcaButtonAction(ActionEvent event) throws IOException{
        
    }  
    
}
