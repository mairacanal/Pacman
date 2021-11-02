package pacman.gameElements;

import java.util.ArrayList;
import java.lang.Math;

public class Inky extends Ghost {

    Inky(Node node) {
        
        // definir identificaçao e velocidade
        super(node, GameConstants.INKY, 0);
        
    }
    
    public void move() {

        ArrayList<Node> nodes = node.getNodes();

        while (!node.isCanWalk()) {

            node = nodes.get((int) (Math.random() * 3) + 1);

        }
        
    }
    
}
