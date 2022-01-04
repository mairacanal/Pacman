/**
 * @file Controller.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.engine;

import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.application.Platform;
import java.util.Timer;
import java.util.TimerTask;
import pacman.render.Render;
import pacman.gameElements.Map;
import pacman.gameElements.GameConstants;

public class Controller implements EventHandler<KeyEvent> {
    
    final private static double FRAMERATE = 5.0;

    @FXML
    private Label scoreLabel;
    
    @FXML
    private Label levelLabel;   
    
    @FXML
    private Label lifeLabel;   
    
    @FXML
    private Render render;

    private Timer timer;    
    
    private final Map map;
    private final Engine engine;

    public Controller() {
        
        this.map = new Map();
        this.engine = new Engine(map);
        
    }

    public void initialize() {
        
        this.engine.init();
        this.update();
        this.startTimer();
        
    }

    private void startTimer() {
        
        this.timer = new java.util.Timer();
        
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    update();
                });
            }
        };

        long frameTimeInMilliseconds = (long) (1000.0 / FRAMERATE);
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
        
    }

    private void update() {
        
        this.engine.running();
        
        this.render.update(this.map);
        this.scoreLabel.setText(String.format("Score %d", GameStatus.getPoints()));
        this.levelLabel.setText(String.format(" Level %d", GameStatus.getLevel()));        
        this.lifeLabel.setText(String.format("Lifes %d", GameStatus.getLifes()));        
        
    }

    @Override
    public void handle(KeyEvent keyEvent) {
             
        KeyCode code = keyEvent.getCode();
        
        if (null != code)
            switch (code) {
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
    
    public double getBoardWidth() {
        
        return Render.CELL_WIDTH * GameConstants.BOARD_HORIZONTAL;
        
    }

    public double getBoardHeight() {
        
        return Render.CELL_WIDTH * GameConstants.BOARD_VERTICAL;
        
    }
    
}