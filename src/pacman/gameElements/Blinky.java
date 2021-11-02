package pacman.gameElements;

import java.util.ArrayList;

public class Blinky extends Ghost {
    
    Blinky(Node node) {
        
        // definir identificaçao e velocidade
        super(node, GameConstants.BLINKY, 0);
        
    }
    
    public void move() {

        ArrayList<Node> nodes = this.node.getNodes();
        Node nextNode = null;

        for (Node node : nodes) {

            if (nextNode == null)
                nextNode = node;
            else if (nextNode.getDistance("pacman") > node.getDistance("pacman") && node.getId() != GameConstants.BLOCKED) 
                nextNode = node;

        }

        this.node = nextNode;
        
    }
    
}
