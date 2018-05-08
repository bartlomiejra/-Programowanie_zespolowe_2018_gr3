package wu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Teo
 */
public class Oceny_WykladowcaController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }   
    
     @FXML
    private void close_usersButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
}
