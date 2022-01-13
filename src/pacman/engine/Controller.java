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
 * 
 */
public class Controller implements EventHandler<KeyEvent> {
    
    final private static double FRAMERATE = 50.0;

    @FXML
    private Label scoreLabel;
    
    @FXML
    private Label levelLabel;   
    
    @FXML
    private Label lifeLabel;   
    
    @FXML
    private Label statusLabel;     
    
    @FXML
    private Render render;

    private Timer timer;    
    
    private final Map map;
    
    private final Engine engine;
    
    private boolean paused;

    /**
     * 
     */
    public Controller() {
        
        this.map = new Map();        
        this.engine = new Engine(map);        
        
    }

    /**
     * 
     */
    public void initialize() {
        
        this.paused = false;
        this.statusLabel.setVisible(false);
        
        GameStatus.resetStatus();
        this.engine.init();
        
        this.update();        
        this.startTimer();
        
    }

    /**
     * 
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
     * 
     */
    private void update() {
        
        this.engine.running();
        
        if (GameStatus.isGameOver())
            gameOver();
        
        this.render.update(this.map);
        this.scoreLabel.setText(String.format("Score %d", GameStatus.getPoints()));
        this.levelLabel.setText(String.format(" Level %d", GameStatus.getLevel()));        
        this.lifeLabel.setText(String.format("Lifes %d", GameStatus.getLifes()));        
        
    }

    /**
     * 
     * @param keyEvent
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
     * 
     * @param event 
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
     * 
     * @param event 
     */
    @FXML
    public void reset(ActionEvent event) {
                
        this.timer.cancel();             
        this.initialize();
        
    }
     
    /**
     * 
     */
    public void gameOver() {
        
        this.statusLabel.setText("Game Over");
        this.statusLabel.setVisible(true);
        this.timer.cancel();       
        
    }
    
}