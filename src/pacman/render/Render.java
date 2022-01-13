/**
 * @file Render.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.render;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.HashMap;
import pacman.gameElements.GameConstants;
import pacman.gameElements.Map;
import pacman.gameElements.Node;
import pacman.engine.GameStatus;

/**
 * Classe que renderiza a interface gráfica do jogo
 */
public class Render extends Group {
    
    public final static double CELL = 20.0;    
            
    private final HashMap<Integer, Image> pallete;
    private final Image[] pacmanView;
    private ImageView[][] cellViews;
    
    /**
     * Construtor padrão da classe Render
     */
    public Render() {
        
        this.pallete = new HashMap<>();
        this.pacmanView = new Image[4];
        
        this.initializeGrid();
        this.loadImages();
    
    }
    
    /**
     * 
     */
    private void initializeGrid() {
                   
        this.cellViews = new ImageView[GameConstants.BOARD_VERTICAL][GameConstants.BOARD_HORIZONTAL];

        for (int i = 0; i < GameConstants.BOARD_VERTICAL; i++) {

            for (int j = 0; j < GameConstants.BOARD_HORIZONTAL; j++) {

                ImageView imageView = new ImageView();

                imageView.setX((double) j * CELL);
                imageView.setY((double) i * CELL);
                imageView.setFitWidth(CELL);
                imageView.setFitHeight(CELL);
                this.cellViews[i][j] = imageView;
                this.getChildren().add(imageView);

            }

        }
        
    }
    
    /**
     * Método que define a paleta de correspondência entre símbolos e identificadores
     * do jogo
     */
    private void loadImages() {

        this.pallete.put(GameConstants.BLOCKED,new Image("file:src/pacman/resources/wall.png"));
        this.pallete.put(GameConstants.BLINKY, new Image("file:src/pacman/resources/blinky.gif"));
        this.pallete.put(GameConstants.PINKY,  new Image("file:src/pacman/resources/pinky.gif"));
        this.pallete.put(GameConstants.INKY,   new Image("file:src/pacman/resources/inky.gif"));
        this.pallete.put(GameConstants.CLYDE,  new Image("file:src/pacman/resources/clyde.gif"));
        this.pallete.put(GameConstants.PACDOT, new Image("file:src/pacman/resources/smalldot.png"));
        this.pallete.put(GameConstants.PILL,   new Image("file:src/pacman/resources/whitedot.png"));
        this.pallete.put(GameConstants.FRUIT,  new Image("file:src/pacman/resources/cherry.png"));
        this.pallete.put(GameConstants.FRUIT1, new Image("file:src/pacman/resources/strawberry.png"));
        this.pallete.put(GameConstants.FRUIT2, new Image("file:src/pacman/resources/orange.png"));
        this.pallete.put(GameConstants.BLUEGHOST,   new Image("file:src/pacman/resources/blueghost.gif"));
        this.pallete.put(GameConstants.GHOSTGHOST,   new Image("file:src/pacman/resources/eyes.gif"));
        
        for (int i = 0; i < 4; i++)
            this.pacmanView[i] = new Image(String.format("file:src/pacman/resources/pacman%d.gif", i));
        
    }
    
    /**
     * Método que desenha a interface gráfica do jogo
     * @param map
     */
    public void update(Map map) {
        
        for (int i = 0; i < GameConstants.BOARD_VERTICAL; i++){
            
            for (int j = 0; j < GameConstants.BOARD_HORIZONTAL; j++){
                
                Node current = map.getNode(i,j);
                
                if (!current.getEntities().isEmpty()) {
                    if (current.getEntities().get(0).getId() == GameConstants.PACMAN)
                        this.cellViews[i][j].setImage(this.pacmanView[GameStatus.getPacmanDirection()]);
                    else
                        this.cellViews[i][j].setImage(this.pallete.get(current.getEntities().get(0).getId()));                    
                }                    
                else if (current.getConsumable() != null)
                    this.cellViews[i][j].setImage(this.pallete.get(current.getConsumable().getId()));
                else if (current.getId() == GameConstants.BLOCKED)
                    this.cellViews[i][j].setImage(this.pallete.get(current.getId()));   
                else
                    this.cellViews[i][j].setImage(null);
                                
            }
            
        }

    }
    
}
