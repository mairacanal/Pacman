package pacman.gameElements;

import java.util.ArrayList;

public class Pinky extends Ghost {
    
    public Pinky(Node node) {
        
        // definir identificaçao e velocidade
        super(node, GameConstants.PINKY, 0);
        
    }    
    
    public void move() {

        ArrayList<Node> nodes = this.node.getNodes();
        Node nextNode = null;

        for (Node node : nodes) {

            if (nextNode == null)
                nextNode = node;
            else if (nextNode.getDistance("pacman") > node.getDistance("pacman") && node.isCanWalk()) 
                nextNode = node;

        }

        this.node.removeEntity(this);
        this.node = nextNode;
        this.node.addEntity(this);
        
    }
    
}