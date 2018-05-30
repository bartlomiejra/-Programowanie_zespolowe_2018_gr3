package wu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Klasa glowna odpowiadajaca za uruchomienie programu
 * @author student
 */
public class WU extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login_window.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Wirtualna Uczelnia");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
