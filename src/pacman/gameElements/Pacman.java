/**
 * @file Pacman.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.gameElements;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe que representa um elemento do jogo, o Pacman
 */
public class Pacman extends Entity {
    
    /**
     * TODO: definir a velocidade do Pacman
     * Construtor padrão da classe Pacman
     * @param currentNode Nó em que o Pacman nasce
     */
    public Pacman(Node currentNode) {
        
        super(currentNode, GameConstants.PACMAN, 0, GameConstants.LEFT);
        
    }
    
    /**
     * Método que inicializa o Pacman no nó adequado
     */
    public void born() {

        currentNode.removeEntity(this);
        initialNode.addEntity(this);
        currentNode = initialNode;

    }
    
    /**
     * TODO: mover-se por entrada de teclado
     * Método que move o Pacman no tabuleiro aleatoriamente
     */
    public void move() {

        Random rand = new Random();
        Node previousNode = currentNode;
        ArrayList<Node> currentNodes = currentNode.getNodes();
        ArrayList<Integer> id = new ArrayList<>();
        int newDirection;

        id.add(GameConstants.BLOCKED);
        id.add(GameConstants.GATE);

        do {

            newDirection = rand.nextInt(4);
            currentNode = currentNodes.get(newDirection);

        } while (!currentNode.notForbiddenId(id) || newDirection == GameConstants.oppositeDirection(direction));

        direction = newDirection;
        previousNode.removeEntity(this);
        currentNode.addEntity(this);
        
    }
    
    /**
     * TODO
     * Método que "mata" o Pacman
     */
    public void die() {
        
    }
    
}
