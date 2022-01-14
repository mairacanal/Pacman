/**
 * @file Controller.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.engine;

import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.application.Platform;
import java.util.Timer;
import java.util.TimerTask;
import pacman.render.Render;
import pacman.gameElements.Map;
import pacman.gameElements.GameConstants;

/**
 * Classe que realiza a interface entre o JavaFX e a Engine do jogo, controlando
 * o Framerate do jogo e os botões da interface.
 */
public class Controller implements EventHandler<KeyEvent> {
    
    final private static double FRAMERATE = 60.0;

    @FXML
    private Label scoreLabel;
    
    @FXML
    private Label levelLabel;   
    
    @FXML
    private Label lifeLabel;   
    
    @FXML
    private Label gameOverLabel;     
    
    @FXML
    private Render render;

    private Timer timer;    
    
    private final Map map;
    
    private final Engine engine;
    
    private boolean paused;

    /**
     * Construtor da classe Controller, que inicializa o mapa e a engine do jogo.
     */
    public Controller() {
        
        this.map = new Map();        
        this.engine = new Engine(map);        
        
    }

    /**
     * Método que inicializa a engine e a parte gráfica do jogo.
     */
    @FXML
    public void initialize() {
        
        this.paused = false;
        this.gameOverLabel.setVisible(false);
        
        GameStatus.resetStatus();
        this.engine.init();
        
        this.update();        
        this.startTimer();
        
    }

    /**
     * Método que inicializa o Timer e agenda uma tarefa para atualizar o jogo
     * de acordo com o framerate definido.
     */
    private void startTimer() {
        
        this.timer = new Timer();
        
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    update();
                });
            }
        };       

        long frametime = (long) (1000.0 / FRAMERATE);
        this.timer.schedule(timerTask, 0, frametime);
        
    }

    /**
     * Método que atualiza o jogo a cada rodada, movimentando os personagens e 
     * renderizando as suas novas posições.
     */
    private void update() {
        
        this.engine.running();
        
        if (GameStatus.isGameOver()) {
            
            this.gameOverLabel.setVisible(true);
            this.timer.cancel();   
            
        }
        
        this.render.update(this.map);
        this.scoreLabel.setText(String.format("Score %d", GameStatus.getPoints()));
        this.levelLabel.setText(String.format(" Level %d", GameStatus.getLevel()));        
        this.lifeLabel.setText(String.format("Lifes %d", GameStatus.getLifes()));        
        
    }

    /**
     * Método que lida com a entrada de teclado do usuário, indicando a direção
     * do Pacman.
     * @param keyEvent Evento de entrada de teclado
     */
    @Override
    public void handle(KeyEvent keyEvent) {             
                
        switch (keyEvent.getCode()) {
            case LEFT:
                GameStatus.setPacmanDirection(GameConstants.LEFT);
                break;
            case RIGHT:
                GameStatus.setPacmanDirection(GameConstants.RIGHT);
                break;
            case UP:
                GameStatus.setPacmanDirection(GameConstants.UP);
                break;
            case DOWN:
                GameStatus.setPacmanDirection(GameConstants.DOWN);
                break;
            default:
                break;
        }                
        
    }   
    
    /**
     * Método que "handle" o botão "Pause" da interface, pausando o jogo.
     * @param event Evento de clique no botão "Pause"
     */
    @FXML
    public void pause(ActionEvent event) {
        
        if (!paused)            
            this.timer.cancel();             
        else 
            this.startTimer();    
        
        paused = !paused;
        
    }
    
    /**
     * Método que "handle" o botão "Reset" da interface, reinicializando o jogo.
     * @param event Evento de clique no botão "Reset"
     */
    @FXML
    public void reset(ActionEvent event) {
                
        this.timer.cancel();             
        this.initialize();
        
    }
    
}