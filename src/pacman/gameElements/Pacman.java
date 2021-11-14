package pacman.gameElements;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */
public class Pacman extends Entity {
    
    public Pacman(Node currentNode) {
        
        // definir velocidade
        super(currentNode, GameConstants.PACMAN, 0, GameConstants.LEFT);
        
    }
    
    /**
     * 
     */
    public void born() {

        currentNode.removeEntity(this);
        initialNode.addEntity(this);
        currentNode = initialNode;

    }
    
    // TODO: se mover por meio de entrada de teclado
    /**
     * 
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
     * 
     */
    public void die() {
        
    }
    
}
