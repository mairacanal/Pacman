package pacman.gameElements;

import java.util.ArrayList;
import java.lang.Math;
public class Clyde extends Ghost {
    
    Clyde (Node node) {
        
        // definir identificaçao e velocidade
        super(node, GameConstants.CLYDE, 0);
        
    }
    
    public void move() {
        
        ArrayList<Node> nodes = node.getNodes();

        while (!node.isCanWalk()) {

            node = nodes.get((int) (Math.random() * 3) + 1);

        }

    }
    
}