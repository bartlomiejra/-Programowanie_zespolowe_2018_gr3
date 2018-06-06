package wu;

import Connection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

/**
 * FXML Controller class
 *
 * @author Teo
 */
public class KierRokController implements Initializable {
    
    
    
    @FXML
    private TableView<Kierunek> table_kierunek;
    @FXML
    private TableColumn<Kierunek, Integer> column_id_studenta_kierunek;
    @FXML
    private TableColumn<Kierunek, String> column_kierunek_kierunek;
    @FXML
    private TableColumn<Kierunek, String> column_rok_rok;
 
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

    ConnectionClass PolaczenieDB = new ConnectionClass();

    Connection sesja = PolaczenieDB.getConnection();
    private ObservableList<Kierunek> data;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //wyswietlanie select przedmioty
        data = FXCollections.observableArrayList();

        Statement stmt = null;

        try {

            stmt = sesja.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT id_specjalizacji,id_studenta, kierunek, rok from specjalizacja_studenci where id_studenta='0';");

            //System.out.println("Dane:"+ rs.getString(2));
            while (rs.next()) {

                data.add(new Kierunek(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getString(4)));

            }

            //columnIdharmonogramuAdmin.setCellValueFactory(new PropertyValueFactory<>("idHarmonogramu"));
          // column_id_studenta_kierunek.setCellValueFactory(new PropertyValueFactory<>("id_studenta"));
             column_kierunek_kierunek.setCellValueFactory(new PropertyValueFactory<>("kierunek"));
            column_rok_rok.setCellValueFactory(new PropertyValueFactory<>("rok"));
          

            table_kierunek.setItems(null);
            table_kierunek.setItems(data);

        } catch (Exception e) {

        }

        // koniec wyswietlanie select przedmioty
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
          System.out.println("Dodawanie pracownika");
        //System.out.println(data_ur_p.getEditor().getText());
        
          
        
        try {
          
            //Statement stmt = sesja.createStatement();
            //System.out.println(data_ur_p.getEditor().getText());
            int a = 0;
            sesja.createStatement().executeUpdate("INSERT INTO `specjalizacja_studenci` (`id_specjalizacji`,`id_studenta`,`kierunek`, `rok`) VALUES (null,'" + a + "','" + tf_kierunek.getText() + "','" + tf_rok.getText() + "');");

            Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("KierRok.fxml"));
            Scene assessment_page_scene = new Scene(assessment_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(assessment_page_scene);
            app_stage.show();
            // cIPracownik.getSelectionModel().getSelectedItem().getid_pracownika()
        } catch (Exception e) {

        }
        
    }

    @FXML
    private void delete_kierunekBtn(ActionEvent event) {
        
        int id = (table_kierunek.getSelectionModel().getSelectedItem().getid_specjalizacji());

        try {

            PreparedStatement statement = sesja.prepareStatement("DELETE FROM specjalizacja_studenci WHERE id_specjalizacji = ?");
            statement.setInt(1, id);
            statement.executeUpdate();

            Parent assessment_page_parent = FXMLLoader.load(getClass().getResource("KierRok.fxml"));
            Scene assessment_page_scene = new Scene(assessment_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(assessment_page_scene);
            app_stage.show();
        } catch (Exception e) {

        }
    }
    
}
