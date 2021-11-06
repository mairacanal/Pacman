package pacman.gameElements;

import java.util.ArrayList;
import java.lang.Math;

public class Inky extends Ghost {

    public Inky(Node node) {
        
        // definir identificaçao e velocidade
        super(node, GameConstants.INKY, 0);
        
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
