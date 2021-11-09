package pacman.gameElements;

import java.util.ArrayList;
import java.util.Random;

public class Pacman extends Entity {
    
    public Pacman(Node node) {
        
        // definir identificaçao e velocidade
        super(node, GameConstants.PACMAN, 0, GameConstants.LEFT);
        
    }
    
    public void born() {

    }
    
    // TODO: se mover por meio de entrada de teclado
    public void move() {

        Random rand = new Random();
        Node previousNode = node;
        ArrayList<Node> nodes = node.getNodes();
        ArrayList<Integer> id = new ArrayList<>();
        int newDirection;

        id.add(GameConstants.BLOCKED);
        id.add(GameConstants.GATE);

        do {

            newDirection = rand.nextInt(4);
            node = nodes.get(newDirection);

        } while (!node.notForbiddenId(id) || newDirection == GameConstants.oppositeDirection(direction));

        direction = newDirection;
        previousNode.removeEntity(this);
        node.addEntity(this);
        
    }
    
    public void die() {
        
    }
    
}
