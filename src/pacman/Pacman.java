/**
 * @file Pacman.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman;

import pacman.engine.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Pacman extends Application {
        
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pacman.fxml"));
        Parent root = loader.load();
        
        primaryStage.setTitle("Pacman");
        
        Controller controller = loader.getController();
        
        root.setOnKeyPressed(controller);
        double sceneWidth = controller.getBoardWidth() + 20.0;
        double sceneHeight = controller.getBoardHeight() + 100.0;
        primaryStage.setScene(new Scene(root, sceneWidth, sceneHeight));
        primaryStage.show();
        root.requestFocus();
        
    }

    public static void main(String[] args) {
        
        launch(args);
        
    }
    
}
