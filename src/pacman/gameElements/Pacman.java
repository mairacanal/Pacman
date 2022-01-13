/**
 * @file Pacman.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.gameElements;

import java.util.ArrayList;
import pacman.engine.GameStatus;

/**
 * Classe que representa um elemento do jogo, o Pacman.
 */
public class Pacman extends Entity {
    
    /**
     * Construtor padrão da classe Pacman
     * @param currentNode Nó em que o Pacman nasce
     */
    public Pacman(Node currentNode) {
        
        super(currentNode, GameConstants.PACMAN, 80, GameConstants.LEFT);
        
    }
    
    /**
     * Método que inicializa o Pacman no nó adequado.
     */
    @Override
    public void born() {

        direction = GameConstants.LEFT;
        GameStatus.setPacmanDirection(direction);
        
        currentNode.removeEntity(this);
        initialNode.addEntity(this);
        currentNode = initialNode;

    }
    
    /**
     * Método que move o Pacman no tabuleiro na direção indicada pelo teclado.
     */
    @Override
    public void move() {
        
        moveCounter += speed;
        
        if (moveCounter >= 1000) {
            
            Node previousNode = currentNode;
            ArrayList<Node> nodes = currentNode.getNodes();        
            int newDirection = GameStatus.getPacmanDirection();

            if (nodes.get(newDirection).getId() != GameConstants.BLOCKED 
                    && nodes.get(newDirection).getId() != GameConstants.GATE) {            
                direction = newDirection;                        
            }

            if (nodes.get(direction).getId() != GameConstants.BLOCKED 
                    && nodes.get(direction).getId() != GameConstants.GATE) {

                currentNode = nodes.get(direction);
                previousNode.removeEntity(this);
                currentNode.addEntity(this);

            }
            
            moveCounter = 0;
            
        }
        
    }
    
    /**
     * Método que "mata" o Pacman.
     */
    @Override
    public void die() {
        
    }
    
}
