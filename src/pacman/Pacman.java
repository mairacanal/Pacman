/**
 * @file Pacman.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Pacman extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
                
        Parent root = FXMLLoader.load(getClass().getResource("render/Menu.fxml"));
        
        Scene scene = new Scene(root, 650.0, 800.0);         
        scene.getStylesheets().add(Pacman.class.getResource("resources/fontstyle.css").toExternalForm());
        
        stage.setTitle("Pacman");
        stage.setScene(scene);
        stage.show();   
        
    }

    public static void main(String[] args) {
        
        launch(args);
        
    }
    
}
