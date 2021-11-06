package pacman.gameElements;

import java.util.ArrayList;
import java.lang.Math;
public class Clyde extends Ghost {
    
    Clyde (Node node) {
        
        // definir velocidade
        super(node, GameConstants.CLYDE, 0);
        
    }
    
    public void move() {
        
        Node previousNode = null;
        ArrayList<Node> nodes = node.getNodes();

        while (!node.isCanWalk()) {

            previousNode = node;
            node = nodes.get((int) (Math.random() * 3) + 1);

        }

        previousNode.removeEntity(this);
        node.addEntity(this);

    }
    
}