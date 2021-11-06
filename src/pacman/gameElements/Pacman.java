package pacman.gameElements;

import java.util.ArrayList;

public class Pacman extends Entity {
    
    private String direction;
    
    public Pacman(Node node) {
        
        // definir identificaçao e velocidade
        super(node, GameConstants.PACMAN, 0);
        
    }
    
    public void born() {

    }
    
    // TODO: se mover por meio de entrada de teclado
    public void move() {

        Node previousNode = node;
        ArrayList<Node> nodes = node.getNodes();

        while (!node.isCanWalk()) {

            node = nodes.get((int) (Math.random() * 3) + 1);

        }

        previousNode.removeEntity(this);
        node.addEntity(this);
        
    }
    
    public void die() {
        
    }
    
}
