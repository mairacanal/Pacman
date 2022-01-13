/**
 * @file MenuController.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.engine;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {
        
    private Stage stage;
    
    private Scene scene;
    
    private Parent root;
    
    @FXML
    public void play(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pacman/render/Pacman.fxml"));
        root = loader.load();
        
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Pacman");
        
        Controller controller = loader.getController();        
        root.setOnKeyPressed(controller);
        
        scene = new Scene(root, 650.0, 800.0);
        scene.getStylesheets().add(getClass().getResource("/pacman/resources/fontstyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();     
        
        root.requestFocus();            
        
    }
    
}
