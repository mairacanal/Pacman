/**
 * @file MenuController.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.engine;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Classe que controla todas as funcionalidades do menu principal
 */
public class MenuController {
        
    private Stage stage;
    
    private Scene scene;
    
    private Parent root;
    
    /**
     * Método "handle" do botão "Play" do menu principal, o qual inicializa a 
     * tela do jogo "Pacman"
     * @param event Evento de clique no botão
     * @throws IOException Exceção lançada no caso de erros no carregamento dos arquivos
     */
    @FXML
    public void play(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pacman/render/Pacman.fxml"));
        root = loader.load();
        
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        Controller controller = loader.getController();
        
        root.setOnKeyPressed(controller);
        
        scene = new Scene(root, 650.0, 800.0);
        scene.getStylesheets().add(getClass().getResource("/pacman/resources/fontstyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();     
        
        stage.setOnCloseRequest((WindowEvent t) -> {
            Platform.exit();
            System.exit(0);
        });
        
        root.requestFocus();                   
        
    }
    
}
